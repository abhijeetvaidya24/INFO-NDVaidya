/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteQueryBuilder
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Vector
 */
package com.appsgeyser.multiTabApp.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;
import com.appsgeyser.multiTabApp.storage.DatabaseOpenHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class BrowsingHistoryStorage {
    private DatabaseOpenHelper _dbHelper;

    public BrowsingHistoryStorage(Context context) {
        this._dbHelper = new DatabaseOpenHelper(context);
    }

    public void addHistoryItem(String string2, String string3, Date date) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", string2);
        contentValues.put("url", string3);
        contentValues.put("visitTime", DatabaseOpenHelper.SQL_DATE_FORMAT.format(date));
        this._dbHelper.getWritableDatabase().insert("history", null, contentValues);
    }

    public Cursor getHistoryItemsGroupedByUrl(String string2) {
        String[] arrstring;
        String string3;
        String[] arrstring2 = new String[]{"rowId _id", "title", "url"};
        this.loadHistory(new Date("2014/01/01"), new Date("2016/09/09"));
        if (string2 != null) {
            String[] arrstring3 = new String[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("*");
            arrstring3[0] = stringBuilder.toString();
            string3 = "url MATCH ?";
            arrstring = arrstring3;
        } else {
            string3 = null;
            arrstring = null;
        }
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("history");
        return sQLiteQueryBuilder.query(this._dbHelper.getReadableDatabase(), arrstring2, string3, arrstring, "url", null, null, "6");
    }

    public Cursor loadHistory(Date date, Date date2) {
        Vector vector = new Vector();
        String string2 = "";
        if (date != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("visitTime>= ?");
            string2 = stringBuilder.toString();
            vector.add((Object)DatabaseOpenHelper.SQL_DATE_FORMAT.format(date));
        }
        if (date2 != null) {
            if (date != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(" AND ");
                string2 = stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("visitTime<= ?");
            string2 = stringBuilder.toString();
            vector.add((Object)DatabaseOpenHelper.SQL_DATE_FORMAT.format(date2));
        }
        String string3 = string2;
        Object[] arrobject = new String[vector.size()];
        vector.toArray(arrobject);
        String[] arrstring = new String[]{"rowId _id", "title", "url", "visitTime"};
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("history");
        Cursor cursor = sQLiteQueryBuilder.query(this._dbHelper.getReadableDatabase(), arrstring, string3, (String[])arrobject, null, null, null);
        if (cursor == null) {
            return null;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;
    }

    public Cursor loadWeeklyHistory() {
        Date date = new Date();
        return this.loadHistory(new Date(date.getTime() - 604800000L), date);
    }

    public int removeHistoryAllItem() {
        try {
            int n2 = this._dbHelper.getWritableDatabase().delete("history", null, null);
            return n2;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append((Object)exception);
            Log.e((String)"removeHistoryAllItem", (String)stringBuilder.toString());
            return -1;
        }
    }

    public int removeHistoryItemById(long l2) {
        try {
            SQLiteDatabase sQLiteDatabase = this._dbHelper.getWritableDatabase();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("rowId=");
            stringBuilder.append(Long.toString((long)l2));
            int n2 = sQLiteDatabase.delete("history", stringBuilder.toString(), null);
            return n2;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append((Object)exception);
            Log.e((String)"removeHistoryItemById", (String)stringBuilder.toString());
            return -1;
        }
    }
}

