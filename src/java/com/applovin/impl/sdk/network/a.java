/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.applovin.impl.mediation.c.b
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.SocketTimeoutException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.net.UnknownHostException
 *  java.util.Locale
 *  org.json.JSONException
 *  org.json.JSONObject
 *  org.xml.sax.SAXException
 */
package com.applovin.impl.sdk.network;

import android.content.Context;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.e.i;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.p;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

public class a {
    private final j a;
    private final p b;

    public a(j j2) {
        this.a = j2;
        this.b = j2.u();
    }

    private int a(Throwable throwable) {
        if (throwable instanceof UnknownHostException) {
            return -103;
        }
        if (throwable instanceof SocketTimeoutException) {
            return -102;
        }
        if (throwable instanceof IOException) {
            String string2 = throwable.getMessage();
            if (string2 != null && string2.toLowerCase(Locale.ENGLISH).contains((CharSequence)"authentication challenge")) {
                return 401;
            }
            return -100;
        }
        if (throwable instanceof JSONException) {
            return -104;
        }
        return -1;
    }

    private HttpURLConnection a(String string2, String string3, int n2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(string2).openConnection();
        httpURLConnection.setRequestMethod(string3);
        int n3 = n2 < 0 ? this.a.a(com.applovin.impl.sdk.b.b.dM) : n2;
        httpURLConnection.setConnectTimeout(n3);
        if (n2 < 0) {
            n2 = this.a.a(com.applovin.impl.sdk.b.b.dN);
        }
        httpURLConnection.setReadTimeout(n2);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    private void a(int n2, String string2) {
        if (this.a.a(com.applovin.impl.sdk.b.b.ad).booleanValue()) {
            try {
                c.a(n2, string2, this.a.w());
                return;
            }
            catch (Throwable throwable) {
                p p2 = this.a.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to track response code for URL: ");
                stringBuilder.append(string2);
                p2.b("ConnectionManager", stringBuilder.toString(), throwable);
            }
        }
    }

    /*
     * Exception decompiling
     */
    private static void a(InputStream var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    private void a(String string2) {
        g g2;
        h h2;
        if (!com.applovin.impl.sdk.e.j.a(string2, f.e(this.a)) && !com.applovin.impl.sdk.e.j.a(string2, f.f(this.a))) {
            if (!com.applovin.impl.sdk.e.j.a(string2, com.applovin.impl.mediation.c.b.a((j)this.a)) && !com.applovin.impl.sdk.e.j.a(string2, com.applovin.impl.mediation.c.b.b((j)this.a))) {
                h2 = this.a.D();
                g2 = g.i;
            } else {
                h2 = this.a.D();
                g2 = g.q;
            }
        } else {
            h2 = this.a.D();
            g2 = g.h;
        }
        h2.a(g2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private <T> void a(String object, int n2, String string2, T object2, boolean bl, b<T> b2) throws JSONException {
        void var4_6;
        void var6_9;
        block11 : {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n2);
            stringBuilder.append(" received from \"");
            stringBuilder.append(string2);
            stringBuilder.append("\": ");
            stringBuilder.append((String)object);
            p2.a("ConnectionManager", stringBuilder.toString());
            if (n2 >= 200 && n2 < 300) {
                void var5_8;
                if (var5_8 != false) {
                    object = i.a((String)object, this.a.s());
                }
                boolean bl2 = object != null && object.length() > 2;
                if (n2 != 204 && bl2) {
                    StringBuilder stringBuilder2;
                    void var21_17;
                    p p3;
                    String string3;
                    try {
                        if (object2 instanceof String) break block10;
                        if (object2 instanceof n) {
                            object = o.a((String)object, this.a);
                            break block10;
                        }
                        if (object2 instanceof JSONObject) {
                            JSONObject jSONObject = new JSONObject((String)object);
                        } else {
                            p p4 = this.b;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Unable to handle '");
                            stringBuilder3.append(object2.getClass().getName());
                            stringBuilder3.append("'");
                            p4.d("ConnectionManager", stringBuilder3.toString());
                        }
                        break block11;
                    }
                    catch (SAXException sAXException) {
                        this.a(string2);
                        p3 = this.b;
                        stringBuilder2 = new StringBuilder();
                        string3 = "Invalid XML returned from \"";
                    }
                    catch (JSONException jSONException) {
                        this.a(string2);
                        p3 = this.b;
                        stringBuilder2 = new StringBuilder();
                        string3 = "Invalid JSON returned from \"";
                    }
                    stringBuilder2.append(string3);
                    stringBuilder2.append(string2);
                    stringBuilder2.append("\"");
                    p3.b("ConnectionManager", stringBuilder2.toString(), (Throwable)var21_17);
                }
            } else {
                block10 : {
                    p p5 = this.b;
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(n2);
                    stringBuilder4.append(" error received from \"");
                    stringBuilder4.append(string2);
                    stringBuilder4.append("\"");
                    p5.d("ConnectionManager", stringBuilder4.toString());
                    var6_9.a(n2);
                    return;
                }
                Object object3 = object;
            }
        }
        var6_9.a(var4_6, n2);
    }

    private void a(String string2, String string3, int n2, long l2) {
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Successful ");
        stringBuilder.append(string2);
        stringBuilder.append(" returned ");
        stringBuilder.append(n2);
        stringBuilder.append(" in ");
        stringBuilder.append((float)(System.currentTimeMillis() - l2) / 1000.0f);
        stringBuilder.append(" s over ");
        stringBuilder.append(f.d(this.a));
        stringBuilder.append(" to \"");
        stringBuilder.append(string3);
        stringBuilder.append("\"");
        p2.b("ConnectionManager", stringBuilder.toString());
    }

    private void a(String string2, String string3, int n2, long l2, Throwable throwable) {
        p p2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed ");
        stringBuilder.append(string2);
        stringBuilder.append(" returned ");
        stringBuilder.append(n2);
        stringBuilder.append(" in ");
        stringBuilder.append((float)(System.currentTimeMillis() - l2) / 1000.0f);
        stringBuilder.append(" s over ");
        stringBuilder.append(f.d(this.a));
        stringBuilder.append(" to \"");
        stringBuilder.append(string3);
        stringBuilder.append("\"");
        p2.b("ConnectionManager", stringBuilder.toString(), throwable);
    }

    /*
     * Exception decompiling
     */
    private static void a(HttpURLConnection var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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
    public <T> void a(com.applovin.impl.sdk.network.b<T> var1, a var2, b<T> var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl345 : ALOAD : trying to set 1 previously set to 0
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

    public static class a {
        private long a;
        private long b;

        private void a(long l2) {
            this.a = l2;
        }

        static /* synthetic */ void a(a a2, long l2) {
            a2.b(l2);
        }

        private void b(long l2) {
            this.b = l2;
        }

        static /* synthetic */ void b(a a2, long l2) {
            a2.a(l2);
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }
    }

    public static interface b<T> {
        public void a(int var1);

        public void a(T var1, int var2);
    }

}

