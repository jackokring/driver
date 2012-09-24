/*
 * Copyright (c) 2009 JogAmp Community. All rights reserved.
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

package com.jogamp.opencl;


/**
 * Common superclass for all OpenCL objects.
 * @author Michael Bien
 */
public abstract class CLObject {

    /**
     * The OpenCL object handle.
     */
    public final long ID;
    
    protected CLContext context;

    CLObject(long ID) {
        this.context = null;
        this.ID = ID;
    }

    CLObject(CLContext context, long ID) {
        this.context = context;
        this.ID = ID;
    }

    /**
     * Returns the context for this OpenCL object.
     */
    public CLContext getContext() {
        return context;
    }

    /**
     * Returns the platform for this OpenCL object.
     */
    public CLPlatform getPlatform() {
        return context.getPlatform();
    }

    /**
     * Returns the OpenCL object handle
     */
    public long getID() {
        return ID;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id: " + ID
                                          + " context: " + context+"]";
    }

}
