/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.IBinder
 *  io.presage.core.service.MCService$1
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package io.presage.core.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import io.presage.core.IIIIIIII;
import io.presage.core.IIIIIIIl;
import io.presage.core.IIIIIIlI;
import io.presage.core.IIIIIIll;
import io.presage.core.IllllllI;
import io.presage.core.lIIIlIlI;
import io.presage.core.service.MCService;

public class MCService
extends Service {
    private BroadcastReceiver IIIIIIII;
    private boolean IIIIIIIl;
    private IIIIIIll.IIIIIIII IIIIIIlI;
    private Handler IIIIIIll;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        this.IIIIIIll = new Handler();
        this.IIIIIIIl = true;
        this.IIIIIIlI = new 1(this);
        this.IIIIIIII = new BroadcastReceiver(){

            public final void onReceive(Context context, Intent intent) {
                new Object[1][0] = intent.getAction();
                MCService.this.IIIIIIll.postDelayed(new Runnable(){

                    public final void run() {
                        IllllllI.IIIIIIII(1004, lIIIlIlI.IIllIlIl.IIIIlIlI);
                        IIIIIIll.IIIIIIII((Context)MCService.this).IIIIIIII();
                        MCService.this.IIIIIIIl = false;
                        MCService.this.stopSelf();
                    }
                }, 50L);
            }

        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        this.registerReceiver(this.IIIIIIII, intentFilter);
    }

    public void onDestroy() {
        try {
            this.unregisterReceiver(this.IIIIIIII);
        }
        catch (IllegalArgumentException illegalArgumentException) {}
        if (this.IIIIIIIl) {
            IIIIIIll.IIIIIIII((Context)this).IIIIIIII();
        }
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        this.IIIIIIll.postDelayed(new Runnable(){

            public final void run() {
                try {
                    IIIIIIll.IIIIIIII((Context)MCService.this).IIIIIIII(IIIIIIII.IIIIIIII((Context)MCService.this).IIIIIIIl, MCService.this.IIIIIIlI);
                }
                catch (IIIIIIIl iIIIIIIl) {}
            }
        }, 50L);
        return 1;
    }

}

