/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.os.SystemClock
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 */
package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalPrefs;
import java.util.ArrayList;

public class OneSignalDbHelper
extends SQLiteOpenHelper {
    private static final String[] SQL_INDEX_ENTRIES = new String[]{"CREATE INDEX notification_notification_id_idx ON notification(notification_id); ", "CREATE INDEX notification_android_notification_id_idx ON notification(android_notification_id); ", "CREATE INDEX notification_group_id_idx ON notification(group_id); ", "CREATE INDEX notification_collapse_id_idx ON notification(collapse_id); ", "CREATE INDEX notification_created_time_idx ON notification(created_time); ", "CREATE INDEX notification_expire_time_idx ON notification(expire_time); "};
    private static OneSignalDbHelper sInstance;

    OneSignalDbHelper(Context context) {
        super(context, "OneSignal.db", null, OneSignalDbHelper.getDbVersion());
    }

    private static int getDbVersion() {
        return 3;
    }

    public static OneSignalDbHelper getInstance(Context context) {
        Class<OneSignalDbHelper> class_ = OneSignalDbHelper.class;
        synchronized (OneSignalDbHelper.class) {
            if (sInstance == null) {
                sInstance = new OneSignalDbHelper(context.getApplicationContext());
            }
            OneSignalDbHelper oneSignalDbHelper = sInstance;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return oneSignalDbHelper;
        }
    }

    private static void internalOnUpgrade(SQLiteDatabase sQLiteDatabase, int n2) {
        if (n2 < 2) {
            OneSignalDbHelper.upgradeFromV1ToV2(sQLiteDatabase);
        }
        if (n2 < 3) {
            OneSignalDbHelper.upgradeFromV2ToV3(sQLiteDatabase);
        }
    }

    static StringBuilder recentUninteractedWithNotificationsWhere() {
        long l2 = System.currentTimeMillis() / 1000L;
        long l3 = l2 - 604800L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("created_time > ");
        stringBuilder.append(l3);
        stringBuilder.append(" AND ");
        stringBuilder.append("dismissed");
        stringBuilder.append(" = 0 AND ");
        stringBuilder.append("opened");
        stringBuilder.append(" = 0 AND ");
        stringBuilder.append("is_summary");
        stringBuilder.append(" = 0");
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
        if (OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, "OS_RESTORE_TTL_FILTER", true)) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(" AND expire_time > ");
            stringBuilder3.append(l2);
            stringBuilder2.append(stringBuilder3.toString());
        }
        return stringBuilder2;
    }

    private static void safeExecSQL(SQLiteDatabase sQLiteDatabase, String string2) {
        try {
            sQLiteDatabase.execSQL(string2);
            return;
        }
        catch (SQLiteException sQLiteException) {
            sQLiteException.printStackTrace();
            return;
        }
    }

    private static void upgradeFromV1ToV2(SQLiteDatabase sQLiteDatabase) {
        OneSignalDbHelper.safeExecSQL(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
        OneSignalDbHelper.safeExecSQL(sQLiteDatabase, "CREATE INDEX notification_group_id_idx ON notification(group_id); ");
    }

    private static void upgradeFromV2ToV3(SQLiteDatabase sQLiteDatabase) {
        OneSignalDbHelper.safeExecSQL(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN expire_time TIMESTAMP;");
        OneSignalDbHelper.safeExecSQL(sQLiteDatabase, "UPDATE notification SET expire_time = created_time + 259200;");
        OneSignalDbHelper.safeExecSQL(sQLiteDatabase, "CREATE INDEX notification_expire_time_idx ON notification(expire_time); ");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    SQLiteDatabase getReadableDbWithRetries() {
        OneSignalDbHelper oneSignalDbHelper = this;
        // MONITORENTER : oneSignalDbHelper
        int n2 = 0;
        do {
            SQLiteDatabase sQLiteDatabase = this.getReadableDatabase();
            // MONITOREXIT : oneSignalDbHelper
            return sQLiteDatabase;
            {
                catch (Throwable throwable) {
                    throw throwable;
                }
                catch (Throwable throwable) {}
                if (++n2 >= 5) throw throwable;
                long l2 = n2 * 400;
                {
                    SystemClock.sleep((long)l2);
                    continue;
                }
            }
            break;
        } while (true);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    SQLiteDatabase getWritableDbWithRetries() {
        OneSignalDbHelper oneSignalDbHelper = this;
        // MONITORENTER : oneSignalDbHelper
        int n2 = 0;
        do {
            SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
            // MONITOREXIT : oneSignalDbHelper
            return sQLiteDatabase;
            {
                catch (Throwable throwable) {
                    throw throwable;
                }
                catch (Throwable throwable) {}
                if (++n2 >= 5) throw throwable;
                long l2 = n2 * 400;
                {
                    SystemClock.sleep((long)l2);
                    continue;
                }
            }
            break;
        } while (true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime('%s', 'now')),expire_time TIMESTAMP);");
        String[] arrstring = SQL_INDEX_ENTRIES;
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            sQLiteDatabase.execSQL(arrstring[i2]);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state.");
        Cursor cursor = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        try {
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add((Object)cursor.getString(0));
            }
            for (String string2 : arrayList) {
                if (string2.startsWith("sqlite_")) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DROP TABLE IF EXISTS ");
                stringBuilder.append(string2);
                sQLiteDatabase.execSQL(stringBuilder.toString());
            }
        }
        catch (Throwable throwable) {
            cursor.close();
            throw throwable;
        }
        cursor.close();
        this.onCreate(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        try {
            OneSignalDbHelper.internalOnUpgrade(sQLiteDatabase, n2);
            return;
        }
        catch (SQLiteException sQLiteException) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error in upgrade, migration may have already run! Skipping!", sQLiteException);
            return;
        }
    }
}

