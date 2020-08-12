/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Parcel
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.concurrent.LinkedBlockingQueue
 */
package com.startapp.common.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;

public final class b {
    private static volatile c a;

    public static b a() {
        return e.a;
    }

    public static boolean a(String string) {
        try {
            Class.forName((String)string);
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    public static a b(Context context) {
        if (b.b()) {
            return b.c(context);
        }
        return b.d(context);
    }

    public static boolean b() {
        return b.a("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    private static a c(Context context) {
        try {
            Method method = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class});
            Object[] arrobject = new Object[]{context.getApplicationContext()};
            Object object = method.invoke(null, arrobject);
            a a2 = new a((String)object.getClass().getMethod("getId", new Class[0]).invoke(object, new Object[0]), (Boolean)object.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(object, new Object[0]), "APP");
            return a2;
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static a d(Context context) {
        Throwable throwable2222;
        if (Looper.myLooper() == Looper.getMainLooper()) throw new IllegalStateException("Cannot be called from the main thread");
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        b b2 = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.getApplicationContext().bindService(intent, (ServiceConnection)b2, 1)) throw new IOException("Google Play connection failed");
        d d2 = new d(b2.a());
        a a2 = new a(d2.a(), d2.a(true), "DEVICE");
        context.getApplicationContext().unbindService((ServiceConnection)b2);
        return a2;
        {
            catch (Throwable throwable2222) {
            }
            catch (Exception exception) {}
            {
                throw exception;
            }
        }
        context.getApplicationContext().unbindService((ServiceConnection)b2);
        throw throwable2222;
    }

    /*
     * Exception decompiling
     */
    public c a(Context var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    protected void a(a a2) {
        b b2 = this;
        synchronized (b2) {
            a.a(a2.a());
            a.a(a2.b());
            a.b(a2.c());
            return;
        }
    }

    public static final class a {
        private final String a;
        private final boolean b;
        private final String c;

        a(String string, boolean bl, String string2) {
            this.a = string;
            this.b = bl;
            this.c = string2;
        }

        public String a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }
    }

    protected static final class b
    implements ServiceConnection {
        boolean a = false;
        private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);

        protected b() {
        }

        public IBinder a() {
            if (!this.a) {
                this.a = true;
                return (IBinder)this.b.take();
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put((Object)iBinder);
            }
            catch (InterruptedException interruptedException) {}
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class c {
        private String a = "";
        private String b = "";
        private boolean c = false;

        public String a() {
            c c2 = this;
            synchronized (c2) {
                String string = this.a;
                return string;
            }
        }

        public void a(String string) {
            c c2 = this;
            synchronized (c2) {
                this.a = string;
                return;
            }
        }

        public void a(boolean bl) {
            c c2 = this;
            synchronized (c2) {
                this.c = bl;
                return;
            }
        }

        public void b(String string) {
            c c2 = this;
            synchronized (c2) {
                this.b = string;
                return;
            }
        }

        public boolean b() {
            c c2 = this;
            synchronized (c2) {
                boolean bl = this.c;
                return bl;
            }
        }

        public String c() {
            c c2 = this;
            synchronized (c2) {
                String string = this.b;
                return string;
            }
        }
    }

    private static final class d
    implements IInterface {
        private IBinder a;

        public d(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() {
            Parcel parcel = Parcel.obtain();
            Parcel parcel2 = Parcel.obtain();
            try {
                parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, parcel, parcel2, 0);
                parcel2.readException();
                String string = parcel2.readString();
                return string;
            }
            finally {
                parcel2.recycle();
                parcel.recycle();
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean a(boolean bl) {
            Parcel parcel = Parcel.obtain();
            Parcel parcel2 = Parcel.obtain();
            try {
                parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean bl2 = true;
                int n2 = bl ? 1 : 0;
                parcel.writeInt(n2);
                this.a.transact(2, parcel, parcel2, 0);
                parcel2.readException();
                int n3 = parcel2.readInt();
                if (n3 != 0) {
                    return bl2;
                } else {
                    bl2 = false;
                }
                return bl2;
            }
            finally {
                parcel2.recycle();
                parcel.recycle();
            }
        }

        public IBinder asBinder() {
            return this.a;
        }
    }

    private static class e {
        private static final b a = new b();
    }

}

