/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.sqlite.SQLiteDatabase
 *  com.yandex.metrica.impl.bk
 *  com.yandex.metrica.impl.ob.bx
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.ob.bo;
import com.yandex.metrica.impl.ob.bv;
import com.yandex.metrica.impl.ob.bx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class bq {
    private final Map<String, Object> a = new HashMap();
    private final Map<String, Object> b = new HashMap();
    private final String c;
    private final a d;
    private volatile boolean e;
    private final bv f;

    static {
        bq.class.getSimpleName();
    }

    public bq(bo bo2, String string2) {
        this(string2, (bv)new bx(bo2));
    }

    protected bq(String string2, bv bv2) {
        this.f = bv2;
        this.c = string2;
        this.d = new a(0);
        this.d.start();
    }

    static /* synthetic */ Map a(bq bq2) {
        return bq2.a;
    }

    static /* synthetic */ void a(bq bq2, Map map) {
        ContentValues[] arrcontentValues = new ContentValues[map.size()];
        Iterator iterator = map.entrySet().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            block9 : {
                ContentValues contentValues;
                block4 : {
                    Object object;
                    block8 : {
                        block7 : {
                            block6 : {
                                block5 : {
                                    block3 : {
                                        Map.Entry entry = (Map.Entry)iterator.next();
                                        contentValues = new ContentValues();
                                        String string2 = (String)entry.getKey();
                                        object = entry.getValue();
                                        contentValues.put("key", string2);
                                        if (object != bq2) break block3;
                                        contentValues.putNull("value");
                                        break block4;
                                    }
                                    if (!(object instanceof String)) break block5;
                                    contentValues.put("value", (String)object);
                                    contentValues.put("type", Integer.valueOf((int)4));
                                    break block4;
                                }
                                if (!(object instanceof Long)) break block6;
                                contentValues.put("value", (Long)object);
                                contentValues.put("type", Integer.valueOf((int)3));
                                break block4;
                            }
                            if (!(object instanceof Integer)) break block7;
                            contentValues.put("value", (Integer)object);
                            contentValues.put("type", Integer.valueOf((int)2));
                            break block4;
                        }
                        if (!(object instanceof Boolean)) break block8;
                        contentValues.put("value", String.valueOf((boolean)((Boolean)object)));
                        contentValues.put("type", Integer.valueOf((int)1));
                        break block4;
                    }
                    if (object != null) break block9;
                }
                arrcontentValues[n2] = contentValues;
                ++n2;
                continue;
            }
            throw new UnsupportedOperationException();
        }
        bq2.a(arrcontentValues);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2, Object object) {
        a a2;
        Map<String, Object> map;
        Map<String, Object> map2 = map = this.a;
        synchronized (map2) {
            this.c();
            this.a.put((Object)string2, object);
        }
        a a3 = a2 = this.d;
        synchronized (a3) {
            this.b.put((Object)string2, object);
            this.d.notifyAll();
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(ContentValues[] arrcontentValues) {
        SQLiteDatabase sQLiteDatabase;
        int n3;
        int n2;
        block12 : {
            SQLiteDatabase sQLiteDatabase2;
            block14 : {
                Exception exception2;
                void var3_10;
                block13 : {
                    if (arrcontentValues == null) {
                        return;
                    }
                    sQLiteDatabase2 = null;
                    sQLiteDatabase = this.f.a();
                    try {
                        sQLiteDatabase.beginTransaction();
                        n3 = arrcontentValues.length;
                        n2 = 0;
                        break block12;
                    }
                    catch (Throwable throwable) {
                        break block13;
                    }
                    catch (Exception exception2) {
                        sQLiteDatabase2 = sQLiteDatabase;
                        break block14;
                    }
                    catch (Throwable throwable) {
                        sQLiteDatabase = null;
                    }
                }
                bk.a((SQLiteDatabase)sQLiteDatabase);
                this.f.a(sQLiteDatabase);
                throw var3_10;
                catch (Exception exception2) {
                    // empty catch block
                }
            }
            bk.a(sQLiteDatabase2);
            this.f.a(sQLiteDatabase2);
            return;
        }
        do {
            if (n2 < n3) {
                ContentValues contentValues = arrcontentValues[n2];
                if (contentValues.getAsString("value") == null) {
                    String string2 = contentValues.getAsString("key");
                    sQLiteDatabase.delete(this.a(), "key = ?", new String[]{string2});
                } else {
                    sQLiteDatabase.insertWithOnConflict(this.a(), null, contentValues, 5);
                }
            } else {
                sQLiteDatabase.setTransactionSuccessful();
                bk.a((SQLiteDatabase)sQLiteDatabase);
                this.f.a(sQLiteDatabase);
                return;
            }
            ++n2;
        } while (true);
    }

    static /* synthetic */ boolean a(bq bq2, boolean bl2) {
        bq2.e = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object b(String string2) {
        Map<String, Object> map;
        Map<String, Object> map2 = map = this.a;
        synchronized (map2) {
            this.c();
            return this.a.get((Object)string2);
        }
    }

    /*
     * Exception decompiling
     */
    static /* synthetic */ void b(bq var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl102 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
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

    static /* synthetic */ Map c(bq bq2) {
        return bq2.b;
    }

    /*
     * Exception decompiling
     */
    private void c() {
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

    public int a(String string2, int n2) {
        Object object = this.b(string2);
        if (object instanceof Integer) {
            return (Integer)object;
        }
        return n2;
    }

    public long a(String string2, long l2) {
        Object object = this.b(string2);
        if (object instanceof Long) {
            return (Long)object;
        }
        return l2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public bq a(String string2) {
        Map<String, Object> map;
        a a2;
        Map<String, Object> map2 = map = this.a;
        synchronized (map2) {
            this.c();
            this.a.remove((Object)string2);
        }
        a a3 = a2 = this.d;
        synchronized (a3) {
            this.b.put((Object)string2, (Object)this);
            this.d.notifyAll();
            return this;
        }
    }

    String a() {
        return this.c;
    }

    public String a(String string2, String string3) {
        Object object = this.b(string2);
        if (object instanceof String) {
            return (String)object;
        }
        return string3;
    }

    public boolean a(String string2, boolean bl2) {
        Object object = this.b(string2);
        if (object instanceof Boolean) {
            return (Boolean)object;
        }
        return bl2;
    }

    public bq b(String string2, int n2) {
        bq bq2 = this;
        synchronized (bq2) {
            this.a(string2, (Object)n2);
            return this;
        }
    }

    public bq b(String string2, long l2) {
        this.a(string2, (Object)l2);
        return this;
    }

    public bq b(String string2, String string3) {
        bq bq2 = this;
        synchronized (bq2) {
            this.a(string2, (Object)string3);
            return this;
        }
    }

    public bq b(String string2, boolean bl2) {
        this.a(string2, (Object)bl2);
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        a a2;
        a a3 = a2 = this.d;
        synchronized (a3) {
            this.d.notifyAll();
            return;
        }
    }

    private class a
    extends Thread {
        private a() {
        }

        /* synthetic */ a(byte by) {
            this();
        }

        /*
         * Exception decompiling
         */
        public void run() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl42 : NEW : trying to set 1 previously set to 0
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
    }

}

