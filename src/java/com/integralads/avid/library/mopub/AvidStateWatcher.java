/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.KeyguardManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.integralads.avid.library.mopub;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import java.util.Collection;
import java.util.Iterator;

public class AvidStateWatcher {
    public static final String CONTEXT_AVID_AD_SESSION_ID = "avidAdSessionId";
    public static final String CONTEXT_AVID_LIBRARY_VERSION = "avidLibraryVersion";
    public static final String CONTEXT_BUNDLE_IDENTIFIER = "bundleIdentifier";
    public static final String CONTEXT_PARTNER = "partner";
    public static final String CONTEXT_PARTNER_VERSION = "partnerVersion";
    private static AvidStateWatcher avidStateWatcher = new AvidStateWatcher();
    private Context context;
    private boolean isScreenOff;
    private boolean isStarted;
    private BroadcastReceiver receiver;
    private AvidStateWatcherListener stateWatcherListener;

    public static AvidStateWatcher getInstance() {
        return avidStateWatcher;
    }

    private void notifyScreenModeChanged() {
        boolean bl2 = true ^ this.isScreenOff;
        Iterator iterator = AvidAdSessionRegistry.getInstance().getInternalAvidAdSessions().iterator();
        while (iterator.hasNext()) {
            ((InternalAvidAdSession)iterator.next()).setScreenMode(bl2);
        }
    }

    private void onScreenModeChanged(boolean bl2) {
        if (this.isScreenOff != bl2) {
            this.isScreenOff = bl2;
            if (this.isStarted) {
                this.notifyScreenModeChanged();
                AvidStateWatcherListener avidStateWatcherListener = this.stateWatcherListener;
                if (avidStateWatcherListener != null) {
                    avidStateWatcherListener.onAppStateChanged(this.isActive());
                }
            }
        }
    }

    private void registerReceiver() {
        this.receiver = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent == null) {
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals((Object)intent.getAction())) {
                    AvidStateWatcher.this.onScreenModeChanged(true);
                    return;
                }
                if ("android.intent.action.USER_PRESENT".equals((Object)intent.getAction())) {
                    AvidStateWatcher.this.onScreenModeChanged(false);
                    return;
                }
                if ("android.intent.action.SCREEN_ON".equals((Object)intent.getAction()) && (keyguardManager = (KeyguardManager)context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                    AvidStateWatcher.this.onScreenModeChanged(false);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.context.registerReceiver(this.receiver, intentFilter);
    }

    private void unregisterReceiver() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.context;
        if (context != null && (broadcastReceiver = this.receiver) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.receiver = null;
        }
    }

    public AvidStateWatcherListener getStateWatcherListener() {
        return this.stateWatcherListener;
    }

    public void init(Context context) {
        this.unregisterReceiver();
        this.context = context;
        this.registerReceiver();
    }

    public boolean isActive() {
        return true ^ this.isScreenOff;
    }

    public void setStateWatcherListener(AvidStateWatcherListener avidStateWatcherListener) {
        this.stateWatcherListener = avidStateWatcherListener;
    }

    public void start() {
        this.isStarted = true;
        this.notifyScreenModeChanged();
    }

    public void stop() {
        this.unregisterReceiver();
        this.context = null;
        this.isStarted = false;
        this.isScreenOff = false;
        this.stateWatcherListener = null;
    }

    public static interface AvidStateWatcherListener {
        public void onAppStateChanged(boolean var1);
    }

}

