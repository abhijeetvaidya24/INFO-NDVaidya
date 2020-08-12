/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.job.JobService
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import io.presage.core.IIIIIlII;
import io.presage.core.IllllllI;
import io.presage.core.activity.ABActivity;
import io.presage.core.lIIIIIll;
import io.presage.core.lIIIlIlI;

public abstract class lIIlllll
extends JobService {
    private BroadcastReceiver IIIIIIII;

    static /* synthetic */ void IIIIIIII(Context context) {
        if (context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, ABActivity.class)) == 1) {
            Intent intent = new Intent(context, ABActivity.class);
            intent.setFlags(1350565888);
            context.startActivity(intent);
        }
    }

    public void onCreate() {
        this.IIIIIIII = new BroadcastReceiver(){

            public final void onReceive(Context context, Intent intent) {
                if (intent == null) {
                    return;
                }
                if (intent.getAction() == null) {
                    return;
                }
                if (intent.getAction().equals((Object)"android.intent.action.USER_PRESENT")) {
                    IllllllI.IIIIIIII(1004, lIIIlIlI.IIllIlIl.IIIIlIII);
                    IIIIIlII.IIIIIIII(context).IIIIIIII();
                    return;
                }
                if (intent.getAction().equals((Object)"android.intent.action.SCREEN_OFF")) {
                    IllllllI.IIIIIIII(1004, lIIIlIlI.IIllIlIl.IIIIlIlI);
                    IIIIIlII.IIIIIIII(context).IIIIIIIl();
                    if (Build.VERSION.SDK_INT >= 26) {
                        lIIlllll.IIIIIIII(context);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.registerReceiver(this.IIIIIIII, intentFilter);
        if (lIIIIIll.IIIIIIlI((Context)this)) {
            IllllllI.IIIIIIII(1004, lIIIlIlI.IIllIlIl.IIIIllIl);
            IIIIIlII.IIIIIIII((Context)this).IIIIIIII();
            return;
        }
        if (lIIIIIll.IIIIIIIl((Context)this)) {
            IllllllI.IIIIIIII(1004, lIIIlIlI.IIllIlIl.IIIIlllI);
            IIIIIlII.IIIIIIII((Context)this).IIIIIIIl();
        }
    }

    public void onDestroy() {
        try {
            this.unregisterReceiver(this.IIIIIIII);
        }
        catch (IllegalArgumentException illegalArgumentException) {}
    }

}

