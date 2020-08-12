/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  com.google.android.gms.ads.MobileAds
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.c;

import android.annotation.SuppressLint;
import android.content.Context;
import com.adincube.sdk.util.s;
import com.google.android.gms.ads.MobileAds;

public class c {
    private static String c;
    private static boolean d;
    public Float a = null;
    private Context b = null;
    private boolean e = false;
    private boolean f = false;

    public c(Context context) {
        this.b = context;
    }

    public final c a(Boolean bl) {
        if (bl != null) {
            this.e = bl;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final c a(String string) {
        Class<c> class_ = c.class;
        synchronized (c.class) {
            if (c == null && string == null) {
                // ** MonitorExit[var3_2] (shouldn't be in output)
                return this;
            }
            if (string != null && !string.equals((Object)c)) {
                c = string;
                this.f = true;
            }
            // ** MonitorExit[var3_2] (shouldn't be in output)
            return this;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"MissingPermission"})
    public final void a() {
        Integer n2 = s.b(this.b);
        if (n2 == null) {
            return;
        }
        if (n2 < 9000000) {
            return;
        }
        Class<c> class_ = c.class;
        synchronized (c.class) {
            Float f2;
            if (!d || this.f) {
                d = true;
                MobileAds.initialize((Context)this.b.getApplicationContext(), (String)c);
            }
            // ** MonitorExit[var5_2] (shouldn't be in output)
            MobileAds.setAppMuted((boolean)this.e);
            float f3 = this.e ? 0.0f : 1.0f;
            MobileAds.setAppVolume((float)f3);
            if (!this.e && (f2 = this.a) != null) {
                MobileAds.setAppVolume((float)f2.floatValue());
            }
            return;
        }
    }
}

