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
package com.adincube.sdk.mediation.r;

import android.content.Context;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.i;
import java.util.HashMap;
import java.util.Map;

public final class c {
    com.adincube.sdk.util.d.b a;

    public c(b b2, Context context) {
        this.a = new com.adincube.sdk.util.d.b(b2.f().f(), context);
    }

    public final void a() {
        this.a.a("android.permission.INTERNET");
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        this.a.a("com.mopub.common.privacy.ConsentDialogActivity", (Map<String, String>)hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        this.a.a("com.mopub.mobileads.MoPubActivity", (Map<String, String>)hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        this.a.a("com.mopub.mobileads.MraidActivity", (Map<String, String>)hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        this.a.a("com.mopub.common.MoPubBrowser", (Map<String, String>)hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put((Object)"android:configChanges", (Object)"keyboardHidden|orientation|screenSize");
        this.a.a("com.mopub.mobileads.MraidVideoPlayerActivity", (Map<String, String>)hashMap5);
        this.a.a();
    }
}

