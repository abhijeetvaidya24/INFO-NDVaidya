/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.util.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.t;

public final class b
extends BroadcastReceiver {
    public Context a = null;
    public a b = null;
    private com.adincube.sdk.h.c.b c = null;
    private com.adincube.sdk.h.c.a d = null;
    private boolean e = false;
    private boolean f = false;

    public b(Context context, com.adincube.sdk.h.c.b b2, com.adincube.sdk.h.c.a a2) {
        this.a = context;
        this.c = b2;
        this.d = a2;
        this.f = t.a(this.a);
    }

    public final void a() {
        if (!this.e) {
            this.a.registerReceiver((BroadcastReceiver)this, new IntentFilter("android.intent.action.SCREEN_ON"));
            this.a.registerReceiver((BroadcastReceiver)this, new IntentFilter("android.intent.action.SCREEN_OFF"));
            this.e = true;
        }
    }

    public final void b() {
        if (this.e) {
            IllegalArgumentException illegalArgumentException2;
            block3 : {
                try {
                    this.a.unregisterReceiver((BroadcastReceiver)this);
                }
                catch (IllegalArgumentException illegalArgumentException2) {
                    if (illegalArgumentException2.getMessage() == null || !illegalArgumentException2.getMessage().startsWith("Receiver not registered")) break block3;
                }
                this.e = false;
                return;
            }
            throw illegalArgumentException2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onReceive(Context context, Intent intent) {
        boolean bl;
        try {
            bl = "android.intent.action.SCREEN_ON".equals((Object)intent.getAction());
        }
        catch (Throwable throwable) {
            new Object[1][0] = throwable;
            ErrorReportingHelper.report("ScreenStateManager.onReceive", this.c, this.d, throwable);
            return;
        }
        if (this.f != bl) {
            this.f = bl;
            if (this.b != null) {
                this.b.a(bl);
            }
        }
    }

    public static interface a {
        public void a(boolean var1);
    }

}

