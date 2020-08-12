/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  io.presage.mraid.browser.listeners.OrientationListener
 *  io.presage.mraid.browser.listeners.OrientationListener$1
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import io.presage.Stilton;
import io.presage.cl;
import io.presage.mraid.browser.listeners.OrientationListener;

public final class TommeMarcdeRaisin {
    private int a;
    private final BroadcastReceiver b;
    private final Context c;
    private final Stilton d;

    public TommeMarcdeRaisin(Context context, Stilton stilton) {
        this.c = context;
        this.d = stilton;
        Resources resources = this.c.getResources();
        cl.a((Object)resources, "context.resources");
        this.a = resources.getConfiguration().orientation;
        this.b = (BroadcastReceiver)new OrientationListener.1(this);
        this.b();
    }

    public static final /* synthetic */ int a(TommeMarcdeRaisin tommeMarcdeRaisin) {
        return tommeMarcdeRaisin.a;
    }

    public static final /* synthetic */ void a(TommeMarcdeRaisin tommeMarcdeRaisin, int n2) {
        tommeMarcdeRaisin.a = n2;
    }

    private final void b() {
        this.c.registerReceiver(this.b, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    public static final /* synthetic */ void b(TommeMarcdeRaisin tommeMarcdeRaisin) {
        tommeMarcdeRaisin.c();
    }

    private final void c() {
        String string2 = this.d();
        this.d.a(string2);
    }

    private final String d() {
        int n2 = this.a;
        if (n2 != 1) {
            if (n2 != 2) {
                return "unknown";
            }
            return "landscape";
        }
        return "portrait";
    }

    public final void a() {
        this.c.unregisterReceiver(this.b);
    }
}

