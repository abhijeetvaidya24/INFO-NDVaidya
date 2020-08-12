/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tapjoy.internal.fg
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.internal.fg;

abstract class ff {
    private static final ff a;
    private static ff b;

    static {
        fg fg2 = new fg();
        a = fg2;
        b = fg2;
    }

    ff() {
    }

    static ff a() {
        return b;
    }

    public abstract Object a(Context var1, String var2, TJPlacementListener var3);
}

