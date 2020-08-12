/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.DatabaseUtils
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.yandex.metrica.impl.utils;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Build;

public class e {
    public static String a(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append("?,");
        }
        int n3 = stringBuilder.length();
        stringBuilder.replace(n3 - 1, n3, "");
        return stringBuilder.toString();
    }

    public static void a(Cursor cursor, ContentValues contentValues) {
        if (Build.VERSION.SDK_INT >= 11) {
            String[] arrstring = cursor.getColumnNames();
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = cursor.getType(i2);
                if (n3 != 0) {
                    if (n3 != 1) {
                        if (n3 != 2) {
                            if (n3 != 3) {
                                if (n3 != 4) {
                                    contentValues.put(arrstring[i2], cursor.getString(i2));
                                    continue;
                                }
                                contentValues.put(arrstring[i2], cursor.getBlob(i2));
                                continue;
                            }
                            contentValues.put(arrstring[i2], cursor.getString(i2));
                            continue;
                        }
                        contentValues.put(arrstring[i2], Float.valueOf((float)cursor.getFloat(i2)));
                        continue;
                    }
                    contentValues.put(arrstring[i2], Integer.valueOf((int)cursor.getInt(i2)));
                    continue;
                }
                contentValues.put(arrstring[i2], cursor.getString(i2));
            }
            return;
        }
        DatabaseUtils.cursorRowToContentValues((Cursor)cursor, (ContentValues)contentValues);
    }
}

