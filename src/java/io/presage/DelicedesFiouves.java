/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.os.IBinder
 *  android.os.Looper
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.presage;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import io.presage.CureNantais;
import io.presage.Dauphin;
import io.presage.Echourgnacalaliqueurdenoix;
import io.presage.cl;
import java.io.IOException;

public final class DelicedesFiouves {
    public static final DelicedesFiouves a = new DelicedesFiouves();

    private DelicedesFiouves() {
    }

    public static CureNantais a(Context context) throws Exception {
        DelicedesFiouves.a();
        DelicedesFiouves.b(context);
        Dauphin dauphin = new Dauphin();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        ServiceConnection serviceConnection = dauphin;
        if (context.bindService(intent, serviceConnection, 1)) {
            try {
                Echourgnacalaliqueurdenoix echourgnacalaliqueurdenoix = new Echourgnacalaliqueurdenoix(dauphin.a());
                CureNantais cureNantais = new CureNantais(echourgnacalaliqueurdenoix.a(), echourgnacalaliqueurdenoix.b());
                return cureNantais;
            }
            finally {
                context.unbindService(serviceConnection);
            }
        }
        throw (Throwable)new IOException("Google Play connection failed");
    }

    private static void a() {
        if (!cl.a((Object)Looper.myLooper(), (Object)Looper.getMainLooper())) {
            return;
        }
        throw (Throwable)new IllegalStateException("Cannot be called from the main thread");
    }

    private static void b(Context context) {
        if (!DelicedesFiouves.c(context)) {
            return;
        }
        throw (Throwable)new IllegalStateException("Google play is not installed");
    }

    private static boolean c(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            return false;
        }
        catch (Exception exception) {
            return true;
        }
    }
}

