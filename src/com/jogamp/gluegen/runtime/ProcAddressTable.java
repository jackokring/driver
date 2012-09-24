/*
 * Copyright (c) 2003-2005 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN
 * MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR
 * ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR
 * DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE
 * DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY,
 * ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF
 * SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed or intended for use
 * in the design, construction, operation or maintenance of any nuclear
 * facility.
 */
package com.jogamp.gluegen.runtime;

import com.jogamp.common.os.DynamicLookupHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Superclass for all generated ProcAddressTables.
 *
 * A ProcAddressTable is a cache of pointers to the dynamically-linkable C
 * functions this autogenerated Java binding has exposed. Some
 * libraries such as OpenGL, OpenAL and others define function pointer
 * signatures rather than statically linkable entry points for the
 * purposes of being able to query at run-time whether a particular
 * extension is available. This table acts as a cache of these
 * function pointers. Each function pointer is typically looked up at
 * run-time by a platform-dependent mechanism such as dlsym(),
 * wgl/glXGetProcAddress(), or alGetProcAddress(). If the field containing the function
 * pointer is 0, the function is considered to be unavailable and can
 * not be called.
 *
 * @author Kenneth Russel
 * @author Michael Bien
 * @author Sven Gothel
 *
 * @see FunctionAddressResolver
 * @see DynamicLookupHelper
 */
public abstract class ProcAddressTable {

    public static final String PROCADDRESS_VAR_PREFIX = "_addressof_";

    protected static boolean DEBUG;
    protected static String DEBUG_PREFIX;
    protected static int debugNum;

    private final FunctionAddressResolver resolver;

    static {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            public Object run() {
                DEBUG = (System.getProperty("jogamp.debug.ProcAddressHelper") != null);
                if (DEBUG) {
                    DEBUG_PREFIX = System.getProperty("jogamp.debug.ProcAddressHelper.prefix");
                }
                return null;
            }
        });
    }

    public ProcAddressTable() {
        this(new One2OneResolver());
    }

    public ProcAddressTable(FunctionAddressResolver resolver) {
        this.resolver = resolver;
    }


    /**
     * Resets the complete table.
     */
    public void reset(DynamicLookupHelper lookup) throws RuntimeException {

        if(null==lookup) {
            throw new RuntimeException("Passed null DynamicLookupHelper");
        }

        PrintStream dout = getDebugOutStream();

        if (DEBUG) {
            dout.println(getClass().getName()+".reset()");
        }

        Field[] fields = getClass().getFields();
        for (int i = 0; i < fields.length; ++i) {
            String fieldName = fields[i].getName();
            if (isAddressField(fieldName)) {
                String funcName = fieldToFunctionName(fieldName);
                setEntry(fields[i], funcName, lookup);
            }
        }

        if (DEBUG) {
            dout.flush();
            if (DEBUG_PREFIX != null) {
                dout.close();
            }
        }
    }

    /**
     * Initializes the mapping for a single function.
     * @throws IllegalArgumentException if this function is not in this table.
     */
    public void initEntry(String name, DynamicLookupHelper lookup) {
        Field field = fieldForFunction(name);
        setEntry(field, name, lookup);
    }

    protected void setEntry(Field addressField, String funcName, DynamicLookupHelper lookup) {
        try {
            assert (addressField.getType() == Long.TYPE);
            long newProcAddress = resolver.resolve(funcName, lookup);
            // set the current value of the proc address variable in the table object
            addressField.setLong(this, newProcAddress);
            if (DEBUG) {
                getDebugOutStream().println("  " + addressField.getName() + " -> 0x" + Long.toHexString(newProcAddress));
            }
        } catch (Exception e) {
            throw new RuntimeException("Can not get proc address for method \""
                    + funcName + "\": Couldn't set value of field \"" + addressField, e);
        }
    }

    protected String fieldToFunctionName(String addressFieldName) {
        return addressFieldName.substring(PROCADDRESS_VAR_PREFIX.length());
    }

    protected Field fieldForFunction(String name) {
        try {
            return getClass().getField(PROCADDRESS_VAR_PREFIX + name);
        } catch (NoSuchFieldException ex) {
            throw new IllegalArgumentException(getClass().getName() +" has no entry for the function '"+name+"'.", ex);
        }
    }

    protected boolean isAddressField(String fieldName) {
        return fieldName.startsWith(PROCADDRESS_VAR_PREFIX);
    }

    protected static PrintStream getDebugOutStream() {
        PrintStream out = null;
        if (DEBUG) {
            if (DEBUG_PREFIX != null) {
                try {
                    out = new PrintStream(new BufferedOutputStream(new FileOutputStream(DEBUG_PREFIX + File.separatorChar
                            + "procaddresstable-" + (++debugNum) + ".txt")));
                } catch (IOException e) {
                    e.printStackTrace();
                    out = System.err;
                }
            } else {
                out = System.err;
            }
        }
        return out;
    }

    /**
     * Returns this table as map with the function name as key and the address as value.
     */
    public Map<String, Long> toMap() {
        
        SortedMap<String, Long> map = new TreeMap<String, Long>();

        Field[] fields = getClass().getFields();
        try {
            for (int i = 0; i < fields.length; ++i) {
                String addressFieldName = fields[i].getName();
                if (isAddressField(addressFieldName)) {
                    map.put(fieldToFunctionName(addressFieldName), (Long)fields[i].get(this));
                }
            }
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        
        return map;
    }

    /**
     * Returns true only if non null function pointer to this function exists.
     */
    public boolean isFunctionAvailable(String functionName) {
        try{
            return getAddressFor(functionName) != 0;
        }catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * This is a convenience method to get (by name) the native function
     * pointer for a given function. It lets you avoid having to
     * manually compute the &quot;{@link #PROCADDRESS_VAR_PREFIX} + &lt;functionName&gt;&quot;
     * member variable name and look it up via reflection.
     *
     * @throws IllegalArgumentException if this function is not in this table.
     */
    public long getAddressFor(String functionName) {
        Field addressField = fieldForFunction(functionName);
        try {
            return addressField.getLong(this);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Returns all functions pointing to null.
     */
    public Set<String> getNullPointerFunctions() {
        Map<String, Long> table = toMap();
        Set<String> nullPointers = new LinkedHashSet<String>();
        for (Iterator<Map.Entry<String, Long>> it = table.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Long> entry = it.next();
            long address = entry.getValue().longValue();
            if(address == 0) {
                nullPointers.add(entry.getKey());
            }
        }
        return nullPointers;
    }

//    @Override
    public String toString() {
        return getClass().getName()+""+toMap();
    }


    private static class One2OneResolver implements FunctionAddressResolver {
        public long resolve(String name, DynamicLookupHelper lookup) {
            return lookup.dynamicLookupFunction(name);
        }
    }


}
