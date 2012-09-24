/*
 * Copyright (c) 2003 Sun Microsystems, Inc. All Rights Reserved.
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

package com.jogamp.gluegen;

import java.util.*;

import com.jogamp.common.os.MachineDescription;
import com.jogamp.gluegen.cgram.types.*;

/** Specifies the interface by which GlueGen requests glue code to be
    generated. Can be replaced to generate glue code for other
    languages and foreign function interfaces. */

public interface GlueEmitter {

  public void readConfigurationFile(String filename) throws Exception;

  /**
   * Begin the emission of glue code. This might include opening files,
   * emitting class headers, etc.
   */
  public void beginEmission(GlueEmitterControls controls) throws Exception;

  /**
   * Finish the emission of glue code. This might include closing files,
   * closing open class definitions, etc.
   */
  public void endEmission() throws Exception;

  public void beginDefines() throws Exception;
  /**
   * @param optionalComment If optionalComment is non-null, the emitter can
   * emit that string as a comment providing extra information about the
   * define.
   */
  public void emitDefine(ConstantDefinition def, String optionalComment) throws Exception;
  public void endDefines() throws Exception;
  
  public void beginFunctions(TypeDictionary typedefDictionary,
                             TypeDictionary structDictionary,
                             Map<Type, Type> canonMap) throws Exception;

  /** Emit glue code for the list of FunctionSymbols. */
  public Iterator<FunctionSymbol> emitFunctions(List<FunctionSymbol> cFunctions) throws Exception;
  public void endFunctions() throws Exception;

  /** Begins the process of computing field offsets and type sizes for
      the structs to be emitted. */
  public void beginStructLayout() throws Exception;
  /** Lays out one struct which will be emitted later. */
  public void layoutStruct(CompoundType t) throws Exception;
  /** Finishes the struct layout process. */
  public void endStructLayout() throws Exception;

  public void beginStructs(TypeDictionary typedefDictionary,
                           TypeDictionary structDictionary,
                           Map<Type, Type> canonMap) throws Exception;
  /** Emit glue code for the given CompoundType. alternateName is
      provided when the CompoundType (e.g. "struct foo_t") has not
      been typedefed to anything but the type of "pointer to struct
      foo_t" has (e.g. "typedef struct foo_t {} *Foo"); in this case
      alternateName would be set to Foo. */
  public void emitStruct(CompoundType t, String alternateName) throws Exception;
  public void endStructs() throws Exception;
}
