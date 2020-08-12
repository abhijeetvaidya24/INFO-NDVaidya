/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.adsCommon.i;

import android.os.Bundle;

public class b {
    private final Bundle a;

    public b(Bundle bundle) {
        this.a = bundle;
    }

    public String a() {
        return this.a.getString("install_referrer");
    }

    public long b() {
        return this.a.getLong("referrer_click_timestamp_seconds");
    }

    public long c() {
        return this.a.getLong("install_begin_timestamp_seconds");
    }
}

