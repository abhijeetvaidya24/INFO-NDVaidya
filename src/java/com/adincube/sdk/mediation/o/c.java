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
package com.adincube.sdk.mediation.o;

import android.content.Context;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.i;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private com.adincube.sdk.util.d.b a = null;

    public c(b b2, Context context) {
        this.a = new com.adincube.sdk.util.d.b(b2.f().f(), context);
    }

    public final void a() {
        this.a.a("android.permission.INTERNET");
        this.a.a("android.permission.ACCESS_NETWORK_STATE");
        HashMap hashMap = new HashMap(2);
        hashMap.put((Object)"android:configChanges", (Object)"orientation|screenSize");
        hashMap.put((Object)"android:android:hardwareAccelerated", (Object)"true");
        this.a.a("com.ironsource.sdk.controller.ControllerActivity", (Map<String, String>)hashMap);
        HashMap hashMap2 = new HashMap(3);
        hashMap2.put((Object)"android:configChanges", (Object)"orientation|screenSize");
        hashMap2.put((Object)"android:android:hardwareAccelerated", (Object)"true");
        hashMap2.put((Object)"android:theme", (Object)"@android:style/Theme.Translucent");
        this.a.a("com.ironsource.sdk.controller.InterstitialActivity", (Map<String, String>)hashMap2);
        HashMap hashMap3 = new HashMap(3);
        hashMap3.put((Object)"android:configChanges", (Object)"orientation|screenSize");
        hashMap3.put((Object)"android:android:hardwareAccelerated", (Object)"true");
        hashMap3.put((Object)"android:theme", (Object)"@android:style/Theme.Translucent");
        this.a.a("com.ironsource.sdk.controller.OpenUrlActivity", (Map<String, String>)hashMap3);
        this.a.a();
    }
}

