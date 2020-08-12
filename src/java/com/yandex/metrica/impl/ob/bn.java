/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.DatabaseUtils
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.text.TextUtils
 *  com.yandex.metrica.YandexMetrica
 *  com.yandex.metrica.impl.a
 *  com.yandex.metrica.impl.a$a
 *  com.yandex.metrica.impl.bi
 *  com.yandex.metrica.impl.bk
 *  com.yandex.metrica.impl.h
 *  com.yandex.metrica.impl.k
 *  com.yandex.metrica.impl.ob.bj
 *  com.yandex.metrica.impl.ob.bl
 *  com.yandex.metrica.impl.utils.j
 *  java.io.Closeable
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReentrantReadWriteLock
 *  java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock
 *  java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock
 */
package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.a;
import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.h;
import com.yandex.metrica.impl.k;
import com.yandex.metrica.impl.ob.bj;
import com.yandex.metrica.impl.ob.bl;
import com.yandex.metrica.impl.ob.bo;
import com.yandex.metrica.impl.ob.r;
import com.yandex.metrica.impl.ob.u;
import com.yandex.metrica.impl.p;
import com.yandex.metrica.impl.utils.j;
import com.yandex.metrica.impl.utils.m;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class bn
implements Closeable {
    private final ReentrantReadWriteLock a = new ReentrantReadWriteLock();
    private final Lock b = this.a.readLock();
    private final Lock c = this.a.writeLock();
    private final bo d;
    private final a e;
    private final Object f = new Object();
    private final List<ContentValues> g = new ArrayList(3);
    private ContentValues h;
    private final Context i;
    private final u j;
    private final AtomicLong k = new AtomicLong();

    public bn(u u2, bo bo2) {
        this.d = bo2;
        this.i = u2.m();
        this.j = u2;
        this.k.set(this.b());
        a a2 = this.e = new a();
        StringBuilder stringBuilder = new StringBuilder("DatabaseWorker [");
        stringBuilder.append((Object)u2.l());
        stringBuilder.append("]");
        a2.setName(stringBuilder.toString());
        this.e.start();
        this.c();
    }

    private static long a(Cursor cursor) {
        try {
            if (cursor.moveToFirst()) {
                long l2 = cursor.getLong(0);
                return l2;
            }
            return 0L;
        }
        finally {
            bk.a((Cursor)cursor);
        }
    }

    private Cursor a(String string2) {
        try {
            Cursor cursor = this.d.getReadableDatabase().query("reports", null, string2, null, null, null, null, null);
            return cursor;
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static String a(String string2, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder(string2);
        for (String string3 : map.keySet()) {
            String string4 = stringBuilder.length() > 0 ? " AND " : "";
            stringBuilder.append(string4);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string3);
            stringBuilder2.append(" = ? ");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (bi.a((String)stringBuilder.toString())) {
            return null;
        }
        return stringBuilder.toString();
    }

    private void a(ContentValues contentValues, String string2) {
        Integer n2 = contentValues.getAsInteger("type");
        int n3 = n2 != null ? n2 : -1;
        if (p.b(n3)) {
            StringBuilder stringBuilder = new StringBuilder(string2);
            stringBuilder.append(": ");
            stringBuilder.append(bn.b(contentValues, "name"));
            String string3 = bn.b(contentValues, "value");
            if (p.c(contentValues.getAsInteger("type")) && !TextUtils.isEmpty((CharSequence)string3)) {
                stringBuilder.append(" with value ");
                stringBuilder.append(string3);
            }
            this.j.p().a(stringBuilder.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void a(bn bn2, ContentValues contentValues) {
        if (contentValues == null) {
            return;
        }
        bn2.c.lock();
        try {
            bn2.d.getWritableDatabase().insertOrThrow("sessions", null, contentValues);
            return;
        }
        catch (Exception exception) {}
        return;
        finally {
            bn2.c.unlock();
        }
    }

    /*
     * Exception decompiling
     */
    static /* synthetic */ void a(bn var0, List var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl57 : ALOAD_0 : trying to set 1 previously set to 0
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

    private void a(List<ContentValues> list, String string2) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            this.a((ContentValues)list.get(i2), string2);
        }
    }

    static /* synthetic */ boolean a(bn bn2) {
        return bn2.d();
    }

    private static String[] a(String[] arrstring, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection)Arrays.asList((Object[])arrstring));
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            arrayList.add(((Map.Entry)iterator.next()).getValue());
        }
        return (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
    }

    private long b() {
        this.b.lock();
        try {
            long l2 = bn.a(this.d.getReadableDatabase().rawQuery("SELECT count() FROM reports", null));
            return l2;
        }
        catch (Exception exception) {
            return 0L;
        }
        finally {
            this.b.unlock();
        }
    }

    static /* synthetic */ ContentValues b(bn bn2, ContentValues contentValues) {
        bn2.h = contentValues;
        return contentValues;
    }

    static /* synthetic */ Object b(bn bn2) {
        return bn2.f;
    }

    private static String b(ContentValues contentValues, String string2) {
        return bi.b((String)contentValues.getAsString(string2), (String)"");
    }

    static /* synthetic */ List c(bn bn2) {
        return bn2.g;
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

    static /* synthetic */ ContentValues d(bn bn2) {
        return bn2.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean d() {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            if (this.h != null) return false;
            if (!this.g.isEmpty()) return false;
            return true;
        }
    }

    int a(SQLiteDatabase sQLiteDatabase) {
        Object[] arrobject = new Integer[p.a.size()];
        Iterator iterator = p.a.iterator();
        int n2 = 0;
        do {
            if (!iterator.hasNext()) break;
            p.a a2 = (p.a)((Object)iterator.next());
            int n3 = n2 + 1;
            arrobject[n2] = a2.a();
            n2 = n3;
            continue;
            break;
        } while (true);
        try {
            long l2 = System.currentTimeMillis() / 1000L - TimeUnit.DAYS.toSeconds(14L);
            Object[] arrobject2 = new Object[]{"type", TextUtils.join((CharSequence)",", (Object[])arrobject), "id", "reports", "session_id", "number", 10, l2};
            int n4 = sQLiteDatabase.delete("reports", String.format((String)"%1$s NOT IN (%2$s) AND (%3$s IN (SELECT %3$s FROM %4$s ORDER BY %5$s, %6$s LIMIT (SELECT count() FROM %4$s) / %7$s ) OR %5$s < %8$s )", (Object[])arrobject2), null);
            return n4;
        }
        catch (Throwable throwable) {
            YandexMetrica.getReporter((Context)this.i, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportError("deleteExcessiveReports exception", throwable);
            return 0;
        }
    }

    /*
     * Exception decompiling
     */
    public int a(long[] var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl119.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    public long a() {
        this.b.lock();
        try {
            long l2 = this.k.get();
            return l2;
        }
        finally {
            this.b.unlock();
        }
    }

    public Cursor a(long l2, Map<String, String> map) {
        this.b.lock();
        try {
            SQLiteDatabase sQLiteDatabase = this.d.getReadableDatabase();
            String string2 = bn.a("id = ?", map);
            String[] arrstring = new String[]{Long.toString((long)l2)};
            Cursor cursor = sQLiteDatabase.query("sessions", null, string2, bn.a(arrstring, map), null, null, null, null);
            return cursor;
        }
        catch (Exception exception) {
            return null;
        }
        finally {
            this.b.unlock();
        }
    }

    public Cursor a(Map<String, String> map) {
        this.b.lock();
        try {
            SQLiteDatabase sQLiteDatabase = this.d.getReadableDatabase();
            String string2 = bn.a("id >= ?", map);
            String[] arrstring = new String[]{Long.toString((long)0L)};
            Cursor cursor = sQLiteDatabase.query("sessions", null, string2, bn.a(arrstring, map), null, null, "id ASC", null);
            return cursor;
        }
        catch (Exception exception) {
            return null;
        }
        finally {
            this.b.unlock();
        }
    }

    /*
     * Exception decompiling
     */
    public List<ContentValues> a(Long var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl56 : ALOAD_3 : trying to set 1 previously set to 0
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
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(long l2, int n2, int n3) throws SQLiteException {
        Cursor cursor;
        block13 : {
            String string2;
            ArrayList arrayList;
            SQLiteDatabase sQLiteDatabase;
            block11 : {
                block9 : {
                    block10 : {
                        Exception exception2;
                        Cursor cursor2;
                        void var8_15;
                        block12 : {
                            if (n3 <= 0) {
                                return;
                            }
                            this.c.lock();
                            cursor2 = null;
                            sQLiteDatabase = this.d.getWritableDatabase();
                            Locale locale = Locale.US;
                            Object[] arrobject = new Object[]{"session_id", Long.toString((long)l2), "session_type", Integer.toString((int)n2), "id", "reports", Integer.toString((int)(n3 - 1))};
                            string2 = String.format((Locale)locale, (String)"%1$s = %2$s AND %3$s = %4$s AND %5$s <= (SELECT %5$s FROM %6$s WHERE %1$s = %2$s AND %3$s = %4$s ORDER BY %5$s ASC LIMIT %7$s, 1)", (Object[])arrobject);
                            if (!this.j.p().b()) break block9;
                            cursor = this.a(string2);
                            if (cursor == null) break block10;
                            try {
                                if (cursor.getCount() <= 0) break block10;
                                arrayList = new ArrayList(cursor.getCount());
                                while (cursor.moveToNext()) {
                                    ContentValues contentValues = new ContentValues();
                                    DatabaseUtils.cursorRowToContentValues((Cursor)cursor, (ContentValues)contentValues);
                                    arrayList.add((Object)contentValues);
                                }
                                break block11;
                            }
                            catch (Exception exception2) {}
                            break block13;
                            catch (Throwable throwable) {
                                cursor2 = cursor;
                                break block12;
                            }
                            catch (Throwable throwable) {
                                // empty catch block
                            }
                        }
                        bk.a(cursor2);
                        this.c.unlock();
                        throw var8_15;
                        catch (Exception exception2) {
                            cursor = null;
                            break block13;
                        }
                    }
                    arrayList = null;
                    break block11;
                }
                cursor = null;
                arrayList = null;
            }
            int n4 = sQLiteDatabase.delete("reports", string2, null);
            if (arrayList != null) {
                this.a((List<ContentValues>)arrayList, "Event removed from db");
            }
            this.k.addAndGet((long)(-n4));
        }
        bk.a(cursor);
        this.c.unlock();
    }

    public void a(long l2, bl bl2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf((long)l2));
        contentValues.put("start_time", Long.valueOf((long)(System.currentTimeMillis() / 1000L)));
        contentValues.put("server_time_offset", Long.valueOf((long)m.a()));
        contentValues.put("type", Integer.valueOf((int)bl2.a()));
        new k(this.i).a(this.j).a(contentValues).a();
        this.a(contentValues);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(ContentValues contentValues) {
        a a2;
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            this.h = contentValues;
        }
        a a3 = a2 = this.e;
        synchronized (a3) {
            this.e.notifyAll();
            return;
        }
    }

    public void a(h h2, bj bj2, a.a a2) {
        ContentValues contentValues = new ContentValues(20);
        contentValues.put("number", Long.valueOf((long)bj2.c()));
        contentValues.put("time", Long.valueOf((long)bj2.d()));
        contentValues.put("session_id", Long.valueOf((long)bj2.a()));
        contentValues.put("session_type", Integer.valueOf((int)bj2.b().a()));
        new k(this.i).a(this.j).a(contentValues).a(h2, a2);
        this.b(contentValues);
    }

    public void a(u u2) {
        this.e.a(u2);
    }

    public Cursor b(long l2, bl bl2) throws SQLiteException {
        this.b.lock();
        try {
            SQLiteDatabase sQLiteDatabase = this.d.getReadableDatabase();
            String[] arrstring = new String[]{Long.toString((long)l2), Integer.toString((int)bl2.a())};
            Cursor cursor = sQLiteDatabase.query("reports", null, "session_id = ? AND session_type = ?", arrstring, null, null, "number ASC", null);
            return cursor;
        }
        catch (Exception exception) {
            return null;
        }
        finally {
            this.b.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(ContentValues contentValues) {
        a a2;
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            this.g.add((Object)contentValues);
        }
        a a3 = a2 = this.e;
        synchronized (a3) {
            this.e.notifyAll();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public ContentValues c(long var1, bl var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl59.1 : ALOAD : trying to set 1 previously set to 0
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

    public void close() {
        this.g.clear();
        this.e.a();
    }

    private class a
    extends Thread {
        private final List<ContentValues> b = new ArrayList();
        private u c;

        void a() {
            a a2 = this;
            synchronized (a2) {
                this.interrupt();
                this.c = null;
                return;
            }
        }

        void a(u u2) {
            a a2 = this;
            synchronized (a2) {
                this.c = u2;
                return;
            }
        }

        void b() {
            a a2 = this;
            synchronized (a2) {
                if (this.c != null && !this.c.o()) {
                    this.c.b();
                }
                return;
            }
        }

        /*
         * Exception decompiling
         */
        public void run() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl24 : ALOAD_0 : trying to set 1 previously set to 0
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

