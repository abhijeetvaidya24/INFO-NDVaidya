/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 *  com.yandex.metrica.impl.ob.bx
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.yandex.metrica.impl.ob.bo;
import com.yandex.metrica.impl.ob.bv;
import com.yandex.metrica.impl.ob.bx;
import com.yandex.metrica.impl.ob.cw;
import java.util.List;

public class br {
    private final bv a;
    private String b;

    public br(bo bo2, String string2) {
        this.a = new bx(bo2);
        this.b = string2;
    }

    /*
     * Exception decompiling
     */
    public List<cw> a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl67.1 : ALOAD_0 : trying to set 1 previously set to 0
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
    public void a(List<cw> list) {
        SQLiteDatabase sQLiteDatabase = this.a.a();
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("delete from permissions");
            for (cw cw2 : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", cw2.b());
                int n2 = cw2.a() ? 1 : 0;
                contentValues.put("granted", Integer.valueOf((int)n2));
                sQLiteDatabase.insert("permissions", null, contentValues);
            }
            sQLiteDatabase.setTransactionSuccessful();
            return;
        }
        catch (SQLException sQLException) {}
        return;
        finally {
            sQLiteDatabase.endTransaction();
            this.a.a(sQLiteDatabase);
        }
    }
}

