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
 *  android.os.SystemClock
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONObject
 */
package com.ironsource.eventsmodule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.util.Log;
import com.ironsource.eventsmodule.EventData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class DataBaseEventsStorage
extends SQLiteOpenHelper {
    private static DataBaseEventsStorage mInstance;
    private final int DB_OPEN_BACKOFF_TIME = 400;
    private final int DB_RETRY_NUM = 4;
    private final String SQL_CREATE_ENTRIES = "CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )";
    private final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS events";

    public DataBaseEventsStorage(Context context, String string, int n2) {
        super(context, string, null, n2);
    }

    private ContentValues getContentValuesForEvent(EventData eventData, String string) {
        if (eventData != null) {
            ContentValues contentValues = new ContentValues(4);
            contentValues.put("eventid", Integer.valueOf((int)eventData.getEventId()));
            contentValues.put("timestamp", Long.valueOf((long)eventData.getTimeStamp()));
            contentValues.put("type", string);
            contentValues.put("data", eventData.getAdditionalData());
            return contentValues;
        }
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private SQLiteDatabase getDataBaseWithRetries(boolean var1_1) throws Throwable {
        var9_2 = this;
        // MONITORENTER : var9_2
        var2_3 = 0;
        do {
            if (!var1_1) ** GOTO lbl10
            var8_6 = this.getWritableDatabase();
            // MONITOREXIT : var9_2
            return var8_6;
lbl10: // 1 sources:
            var7_7 = this.getReadableDatabase();
            // MONITOREXIT : var9_2
            return var7_7;
            {
                catch (Throwable var4_8) {
                    throw var4_8;
                }
                catch (Throwable var3_4) {}
                if (++var2_3 >= 4) throw var3_4;
                var5_5 = var2_3 * 400;
                {
                    SystemClock.sleep((long)var5_5);
                    continue;
                }
            }
            break;
        } while (true);
    }

    public static DataBaseEventsStorage getInstance(Context context, String string, int n2) {
        Class<DataBaseEventsStorage> class_ = DataBaseEventsStorage.class;
        synchronized (DataBaseEventsStorage.class) {
            if (mInstance == null) {
                mInstance = new DataBaseEventsStorage(context, string, n2);
            }
            DataBaseEventsStorage dataBaseEventsStorage = mInstance;
            // ** MonitorExit[var5_3] (shouldn't be in output)
            return dataBaseEventsStorage;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearEvents(String var1_1) {
        var10_2 = this;
        synchronized (var10_2) {
            var2_3 = null;
            var3_4 = new String[]{var1_1};
            var2_3 = this.getDataBaseWithRetries(true);
            var2_3.delete("events", "type = ?", var3_4);
            if (var2_3 == null) return;
            if (var2_3.isOpen() == false) return;
lbl12: // 2 sources:
            do {
                var2_3.close();
                return;
                break;
            } while (true);
            {
                block12 : {
                    catch (Throwable var8_5) {
                        break block12;
                    }
                    catch (Throwable var4_6) {}
                    {
                        Log.e((String)"IronSource", (String)"Exception while clearing events: ", (Throwable)var4_6);
                        if (var2_3 == null) return;
                    }
                    var7_7 = var2_3.isOpen();
                    if (var7_7 == false) return;
                    ** continue;
                }
                if (var2_3 == null) throw var8_5;
                if (var2_3.isOpen() == false) throw var8_5;
                var2_3.close();
                throw var8_5;
            }
            finally {
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public ArrayList<EventData> loadEvents(String var1_1) {
        block20 : {
            block19 : {
                block21 : {
                    var14_2 = this;
                    // MONITORENTER : var14_2
                    var2_3 = new ArrayList();
                    var3_4 = null;
                    var5_5 = this.getDataBaseWithRetries(false);
                    var10_6 = new String[]{var1_1};
                    var3_4 = var5_5.query("events", null, "type = ?", var10_6, null, null, "timestamp ASC");
                    if (var3_4.getCount() > 0) {
                        var3_4.moveToFirst();
                        while (!var3_4.isAfterLast()) {
                            var2_3.add((Object)new EventData(var3_4.getInt(var3_4.getColumnIndex("eventid")), var3_4.getLong(var3_4.getColumnIndex("timestamp")), new JSONObject(var3_4.getString(var3_4.getColumnIndex("data")))));
                            var3_4.moveToNext();
                        }
                        var3_4.close();
                    }
                    if (var3_4 == null) ** GOTO lbl22
                    if (!var3_4.isClosed()) {
                        var3_4.close();
                    }
lbl22: // 4 sources:
                    if (var5_5 == null || !var5_5.isOpen()) break block19;
                    break block21;
                    catch (Throwable var9_8) {
                        var3_4 = null;
                        var5_5 = null;
                        break block20;
                    }
                    catch (Throwable var4_11) {
                        var5_5 = null;
                        ** GOTO lbl-1000
                    }
                }
                do {
                    var5_5.close();
                    return var2_3;
                    break;
                } while (true);
                catch (Throwable var9_7) {
                    break block20;
                }
                catch (Throwable var4_10) {}
lbl-1000: // 2 sources:
                {
                    Log.e((String)"IronSource", (String)"Exception while loading events: ", (Throwable)var4_12);
                    if (var3_4 == null) ** GOTO lbl43
                }
                if (!var3_4.isClosed()) {
                    var3_4.close();
                }
lbl43: // 4 sources:
                if (var5_5 != null && (var8_13 = var5_5.isOpen())) ** continue;
            }
            // MONITOREXIT : var14_2
            return var2_3;
        }
        if (var3_4 == null) ** GOTO lbl55
        if (!var3_4.isClosed()) {
            var3_4.close();
        }
lbl55: // 4 sources:
        if (var5_5 == null) throw var9_9;
        if (var5_5.isOpen() == false) throw var9_9;
        var5_5.close();
        throw var9_9;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        this.onCreate(sQLiteDatabase);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void saveEvents(List<EventData> var1_1, String var2_2) {
        block16 : {
            var14_3 = this;
            // MONITORENTER : var14_3
            if (var1_1 == null) {
                // MONITOREXIT : var14_3
                return;
            }
            var4_4 = var1_1.isEmpty();
            if (var4_4) {
                return;
            }
            var5_5 = null;
            var9_6 = this.getDataBaseWithRetries(true);
            try {
                var10_7 = var1_1.iterator();
                while (var10_7.hasNext()) {
                    var11_8 = this.getContentValuesForEvent((EventData)var10_7.next(), var2_2);
                    if (var9_6 == null || var11_8 == null) continue;
                    var9_6.insert("events", null, var11_8);
                }
            }
            catch (Throwable var8_9) {
                break block16;
            }
            catch (Throwable var6_12) {
                var5_5 = var9_6;
                ** GOTO lbl-1000
            }
            if (var9_6 == null || !var9_6.isOpen()) return;
            {
                var9_6.close();
                return;
            }
            catch (Throwable var8_10) {
                var9_6 = var5_5;
                break block16;
            }
            catch (Throwable var6_13) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                Log.e((String)"IronSource", (String)"Exception while saving events: ", (Throwable)var6_14);
            }
            if (var5_5 != null && var5_5.isOpen()) {
                var5_5.close();
            }
            // MONITOREXIT : var14_3
            return;
        }
        if (var9_6 == null) throw var8_11;
        if (var9_6.isOpen() == false) throw var8_11;
        var9_6.close();
        throw var8_11;
    }
}

