/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.media.AudioManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.widget.Toast
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.text.SimpleDateFormat
 *  java.util.Arrays
 *  java.util.Date
 *  java.util.Locale
 *  java.util.UUID
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.zip.CRC32
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.ap;
import com.adcolony.sdk.az;
import com.adcolony.sdk.g;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;

class au {
    static ExecutorService b = Executors.newSingleThreadExecutor();
    static Handler c;

    /*
     * Exception decompiling
     */
    static int a(ap var0) {
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

    static AudioManager a(Context context) {
        if (context == null) {
            new y.a().a("getAudioManager called with a null Context").a(y.h);
            return null;
        }
        return (AudioManager)context.getSystemService("audio");
    }

    static String a(double d2, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        au.a(d2, n2, stringBuilder);
        return stringBuilder.toString();
    }

    static String a(JSONArray jSONArray) throws JSONException {
        String string = "";
        block9 : for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            if (i2 > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(",");
                string = stringBuilder.toString();
            }
            switch (jSONArray.getInt(i2)) {
                default: {
                    continue block9;
                }
                case 7: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append("SU");
                    string = stringBuilder.toString();
                    continue block9;
                }
                case 6: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append("SA");
                    string = stringBuilder.toString();
                    continue block9;
                }
                case 5: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append("FR");
                    string = stringBuilder.toString();
                    continue block9;
                }
                case 4: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append("TH");
                    string = stringBuilder.toString();
                    continue block9;
                }
                case 3: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append("WE");
                    string = stringBuilder.toString();
                    continue block9;
                }
                case 2: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append("TU");
                    string = stringBuilder.toString();
                    continue block9;
                }
                case 1: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append("MO");
                    string = stringBuilder.toString();
                }
            }
        }
        return string;
    }

    static JSONArray a(int n2) {
        JSONArray jSONArray = w.b();
        for (int i2 = 0; i2 < n2; ++i2) {
            w.a(jSONArray, au.e());
        }
        return jSONArray;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void a(double d2, int n2, StringBuilder stringBuilder) {
        if (!Double.isNaN((double)d2) && !Double.isInfinite((double)d2)) {
            if (d2 < 0.0) {
                d2 = -d2;
                stringBuilder.append('-');
            }
            if (n2 == 0) {
                stringBuilder.append(Math.round((double)d2));
                return;
            }
            long l2 = (long)Math.pow((double)10.0, (double)n2);
            double d3 = l2;
            Double.isNaN((double)d3);
            long l3 = Math.round((double)(d2 * d3));
            stringBuilder.append(l3 / l2);
            stringBuilder.append('.');
            long l4 = l3 % l2;
            if (l4 == 0L) {
                int n3 = 0;
                while (n3 < n2) {
                    stringBuilder.append('0');
                    ++n3;
                }
                return;
            }
            long l5 = l4 * 10L;
            do {
                if (l5 >= l2) {
                    stringBuilder.append(l4);
                    return;
                }
                stringBuilder.append('0');
                l5 *= 10L;
            } while (true);
        }
        stringBuilder.append(d2);
    }

    static boolean a(Intent intent) {
        return au.a(intent, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static boolean a(Intent intent, boolean bl) {
        try {
            Context context = com.adcolony.sdk.a.c();
            if (context == null) {
                return false;
            }
            AdColonyInterstitial adColonyInterstitial = com.adcolony.sdk.a.a().u();
            if (adColonyInterstitial != null && adColonyInterstitial.g()) {
                adColonyInterstitial.h().f();
            }
            if (bl) {
                context.startActivity(Intent.createChooser((Intent)intent, (CharSequence)"Handle this via..."));
                return true;
            }
            context.startActivity(intent);
            return true;
        }
        catch (Exception exception) {
            new y.a().a(exception.toString()).a(y.f);
            return false;
        }
    }

    static boolean a(AudioManager audioManager) {
        if (audioManager == null) {
            new y.a().a("isAudioEnabled() called with a null AudioManager").a(y.h);
            return false;
        }
        try {
            int n2 = audioManager.getStreamVolume(3);
            boolean bl = false;
            if (n2 > 0) {
                bl = true;
            }
            return bl;
        }
        catch (Exception exception) {
            new y.a().a("Exception occurred when accessing AudioManager.getStreamVolume: ").a(exception.toString()).a(y.h);
            return false;
        }
    }

    static boolean a(Runnable runnable) {
        Looper looper = Looper.getMainLooper();
        if (looper == null) {
            return false;
        }
        if (c == null) {
            c = new Handler(looper);
        }
        if (looper == Looper.myLooper()) {
            runnable.run();
        } else {
            c.post(runnable);
        }
        return true;
    }

    static boolean a(String string) {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return false;
        }
        try {
            Application application = context instanceof Application ? (Application)context : ((Activity)context).getApplication();
            application.getPackageManager().getApplicationInfo(string, 0);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    static boolean a(final String string, final int n2) {
        final Context context = com.adcolony.sdk.a.c();
        if (context != null) {
            au.a(new Runnable(){

                public void run() {
                    Toast.makeText((Context)context, (CharSequence)string, (int)n2).show();
                }
            });
            return true;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    static boolean a(String var0, File var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl77 : ALOAD : trying to set 1 previously set to 0
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

    static boolean a(String[] arrstring, String[] arrstring2) {
        if (arrstring != null && arrstring2 != null && arrstring.length == arrstring2.length) {
            Arrays.sort((Object[])arrstring);
            Arrays.sort((Object[])arrstring2);
            return Arrays.equals((Object[])arrstring, (Object[])arrstring2);
        }
        return false;
    }

    static double b(AudioManager audioManager) {
        double d2;
        int n2;
        if (audioManager == null) {
            new y.a().a("getAudioVolume() called with a null AudioManager").a(y.h);
            return 0.0;
        }
        try {
            d2 = audioManager.getStreamVolume(3);
            n2 = audioManager.getStreamMaxVolume(3);
        }
        catch (Exception exception) {
            new y.a().a("Exception occurred when accessing AudioManager: ").a(exception.toString()).a(y.h);
            return 0.0;
        }
        double d3 = n2;
        if (d3 == 0.0) {
            return 0.0;
        }
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        return d2 / d3;
    }

    static int b(String string) {
        CRC32 cRC32 = new CRC32();
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            cRC32.update((int)string.charAt(i2));
        }
        return (int)cRC32.getValue();
    }

    static String b() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return "1.0";
        }
        try {
            String string = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionName;
            return string;
        }
        catch (Exception exception) {
            new y.a().a("Failed to retrieve package info.").a(y.h);
            return "1.0";
        }
    }

    static String b(Context context) {
        try {
            String string = context.getPackageName();
            return string;
        }
        catch (Exception exception) {
            return "unknown";
        }
    }

    static String b(JSONArray jSONArray) throws JSONException {
        String string = "";
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            if (i2 > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(",");
                string = stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(jSONArray.getInt(i2));
            string = stringBuilder.toString();
        }
        return string;
    }

    static int c() {
        Context context = com.adcolony.sdk.a.c();
        if (context == null) {
            return 0;
        }
        try {
            int n2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode;
            return n2;
        }
        catch (Exception exception) {
            new y.a().a("Failed to retrieve package info.").a(y.h);
            return 0;
        }
    }

    static int c(Context context) {
        if (context == null) {
            return 0;
        }
        int n2 = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (n2 > 0) {
            return context.getResources().getDimensionPixelSize(n2);
        }
        return 0;
    }

    static String c(String string) {
        try {
            String string2 = az.a(string);
            return string2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    static String d() {
        CharSequence charSequence;
        block3 : {
            Context context = com.adcolony.sdk.a.c();
            if (context == null) {
                return "";
            }
            Application application = context instanceof Application ? (Application)context : ((Activity)context).getApplication();
            PackageManager packageManager = application.getPackageManager();
            try {
                charSequence = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
                if (charSequence != null) break block3;
                return "";
            }
            catch (Exception exception) {
                new y.a().a("Failed to retrieve application label.").a(y.h);
                return "";
            }
        }
        return charSequence.toString();
    }

    /*
     * Exception decompiling
     */
    static JSONArray d(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl33.1 : ALOAD_1 : trying to set 1 previously set to 0
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

    static boolean d(String string) {
        if (string != null && string.length() <= 128) {
            return true;
        }
        new y.a().a("String must be non-null and the max length is 128 characters.").a(y.e);
        return false;
    }

    static String e() {
        return UUID.randomUUID().toString();
    }

    static int g(String string) {
        long l2;
        try {
            l2 = Long.parseLong((String)string, (int)16);
        }
        catch (NumberFormatException numberFormatException) {
            new y.a().a("Unable to parse '").a(string).a("' as a color.").a(y.f);
            return -16777216;
        }
        return (int)l2;
    }

    static boolean g() {
        Context context = com.adcolony.sdk.a.c();
        return context != null && Build.VERSION.SDK_INT >= 24 && context instanceof Activity && ((Activity)context).isInMultiWindowMode();
    }

    static Date h(String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.US);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            Date date = simpleDateFormat.parse(string);
            return date;
        }
        catch (Exception exception) {
            try {
                Date date = simpleDateFormat2.parse(string);
                return date;
            }
            catch (Exception exception2) {
                try {
                    Date date = simpleDateFormat3.parse(string);
                    return date;
                }
                catch (Exception exception3) {
                    return null;
                }
            }
        }
    }

    static class a {
        double a;
        double b = System.currentTimeMillis();

        a(double d2) {
            this.a(d2);
        }

        void a(double d2) {
            this.a = d2;
            double d3 = System.currentTimeMillis();
            Double.isNaN((double)d3);
            this.b = d3 / 1000.0 + this.a;
        }

        boolean b() {
            return this.c() == 0.0;
        }

        double c() {
            double d2 = System.currentTimeMillis();
            Double.isNaN((double)d2);
            double d3 = d2 / 1000.0;
            double d4 = this.b - d3;
            if (d4 <= 0.0) {
                return 0.0;
            }
            return d4;
        }

        public String toString() {
            return au.a(this.c(), 2);
        }
    }

}

