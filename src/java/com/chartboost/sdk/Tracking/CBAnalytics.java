/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Base64
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.h
 *  com.chartboost.sdk.i
 *  com.chartboost.sdk.impl.ad
 *  com.chartboost.sdk.impl.ah
 *  com.chartboost.sdk.impl.aj
 *  com.chartboost.sdk.impl.aj$a
 *  com.chartboost.sdk.impl.ap
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.EnumMap
 *  java.util.Locale
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.chartboost.sdk.Tracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Tracking.a;
import com.chartboost.sdk.h;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.aj;
import com.chartboost.sdk.impl.ap;
import java.util.EnumMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class CBAnalytics {
    private CBAnalytics() {
    }

    private static void a(ah ah2, ap ap2, a a2, JSONArray jSONArray, String string2) {
        Class<CBAnalytics> class_ = CBAnalytics.class;
        synchronized (CBAnalytics.class) {
            String string3 = "/post-install-event/".concat("tracking");
            aj aj2 = new aj(string3, ap2, a2, 2, null);
            aj2.a("track_info", (Object)jSONArray);
            aj2.l = true;
            aj2.b(string2);
            ah2.a((ad)aj2);
            // ** MonitorExit[var8_5] (shouldn't be in output)
            return;
        }
    }

    private static void a(ah ah2, ap ap2, a a2, JSONObject jSONObject, String string2, CBIAPType cBIAPType) {
        Class<CBAnalytics> class_ = CBAnalytics.class;
        synchronized (CBAnalytics.class) {
            String string3 = String.format((Locale)Locale.US, (String)"%s%s", (Object[])new Object[]{"/post-install-event/", string2});
            aj aj2 = new aj(string3, ap2, a2, 2, null);
            aj2.a(string2, (Object)jSONObject);
            aj2.l = true;
            aj2.b(string2);
            ah2.a((ad)aj2);
            // ** MonitorExit[var9_6] (shouldn't be in output)
            return;
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
    private static void a(String var0, String var1_1, String var2_2, String var3_3, String var4_4, String var5_5, String var6_6, String var7_7, String var8_8, CBIAPType var9_9) {
        block14 : {
            var24_10 = CBAnalytics.class;
            // MONITORENTER : com.chartboost.sdk.Tracking.CBAnalytics.class
            if (i.m == null) {
                CBLogging.b("CBPostInstallTracker", "You need call Chartboost.init() before calling any public API's");
                // MONITOREXIT : var24_10
                return;
            }
            var11_11 = h.a();
            if (var11_11 == null) {
                CBLogging.b("CBPostInstallTracker", "You need call Chartboost.startWithAppId() before tracking in-app purchases");
                // MONITOREXIT : var24_10
                return;
            }
            if (TextUtils.isEmpty((CharSequence)var0) || TextUtils.isEmpty((CharSequence)var1_1) || TextUtils.isEmpty((CharSequence)var2_2) || TextUtils.isEmpty((CharSequence)var3_3) || (var12_12 = TextUtils.isEmpty((CharSequence)var4_4))) break block14;
            try {
                var13_13 = Pattern.compile((String)"(\\d+\\.\\d+)|(\\d+)").matcher((CharSequence)var3_3);
                var13_13.find();
                var15_14 = var13_13.group();
                if (TextUtils.isEmpty((CharSequence)var15_14)) {
                    CBLogging.b("CBPostInstallTracker", "Invalid price object");
                    // MONITOREXIT : var24_10
                    return;
                }
                var16_15 = Float.parseFloat((String)var15_14);
                if (var9_9 != CBIAPType.GOOGLE_PLAY) ** GOTO lbl34
            }
            catch (IllegalStateException v0) {
                CBLogging.b("CBPostInstallTracker", "Invalid price object");
                // MONITOREXIT : var24_10
                return;
            }
            if (!TextUtils.isEmpty((CharSequence)var5_5) && !TextUtils.isEmpty((CharSequence)var6_6)) {
                var23_16 = new e.a[]{e.a("purchaseData", (Object)var5_5), e.a("purchaseSignature", (Object)var6_6), e.a("type", CBIAPType.GOOGLE_PLAY.ordinal())};
                var18_17 = e.a(var23_16);
            } else {
                CBLogging.b("CBPostInstallTracker", "Null object is passed for for purchase data or purchase signature");
                // MONITOREXIT : var24_10
                return;
lbl34: // 1 sources:
                var17_18 = CBIAPType.AMAZON;
                var18_17 = null;
                if (var9_9 == var17_18) {
                    if (!TextUtils.isEmpty((CharSequence)var7_7) && !TextUtils.isEmpty((CharSequence)var8_8)) {
                        var19_19 = new e.a[]{e.a("userID", (Object)var7_7), e.a("purchaseToken", (Object)var8_8), e.a("type", CBIAPType.AMAZON.ordinal())};
                        var18_17 = e.a(var19_19);
                    } else {
                        CBLogging.b("CBPostInstallTracker", "Null object is passed for for amazon user id or amazon purchase token");
                        // MONITOREXIT : var24_10
                        return;
                    }
                }
            }
            if (var18_17 == null) {
                CBLogging.b("CBPostInstallTracker", "Error while parsing the receipt to a JSON Object, ");
                // MONITOREXIT : var24_10
                return;
            }
            var20_20 = Base64.encodeToString((byte[])var18_17.toString().getBytes(), (int)2);
            var21_21 = new e.a[]{e.a("localized-title", (Object)var1_1), e.a("localized-description", (Object)var2_2), e.a("price", (Object)Float.valueOf((float)var16_15)), e.a("currency", (Object)var4_4), e.a("productID", (Object)var0), e.a("receipt", (Object)var20_20)};
            var22_22 = e.a(var21_21);
            CBAnalytics.a(var11_11.h, var11_11.j, var11_11.o, var22_22, "iap", var9_9);
            // MONITOREXIT : var24_10
            return;
        }
        CBLogging.b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
        // MONITOREXIT : var24_10
    }

    public static void trackInAppAmazonStorePurchaseEvent(String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        Class<CBAnalytics> class_ = CBAnalytics.class;
        synchronized (CBAnalytics.class) {
            CBAnalytics.a(string6, string2, string3, string4, string5, null, null, string7, string8, CBIAPType.AMAZON);
            // ** MonitorExit[var8_7] (shouldn't be in output)
            return;
        }
    }

    public static void trackInAppGooglePlayPurchaseEvent(String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        Class<CBAnalytics> class_ = CBAnalytics.class;
        synchronized (CBAnalytics.class) {
            CBAnalytics.a(string6, string2, string3, string4, string5, string7, string8, null, null, CBIAPType.GOOGLE_PLAY);
            // ** MonitorExit[var8_7] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void trackLevelInfo(String string2, CBLevelType cBLevelType, int n2, int n3, String string3) {
        Class<CBAnalytics> class_ = CBAnalytics.class;
        synchronized (CBAnalytics.class) {
            h h2 = h.a();
            if (h2 == null) {
                CBLogging.b("CBPostInstallTracker", "trackLevelInfo: SDK is not initialized");
                // ** MonitorExit[var11_5] (shouldn't be in output)
                return;
            }
            if (TextUtils.isEmpty((CharSequence)string2)) {
                CBLogging.b("CBPostInstallTracker", "Invalid value: event label cannot be empty or null");
                // ** MonitorExit[var11_5] (shouldn't be in output)
                return;
            }
            if (cBLevelType == null) {
                CBLogging.b("CBPostInstallTracker", "Invalid value: level type cannot be empty or null, please choose from one of the CBLevelType enum values");
                // ** MonitorExit[var11_5] (shouldn't be in output)
                return;
            }
            if (n2 >= 0 && n3 >= 0) {
                if (string3.isEmpty()) {
                    CBLogging.b("CBPostInstallTracker", "Invalid value: description cannot be empty or null");
                    // ** MonitorExit[var11_5] (shouldn't be in output)
                    return;
                }
                e.a[] arra = new e.a[]{e.a("event_label", (Object)string2), e.a("event_field", cBLevelType.getLevelType()), e.a("main_level", n2), e.a("sub_level", n3), e.a("description", (Object)string3), e.a("timestamp", System.currentTimeMillis()), e.a("data_type", (Object)"level_info")};
                JSONObject jSONObject = e.a(arra);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object)jSONObject);
                CBAnalytics.a(h2.h, h2.j, h2.o, jSONArray, "tracking");
                // ** MonitorExit[var11_5] (shouldn't be in output)
                return;
            }
            CBLogging.b("CBPostInstallTracker", "Invalid value: Level number should be > 0");
            // ** MonitorExit[var11_5] (shouldn't be in output)
            return;
        }
    }

    public static void trackLevelInfo(String string2, CBLevelType cBLevelType, int n2, String string3) {
        Class<CBAnalytics> class_ = CBAnalytics.class;
        synchronized (CBAnalytics.class) {
            CBAnalytics.trackLevelInfo(string2, cBLevelType, n2, 0, string3);
            // ** MonitorExit[var5_4] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void trackInAppPurchaseEvent(EnumMap<CBIAPPurchaseInfo, String> enumMap, CBIAPType cBIAPType) {
        CBAnalytics cBAnalytics = this;
        synchronized (cBAnalytics) {
            if (!(enumMap == null || cBIAPType == null || TextUtils.isEmpty((CharSequence)((CharSequence)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_ID))) || TextUtils.isEmpty((CharSequence)((CharSequence)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_TITLE))) || TextUtils.isEmpty((CharSequence)((CharSequence)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_DESCRIPTION))) || TextUtils.isEmpty((CharSequence)((CharSequence)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_PRICE))) || TextUtils.isEmpty((CharSequence)((CharSequence)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_CURRENCY_CODE))))) {
                String string2 = (String)enumMap.get((Object)CBIAPPurchaseInfo.GOOGLE_PURCHASE_DATA);
                String string3 = (String)enumMap.get((Object)CBIAPPurchaseInfo.GOOGLE_PURCHASE_SIGNATURE);
                String string4 = (String)enumMap.get((Object)CBIAPPurchaseInfo.AMAZON_USER_ID);
                String string5 = (String)enumMap.get((Object)CBIAPPurchaseInfo.AMAZON_PURCHASE_TOKEN);
                CBAnalytics.a((String)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_ID), (String)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_TITLE), (String)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_DESCRIPTION), (String)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_PRICE), (String)enumMap.get((Object)CBIAPPurchaseInfo.PRODUCT_CURRENCY_CODE), string2, string3, string4, string5, cBIAPType);
                return;
            }
            CBLogging.b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
            return;
        }
    }

    public static final class CBIAPPurchaseInfo
    extends Enum<CBIAPPurchaseInfo> {
        public static final /* enum */ CBIAPPurchaseInfo AMAZON_PURCHASE_TOKEN;
        public static final /* enum */ CBIAPPurchaseInfo AMAZON_USER_ID;
        public static final /* enum */ CBIAPPurchaseInfo GOOGLE_PURCHASE_DATA;
        public static final /* enum */ CBIAPPurchaseInfo GOOGLE_PURCHASE_SIGNATURE;
        public static final /* enum */ CBIAPPurchaseInfo PRODUCT_CURRENCY_CODE;
        public static final /* enum */ CBIAPPurchaseInfo PRODUCT_DESCRIPTION;
        public static final /* enum */ CBIAPPurchaseInfo PRODUCT_ID;
        public static final /* enum */ CBIAPPurchaseInfo PRODUCT_PRICE;
        public static final /* enum */ CBIAPPurchaseInfo PRODUCT_TITLE;
        private static final /* synthetic */ CBIAPPurchaseInfo[] a;

        static {
            PRODUCT_ID = new CBIAPPurchaseInfo();
            PRODUCT_TITLE = new CBIAPPurchaseInfo();
            PRODUCT_DESCRIPTION = new CBIAPPurchaseInfo();
            PRODUCT_PRICE = new CBIAPPurchaseInfo();
            PRODUCT_CURRENCY_CODE = new CBIAPPurchaseInfo();
            GOOGLE_PURCHASE_DATA = new CBIAPPurchaseInfo();
            GOOGLE_PURCHASE_SIGNATURE = new CBIAPPurchaseInfo();
            AMAZON_PURCHASE_TOKEN = new CBIAPPurchaseInfo();
            AMAZON_USER_ID = new CBIAPPurchaseInfo();
            CBIAPPurchaseInfo[] arrcBIAPPurchaseInfo = new CBIAPPurchaseInfo[]{PRODUCT_ID, PRODUCT_TITLE, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_CURRENCY_CODE, GOOGLE_PURCHASE_DATA, GOOGLE_PURCHASE_SIGNATURE, AMAZON_PURCHASE_TOKEN, AMAZON_USER_ID};
            a = arrcBIAPPurchaseInfo;
        }

        public static CBIAPPurchaseInfo valueOf(String string2) {
            return (CBIAPPurchaseInfo)Enum.valueOf(CBIAPPurchaseInfo.class, (String)string2);
        }

        public static CBIAPPurchaseInfo[] values() {
            return (CBIAPPurchaseInfo[])a.clone();
        }
    }

    public static final class CBIAPType
    extends Enum<CBIAPType> {
        public static final /* enum */ CBIAPType AMAZON;
        public static final /* enum */ CBIAPType GOOGLE_PLAY;
        private static final /* synthetic */ CBIAPType[] a;

        static {
            GOOGLE_PLAY = new CBIAPType();
            AMAZON = new CBIAPType();
            CBIAPType[] arrcBIAPType = new CBIAPType[]{GOOGLE_PLAY, AMAZON};
            a = arrcBIAPType;
        }

        public static CBIAPType valueOf(String string2) {
            return (CBIAPType)Enum.valueOf(CBIAPType.class, (String)string2);
        }

        public static CBIAPType[] values() {
            return (CBIAPType[])a.clone();
        }
    }

    public static final class CBLevelType
    extends Enum<CBLevelType> {
        public static final /* enum */ CBLevelType CHARACTER_LEVEL;
        public static final /* enum */ CBLevelType CURRENT_AREA;
        public static final /* enum */ CBLevelType HIGHEST_LEVEL_REACHED;
        public static final /* enum */ CBLevelType OTHER_NONSEQUENTIAL;
        public static final /* enum */ CBLevelType OTHER_SEQUENTIAL;
        private static final /* synthetic */ CBLevelType[] b;
        private final int a;

        static {
            HIGHEST_LEVEL_REACHED = new CBLevelType(1);
            CURRENT_AREA = new CBLevelType(2);
            CHARACTER_LEVEL = new CBLevelType(3);
            OTHER_SEQUENTIAL = new CBLevelType(4);
            OTHER_NONSEQUENTIAL = new CBLevelType(5);
            CBLevelType[] arrcBLevelType = new CBLevelType[]{HIGHEST_LEVEL_REACHED, CURRENT_AREA, CHARACTER_LEVEL, OTHER_SEQUENTIAL, OTHER_NONSEQUENTIAL};
            b = arrcBLevelType;
        }

        private CBLevelType(int n3) {
            this.a = n3;
        }

        public static CBLevelType valueOf(String string2) {
            return (CBLevelType)Enum.valueOf(CBLevelType.class, (String)string2);
        }

        public static CBLevelType[] values() {
            return (CBLevelType[])b.clone();
        }

        public int getLevelType() {
            return this.a;
        }
    }

}

