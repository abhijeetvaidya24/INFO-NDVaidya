/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  java.util.UUID
 */
package com.ogury.consent.manager;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.ogury.consent.manager.Helvetica;
import com.ogury.consent.manager.cf0;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.vieww10800;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class colortbl {
    public static final colortbl a = new colortbl();

    private colortbl() {
    }

    private static String a(Context context) {
        long l2;
        ApplicationInfo applicationInfo;
        block12 : {
            if (context == null) {
                applicationInfo = null;
            } else {
                ArrayList arrayList;
                List list;
                block13 : {
                    PackageManager packageManager;
                    block11 : {
                        packageManager = context.getPackageManager();
                        if (packageManager != null) break block11;
                        applicationInfo = null;
                        break block12;
                    }
                    list = packageManager.getInstalledApplications(128);
                    arrayList = new ArrayList();
                    if (!list.isEmpty()) break block13;
                    applicationInfo = null;
                    break block12;
                }
                for (ApplicationInfo applicationInfo2 : list) {
                    if ((1 & applicationInfo2.flags) == 0 || applicationInfo2.packageName == null) continue;
                    arrayList.add((Object)applicationInfo2);
                }
                List list2 = (List)arrayList;
                Comparator comparator = ansi.a;
                tx6480.b((Object)list2, "$receiver");
                tx6480.b((Object)comparator, "comparator");
                if (list2.size() > 1) {
                    Collections.sort((List)list2, (Comparator)comparator);
                }
                applicationInfo = (ApplicationInfo)arrayList.get(0);
            }
        }
        if (applicationInfo == null) {
            return "00000000-0000-0000-0000-000000000000";
        }
        try {
            l2 = context.getPackageManager().getPackageInfo((String)applicationInfo.packageName, (int)128).firstInstallTime;
        }
        catch (Exception exception) {
            return "00000000-0000-0000-0000-000000000000";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf((long)l2));
        String string2 = stringBuilder.toString();
        Charset charset = cf0.a;
        if (string2 != null) {
            byte[] arrby = string2.getBytes(charset);
            tx6480.a((Object)arrby, "(this as java.lang.String).getBytes(charset)");
            String string3 = UUID.nameUUIDFromBytes((byte[])arrby).toString();
            tx6480.a((Object)string3, "UUID.nameUUIDFromBytes((\u2026toByteArray()).toString()");
            return string3;
        }
        throw new vieww10800("null cannot be cast to non-null type java.lang.String");
    }

    public static final /* synthetic */ String a(colortbl colortbl2, Context context) {
        return colortbl.a(context);
    }

    public static void a(final Context context, final Helvetica helvetica) {
        tx6480.b((Object)context, "context");
        tx6480.b(helvetica, "aaidCallback");
        new Thread(new Runnable(){

            /*
             * Exception decompiling
             */
            public final void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl44 : ALOAD_0 : trying to set 1 previously set to 0
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
        }).start();
    }

}

