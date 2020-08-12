/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.adincube.sdk.mediation.w;

import android.content.Context;
import com.adincube.sdk.mediation.i;
import java.util.Map;

public final class b {
    private com.adincube.sdk.util.d.b a = null;

    public b(com.adincube.sdk.mediation.b b2, Context context) {
        this.a = new com.adincube.sdk.util.d.b(b2.f().f(), context);
    }

    public final void a() {
        this.a.a("android.permission.INTERNET");
        this.a.a("com.adincube.sdk.AdinCubeActivity", null);
        this.a.a();
    }
}

