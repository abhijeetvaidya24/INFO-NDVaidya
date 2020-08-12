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
package com.adincube.sdk.mediation.mediabrix;

import android.content.Context;
import android.os.Build;
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
        if (Build.VERSION.SDK_INT <= 18) {
            this.a.a("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"android:theme", (Object)"@android:style/Theme.Translucent.NoTitleBar.Fullscreen");
        hashMap.put((Object)"android:configChanges", (Object)"orientation|screenSize|keyboard");
        this.a.a("com.mediabrix.android.service.AdViewActivity", (Map<String, String>)hashMap);
        this.a.b("com.mediabrix.android.service.MediaBrixService");
    }
}

