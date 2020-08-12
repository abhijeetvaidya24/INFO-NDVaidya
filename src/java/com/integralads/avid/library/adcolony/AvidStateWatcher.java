/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.KeyguardManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistry
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.integralads.avid.library.adcolony;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import java.util.Collection;
import java.util.Iterator;

public class AvidStateWatcher {
    private static AvidStateWatcher a = new AvidStateWatcher();
    private Context b;
    private BroadcastReceiver c;
    private boolean d;
    private boolean e;
    private AvidStateWatcherListener f;

    private void b() {
        this.c = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent == null) {
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals((Object)intent.getAction())) {
                    AvidStateWatcher.this.b(true);
                    return;
                }
                if ("android.intent.action.USER_PRESENT".equals((Object)intent.getAction())) {
                    AvidStateWatcher.this.b(false);
                    return;
                }
                if ("android.intent.action.SCREEN_ON".equals((Object)intent.getAction()) && (keyguardManager = (KeyguardManager)context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                    AvidStateWatcher.this.b(false);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.b.registerReceiver(this.c, intentFilter);
    }

    private void b(boolean bl2) {
        if (this.e != bl2) {
            this.e = bl2;
            if (this.d) {
                this.d();
                AvidStateWatcherListener avidStateWatcherListener = this.f;
                if (avidStateWatcherListener != null) {
                    avidStateWatcherListener.onAppStateChanged(this.isActive());
                }
            }
        }
    }

    private void c() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.b;
        if (context != null && (broadcastReceiver = this.c) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.c = null;
        }
    }

    private void d() {
        boolean bl2 = true ^ this.e;
        Iterator iterator = AvidAdSessionRegistry.getInstance().getInternalAvidAdSessions().iterator();
        while (iterator.hasNext()) {
            ((InternalAvidAdSession)iterator.next()).setScreenMode(bl2);
        }
    }

    public static AvidStateWatcher getInstance() {
        return a;
    }

    public void init(Context context) {
        this.c();
        this.b = context;
        this.b();
    }

    public boolean isActive() {
        return true ^ this.e;
    }

    public void setStateWatcherListener(AvidStateWatcherListener avidStateWatcherListener) {
        this.f = avidStateWatcherListener;
    }

    public void start() {
        this.d = true;
        this.d();
    }

    public void stop() {
        this.c();
        this.b = null;
        this.d = false;
        this.e = false;
        this.f = null;
    }

    public static interface AvidStateWatcherListener {
        public void onAppStateChanged(boolean var1);
    }

}

