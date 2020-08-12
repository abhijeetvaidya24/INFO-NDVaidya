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
package com.adincube.sdk.mediation.f;

import android.content.Context;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.i;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private com.adincube.sdk.util.d.b a;

    public c(b b2, Context context) {
        this.a = new com.adincube.sdk.util.d.b(b2.f().f(), context);
    }

    public final void a() {
        this.a.a("android.permission.INTERNET");
        this.a.a("android.permission.ACCESS_NETWORK_STATE");
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"android:configChanges", (Object)"orientation|screenSize");
        this.a.a("com.applovin.adview.AppLovinInterstitialActivity", (Map<String, String>)hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"android:configChanges", (Object)"orientation|screenSize");
        this.a.a("com.applovin.adview.AppLovinConfirmationActivity", (Map<String, String>)hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        this.a.a("com.applovin.sdk.AppLovinWebViewActivity", (Map<String, String>)hashMap3);
        this.a.a();
    }
}

