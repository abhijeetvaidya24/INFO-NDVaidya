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
package com.ogury.consent.manager;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import com.ogury.consent.manager.cocoartf1671;
import com.ogury.consent.manager.cocoasubrtf100;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.tx720;
import java.io.IOException;

public final class red255 {
    public static final red255 a = new red255();

    private red255() {
    }

    public static tx720 a(Context context) throws Exception {
        tx6480.b((Object)context, "context");
        if (!tx6480.a((Object)Looper.myLooper(), (Object)Looper.getMainLooper())) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
            }
            catch (Exception exception) {
                throw (Throwable)exception;
            }
            return red255.b(context);
        }
        throw (Throwable)new IllegalStateException("Cannot be called from the main thread");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static tx720 b(Context context) throws Exception {
        Throwable throwable2222;
        cocoartf1671 cocoartf16712 = new cocoartf1671();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        ServiceConnection serviceConnection = cocoartf16712;
        if (!context.bindService(intent, serviceConnection, 1)) throw (Throwable)new IOException("Google Play connection failed");
        cocoasubrtf100 cocoasubrtf1002 = new cocoasubrtf100(cocoartf16712.a());
        tx720 tx7202 = new tx720(cocoasubrtf1002.a(), cocoasubrtf1002.a(true));
        context.unbindService(serviceConnection);
        return tx7202;
        {
            catch (Throwable throwable2222) {
            }
            catch (Exception exception) {}
            {
                throw (Throwable)exception;
            }
        }
        context.unbindService(serviceConnection);
        throw throwable2222;
    }
}

