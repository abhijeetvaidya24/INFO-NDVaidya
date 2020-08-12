/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageManager
 *  android.graphics.Point
 *  android.media.AudioDeviceInfo
 *  android.media.AudioManager
 *  android.os.Build
 *  android.os.Handler
 *  android.os.Looper
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.provider.Settings$SettingNotFoundException
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  com.applovin.adview.AppLovinInterstitialActivity
 *  com.applovin.impl.sdk.d.i
 *  com.applovin.impl.sdk.k$2
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.nio.charset.Charset
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.Locale
 *  java.util.Map
 *  java.util.PriorityQueue
 *  java.util.Queue
 *  java.util.TimeZone
 *  java.util.UUID
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.impl.sdk.ad.f;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.d.i;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.e.i;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class k {
    private static final Queue<String> a = new LinkedList();
    private static String f;
    private static String g;
    private static int h;
    private final com.applovin.impl.sdk.j b;
    private final p c;
    private final Context d;
    private final Map<Class, Object> e;
    private final AtomicReference<a> i = new AtomicReference();

    static {
        a.add((Object)"act");
        a.add((Object)"acm");
        a.add((Object)"adr");
        a.add((Object)"build");
        a.add((Object)"volume");
        a.add((Object)"ua");
    }

    protected k(com.applovin.impl.sdk.j j2) {
        if (j2 != null) {
            this.b = j2;
            this.c = j2.u();
            this.d = j2.w();
            this.e = Collections.synchronizedMap((Map)new HashMap());
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /*
     * Exception decompiling
     */
    private d a(d var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl161 : ALOAD_0 : trying to set 1 previously set to 0
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

    private boolean a(String string2) {
        return k.a(string2, this.d);
    }

    public static boolean a(String string2, Context context) {
        if (string2 != null) {
            if (context != null) {
                return context.getPackageManager().checkPermission(string2, context.getPackageName()) == 0;
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No permission name specified");
    }

    private boolean a(String string2, com.applovin.impl.sdk.b.b<String> b2) {
        Iterator iterator = com.applovin.impl.sdk.e.d.a(this.b.a(b2)).iterator();
        while (iterator.hasNext()) {
            if (!string2.startsWith((String)iterator.next())) continue;
            return true;
        }
        return false;
    }

    private String b(int n2) {
        String string2;
        JSONObject jSONObject = new JSONObject(this.f());
        PriorityQueue priorityQueue = new PriorityQueue(a);
        while ((string2 = Base64.encodeToString((byte[])jSONObject.toString().getBytes(Charset.defaultCharset()), (int)2)).length() > n2) {
            String string3;
            while (!jSONObject.has(string3 = (String)priorityQueue.poll()) && !priorityQueue.isEmpty()) {
            }
            if (!TextUtils.isEmpty((CharSequence)string3)) {
                jSONObject.remove(string3);
                continue;
            }
            p p2 = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to generate base64 request parameters with max length: ");
            stringBuilder.append(n2);
            p2.d("DataCollector", stringBuilder.toString());
            return "";
        }
        return string2;
    }

    private String b(String string2) {
        int n2 = string2.length();
        int[] arrn = new int[]{11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        int n3 = arrn.length;
        char[] arrc = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arrc[i2] = string2.charAt(i2);
            for (int i3 = n3 - 1; i3 >= 0; --i3) {
                arrc[i2] = (char)(arrc[i2] ^ arrn[i3]);
            }
        }
        return new String(arrc);
    }

    private String c(int n2) {
        if (n2 == 1) {
            return "receiver";
        }
        if (n2 == 2) {
            return "speaker";
        }
        if (n2 != 4 && n2 != 3) {
            if (n2 == 8) {
                return "bluetootha2dpoutput";
            }
            if (n2 != 13 && n2 != 19 && n2 != 5 && n2 != 6 && n2 != 12 && n2 != 11) {
                if (n2 != 9 && n2 != 10) {
                    return null;
                }
                return "hdmioutput";
            }
            return "lineout";
        }
        return "headphones";
    }

    static /* synthetic */ AtomicReference c(k k2) {
        return k2.i;
    }

    private Map<String, String> f() {
        return this.a(null, false, true);
    }

    private String g() {
        try {
            int n2 = m.e(this.d);
            if (n2 == 1) {
                return "portrait";
            }
            if (n2 == 2) {
                return "landscape";
            }
        }
        catch (Throwable throwable) {
            this.b.u().b("DataCollector", "Encountered error while attempting to collect application orientation", throwable);
        }
        return "none";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private a h() {
        String string2;
        ContentResolver contentResolver;
        a a2;
        block4 : {
            block3 : {
                void var1_7;
                p p2;
                String string3;
                try {
                    contentResolver = this.d.getContentResolver();
                    string2 = Settings.Secure.getString((ContentResolver)contentResolver, (String)"advertising_id");
                    a2 = new a();
                    if (string2 == null) break block3;
                    break block4;
                }
                catch (Throwable throwable) {
                    p2 = this.c;
                    string3 = "Unable to collect FireOS IDFA";
                }
                catch (Settings.SettingNotFoundException settingNotFoundException) {
                    p2 = this.c;
                    string3 = "Unable to determine if FireOS limited ad tracking is turned on";
                }
                p2.b("DataCollector", string3, (Throwable)var1_7);
                return null;
            }
            string2 = "";
        }
        a2.b = string2;
        boolean bl = Settings.Secure.getInt((ContentResolver)contentResolver, (String)"limit_ad_tracking") != 0;
        a2.a = bl;
        return a2;
    }

    private a i() {
        block6 : {
            String string2;
            Object object;
            block7 : {
                Class class_ = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient");
                if (class_ == null) break block6;
                Method method = class_.getMethod("getAdvertisingIdInfo", new Class[]{Context.class});
                Object[] arrobject = new Object[]{this.d};
                Object object2 = method.invoke(null, arrobject);
                if (object2 == null) break block6;
                Class class_2 = object2.getClass();
                object = class_2.getMethod("isLimitAdTrackingEnabled", (Class[])null).invoke(object2, (Object[])null);
                string2 = (String)class_2.getMethod("getId", (Class[])null).invoke(object2, (Object[])null);
                if (string2 != null) break block7;
                string2 = "";
            }
            try {
                a a2 = new a();
                a2.a = (Boolean)object;
                a2.b = string2;
                return a2;
            }
            catch (Throwable throwable) {
                this.c.b("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", throwable);
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.c.c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", classNotFoundException);
            }
        }
        return new a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private c j() {
        try {
            c c2 = new c();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            Intent intent = this.d.registerReceiver(null, intentFilter);
            int n2 = -1;
            int n3 = intent != null ? intent.getIntExtra("level", n2) : -1;
            int n4 = intent != null ? intent.getIntExtra("scale", n2) : -1;
            c2.b = n3 > 0 && n4 > 0 ? (int)(100.0f * ((float)n3 / (float)n4)) : n2;
            if (intent != null) {
                n2 = intent.getIntExtra("status", n2);
            }
            c2.a = n2;
            return c2;
        }
        catch (Throwable throwable) {
            this.c.b("DataCollector", "Unable to collect battery info", throwable);
            return null;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private String k() {
        block9 : {
            try {
                var2_1 = (AudioManager)this.d.getSystemService("audio");
                var3_2 = new StringBuilder();
                var4_3 = e.g();
                if (var4_3) {
                    var10_4 = var2_1.getDevices(2);
                    var11_5 = var10_4.length;
                    var12_6 = 0;
                    break block9;
                }
                if (var2_1.isWiredHeadsetOn()) {
                    var3_2.append("headphones");
                    var3_2.append(",");
                }
                if (var2_1.isBluetoothA2dpOn()) {
                    var3_2.append("bluetootha2dpoutput");
                }
                do {
                    if (var3_2.length() > 0 && var3_2.charAt(-1 + var3_2.length()) == ',') {
                        var3_2.deleteCharAt(-1 + var3_2.length());
                    }
                    if (TextUtils.isEmpty((CharSequence)(var5_8 = var3_2.toString())) == false) return var5_8;
                    this.c.a("DataCollector", "No sound outputs detected");
                    return var5_8;
                    break;
                } while (true);
            }
            catch (Throwable var1_9) {
                this.c.b("DataCollector", "Unable to collect sound outputs", var1_9);
                return null;
            }
        }
        do {
            if (var12_6 >= var11_5) ** continue;
            var13_7 = this.c(var10_4[var12_6].getType());
            if (!TextUtils.isEmpty((CharSequence)var13_7)) {
                var3_2.append(var13_7);
                var3_2.append(",");
            }
            ++var12_6;
        } while (true);
    }

    private double l() {
        double d2 = TimeZone.getDefault().getOffset(new Date().getTime());
        Double.isNaN((double)d2);
        double d3 = Math.round((double)(d2 * 10.0 / 3600000.0));
        Double.isNaN((double)d3);
        return d3 / 10.0;
    }

    private boolean m() {
        boolean bl;
        try {
            if (this.b.g()) {
                return this.d.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
            }
            PackageManager packageManager = this.d.getPackageManager();
            if (e.f()) {
                return packageManager.hasSystemFeature("android.software.leanback");
            }
            if (e.c()) {
                return packageManager.hasSystemFeature("android.hardware.type.television");
            }
            bl = packageManager.hasSystemFeature("android.hardware.touchscreen");
        }
        catch (Throwable throwable) {
            this.c.b("DataCollector", "Failed to determine if device is TV.", throwable);
            return false;
        }
        return bl ^ true;
    }

    /*
     * Exception decompiling
     */
    private boolean n() {
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

    private boolean o() {
        String string2 = Build.TAGS;
        return string2 != null && string2.contains((CharSequence)this.b("lz}$blpz"));
    }

    private boolean p() {
        String[] arrstring = new String[]{"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i2 = 0; i2 < arrstring.length; ++i2) {
            if (!new File(this.b(arrstring[i2])).exists()) continue;
            return true;
        }
        return false;
    }

    private boolean q() {
        return this.a(Build.DEVICE, com.applovin.impl.sdk.b.b.ev) || this.a(Build.HARDWARE, com.applovin.impl.sdk.b.b.eu) || this.a(Build.MANUFACTURER, com.applovin.impl.sdk.b.b.ew) || this.a(Build.MODEL, com.applovin.impl.sdk.b.b.ex);
        {
        }
    }

    private String r() {
        AtomicReference atomicReference;
        atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(this.d.getMainLooper()).post(new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                try {
                    try {
                        WebView webView = new WebView(k.this.d);
                        atomicReference.set((Object)webView.getSettings().getUserAgentString());
                    }
                    catch (Throwable throwable3) {
                        k.this.c.b("DataCollector", "Unable to collect user agent string", throwable3);
                    }
                }
                catch (Throwable throwable2) {}
                countDownLatch.countDown();
                return;
                countDownLatch.countDown();
                throw throwable2;
            }
        });
        try {
            countDownLatch.await(this.b.a(com.applovin.impl.sdk.b.b.eB).longValue(), TimeUnit.MILLISECONDS);
        }
        catch (Throwable throwable) {}
        return (String)atomicReference.get();
    }

    private String s() {
        boolean bl = e.b();
        String string2 = "custom_size,launch_app";
        if (bl && e.a(AppLovinInterstitialActivity.class, this.d)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(",video");
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    f a(int n2) {
        String string2 = this.b(n2);
        boolean bl = this.i.get() != null;
        if (this.b.a(com.applovin.impl.sdk.b.b.eY).booleanValue()) {
            long l2 = m.a(this.b);
            return new f(i.a(string2, this.b.s(), l2), bl);
        }
        return new f(string2, bl);
    }

    /*
     * Exception decompiling
     */
    public d a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl107 : FAKE_TRY : trying to set 1 previously set to 0
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

    public Map<String, String> a(Map<String, String> map, boolean bl, boolean bl2) {
        Boolean bl3;
        a a2;
        Boolean bl4;
        HashMap hashMap = new HashMap();
        d d2 = this.a();
        hashMap.put((Object)"brand", (Object)j.e(d2.d));
        hashMap.put((Object)"brand_name", (Object)j.e(d2.e));
        hashMap.put((Object)"hardware", (Object)j.e(d2.f));
        hashMap.put((Object)"api_level", (Object)String.valueOf((int)d2.h));
        hashMap.put((Object)"carrier", (Object)j.e(d2.j));
        hashMap.put((Object)"country_code", (Object)j.e(d2.i));
        hashMap.put((Object)"locale", (Object)j.e(d2.k.toString()));
        hashMap.put((Object)"model", (Object)j.e(d2.a));
        hashMap.put((Object)"os", (Object)j.e(d2.b));
        hashMap.put((Object)"platform", (Object)j.e(d2.c));
        hashMap.put((Object)"revision", (Object)j.e(d2.g));
        hashMap.put((Object)"orientation_lock", (Object)d2.l);
        hashMap.put((Object)"tz_offset", (Object)String.valueOf((double)d2.o));
        hashMap.put((Object)"wvvc", (Object)String.valueOf((int)d2.p));
        hashMap.put((Object)"adns", (Object)String.valueOf((float)d2.m));
        hashMap.put((Object)"adnsd", (Object)String.valueOf((int)d2.n));
        hashMap.put((Object)"sim", (Object)j.a(d2.u));
        hashMap.put((Object)"gy", (Object)j.a(d2.v));
        hashMap.put((Object)"tv", (Object)j.a(d2.w));
        hashMap.put((Object)"fs", (Object)String.valueOf((long)d2.y));
        hashMap.put((Object)"adr", (Object)j.a(d2.q));
        hashMap.put((Object)"volume", (Object)String.valueOf((int)d2.s));
        m.a("ua", j.e(d2.t), (Map<String, String>)hashMap);
        m.a("so", j.e(d2.x), (Map<String, String>)hashMap);
        c c2 = d2.r;
        if (c2 != null) {
            hashMap.put((Object)"act", (Object)String.valueOf((int)c2.a));
            hashMap.put((Object)"acm", (Object)String.valueOf((int)c2.b));
        }
        if ((bl4 = d2.z) != null) {
            hashMap.put((Object)"huc", (Object)bl4.toString());
        }
        if ((bl3 = d2.A) != null) {
            hashMap.put((Object)"aru", (Object)bl3.toString());
        }
        Point point = e.a(this.d);
        hashMap.put((Object)"dx", (Object)Integer.toString((int)point.x));
        hashMap.put((Object)"dy", (Object)Integer.toString((int)point.y));
        hashMap.put((Object)"accept", (Object)this.s());
        hashMap.put((Object)"api_did", (Object)this.b.a(com.applovin.impl.sdk.b.b.R));
        hashMap.put((Object)"sdk_version", (Object)"9.2.1");
        hashMap.put((Object)"build", (Object)Integer.toString((int)111));
        hashMap.put((Object)"format", (Object)"json");
        b b2 = this.c();
        hashMap.put((Object)"app_version", (Object)j.e(b2.b));
        hashMap.put((Object)"ia", (Object)Long.toString((long)b2.f));
        hashMap.put((Object)"tg", (Object)String.valueOf((Object)b2.e));
        hashMap.put((Object)"installer_name", (Object)b2.d);
        m.a("mediation_provider", j.e(this.b.m()), (Map<String, String>)hashMap);
        hashMap.put((Object)"network", (Object)com.applovin.impl.sdk.e.f.d(this.b));
        m.a("plugin_version", this.b.a(com.applovin.impl.sdk.b.b.el), (Map<String, String>)hashMap);
        hashMap.put((Object)"preloading", (Object)String.valueOf((boolean)bl));
        m.a("test_ads", this.b.l().isTestAdsEnabled(), (Map<String, String>)hashMap);
        hashMap.put((Object)"first_install", (Object)String.valueOf((boolean)this.b.A()));
        if (!this.b.a(com.applovin.impl.sdk.b.b.eX).booleanValue()) {
            hashMap.put((Object)"sdk_key", (Object)this.b.s());
        }
        hashMap.put((Object)"sc", (Object)this.b.a(com.applovin.impl.sdk.b.b.V));
        hashMap.put((Object)"sc2", (Object)this.b.a(com.applovin.impl.sdk.b.b.W));
        hashMap.put((Object)"server_installed_at", (Object)j.e(this.b.a(com.applovin.impl.sdk.b.b.X)));
        m.a("persisted_data", j.e(this.b.a(com.applovin.impl.sdk.b.d.r)), (Map<String, String>)hashMap);
        hashMap.put((Object)"v1", (Object)Boolean.toString((boolean)e.a("android.permission.WRITE_EXTERNAL_STORAGE", this.d)));
        hashMap.put((Object)"v2", (Object)Boolean.toString((boolean)e.a(AppLovinInterstitialActivity.class, this.d)));
        hashMap.put((Object)"v3", (Object)Boolean.toString((boolean)e.b(this.d)));
        hashMap.put((Object)"v4", (Object)Boolean.toString((boolean)e.c(this.d)));
        hashMap.put((Object)"v5", (Object)Boolean.toString((boolean)e.a(AppLovinWebViewActivity.class, this.d)));
        if (this.b.a(com.applovin.impl.sdk.b.b.eD).booleanValue()) {
            h h2 = this.b.D();
            hashMap.put((Object)"li", (Object)String.valueOf((long)h2.b(g.b)));
            hashMap.put((Object)"si", (Object)String.valueOf((long)h2.b(g.d)));
            hashMap.put((Object)"pf", (Object)String.valueOf((long)h2.b(g.h)));
            hashMap.put((Object)"mpf", (Object)String.valueOf((long)h2.b(g.q)));
            hashMap.put((Object)"gpf", (Object)String.valueOf((long)h2.b(g.i)));
        }
        hashMap.put((Object)"vz", (Object)j.a(this.d.getPackageName(), this.b));
        if (this.b.i()) {
            hashMap.put((Object)"pnr", (Object)Boolean.toString((boolean)this.b.j()));
        }
        if (bl2) {
            a2 = (a)this.i.get();
            if (a2 == null) {
                a2 = new a();
                hashMap.put((Object)"inc", (Object)Boolean.toString((boolean)true));
            }
            this.e();
        } else {
            a2 = this.b.G().d();
        }
        String string2 = a2.b;
        if (j.b(string2)) {
            hashMap.put((Object)"idfa", (Object)string2);
        }
        hashMap.put((Object)"dnt", (Object)Boolean.toString((boolean)a2.a));
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put((Object)"rid", (Object)UUID.randomUUID().toString());
        return hashMap;
    }

    public String b() {
        if (this.b.g()) {
            return "fireos";
        }
        return "android";
    }

    /*
     * Exception decompiling
     */
    public b c() {
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
    public a d() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.b.a.a.i.b(Op03SimpleStatement.java:414)
        // org.benf.cfr.reader.b.a.a.b.ad.a(Misc.java:226)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:623)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:52)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:576)
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

    public void e() {
        com.applovin.impl.sdk.d.i i2 = new com.applovin.impl.sdk.d.i(this.b, (i.a)new 2(this));
        this.b.C().a((com.applovin.impl.sdk.d.a)i2, q.a.c);
    }

    public static class a {
        public boolean a;
        public String b = "";
    }

    public static class b {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public long f;
    }

    public static class c {
        public int a = -1;
        public int b = -1;
    }

    public static class d {
        public Boolean A;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public int h;
        public String i;
        public String j;
        public Locale k;
        public String l;
        public float m;
        public int n;
        public double o;
        public int p;
        public boolean q;
        public c r;
        public int s;
        public String t;
        public boolean u;
        public boolean v;
        public boolean w;
        public String x;
        public long y;
        public Boolean z;
    }

}

