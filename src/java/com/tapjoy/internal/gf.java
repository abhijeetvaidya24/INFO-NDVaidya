/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.util.Base64
 *  com.tapjoy.internal.dx
 *  com.tapjoy.internal.dx$a
 *  com.tapjoy.internal.ed
 *  com.tapjoy.internal.ed$a
 *  com.tapjoy.internal.ee
 *  com.tapjoy.internal.ef
 *  com.tapjoy.internal.eh
 *  com.tapjoy.internal.eh$a
 *  com.tapjoy.internal.ei
 *  com.tapjoy.internal.ek
 *  com.tapjoy.internal.ek$a
 *  com.tapjoy.internal.j
 *  com.tapjoy.internal.m
 *  com.tapjoy.internal.q
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Calendar
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Set
 *  java.util.TimeZone
 *  java.util.UUID
 */
package com.tapjoy.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.tapjoy.internal.cr;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.dx;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.ee;
import com.tapjoy.internal.ef;
import com.tapjoy.internal.eh;
import com.tapjoy.internal.ei;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.gm;
import com.tapjoy.internal.j;
import com.tapjoy.internal.m;
import com.tapjoy.internal.q;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

public final class gf {
    public static final String a = UUID.randomUUID().toString();
    private static gf d;
    public final ek.a b;
    public final gm c;
    private final ed.a e;
    private final dx.a f;
    private final Context g;

    /*
     * Exception decompiling
     */
    private gf(Context var1, gm var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl639 : ALOAD_0 : trying to set 1 previously set to 0
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

    private static int a(int n2, int n3) {
        return Integer.bitCount((int)(n3 & (1 << n2) - 1));
    }

    public static gf a(Context context) {
        Class<gf> class_ = gf.class;
        synchronized (gf.class) {
            if (d == null) {
                d = new gf(context, gm.a(context));
            }
            gf gf2 = d;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return gf2;
        }
    }

    /*
     * Exception decompiling
     */
    private static String a(PackageManager var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl21.1 : ACONST_NULL : trying to set 1 previously set to 0
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

    private void g() {
        String string2 = Base64.encodeToString((byte[])ei.c.b((Object)new ei(this.b.g)), (int)2);
        this.c.g.a(string2);
    }

    /*
     * Exception decompiling
     */
    final void a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl64.1 : ALOAD : trying to set 1 previously set to 0
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(int n2, String string2) {
        gf gf2 = this;
        synchronized (gf2) {
            boolean bl2;
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 != 5) {
                                return false;
                            }
                            this.c.y.a(string2);
                            bl2 = true ^ cr.a(this.b.z, string2);
                            if (!bl2) return bl2;
                            this.b.z = string2;
                        } else {
                            this.c.x.a(string2);
                            bl2 = true ^ cr.a(this.b.y, string2);
                            if (!bl2) return bl2;
                            this.b.y = string2;
                        }
                    } else {
                        this.c.w.a(string2);
                        bl2 = true ^ cr.a(this.b.x, string2);
                        if (!bl2) return bl2;
                        this.b.x = string2;
                    }
                } else {
                    this.c.v.a(string2);
                    bl2 = true ^ cr.a(this.b.w, string2);
                    if (!bl2) return bl2;
                    this.b.w = string2;
                }
            } else {
                this.c.u.a(string2);
                bl2 = true ^ cr.a(this.b.v, string2);
                if (!bl2) return bl2;
                this.b.v = string2;
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(Integer n2) {
        gf gf2 = this;
        synchronized (gf2) {
            this.c.s.a(n2);
            boolean bl2 = true ^ cr.a((Object)this.b.t, (Object)n2);
            if (bl2) {
                this.b.t = n2;
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(String string2) {
        gf gf2 = this;
        synchronized (gf2) {
            boolean bl2;
            block7 : {
                block6 : {
                    block5 : {
                        block4 : {
                            block3 : {
                                block2 : {
                                    this.c.q.a(string2);
                                    bl2 = true;
                                    if (string2 == null) break block2;
                                    if (cr.a(this.f.e, string2)) break block3;
                                    break block4;
                                }
                                if (this.f.e == null) break block5;
                                break block6;
                            }
                            bl2 = false;
                        }
                        this.f.e = string2;
                        break block7;
                    }
                    bl2 = false;
                }
                this.f.e = null;
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final boolean a(String string2, long l2, boolean bl2) {
        gf gf2 = this;
        synchronized (gf2) {
            int n2 = this.b.g.size();
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    this.b.g.add((Object)new eh(string2, Long.valueOf((long)l2)));
                    this.g();
                    return true;
                }
                eh eh2 = (eh)this.b.g.get(n3);
                if (eh2.f.equals((Object)string2)) {
                    if (!bl2) return false;
                    eh.a a2 = eh2.b();
                    a2.d = l2;
                    this.b.g.set(n3, (Object)a2.b());
                    return true;
                }
                ++n3;
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(boolean bl2) {
        gf gf2 = this;
        synchronized (gf2) {
            this.c.C.a(bl2);
            boolean bl3 = bl2 != (Boolean)cr.b((Object)this.b.B, (Object)ek.r);
            this.b.B = bl2;
            return bl3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final ee b() {
        gf gf2 = this;
        synchronized (gf2) {
            this.e.l = Locale.getDefault().toString();
            this.e.m = TimeZone.getDefault().getID();
            boolean bl2 = false;
            long l2 = System.currentTimeMillis() - 259200000L;
            Iterator iterator = this.b.g.iterator();
            while (iterator.hasNext()) {
                if (((eh)iterator.next()).g > l2) continue;
                iterator.remove();
                bl2 = true;
            }
            if (!bl2) return new ee(this.e.b(), this.f.b(), this.b.b());
            this.g();
            return new ee(this.e.b(), this.f.b(), this.b.b());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean b(Integer n2) {
        gf gf2 = this;
        synchronized (gf2) {
            this.c.t.a(n2);
            boolean bl2 = true ^ cr.a((Object)this.b.u, (Object)n2);
            if (bl2) {
                this.b.u = n2;
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean b(String string2) {
        gf gf2 = this;
        synchronized (gf2) {
            this.c.r.a(string2);
            boolean bl2 = true ^ cr.a(this.b.s, string2);
            if (bl2) {
                this.b.s = string2;
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final String c() {
        gf gf2 = this;
        synchronized (gf2) {
            return this.c.d.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean c(String string2) {
        gf gf2 = this;
        synchronized (gf2) {
            int n2 = this.b.g.size() - 1;
            while (n2 >= 0) {
                eh eh2 = (eh)this.b.g.get(n2);
                if (eh2.f.equals((Object)string2)) {
                    eh.a a2 = eh2.b();
                    a2.e = System.currentTimeMillis();
                    this.b.g.set(n2, (Object)a2.b());
                    this.g();
                    return true;
                }
                --n2;
            }
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final ef d() {
        gf gf2 = this;
        synchronized (gf2) {
            int n2;
            ef ef2;
            int n3;
            block9 : {
                int n4;
                int n5;
                int n6;
                int n7;
                block10 : {
                    long l2;
                    Calendar calendar;
                    Calendar calendar2 = Calendar.getInstance();
                    n3 = 1;
                    n2 = 100 + (10000 * calendar2.get(n3) + 100 * calendar2.get(2)) + calendar2.get(5);
                    int n8 = this.c.e.a();
                    if (n8 == n2) return null;
                    if (n8 == 0) {
                        this.b.e = n3;
                        this.b.f = n3;
                        ef2 = new ef("fq7_0_1", "fq30_0_1", null);
                        break block9;
                    }
                    n7 = this.c.f.a();
                    n6 = gf.a(7, n7);
                    n4 = gf.a(30, n7);
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.set(n8 / 10000, n8 / 100 % 100 - n3, n8 % 100);
                    int n9 = Integer.signum((int)(calendar2.get(n3) - calendar3.get(n3)));
                    if (n9 != -1) {
                        if (n9 != n3) {
                            n5 = calendar2.get(6) - calendar3.get(6);
                            break block10;
                        }
                        calendar = (Calendar)calendar2.clone();
                        calendar.set(calendar3.get(n3), calendar3.get(2), calendar3.get(5));
                        l2 = calendar2.getTimeInMillis();
                    } else {
                        calendar = (Calendar)calendar3.clone();
                        calendar.set(calendar2.get(n3), calendar2.get(2), calendar2.get(5));
                        l2 = calendar3.getTimeInMillis();
                    }
                    n5 = 0;
                    while (calendar.getTimeInMillis() < l2) {
                        calendar.add(5, n3);
                        ++n5;
                    }
                    if (n9 > 0) break block10;
                    n5 = -n5;
                }
                int n10 = Math.abs((int)n5) >= 30 ? 0 : (n5 >= 0 ? n7 << n5 : n7 >> -n5);
                int n11 = gf.a(7, n3 |= n10);
                int n12 = gf.a(30, n3);
                this.b.e = n11;
                this.b.f = n12;
                StringBuilder stringBuilder = new StringBuilder("fq7_");
                stringBuilder.append(n6);
                stringBuilder.append("_");
                stringBuilder.append(n11);
                String string2 = stringBuilder.toString();
                StringBuilder stringBuilder2 = new StringBuilder("fq30_");
                stringBuilder2.append(n4);
                stringBuilder2.append("_");
                stringBuilder2.append(n12);
                ef2 = new ef(string2, stringBuilder2.toString(), null);
            }
            this.c.e.a(n2);
            this.c.f.a(n3);
            return ef2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Set e() {
        gf gf2 = this;
        synchronized (gf2) {
            return new HashSet((Collection)this.b.A);
        }
    }

    public final boolean f() {
        return (Boolean)cr.b((Object)this.b.B, (Object)ek.r);
    }
}

