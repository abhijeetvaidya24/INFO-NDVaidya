/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.b.a.a.b
 *  com.adincube.sdk.b.a.a.c
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.b.a.a;

import android.content.Context;
import com.adincube.sdk.b.a.a.b;
import com.adincube.sdk.b.a.a.c;
import com.adincube.sdk.b.a.a.d;
import com.adincube.sdk.b.a.a.e;
import com.adincube.sdk.util.a;

public final class f {
    private d a = null;

    public f() {
        this(new d());
    }

    public f(d d2) {
        this.a = d2;
    }

    private static e b(Context context) {
        try {
            b b2 = new b(context);
            return b2;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return null;
        }
    }

    public final e a(Context context) {
        e e2 = this.a.a ? f.b(context) : null;
        if (e2 == null) {
            e2 = new c(context);
        }
        Object[] arrobject = new Object[]{e2.k()};
        a.a("Will display video content using player: %s", arrobject);
        return e2;
    }
}

