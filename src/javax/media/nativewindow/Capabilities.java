/*
 * Copyright (c) 2003 Sun Microsystems, Inc. All Rights Reserved.
 * Copyright (c) 2010 JogAmp Community. All rights reserved.
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

package javax.media.nativewindow;

/** Specifies a set of capabilities that a window's rendering context
    must support, such as color depth per channel. It currently
    contains the minimal number of routines which allow configuration
    on all supported window systems. */
public class Capabilities implements CapabilitiesImmutable, Cloneable {
  protected final static String na_str = "----" ;

  private int     redBits        = 8;
  private int     greenBits      = 8;
  private int     blueBits       = 8;
  private int     alphaBits      = 0;

  // Support for transparent windows containing OpenGL content
  private boolean backgroundOpaque = true;
  private int     transparentValueRed = 0;
  private int     transparentValueGreen = 0;
  private int     transparentValueBlue = 0;
  private int     transparentValueAlpha = 0;

  // Switch for on- or offscreen
  private boolean onscreen  = true;

  /** Creates a Capabilities object. All attributes are in a default
      state.
    */
  public Capabilities() {}

  @Override
  public Object cloneMutable() {
    return clone();
  }

  @Override
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      throw new NativeWindowException(e);
    }
  }

  @Override
  public int hashCode() {
    // 31 * x == (x << 5) - x
    int hash = 31 + this.redBits;
    hash = ((hash << 5) - hash) + this.greenBits;
    hash = ((hash << 5) - hash) + this.blueBits;
    hash = ((hash << 5) - hash) + this.alphaBits;
    hash = ((hash << 5) - hash) + ( this.backgroundOpaque ? 1 : 0 );
    hash = ((hash << 5) - hash) + this.transparentValueRed;
    hash = ((hash << 5) - hash) + this.transparentValueGreen;
    hash = ((hash << 5) - hash) + this.transparentValueBlue;
    hash = ((hash << 5) - hash) + this.transparentValueAlpha;
    hash = ((hash << 5) - hash) + ( this.onscreen ? 1 : 0 );
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj)  { return true; }
    if(!(obj instanceof CapabilitiesImmutable)) {
        return false;
    }
    CapabilitiesImmutable other = (CapabilitiesImmutable)obj;
    boolean res = other.getRedBits()==redBits &&
                  other.getGreenBits()==greenBits &&
                  other.getBlueBits()==blueBits &&
                  other.getAlphaBits()==alphaBits &&
                  other.isBackgroundOpaque()==backgroundOpaque &&
                  other.isOnscreen()==onscreen;
    if(!backgroundOpaque) {
     res = res && other.getTransparentRedValue()==transparentValueRed &&
                  other.getTransparentGreenValue()==transparentValueGreen &&
                  other.getTransparentBlueValue()==transparentValueBlue &&
                  other.getTransparentAlphaValue()==transparentValueAlpha;
    }

    return res;
  }

  /**
   * Comparing RGBA values only
   **/
  @Override
  public int compareTo(final CapabilitiesImmutable caps) {
    /** 
    if ( ! ( o instanceof CapabilitiesImmutable ) ) {
        Class<?> c = (null != o) ? o.getClass() : null ;
        throw new ClassCastException("Not a CapabilitiesImmutable object, but " + c);
    }
    final CapabilitiesImmutable caps = (CapabilitiesImmutable) o; */
        
    final int a = ( alphaBits > 0 ) ? alphaBits : 1;
    final int rgba = redBits * greenBits * blueBits * a;

    final int xa = ( caps.getAlphaBits() ) > 0 ? caps.getAlphaBits() : 1;
    final int xrgba = caps.getRedBits() * caps.getGreenBits() * caps.getBlueBits() * xa;

    if(rgba > xrgba) {
        return 1;
    } else if(rgba < xrgba) {
        return -1;
    }

    return 0; // they are equal: RGBA
  }

  @Override
  public int getVisualID(VIDType type) throws NativeWindowException {
      switch(type) {
          case INTRINSIC:
          case NATIVE:
              return VisualIDHolder.VID_UNDEFINED;
          default:
              throw new NativeWindowException("Invalid type <"+type+">");
      }
  }

  /** Returns the number of bits requested for the color buffer's red
      component. On some systems only the color depth, which is the
      sum of the red, green, and blue bits, is considered. */
  @Override
  public final int getRedBits() {
    return redBits;
  }

  /** Sets the number of bits requested for the color buffer's red
      component. On some systems only the color depth, which is the
      sum of the red, green, and blue bits, is considered. */
  public void setRedBits(int redBits) {
    this.redBits = redBits;
  }

  /** Returns the number of bits requested for the color buffer's
      green component. On some systems only the color depth, which is
      the sum of the red, green, and blue bits, is considered. */
  @Override
  public final int getGreenBits() {
    return greenBits;
  }

  /** Sets the number of bits requested for the color buffer's green
      component. On some systems only the color depth, which is the
      sum of the red, green, and blue bits, is considered. */
  public void setGreenBits(int greenBits) {
    this.greenBits = greenBits;
  }

  /** Returns the number of bits requested for the color buffer's blue
      component. On some systems only the color depth, which is the
      sum of the red, green, and blue bits, is considered. */
  @Override
  public final int getBlueBits() {
    return blueBits;
  }

  /** Sets the number of bits requested for the color buffer's blue
      component. On some systems only the color depth, which is the
      sum of the red, green, and blue bits, is considered. */
  public void setBlueBits(int blueBits) {
    this.blueBits = blueBits;
  }

  /** Returns the number of bits requested for the color buffer's
      alpha component. On some systems only the color depth, which is
      the sum of the red, green, and blue bits, is considered. */
  @Override
  public final int getAlphaBits() {
    return alphaBits;
  }

  /** 
   * Sets the number of bits requested for the color buffer's alpha
   * component. On some systems only the color depth, which is the
   * sum of the red, green, and blue bits, is considered.
   * <p>
   * <b>Note:</b> If alpha bits are <code>zero</code>, they are set to <code>one</code> 
   * by {@link #setBackgroundOpaque(boolean)} and it's OpenGL specialization <code>GLCapabilities::setSampleBuffers(boolean)</code>.<br/>
   * Ensure to call this method after the above to ensure a <code>zero</code> value.</br>
   * The above automated settings takes into account, that the user calls this method to <i>request</i> alpha bits,
   * not to <i>reflect</i> a current state. Nevertheless if this is the case - call it at last.
   * </p>  
   */
  public void setAlphaBits(int alphaBits) {
    this.alphaBits = alphaBits;
  }

  /**
   * Defaults to true, ie. opaque surface.
   * <p>
   * On supported platforms, setting opaque to false may result in a translucent surface. </p>
   *
   * <p>
   * Platform implementations may need an alpha component in the surface (eg. Windows),
   * or expect pre-multiplied alpha values (eg. X11/XRender).<br>
   * To unify the experience, this method also invokes {@link #setAlphaBits(int) setAlphaBits(1)}
   * if {@link #getAlphaBits()} == 0.<br>
   * Please note that in case alpha is required on the platform the
   * clear color shall have an alpha lower than 1.0 to allow anything shining through.
   * </p>
   *
   * <p>
   * Mind that translucency may cause a performance penalty
   * due to the composite work required by the window manager.</p>
   *
   * <p>
   * The platform implementation may utilize the transparency RGBA values.<br>
   * This is true for the original GLX transparency specification, which is no more used today.<br>
   * Actually these values are currently not used by any implementation,
   * so we may mark them deprecated soon, if this doesn't change.<br>
   * </p>
   */
  public void setBackgroundOpaque(boolean opaque) {
      backgroundOpaque = opaque;
      if(!opaque && getAlphaBits()==0) {
          setAlphaBits(1);
      }
  }

  /** Indicates whether the background of this OpenGL context should
      be considered opaque. Defaults to true.

      @see #setBackgroundOpaque
  */
  @Override
  public final boolean isBackgroundOpaque() {
    return backgroundOpaque;
  }

  /** Sets whether the drawable surface supports onscreen.
      Defaults to true.
  */
  public void setOnscreen(boolean onscreen) {
    this.onscreen=onscreen;
  }

  /** Indicates whether the drawable surface is onscreen.
      Defaults to true.
  */
  @Override
  public final boolean isOnscreen() {
    return onscreen;
  }

  /** Gets the transparent red value for the frame buffer configuration.
    * This value is undefined if {@link #isBackgroundOpaque()} equals true.
    * @see #setTransparentRedValue
    */
  @Override
  public final int getTransparentRedValue() { return transparentValueRed; }

  /** Gets the transparent green value for the frame buffer configuration.
    * This value is undefined if {@link #isBackgroundOpaque()} equals true.
    * @see #setTransparentGreenValue
    */
  @Override
  public final int getTransparentGreenValue() { return transparentValueGreen; }

  /** Gets the transparent blue value for the frame buffer configuration.
    * This value is undefined if {@link #isBackgroundOpaque()} equals true.
    * @see #setTransparentBlueValue
    */
  @Override
  public final int getTransparentBlueValue() { return transparentValueBlue; }

  /** Gets the transparent alpha value for the frame buffer configuration.
    * This value is undefined if {@link #isBackgroundOpaque()} equals true.
    * @see #setTransparentAlphaValue
    */
  @Override
  public final int getTransparentAlphaValue() { return transparentValueAlpha; }

  /** Sets the transparent red value for the frame buffer configuration,
      ranging from 0 to the maximum frame buffer value for red.
      This value is ignored if {@link #isBackgroundOpaque()} equals true.<br>
      It defaults to half of the frambuffer value for red. <br>
      A value of -1 is interpreted as any value. */
  public void setTransparentRedValue(int transValueRed) { transparentValueRed=transValueRed; }

  /** Sets the transparent green value for the frame buffer configuration,
      ranging from 0 to the maximum frame buffer value for green.
      This value is ignored if {@link #isBackgroundOpaque()} equals true.<br>
      It defaults to half of the frambuffer value for green.<br>
      A value of -1 is interpreted as any value. */
  public void setTransparentGreenValue(int transValueGreen) { transparentValueGreen=transValueGreen; }

  /** Sets the transparent blue value for the frame buffer configuration,
      ranging from 0 to the maximum frame buffer value for blue.
      This value is ignored if {@link #isBackgroundOpaque()} equals true.<br>
      It defaults to half of the frambuffer value for blue.<br>
      A value of -1 is interpreted as any value. */
  public void setTransparentBlueValue(int transValueBlue) { transparentValueBlue=transValueBlue; }

  /** Sets the transparent alpha value for the frame buffer configuration,
      ranging from 0 to the maximum frame buffer value for alpha.
      This value is ignored if {@link #isBackgroundOpaque()} equals true.<br>
      It defaults to half of the frambuffer value for alpha.<br>
      A value of -1 is interpreted as any value. */
  public void setTransparentAlphaValue(int transValueAlpha) { transparentValueAlpha=transValueAlpha; }

  @Override
  public StringBuilder toString(StringBuilder sink) {
    if(null == sink) {
        sink = new StringBuilder();
    }
    if(onscreen) {
        sink.append("on-scr");
    } else {
        sink.append("offscr");
    }
    sink.append(", rgba 0x").append(toHexString(redBits)).append("/").append(toHexString(greenBits)).append("/").append(toHexString(blueBits)).append("/").append(toHexString(alphaBits));
    if(backgroundOpaque) {
        sink.append(", opaque");
    } else {
        sink.append(", trans-rgba 0x").append(toHexString(transparentValueRed)).append("/").append(toHexString(transparentValueGreen)).append("/").append(toHexString(transparentValueBlue)).append("/").append(toHexString(transparentValueAlpha));
    }
    return sink;
  }
  protected final String toHexString(int val) { return Integer.toHexString(val); }

  /** Returns a textual representation of this Capabilities
      object. */
  @Override
  public String toString() {
    StringBuilder msg = new StringBuilder();
    msg.append("Caps[");
    toString(msg);
    msg.append("]");
    return msg.toString();
  }
}
