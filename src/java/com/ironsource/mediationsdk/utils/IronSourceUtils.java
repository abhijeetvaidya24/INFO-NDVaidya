/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.text.TextUtils
 *  com.ironsource.mediationsdk.AbstractAdapter
 *  com.ironsource.mediationsdk.BannerSmash
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.math.BigInteger
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.StringTokenizer
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.BannerSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceUtils {
    private static String mAbt = "";
    private static int serr = 1;

    public static String getAbt() {
        return mAbt;
    }

    static boolean getBooleanFromSharedPrefs(Context context, String string, boolean bl2) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getBoolean(string, bl2);
    }

    public static String getConnectionType(Context context) {
        if (context == null) {
            return "cellular";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "cellular";
        }
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                return "cellular";
            }
            if (networkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return "wifi";
            }
            return "cellular";
        }
        return "none";
    }

    public static int getCurrentTimestamp() {
        return (int)(System.currentTimeMillis() / 1000L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getDefaultEventsFormatterType(Context context, String string, String string2) {
        Class<IronSourceUtils> class_ = IronSourceUtils.class;
        synchronized (IronSourceUtils.class) {
            try {
                try {
                    return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(IronSourceUtils.getDefaultFormatterTypeByEventType(string), string2);
                }
                catch (Exception exception) {
                    IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("IronSourceUtils:getDefaultEventsFormatterType(eventType: ");
                    stringBuilder.append(string);
                    stringBuilder.append(", defaultFormatterType:");
                    stringBuilder.append(string2);
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
                }
                return string2;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getDefaultEventsURL(Context context, String string, String string2) {
        Class<IronSourceUtils> class_ = IronSourceUtils.class;
        synchronized (IronSourceUtils.class) {
            try {
                try {
                    return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(IronSourceUtils.getDefaultEventsUrlByEventType(string), string2);
                }
                catch (Exception exception) {
                    IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("IronSourceUtils:getDefaultEventsURL(eventType: ");
                    stringBuilder.append(string);
                    stringBuilder.append(", defaultEventsURL:");
                    stringBuilder.append(string2);
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
                }
                return string2;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    private static String getDefaultEventsUrlByEventType(String string) {
        if ("IS".equals((Object)string)) {
            return "default_is_events_url";
        }
        if ("RV".equals((Object)string)) {
            return "default_rv_events_url";
        }
        return "";
    }

    private static String getDefaultFormatterTypeByEventType(String string) {
        if ("IS".equals((Object)string)) {
            return "default_is_events_formatter_type";
        }
        if ("RV".equals((Object)string)) {
            return "default_rv_events_formatter_type";
        }
        return "";
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
    public static int[] getDefaultOptOutEvents(Context context, String string) {
        Class<IronSourceUtils> class_ = IronSourceUtils.class;
        // MONITORENTER : com.ironsource.mediationsdk.utils.IronSourceUtils.class
        int[] arrn = null;
        int n2 = 0;
        String string2 = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(IronSourceUtils.getDefaultOptOutEventsByEventType(string), null);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        arrn = null;
        if (bl2) return arrn;
        StringTokenizer stringTokenizer = new StringTokenizer(string2, ",");
        ArrayList arrayList = new ArrayList();
        do {
            boolean bl3 = stringTokenizer.hasMoreTokens();
            arrn = null;
            if (!bl3) break;
            arrayList.add((Object)Integer.parseInt((String)stringTokenizer.nextToken()));
        } while (true);
        arrn = new int[arrayList.size()];
        while (n2 < arrn.length) {
            arrn[n2] = (Integer)arrayList.get(n2);
            ++n2;
        }
        return arrn;
        {
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (Exception exception) {}
            {
                IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("IronSourceUtils:getDefaultOptOutEvents(eventType: ");
                stringBuilder.append(string);
                stringBuilder.append(")");
                ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
                // MONITOREXIT : class_
            }
        }
        return arrn;
    }

    private static String getDefaultOptOutEventsByEventType(String string) {
        if ("IS".equals((Object)string)) {
            return "default_is_opt_out_events";
        }
        if ("RV".equals((Object)string)) {
            return "default_rv_opt_out_events";
        }
        return "";
    }

    static int getIntFromSharedPrefs(Context context, String string, int n2) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getInt(string, n2);
    }

    public static String getLastResponse(Context context) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString("last_response", "");
    }

    static long getLongFromSharedPrefs(Context context, String string, long l2) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getLong(string, l2);
    }

    public static String getMD5(String string) {
        try {
            String string2 = new BigInteger(1, MessageDigest.getInstance((String)"MD5").digest(string.getBytes())).toString(16);
            while (string2.length() < 32) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("0");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            }
            return string2;
        }
        catch (Throwable throwable) {
            if (string == null) {
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getMD5(input:null)", throwable);
            } else {
                IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getMD5(input:");
                stringBuilder.append(string);
                stringBuilder.append(")");
                ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), throwable);
            }
            return "";
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static JSONObject getMediationAdditionalData(boolean var0) {
        var1_1 = new JSONObject();
        if (!var0) ** GOTO lbl5
        try {
            var1_1.put("networkInstance", (Object)"true");
lbl5: // 2 sources:
            var1_1.put("provider", (Object)"Mediation");
            return var1_1;
        }
        catch (JSONException v0) {}
        return var1_1;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static JSONObject getProviderAdditionalData(AbstractSmash var0, boolean var1_1) {
        var2_2 = new JSONObject();
        if (!var1_1) ** GOTO lbl5
        try {
            var2_2.put("networkInstance", (Object)"true");
lbl5: // 2 sources:
            var2_2.put("spId", (Object)var0.getSubProviderId());
            var2_2.put("provider", (Object)var0.getName());
            var2_2.put("providerSDKVersion", (Object)var0.getAdapter().getCoreSDKVersion());
            var2_2.put("providerAdapterVersion", (Object)var0.getAdapter().getVersion());
            var2_2.put("providerPriority", var0.getProviderPriority());
            return var2_2;
        }
        catch (Exception var3_3) {
            var4_4 = IronSourceLoggerManager.getLogger();
            var5_5 = IronSourceLogger.IronSourceTag.NATIVE;
            var6_6 = new StringBuilder();
            var6_6.append("IronSourceUtils:getProviderAdditionalData(adapter: ");
            var6_6.append(var0.getName());
            var6_6.append(")");
            var4_4.logException(var5_5, var6_6.toString(), (Throwable)var3_3);
            return var2_2;
        }
    }

    public static JSONObject getProviderAdditionalData(BannerSmash bannerSmash) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("spId", (Object)bannerSmash.getSubProviderId());
            jSONObject.put("provider", (Object)bannerSmash.getName());
            jSONObject.put("providerSDKVersion", (Object)bannerSmash.getAdapter().getCoreSDKVersion());
            jSONObject.put("providerAdapterVersion", (Object)bannerSmash.getAdapter().getVersion());
            jSONObject.put("providerPriority", bannerSmash.getProviderPriority());
            return jSONObject;
        }
        catch (Exception exception) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IronSourceUtils:getProviderAdditionalData(adapter: ");
            stringBuilder.append(bannerSmash.getName());
            stringBuilder.append(")");
            ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
            return jSONObject;
        }
    }

    public static String getSDKVersion() {
        return "6.7.10";
    }

    private static String getSHA256(String string) {
        try {
            String string2 = String.format((String)"%064x", (Object[])new Object[]{new BigInteger(1, MessageDigest.getInstance((String)"SHA-256").digest(string.getBytes()))});
            return string2;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            if (string == null) {
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getSHA256(input:null)", (Throwable)noSuchAlgorithmException);
            } else {
                IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getSHA256(input:");
                stringBuilder.append(string);
                stringBuilder.append(")");
                ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)noSuchAlgorithmException);
            }
            return "";
        }
    }

    public static int getSerr() {
        return serr;
    }

    static String getStringFromSharedPrefs(Context context, String string, String string2) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(string, string2);
    }

    public static long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public static String getTransId(String string) {
        return IronSourceUtils.getSHA256(string);
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isConnected();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static JSONObject mergeJsons(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            try {
                return new JSONObject();
            }
            catch (JSONException jSONException) {}
            jSONException.printStackTrace();
            return jSONObject;
        } else {
            if (jSONObject == null) {
                return jSONObject2;
            }
            if (jSONObject2 == null) {
                return jSONObject;
            }
            Iterator iterator = jSONObject2.keys();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                if (jSONObject.has(string)) continue;
                jSONObject.put(string, jSONObject2.get(string));
            }
        }
        return jSONObject;
    }

    static void saveBooleanToSharedPrefs(Context context, String string, boolean bl2) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editor.putBoolean(string, bl2);
        editor.apply();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void saveDefaultEventsFormatterType(Context context, String string, String string2) {
        Class<IronSourceUtils> class_ = IronSourceUtils.class;
        synchronized (IronSourceUtils.class) {
            try {
                try {
                    SharedPreferences.Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                    editor.putString(IronSourceUtils.getDefaultFormatterTypeByEventType(string), string2);
                    editor.commit();
                }
                catch (Exception exception) {
                    IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("IronSourceUtils:saveDefaultEventsFormatterType(eventType: ");
                    stringBuilder.append(string);
                    stringBuilder.append(", formatterType:");
                    stringBuilder.append(string2);
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void saveDefaultEventsURL(Context context, String string, String string2) {
        Class<IronSourceUtils> class_ = IronSourceUtils.class;
        synchronized (IronSourceUtils.class) {
            try {
                try {
                    SharedPreferences.Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                    editor.putString(IronSourceUtils.getDefaultEventsUrlByEventType(string), string2);
                    editor.commit();
                }
                catch (Exception exception) {
                    IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("IronSourceUtils:saveDefaultEventsURL(eventType: ");
                    stringBuilder.append(string);
                    stringBuilder.append(", eventsUrl:");
                    stringBuilder.append(string2);
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void saveDefaultOptOutEvents(Context var0, String var1_1, int[] var2_2) {
        var21_3 = IronSourceUtils.class;
        // MONITORENTER : com.ironsource.mediationsdk.utils.IronSourceUtils.class
        try {
            var14_5 = var0.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            var15_6 = null;
            if (var2_2 == null) ** GOTO lbl14
            var16_7 = new StringBuilder();
            for (var3_4 = 0; var3_4 < var2_2.length; ++var3_4) {
                var16_7.append(var2_2[var3_4]);
                var16_7.append(",");
            }
            var15_6 = var16_7.toString();
lbl14: // 2 sources:
            var14_5.putString(IronSourceUtils.getDefaultOptOutEventsByEventType(var1_1), var15_6);
            var14_5.commit();
            return;
        }
        catch (Throwable var13_8) {
            throw var13_8;
        }
        catch (Exception var4_9) {
            var5_10 = IronSourceLoggerManager.getLogger();
            var6_11 = IronSourceLogger.IronSourceTag.NATIVE;
            var7_12 = new StringBuilder();
            var7_12.append("IronSourceUtils:saveDefaultOptOutEvents(eventType: ");
            var7_12.append(var1_1);
            var7_12.append(", optOutEvents:");
            var7_12.append((Object)var2_2);
            var7_12.append(")");
            var5_10.logException(var6_11, var7_12.toString(), (Throwable)var4_9);
        }
    }

    static void saveGeneralProperties(Context context, JSONObject jSONObject) {
        Class<IronSourceUtils> class_ = IronSourceUtils.class;
        synchronized (IronSourceUtils.class) {
            if (context != null && jSONObject != null) {
                SharedPreferences.Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                editor.putString("general_properties", jSONObject.toString());
                editor.apply();
                // ** MonitorExit[var5_2] (shouldn't be in output)
                return;
            }
            // ** MonitorExit[var5_2] (shouldn't be in output)
            return;
        }
    }

    static void saveIntToSharedPrefs(Context context, String string, int n2) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editor.putInt(string, n2);
        editor.apply();
    }

    public static void saveLastResponse(Context context, String string) {
        Class<IronSourceUtils> class_ = IronSourceUtils.class;
        synchronized (IronSourceUtils.class) {
            SharedPreferences.Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            editor.putString("last_response", string);
            editor.apply();
            // ** MonitorExit[var5_2] (shouldn't be in output)
            return;
        }
    }

    static void saveLongToSharedPrefs(Context context, String string, long l2) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editor.putLong(string, l2);
        editor.apply();
    }

    static void saveStringToSharedPrefs(Context context, String string, String string2) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editor.putString(string, string2);
        editor.apply();
    }

    static void setABT(String string) {
        mAbt = string;
    }
}

