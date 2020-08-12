/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.util.Log
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.SimpleDateFormat
 */
package com.appsgeyser.multiTabApp.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.text.SimpleDateFormat;

public class DatabaseOpenHelper
extends SQLiteOpenHelper {
    public static final SimpleDateFormat SQL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DatabaseOpenHelper(Context context) {
        super(context, "Storage", null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE VIRTUAL TABLE history  USING fts3(visitTime DATETIME, title TEXT, url TEXT);");
        sQLiteDatabase.execSQL("create table downloadsList (id integer primary key autoincrement,name text,description text,id_d text,link_d text,file_path text,date integer,status text);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Upgrading database from version ");
        stringBuilder.append(n2);
        stringBuilder.append(" to ");
        stringBuilder.append(n3);
        stringBuilder.append(", which will destroy all old data");
        Log.w((String)"StorageDatabase", (String)stringBuilder.toString());
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS history");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS create table downloadsList (id integer primary key autoincrement,name text,description text,id_d text,link_d text,file_path text,date integer,status text);");
        this.onCreate(sQLiteDatabase);
    }
}

