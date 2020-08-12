/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.Date
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TimeZone
 *  java.util.TreeMap
 */
package com.tappx.b.a;

import com.tappx.b.b;
import com.tappx.b.g;
import com.tappx.b.k;
import com.tappx.b.v;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;

public class j {
    static final String a = "Content-Type";
    private static final String b = "ISO-8859-1";
    private static final String c = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public static long a(String string2) {
        try {
            long l2 = j.a().parse(string2).getTime();
            return l2;
        }
        catch (ParseException parseException) {
            v.a(parseException, "Unable to parse dateStr: %s, falling back to 0", string2);
            return 0L;
        }
    }

    /*
     * Exception decompiling
     */
    public static b.a a(k var0) {
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

    static String a(long l2) {
        return j.a().format(new Date(l2));
    }

    public static String a(Map<String, String> map) {
        return j.a(map, b);
    }

    public static String a(Map<String, String> map, String string2) {
        String string3 = (String)map.get((Object)a);
        if (string3 != null) {
            String[] arrstring = string3.split(";");
            for (int i2 = 1; i2 < arrstring.length; ++i2) {
                String[] arrstring2 = arrstring[i2].trim().split("=");
                if (arrstring2.length != 2 || !arrstring2[0].equals((Object)"charset")) continue;
                return arrstring2[1];
            }
        }
        return string2;
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone((String)"GMT"));
        return simpleDateFormat;
    }

    static Map<String, String> a(List<g> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g g2 : list) {
            treeMap.put((Object)g2.a(), (Object)g2.b());
        }
        return treeMap;
    }

    static List<g> b(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add((Object)new g((String)entry.getKey(), (String)entry.getValue()));
        }
        return arrayList;
    }
}

