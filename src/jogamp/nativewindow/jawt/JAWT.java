/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Fri Aug 03 06:26:19 CEST 2012 ----! */


package jogamp.nativewindow.jawt;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDescriptionRuntime;

import java.security.*;
import jogamp.nativewindow.jawt.*;
import com.jogamp.common.os.Platform;
import com.jogamp.common.util.VersionNumber;

public class JAWT {

  StructAccessor accessor;

  private static final int mdIdx = MachineDescriptionRuntime.getStatic().ordinal();

  private static final int[] JAWT_size = new int[] { 24 /* ARMle_EABI */, 24 /* X86_32_UNIX */, 48 /* X86_64_UNIX */, 24 /* X86_32_MACOS */, 24 /* X86_32_WINDOWS */, 48 /* X86_64_WINDOWS */  };
  private static final int[] version_offset = new int[] { 0 /* ARMle_EABI */, 0 /* X86_32_UNIX */, 0 /* X86_64_UNIX */, 0 /* X86_32_MACOS */, 0 /* X86_32_WINDOWS */, 0 /* X86_64_WINDOWS */ };

  public static int size() {
    return JAWT_size[mdIdx];
  }

  public static JAWT create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static JAWT create(java.nio.ByteBuffer buf) {
      return new JAWT(buf);
  }

  JAWT(java.nio.ByteBuffer buf) {
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  public JAWT setVersion(int val) {
    accessor.setIntAt(version_offset[mdIdx], val, MachineDescriptionRuntime.getStatic().md.intSizeInBytes());
    return this;
  }

  public int getVersion() {
    return accessor.getIntAt(version_offset[mdIdx], MachineDescriptionRuntime.getStatic().md.intSizeInBytes());
  }

  /** Interface to C language function: <br> <code> JAWT_DrawingSurface *  GetDrawingSurface(JNIEnv *  env, jobject target); </code>    */
  public JAWT_DrawingSurface GetDrawingSurface(Object target)  {

    final ByteBuffer _res;
    _res = GetDrawingSurface0(getBuffer(), target);
    if (_res == null) return null;
    return JAWT_DrawingSurface.create(Buffers.nativeOrder(_res));
  }
  /** Entry point to C language function: <code> JAWT_DrawingSurface *  GetDrawingSurface(JNIEnv *  env, jobject target); </code>    */
  private native ByteBuffer GetDrawingSurface0(ByteBuffer jthis0, Object target);

  /** Interface to C language function: <br> <code> void FreeDrawingSurface(JAWT_DrawingSurface *  ds); </code>    */
  public void FreeDrawingSurface(JAWT_DrawingSurface ds)  {

        FreeDrawingSurface0(getBuffer(), ((ds == null) ? null : ds.getBuffer()));
  }
  /** Entry point to C language function: <code> void FreeDrawingSurface(JAWT_DrawingSurface *  ds); </code>    */
  private native void FreeDrawingSurface0(ByteBuffer jthis0, ByteBuffer ds);

  /** Interface to C language function: <br> <code> void Lock(JNIEnv *  env); </code>    */
  public void Lock()  {

        Lock0(getBuffer());
  }
  /** Entry point to C language function: <code> void Lock(JNIEnv *  env); </code>    */
  private native void Lock0(ByteBuffer jthis0);

  /** Interface to C language function: <br> <code> void Unlock(JNIEnv *  env); </code>    */
  public void Unlock()  {

        Unlock0(getBuffer());
  }
  /** Entry point to C language function: <code> void Unlock(JNIEnv *  env); </code>    */
  private native void Unlock0(ByteBuffer jthis0);

  // --- Begin CustomJavaCode .cfg declarations
  private int jawt_version_cached = 0;
  
  public final int getCachedVersion() {
      return jawt_version_cached;
  }
  
  protected static boolean getJAWT(final JAWT jawt, final int jawt_version_flags) {
      JAWTUtil.initSingleton();
      // Workaround for 4845371.
      // Make sure the first reference to the JNI GetDirectBufferAddress is done
      // from a privileged context so the VM's internal class lookups will succeed.
      return AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
          public Boolean run() {
            jawt.setVersion(jawt_version_flags);
            if (JAWTFactory.JAWT_GetAWT(jawt)) {
              jawt.jawt_version_cached = jawt.getVersion();
              return new Boolean(true);
            }
            jawt.jawt_version_cached = 0;
            return new Boolean(false);
          }
        }).booleanValue();
  }
  // ---- End CustomJavaCode .cfg declarations
}
