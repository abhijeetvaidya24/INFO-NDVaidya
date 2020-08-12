/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  com.yandex.metrica.impl.ob.bm
 *  java.io.Closeable
 *  java.lang.String
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.yandex.metrica.impl.ob.bm;
import com.yandex.metrica.impl.ob.bs;
import java.io.Closeable;

public class bo
extends SQLiteOpenHelper
implements Closeable {
    protected final bs a;

    public bo(Context context, String string2, bs bs2) {
        super(context, string2, null, bm.b);
        this.a = bs2;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.b(sQLiteDatabase);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        this.a.a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        this.a.a(sQLiteDatabase, n2, n3);
    }
}

