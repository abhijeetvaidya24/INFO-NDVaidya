/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteFullException
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.appnext.base.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import com.appnext.base.a.a.a;
import com.appnext.base.a.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class e<MODEL extends d> {
    private static final int eh = -1;
    private static final String ei = " DESC";

    protected static long a(SQLiteDatabase sQLiteDatabase, String string2, ContentValues contentValues) {
        try {
            long l2 = sQLiteDatabase.insertWithOnConflict(string2, null, contentValues, 5);
            return l2;
        }
        catch (Throwable throwable) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.Global$53629b42, throwable);
            return -1L;
        }
        catch (SQLiteFullException sQLiteFullException) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.DatabaseOrDiskFull$53629b42, new Exception(sQLiteFullException.getMessage()));
            return -1L;
        }
    }

    protected static long a(String string2, ContentValues contentValues) {
        try {
            long l2 = com.appnext.base.a.a.a.ac().ad().insert(string2, null, contentValues);
            com.appnext.base.a.a.a.ac().ae();
            return l2;
        }
        catch (Throwable throwable) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.Global$53629b42, throwable);
            return -1L;
        }
        catch (SQLiteFullException sQLiteFullException) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.DatabaseOrDiskFull$53629b42, new Exception(sQLiteFullException.getMessage()));
            return -1L;
        }
    }

    /*
     * Exception decompiling
     */
    private static String a(String[] var0, List<a> var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl41.1 : ALOAD_2 : trying to set 1 previously set to 0
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

    protected static long b(SQLiteDatabase sQLiteDatabase, String string2, ContentValues contentValues) {
        try {
            long l2 = sQLiteDatabase.insert(string2, null, contentValues);
            return l2;
        }
        catch (Throwable throwable) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.Global$53629b42, throwable);
            return -1L;
        }
        catch (SQLiteFullException sQLiteFullException) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.DatabaseOrDiskFull$53629b42, new Exception(sQLiteFullException.getMessage()));
            return -1L;
        }
    }

    protected static long b(String string2, ContentValues contentValues) {
        try {
            long l2 = com.appnext.base.a.a.a.ac().ad().insertWithOnConflict(string2, null, contentValues, 5);
            com.appnext.base.a.a.a.ac().ae();
            return l2;
        }
        catch (Throwable throwable) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.Global$53629b42, throwable);
            return -1L;
        }
        catch (SQLiteFullException sQLiteFullException) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.DatabaseOrDiskFull$53629b42, new Exception(sQLiteFullException.getMessage()));
            return -1L;
        }
    }

    private static ContentValues b(JSONObject jSONObject) {
        try {
            ContentValues contentValues = new ContentValues();
            Iterator iterator = jSONObject.keys();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                contentValues.put(string2, jSONObject.getString(string2));
            }
            return contentValues;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private List<MODEL> e(Cursor cursor) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add(this.b(cursor));
                cursor.moveToNext();
            }
            cursor.close();
        }
        catch (Throwable throwable) {}
        return arrayList;
    }

    protected static void e(String string2, String string3) {
        try {
            com.appnext.base.a.a.a.ac().ad().delete(string2, string3, null);
            com.appnext.base.a.a.a.ac().ae();
            return;
        }
        catch (Throwable throwable) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.Global$53629b42, new Exception(throwable.getMessage()));
            return;
        }
        catch (SQLiteFullException sQLiteFullException) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.DatabaseOrDiskFull$53629b42, new Exception(sQLiteFullException.getMessage()));
            return;
        }
    }

    protected static String z(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(ei);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final int a(String string2, String[] arrstring, String[] arrstring2, List<a> list) {
        int n2 = 0;
        try {
            SQLiteDatabase sQLiteDatabase = com.appnext.base.a.a.a.ac().ad();
            String string3 = null;
            n2 = 0;
            if (arrstring != null) {
                string3 = e.a(arrstring, list);
            }
            n2 = sQLiteDatabase.delete(string2, string3, arrstring2);
            com.appnext.base.a.a.a.ac().ae();
            return n2;
        }
        catch (Throwable throwable) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.Global$53629b42, new Exception(throwable.getMessage()));
            return n2;
        }
        catch (SQLiteFullException sQLiteFullException) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.DatabaseOrDiskFull$53629b42, new Exception(sQLiteFullException.getMessage()));
            return n2;
        }
    }

    /*
     * Exception decompiling
     */
    protected final long a(String var1, JSONArray var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl34 : ALOAD : trying to set 1 previously set to 0
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

    protected final long a(String string2, JSONObject jSONObject) {
        try {
            long l2 = com.appnext.base.a.a.a.ac().ad().insertWithOnConflict(string2, null, e.b(jSONObject), 5);
            com.appnext.base.a.a.a.ac().ae();
            return l2;
        }
        catch (Throwable throwable) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.Global$53629b42, throwable);
            return -1L;
        }
        catch (SQLiteFullException sQLiteFullException) {
            com.appnext.base.a.a.a.ac();
            com.appnext.base.a.a.a.a(a.a.DatabaseOrDiskFull$53629b42, new Exception(sQLiteFullException.getMessage()));
            return -1L;
        }
    }

    protected final List<MODEL> a(String string2, String[] arrstring, String[] arrstring2, String string3, List<a> list) {
        try {
            List<MODEL> list2 = this.e(com.appnext.base.a.a.a.ac().ad().query(string2, this.at(), e.a(arrstring, list), arrstring2, null, null, string3));
            com.appnext.base.a.a.a.ac().ae();
            return list2;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    protected abstract String[] at();

    /*
     * Exception decompiling
     */
    protected final long b(String var1, JSONArray var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl34 : ALOAD : trying to set 1 previously set to 0
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

    protected abstract MODEL b(Cursor var1);

    protected final void delete(String string2) {
        this.a(string2, null, null, null);
    }

    protected final List<MODEL> y(String string2) {
        try {
            List<MODEL> list = this.e(com.appnext.base.a.a.a.ac().ad().query(string2, this.at(), null, null, null, null, null));
            com.appnext.base.a.a.a.ac().ae();
            return list;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    protected static final class a
    extends Enum<a> {
        private static final /* synthetic */ a[] $VALUES;
        public static final /* enum */ a Equals = new a(" = ? ");
        public static final /* enum */ a GreaterThan = new a(" >= ? ");
        public static final /* enum */ a LessThan = new a(" <= ? ");
        private String mOperator;

        static {
            a[] arra = new a[]{Equals, GreaterThan, LessThan};
            $VALUES = arra;
        }

        private a(String string3) {
            this.mOperator = string3;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])$VALUES.clone();
        }

        public final String au() {
            return this.mOperator;
        }
    }

}

