/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.URLUtil
 *  com.tappx.a.a.a.b.k$b
 *  com.tappx.a.a.a.b.k$c
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Locale
 *  java.util.Map
 */
package com.tappx.a.a.a.b;

import android.webkit.URLUtil;
import com.tappx.a.a.a.b.a.d;
import com.tappx.a.a.a.b.k;
import com.tappx.a.a.a.h;
import java.util.Locale;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public class k {
    private static final int A = 0;
    private static final int B = 0;
    private static final int C = 0;
    private static final int D = 0;
    private static final String E = "1";
    private static final int F = 10;
    private static final int G = 0;
    private static final String H = "1";
    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static final String g;
    private static final String h;
    private static final String i;
    private static final String j;
    private static final String k;
    private static final String l;
    private static final String m;
    private static final String n;
    private static final String o;
    private static final String p;
    private static final String q;
    private static final String r;
    private static final String s;
    private static final String t;
    private static final String u;
    private static final String v;
    private static final String w;
    private static final int x = -1;
    private static final int y = Integer.MAX_VALUE;
    private static final int z;
    private final c I;
    private final b J;

    static {
        a = h.a("alkSd/cjeMOnRhI1+y0Fgw");
        b = h.a("7lduO4sGkp1tZzDJbYS8pw");
        c = h.a("HnTZ8Ox2OnyDxdD5hsZrLQ");
        d = h.a("AkEIgV9lhHi/w7lKhAfWaA");
        e = h.a("Vj56qeUSUIexpZcT0zkYTw");
        f = h.a("/spXhZX81bJqCykir0NEjw");
        g = h.a("ju52neF4RY1ixmfCi1hgfA");
        h = h.a("lZVtXyq5ZD6wNwR+ZIHPqA");
        i = h.a("yzM431Q8gFGgERkBwgxdJg");
        j = h.a("oRIavRQJX4wGvDJt1kOzlg");
        k = h.a("5/KYAj40HA8DjDIwU73ybw");
        l = h.a("Ku0dXCSVFeVQPviFMELOqg");
        m = h.a("7nlBnTgzxYha5wGn2VLJtw");
        n = h.a("2mDdVFzY5fPJSVCM3S7xnA");
        o = h.a("Dgw5Kh1C4hRzacbFtYeP2Q");
        p = h.a("kZlsOHt4BykwnGQBWo5ciQ");
        q = h.a("vDgIOL0Ac/85bIB4sUn2dg");
        r = h.a("VbMgRD4jVg4hNau0Ow7yWHX5dBZylyqDyPIjra0JMrA");
        s = h.a("Rn7//KdU5SMi4HFSPVjQzQ");
        t = h.a("CJcKTQGQcFh0cXOvBHlbc1De0+8fG8Rx/CGjhGnsKs8");
        u = h.a("OwINE7I1OlDbXaPClfMqJg");
        v = h.a("J6xwyZwxZoE3V4vmDtoW2w");
        w = h.a("93poZZjBiuurmpEnoLn+8A");
    }

    public k() {
        this(new /* Unavailable Anonymous Inner Class!! */, new /* Unavailable Anonymous Inner Class!! */);
    }

    k(c c2, b b2) {
        this.I = c2;
        this.J = b2;
    }

    private int a(String string2) {
        if (string2 == null) {
            return 0;
        }
        try {
            int n2 = Integer.parseInt((String)string2);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    static /* synthetic */ String h() {
        return d;
    }

    static /* synthetic */ String i() {
        return e;
    }

    static /* synthetic */ String j() {
        return f;
    }

    static /* synthetic */ String k() {
        return g;
    }

    static /* synthetic */ String l() {
        return h;
    }

    static /* synthetic */ String m() {
        return i;
    }

    static /* synthetic */ String n() {
        return o;
    }

    public com.tappx.a.a.a.e.d a(d d2) {
        String string2 = (String)d2.b.get((Object)a);
        int n2 = this.a((String)d2.b.get((Object)s));
        boolean bl2 = "1".equals(d2.b.get((Object)p));
        String string3 = (String)d2.b.get((Object)t);
        if (u.equals((Object)string2)) {
            com.tappx.a.a.a.e.d d3 = new com.tappx.a.a.a.e.d();
            d3.a(bl2, n2, string3);
            return d3;
        }
        if (v.equals((Object)string2)) {
            com.tappx.a.a.a.e.d d4 = this.J.b(d2);
            d4.a(bl2, n2, string3);
            return d4;
        }
        if (w.equals((Object)string2)) {
            com.tappx.a.a.a.e.d d5 = this.I.b(d2);
            d5.a(bl2, n2, string3);
            return d5;
        }
        throw new com.tappx.a.a.a.e.a.a();
    }

    public com.tappx.a.a.a.h.b b(d d2) {
        String string2 = (String)d2.b.get((Object)q);
        if (URLUtil.isValidUrl((String)string2)) {
            boolean bl2 = "1".equalsIgnoreCase((String)d2.b.get((Object)p));
            String string3 = d2.a();
            if (string3 != null && string3.length() < 10) {
                string3 = null;
            }
            return new com.tappx.a.a.a.h.b(bl2, string2, string3, (String)d2.b.get((Object)r));
        }
        throw new com.tappx.a.a.a.e.a.a();
    }

    static class a {
        static final String c = h.a("Z0s98+TEac+mapO900zQZA");
        static final String d = h.a("UjhhaCwcEZ+voViDfkR/pA");
        static final String e = h.a("SNfY2H1acX2p46/zyMOc/g");
        static final String f = h.a("On2W1poIktAVirYlBse78g");
        static final String g = h.a("LC4el1lDkKxbZdxa4Qatkw");
        static final String h = h.a("rj1rf34CVwuKwyr8EiViZg");

        a() {
        }

        private com.tappx.a.a.a.e.a a(String string2) {
            if (string2 == null) {
                string2 = g;
            }
            if (e.equals((Object)string2)) {
                return com.tappx.a.a.a.e.a.c;
            }
            if (f.equals((Object)string2)) {
                return com.tappx.a.a.a.e.a.d;
            }
            if (c.equals((Object)string2)) {
                return com.tappx.a.a.a.e.a.e;
            }
            if (d.equals((Object)string2)) {
                return com.tappx.a.a.a.e.a.f;
            }
            if (h.equals((Object)string2)) {
                return com.tappx.a.a.a.e.a.b;
            }
            if (g.equals((Object)string2)) {
                return com.tappx.a.a.a.e.a.a;
            }
            return com.tappx.a.a.a.e.a.a;
        }

        private int b(Map<String, String> map, String string2, int n2) {
            String string3 = (String)map.get((Object)n);
            if (string3 == null) {
                return n2;
            }
            String string4 = string3.toLowerCase(Locale.US);
            int n3 = -1;
            int n4 = string4.hashCode();
            if (n4 != 108) {
                if (n4 == 112 && string4.equals((Object)"p")) {
                    n3 = 1;
                }
            } else if (string4.equals((Object)"l")) {
                n3 = 0;
            }
            if (n3 != 0) {
                return n3 == 1;
            }
            return 2;
        }

        /*
         * Exception decompiling
         */
        int a(Map<String, String> var1, String var2, int var3) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl17.1 : ILOAD_3 : trying to set 0 previously set to 1
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

        com.tappx.a.a.a.e.d a(d d2) {
            com.tappx.a.a.a.e.d d3 = new com.tappx.a.a.a.e.d();
            int n2 = this.a(d2.b, b, -1);
            if (n2 >= 0) {
                d3.a(n2);
            }
            return d3;
        }

        void a(com.tappx.a.a.a.e.b b2, Map<String, String> map, boolean bl2) {
            int n2 = this.a(map, c, Integer.MAX_VALUE);
            b2.a(System.currentTimeMillis() + (long)n2);
            if (bl2) {
                b2.b((String)map.get((Object)j));
                b2.c((String)map.get((Object)k));
                b2.a((String)map.get((Object)l));
            }
            b2.a(this.a((String)map.get((Object)m)));
            b2.a(this.b(map, n, 0));
        }
    }

}

