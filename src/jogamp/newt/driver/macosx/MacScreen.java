/*
 * Copyright (c) 2008 Sun Microsystems, Inc. All Rights Reserved.
 * Copyright (c) 2011 JogAmp Community. All rights reserved.
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
 */

package jogamp.newt.driver.macosx;

import java.util.List;

import javax.media.nativewindow.DefaultGraphicsScreen;
import javax.media.nativewindow.util.Dimension;
import javax.media.nativewindow.util.DimensionImmutable;
import javax.media.nativewindow.util.Point;

import jogamp.newt.ScreenImpl;

import com.jogamp.common.util.IntObjectHashMap;
import com.jogamp.newt.ScreenMode;
import com.jogamp.newt.util.ScreenModeUtil;

public class MacScreen extends ScreenImpl {
    
    // caching native CGDisplayScreenSize() results, since it's ridiculous slow (~6 ms each call)
    private static IntObjectHashMap/*<int, DimensionImmutable>*/ scrnIdx2Dimension;
    
    static {
        MacDisplay.initSingleton();
        scrnIdx2Dimension = new IntObjectHashMap();
        scrnIdx2Dimension.setKeyNotFoundValue(null);
    }

    public MacScreen() {
    }

    protected void createNativeImpl() {
        aScreen = new DefaultGraphicsScreen(getDisplay().getGraphicsDevice(), screen_idx);
    }

    protected void closeNativeImpl() { }

    private static native int getWidthImpl0(int scrn_idx);
    private static native int getHeightImpl0(int scrn_idx);
    
    private int[] getScreenModeIdx(int idx) {
        // caching native CGDisplayScreenSize() results, since it's ridiculous slow (~6 ms each call)
        DimensionImmutable dim = (DimensionImmutable) scrnIdx2Dimension.get(screen_idx);
        if(null == dim) {
            int[] res = getScreenSizeMM0(screen_idx);
            if(null == res || 0 == res.length) {
                return null;
            }
            dim = new Dimension(res[0], res[1]);
            scrnIdx2Dimension.put(screen_idx, dim);
        }

        int[] modeProps = getScreenMode0(screen_idx, idx, dim.getWidth(), dim.getHeight());
        if (null == modeProps || 0 == modeProps.length) {
            return null;
        }
        if(modeProps.length < ScreenModeUtil.NUM_SCREEN_MODE_PROPERTIES_ALL) {
            throw new RuntimeException("properties array too short, should be >= "+ScreenModeUtil.NUM_SCREEN_MODE_PROPERTIES_ALL+", is "+modeProps.length);
        }
        return modeProps;
    }

    private int nativeModeIdx;
    
    protected int[] getScreenModeFirstImpl() {
        nativeModeIdx = 0;
        return getScreenModeNextImpl();
    }

    protected int[] getScreenModeNextImpl() {
        int[] modeProps = getScreenModeIdx(nativeModeIdx);
        if (null != modeProps && 0 < modeProps.length) {
            nativeModeIdx++;
            return modeProps;
        }
        return null;
    }

    protected ScreenMode getCurrentScreenModeImpl() {
        int[] modeProps = getScreenModeIdx(-1);
        if (null != modeProps && 0 < modeProps.length) {
            return ScreenModeUtil.streamIn(modeProps, 0);
        }
        return null;
    }
    
    protected boolean setCurrentScreenModeImpl(final ScreenMode screenMode) {
        final List<ScreenMode> screenModes = this.getScreenModesOrig();
        final int screenModeIdx = screenModes.indexOf(screenMode);
        if(0>screenModeIdx) {
            throw new RuntimeException("ScreenMode not element of ScreenMode list: "+screenMode);
        }
        final int nativeModeIdx = getScreenModesIdx2NativeIdx().get(screenModeIdx);
        return setScreenMode0(screen_idx, nativeModeIdx);
    }
    
    protected int validateScreenIndex(int idx) {
        return idx; 
    }
        
    protected void getVirtualScreenOriginAndSize(Point virtualOrigin, Dimension virtualSize) {
        virtualOrigin.setX(0);
        virtualOrigin.setY(0);
        virtualSize.setWidth(getWidthImpl0(screen_idx));
        virtualSize.setHeight(getHeightImpl0(screen_idx));
    }

    private native int[] getScreenSizeMM0(int screen_idx);
    private native int[] getScreenMode0(int screen_index, int mode_index, int widthMM, int heightMM);
    private native boolean setScreenMode0(int screen_index, int mode_idx);
}
