/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Set
 */
package com.onesignal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.onesignal.OneSignal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class OneSignalPrefs {
    public static final String PREFS_ONESIGNAL = OneSignal.class.getSimpleName();
    public static WritePrefHandlerThread prefsHandler;
    static HashMap<String, HashMap<String, Object>> prefsToApply;

    static {
        OneSignalPrefs.initializePool();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object get(String string2, String string3, Class class_, Object object) {
        HashMap hashMap;
        HashMap hashMap2 = hashMap = (HashMap)prefsToApply.get((Object)string2);
        synchronized (hashMap2) {
            if (class_.equals(Object.class) && hashMap.containsKey((Object)string3)) {
                return true;
            }
            Object object2 = hashMap.get((Object)string3);
            if (object2 != null) return object2;
            if (!hashMap.containsKey((Object)string3)) {
                // MONITOREXIT [2, 8] lbl8 : w: MONITOREXIT : var9_5
                SharedPreferences sharedPreferences = OneSignalPrefs.getSharedPrefsByName(string2);
                if (sharedPreferences == null) {
                    return object;
                }
                if (class_.equals(String.class)) {
                    return sharedPreferences.getString(string3, (String)object);
                }
                if (class_.equals(Boolean.class)) {
                    return sharedPreferences.getBoolean(string3, ((Boolean)object).booleanValue());
                }
                if (class_.equals(Integer.class)) {
                    return sharedPreferences.getInt(string3, ((Integer)object).intValue());
                }
                if (class_.equals(Long.class)) {
                    return sharedPreferences.getLong(string3, ((Long)object).longValue());
                }
                if (!class_.equals(Object.class)) return null;
                return sharedPreferences.contains(string3);
            }
            return object2;
        }
    }

    static boolean getBool(String string2, String string3, boolean bl2) {
        return (Boolean)OneSignalPrefs.get(string2, string3, Boolean.class, bl2);
    }

    static int getInt(String string2, String string3, int n2) {
        return (Integer)OneSignalPrefs.get(string2, string3, Integer.class, n2);
    }

    static long getLong(String string2, String string3, long l2) {
        return (Long)OneSignalPrefs.get(string2, string3, Long.class, l2);
    }

    private static SharedPreferences getSharedPrefsByName(String string2) {
        Class<OneSignalPrefs> class_ = OneSignalPrefs.class;
        synchronized (OneSignalPrefs.class) {
            block4 : {
                if (OneSignal.appContext != null) break block4;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("OneSignal.appContext null, could not read ");
                stringBuilder.append(string2);
                stringBuilder.append(" from getSharedPreferences.");
                String string3 = stringBuilder.toString();
                OneSignal.Log(OneSignal.LOG_LEVEL.WARN, string3, new Throwable());
                // ** MonitorExit[var8_1] (shouldn't be in output)
                return null;
            }
            SharedPreferences sharedPreferences = OneSignal.appContext.getSharedPreferences(string2, 0);
            // ** MonitorExit[var8_1] (shouldn't be in output)
            return sharedPreferences;
        }
    }

    static String getString(String string2, String string3, String string4) {
        return (String)OneSignalPrefs.get(string2, string3, String.class, string4);
    }

    public static void initializePool() {
        prefsToApply = new HashMap();
        prefsToApply.put((Object)PREFS_ONESIGNAL, (Object)new HashMap());
        prefsToApply.put((Object)"GTPlayerPurchases", (Object)new HashMap());
        prefsHandler = new WritePrefHandlerThread();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void save(String string2, String string3, Object object) {
        HashMap hashMap;
        HashMap hashMap2 = hashMap = (HashMap)prefsToApply.get((Object)string2);
        synchronized (hashMap2) {
            hashMap.put((Object)string3, object);
        }
        OneSignalPrefs.startDelayedWrite();
    }

    public static void saveBool(String string2, String string3, boolean bl2) {
        OneSignalPrefs.save(string2, string3, bl2);
    }

    public static void saveLong(String string2, String string3, long l2) {
        OneSignalPrefs.save(string2, string3, l2);
    }

    public static void saveString(String string2, String string3, String string4) {
        OneSignalPrefs.save(string2, string3, string4);
    }

    public static void startDelayedWrite() {
        prefsHandler.startDelayedWrite();
    }

    public static class WritePrefHandlerThread
    extends HandlerThread {
        private long lastSyncTime = 0L;
        public Handler mHandler;

        WritePrefHandlerThread() {
            super("OSH_WritePrefs");
            this.start();
            this.mHandler = new Handler(this.getLooper());
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void flushBufferToDisk() {
            if (OneSignal.appContext == null) {
                return;
            }
            Iterator iterator = OneSignalPrefs.prefsToApply.keySet().iterator();
            do {
                HashMap hashMap;
                if (!iterator.hasNext()) {
                    this.lastSyncTime = System.currentTimeMillis();
                    return;
                }
                String string2 = (String)iterator.next();
                SharedPreferences.Editor editor = OneSignalPrefs.getSharedPrefsByName(string2).edit();
                HashMap hashMap2 = hashMap = (HashMap)OneSignalPrefs.prefsToApply.get((Object)string2);
                synchronized (hashMap2) {
                    for (String string3 : hashMap.keySet()) {
                        Object object = hashMap.get((Object)string3);
                        if (object instanceof String) {
                            editor.putString(string3, (String)object);
                            continue;
                        }
                        if (object instanceof Boolean) {
                            editor.putBoolean(string3, ((Boolean)object).booleanValue());
                            continue;
                        }
                        if (object instanceof Integer) {
                            editor.putInt(string3, ((Integer)object).intValue());
                            continue;
                        }
                        if (!(object instanceof Long)) continue;
                        editor.putLong(string3, ((Long)object).longValue());
                    }
                    hashMap.clear();
                }
                editor.apply();
            } while (true);
        }

        private Runnable getNewRunnable() {
            return new Runnable(){

                public void run() {
                    WritePrefHandlerThread.this.flushBufferToDisk();
                }
            };
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        void startDelayedWrite() {
            Handler handler;
            Handler handler2 = handler = this.mHandler;
            synchronized (handler2) {
                this.mHandler.removeCallbacksAndMessages(null);
                if (this.lastSyncTime == 0L) {
                    this.lastSyncTime = System.currentTimeMillis();
                }
                long l2 = 200L + (this.lastSyncTime - System.currentTimeMillis());
                this.mHandler.postDelayed(this.getNewRunnable(), l2);
                return;
            }
        }

    }

}

