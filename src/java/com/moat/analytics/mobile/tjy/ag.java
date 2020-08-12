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
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.NativeDisplayTracker;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.bc;
import java.lang.reflect.Method;
import java.util.Map;

class ag
implements bc {
    private static final a a;
    private static final a b;

    static {
        a a2 = a.a();
        a a3 = a.a();
        try {
            Method method = NativeDisplayTracker.class.getMethod("track", new Class[]{Map.class});
            Method method2 = NativeDisplayTracker.class.getMethod("stopTracking", new Class[0]);
            a2 = a.a((Object)method);
            a3 = a.a((Object)method2);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            com.moat.analytics.mobile.tjy.base.exception.a.a((Exception)((Object)noSuchMethodException));
        }
        a = a2;
        b = a3;
    }

    ag() {
    }

    @Override
    public Class a() {
        return NativeDisplayTracker.class;
    }
}

