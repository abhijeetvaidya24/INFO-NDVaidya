/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.util.Log
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.LinkedBlockingQueue
 */
package com.ogury.consent.manager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.vieww10800;
import java.util.concurrent.LinkedBlockingQueue;

public final class cocoartf1671
implements ServiceConnection {
    private final LinkedBlockingQueue<IBinder> a = new LinkedBlockingQueue(1);
    private boolean b;

    public final IBinder a() throws InterruptedException {
        if (!this.b) {
            this.b = true;
            Object object = this.a.take();
            if (object != null) {
                return (IBinder)object;
            }
            throw new vieww10800("null cannot be cast to non-null type android.os.IBinder");
        }
        throw (Throwable)new IllegalStateException();
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        tx6480.b((Object)componentName, "name");
        tx6480.b((Object)iBinder, "service");
        try {
            this.a.put((Object)iBinder);
            return;
        }
        catch (InterruptedException interruptedException) {
            Log.d((String)"service", (String)"intrerrupted");
            return;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        tx6480.b((Object)componentName, "name");
    }
}

