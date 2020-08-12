/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.view.View
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 *  java.util.Map
 */
package com.moat.analytics.mobile.aer;

import android.media.MediaPlayer;
import android.view.View;
import com.moat.analytics.mobile.aer.NativeVideoTracker;
import com.moat.analytics.mobile.aer.ay;
import com.moat.analytics.mobile.aer.base.exception.a;
import java.lang.reflect.Method;
import java.util.Map;

class ae
implements ay<NativeVideoTracker> {
    private static final com.moat.analytics.mobile.aer.base.functional.a<Method> a;
    private static final com.moat.analytics.mobile.aer.base.functional.a<Method> b;
    private static final com.moat.analytics.mobile.aer.base.functional.a<Method> c;
    private static final com.moat.analytics.mobile.aer.base.functional.a<Method> d;
    private static final com.moat.analytics.mobile.aer.base.functional.a<Method> e;

    static {
        com.moat.analytics.mobile.aer.base.functional.a<Object> a2 = com.moat.analytics.mobile.aer.base.functional.a.a();
        com.moat.analytics.mobile.aer.base.functional.a<Object> a3 = com.moat.analytics.mobile.aer.base.functional.a.a();
        com.moat.analytics.mobile.aer.base.functional.a<Object> a4 = com.moat.analytics.mobile.aer.base.functional.a.a();
        com.moat.analytics.mobile.aer.base.functional.a<Object> a5 = com.moat.analytics.mobile.aer.base.functional.a.a();
        com.moat.analytics.mobile.aer.base.functional.a<Object> a6 = com.moat.analytics.mobile.aer.base.functional.a.a();
        try {
            Class[] arrclass = new Class[]{Boolean.TYPE};
            Method method = NativeVideoTracker.class.getMethod("setDebug", arrclass);
            Method method2 = NativeVideoTracker.class.getMethod("trackVideoAd", new Class[]{Map.class, MediaPlayer.class, View.class});
            Method method3 = NativeVideoTracker.class.getMethod("changeTargetView", new Class[]{View.class});
            Method method4 = NativeVideoTracker.class.getMethod("dispatchEvent", new Class[]{Map.class});
            Method method5 = NativeVideoTracker.class.getMethod("dispatchEvent", new Class[]{Map.class});
            a2 = com.moat.analytics.mobile.aer.base.functional.a.a(method);
            a3 = com.moat.analytics.mobile.aer.base.functional.a.a(method2);
            a4 = com.moat.analytics.mobile.aer.base.functional.a.a(method3);
            a6 = com.moat.analytics.mobile.aer.base.functional.a.a(method4);
            a5 = com.moat.analytics.mobile.aer.base.functional.a.a(method5);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            a.a((Exception)((Object)noSuchMethodException));
        }
        a = a2;
        b = a3;
        c = a4;
        d = a6;
        e = a5;
    }

    ae() {
    }

    @Override
    public Class<NativeVideoTracker> a() {
        return NativeVideoTracker.class;
    }
}

