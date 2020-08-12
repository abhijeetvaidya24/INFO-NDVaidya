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
package com.adincube.sdk.mediation.g;

import android.content.Context;
import com.adincube.sdk.mediation.i;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private String a = null;
    private com.adincube.sdk.util.d.b b = null;

    public b(com.adincube.sdk.mediation.b b2, Context context) {
        this.b = new com.adincube.sdk.util.d.b(b2.f().f(), context);
        this.a = b2.f().b(context);
    }

    public final void a() {
        this.b.a("android.permission.INTERNET");
        this.b.a("android.permission.ACCESS_NETWORK_STATE");
        this.b.b("com.appnext.base.services.OperationService");
        this.b.b("com.appnext.base.services.ReceiverService");
        this.b.b("com.appnext.core.AdsService");
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"android:hardwareAccelerated", (Object)"true");
        hashMap.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        hashMap.put((Object)"android:theme", (Object)"@android:style/Theme.NoTitleBar.Fullscreen");
        this.b.a("com.appnext.ads.interstitial.InterstitialActivity", (Map<String, String>)hashMap);
        hashMap.put((Object)"android:hardwareAccelerated", (Object)"true");
        hashMap.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        hashMap.put((Object)"android:theme", (Object)"@android:style/Theme.NoTitleBar.Fullscreen");
        this.b.a("com.appnext.ads.fullscreen.FullscreenActivity", (Map<String, String>)hashMap);
        this.b.a();
    }
}

