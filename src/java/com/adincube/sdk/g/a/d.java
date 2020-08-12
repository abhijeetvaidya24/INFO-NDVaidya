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
 *  com.adincube.sdk.g.a.a
 *  com.adincube.sdk.g.a.d$a
 *  com.adincube.sdk.g.a.d$b
 *  com.adincube.sdk.h.a
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.LinkedBlockingQueue
 */
package com.adincube.sdk.g.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import com.adincube.sdk.g.a.d;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Exception performing whole class analysis.
 */
public final class d
implements com.adincube.sdk.g.a.a {
    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final com.adincube.sdk.h.a a(Context context) {
        Throwable throwable2222;
        a a2;
        block8 : {
            block7 : {
                if (Looper.myLooper() == Looper.getMainLooper()) throw new IllegalStateException("Cannot be called from the main thread");
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                }
                catch (Exception exception) {
                    throw new RuntimeException((Throwable)exception);
                }
                a2 = new /* Unavailable Anonymous Inner Class!! */;
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (!context.bindService(intent, (ServiceConnection)a2, 1)) throw new RuntimeException("Google Play connection failed");
                if (a2.a) break block7;
                a2.a = true;
                b b2 = new /* Unavailable Anonymous Inner Class!! */;
                com.adincube.sdk.h.a a3 = new com.adincube.sdk.h.a(b2.a(), b2.b());
                context.unbindService((ServiceConnection)a2);
                return a3;
            }
            try {
                throw new IllegalStateException();
            }
            catch (Throwable throwable2222) {
                break block8;
            }
            catch (Exception exception) {
                throw new RuntimeException((Throwable)exception);
            }
        }
        context.unbindService((ServiceConnection)a2);
        throw throwable2222;
    }
}

