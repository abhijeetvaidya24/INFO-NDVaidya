/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.bm
 *  com.tapjoy.internal.br
 *  com.tapjoy.internal.dx
 *  com.tapjoy.internal.dy
 *  com.tapjoy.internal.dz
 *  com.tapjoy.internal.eb
 *  com.tapjoy.internal.ed
 *  com.tapjoy.internal.eh
 *  com.tapjoy.internal.ek
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bm;
import com.tapjoy.internal.bq;
import com.tapjoy.internal.br;
import com.tapjoy.internal.dx;
import com.tapjoy.internal.dy;
import com.tapjoy.internal.dz;
import com.tapjoy.internal.eb;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.eh;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class gs {
    public static String a(dx dx2) {
        bm bm2 = new bm().c();
        if (dx2.e != null) {
            bm2.a("pkg_ver").b(dx2.e);
        }
        if (dx2.f != null) {
            bm2.a("pkg_rev").a((Number)dx2.f);
        }
        if (dx2.g != null) {
            bm2.a("data_ver").b(dx2.g);
        }
        if (dx2.h != null) {
            bm2.a("installer").b(dx2.h);
        }
        if (dx2.i != null) {
            bm2.a("store").b(dx2.i);
        }
        return bm2.d().toString();
    }

    /*
     * Exception decompiling
     */
    private static String a(dy var0, boolean var1, boolean var2, boolean var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl421.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    public static String a(dz dz2) {
        bm bm2 = new bm().a();
        Iterator iterator = dz2.d.iterator();
        ed ed2 = null;
        dx dx2 = null;
        ek ek2 = null;
        while (iterator.hasNext()) {
            dx dx3;
            boolean bl2;
            boolean bl3;
            dy dy2 = (dy)iterator.next();
            boolean bl4 = true;
            if (ed2 != null && ed2.equals((Object)dy2.u)) {
                bl3 = true;
            } else {
                ed2 = dy2.u;
                bl3 = false;
            }
            if (dx2 != null && dx2.equals((Object)dy2.v)) {
                dx3 = dx2;
                bl2 = true;
            } else {
                dx3 = dy2.v;
                bl2 = false;
            }
            if (ek2 == null || !ek2.equals((Object)dy2.w)) {
                ek2 = dy2.w;
                bl4 = false;
            }
            bm2.a((bq)new br(gs.a(dy2, bl3, bl2, bl4)));
            dx2 = dx3;
        }
        return bm2.b().toString();
    }

    private static String a(eb eb2) {
        int n2 = 1.a[eb2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 == 4) {
                        return "usages";
                    }
                    throw new RuntimeException();
                }
                return "custom";
            }
            return "campaign";
        }
        return "app";
    }

    public static String a(ed ed2) {
        bm bm2 = new bm().c().a("sdk").b(ed2.t).a("os_name").b(ed2.k).a("os_ver").b(ed2.l).a("device_id").b(ed2.h).a("device_maker").b(ed2.i).a("device_model").b(ed2.j).a("pkg_id").b(ed2.r).a("pkg_sign").b(ed2.s).a("locale").b(ed2.p).a("timezone").b(ed2.q);
        if (ed2.m != null) {
            bm2.a("display_d").a((Number)ed2.m);
        }
        if (ed2.n != null) {
            bm2.a("display_w").a((Number)ed2.n);
        }
        if (ed2.o != null) {
            bm2.a("display_h").a((Number)ed2.o);
        }
        if (ed2.g != null) {
            bm2.a("mac").b(ed2.g);
        }
        if (ed2.u != null) {
            bm2.a("country_sim").b(ed2.u);
        }
        if (ed2.v != null) {
            bm2.a("country_net").b(ed2.v);
        }
        if (ed2.w != null) {
            bm2.a("imei").b(ed2.w);
        }
        return bm2.d().toString();
    }

    public static String a(ek ek2) {
        return gs.a(ek2, null);
    }

    private static String a(ek ek2, dy dy2) {
        String string2;
        bm bm2 = new bm().c();
        if (ek2.s != null) {
            bm2.a("installed").a((Number)ek2.s);
        }
        if (ek2.t != null) {
            bm2.a("referrer").b(ek2.t);
        }
        if (ek2.G != null) {
            bm2.a("idfa").b(ek2.G);
            if (ek2.H != null && ek2.H.booleanValue()) {
                bm2.a("idfa_optout").a(1L);
            }
        } else if (dy2 != null && dy2.r != null && gf.a.equals((Object)dy2.r) && (string2 = gq.b()) != null) {
            bm2.a("idfa").b(string2);
            if (gq.c()) {
                bm2.a("idfa_optout").a(1L);
            }
        }
        if (ek2.u != null) {
            bm2.a("fq7").a((long)Math.max((int)ek2.u, (int)1));
        }
        if (ek2.v != null) {
            bm2.a("fq30").a((long)Math.max((int)ek2.v, (int)1));
        }
        if (ek2.w.size() > 0) {
            ArrayList arrayList = new ArrayList(ek2.w.size());
            for (eh eh2 : ek2.w) {
                if (eh2.h == null) continue;
                arrayList.add((Object)eh2.f);
            }
            if (!arrayList.isEmpty()) {
                bm2.a("push").a();
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    bm2.b((String)iterator.next());
                }
                bm2.b();
            }
        }
        bm2.a("session").c();
        if (ek2.x != null) {
            bm2.a("total_count").a((Number)ek2.x);
        }
        if (ek2.y != null) {
            bm2.a("total_length").a((Number)ek2.y);
        }
        if (ek2.z != null) {
            bm2.a("last_at").a((Number)ek2.z);
        }
        if (ek2.A != null) {
            bm2.a("last_length").a((Number)ek2.A);
        }
        bm2.d();
        bm2.a("purchase").c();
        if (ek2.B != null) {
            bm2.a("currency").b(ek2.B);
        }
        if (ek2.C != null) {
            bm2.a("total_count").a((Number)ek2.C);
        }
        if (ek2.D != null) {
            bm2.a("total_price").a((Number)ek2.D);
        }
        if (ek2.E != null) {
            bm2.a("last_at").a((Number)ek2.E);
        }
        if (ek2.F != null) {
            bm2.a("last_price").a((Number)ek2.F);
        }
        bm2.d();
        if (ek2.I != null) {
            bm2.a("user_id").b(ek2.I);
        }
        if (ek2.J != null) {
            bm2.a("user_level").a((Number)ek2.J);
        }
        if (ek2.K != null) {
            bm2.a("friend_count").a((Number)ek2.K);
        }
        if (ek2.L != null) {
            bm2.a("uv1").b(ek2.L);
        }
        if (ek2.M != null) {
            bm2.a("uv2").b(ek2.M);
        }
        if (ek2.N != null) {
            bm2.a("uv3").b(ek2.N);
        }
        if (ek2.O != null) {
            bm2.a("uv4").b(ek2.O);
        }
        if (ek2.P != null) {
            bm2.a("uv5").b(ek2.P);
        }
        if (ek2.Q.size() > 0) {
            bm2.a("tags").a((Collection)ek2.Q);
        }
        if (Boolean.TRUE.equals((Object)ek2.R)) {
            bm2.a("push_optout").a(1L);
        }
        return bm2.d().toString();
    }

}

