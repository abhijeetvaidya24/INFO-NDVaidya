/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Message
 *  com.yandex.metrica.MetricaService
 *  com.yandex.metrica.YandexMetrica
 *  com.yandex.metrica.impl.bk
 *  com.yandex.metrica.impl.ob.dp$10
 *  com.yandex.metrica.impl.ob.dp$4$1
 *  com.yandex.metrica.impl.ob.dp$5
 *  com.yandex.metrica.impl.ob.dp$6
 *  com.yandex.metrica.impl.ob.dp$7
 *  com.yandex.metrica.impl.ob.dp$8
 *  com.yandex.metrica.impl.ob.dp$9
 *  com.yandex.metrica.impl.ob.l
 *  com.yandex.metrica.impl.ob.m
 *  com.yandex.metrica.impl.ob.n
 *  com.yandex.metrica.impl.ob.o
 *  com.yandex.metrica.impl.ob.p
 *  java.io.BufferedOutputStream
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.ServerSocket
 *  java.net.Socket
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.yandex.metrica.MetricaService;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.ob.dp;
import com.yandex.metrica.impl.ob.dq;
import com.yandex.metrica.impl.ob.ds;
import com.yandex.metrica.impl.ob.g;
import com.yandex.metrica.impl.ob.h;
import com.yandex.metrica.impl.ob.i;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.l;
import com.yandex.metrica.impl.ob.m;
import com.yandex.metrica.impl.ob.n;
import com.yandex.metrica.impl.ob.o;
import com.yandex.metrica.impl.ob.p;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class dp
implements Runnable {
    private final ServiceConnection a = new ServiceConnection(){

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private final Handler b = new Handler(Looper.getMainLooper()){

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 100) {
                return;
            }
            dp.this.e();
            try {
                dp.this.d.unbindService(dp.this.a);
                return;
            }
            catch (Exception exception) {
                YandexMetrica.getReporter((Context)dp.this.d, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("socket_unbind_has_thrown_exception");
                return;
            }
        }
    };
    private HashMap<String, c> c = new HashMap<String, c>(){
        {
            this.put((Object)"p", (Object)new 1(this));
        }
    };
    private final Context d;
    private boolean e;
    private ServerSocket f;
    private final dq g = new dq();
    private ds h;
    private Thread i;

    dp(Context context) {
        this.d = context;
        g.a().a(this, p.class, k.a(new 6(this)).a(new 5(this)).a());
        g.a().a(this, n.class, k.a(new 7(this)).a());
        g.a().a(this, l.class, k.a(new 8(this)).a());
        g.a().a(this, m.class, k.a(new 9(this)).a());
        g.a().a(this, o.class, k.a(new 10(this)).a());
    }

    static /* synthetic */ HashMap b(int n2) {
        return dp.c(n2);
    }

    static /* synthetic */ ds c(dp dp2) {
        return dp2.h;
    }

    private static HashMap<String, Object> c(int n2) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"port", (Object)String.valueOf((int)n2));
        return hashMap;
    }

    static /* synthetic */ dq d(dp dp2) {
        return dp2.g;
    }

    ServerSocket a(int n2) throws IOException {
        return new ServerSocket(n2);
    }

    public void a() {
        if (this.e) {
            this.b();
            Handler handler = this.b;
            handler.sendMessageDelayed(handler.obtainMessage(100), 1000L * this.h.a());
        }
    }

    void a(ds ds2) {
        this.h = ds2;
    }

    public void b() {
        this.b.removeMessages(100);
    }

    public void c() {
        dp dp2 = this;
        synchronized (dp2) {
            if (!this.e && this.h != null) {
                this.e = true;
                this.d();
                this.i = new Thread((Runnable)this);
                this.i.start();
            }
            return;
        }
    }

    void d() {
        Intent intent = new Intent(this.d, MetricaService.class);
        intent.setAction("com.yandex.metrica.ACTION_BIND_TO_LOCAL_SERVER");
        try {
            if (!this.d.bindService(intent, this.a, 1)) {
                YandexMetrica.getReporter((Context)this.d, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("socket_bind_has_failed");
            }
            return;
        }
        catch (Exception exception) {
            YandexMetrica.getReporter((Context)this.d, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("socket_bind_has_thrown_exception");
            return;
        }
    }

    public void e() {
        dp dp2 = this;
        synchronized (dp2) {
            try {
                this.e = false;
                if (this.i != null) {
                    this.i.interrupt();
                    this.i = null;
                }
                if (this.f != null) {
                    this.f.close();
                    this.f = null;
                }
                return;
            }
            catch (IOException iOException) {
                return;
            }
            finally {
            }
        }
    }

    /*
     * Exception decompiling
     */
    ServerSocket f() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl10 : ALOAD_2 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    /*
     * Exception decompiling
     */
    public void run() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl8 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    abstract class b {
        Uri b;
        Socket c;

        b(Map<String, String> map) {
            this.b = var1_1;
            this.c = map;
        }

        private static void a(OutputStream outputStream) throws IOException {
            outputStream.write("\r\n".getBytes());
        }

        private static void a(OutputStream outputStream, String string2, String string3) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            stringBuilder.append(string3);
            outputStream.write(stringBuilder.toString().getBytes());
            b.a(outputStream);
        }

        public abstract void a();

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        void a(String var1_1, Map<String, String> var2_2, byte[] var3_3) {
            block8 : {
                var4_4 = null;
                var5_5 = new BufferedOutputStream(this.c.getOutputStream());
                try {
                    var5_5.write(var1_1.getBytes());
                    b.a((OutputStream)var5_5);
                    for (Map.Entry var9_7 : var2_2.entrySet()) {
                        b.a((OutputStream)var5_5, (String)var9_7.getKey(), (String)var9_7.getValue());
                    }
                    b.a((OutputStream)var5_5, "Content-Length", String.valueOf((int)var3_3.length));
                    b.a((OutputStream)var5_5);
                    var5_5.write(var3_3);
                    var5_5.flush();
                    this.b();
                }
                catch (Throwable var7_8) {
                    break block8;
                }
                catch (IOException var6_11) {
                    var4_4 = var5_5;
                    ** GOTO lbl-1000
                }
                bk.a((Closeable)var5_5);
                return;
                catch (Throwable var7_9) {
                    var5_5 = var4_4;
                    break block8;
                }
                catch (IOException var6_12) {
                    // empty catch block
                }
lbl-1000: // 2 sources:
                {
                    this.a((Throwable)var6_13);
                }
                bk.a((Closeable)var4_4);
                return;
            }
            bk.a((Closeable)var5_5);
            throw var7_10;
        }

        protected void a(Throwable throwable) {
        }

        protected void b() {
        }
    }

    static abstract class c {
        c() {
        }

        public abstract b a(Uri var1, Socket var2);
    }

}

