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
package com.adincube.sdk.mediation.y;

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
        hashMap.put((Object)"android:hardwareAccelerated", (Object)"true");
        hashMap.put((Object)"android:configChanges", (Object)"orientation|keyboardHidden|screenSize");
        hashMap.put((Object)"android:theme", (Object)"@android:style/Theme.Translucent.NoTitleBar.Fullscreen");
        this.a.a("com.tapjoy.TJAdUnitActivity", (Map<String, String>)hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"android:hardwareAccelerated", (Object)"true");
        hashMap2.put((Object)"android:configChanges", (Object)"orientation|keyboardHidden|screenSize");
        hashMap2.put((Object)"android:theme", (Object)"@android:style/Theme.Translucent.NoTitleBar");
        this.a.a("com.tapjoy.TJContentActivity", (Map<String, String>)hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put((Object)"android:configChanges", (Object)"orientation|keyboardHidden|screenSize");
        this.a.a("com.tapjoy.mraid.view.ActionHandler", (Map<String, String>)hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put((Object)"android:configChanges", (Object)"orientation|keyboardHidden|screenSize");
        this.a.a("com.tapjoy.mraid.view.Browser", (Map<String, String>)hashMap4);
        this.a.c("com.tapjoy.InstallReferrerReceiver");
        this.a.a();
    }
}

