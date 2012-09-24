/**
 * Copyright 2010 JogAmp Community. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 * 
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY JogAmp Community ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL JogAmp Community OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of JogAmp Community.
 */
 
package jogamp.common.os;

import com.jogamp.common.os.MachineDescription;
import com.jogamp.common.os.Platform;
import com.jogamp.common.os.MachineDescription.StaticConfig;

/**
 * Runtime MachineDescription
 */
public class MachineDescriptionRuntime {

  static volatile boolean smdQueried = false;
  static MachineDescription.StaticConfig smd = null;
  
  public static MachineDescription.StaticConfig getStatic() {
        if(!smdQueried) {
            synchronized(MachineDescription.class) { // volatile dbl-checked-locking OK
                if(!smdQueried) {
                    smd = getStaticImpl();
                    smdQueried=true;
                }
            }
        }
        return smd;
  }  
  
  private static boolean isCPUArch32Bit() throws RuntimeException {
    switch( PlatformPropsImpl.CPU_ARCH ) {
        case X86_32:
        case ARM:
        case ARMv5:
        case ARMv6:
        case ARMv7:
        case SPARC_32:
        case PPC:
            return true;
        case X86_64:
        case IA64:
        case SPARCV9_64:
        case PA_RISC2_0:
            return false;
        default:
            throw new RuntimeException("Please port CPU detection (32/64 bit) to your platform (" + PlatformPropsImpl.OS_lower + "/" + PlatformPropsImpl.ARCH_lower + "("+PlatformPropsImpl.CPU_ARCH+"))");
    }
  }
          
  private static MachineDescription.StaticConfig getStaticImpl() {
      if(isCPUArch32Bit()) {
        if(PlatformPropsImpl.CPU_ARCH.getFamily() == Platform.CPUFamily.ARM && PlatformPropsImpl.LITTLE_ENDIAN) {
            return StaticConfig.ARMle_EABI;
        } else if(PlatformPropsImpl.OS_TYPE == Platform.OSType.WINDOWS) {
            return StaticConfig.X86_32_WINDOWS;            
        } else if(PlatformPropsImpl.OS_TYPE == Platform.OSType.MACOS) {
            return StaticConfig.X86_32_MACOS;
        }
        return StaticConfig.X86_32_UNIX;            
      } else {
        if(PlatformPropsImpl.OS_TYPE == Platform.OSType.WINDOWS) {
            return StaticConfig.X86_64_WINDOWS;                        
        }
        return StaticConfig.X86_64_UNIX;
      }
  }
      
  static volatile boolean rmdQueried = false;
  static MachineDescription rmd = null;

  public static MachineDescription getRuntime() {
        if(!rmdQueried) {
            synchronized(MachineDescription.class) { // volatile dbl-checked-locking OK
                if(!rmdQueried) {
                    rmd = getRuntimeImpl();
                    rmdQueried=true;
                }
            }
        }
        return rmd;
  }  
  private static MachineDescription getRuntimeImpl() {
        try {
            Platform.initSingleton(); // loads native gluegen-rt library
        } catch (UnsatisfiedLinkError err) {
            return null;
        }
        
        int pointerSizeInBytes = getPointerSizeInBytesImpl();
        switch(pointerSizeInBytes) {
            case 4:
            case 8:
                break;
            default:
                throw new RuntimeException("Unsupported pointer size "+pointerSizeInBytes+"bytes, please implement.");
        }

        final long pageSizeL =  getPageSizeInBytesImpl();
        if(Integer.MAX_VALUE < pageSizeL) {
            throw new InternalError("PageSize exceeds integer value: " + pageSizeL);
        }
        
        // size:      int, long, float, double, pointer, pageSize
        // alignment: int8, int16, int32, int64, int, long, float, double, pointer
        return new MachineDescription( 
            true /* runtime validated */, PlatformPropsImpl.LITTLE_ENDIAN,
            
            getSizeOfIntImpl(), getSizeOfLongImpl(),
            getSizeOfFloatImpl(), getSizeOfDoubleImpl(), getSizeOfLongDoubleImpl(), 
            pointerSizeInBytes, (int)pageSizeL,
            
            getAlignmentInt8Impl(), getAlignmentInt16Impl(), getAlignmentInt32Impl(), getAlignmentInt64Impl(),
            getAlignmentIntImpl(), getAlignmentLongImpl(), 
            getAlignmentFloatImpl(), getAlignmentDoubleImpl(), getAlignmentLongDoubleImpl(), 
            getAlignmentPointerImpl());        
    }

    private static native int getPointerSizeInBytesImpl();
    private static native long getPageSizeInBytesImpl();
    
    private static native int getAlignmentInt8Impl();
    private static native int getAlignmentInt16Impl();
    private static native int getAlignmentInt32Impl();
    private static native int getAlignmentInt64Impl();
    private static native int getAlignmentIntImpl();
    private static native int getAlignmentLongImpl();
    private static native int getAlignmentPointerImpl();
    private static native int getAlignmentFloatImpl();
    private static native int getAlignmentDoubleImpl();
    private static native int getAlignmentLongDoubleImpl();
    private static native int getSizeOfIntImpl();
    private static native int getSizeOfLongImpl();
    private static native int getSizeOfPointerImpl();
    private static native int getSizeOfFloatImpl();
    private static native int getSizeOfDoubleImpl();    
    private static native int getSizeOfLongDoubleImpl();    
}

