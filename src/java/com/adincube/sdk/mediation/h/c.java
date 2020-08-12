/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.adincube.sdk.mediation.h;

import android.content.Context;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.util.d.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    com.adincube.sdk.util.d.b a = null;

    public c(b b2, Context context) {
        this.a = new com.adincube.sdk.util.d.b(b2.f().f(), context);
    }

    final void a() {
        this.a.a("android.permission.INTERNET");
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"android:exported", (Object)"false");
        hashMap.put((Object)"android:permission", (Object)"android.permission.BIND_JOB_SERVICE");
        this.a.b("com.avocarrot.sdk.CallbackJobService", (Map<String, String>)hashMap, null);
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"android:exported", (Object)"false");
        this.a.b("com.avocarrot.sdk.CallbackService", (Map<String, String>)hashMap2, null);
    }
}

