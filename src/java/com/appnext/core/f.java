/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.Pair
 *  android.webkit.CookieManager
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  com.appnext.core.AppnextAd
 *  java.io.BufferedWriter
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.PrintWriter
 *  java.io.PushbackInputStream
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.CookieHandler
 *  java.net.CookieManager
 *  java.net.HttpRetryException
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.net.URLEncoder
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Random
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.zip.GZIPInputStream
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.appnext.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.appnext.base.b.d;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.p;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    private static final boolean DEBUG = false;
    public static final String VID = "2.5.0.472";
    static final int fd = 8000;
    private static final String gS = "expiredTimems";
    private static double gT;
    private static HashMap<String, Bitmap> gU;
    private static String gV;
    private static String gW;
    private static String gX;
    public static final Executor gY;

    static {
        CookieHandler.setDefault((CookieHandler)new CookieManager());
        gT = -1.0;
        gV = "";
        gW = "";
        gX = "";
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1 + Runtime.getRuntime().availableProcessors(), 1 + 2 * Runtime.getRuntime().availableProcessors(), 1L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue(128), new ThreadFactory(){
            private final AtomicInteger gZ = new AtomicInteger(1);

            public final Thread newThread(Runnable runnable) {
                StringBuilder stringBuilder = new StringBuilder("AsyncTask #");
                stringBuilder.append(this.gZ.getAndIncrement());
                return new Thread(runnable, stringBuilder.toString());
            }
        });
        gY = threadPoolExecutor;
        gU = new HashMap();
    }

    private static void W(String string2) {
        gV = string2;
    }

    /*
     * Exception decompiling
     */
    private static boolean X(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl29.1 : ICONST_0 : trying to set 1 previously set to 0
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

    private static boolean Y(String string2) {
        JSONObject jSONObject;
        block3 : {
            try {
                jSONObject = new JSONObject(string2);
                if (jSONObject.has(gS)) break block3;
                return true;
            }
            catch (Throwable throwable) {
                return true;
            }
        }
        long l2 = jSONObject.getLong(gS);
        long l3 = System.currentTimeMillis();
        return l3 >= l2;
    }

    /*
     * Exception decompiling
     */
    public static Bitmap Z(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl104 : ALOAD_2 : trying to set 1 previously set to 0
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

    public static int a(Context context, float f2) {
        return (int)(f2 * ((float)context.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    public static InputStream a(InputStream inputStream) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 2);
        byte[] arrby = new byte[2];
        try {
            pushbackInputStream.unread(arrby, 0, pushbackInputStream.read(arrby));
        }
        catch (Throwable throwable) {
            return inputStream;
        }
        if (arrby[0] == 31 && arrby[1] == -117) {
            return new GZIPInputStream((InputStream)pushbackInputStream);
        }
        return pushbackInputStream;
    }

    public static String a(String string2, ArrayList<Pair<String, String>> arrayList) throws IOException {
        return f.a(string2, arrayList, 8000);
    }

    public static String a(String string2, ArrayList<Pair<String, String>> arrayList, int n2) throws IOException {
        return new String(f.b(string2, arrayList, true, n2, d.a.ArrayList), "UTF-8");
    }

    public static String a(String string2, HashMap<String, String> hashMap) throws IOException {
        return f.a(string2, hashMap, true, 8000);
    }

    public static String a(String string2, HashMap<String, String> hashMap, int n2) throws IOException {
        return f.a(string2, null, true, n2);
    }

    public static String a(String string2, HashMap<String, String> hashMap, boolean bl) throws IOException {
        return f.a(string2, hashMap, bl, 8000);
    }

    public static String a(String string2, HashMap<String, String> hashMap, boolean bl, int n2) throws IOException {
        return new String(f.b(string2, hashMap, bl, n2, d.a.HashMap), "UTF-8");
    }

    private static void a(final Context context, final String string2, final String string3, final String string4, final String string5, final String string6, final String string7, final String string8, final String string9) {
        try {
            Runnable runnable = new Runnable(){

                /*
                 * Exception decompiling
                 */
                public final void run() {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl8 : ALOAD_1 : trying to set 1 previously set to 0
                    // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                    // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                    // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                    // org.benf.cfr.reader.entities.g.p(Method.java:396)
                    // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                    // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                    // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
            };
            new Thread(runnable).start();
        }
        catch (Throwable throwable) {}
    }

    public static void a(final Ad ad, final AppnextAd appnextAd, final String string2, final String string3, final p p2) {
        Runnable runnable = new Runnable(){

            public final void run() {
                try {
                    if (!Boolean.parseBoolean((String)p2.get("stp_flag"))) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(System.currentTimeMillis());
                    arrayList.add((Object)new Pair((Object)"client_date", (Object)stringBuilder.toString()));
                    arrayList.add((Object)new Pair((Object)"did", (Object)f.b(ad.getContext(), true)));
                    arrayList.add((Object)new Pair((Object)"session_id", (Object)appnextAd.getSession()));
                    arrayList.add((Object)new Pair((Object)"tid", (Object)ad.getTID()));
                    arrayList.add((Object)new Pair((Object)"vid", (Object)ad.getVID()));
                    arrayList.add((Object)new Pair((Object)"auid", (Object)ad.getAUID()));
                    arrayList.add((Object)new Pair((Object)"osid", (Object)"100"));
                    arrayList.add((Object)new Pair((Object)"tem_id", (Object)string3));
                    arrayList.add((Object)new Pair((Object)"pid", (Object)ad.getPlacementID()));
                    arrayList.add((Object)new Pair((Object)"banner_id", (Object)appnextAd.getBannerID()));
                    arrayList.add((Object)new Pair((Object)"cm_id", (Object)appnextAd.getCampaignID()));
                    arrayList.add((Object)new Pair((Object)"event_name", (Object)string2));
                    arrayList.add((Object)new Pair((Object)"package_id", (Object)ad.getContext().getPackageName()));
                    f.a("https://global.appnext.com/stp.aspx", (ArrayList<Pair<String, String>>)arrayList, 8000);
                }
                catch (Throwable throwable) {}
            }
        };
        new Thread(runnable).start();
    }

    public static void a(File file) {
        if (file.isDirectory()) {
            File[] arrfile = file.listFiles();
            int n2 = arrfile.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                f.a(arrfile[i2]);
            }
        }
        file.delete();
    }

    public static void a(final String string2, final String string3, final String string4, final String string5, final String string6, final String string7, final String string8, final String string9, final String string10) {
        try {
            if (!string7.equals((Object)"video_started") && !string7.equals((Object)"video_ended")) {
                return;
            }
            Runnable runnable = new Runnable(){

                /*
                 * Exception decompiling
                 */
                public final void run() {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl23 : BIPUSH : trying to set 1 previously set to 0
                    // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                    // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                    // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                    // org.benf.cfr.reader.entities.g.p(Method.java:396)
                    // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                    // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                    // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
            };
            new Thread(runnable).start();
        }
        catch (Throwable throwable) {}
    }

    public static boolean a(Context context, String string2) {
        if (context != null) {
            if (TextUtils.isEmpty((CharSequence)string2)) {
                return false;
            }
            if (context.checkPermission(string2, Process.myPid(), Process.myUid()) == 0) {
                return true;
            }
        }
        return false;
    }

    public static byte[] a(String string2, Object object, boolean bl, int n2) throws IOException {
        return f.b(string2, object, bl, n2, d.a.HashMap);
    }

    /*
     * Exception decompiling
     */
    public static byte[] a(String var0, Object var1, boolean var2, int var3, d.a var4) throws Exception {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl384.1 : ACONST_NULL : trying to set 1 previously set to 0
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int aa(String string2) {
        String string3 = string2.toLowerCase(Locale.US);
        int n2 = string3.hashCode();
        if (n2 != 1653) {
            if (n2 != 1684) {
                if (n2 != 1715) {
                    if (n2 != 3649301) return -1;
                    if (!string3.equals((Object)"wifi")) return -1;
                    return 3;
                }
                if (!string3.equals((Object)"4g")) return -1;
                return 2;
            }
            if (!string3.equals((Object)"3g")) return -1;
            return 1;
        }
        if (!string3.equals((Object)"2g")) return -1;
        return 0;
    }

    private static String ab(String string2) {
        MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
        messageDigest.reset();
        messageDigest.update(string2.getBytes());
        byte[] arrby = messageDigest.digest();
        int n2 = arrby.length;
        StringBuilder stringBuilder = new StringBuilder(n2 << 1);
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(Character.forDigit((int)((240 & arrby[i2]) >> 4), (int)16));
            stringBuilder.append(Character.forDigit((int)(15 & arrby[i2]), (int)16));
        }
        try {
            String string3 = stringBuilder.toString();
            return string3;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return f.c(32);
        }
    }

    /*
     * Exception decompiling
     */
    public static String b(Context var0, boolean var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20 : ALOAD_2 : trying to set 1 previously set to 0
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

    public static String b(String string2, JSONObject jSONObject) throws IOException {
        return new String(f.b(string2, (Object)jSONObject, true, 8000, d.a.JSONObject), "UTF-8");
    }

    public static String b(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter((Writer)stringWriter));
        String string2 = stringWriter.toString();
        if (string2.length() > 512) {
            string2 = string2.substring(0, 512);
        }
        return string2;
    }

    /*
     * Exception decompiling
     */
    private static String b(List<Pair<String, String>> var0, boolean var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl10 : ALOAD_3 : trying to set 1 previously set to 0
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

    private static byte[] b(InputStream inputStream) throws IOException {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[1024];
        while ((n2 = inputStream.read(arrby)) != -1) {
            byteArrayOutputStream.write(arrby, 0, n2);
        }
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static byte[] b(String var0, Object var1_1, boolean var2_2, int var3_3, d.a var4_4) throws IOException {
        block19 : {
            block17 : {
                block18 : {
                    var5_5 = new URL(var0);
                    new StringBuilder("performURLCall ").append(var0);
                    var7_6 = null;
                    var9_7 = (HttpURLConnection)var5_5.openConnection();
                    try {
                        var9_7.setReadTimeout(var3_3);
                        var9_7.setConnectTimeout(var3_3);
                        var9_7.setRequestProperty("Accept-Encoding", "gzip");
                        var9_7.setRequestProperty("User-Agent", f.gV);
                        if (var1_1 != null) {
                            var9_7.setDoOutput(true);
                            var9_7.setRequestMethod("POST");
                            var14_8 = d.a.JSONObject;
                            var7_6 = null;
                            if (var4_4 == var14_8 || var4_4 == d.a.JSONArray) {
                                var9_7.setRequestProperty("Content-Type", "application/json");
                                new StringBuilder("report params ").append(var1_1.toString());
                            }
                            var16_9 = var9_7.getOutputStream();
                            var17_10 = new BufferedWriter((Writer)new OutputStreamWriter(var16_9, "UTF-8"));
                            if (var4_4 == d.a.JSONArray) {
                                var17_10.write(((JSONArray)var1_1).toString());
                            } else if (var4_4 == d.a.JSONObject) {
                                var17_10.write(((JSONObject)var1_1).toString());
                            } else if (var4_4 == d.a.HashMap) {
                                var18_11 = (HashMap)var1_1;
                                var19_12 = new ArrayList();
                                var20_13 = var18_11.entrySet().iterator();
                                do {
                                    var21_14 = var20_13.hasNext();
                                    var7_6 = null;
                                    if (!var21_14) break;
                                    var22_15 = (Map.Entry)var20_13.next();
                                    var19_12.add((Object)new Pair(var22_15.getKey(), var22_15.getValue()));
                                } while (true);
                                var17_10.write(f.b((List<Pair<String, String>>)var19_12, var2_2));
                            } else if (var4_4 == d.a.ArrayList) {
                                var17_10.write(f.b((List<Pair<String, String>>)((ArrayList)var1_1), var2_2));
                            }
                            var17_10.flush();
                            var17_10.close();
                            var16_9.close();
                        }
                        var10_16 = var9_7.getResponseCode();
                        var7_6 = null;
                        if (var10_16 != 200) break block17;
                        var7_6 = var9_7.getInputStream();
                        var11_17 = f.b(f.a(var7_6));
                        if (var7_6 == null) break block18;
                    }
                    catch (Throwable var8_20) {}
                    var7_6.close();
                }
                if (var9_7 == null) return var11_17;
                var9_7.disconnect();
                return var11_17;
            }
            if (var10_16 == 301 || var10_16 == 302 || var10_16 == 303) ** GOTO lbl65
            var13_18 = "";
            var7_6 = var9_7.getErrorStream();
            if (var7_6 == null) throw new HttpRetryException(var13_18, var10_16);
            var13_18 = new String(f.b(var7_6), "UTF-8");
            throw new HttpRetryException(var13_18, var10_16);
lbl65: // 1 sources:
            var12_19 = f.b(var9_7.getHeaderField("Location"), var1_1, var2_2, var3_3, var4_4);
            if (var9_7 == null) return var12_19;
            var9_7.disconnect();
            return var12_19;
            break block19;
            catch (Throwable var8_21) {
                var9_7 = null;
            }
        }
        if (var7_6 != null) {
            var7_6.close();
        }
        if (var9_7 == null) throw var8_22;
        var9_7.disconnect();
        throw var8_22;
    }

    static String bb() {
        return gV;
    }

    public static String bc() {
        try {
            StringBuilder stringBuilder = new StringBuilder("android ");
            stringBuilder.append(Build.VERSION.SDK_INT);
            stringBuilder.append(" ");
            stringBuilder.append(Build.MANUFACTURER);
            stringBuilder.append(" ");
            stringBuilder.append(Build.MODEL);
            String string2 = URLEncoder.encode((String)stringBuilder.toString(), (String)"UTF-8");
            return string2;
        }
        catch (Throwable throwable) {
            return "android";
        }
    }

    public static int bd() {
        Runtime runtime = Runtime.getRuntime();
        long l2 = (runtime.totalMemory() - runtime.freeMemory()) / 0x100000L;
        return (int)(runtime.maxMemory() / 0x100000L - l2);
    }

    public static double be() {
        return 0.0;
    }

    public static String bf() {
        return Locale.getDefault().getLanguage();
    }

    public static String bg() {
        String[] arrstring = VID.split("\\.");
        if (arrstring.length < 4) {
            return VID;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < 3; ++i2) {
            stringBuilder.append(arrstring[i2]);
            if (i2 >= 2) continue;
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }

    private static String c(int n2) {
        char[] arrc = "0123456789abcdef".toCharArray();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < 32; ++i2) {
            stringBuilder.append(arrc[random.nextInt(arrc.length)]);
        }
        return stringBuilder.toString();
    }

    /*
     * Exception decompiling
     */
    public static String c(String var0) {
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

    public static void c(Throwable throwable) {
    }

    public static boolean c(Context context, String string2) {
        try {
            context.getPackageManager().getPackageInfo(string2, 128);
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    /*
     * Exception decompiling
     */
    private static void d(HashMap<String, Bitmap> var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl19.1 : RETURN : trying to set 1 previously set to 0
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

    public static String g(AppnextAd appnextAd) {
        String string2;
        StringBuilder stringBuilder = new StringBuilder("https://www.appnext.com/privacy_policy/index.html?z=");
        stringBuilder.append(new Random().nextInt(10));
        stringBuilder.append(appnextAd.getZoneID());
        stringBuilder.append(new Random().nextInt(10));
        if (appnextAd.isGdpr()) {
            StringBuilder stringBuilder2 = new StringBuilder("&edda=1&geo=");
            stringBuilder2.append(appnextAd.getCountry());
            string2 = stringBuilder2.toString();
        } else {
            string2 = "";
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String l(Context context) {
        return f.b(context, true);
    }

    public static String m(String string2, String string3) {
        String string4 = android.webkit.CookieManager.getInstance().getCookie(string2);
        if (string4 == null) {
            return "";
        }
        String[] arrstring = string4.split(";");
        int n2 = arrstring.length;
        String string5 = "";
        for (int i2 = 0; i2 < n2; ++i2) {
            String string6 = arrstring[i2];
            if (!string6.contains((CharSequence)string3)) continue;
            String[] arrstring2 = string6.split("=");
            if (arrstring2.length > 1) {
                string5 = arrstring2[1];
                continue;
            }
            return "";
        }
        return string5;
    }

    static void m(Context context) {
        try {
            WebView webView = new WebView(context);
            gV = webView.getSettings().getUserAgentString();
            webView.destroy();
        }
        catch (Throwable throwable) {}
    }

    public static String n(Context context) {
        if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            return "Unknown";
        }
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                return "wifi";
            }
            if (networkInfo.getType() == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(networkInfo.getSubtype());
                return stringBuilder.toString();
            }
            return "Unknown";
        }
        return "-";
    }

    public static String o(Context context) {
        if (context == null) {
            return "Unknown";
        }
        if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            return "Unknown";
        }
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                return "wifi";
            }
            if (networkInfo.getType() == 0) {
                switch (networkInfo.getSubtype()) {
                    default: {
                        return "Unknown";
                    }
                    case 13: {
                        return "4G";
                    }
                    case 3: 
                    case 5: 
                    case 6: 
                    case 8: 
                    case 9: 
                    case 10: 
                    case 12: 
                    case 14: 
                    case 15: {
                        return "3G";
                    }
                    case 1: 
                    case 2: 
                    case 4: 
                    case 7: 
                    case 11: 
                }
                return "2G";
            }
            return "Unknown";
        }
        return "-";
    }

    public static void o(String string2) {
    }

    public static String p(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String string2 = telephonyManager.getSimOperator();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2.substring(0, 3));
            stringBuilder.append("_");
            stringBuilder.append(string2.substring(3));
            return stringBuilder.toString();
        }
        return "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String q(Context context) {
        if (!gX.equals((Object)"")) return gX;
        String string2 = VID;
        synchronized (VID) {
            if (!gX.equals((Object)"")) return gX;
            gX = f.r(context);
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return gX;
        }
    }

    public static String r(Context context) {
        String string2 = f.b(context, true);
        if (string2.equals((Object)"")) {
            return f.c(32);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis() / 1000L);
        return f.ab(stringBuilder.toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean s(Context context) {
        NetworkInfo networkInfo;
        try {
            if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
                f.a("http://www.appnext.com/myid.html", null);
                return true;
            }
            networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkInfo == null) throw new IOException();
        }
        catch (Throwable throwable) {
            return false;
        }
        if (networkInfo.isConnected()) return true;
        throw new IOException();
    }

}

