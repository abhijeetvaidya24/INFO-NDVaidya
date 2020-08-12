/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.adincube.sdk.mediation.t;

import android.content.Context;
import android.os.Build;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.util.d.b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    private com.adincube.sdk.util.d.b a = null;

    public c(b b2, Context context) {
        this.a = new com.adincube.sdk.util.d.b(b2.f().f(), context);
    }

    public final void a() {
        this.a.a("android.permission.INTERNET");
        this.a.a("android.permission.ACCESS_NETWORK_STATE");
        this.a.a("com.android.alarm.permission.SET_ALARM");
        HashMap hashMap = new HashMap(2);
        hashMap.put((Object)"android:theme", (Object)"@style/Presage.AdScreen.Translucent");
        hashMap.put((Object)"android:configChanges", (Object)"orientation|screenSize");
        b.b b2 = new b.b();
        this.a.a("io.presage.interstitial.ui.InterstitialActivity", (Map<String, String>)hashMap, (List<b.b>)Arrays.asList((Object[])new b.b[]{b2}));
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put((Object)"android:theme", (Object)"@style/Presage.AdScreen.Translucent");
        hashMap2.put((Object)"android:configChanges", (Object)"orientation|screenSize");
        b.b b3 = new b.b();
        this.a.a("io.presage.interstitial.ui.InterstitialAndroid8TransparentActivity", (Map<String, String>)hashMap2, (List<b.b>)Arrays.asList((Object[])new b.b[]{b3}));
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put((Object)"android:theme", (Object)"@style/Presage.AdScreen");
        hashMap3.put((Object)"android:configChanges", (Object)"orientation|screenSize");
        b.b b4 = new b.b();
        this.a.a("io.presage.interstitial.ui.InterstitialAndroid8RotableActivity", (Map<String, String>)hashMap3, (List<b.b>)Arrays.asList((Object[])new b.b[]{b4}));
        HashMap hashMap4 = new HashMap(1);
        hashMap4.put((Object)"android:theme", (Object)"@style/Presage.AdScreen");
        b.b b5 = new b.b();
        b5.a.add((Object)"android.intent.action.MAIN");
        this.a.a("io.presage.mraid.browser.ShortcutActivity", (Map<String, String>)hashMap4, (List<b.b>)Arrays.asList((Object[])new b.b[]{b5}));
        HashMap hashMap5 = new HashMap(1);
        hashMap5.put((Object)"android:exported", (Object)"false");
        b.b b6 = new b.b();
        this.a.b("io.presage.common.profig.schedule.ProfigSyncIntentService", (Map<String, String>)hashMap5, (List<b.b>)Arrays.asList((Object[])new b.b[]{b6}));
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put((Object)"android:exported", (Object)"false");
            hashMap6.put((Object)"android:permission", (Object)"android.permission.BIND_JOB_SERVICE");
            b.b b7 = new b.b();
            this.a.b("io.presage.common.profig.schedule.ProfigJobService", (Map<String, String>)hashMap6, (List<b.b>)Arrays.asList((Object[])new b.b[]{b7}));
        }
        this.a.c("io.presage.common.profig.schedule.ProfigAlarmReceiver");
        this.a.a();
    }
}

