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
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.WebAdTracker;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.bc;
import java.lang.reflect.Method;

class bk
implements bc {
    private static final a a;

    static {
        a a2 = a.a();
        try {
            a2 = a.a((Object)WebAdTracker.class.getMethod("track", new Class[0]));
        }
        catch (NoSuchMethodException noSuchMethodException) {
            com.moat.analytics.mobile.tjy.base.exception.a.a((Exception)((Object)noSuchMethodException));
        }
        a = a2;
    }

    bk() {
    }

    @Override
    public Class a() {
        return WebAdTracker.class;
    }
}

