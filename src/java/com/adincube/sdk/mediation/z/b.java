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
package com.adincube.sdk.mediation.z;

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
        hashMap.put((Object)"android:configChanges", (Object)"fontScale|keyboard|keyboardHidden|locale|mnc|mcc|navigation|orientation|screenLayout|screenSize|smallestScreenSize|uiMode|touchscreen");
        hashMap.put((Object)"android:theme", (Object)"@android:style/Theme.NoTitleBar.Fullscreen");
        hashMap.put((Object)"android:hardwareAccelerated", (Object)"true");
        this.a.a("com.unity3d.ads.adunit.AdUnitActivity", (Map<String, String>)hashMap);
        hashMap.put((Object)"android:hardwareAccelerated", (Object)"false");
        this.a.a("com.unity3d.ads.adunit.AdUnitSoftwareActivity", (Map<String, String>)hashMap);
        this.a.a();
    }
}

