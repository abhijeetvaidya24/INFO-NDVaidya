/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.appsgeyser.multiTabApp.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookmarksManager
extends SQLiteOpenHelper {
    private final String BOOKMARKS_PAGE_PREFIX;
    private String BOOKMARKS_TABLE_CREATE;
    private String BOOKMARKS_TABLE_NAME;
    private final String DATABASE_NAME;
    private Context _context;
    private String _name;

    public BookmarksManager(String string2, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bookmarks");
        stringBuilder.append(string2);
        super(context, stringBuilder.toString(), null, 1);
        this.BOOKMARKS_PAGE_PREFIX = "BookmarksPage";
        this._context = context;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Bookmarks");
        stringBuilder2.append(string2);
        this.DATABASE_NAME = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("BookmarksPage");
        stringBuilder3.append(string2);
        this.BOOKMARKS_TABLE_NAME = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("CREATE TABLE ");
        stringBuilder4.append(this.BOOKMARKS_TABLE_NAME);
        stringBuilder4.append(" (");
        stringBuilder4.append("id");
        stringBuilder4.append(" integer primary key autoincrement, ");
        stringBuilder4.append("name");
        stringBuilder4.append(" TEXT, ");
        stringBuilder4.append("url");
        stringBuilder4.append(" TEXT);");
        this.BOOKMARKS_TABLE_CREATE = stringBuilder4.toString();
        this._name = string2;
    }

    public void addBookmark(String string2, String string3) {
        SQLiteDatabase sQLiteDatabase = super.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", string2);
        contentValues.put("url", string3);
        sQLiteDatabase.insert(this.BOOKMARKS_TABLE_NAME, null, contentValues);
    }

    public Cursor getBookmarks() {
        return this.getBookmarks(0, null);
    }

    public Cursor getBookmarks(Integer n2, Integer n3) {
        String string2;
        SQLiteDatabase sQLiteDatabase = super.getReadableDatabase();
        String string3 = "";
        if (n3 != null && n3 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(" limit ");
            stringBuilder.append((Object)n3);
            string3 = stringBuilder.toString();
        }
        if (n2 != null && n2 > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(" offset ");
            stringBuilder.append((Object)n2);
            string2 = stringBuilder.toString();
        } else {
            string2 = string3;
        }
        return sQLiteDatabase.query(this.BOOKMARKS_TABLE_NAME, null, null, null, null, null, null, string2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.BOOKMARKS_TABLE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DROP TABLE IF EXISTS ");
        stringBuilder.append(this.BOOKMARKS_TABLE_NAME);
        sQLiteDatabase.execSQL(stringBuilder.toString());
        this.onCreate(sQLiteDatabase);
    }

    public void removeBookmark(Integer n2) {
        SQLiteDatabase sQLiteDatabase = super.getWritableDatabase();
        String string2 = this.BOOKMARKS_TABLE_NAME;
        String[] arrstring = new String[]{n2.toString()};
        sQLiteDatabase.delete(string2, "id=?", arrstring);
    }
}

