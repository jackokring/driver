/**
 * Copyright 2011 JogAmp Community. All rights reserved.
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
package jogamp.android.launcher;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainLauncher extends Activity {
   static final String TAG = "JogAmp-MainLauncher";
   
   // private static final String[] frameworkAPKs = { "/system/framework/core-junit.jar", "/data/projects/gluegen/make/lib/ant-junit-all.apk" };
   private static final String[] frameworkAPKs = { "/data/projects/gluegen/make/lib/ant-junit-all.apk" };
   
   LauncherUtil.DataSet data = null;
   
   Class<?> mainClazz = null;
   Method mainClazzMain = null;
      
   Class<?> staticContextClazz = null;
   Method mStaticContextInit = null;
   Method mStaticContextClear = null;
   String[] mainClassArgs = null;
   
   @Override
   public void onCreate(Bundle savedInstanceState) {
       Log.d(TAG, "onCreate - S");
       super.onCreate(savedInstanceState);
       
       final Uri uri = getIntent().getData();
       data = LauncherUtil.DataSet.create(uri);
       data.setSystemProperties();

       ClassLoader cl = ClassLoaderUtil.createClassLoader(this, data.getPackages(), false, Arrays.asList(frameworkAPKs));
       if(null != cl) {
           try {
               staticContextClazz = Class.forName("jogamp.common.os.android.StaticContext", true, cl);
               mStaticContextInit = staticContextClazz.getMethod("init", android.content.Context.class);
               mStaticContextClear = staticContextClazz.getMethod("clear");               
               
               mainClazz = Class.forName(data.getActivityName(), true, cl);
               Log.d(TAG, "Main Clazz "+mainClazz);
               mainClazzMain = mainClazz.getDeclaredMethod("main", new Class[] { String[].class });
               Log.d(TAG, "Main Clazz Main "+mainClazzMain);
           } catch (Exception e) {
               Log.d(TAG, "error: "+e, e);
               throw new RuntimeException(e);
           }
       }

       if( null == mStaticContextInit || null == mStaticContextClear || 
           null == mainClazzMain ) {
           RuntimeException e = new RuntimeException("XXX - incomplete method set");
           Log.d(TAG, "error: "+e, e);
           throw e;
       }
       
       callMethod(null, mStaticContextInit, this.getApplicationContext());
       
       mainClassArgs=new String[0]; // FIXME
       
       Log.d(TAG, "onCreate - X");
   }
   
   @Override
   public void onStart() {
     Log.d(TAG, "onStart - S");
     super.onStart();
     Log.d(TAG, "onStart - X");
   }
     
   @Override
   public void onRestart() {
     Log.d(TAG, "onRestart - S");
     super.onRestart();
     Log.d(TAG, "onRestart - X");
   }

   @Override
   public void onResume() {
     Log.d(TAG, "onResume - S");
     try {
         mainClazzMain.invoke(null, new Object[] { mainClassArgs } );
     } catch (InvocationTargetException ite) {
         ite.getTargetException().printStackTrace();
     } catch (Throwable t) {
         t.printStackTrace();
     }
     super.onResume();
     finish();
     Log.d(TAG, "onResume - X");
   }

   @Override
   public void onPause() {
     Log.d(TAG, "onPause - S");
     super.onPause();
     Log.d(TAG, "onPause - X");
   }

   @Override
   public void onStop() {
     Log.d(TAG, "onStop - S");
     super.onStop();  
     Log.d(TAG, "onStop - X");
   }

   @Override
   public void onDestroy() {
     Log.d(TAG, "onDestroy - S");
     if(null != data) {
         data.clearSystemProperties();
         data = null;
     }
     callMethod(null, mStaticContextClear);
     super.onDestroy();  
     finish();
     Log.d(TAG, "onDestroy - X");
   }   

   @Override
   public void finish() {
     Log.d(TAG, "finish - S");
     super.finish();  
     Log.d(TAG, "finish - X");
   }   

  /**
   * @throws JogampRuntimeException if the instance can not be created.
   */
  public static final Object createInstance(Class<?> clazz, Class<?>[] cstrArgTypes, Object ... cstrArgs) 
      throws RuntimeException
  {
    return createInstance(getConstructor(clazz, cstrArgTypes), cstrArgs);
  }

  public static final Object createInstance(Constructor<?> cstr, Object ... cstrArgs) 
      throws RuntimeException
  {
    try {
        return cstr.newInstance(cstrArgs);
    } catch (Exception e) {
      Throwable t = e;
      if (t instanceof InvocationTargetException) {
        t = ((InvocationTargetException) t).getTargetException();
      }
      if (t instanceof Error) {
        throw (Error) t;
      }
      if (t instanceof RuntimeException) {
        throw (RuntimeException) t;
      }
      throw new RuntimeException("can not create instance of "+cstr.getName(), t);
    }
  }
  
    /**
     * @throws JogampRuntimeException if the constructor can not be delivered.
     */
    protected static final Constructor<?> getConstructor(Class<?> clazz, Class<?> ... cstrArgTypes) 
        throws RuntimeException {
        try {
            if(null == cstrArgTypes) {
                cstrArgTypes = zeroTypes;
            }
            return clazz.getDeclaredConstructor(cstrArgTypes);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException("Constructor: '" + clazz + "(" + asString(cstrArgTypes) + ")' not found", ex);
        }
    }
    
    protected static final Class<?>[] zeroTypes = new Class[0];

    protected static final String asString(Class<?>[] argTypes) {
        StringBuilder args = new StringBuilder();
        boolean coma = false;
        if(null != argTypes) {
            for (int i = 0; i < argTypes.length; i++) {
                if(coma) {
                     args.append(", ");
                }
                args.append(argTypes[i].getName());
                coma = true;
            }
        }
        return args.toString();
    }
    
  protected static final Object callMethod(Object instance, Method method, Object ... args)
      throws RuntimeException
  {
    try {
        return method.invoke(instance, args);
    } catch (Exception e) {
      Throwable t = e;
      if (t instanceof InvocationTargetException) {
        t = ((InvocationTargetException) t).getTargetException();
      }
      if (t instanceof Error) {
        throw (Error) t;
      }
      if (t instanceof RuntimeException) {
        throw (RuntimeException) t;
      }
      throw new RuntimeException("calling "+method+" failed", t);
    }
  }
}
