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
 * 
 * Sun gratefully acknowledges that this software was originally authored
 * and developed by Kenneth Bradley Russell and Christopher John Kline.
 */

package jogamp.newt;

import com.jogamp.common.util.PropertyAccess;

/** Helper routines for logging and debugging. */

public class Debug extends PropertyAccess {
  // Some common properties
  private static final boolean verbose;
  private static final boolean debugAll;
  
  static {
    PropertyAccess.addTrustedPrefix("newt.", Debug.class);
    verbose = isPropertyDefined("newt.verbose", true);
    debugAll = isPropertyDefined("newt.debug", true);
    if (verbose) {
       Package p = Package.getPackage("com.jogamp.newt");
       System.err.println("NEWT specification version " + p.getSpecificationVersion());
       System.err.println("NEWT implementation version " + p.getImplementationVersion());
       System.err.println("NEWT implementation vendor " + p.getImplementationVendor());
    }
  }

  public static final boolean isPropertyDefined(final String property, final boolean jnlpAlias) {
    return PropertyAccess.isPropertyDefined(property, jnlpAlias, null);
  }
    
  public static final int getIntProperty(final String property, final boolean jnlpAlias, int defaultValue) {
      return PropertyAccess.getIntProperty(property, jnlpAlias, null, defaultValue);
  }
  
  public static final boolean getBooleanProperty(final String property, final boolean jnlpAlias) {
      return PropertyAccess.getBooleanProperty(property, jnlpAlias, null);
  }
  
  public static boolean verbose() {
    return verbose;
  }

  public static boolean debugAll() {
    return debugAll;
  }

  public static boolean debug(String subcomponent) {
    return debugAll() || isPropertyDefined("newt.debug." + subcomponent, true);
  }
}
