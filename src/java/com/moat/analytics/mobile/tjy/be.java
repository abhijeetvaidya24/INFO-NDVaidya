/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
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
package com.moat.analytics.mobile.tjy;

import android.view.View;
import com.moat.analytics.mobile.tjy.MoatAdEvent;
import com.moat.analytics.mobile.tjy.ReactiveVideoTracker;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.bc;
import java.lang.reflect.Method;
import java.util.Map;

class be
implements bc {
    private static final a a;
    private static final a b;
    private static final a c;
    private static final a d;

    static {
        a a2 = a.a();
        a a3 = a.a();
        a a4 = a.a();
        a a5 = a.a();
        try {
            Class[] arrclass = new Class[]{Boolean.TYPE};
            Method method = ReactiveVideoTracker.class.getMethod("setDebug", arrclass);
            Method method2 = ReactiveVideoTracker.class.getMethod("trackVideoAd", new Class[]{Map.class, View.class, View.class});
            Method method3 = ReactiveVideoTracker.class.getMethod("changeTargetView", new Class[]{View.class});
            Method method4 = ReactiveVideoTracker.class.getMethod("dispatchEvent", new Class[]{MoatAdEvent.class});
            a2 = a.a((Object)method);
            a3 = a.a((Object)method2);
            a4 = a.a((Object)method3);
            a5 = a.a((Object)method4);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            com.moat.analytics.mobile.tjy.base.exception.a.a((Exception)((Object)noSuchMethodException));
        }
        a = a2;
        b = a3;
        c = a4;
        d = a5;
    }

    be() {
    }

    @Override
    public Class a() {
        return ReactiveVideoTracker.class;
    }
}

