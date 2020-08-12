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
package com.adincube.sdk.mediation.chartboost;

import android.content.Context;
import com.adincube.sdk.mediation.i;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private com.adincube.sdk.util.d.b a = null;

    public b(com.adincube.sdk.mediation.b b2, Context context) {
        this.a = new com.adincube.sdk.util.d.b(b2.f().f(), context);
    }

    public final void a() {
        this.a.a("android.permission.INTERNET");
        this.a.a("android.permission.ACCESS_NETWORK_STATE");
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"android:excludeFromRecents", (Object)"true");
        hashMap.put((Object)"android:hardwareAccelerated", (Object)"true");
        hashMap.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        this.a.a("com.chartboost.sdk.CBImpressionActivity", (Map<String, String>)hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"android:hardwareAccelerated", (Object)"true");
        hashMap2.put((Object)"android:theme", (Object)"@android:style/Theme.Translucent");
        hashMap2.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        this.a.a("com.adincube.sdk.mediation.chartboost.ChartboostActivity", (Map<String, String>)hashMap2);
        this.a.a();
    }
}

