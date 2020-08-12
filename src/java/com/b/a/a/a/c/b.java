/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.KeyguardManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  com.b.a.a.a.b.i
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.b.a.a.a.c;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.b.a.a.a.b.i;
import java.util.Collection;
import java.util.Iterator;

public class b {
    @SuppressLint(value={"StaticFieldLeak"})
    private static b a = new b();
    private Context b;
    private BroadcastReceiver c;
    private boolean d;
    private boolean e;
    private a f;

    private b() {
    }

    public static b a() {
        return a;
    }

    private void a(boolean bl) {
        if (this.e != bl) {
            this.e = bl;
            if (this.d) {
                this.g();
                a a2 = this.f;
                if (a2 != null) {
                    a2.a(this.d());
                }
            }
        }
    }

    private void e() {
        this.c = new BroadcastReceiver(){

            /*
             * Enabled aggressive block sorting
             */
            public void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent == null) {
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals((Object)intent.getAction())) {
                    b.this.a(true);
                    return;
                }
                if ("android.intent.action.USER_PRESENT".equals((Object)intent.getAction()) || "android.intent.action.SCREEN_ON".equals((Object)intent.getAction()) && (keyguardManager = (KeyguardManager)context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                    b.this.a(false);
                    return;
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.b.registerReceiver(this.c, intentFilter);
    }

    private void f() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.b;
        if (context != null && (broadcastReceiver = this.c) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.c = null;
        }
    }

    private void g() {
        boolean bl = true ^ this.e;
        Iterator iterator = com.b.a.a.a.c.a.a().b().iterator();
        while (iterator.hasNext()) {
            ((i)iterator.next()).f().a(bl);
        }
    }

    public void a(Context context) {
        this.b = context.getApplicationContext();
    }

    public void a(a a2) {
        this.f = a2;
    }

    public void b() {
        this.e();
        this.d = true;
        this.g();
    }

    public void c() {
        this.f();
        this.d = false;
        this.e = false;
        this.f = null;
    }

    public boolean d() {
        return true ^ this.e;
    }

    public static interface a {
        public void a(boolean var1);
    }

}

