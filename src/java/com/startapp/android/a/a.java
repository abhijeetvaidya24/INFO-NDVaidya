/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Environment
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Process
 *  java.lang.ProcessBuilder
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.startapp.android.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.startapp.android.a.b;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(value=14)
public final class a {
    private static final String[] a = new String[]{"15555215554", "15555215556", "15555215558", "15555215560", "15555215562", "15555215564", "15555215566", "15555215568", "15555215570", "15555215572", "15555215574", "15555215576", "15555215578", "15555215580", "15555215582", "15555215584"};
    private static final String[] b = new String[]{"000000000000000", "e21833235b6eef10", "012345678912345"};
    private static final String[] c = new String[]{"310260000000000"};
    private static final String[] d = new String[]{"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
    private static final String[] e = new String[]{"goldfish"};
    private static final String[] f = new String[]{"/dev/socket/qemud", "/dev/qemu_pipe"};
    private static final String[] g = new String[]{"ueventd.android_x86.rc", "x86.prop", "ueventd.ttVM_x86.rc", "init.ttVM_x86.rc", "fstab.ttVM_x86", "fstab.vbox86", "init.vbox86.rc", "ueventd.vbox86.rc"};
    private static final String[] h = new String[]{"fstab.andy", "ueventd.andy.rc"};
    private static final String[] i = new String[]{"fstab.nox", "init.nox.rc", "ueventd.nox.rc", "/BigNoxGameHD", "/YSLauncher"};
    private static final b[] j;
    @SuppressLint(value={"StaticFieldLeak"})
    private static a o;
    private static Boolean p;
    private final Context k;
    private boolean l = false;
    private boolean m = true;
    private List<String> n = new ArrayList();

    static {
        b[] arrb = new b[]{new b("init.svc.qemud", null), new b("init.svc.qemu-props", null), new b("qemu.hw.mainkeys", null), new b("qemu.sf.fake_camera", null), new b("qemu.sf.lcd_density", null), new b("ro.bootloader", "unknown"), new b("ro.bootmode", "unknown"), new b("ro.hardware", "goldfish"), new b("ro.kernel.android.qemud", null), new b("ro.kernel.qemu.gles", null), new b("ro.kernel.qemu", "1"), new b("ro.product.device", "generic"), new b("ro.product.model", "sdk"), new b("ro.product.name", "sdk"), new b("ro.serialno", null), new b("ro.build.description", "72656C656173652D6B657973"), new b("ro.build.fingerprint", "3A757365722F72656C656173652D6B657973"), new b("net.eth0.dns1", null), new b("rild.libpath", "2F73797374656D2F6C69622F6C69627265666572656E63652D72696C2E736F"), new b("ro.radio.use-ppp", null), new b("gsm.version.baseband", null), new b("ro.build.tags", "72656C656173652D6B65"), new b("ro.build.display.id", "746573742D"), new b("init.svc.console", null)};
        j = arrb;
    }

    private a(Context context) {
        this.k = context;
        this.n.add((Object)"com.google.android.launcher.layouts.genymotion");
        this.n.add((Object)"com.bluestacks");
        this.n.add((Object)"com.bignox.app");
        this.n.add((Object)"com.vphone.launcher");
    }

    private String a(Context context, String string2) {
        try {
            Class class_ = context.getClassLoader().loadClass("android.os.SystemProperties");
            String string3 = (String)class_.getMethod("get", new Class[]{String.class}).invoke((Object)class_, new Object[]{string2});
            return string3;
        }
        catch (Exception exception) {
            return null;
        }
    }

    private boolean a() {
        boolean bl2 = this.b();
        if (!bl2) {
            bl2 = this.c();
        }
        if (!bl2) {
            bl2 = this.d();
        }
        return bl2;
    }

    public static boolean a(Context context) {
        if (p == null) {
            p = a.b(context).a();
        }
        return p;
    }

    private boolean a(String[] arrstring, String string2) {
        for (String string3 : arrstring) {
            File file;
            if (this.b(this.k, "android.permission.READ_EXTERNAL_STORAGE") && string3.contains((CharSequence)"/") && string2.equals((Object)"Nox")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)Environment.getExternalStorageDirectory());
                stringBuilder.append(string3);
                file = new File(stringBuilder.toString());
            } else {
                file = new File(string3);
            }
            if (!file.exists()) continue;
            return true;
        }
        return false;
    }

    private static a b(Context context) {
        if (context != null) {
            if (o == null) {
                o = new a(context.getApplicationContext());
            }
            return o;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    private boolean b() {
        return Build.FINGERPRINT.startsWith("generic") || Build.MODEL.contains((CharSequence)"google_sdk") || Build.MODEL.toLowerCase().contains((CharSequence)"droid4x") || Build.MODEL.contains((CharSequence)"Emulator") || Build.MODEL.contains((CharSequence)"Android SDK built for") || Build.MANUFACTURER.contains((CharSequence)"Genymotion") || Build.HARDWARE.equals((Object)"goldfish") || Build.HARDWARE.equals((Object)"vbox86") || Build.PRODUCT.equals((Object)"sdk") || Build.PRODUCT.equals((Object)"google_sdk") || Build.PRODUCT.equals((Object)"sdk_x86") || Build.PRODUCT.equals((Object)"vbox86p") || Build.BOARD.toLowerCase().contains((CharSequence)"nox") || Build.BOOTLOADER.toLowerCase().contains((CharSequence)"nox") || Build.HARDWARE.toLowerCase().contains((CharSequence)"nox") || Build.PRODUCT.toLowerCase().contains((CharSequence)"nox") || Build.SERIAL.toLowerCase().contains((CharSequence)"nox") || Build.FINGERPRINT.startsWith("unknown") || Build.FINGERPRINT.contains((CharSequence)"Andy") || Build.FINGERPRINT.contains((CharSequence)"ttVM_Hdragon") || Build.FINGERPRINT.contains((CharSequence)"vbox86p") || Build.HARDWARE.contains((CharSequence)"ttVM_x86") || Build.MODEL.equals((Object)"sdk") || Build.MODEL.contains((CharSequence)"Droid4X") || Build.MODEL.contains((CharSequence)"TiantianVM") || Build.MODEL.contains((CharSequence)"Andy") || Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic");
        {
        }
    }

    /*
     * Exception decompiling
     */
    private boolean b(Context var1, String var2) {
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

    private boolean c() {
        return this.e() || this.a(d, "Geny") || this.a(h, "Andy") || this.a(i, "Nox") || this.j() || this.a(f, "Pipes") || this.l() || this.k() && this.a(g, "X86");
        {
        }
    }

    private boolean d() {
        if (this.m) {
            if (this.n.isEmpty()) {
                return false;
            }
            PackageManager packageManager = this.k.getPackageManager();
            Iterator iterator = this.n.iterator();
            while (iterator.hasNext()) {
                Intent intent = packageManager.getLaunchIntentForPackage((String)iterator.next());
                if (intent == null || packageManager.queryIntentActivities(intent, 65536).isEmpty()) continue;
                return true;
            }
        }
        return false;
    }

    private boolean e() {
        boolean bl2;
        block2 : {
            block3 : {
                boolean bl3 = this.b(this.k, "android.permission.READ_PHONE_STATE");
                bl2 = false;
                if (!bl3) break block2;
                boolean bl4 = this.l;
                bl2 = false;
                if (!bl4) break block2;
                boolean bl5 = this.m();
                bl2 = false;
                if (!bl5) break block2;
                if (this.f() || this.g() || this.h()) break block3;
                boolean bl6 = this.i();
                bl2 = false;
                if (!bl6) break block2;
            }
            bl2 = true;
        }
        return bl2;
    }

    private boolean f() {
        TelephonyManager telephonyManager = (TelephonyManager)this.k.getSystemService("phone");
        if (telephonyManager != null) {
            String string2 = telephonyManager.getLine1Number();
            String[] arrstring = a;
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!arrstring[i2].equalsIgnoreCase(string2)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean g() {
        TelephonyManager telephonyManager = (TelephonyManager)this.k.getSystemService("phone");
        if (telephonyManager != null) {
            String string2 = telephonyManager.getDeviceId();
            String[] arrstring = b;
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!arrstring[i2].equalsIgnoreCase(string2)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean h() {
        TelephonyManager telephonyManager = (TelephonyManager)this.k.getSystemService("phone");
        if (telephonyManager != null) {
            String string2 = telephonyManager.getSubscriberId();
            String[] arrstring = c;
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!arrstring[i2].equalsIgnoreCase(string2)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean i() {
        TelephonyManager telephonyManager = (TelephonyManager)this.k.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName().equalsIgnoreCase("android");
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    private boolean j() {
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

    private boolean k() {
        b[] arrb = j;
        int n2 = arrb.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            b b2 = arrb[i2];
            String string2 = this.a(this.k, b2.a);
            if (b2.b == null && string2 != null) {
                ++n3;
            }
            if (b2.b == null || string2 == null || !string2.contains((CharSequence)b2.b)) continue;
            ++n3;
        }
        boolean bl2 = false;
        if (n3 >= 5) {
            bl2 = true;
        }
        return bl2;
    }

    private boolean l() {
        if (this.b(this.k, "android.permission.INTERNET")) {
            StringBuilder stringBuilder;
            String[] arrstring = new String[]{"/system/bin/netcfg"};
            stringBuilder = new StringBuilder();
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(arrstring);
                processBuilder.directory(new File("/system/bin/"));
                processBuilder.redirectErrorStream(true);
                InputStream inputStream = processBuilder.start().getInputStream();
                byte[] arrby = new byte[1024];
                while (inputStream.read(arrby) != -1) {
                    stringBuilder.append(new String(arrby));
                }
                inputStream.close();
            }
            catch (Exception exception) {}
            String string2 = stringBuilder.toString();
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                for (String string3 : string2.split("\n")) {
                    if (!string3.contains((CharSequence)"wlan0") && !string3.contains((CharSequence)"tunl0") && !string3.contains((CharSequence)"eth0") || !string3.contains((CharSequence)"10.0.2.15")) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean m() {
        return this.k.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }
}

