/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.adincube.sdk.mediation.k;

import android.content.Context;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.i;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private com.adincube.sdk.util.d.b a = null;

    public d(b b2, Context context) {
        this.a = new com.adincube.sdk.util.d.b(b2.f().f(), context);
    }

    public final void a() {
        this.a.a("android.permission.INTERNET");
        this.a.a("android.permission.ACCESS_NETWORK_STATE");
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        this.a.a("com.facebook.ads.AudienceNetworkActivity", (Map<String, String>)hashMap);
        this.a.a();
    }
}

