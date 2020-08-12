/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  io.presage.mraid.browser.listeners.CloseSystemDialogsListener
 *  io.presage.mraid.browser.listeners.CloseSystemDialogsListener$1
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.presage.Stilton;
import io.presage.mraid.browser.listeners.CloseSystemDialogsListener;

public final class TommedeYenne {
    private final BroadcastReceiver a;
    private final Context b;
    private final Stilton c;

    public TommedeYenne(Context context, Stilton stilton) {
        this.b = context;
        this.c = stilton;
        this.a = (BroadcastReceiver)new CloseSystemDialogsListener.1(this);
        this.b();
    }

    public static final /* synthetic */ void a(TommedeYenne tommedeYenne) {
        tommedeYenne.c();
    }

    private final void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.b.registerReceiver(this.a, intentFilter);
    }

    private final void c() {
        this.c.a();
    }

    public final void a() {
        this.b.unregisterReceiver(this.a);
    }
}

