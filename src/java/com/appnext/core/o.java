/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 */
package com.appnext.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.appnext.core.AdsService;

public abstract class o {
    private ServiceConnection mConnection = new ServiceConnection(){

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            o.this.mMessenger = new Messenger(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            o.this.mMessenger = null;
        }
    };
    private Messenger mMessenger;

    protected static Class<?> bk() {
        return AdsService.class;
    }

    public void a(Context context) {
        try {
            context.unbindService(this.mConnection);
            this.mMessenger = null;
            this.mConnection = null;
        }
        catch (Throwable throwable) {}
    }

    protected abstract void a(Intent var1);

    public final void t(Context context) {
        Intent intent = new Intent(context, AdsService.class);
        this.a(intent);
        try {
            context.getApplicationContext().bindService(intent, this.mConnection, 1);
            Message message = Message.obtain(null, (int)8348, (int)0, (int)0);
            message.setData(intent.getExtras());
            this.mMessenger.send(message);
            return;
        }
        catch (Throwable throwable) {
            context.startService(intent);
            return;
        }
    }

}

