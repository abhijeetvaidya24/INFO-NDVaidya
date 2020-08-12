/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.tappx.b.a.a
 *  java.io.InputStream
 *  java.lang.Deprecated
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 *  java.util.TreeSet
 */
package com.tappx.b.a;

import android.os.SystemClock;
import com.tappx.b.a.a;
import com.tappx.b.a.d;
import com.tappx.b.a.f;
import com.tappx.b.a.j;
import com.tappx.b.a.l;
import com.tappx.b.b;
import com.tappx.b.g;
import com.tappx.b.h;
import com.tappx.b.k;
import com.tappx.b.n;
import com.tappx.b.r;
import com.tappx.b.u;
import com.tappx.b.v;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class e
implements h {
    protected static final boolean a = false;
    private static final int d = 3000;
    private static final int e = 4096;
    @Deprecated
    protected final l b;
    protected final f c;
    private final d f;

    static {
        a = v.b;
    }

    public e(d d2) {
        this(d2, new f(4096));
    }

    public e(d d2, f f2) {
        this.f = d2;
        this.b = d2;
        this.c = f2;
    }

    @Deprecated
    public e(l l2) {
        this(l2, new f(4096));
    }

    @Deprecated
    public e(l l2, f f2) {
        this.b = l2;
        this.f = new a(l2);
        this.c = f2;
    }

    private static List<g> a(List<g> list, b.a a2) {
        ArrayList arrayList;
        block6 : {
            TreeSet treeSet;
            block5 : {
                treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                if (!list.isEmpty()) {
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        treeSet.add((Object)((g)iterator.next()).a());
                    }
                }
                arrayList = new ArrayList(list);
                if (a2.h == null) break block5;
                if (a2.h.isEmpty()) break block6;
                for (g g2 : a2.h) {
                    if (treeSet.contains((Object)g2.a())) continue;
                    arrayList.add((Object)g2);
                }
                break block6;
            }
            if (!a2.g.isEmpty()) {
                for (Map.Entry entry : a2.g.entrySet()) {
                    if (treeSet.contains(entry.getKey())) continue;
                    arrayList.add((Object)new g((String)entry.getKey(), (String)entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    private Map<String, String> a(b.a a2) {
        if (a2 == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        if (a2.b != null) {
            hashMap.put((Object)"If-None-Match", (Object)a2.b);
        }
        if (a2.d > 0L) {
            hashMap.put((Object)"If-Modified-Since", (Object)j.a(a2.d));
        }
        return hashMap;
    }

    @Deprecated
    protected static Map<String, String> a(g[] arrg) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i2 = 0; i2 < arrg.length; ++i2) {
            treeMap.put((Object)arrg[i2].a(), (Object)arrg[i2].b());
        }
        return treeMap;
    }

    private void a(long l2, n<?> n2, byte[] arrby, int n3) {
        if (a || l2 > 3000L) {
            Object[] arrobject = new Object[5];
            arrobject[0] = n2;
            arrobject[1] = l2;
            String string = arrby != null ? Integer.valueOf((int)arrby.length) : "null";
            arrobject[2] = string;
            arrobject[3] = n3;
            arrobject[4] = n2.y().b();
            v.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", arrobject);
        }
    }

    private static void a(String string, n<?> n2, u u2) {
        r r2 = n2.y();
        int n3 = n2.x();
        try {
            r2.a(u2);
        }
        catch (u u3) {
            Object[] arrobject = new Object[]{string, n3};
            n2.a(String.format((String)"%s-timeout-giveup [timeout=%s]", (Object[])arrobject));
            throw u3;
        }
        Object[] arrobject = new Object[]{string, n3};
        n2.a(String.format((String)"%s-retry [timeout=%s]", (Object[])arrobject));
    }

    /*
     * Exception decompiling
     */
    private byte[] a(InputStream var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl42 : ALOAD_0 : trying to set 1 previously set to 0
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
     * Exception decompiling
     */
    @Override
    public k a(n<?> var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl3 : INVOKESTATIC : trying to set 1 previously set to 0
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

    protected void a(String string, String string2, long l2) {
        long l3 = SystemClock.elapsedRealtime();
        Object[] arrobject = new Object[]{string, l3 - l2, string2};
        v.a("HTTP ERROR(%s) %d ms to fetch %s", arrobject);
    }
}

