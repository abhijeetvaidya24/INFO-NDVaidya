/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  java.io.BufferedInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.content.Context;
import android.content.res.AssetManager;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.n;
import com.adcolony.sdk.w;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class p
implements Runnable {
    String a = "";
    String b = "";
    boolean c;
    int d;
    int e;
    private HttpURLConnection f;
    private InputStream g;
    private ad h;
    private a i;
    private final int j = 4096;
    private String k;
    private int l = 0;
    private boolean m = false;
    private Map<String, List<String>> n;
    private String o = "";

    p(ad ad2, a a2) {
        this.h = ad2;
        this.i = a2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private boolean a(InputStream inputStream, OutputStream outputStream) throws Exception {
        BufferedInputStream bufferedInputStream;
        Throwable throwable;
        block16 : {
            Exception exception;
            block15 : {
                block14 : {
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        int n2;
                        byte[] arrby = new byte[4096];
                        while ((n2 = bufferedInputStream.read(arrby, 0, 4096)) != -1) {
                            this.d = n2 + this.d;
                            if (this.m && this.d > this.l) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Data exceeds expected maximum (");
                                stringBuilder.append(this.d);
                                stringBuilder.append("/");
                                stringBuilder.append(this.l);
                                stringBuilder.append("): ");
                                stringBuilder.append(this.f.getURL().toString());
                                throw new Exception(stringBuilder.toString());
                            }
                            outputStream.write(arrby, 0, n2);
                        }
                        String string = "UTF-8";
                        if (this.k != null && !this.k.isEmpty()) {
                            string = this.k;
                        }
                        if (outputStream instanceof ByteArrayOutputStream) {
                            this.b = ((ByteArrayOutputStream)outputStream).toString(string);
                        }
                        if (outputStream == null) break block14;
                    }
                    catch (Exception exception2) {
                        break block15;
                    }
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                bufferedInputStream.close();
                return true;
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    bufferedInputStream = null;
                    break block16;
                }
                catch (Exception exception3) {
                    bufferedInputStream = null;
                    exception = exception3;
                }
            }
            try {
                throw exception;
            }
            catch (Throwable throwable3) {
                // empty catch block
            }
        }
        if (outputStream != null) {
            outputStream.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (bufferedInputStream == null) throw throwable;
        bufferedInputStream.close();
        throw throwable;
    }

    private boolean b() throws IOException {
        boolean bl;
        block12 : {
            block11 : {
                JSONObject jSONObject = this.h.c();
                String string = w.b(jSONObject, "content_type");
                String string2 = w.b(jSONObject, "content");
                boolean bl2 = w.d(jSONObject, "no_redirect");
                this.a = w.b(jSONObject, "url");
                this.o = w.b(jSONObject, "filepath");
                this.k = w.b(jSONObject, "encoding");
                this.l = w.a(jSONObject, "max_size", 0);
                boolean bl3 = this.l != 0;
                this.m = bl3;
                this.d = 0;
                this.g = null;
                this.f = null;
                this.n = null;
                if (this.a.startsWith("file://")) {
                    if (this.a.startsWith("file:///android_asset/")) {
                        Context context = com.adcolony.sdk.a.c();
                        if (context != null) {
                            this.g = context.getAssets().open(this.a.substring(22));
                        }
                    } else {
                        this.g = new FileInputStream(this.a.substring(7));
                    }
                } else {
                    this.f = (HttpURLConnection)new URL(this.a).openConnection();
                    this.f.setInstanceFollowRedirects(bl2 ^ true);
                    this.f.setRequestProperty("Accept-Charset", "UTF-8");
                    this.f.setRequestProperty("User-Agent", com.adcolony.sdk.a.a().m().E());
                    if (!string.equals((Object)"")) {
                        this.f.setRequestProperty("Content-Type", string);
                    }
                    if (this.h.d().equals((Object)"WebServices.post")) {
                        this.f.setDoOutput(true);
                        this.f.setFixedLengthStreamingMode(string2.getBytes("UTF-8").length);
                        new PrintStream(this.f.getOutputStream()).print(string2);
                    }
                }
                if (this.f != null) break block11;
                InputStream inputStream = this.g;
                bl = false;
                if (inputStream == null) break block12;
            }
            bl = true;
        }
        return bl;
    }

    private boolean c() throws Exception {
        Object object;
        String string = this.h.d();
        if (this.g != null) {
            object = this.o.length() == 0 ? new ByteArrayOutputStream(4096) : new FileOutputStream(new File(this.o).getAbsolutePath());
        } else if (string.equals((Object)"WebServices.download")) {
            this.g = this.f.getInputStream();
            object = new FileOutputStream(this.o);
        } else if (string.equals((Object)"WebServices.get")) {
            this.g = this.f.getInputStream();
            object = new ByteArrayOutputStream(4096);
        } else if (string.equals((Object)"WebServices.post")) {
            this.f.connect();
            InputStream inputStream = this.f.getResponseCode() == 200 ? this.f.getInputStream() : this.f.getErrorStream();
            this.g = inputStream;
            object = new ByteArrayOutputStream(4096);
        } else {
            object = null;
        }
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            this.e = httpURLConnection.getResponseCode();
            this.n = this.f.getHeaderFields();
        }
        return this.a(this.g, (OutputStream)object);
    }

    ad a() {
        return this.h;
    }

    /*
     * Exception decompiling
     */
    public void run() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl133 : ICONST_1 : trying to set 1 previously set to 0
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

    static interface a {
        public void a(p var1, ad var2, Map<String, List<String>> var3);
    }

}

