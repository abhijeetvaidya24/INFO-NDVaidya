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
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.WebAdTracker;
import com.moat.analytics.mobile.aer.ay;
import com.moat.analytics.mobile.aer.base.exception.a;
import java.lang.reflect.Method;

class bd
implements ay<WebAdTracker> {
    private static final com.moat.analytics.mobile.aer.base.functional.a<Method> a;

    static {
        com.moat.analytics.mobile.aer.base.functional.a<Object> a2 = com.moat.analytics.mobile.aer.base.functional.a.a();
        try {
            a2 = com.moat.analytics.mobile.aer.base.functional.a.a(WebAdTracker.class.getMethod("track", new Class[0]));
        }
        catch (NoSuchMethodException noSuchMethodException) {
            a.a((Exception)((Object)noSuchMethodException));
        }
        a = a2;
    }

    bd() {
    }

    @Override
    public Class<WebAdTracker> a() {
        return WebAdTracker.class;
    }
}

