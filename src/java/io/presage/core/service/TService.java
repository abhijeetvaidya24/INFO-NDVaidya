/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  io.presage.core.service.TService$1
 */
package io.presage.core.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import io.presage.core.IllllllI;
import io.presage.core.lIIIlIII;
import io.presage.core.service.TService;

public class TService
extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        if (lIIIlIII.IIIIIIIl((Context)this)) {
            IllllllI.IIIIIIII((IllllllI.IIIIIIII)new 1(this));
        }
        return 1;
    }
}

