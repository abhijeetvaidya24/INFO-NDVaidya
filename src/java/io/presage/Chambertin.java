/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  io.presage.du
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.text.SimpleDateFormat
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package io.presage;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import io.presage.Laguiole;
import io.presage.ak;
import io.presage.cl;
import io.presage.du;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class Chambertin {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final Context b;

    public Chambertin(Context context) {
        this.b = context;
    }

    public static String a() {
        String string2 = Build.VERSION.RELEASE;
        cl.a((Object)string2, "Build.VERSION.RELEASE");
        return string2;
    }

    private static String a(NetworkInfo networkInfo) {
        if (Laguiole.a(networkInfo)) {
            String string2 = networkInfo.getTypeName();
            cl.a((Object)string2, "info.typeName");
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(networkInfo.getTypeName());
        stringBuilder.append(" - ");
        stringBuilder.append(networkInfo.getSubtypeName());
        return stringBuilder.toString();
    }

    private static String a(String string2, String string3) {
        if (du.b((String)string3, (String)string2)) {
            return string3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static String b() {
        String string2 = System.getProperty((String)"java.vm.version");
        cl.a((Object)string2, "System.getProperty(\"java.vm.version\")");
        return string2;
    }

    public static String c() {
        String string2 = System.getProperty((String)"java.vm.name");
        cl.a((Object)string2, "System.getProperty(\"java.vm.name\")");
        return string2;
    }

    public static String d() {
        String string2 = System.getProperty((String)"os.arch");
        cl.a((Object)string2, "System.getProperty(\"os.arch\")");
        return string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String e() {
        StringBuilder stringBuilder;
        String string2;
        try {
            Calendar calendar = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"GMT"), (Locale)Locale.getDefault());
            cl.a((Object)calendar, "calendar");
            Date date = calendar.getTime();
            string2 = new SimpleDateFormat("Z", Locale.US).format(date);
            stringBuilder = new StringBuilder();
            cl.a((Object)string2, "localTime");
            if (string2 == null) throw new ak("null cannot be cast to non-null type java.lang.String");
        }
        catch (Exception exception) {
            return "";
        }
        String string3 = string2.substring(0, 3);
        cl.a((Object)string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        stringBuilder.append(string3);
        stringBuilder.append(":");
        String string4 = string2.substring(3, string2.length());
        cl.a((Object)string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public static String f() {
        TimeZone timeZone = TimeZone.getTimeZone((String)"UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        String string2 = simpleDateFormat.format(new Date());
        cl.a((Object)string2, "format.format(Date())");
        return string2;
    }

    public static String h() {
        String string2 = Build.MANUFACTURER;
        String string3 = Build.MODEL;
        if (string3 != null) {
            cl.a((Object)string2, "manufacturer");
            return Chambertin.a(string2, string3);
        }
        return "Unknown";
    }

    /*
     * Exception decompiling
     */
    public final boolean g() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl35 : ICONST_0 : trying to set 1 previously set to 0
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

    public final String i() {
        block3 : {
            NetworkInfo networkInfo;
            try {
                networkInfo = Laguiole.a(this.b);
                if (networkInfo == null) break block3;
            }
            catch (Exception exception) {
                return "NONE";
            }
            String string2 = Chambertin.a(networkInfo);
            return string2;
        }
        return "UNKNOWN";
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}

