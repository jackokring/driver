/*
 * Copyright (c) 2003 Sun Microsystems, Inc. All Rights Reserved.
 * Copyright (c) 2010 JogAmp Community. All rights reserved.
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
 * 
 * Sun gratefully acknowledges that this software was originally authored
 * and developed by Kenneth Bradley Russell and Christopher John Kline.
 */
package com.jogamp.gluegen.cgram.types;

import java.util.*;

/** Describes a function type, used to model both function
declarations and (via PointerType) function pointers. */
public class FunctionType extends Type implements Cloneable {

    private Type returnType;
    private ArrayList<Type> argumentTypes;
    private ArrayList<String> argumentNames;

    public FunctionType(String name, SizeThunk size, Type returnType, int cvAttributes) {
        super(name, size, cvAttributes);
        this.returnType = returnType;
    }

    public Object clone() {
        FunctionType n = (FunctionType) super.clone();
        if(null!=this.argumentTypes) {
            n.argumentTypes = (ArrayList) this.argumentTypes.clone();
        }
        if(null!=this.argumentNames) {
            n.argumentNames = (ArrayList) this.argumentNames.clone();
        }
        return n;
    }

    @Override
    public boolean equals(Object arg) {
        if (arg == this) {
            return true;
        }
        if (arg == null || (!(arg instanceof FunctionType))) {
            return false;
        }
        FunctionType t = (FunctionType) arg;
        return (super.equals(arg)
                && returnType.equals(t.returnType)
                && listsEqual(argumentTypes, t.argumentTypes));
    }

    @Override
    public FunctionType asFunction() {
        return this;
    }

    /** Returns the return type of this function. */
    public Type getReturnType() {
        return returnType;
    }

    public int getNumArguments() {
        return ((argumentTypes == null) ? 0 : argumentTypes.size());
    }

    /** Returns the name of the <i>i</i>th argument. May return null if
    no argument names were available during parsing. */
    public String getArgumentName(int i) {
        return argumentNames.get(i);
    }

    /** Returns the type of the <i>i</i>th argument. */
    public Type getArgumentType(int i) {
        return argumentTypes.get(i);
    }

    /**
     * Add an argument's name and type. Use null for unknown argument names.
     */
    public void addArgument(Type argumentType, String argumentName) {
        if (argumentTypes == null) {
            argumentTypes = new ArrayList<Type>();
            argumentNames = new ArrayList<String>();
        }
        argumentTypes.add(argumentType);
        argumentNames.add(argumentName);
    }

    public void setArgumentName(int i, String name) {
        argumentNames.set(i, name);
    }

    @Override
    public String toString() {
        return toString(null);
    }

    public String toString(String functionName) {
        return toString(functionName, false);
    }

    public String toString(String functionName, boolean emitNativeTag) {
        return toString(functionName, null, emitNativeTag, false);
    }

    String toString(String functionName, String callingConvention, boolean emitNativeTag, boolean isPointer) {
        StringBuilder res = new StringBuilder();
        res.append(getReturnType());
        res.append(" ");
        if (isPointer) {
            res.append("(");
            if (callingConvention != null) {
                res.append(callingConvention);
            }
            res.append("*");
        }
        if (functionName != null) {
            if (emitNativeTag) {
                // Emit @native tag for javadoc purposes
                res.append("{@native ");
            }
            res.append(functionName);
            if (emitNativeTag) {
                res.append("}");
            }
        }
        if (isPointer) {
            res.append(")");
        }
        res.append("(");
        int n = getNumArguments();
        for (int i = 0; i < n; i++) {
            Type t = getArgumentType(i);
            if (t.isFunctionPointer()) {
                FunctionType ft = t.asPointer().getTargetType().asFunction();
                res.append(ft.toString(getArgumentName(i), callingConvention, false, true));
            } else if (t.isArray()) {
                res.append(t.asArray().toString(getArgumentName(i)));
            } else {
                res.append(t);
                String argumentName = getArgumentName(i);
                if (argumentName != null) {
                    res.append(" ");
                    res.append(argumentName);
                }
            }
            if (i < n - 1) {
                res.append(", ");
            }
        }
        res.append(")");
        if (!isPointer) {
            res.append(";");
        }
        return res.toString();
    }

    @Override
    public void visit(TypeVisitor arg) {
        super.visit(arg);
        returnType.visit(arg);
        int n = getNumArguments();
        for (int i = 0; i < n; i++) {
            getArgumentType(i).visit(arg);
        }
    }

    Type newCVVariant(int cvAttributes) {
        // Functions don't have const/volatile attributes
        return this;
    }
}
