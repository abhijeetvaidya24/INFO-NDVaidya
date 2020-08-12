/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class b {
    private static final int a = -1;
    private static final int b = 1;
    private static final int c;
    private final BroadcastReceiver d;
    private final Context e;
    private int f = -1;
    private b g;

    public b(Context context) {
        this.e = context.getApplicationContext();
        this.d = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                if (intent == null) {
                    return;
                }
                String string2 = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals((Object)string2)) {
                    b.this.a(true);
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals((Object)string2)) {
                    b.this.a(false);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.e.registerReceiver(this.d, intentFilter);
    }

    private void a(boolean n2) {
        if (n2 == this.f) {
            return;
        }
        this.f = n2;
        this.c();
    }

    private void c() {
        b b2 = this.g;
        if (b2 != null) {
            b2.onDeviceScreenStateChanged(this.a());
        }
    }

    public void a(b b2) {
        this.g = b2;
    }

    public boolean a() {
        return this.f != 0;
    }

    public void b() {
        this.a(null);
        this.e.unregisterReceiver(this.d);
    }

    public static class a {
        private static volatile a a;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static a a() {
            a a2 = a;
            if (a2 != null) {
                return a2;
            }
            Class<a> class_ = a.class;
            synchronized (a.class) {
                a a3 = a;
                if (a3 != null) return a3;
                return new a();
            }
        }

        @Deprecated
        public static void a(a a2) {
            a = a2;
        }

        public b a(Context context) {
            return new b(context);
        }
    }

    public static interface b {
        public void onDeviceScreenStateChanged(boolean var1);
    }

}

