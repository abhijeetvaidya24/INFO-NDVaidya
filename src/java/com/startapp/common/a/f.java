/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Queue
 */
package com.startapp.common.a;

import android.content.Context;
import android.location.Location;
import com.startapp.common.a.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class f {
    public static String a(List<Location> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (Location location : list) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(location.getLongitude());
                stringBuilder2.append(",");
                stringBuilder.append(stringBuilder2.toString());
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(location.getLatitude());
                stringBuilder3.append(",");
                stringBuilder.append(stringBuilder3.toString());
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(location.getAccuracy());
                stringBuilder4.append(",");
                stringBuilder.append(stringBuilder4.toString());
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(location.getProvider());
                stringBuilder5.append(",");
                stringBuilder.append(stringBuilder5.toString());
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(location.getTime());
                stringBuilder6.append(";");
                stringBuilder.append(stringBuilder6.toString());
            }
            return stringBuilder.toString().substring(0, -1 + stringBuilder.toString().length());
        }
        return stringBuilder.toString();
    }

    /*
     * Exception decompiling
     */
    public static List<Location> a(Context var0, boolean var1, boolean var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl11 : ALOAD : trying to set 1 previously set to 0
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

    private static Queue<String> b(Context context, boolean bl, boolean bl2) {
        LinkedList linkedList = new LinkedList();
        if (bl && c.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            linkedList.add((Object)"gps");
            linkedList.add((Object)"passive");
            linkedList.add((Object)"network");
            return linkedList;
        }
        if (bl2 && c.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            linkedList.add((Object)"network");
        }
        return linkedList;
    }
}

