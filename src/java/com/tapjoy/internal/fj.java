/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 *  java.io.Closeable
 *  java.io.File
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.tapjoy.internal.dc;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.gb;
import java.io.Closeable;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class fj
extends fi {
    private final File b;
    private final gb c;
    private volatile SQLiteDatabase d;
    private long e;
    private long f;
    private long g;

    public fj(File file, gb gb2) {
        this.b = file;
        this.c = gb2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void b() {
        block12 : {
            var1_1 = fi.a;
            var2_2 = this.d.rawQuery("SELECT ROWID, * FROM UsageStats ORDER BY ROWID ASC", null);
            var4_3 = this.d.rawQuery("SELECT * FROM UsageStatValues ORDER BY stat_id ASC", null);
            try {
                var4_3.moveToNext();
lbl7: // 3 sources:
                do {
                    if (!var2_2.moveToNext()) ** break block11
                    var7_4 = var2_2.getLong(0);
                    var9_5 = 1;
                    var10_6 = var2_2.getString(var9_5);
                    var11_7 = var2_2.getString(2);
                    var12_8 = var11_7.isEmpty() != false ? null : var11_7;
                    var13_9 = var2_2.getInt(3);
                    var14_10 = var2_2.getLong(4);
                    var16_11 = var2_2.getLong(5);
                    if (!var4_3.isAfterLast()) {
                        var18_12 = null;
                    }
                    break block12;
                    break;
                } while (true);
            }
            catch (Throwable var5_17) {
                var4_3.close();
                throw var5_17;
            }
            {
                
                var4_3.close();
                this.d.execSQL("DELETE FROM UsageStats");
                this.d.execSQL("DELETE FROM UsageStatValues");
                this.g = 0L;
                this.f = 0L;
                return;
            }
            finally {
                var2_2.close();
            }
        }
        var18_12 = null;
        ** GOTO lbl54
        do {
            block14 : {
                block13 : {
                    if (var4_3.getLong(0) != var7_4) break block13;
                    if (var18_12 == null) {
                        var18_12 = new HashMap();
                    }
                    var19_13 = var4_3.getString(var9_5);
                    var20_14 = var4_3.getLong(3);
                    var22_15 = var4_3.getLong(4);
                    var18_12.put((Object)var19_13, (Object)var20_14);
                    var25_16 = new StringBuilder();
                    var25_16.append(var19_13);
                    var25_16.append("_max");
                    var18_12.put((Object)var25_16.toString(), (Object)var22_15);
                    if (var4_3.moveToNext()) break block14;
                }
                if (var1_1 != null && var1_1.contains((Object)var10_6)) ** GOTO lbl7
                this.c.a(var10_6, var12_8, var13_9, var14_10, var16_11, (Map)var18_12);
                ** continue;
            }
            var9_5 = 1;
        } while (true);
    }

    @Override
    protected void a() {
        if (this.d != null) {
            dc.a((Closeable)this.d);
            this.d = null;
        }
        this.b.delete();
        this.g = 0L;
        this.f = 0L;
    }

    @Override
    protected void a(long l2) {
        long l3;
        Cursor cursor;
        block11 : {
            if (this.d != null) {
                return;
            }
            this.d = SQLiteDatabase.openOrCreateDatabase((File)this.b, null);
            int n2 = this.d.getVersion();
            if (n2 != 0) {
                if (n2 != 1) {
                    StringBuilder stringBuilder = new StringBuilder("Unknown database version: ");
                    stringBuilder.append(n2);
                    throw new SQLException(stringBuilder.toString());
                }
            } else {
                this.d.beginTransaction();
                this.d.execSQL("CREATE TABLE IF NOT EXISTS UsageStats(name TEXT,dimensions TEXT,count INTEGER,first_time INTEGER,last_time INTEGER,PRIMARY KEY(name, dimensions))");
                this.d.execSQL("CREATE TABLE IF NOT EXISTS UsageStatValues(stat_id LONG,name TEXT,count INTEGER,avg REAL,max INTEGER,PRIMARY KEY(stat_id, name))");
                this.d.setVersion(1);
                this.d.setTransactionSuccessful();
            }
            cursor = this.d.rawQuery("SELECT MIN(first_time), MAX(last_time) FROM UsageStats", null);
            if (!cursor.moveToNext()) break block11;
            this.f = cursor.getLong(0);
            this.g = cursor.getLong(1);
        }
        if ((l3 = this.f) > 0L && l3 + 86400000L <= l2) {
            this.b();
        }
        return;
        finally {
            cursor.close();
        }
        finally {
            this.d.endTransaction();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    protected void a(long var1_1, String var3_2, String var4_3, Map var5_4) {
        block25 : {
            block23 : {
                block22 : {
                    if (this.d == null) {
                        return;
                    }
                    var6_5 = this.e;
                    if (var6_5 == 0L) {
                        this.g = var1_1;
                        this.e = var1_1;
                    } else if (var1_1 >= var6_5 && var1_1 < var6_5 + 86400000L) {
                        if (var1_1 > this.g) {
                            this.g = var1_1;
                        }
                    } else if (var1_1 < this.e && this.g - var1_1 < 86400000L) {
                        this.e = var1_1;
                    } else {
                        this.b();
                        this.g = var1_1;
                        this.e = var1_1;
                    }
                    var8_6 = var4_3 == null ? "" : var4_3;
                    var9_7 = this.d;
                    var10_8 = new String[2];
                    var10_8[0] = var3_2;
                    var11_9 = 1;
                    var10_8[var11_9] = var8_6;
                    var12_10 = var9_7.rawQuery("SELECT ROWID,count,first_time,last_time FROM UsageStats WHERE name = ? AND dimensions = ?", var10_8);
                    try {
                        var13_11 = new ContentValues();
                        var16_12 = var12_10.moveToNext();
                        var17_13 = "name";
                        var18_14 = "count";
                        if (var16_12) {
                            var66_15 = var12_10.getLong(0);
                            var68_16 = var12_10.getInt(var11_9);
                            var69_17 = var12_10.getLong(2);
                            var71_18 = var12_10.getLong(3);
                            var13_11.put(var18_14, Integer.valueOf((int)(var68_16 + var11_9)));
                            if (var1_1 < var69_17) {
                                var13_11.put("first_time", Long.valueOf((long)var1_1));
                            }
                            if (var1_1 > var71_18) {
                                var13_11.put("last_time", Long.valueOf((long)var1_1));
                            }
                            var73_19 = this.d;
                            var74_20 = new StringBuilder("ROWID = ");
                            var74_20.append(var66_15);
                            var73_19.update("UsageStats", var13_11, var74_20.toString(), null);
                            var19_21 = "ROWID = ";
                            var20_22 = var66_15;
                        } else {
                            var19_21 = "ROWID = ";
                            var13_11.put(var17_13, var3_2);
                            var13_11.put("dimensions", var8_6);
                            var13_11.put(var18_14, Integer.valueOf((int)var11_9));
                            var13_11.put("first_time", Long.valueOf((long)var1_1));
                            var13_11.put("last_time", Long.valueOf((long)var1_1));
                            var20_22 = this.d.insert("UsageStats", null, var13_11);
                        }
                        if (var5_4 == null || var5_4.isEmpty()) break block22;
                        var22_23 = var5_4.entrySet().iterator();
                    }
                    catch (Throwable var14_55) {
                        var15_24 = var12_10;
                        break block23;
                    }
                    while (var22_23.hasNext()) {
                        block26 : {
                            block24 : {
                                var23_25 = (Map.Entry)var22_23.next();
                                if (var23_25.getValue() == null) break block26;
                                var25_26 = (String)var23_25.getKey();
                                var26_27 = (Long)var23_25.getValue();
                                var28_28 = new String[2];
                                var28_28[0] = Long.toString((long)var20_22);
                                var28_28[var11_9] = var25_26;
                                var29_29 = this.d.rawQuery("SELECT ROWID, * FROM UsageStatValues WHERE stat_id = ? AND name = ?", var28_28);
                                var31_30 = var29_29.moveToNext();
                                var32_31 = var22_23;
                                if (!var31_30) ** GOTO lbl101
                                var33_32 = var20_22;
                                var42_38 = var29_29.getLong(0);
                                var44_39 = var29_29.getInt(3);
                                var45_40 = var29_29.getDouble(4);
                                var47_41 = var29_29.getLong(5);
                                var13_11.clear();
                                var49_42 = var44_39 + 1;
                                var13_11.put(var18_14, Integer.valueOf((int)var49_42));
                                var15_24 = var12_10;
                                var50_43 = var18_14;
                                var51_44 = var26_27;
                                Double.isNaN((double)var51_44);
                                var54_45 = var51_44 - var45_40;
                                var56_46 = var17_13;
                                var57_47 = var49_42;
                                Double.isNaN((double)var57_47);
                                var60_48 = var45_40 + var54_45 / var57_47;
                                var13_11.put("avg", Double.valueOf((double)var60_48));
                                if (var26_27 > var47_41) {
                                    var13_11.put("max", Long.valueOf((long)var26_27));
                                }
                                var62_49 = this.d;
                                var63_50 = new StringBuilder(var19_21);
                                var63_50.append(var42_38);
                                var62_49.update("UsageStatValues", var13_11, var63_50.toString(), null);
                                var39_37 = var50_43;
                                var37_35 = var56_46;
                                break block24;
lbl101: // 1 sources:
                                var33_32 = var20_22;
                                var15_24 = var12_10;
                                var35_33 = var18_14;
                                var36_34 = var17_13;
                                var13_11.clear();
                                var13_11.put("stat_id", Long.valueOf((long)var33_32));
                                var37_35 = var36_34;
                                var13_11.put(var37_35, var25_26);
                                var38_36 = 1;
                                var39_37 = var35_33;
                                var13_11.put(var39_37, var38_36);
                                var13_11.put("avg", Long.valueOf((long)var26_27));
                                var13_11.put("max", Long.valueOf((long)var26_27));
                                this.d.insert("UsageStatValues", null, var13_11);
                            }
                            try {
                                var29_29.close();
                                var22_23 = var32_31;
                                var20_22 = var33_32;
                                var17_13 = var37_35;
                                var12_10 = var15_24;
                                var18_14 = var39_37;
                            }
                            catch (Throwable var14_54) {
                                break block23;
                            }
                        }
                        var11_9 = 1;
                    }
                }
                var12_10.close();
                return;
            }
            var15_24.close();
            throw var14_56;
            catch (Throwable var30_52) {
                break block25;
            }
            catch (Throwable var30_53) {
                var15_24 = var12_10;
            }
        }
        var29_29.close();
        throw var30_51;
    }

    protected void finalize() {
        if (this.d != null) {
            dc.a((Closeable)this.d);
            this.d = null;
        }
        Object.super.finalize();
    }
}

