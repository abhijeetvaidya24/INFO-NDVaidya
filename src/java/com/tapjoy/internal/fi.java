/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.tapjoy.internal.bm
 *  com.tapjoy.internal.fk
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.tapjoy.internal;

import android.os.SystemClock;
import com.tapjoy.internal.bm;
import com.tapjoy.internal.fk;
import com.tapjoy.internal.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class fi {
    static Set a;
    private static final ThreadLocal b;
    private static fi c;
    private static volatile boolean d;

    static {
        b = new ThreadLocal(){

            protected final /* synthetic */ Object initialValue() {
                return new HashMap();
            }
        };
        d = false;
        a = null;
    }

    public static a a(String string2) {
        a a2 = new a(string2).a();
        ((Map)b.get()).put((Object)string2, (Object)a2);
        return a2;
    }

    public static void a(fk fk2) {
        if (c == null) {
            c = fk2;
            if (d) {
                fk2.a(y.b());
            }
        }
    }

    public static void a(String string2, a a2) {
        if (a2 != null) {
            if (string2.equals((Object)a2.a)) {
                ((Map)b.get()).put((Object)string2, (Object)a2);
                return;
            }
            Object[] arrobject = new Object[]{string2, a2.a};
            return;
        }
        new Object[1][0] = string2;
    }

    public static void a(String string2, TreeMap treeMap, Map map) {
        String string3 = treeMap != null ? bm.a((Object)treeMap) : null;
        fi.b(string2, string3, map);
    }

    public static void a(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            a = new HashSet(collection);
            return;
        }
        a = null;
    }

    public static void a(boolean bl2) {
        if (d != bl2) {
            d = bl2;
            fi fi2 = c;
            if (fi2 != null) {
                if (bl2) {
                    fi2.a(y.b());
                    return;
                }
                fi2.a();
            }
        }
    }

    public static a b(String string2) {
        a a2 = (a)((Map)b.get()).remove((Object)string2);
        if (a2 != null) {
            return a2.b();
        }
        return new a(string2);
    }

    private static void b(String string2, String string3, Map map) {
        fi fi2;
        Set set = a;
        if (set != null && set.contains((Object)string2)) {
            return;
        }
        if (d && (fi2 = c) != null) {
            fi2.a(y.b(), string2, string3, map);
        }
    }

    public static a c(String string2) {
        return (a)((Map)b.get()).get((Object)string2);
    }

    public static a d(String string2) {
        return (a)((Map)b.get()).remove((Object)string2);
    }

    public static a e(String string2) {
        return new a(string2);
    }

    protected abstract void a();

    protected abstract void a(long var1);

    protected abstract void a(long var1, String var3, String var4, Map var5);

    public static final class a {
        final String a;
        private final TreeMap b = new TreeMap();
        private final Map c = new HashMap();
        private volatile long d;

        a(String string2) {
            this.a = string2;
        }

        public final a a() {
            try {
                this.d = SystemClock.elapsedRealtime();
                return this;
            }
            catch (NullPointerException nullPointerException) {
                this.d = -1L;
                return this;
            }
        }

        public final a a(String string2) {
            this.b.put((Object)"failure", (Object)string2);
            return this;
        }

        public final a a(String string2, long l2) {
            this.c.put((Object)string2, (Object)l2);
            return this;
        }

        public final a a(String string2, Object object) {
            this.b.put((Object)string2, object);
            return this;
        }

        public final a a(Map map) {
            if (map != null) {
                this.b.putAll(map);
            }
            return this;
        }

        /*
         * Exception decompiling
         */
        public final a b() {
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

        public final a b(String string2) {
            this.b.put((Object)"misuse", (Object)string2);
            return this;
        }

        public final a b(Map map) {
            if (map != null) {
                this.c.putAll(map);
            }
            return this;
        }

        public final void c() {
            String string2 = this.a;
            String string3 = this.b.size() > 0 ? bm.a((Object)this.b) : null;
            int n2 = this.c.size();
            Map map = null;
            if (n2 > 0) {
                map = this.c;
            }
            fi.b(string2, string3, map);
        }
    }

}

