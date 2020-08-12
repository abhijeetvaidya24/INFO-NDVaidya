/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.mediabrix.android.api.MediabrixAPI
 *  java.lang.Class
 *  java.lang.Object
 */
package com.adincube.sdk.mediation.mediabrix;

import android.content.Context;
import com.mediabrix.android.api.MediabrixAPI;

public class a {
    private static a b;
    private int a = 0;

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        if (b != null) return b;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (b != null) return b;
            b = new a();
            // ** MonitorExit[var1] (shouldn't be in output)
            return b;
        }
    }

    public final void a(Context context) {
        a a2 = this;
        synchronized (a2) {
            this.a = 1 + this.a;
            if (this.a == 1) {
                new Object[1][0] = this.a;
                MediabrixAPI.getInstance().onResume(context.getApplicationContext());
                return;
            }
            new Object[1][0] = this.a;
            MediabrixAPI.getInstance().onPause(context.getApplicationContext());
            MediabrixAPI.getInstance().onResume(context.getApplicationContext());
            return;
        }
    }

    public final void b(Context context) {
        a a2 = this;
        synchronized (a2) {
            --this.a;
            if (this.a <= 0) {
                this.a = 0;
                MediabrixAPI.getInstance().onPause(context.getApplicationContext());
                return;
            }
            new Object[1][0] = this.a;
            MediabrixAPI.getInstance().onPause(context.getApplicationContext());
            MediabrixAPI.getInstance().onResume(context.getApplicationContext());
            return;
        }
    }
}

