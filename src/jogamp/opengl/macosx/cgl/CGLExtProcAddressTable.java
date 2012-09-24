/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/opengl/GLEmitter.java on Fri Aug 03 06:29:07 CEST 2012 ----! */

package jogamp.opengl.macosx.cgl;

import java.util.*;
import javax.media.opengl.*;
import javax.media.opengl.fixedfunc.*;
import jogamp.opengl.*;
import com.jogamp.gluegen.runtime.ProcAddressTable;

/**
 * This table is a cache of pointers to the dynamically-linkable C library.
 * @see ProcAddressTable
 */
public class CGLExtProcAddressTable extends ProcAddressTable {

  public long _addressof_glMapBuffer;

  public CGLExtProcAddressTable(){ super(); }

  public CGLExtProcAddressTable(com.jogamp.gluegen.runtime.FunctionAddressResolver resolver){ super(resolver); }

  /**
   * This is a convenience method to get (by name) the native function
   * pointer for a given function. It lets you avoid having to
   * manually compute the &quot;_addressof_ + 
   * &lt;functionName&gt;&quot; member variable name and look it up via
   * reflection; it also will throw an exception if you try to get the
   * address of an unknown function, or one that is statically linked
   * and therefore does not have a function pointer in this table.
   *
   * @throws RuntimeException if the function pointer was not found in
   *   this table, either because the function was unknown or because
   *   it was statically linked.
   */
  public long getAddressFor(String functionNameUsr) {
    String functionNameBase = com.jogamp.gluegen.runtime.opengl.GLNameResolver.normalizeVEN(com.jogamp.gluegen.runtime.opengl.GLNameResolver.normalizeARB(functionNameUsr, true), true);
    String addressFieldNameBase = PROCADDRESS_VAR_PREFIX + functionNameBase;
    java.lang.reflect.Field addressField = null;
    int  funcNamePermNum = com.jogamp.gluegen.runtime.opengl.GLNameResolver.getFuncNamePermutationNumber(functionNameBase);
    for(int i = 0; null==addressField && i < funcNamePermNum; i++) {
        String addressFieldName = com.jogamp.gluegen.runtime.opengl.GLNameResolver.getFuncNamePermutation(addressFieldNameBase, i);
        try {
          addressField = getClass().getField(addressFieldName);
        } catch (Exception e) { }
    }

    if(null==addressField) {
      // The user is calling a bogus function or one which is not
      // runtime linked
      throw new RuntimeException(
          "WARNING: Address field query failed for \"" + functionNameBase + "\"/\"" + functionNameUsr +
          "\"; it's either statically linked or address field is not a known " +
          "function");
    } 
    try {
      return addressField.getLong(this);
    } catch (Exception e) {
      throw new RuntimeException(
          "WARNING: Address query failed for \"" + functionNameBase + "\"/\"" + functionNameUsr +
          "\"; it's either statically linked or is not a known " +
          "function", e);
    }
  }
} // end of class CGLExtProcAddressTable
