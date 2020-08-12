/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Object
 */
package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.b.e;

public class g {
    public static Boolean a(Context context) {
        return g.a(d.e, context);
    }

    private static Boolean a(d<Boolean> d2, Context context) {
        return e.b(d2, null, context);
    }

    private static boolean a(d<Boolean> d2, Boolean bl, Context context) {
        Boolean bl2 = g.a(d2, context);
        e.a(d2, bl, context);
        boolean bl3 = true;
        if (bl2 != null) {
            if (bl2 != bl) {
                return bl3;
            }
            bl3 = false;
        }
        return bl3;
    }

    public static boolean a(boolean bl, Context context) {
        return g.a(d.e, bl, context);
    }

    public static Boolean b(Context context) {
        return g.a(d.f, context);
    }

    public static boolean b(boolean bl, Context context) {
        return g.a(d.f, bl, context);
    }
}

