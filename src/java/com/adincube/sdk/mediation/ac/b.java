/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.adincube.sdk.mediation.ac;

import android.content.Context;
import android.os.Build;
import com.adincube.sdk.mediation.i;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private com.adincube.sdk.util.d.b a;

    public b(com.adincube.sdk.mediation.b b2, Context context) {
        this.a = new com.adincube.sdk.util.d.b(b2.f().f(), context);
    }

    public final void a() {
        this.a.a("android.permission.INTERNET");
        this.a.a("android.permission.ACCESS_NETWORK_STATE");
        if (Build.VERSION.SDK_INT <= 18) {
            this.a.a("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize|screenLayout|smallestScreenSize");
        hashMap.put((Object)"android:launchMode", (Object)"singleTop");
        hashMap.put((Object)"android:theme", (Object)"@android:style/Theme.NoTitleBar.Fullscreen");
        this.a.a("com.vungle.warren.ui.VungleActivity", (Map<String, String>)hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize|screenLayout|smallestScreenSize");
        hashMap2.put((Object)"android:hardwareAccelerated", (Object)"true");
        hashMap2.put((Object)"android:launchMode", (Object)"singleTop");
        hashMap2.put((Object)"android:theme", (Object)"@android:style/Theme.Translucent.NoTitleBar");
        this.a.a("com.vungle.warren.ui.VungleFlexViewActivity", (Map<String, String>)hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize|screenLayout|smallestScreenSize");
        hashMap3.put((Object)"android:launchMode", (Object)"singleTop");
        this.a.a("com.vungle.warren.ui.VungleWebViewActivity", (Map<String, String>)hashMap3);
        this.a.c("com.vungle.warren.NetworkStateReceiver");
        this.a.a();
    }
}

