/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.HashMap
 *  java.util.Queue
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.util.Log;
import com.adcolony.sdk.a;
import com.adcolony.sdk.aa;
import com.adcolony.sdk.af;
import com.adcolony.sdk.aj;
import com.adcolony.sdk.w;
import com.adcolony.sdk.x;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

class aa {
    static boolean a = false;
    static int i = 3;
    static JSONObject j = w.a();
    static int k = 1;
    static aj l;
    private static ExecutorService m;
    private static final Queue<Runnable> n;

    static {
        m = null;
        n = new ConcurrentLinkedQueue();
    }

    aa() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void a() {
        Queue<Runnable> queue;
        ExecutorService executorService = m;
        if (executorService == null || executorService.isShutdown() || m.isTerminated()) {
            m = Executors.newSingleThreadExecutor();
        }
        Queue<Runnable> queue2 = queue = n;
        synchronized (queue2) {
            while (!n.isEmpty()) {
                aa.a((Runnable)n.poll());
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void a(int n2, int n3, String string, boolean bl) {
        if (!aa.a(aa.b(n2, n3, string, bl))) {
            Queue<Runnable> queue;
            Queue<Runnable> queue2 = queue = n;
            synchronized (queue2) {
                n.add((Object)aa.b(n2, n3, string, bl));
                return;
            }
        }
    }

    static void a(int n2, String string, int n3) {
        if (l == null) {
            return;
        }
        if (n3 == 3 && aa.a(w.f(j, Integer.toString((int)n2)), 3)) {
            l.c(string);
            return;
        }
        if (n3 == 2 && aa.a(w.f(j, Integer.toString((int)n2)), 2)) {
            l.d(string);
            return;
        }
        if (n3 == 1 && aa.a(w.f(j, Integer.toString((int)n2)), 1)) {
            l.e(string);
            return;
        }
        if (n3 == 0 && aa.a(w.f(j, Integer.toString((int)n2)), 0)) {
            l.f(string);
        }
    }

    static void a(int n2, String string, boolean bl) {
        aa.a(0, n2, string, bl);
    }

    static void a(HashMap<String, Object> hashMap) {
        try {
            l = new aj(new x(new URL("https://wd.adcolony.com/logs")), Executors.newSingleThreadScheduledExecutor(), hashMap);
            l.a(5L, TimeUnit.SECONDS);
            return;
        }
        catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private static boolean a(Runnable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl19 : ICONST_0 : trying to set 1 previously set to 0
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

    static boolean a(JSONObject jSONObject, int n2) {
        int n3 = w.c(jSONObject, "send_level");
        if (jSONObject.length() == 0) {
            n3 = k;
        }
        return n3 >= n2 && n3 != 4;
    }

    static boolean a(JSONObject jSONObject, int n2, boolean bl) {
        int n3 = w.c(jSONObject, "print_level");
        boolean bl2 = w.d(jSONObject, "log_private");
        if (jSONObject.length() == 0) {
            n3 = i;
            bl2 = a;
        }
        if (bl && !bl2 || n3 == 4) {
            return false;
        }
        boolean bl3 = false;
        if (n3 >= n2) {
            bl3 = true;
        }
        return bl3;
    }

    private static Runnable b(final int n2, final int n3, final String string, final boolean bl) {
        return new Runnable(){

            public void run() {
                aa.a(n2, string, n3);
                int n22 = 0;
                while (n22 <= string.length() / 4000) {
                    int n32;
                    int n4 = n22 * 4000;
                    if ((n32 = ++n22 * 4000) > string.length()) {
                        n32 = string.length();
                    }
                    if (n3 == 3 && aa.a(w.f(aa.j, Integer.toString((int)n2)), 3, bl)) {
                        Log.d((String)"AdColony [TRACE]", (String)string.substring(n4, n32));
                        continue;
                    }
                    if (n3 == 2 && aa.a(w.f(aa.j, Integer.toString((int)n2)), 2, bl)) {
                        Log.i((String)"AdColony [INFO]", (String)string.substring(n4, n32));
                        continue;
                    }
                    if (n3 == 1 && aa.a(w.f(aa.j, Integer.toString((int)n2)), 1, bl)) {
                        Log.w((String)"AdColony [WARNING]", (String)string.substring(n4, n32));
                        continue;
                    }
                    if (n3 == 0 && aa.a(w.f(aa.j, Integer.toString((int)n2)), 0, bl)) {
                        Log.e((String)"AdColony [ERROR]", (String)string.substring(n4, n32));
                        continue;
                    }
                    if (n3 != -1 || aa.i < -1) continue;
                    Log.e((String)"AdColony [FATAL]", (String)string.substring(n4, n32));
                }
            }
        };
    }

    static void c() {
        a.a("Log.set_log_level", new af(){

            public void a(com.adcolony.sdk.ad ad2) {
                aa.i = w.c(ad2.c(), "level");
            }
        });
        a.a("Log.public.trace", new af(){

            public void a(com.adcolony.sdk.ad ad2) {
                aa.a(w.c(ad2.c(), "module"), 3, w.b(ad2.c(), "message"), false);
            }
        });
        a.a("Log.private.trace", new af(){

            public void a(com.adcolony.sdk.ad ad2) {
                aa.a(w.c(ad2.c(), "module"), 3, w.b(ad2.c(), "message"), true);
            }
        });
        a.a("Log.public.info", new af(){

            public void a(com.adcolony.sdk.ad ad2) {
                aa.a(w.c(ad2.c(), "module"), 2, w.b(ad2.c(), "message"), false);
            }
        });
        a.a("Log.private.info", new af(){

            public void a(com.adcolony.sdk.ad ad2) {
                aa.a(w.c(ad2.c(), "module"), 2, w.b(ad2.c(), "message"), true);
            }
        });
        a.a("Log.public.warning", new af(){

            public void a(com.adcolony.sdk.ad ad2) {
                aa.a(w.c(ad2.c(), "module"), 1, w.b(ad2.c(), "message"), false);
            }
        });
        a.a("Log.private.warning", new af(){

            public void a(com.adcolony.sdk.ad ad2) {
                aa.a(w.c(ad2.c(), "module"), 1, w.b(ad2.c(), "message"), true);
            }
        });
        a.a("Log.public.error", new af(){

            public void a(com.adcolony.sdk.ad ad2) {
                aa.a(w.c(ad2.c(), "module"), 0, w.b(ad2.c(), "message"), false);
            }
        });
        a.a("Log.private.error", new af(){

            public void a(com.adcolony.sdk.ad ad2) {
                aa.a(w.c(ad2.c(), "module"), 0, w.b(ad2.c(), "message"), true);
            }
        });
    }

    void a(JSONArray jSONArray) {
        j = this.b(jSONArray);
    }

    JSONObject b(JSONArray jSONArray) {
        JSONObject jSONObject = w.a();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject2 = w.d(jSONArray, i2);
            w.a(jSONObject, Integer.toString((int)w.c(jSONObject2, "id")), jSONObject2);
        }
        return jSONObject;
    }

}

