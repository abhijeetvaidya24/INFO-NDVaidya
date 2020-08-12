/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.util.concurrent.LinkedBlockingQueue
 */
package io.presage.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

final class lIIlIlII
implements ServiceConnection {
    LinkedBlockingQueue<IBinder> IIIIIIII = new LinkedBlockingQueue(1);
    boolean IIIIIIIl = false;

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.IIIIIIII.put((Object)iBinder);
        }
        catch (InterruptedException interruptedException) {}
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}

