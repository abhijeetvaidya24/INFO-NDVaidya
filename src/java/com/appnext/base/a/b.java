/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  com.appnext.base.a.c.b
 *  java.lang.Class
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.appnext.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class b
extends SQLiteOpenHelper {
    private static final String dx = "appnext_dbs472";
    private static final int dy = 12;
    private static volatile b dz;

    private b(Context context) {
        super(context, dx, null, 12);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b c(Context context) {
        if (dz != null) return dz;
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (dz != null) return dz;
            dz = new b(context.getApplicationContext());
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return dz;
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ct");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS collected_data_table");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS config_table");
            this.onCreate(sQLiteDatabase);
        }
        catch (Throwable throwable) {}
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table ct ( p text, c integer)");
            sQLiteDatabase.execSQL(com.appnext.base.a.c.b.ar());
            sQLiteDatabase.execSQL("create table config_table ( key text primary key, status text not null default 'off', sample text not null default '1', sample_type text not null default '',cycle text not null default '1', cycle_type text not null default 'once', service_key text not null default '', data text not null default '')");
        }
        catch (Throwable throwable) {}
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ct");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS collected_data_table");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS config_table");
            this.onCreate(sQLiteDatabase);
        }
        catch (Throwable throwable) {}
    }
}

