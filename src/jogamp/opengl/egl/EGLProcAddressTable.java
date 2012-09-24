/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/opengl/GLEmitter.java on Fri Aug 03 06:28:30 CEST 2012 ----! */

package jogamp.opengl.egl;

import java.util.*;
import javax.media.opengl.*;
import javax.media.opengl.fixedfunc.*;
import jogamp.opengl.*;
import com.jogamp.gluegen.runtime.opengl.GLProcAddressResolver;
import com.jogamp.gluegen.runtime.ProcAddressTable;

/**
 * This table is a cache of pointers to the dynamically-linkable C library.
 * @see ProcAddressTable
 */
public class EGLProcAddressTable extends ProcAddressTable {


  public EGLProcAddressTable(){ super(); }

  public EGLProcAddressTable(com.jogamp.gluegen.runtime.FunctionAddressResolver resolver){ super(resolver); }

  public long _addressof_eglBindAPI;
  public long _addressof_eglBindTexImage;
  public long _addressof_eglChooseConfig;
  public long _addressof_eglCopyBuffers;
  public long _addressof_eglCreateContext;
  public long _addressof_eglCreatePbufferFromClientBuffer;
  public long _addressof_eglCreatePbufferSurface;
  public long _addressof_eglCreatePixmapSurface;
  public long _addressof_eglCreateWindowSurface;
  public long _addressof_eglDestroyContext;
  public long _addressof_eglDestroySurface;
  public long _addressof_eglGetConfigAttrib;
  public long _addressof_eglGetConfigs;
  public long _addressof_eglGetCurrentContext;
  public long _addressof_eglGetCurrentDisplay;
  public long _addressof_eglGetCurrentSurface;
  public long _addressof_eglGetDisplay;
  public long _addressof_eglGetError;
  public long _addressof_eglGetProcAddress;
  public long _addressof_eglInitialize;
  public long _addressof_eglMakeCurrent;
  public long _addressof_eglQueryAPI;
  public long _addressof_eglQueryContext;
  public long _addressof_eglQueryString;
  public long _addressof_eglQuerySurface;
  public long _addressof_eglReleaseTexImage;
  public long _addressof_eglReleaseThread;
  public long _addressof_eglSurfaceAttrib;
  public long _addressof_eglSwapBuffers;
  public long _addressof_eglSwapInterval;
  public long _addressof_eglTerminate;
  public long _addressof_eglWaitClient;
  public long _addressof_eglWaitGL;
  public long _addressof_eglWaitNative;
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
} // end of class EGLProcAddressTable
