/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Fri Aug 03 06:26:16 CEST 2012 ----! */


package jogamp.nativewindow.windows;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDescriptionRuntime;

import javax.media.nativewindow.util.Point;
import javax.media.nativewindow.NativeWindowException;
import jogamp.nativewindow.NWJNILibLoader;
import jogamp.nativewindow.Debug;

public class PIXELFORMATDESCRIPTOR {

  StructAccessor accessor;

  private static final int mdIdx = MachineDescriptionRuntime.getStatic().ordinal();

  private static final int[] PIXELFORMATDESCRIPTOR_size = new int[] { 40 /* ARMle_EABI */, 40 /* X86_32_UNIX */, 40 /* X86_64_UNIX */, 40 /* X86_32_MACOS */, 40 /* X86_32_WINDOWS */, 40 /* X86_64_WINDOWS */  };
  private static final int[] nSize_offset = new int[] { 0 /* ARMle_EABI */, 0 /* X86_32_UNIX */, 0 /* X86_64_UNIX */, 0 /* X86_32_MACOS */, 0 /* X86_32_WINDOWS */, 0 /* X86_64_WINDOWS */ };
  private static final int[] nVersion_offset = new int[] { 2 /* ARMle_EABI */, 2 /* X86_32_UNIX */, 2 /* X86_64_UNIX */, 2 /* X86_32_MACOS */, 2 /* X86_32_WINDOWS */, 2 /* X86_64_WINDOWS */ };
  private static final int[] dwFlags_offset = new int[] { 4 /* ARMle_EABI */, 4 /* X86_32_UNIX */, 4 /* X86_64_UNIX */, 4 /* X86_32_MACOS */, 4 /* X86_32_WINDOWS */, 4 /* X86_64_WINDOWS */ };
  private static final int[] iPixelType_offset = new int[] { 8 /* ARMle_EABI */, 8 /* X86_32_UNIX */, 8 /* X86_64_UNIX */, 8 /* X86_32_MACOS */, 8 /* X86_32_WINDOWS */, 8 /* X86_64_WINDOWS */ };
  private static final int[] cColorBits_offset = new int[] { 9 /* ARMle_EABI */, 9 /* X86_32_UNIX */, 9 /* X86_64_UNIX */, 9 /* X86_32_MACOS */, 9 /* X86_32_WINDOWS */, 9 /* X86_64_WINDOWS */ };
  private static final int[] cRedBits_offset = new int[] { 10 /* ARMle_EABI */, 10 /* X86_32_UNIX */, 10 /* X86_64_UNIX */, 10 /* X86_32_MACOS */, 10 /* X86_32_WINDOWS */, 10 /* X86_64_WINDOWS */ };
  private static final int[] cRedShift_offset = new int[] { 11 /* ARMle_EABI */, 11 /* X86_32_UNIX */, 11 /* X86_64_UNIX */, 11 /* X86_32_MACOS */, 11 /* X86_32_WINDOWS */, 11 /* X86_64_WINDOWS */ };
  private static final int[] cGreenBits_offset = new int[] { 12 /* ARMle_EABI */, 12 /* X86_32_UNIX */, 12 /* X86_64_UNIX */, 12 /* X86_32_MACOS */, 12 /* X86_32_WINDOWS */, 12 /* X86_64_WINDOWS */ };
  private static final int[] cGreenShift_offset = new int[] { 13 /* ARMle_EABI */, 13 /* X86_32_UNIX */, 13 /* X86_64_UNIX */, 13 /* X86_32_MACOS */, 13 /* X86_32_WINDOWS */, 13 /* X86_64_WINDOWS */ };
  private static final int[] cBlueBits_offset = new int[] { 14 /* ARMle_EABI */, 14 /* X86_32_UNIX */, 14 /* X86_64_UNIX */, 14 /* X86_32_MACOS */, 14 /* X86_32_WINDOWS */, 14 /* X86_64_WINDOWS */ };
  private static final int[] cBlueShift_offset = new int[] { 15 /* ARMle_EABI */, 15 /* X86_32_UNIX */, 15 /* X86_64_UNIX */, 15 /* X86_32_MACOS */, 15 /* X86_32_WINDOWS */, 15 /* X86_64_WINDOWS */ };
  private static final int[] cAlphaBits_offset = new int[] { 16 /* ARMle_EABI */, 16 /* X86_32_UNIX */, 16 /* X86_64_UNIX */, 16 /* X86_32_MACOS */, 16 /* X86_32_WINDOWS */, 16 /* X86_64_WINDOWS */ };
  private static final int[] cAlphaShift_offset = new int[] { 17 /* ARMle_EABI */, 17 /* X86_32_UNIX */, 17 /* X86_64_UNIX */, 17 /* X86_32_MACOS */, 17 /* X86_32_WINDOWS */, 17 /* X86_64_WINDOWS */ };
  private static final int[] cAccumBits_offset = new int[] { 18 /* ARMle_EABI */, 18 /* X86_32_UNIX */, 18 /* X86_64_UNIX */, 18 /* X86_32_MACOS */, 18 /* X86_32_WINDOWS */, 18 /* X86_64_WINDOWS */ };
  private static final int[] cAccumRedBits_offset = new int[] { 19 /* ARMle_EABI */, 19 /* X86_32_UNIX */, 19 /* X86_64_UNIX */, 19 /* X86_32_MACOS */, 19 /* X86_32_WINDOWS */, 19 /* X86_64_WINDOWS */ };
  private static final int[] cAccumGreenBits_offset = new int[] { 20 /* ARMle_EABI */, 20 /* X86_32_UNIX */, 20 /* X86_64_UNIX */, 20 /* X86_32_MACOS */, 20 /* X86_32_WINDOWS */, 20 /* X86_64_WINDOWS */ };
  private static final int[] cAccumBlueBits_offset = new int[] { 21 /* ARMle_EABI */, 21 /* X86_32_UNIX */, 21 /* X86_64_UNIX */, 21 /* X86_32_MACOS */, 21 /* X86_32_WINDOWS */, 21 /* X86_64_WINDOWS */ };
  private static final int[] cAccumAlphaBits_offset = new int[] { 22 /* ARMle_EABI */, 22 /* X86_32_UNIX */, 22 /* X86_64_UNIX */, 22 /* X86_32_MACOS */, 22 /* X86_32_WINDOWS */, 22 /* X86_64_WINDOWS */ };
  private static final int[] cDepthBits_offset = new int[] { 23 /* ARMle_EABI */, 23 /* X86_32_UNIX */, 23 /* X86_64_UNIX */, 23 /* X86_32_MACOS */, 23 /* X86_32_WINDOWS */, 23 /* X86_64_WINDOWS */ };
  private static final int[] cStencilBits_offset = new int[] { 24 /* ARMle_EABI */, 24 /* X86_32_UNIX */, 24 /* X86_64_UNIX */, 24 /* X86_32_MACOS */, 24 /* X86_32_WINDOWS */, 24 /* X86_64_WINDOWS */ };
  private static final int[] cAuxBuffers_offset = new int[] { 25 /* ARMle_EABI */, 25 /* X86_32_UNIX */, 25 /* X86_64_UNIX */, 25 /* X86_32_MACOS */, 25 /* X86_32_WINDOWS */, 25 /* X86_64_WINDOWS */ };
  private static final int[] iLayerType_offset = new int[] { 26 /* ARMle_EABI */, 26 /* X86_32_UNIX */, 26 /* X86_64_UNIX */, 26 /* X86_32_MACOS */, 26 /* X86_32_WINDOWS */, 26 /* X86_64_WINDOWS */ };
  private static final int[] bReserved_offset = new int[] { 27 /* ARMle_EABI */, 27 /* X86_32_UNIX */, 27 /* X86_64_UNIX */, 27 /* X86_32_MACOS */, 27 /* X86_32_WINDOWS */, 27 /* X86_64_WINDOWS */ };
  private static final int[] dwLayerMask_offset = new int[] { 28 /* ARMle_EABI */, 28 /* X86_32_UNIX */, 28 /* X86_64_UNIX */, 28 /* X86_32_MACOS */, 28 /* X86_32_WINDOWS */, 28 /* X86_64_WINDOWS */ };
  private static final int[] dwVisibleMask_offset = new int[] { 32 /* ARMle_EABI */, 32 /* X86_32_UNIX */, 32 /* X86_64_UNIX */, 32 /* X86_32_MACOS */, 32 /* X86_32_WINDOWS */, 32 /* X86_64_WINDOWS */ };
  private static final int[] dwDamageMask_offset = new int[] { 36 /* ARMle_EABI */, 36 /* X86_32_UNIX */, 36 /* X86_64_UNIX */, 36 /* X86_32_MACOS */, 36 /* X86_32_WINDOWS */, 36 /* X86_64_WINDOWS */ };

  public static int size() {
    return PIXELFORMATDESCRIPTOR_size[mdIdx];
  }

  public static PIXELFORMATDESCRIPTOR create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static PIXELFORMATDESCRIPTOR create(java.nio.ByteBuffer buf) {
      return new PIXELFORMATDESCRIPTOR(buf);
  }

  PIXELFORMATDESCRIPTOR(java.nio.ByteBuffer buf) {
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  public PIXELFORMATDESCRIPTOR setNSize(short val) {
    accessor.setShortAt(nSize_offset[mdIdx], val);
    return this;
  }

  public short getNSize() {
    return accessor.getShortAt(nSize_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setNVersion(short val) {
    accessor.setShortAt(nVersion_offset[mdIdx], val);
    return this;
  }

  public short getNVersion() {
    return accessor.getShortAt(nVersion_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setDwFlags(int val) {
    accessor.setIntAt(dwFlags_offset[mdIdx], val);
    return this;
  }

  public int getDwFlags() {
    return accessor.getIntAt(dwFlags_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setIPixelType(byte val) {
    accessor.setByteAt(iPixelType_offset[mdIdx], val);
    return this;
  }

  public byte getIPixelType() {
    return accessor.getByteAt(iPixelType_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCColorBits(byte val) {
    accessor.setByteAt(cColorBits_offset[mdIdx], val);
    return this;
  }

  public byte getCColorBits() {
    return accessor.getByteAt(cColorBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCRedBits(byte val) {
    accessor.setByteAt(cRedBits_offset[mdIdx], val);
    return this;
  }

  public byte getCRedBits() {
    return accessor.getByteAt(cRedBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCRedShift(byte val) {
    accessor.setByteAt(cRedShift_offset[mdIdx], val);
    return this;
  }

  public byte getCRedShift() {
    return accessor.getByteAt(cRedShift_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCGreenBits(byte val) {
    accessor.setByteAt(cGreenBits_offset[mdIdx], val);
    return this;
  }

  public byte getCGreenBits() {
    return accessor.getByteAt(cGreenBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCGreenShift(byte val) {
    accessor.setByteAt(cGreenShift_offset[mdIdx], val);
    return this;
  }

  public byte getCGreenShift() {
    return accessor.getByteAt(cGreenShift_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCBlueBits(byte val) {
    accessor.setByteAt(cBlueBits_offset[mdIdx], val);
    return this;
  }

  public byte getCBlueBits() {
    return accessor.getByteAt(cBlueBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCBlueShift(byte val) {
    accessor.setByteAt(cBlueShift_offset[mdIdx], val);
    return this;
  }

  public byte getCBlueShift() {
    return accessor.getByteAt(cBlueShift_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCAlphaBits(byte val) {
    accessor.setByteAt(cAlphaBits_offset[mdIdx], val);
    return this;
  }

  public byte getCAlphaBits() {
    return accessor.getByteAt(cAlphaBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCAlphaShift(byte val) {
    accessor.setByteAt(cAlphaShift_offset[mdIdx], val);
    return this;
  }

  public byte getCAlphaShift() {
    return accessor.getByteAt(cAlphaShift_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCAccumBits(byte val) {
    accessor.setByteAt(cAccumBits_offset[mdIdx], val);
    return this;
  }

  public byte getCAccumBits() {
    return accessor.getByteAt(cAccumBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCAccumRedBits(byte val) {
    accessor.setByteAt(cAccumRedBits_offset[mdIdx], val);
    return this;
  }

  public byte getCAccumRedBits() {
    return accessor.getByteAt(cAccumRedBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCAccumGreenBits(byte val) {
    accessor.setByteAt(cAccumGreenBits_offset[mdIdx], val);
    return this;
  }

  public byte getCAccumGreenBits() {
    return accessor.getByteAt(cAccumGreenBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCAccumBlueBits(byte val) {
    accessor.setByteAt(cAccumBlueBits_offset[mdIdx], val);
    return this;
  }

  public byte getCAccumBlueBits() {
    return accessor.getByteAt(cAccumBlueBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCAccumAlphaBits(byte val) {
    accessor.setByteAt(cAccumAlphaBits_offset[mdIdx], val);
    return this;
  }

  public byte getCAccumAlphaBits() {
    return accessor.getByteAt(cAccumAlphaBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCDepthBits(byte val) {
    accessor.setByteAt(cDepthBits_offset[mdIdx], val);
    return this;
  }

  public byte getCDepthBits() {
    return accessor.getByteAt(cDepthBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCStencilBits(byte val) {
    accessor.setByteAt(cStencilBits_offset[mdIdx], val);
    return this;
  }

  public byte getCStencilBits() {
    return accessor.getByteAt(cStencilBits_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setCAuxBuffers(byte val) {
    accessor.setByteAt(cAuxBuffers_offset[mdIdx], val);
    return this;
  }

  public byte getCAuxBuffers() {
    return accessor.getByteAt(cAuxBuffers_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setILayerType(byte val) {
    accessor.setByteAt(iLayerType_offset[mdIdx], val);
    return this;
  }

  public byte getILayerType() {
    return accessor.getByteAt(iLayerType_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setBReserved(byte val) {
    accessor.setByteAt(bReserved_offset[mdIdx], val);
    return this;
  }

  public byte getBReserved() {
    return accessor.getByteAt(bReserved_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setDwLayerMask(int val) {
    accessor.setIntAt(dwLayerMask_offset[mdIdx], val);
    return this;
  }

  public int getDwLayerMask() {
    return accessor.getIntAt(dwLayerMask_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setDwVisibleMask(int val) {
    accessor.setIntAt(dwVisibleMask_offset[mdIdx], val);
    return this;
  }

  public int getDwVisibleMask() {
    return accessor.getIntAt(dwVisibleMask_offset[mdIdx]);
  }

  public PIXELFORMATDESCRIPTOR setDwDamageMask(int val) {
    accessor.setIntAt(dwDamageMask_offset[mdIdx], val);
    return this;
  }

  public int getDwDamageMask() {
    return accessor.getIntAt(dwDamageMask_offset[mdIdx]);
  }
}
