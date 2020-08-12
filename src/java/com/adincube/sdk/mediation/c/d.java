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
package com.adincube.sdk.mediation.c;

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
        this.a.d("com.google.android.gms.version");
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"android:configChanges", (Object)"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize");
        hashMap.put((Object)"android:theme", (Object)"@android:style/Theme.Translucent");
        this.a.a("com.google.android.gms.ads.AdActivity", (Map<String, String>)hashMap);
        this.a.a();
    }
}

