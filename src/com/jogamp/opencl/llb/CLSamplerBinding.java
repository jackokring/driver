/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Fri Aug 03 06:57:03 CEST 2012 ----! */

package com.jogamp.opencl.llb;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import java.nio.*;

 /**
  * Java bindings to OpenCL sampler objects.
  * @author Michael Bien, GlueGen, et al.
  */
public interface CLSamplerBinding {

  public static final int CL_ADDRESS_NONE = 0x1130;
  public static final int CL_ADDRESS_CLAMP_TO_EDGE = 0x1131;
  public static final int CL_ADDRESS_CLAMP = 0x1132;
  public static final int CL_ADDRESS_REPEAT = 0x1133;
  public static final int CL_ADDRESS_MIRRORED_REPEAT = 0x1134;
  public static final int CL_FILTER_NEAREST = 0x1140;
  public static final int CL_FILTER_LINEAR = 0x1141;
  public static final int CL_SAMPLER_REFERENCE_COUNT = 0x1150;
  public static final int CL_SAMPLER_CONTEXT = 0x1151;
  public static final int CL_SAMPLER_NORMALIZED_COORDS = 0x1152;
  public static final int CL_SAMPLER_ADDRESSING_MODE = 0x1153;
  public static final int CL_SAMPLER_FILTER_MODE = 0x1154;

  /** Interface to C language function: <br> <code> cl_sampler {@native clCreateSampler}(cl_context context, cl_bool normalized_coords, cl_addressing_mode addressing_mode, cl_filter_mode filter_mode, cl_int *  errcode_ret); </code> 
      @param errcode_ret a direct or array-backed {@link java.nio.IntBuffer}   */
  public long clCreateSampler(long context, int normalized_coords, int addressing_mode, int filter_mode, IntBuffer errcode_ret);

  /** Interface to C language function: <br> <code> cl_sampler {@native clCreateSampler}(cl_context context, cl_bool normalized_coords, cl_addressing_mode addressing_mode, cl_filter_mode filter_mode, cl_int *  errcode_ret); </code>    */
  public long clCreateSampler(long context, int normalized_coords, int addressing_mode, int filter_mode, int[] errcode_ret, int errcode_ret_offset);

  /** Interface to C language function: <br> <code> cl_int {@native clGetSamplerInfo}(cl_sampler sampler, cl_sampler_info param_name, size_t param_value_size, void *  param_value, size_t *  param_value_size_ret); </code> 
      @param param_value a direct only {@link java.nio.Buffer}
      @param param_value_size_ret a direct only {@link com.jogamp.common.nio.PointerBuffer}   */
  public int clGetSamplerInfo(long sampler, int param_name, long param_value_size, Buffer param_value, PointerBuffer param_value_size_ret);

  /** Interface to C language function: <br> <code> cl_int {@native clReleaseSampler}(cl_sampler sampler); </code>    */
  public int clReleaseSampler(long sampler);

  /** Interface to C language function: <br> <code> cl_int {@native clRetainSampler}(cl_sampler sampler); </code>    */
  public int clRetainSampler(long sampler);


} // end of class CLSamplerBinding
