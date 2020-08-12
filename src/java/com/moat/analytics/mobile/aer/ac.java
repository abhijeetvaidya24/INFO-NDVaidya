/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 *  java.util.Map
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.NativeDisplayTracker;
import com.moat.analytics.mobile.aer.ay;
import com.moat.analytics.mobile.aer.base.exception.a;
import java.lang.reflect.Method;
import java.util.Map;

class ac
implements ay<NativeDisplayTracker> {
    private static final com.moat.analytics.mobile.aer.base.functional.a<Method> a;
    private static final com.moat.analytics.mobile.aer.base.functional.a<Method> b;

    static {
        com.moat.analytics.mobile.aer.base.functional.a<Object> a2 = com.moat.analytics.mobile.aer.base.functional.a.a();
        com.moat.analytics.mobile.aer.base.functional.a<Object> a3 = com.moat.analytics.mobile.aer.base.functional.a.a();
        try {
            Method method = NativeDisplayTracker.class.getMethod("track", new Class[]{Map.class});
            Method method2 = NativeDisplayTracker.class.getMethod("stopTracking", new Class[0]);
            a2 = com.moat.analytics.mobile.aer.base.functional.a.a(method);
            a3 = com.moat.analytics.mobile.aer.base.functional.a.a(method2);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            a.a((Exception)((Object)noSuchMethodException));
        }
        a = a2;
        b = a3;
    }

    ac() {
    }

    @Override
    public Class<NativeDisplayTracker> a() {
        return NativeDisplayTracker.class;
    }
}

