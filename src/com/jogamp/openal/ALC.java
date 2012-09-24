/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/procaddress/ProcAddressEmitter.java on Thu Jul 26 21:47:16 CEST 2012 ----! */

package com.jogamp.openal;

import java.io.UnsupportedEncodingException;
import java.util.*;
import com.jogamp.openal.*;
import jogamp.openal.*;
import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import java.nio.*;

public interface ALC extends ALCConstants{


  /** Entry point (through function pointer) to C language function: <br> <code> ALCboolean alcCaptureCloseDevice(ALCdevice *  device); </code>    */
  public boolean alcCaptureCloseDevice(ALCdevice device);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCdevice *  alcCaptureOpenDevice(const ALCchar *  devicename, ALCuint frequency, ALCenum format, ALCsizei buffersize); </code> 
      @param devicename a direct or array-backed {@link java.nio.ByteBuffer}   */
  public ALCdevice alcCaptureOpenDevice(ByteBuffer devicename, int frequency, int format, int buffersize);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCdevice *  alcCaptureOpenDevice(const ALCchar *  devicename, ALCuint frequency, ALCenum format, ALCsizei buffersize); </code>    */
  public ALCdevice alcCaptureOpenDevice(byte[] devicename, int devicename_offset, int frequency, int format, int buffersize);

  /** Entry point (through function pointer) to C language function: <br> <code> void alcCaptureSamples(ALCdevice *  device, ALCvoid *  buffer, ALCsizei samples); </code> 
      @param buffer a direct or array-backed {@link java.nio.Buffer}   */
  public void alcCaptureSamples(ALCdevice device, Buffer buffer, int samples);

  /** Entry point (through function pointer) to C language function: <br> <code> void alcCaptureStart(ALCdevice *  device); </code>    */
  public void alcCaptureStart(ALCdevice device);

  /** Entry point (through function pointer) to C language function: <br> <code> void alcCaptureStop(ALCdevice *  device); </code>    */
  public void alcCaptureStop(ALCdevice device);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCboolean alcCloseDevice(ALCdevice *  device); </code>    */
  public boolean alcCloseDevice(ALCdevice device);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCcontext *  alcCreateContext(ALCdevice *  device, const ALCint *  attrlist); </code> 
      @param attrlist a direct or array-backed {@link java.nio.IntBuffer}   */
  public ALCcontext alcCreateContext(ALCdevice device, IntBuffer attrlist);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCcontext *  alcCreateContext(ALCdevice *  device, const ALCint *  attrlist); </code>    */
  public ALCcontext alcCreateContext(ALCdevice device, int[] attrlist, int attrlist_offset);

  /** Entry point (through function pointer) to C language function: <br> <code> void alcDestroyContext(ALCcontext *  context); </code>    */
  public void alcDestroyContext(ALCcontext context);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCdevice *  alcGetContextsDevice(ALCcontext *  context); </code>    */
  public ALCdevice alcGetContextsDevice(ALCcontext context);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCcontext *  alcGetCurrentContext(ALCvoid); </code>    */
  public ALCcontext alcGetCurrentContext();

  /** Entry point (through function pointer) to C language function: <br> <code> ALCenum alcGetEnumValue(ALCdevice *  device, const ALCchar *  enumname); </code> 
      @param enumname a direct or array-backed {@link java.nio.ByteBuffer}   */
  public int alcGetEnumValue(ALCdevice device, ByteBuffer enumname);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCenum alcGetEnumValue(ALCdevice *  device, const ALCchar *  enumname); </code>    */
  public int alcGetEnumValue(ALCdevice device, byte[] enumname, int enumname_offset);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCenum alcGetError(ALCdevice *  device); </code>    */
  public int alcGetError(ALCdevice device);

  /** Entry point (through function pointer) to C language function: <br> <code> void alcGetIntegerv(ALCdevice *  device, ALCenum param, ALCsizei size, ALCint *  data); </code> 
      @param data a direct or array-backed {@link java.nio.IntBuffer}   */
  public void alcGetIntegerv(ALCdevice device, int param, int size, IntBuffer data);

  /** Entry point (through function pointer) to C language function: <br> <code> void alcGetIntegerv(ALCdevice *  device, ALCenum param, ALCsizei size, ALCint *  data); </code>    */
  public void alcGetIntegerv(ALCdevice device, int param, int size, int[] data, int data_offset);

  /** Entry point (through function pointer) to C language function: <br> <code> const ALCchar *  alcGetString(ALCdevice *  device, ALCenum param); </code>    */
  public String alcGetString(ALCdevice device, int param);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCboolean alcIsExtensionPresent(ALCdevice *  device, const ALCchar *  extname); </code>    */
  public boolean alcIsExtensionPresent(ALCdevice device, String extname);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCboolean alcMakeContextCurrent(ALCcontext *  context); </code>    */
  public boolean alcMakeContextCurrent(ALCcontext context);

  /** Entry point (through function pointer) to C language function: <br> <code> ALCdevice *  alcOpenDevice(const ALCchar *  devicename); </code>    */
  public ALCdevice alcOpenDevice(String devicename);

  /** Entry point (through function pointer) to C language function: <br> <code> void alcProcessContext(ALCcontext *  context); </code>    */
  public void alcProcessContext(ALCcontext context);

  /** Entry point (through function pointer) to C language function: <br> <code> void alcSuspendContext(ALCcontext *  context); </code>    */
  public void alcSuspendContext(ALCcontext context);


  // --- Begin CustomJavaCode .cfg declarations
  /** Fetches the names of the available ALC device specifiers.
      Equivalent to the C call alcGetString(NULL, ALC_DEVICE_SPECIFIER). */
  public java.lang.String[] alcGetDeviceSpecifiers();
  
  /** Fetches the names of the available ALC capture device specifiers.
      Equivalent to the C call alcGetString(NULL, ALC_CAPTURE_DEVICE_SPECIFIER). */
  public java.lang.String[] alcGetCaptureDeviceSpecifiers();
  // ---- End CustomJavaCode .cfg declarations

} // end of class ALC
