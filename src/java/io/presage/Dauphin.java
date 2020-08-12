/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.LinkedBlockingQueue
 */
package io.presage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.presage.ak;
import java.util.concurrent.LinkedBlockingQueue;

public final class Dauphin
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
            throw new ak("null cannot be cast to non-null type android.os.IBinder");
        }
        throw (Throwable)new IllegalStateException();
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.a.put((Object)iBinder);
            return;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}

