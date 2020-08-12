/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  com.ironsource.mediationsdk.model.BannerPlacement
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ApplicationConfigurations;
import com.ironsource.mediationsdk.model.ApplicationEvents;
import com.ironsource.mediationsdk.model.ApplicationLogger;
import com.ironsource.mediationsdk.model.BannerConfigurations;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.Configurations;
import com.ironsource.mediationsdk.model.InterstitialConfigurations;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.OfferwallConfigurations;
import com.ironsource.mediationsdk.model.OfferwallPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.PlacementAvailabilitySettings;
import com.ironsource.mediationsdk.model.PlacementCappingType;
import com.ironsource.mediationsdk.model.ProviderOrder;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.model.ProviderSettingsHolder;
import com.ironsource.mediationsdk.model.RewardedVideoConfigurations;
import com.ironsource.mediationsdk.model.ServerSegmetData;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerResponseWrapper {
    private final String AB_TESTING;
    private final String ADAPTER_TIMEOUT_IN_MILLIS_FIELD;
    private final String ADAPTER_TIMEOUT_IN_SECS_FIELD;
    private final String AD_UNITS_FIELD;
    private final String ALLOW_LOCATION;
    private final String APPLICATION_FIELD;
    private final String BACKFILL_FIELD;
    private final String BACKUP_THRESHOLD_FIELD;
    private final String BN_FIELD;
    private final String CONFIGURATIONS_FIELD;
    private final String CONSOLE_FIELD;
    private final int DEFAULT_ADAPTERS_SMARTLOAD_AMOUNT;
    private final int DEFAULT_ADAPTERS_SMARTLOAD_TIMEOUT;
    private final String DEFAULT_BANNER_LOAD_REFRESH_INTERVAL;
    private final int DEFAULT_BANNER_SMARTLOAD_TIMEOUT;
    private final int DEFAULT_LOG_LEVEL;
    private final int DEFAULT_MAX_EVENTS_PER_BATCH;
    private final String ERROR_KEY;
    private final String EVENTS_FIELD;
    private final String INTEGRATION_FIELD;
    private final String IS_FIELD;
    private final String IS_MULTIPLE_INSTANCES_FIELD;
    private final String LOGGERS_FIELD;
    private final String MAX_EVENTS_PER_BATCH;
    private final String MAX_NUM_OF_ADAPTERS_TO_LOAD_ON_START_FIELD;
    private final String MAX_NUM_OF_EVENTS_FIELD;
    private final String OPT_OUT_EVENTS_FIELD;
    private final String OW_FIELD;
    private final String PLACEMENTS_FIELD;
    private final String PLACEMENT_ID_FIELD;
    private final String PLACEMENT_NAME_FIELD;
    private final String PLACEMENT_SETTINGS_CAPPING_FIELD;
    private final String PLACEMENT_SETTINGS_CAPPING_UNIT_FIELD;
    private final String PLACEMENT_SETTINGS_CAPPING_VALUE_FIELD;
    private final String PLACEMENT_SETTINGS_DELIVERY_FIELD;
    private final String PLACEMENT_SETTINGS_ENABLED_FIELD;
    private final String PLACEMENT_SETTINGS_PACING_FIELD;
    private final String PLACEMENT_SETTINGS_PACING_VALUE_FIELD;
    private final String PREMIUM_FIELD;
    private final String PROVIDER_LOAD_NAME_FIELD;
    private final String PROVIDER_ORDER_FIELD;
    private final String PROVIDER_SETTINGS_FIELD;
    private final String PUBLISHER_FIELD;
    private final String RV_FIELD;
    private final String SEGMENT_FIELD;
    private final String SEND_EVENTS_TOGGLE_FIELD;
    private final String SEND_ULTRA_EVENTS_FIELD;
    private final String SERVER_EVENTS_TYPE;
    private final String SERVER_EVENTS_URL_FIELD;
    private final String SERVER_FIELD;
    private final String SUB_PROVIDER_ID_FIELD;
    private final String UUID_ENABLED_FIELD;
    private final String VIRTUAL_ITEM_COUNT_FIELD;
    private final String VIRTUAL_ITEM_NAME_FIELD;
    private String mAppKey;
    private Configurations mConfigurations;
    private Context mContext;
    private ProviderOrder mProviderOrder;
    private ProviderSettingsHolder mProviderSettingsHolder;
    private JSONObject mResponse;
    private String mUserId;

    public ServerResponseWrapper(Context context, String string, String string2, String string3) {
        block5 : {
            block4 : {
                this.ERROR_KEY = "error";
                this.DEFAULT_LOG_LEVEL = 3;
                this.DEFAULT_ADAPTERS_SMARTLOAD_AMOUNT = 2;
                this.DEFAULT_ADAPTERS_SMARTLOAD_TIMEOUT = 60;
                this.DEFAULT_BANNER_SMARTLOAD_TIMEOUT = 10000;
                this.DEFAULT_MAX_EVENTS_PER_BATCH = 5000;
                this.PROVIDER_ORDER_FIELD = "providerOrder";
                this.PROVIDER_SETTINGS_FIELD = "providerSettings";
                this.CONFIGURATIONS_FIELD = "configurations";
                this.AD_UNITS_FIELD = "adUnits";
                this.PROVIDER_LOAD_NAME_FIELD = "providerLoadName";
                this.APPLICATION_FIELD = "application";
                this.RV_FIELD = "rewardedVideo";
                this.IS_FIELD = "interstitial";
                this.OW_FIELD = "offerwall";
                this.BN_FIELD = "banner";
                this.INTEGRATION_FIELD = "integration";
                this.LOGGERS_FIELD = "loggers";
                this.SEGMENT_FIELD = "segment";
                this.EVENTS_FIELD = "events";
                this.MAX_NUM_OF_ADAPTERS_TO_LOAD_ON_START_FIELD = "maxNumOfAdaptersToLoadOnStart";
                this.ADAPTER_TIMEOUT_IN_SECS_FIELD = "adapterTimeOutInSeconds";
                this.ADAPTER_TIMEOUT_IN_MILLIS_FIELD = "atim";
                this.DEFAULT_BANNER_LOAD_REFRESH_INTERVAL = "bannerInterval";
                this.SERVER_FIELD = "server";
                this.PUBLISHER_FIELD = "publisher";
                this.CONSOLE_FIELD = "console";
                this.SEND_ULTRA_EVENTS_FIELD = "sendUltraEvents";
                this.SEND_EVENTS_TOGGLE_FIELD = "sendEventsToggle";
                this.SERVER_EVENTS_URL_FIELD = "serverEventsURL";
                this.SERVER_EVENTS_TYPE = "serverEventsType";
                this.BACKUP_THRESHOLD_FIELD = "backupThreshold";
                this.MAX_NUM_OF_EVENTS_FIELD = "maxNumberOfEvents";
                this.MAX_EVENTS_PER_BATCH = "maxEventsPerBatch";
                this.OPT_OUT_EVENTS_FIELD = "optOut";
                this.ALLOW_LOCATION = "allowLocation";
                this.PLACEMENTS_FIELD = "placements";
                this.PLACEMENT_ID_FIELD = "placementId";
                this.PLACEMENT_NAME_FIELD = "placementName";
                this.PLACEMENT_SETTINGS_DELIVERY_FIELD = "delivery";
                this.PLACEMENT_SETTINGS_CAPPING_FIELD = "capping";
                this.PLACEMENT_SETTINGS_PACING_FIELD = "pacing";
                this.PLACEMENT_SETTINGS_ENABLED_FIELD = "enabled";
                this.PLACEMENT_SETTINGS_CAPPING_VALUE_FIELD = "maxImpressions";
                this.PLACEMENT_SETTINGS_PACING_VALUE_FIELD = "numOfSeconds";
                this.PLACEMENT_SETTINGS_CAPPING_UNIT_FIELD = "unit";
                this.VIRTUAL_ITEM_NAME_FIELD = "virtualItemName";
                this.VIRTUAL_ITEM_COUNT_FIELD = "virtualItemCount";
                this.BACKFILL_FIELD = "backFill";
                this.PREMIUM_FIELD = "premium";
                this.UUID_ENABLED_FIELD = "uuidEnabled";
                this.AB_TESTING = "abt";
                this.SUB_PROVIDER_ID_FIELD = "spId";
                this.IS_MULTIPLE_INSTANCES_FIELD = "mpis";
                this.mContext = context;
                try {
                    this.mResponse = TextUtils.isEmpty((CharSequence)string3) ? new JSONObject() : new JSONObject(string3);
                    this.parseProviderSettings();
                    this.parseConfigurations();
                    this.parseProviderOrder();
                    boolean bl2 = TextUtils.isEmpty((CharSequence)string);
                    if (!bl2) break block4;
                    string = "";
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                    this.defaultInit();
                    return;
                }
            }
            this.mAppKey = string;
            if (!TextUtils.isEmpty((CharSequence)string2)) break block5;
            string2 = "";
        }
        this.mUserId = string2;
    }

    public ServerResponseWrapper(ServerResponseWrapper serverResponseWrapper) {
        this.ERROR_KEY = "error";
        this.DEFAULT_LOG_LEVEL = 3;
        this.DEFAULT_ADAPTERS_SMARTLOAD_AMOUNT = 2;
        this.DEFAULT_ADAPTERS_SMARTLOAD_TIMEOUT = 60;
        this.DEFAULT_BANNER_SMARTLOAD_TIMEOUT = 10000;
        this.DEFAULT_MAX_EVENTS_PER_BATCH = 5000;
        this.PROVIDER_ORDER_FIELD = "providerOrder";
        this.PROVIDER_SETTINGS_FIELD = "providerSettings";
        this.CONFIGURATIONS_FIELD = "configurations";
        this.AD_UNITS_FIELD = "adUnits";
        this.PROVIDER_LOAD_NAME_FIELD = "providerLoadName";
        this.APPLICATION_FIELD = "application";
        this.RV_FIELD = "rewardedVideo";
        this.IS_FIELD = "interstitial";
        this.OW_FIELD = "offerwall";
        this.BN_FIELD = "banner";
        this.INTEGRATION_FIELD = "integration";
        this.LOGGERS_FIELD = "loggers";
        this.SEGMENT_FIELD = "segment";
        this.EVENTS_FIELD = "events";
        this.MAX_NUM_OF_ADAPTERS_TO_LOAD_ON_START_FIELD = "maxNumOfAdaptersToLoadOnStart";
        this.ADAPTER_TIMEOUT_IN_SECS_FIELD = "adapterTimeOutInSeconds";
        this.ADAPTER_TIMEOUT_IN_MILLIS_FIELD = "atim";
        this.DEFAULT_BANNER_LOAD_REFRESH_INTERVAL = "bannerInterval";
        this.SERVER_FIELD = "server";
        this.PUBLISHER_FIELD = "publisher";
        this.CONSOLE_FIELD = "console";
        this.SEND_ULTRA_EVENTS_FIELD = "sendUltraEvents";
        this.SEND_EVENTS_TOGGLE_FIELD = "sendEventsToggle";
        this.SERVER_EVENTS_URL_FIELD = "serverEventsURL";
        this.SERVER_EVENTS_TYPE = "serverEventsType";
        this.BACKUP_THRESHOLD_FIELD = "backupThreshold";
        this.MAX_NUM_OF_EVENTS_FIELD = "maxNumberOfEvents";
        this.MAX_EVENTS_PER_BATCH = "maxEventsPerBatch";
        this.OPT_OUT_EVENTS_FIELD = "optOut";
        this.ALLOW_LOCATION = "allowLocation";
        this.PLACEMENTS_FIELD = "placements";
        this.PLACEMENT_ID_FIELD = "placementId";
        this.PLACEMENT_NAME_FIELD = "placementName";
        this.PLACEMENT_SETTINGS_DELIVERY_FIELD = "delivery";
        this.PLACEMENT_SETTINGS_CAPPING_FIELD = "capping";
        this.PLACEMENT_SETTINGS_PACING_FIELD = "pacing";
        this.PLACEMENT_SETTINGS_ENABLED_FIELD = "enabled";
        this.PLACEMENT_SETTINGS_CAPPING_VALUE_FIELD = "maxImpressions";
        this.PLACEMENT_SETTINGS_PACING_VALUE_FIELD = "numOfSeconds";
        this.PLACEMENT_SETTINGS_CAPPING_UNIT_FIELD = "unit";
        this.VIRTUAL_ITEM_NAME_FIELD = "virtualItemName";
        this.VIRTUAL_ITEM_COUNT_FIELD = "virtualItemCount";
        this.BACKFILL_FIELD = "backFill";
        this.PREMIUM_FIELD = "premium";
        this.UUID_ENABLED_FIELD = "uuidEnabled";
        this.AB_TESTING = "abt";
        this.SUB_PROVIDER_ID_FIELD = "spId";
        this.IS_MULTIPLE_INSTANCES_FIELD = "mpis";
        try {
            this.mContext = serverResponseWrapper.getContext();
            this.mResponse = new JSONObject(serverResponseWrapper.mResponse.toString());
            this.mAppKey = serverResponseWrapper.mAppKey;
            this.mUserId = serverResponseWrapper.mUserId;
            this.mProviderOrder = serverResponseWrapper.getProviderOrder();
            this.mProviderSettingsHolder = serverResponseWrapper.getProviderSettingsHolder();
            this.mConfigurations = serverResponseWrapper.getConfigurations();
            return;
        }
        catch (Exception exception) {
            this.defaultInit();
            return;
        }
    }

    private void defaultInit() {
        this.mResponse = new JSONObject();
        this.mAppKey = "";
        this.mUserId = "";
        this.mProviderOrder = new ProviderOrder();
        this.mProviderSettingsHolder = ProviderSettingsHolder.getProviderSettingsHolder();
        this.mConfigurations = new Configurations();
    }

    private Context getContext() {
        return this.mContext;
    }

    private int getIntConfigValue(JSONObject jSONObject, JSONObject jSONObject2, String string, int n2) {
        int n3 = jSONObject.has(string) ? jSONObject.optInt(string, 0) : (jSONObject2.has(string) ? jSONObject2.optInt(string, 0) : 0);
        if (n3 == 0) {
            n3 = n2;
        }
        return n3;
    }

    private long getLongConfigValue(JSONObject jSONObject, JSONObject jSONObject2, String string, long l2) {
        long l3 = jSONObject.has(string) ? jSONObject.optLong(string, 0L) : (jSONObject2.has(string) ? jSONObject2.optLong(string, 0L) : 0L);
        if (l3 == 0L) {
            l3 = l2;
        }
        return l3;
    }

    private PlacementAvailabilitySettings getPlacementAvailabilitySettings(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        PlacementAvailabilitySettings.PlacementAvailabilitySettingsBuilder placementAvailabilitySettingsBuilder = new PlacementAvailabilitySettings.PlacementAvailabilitySettingsBuilder();
        boolean bl2 = true;
        placementAvailabilitySettingsBuilder.delivery(jSONObject.optBoolean("delivery", bl2));
        JSONObject jSONObject3 = jSONObject.optJSONObject("capping");
        if (jSONObject3 != null) {
            String string = jSONObject3.optString("unit");
            boolean bl3 = TextUtils.isEmpty((CharSequence)string);
            PlacementCappingType placementCappingType = null;
            if (!bl3) {
                if (PlacementCappingType.PER_DAY.toString().equals((Object)string)) {
                    placementCappingType = PlacementCappingType.PER_DAY;
                } else {
                    boolean bl4 = PlacementCappingType.PER_HOUR.toString().equals((Object)string);
                    placementCappingType = null;
                    if (bl4) {
                        placementCappingType = PlacementCappingType.PER_HOUR;
                    }
                }
            }
            int n2 = jSONObject3.optInt("maxImpressions", 0);
            boolean bl5 = jSONObject3.optBoolean("enabled", false) && n2 > 0;
            placementAvailabilitySettingsBuilder.capping(bl5, placementCappingType, n2);
        }
        if ((jSONObject2 = jSONObject.optJSONObject("pacing")) != null) {
            int n3 = jSONObject2.optInt("numOfSeconds", 0);
            if (!jSONObject2.optBoolean("enabled", false) || n3 <= 0) {
                bl2 = false;
            }
            placementAvailabilitySettingsBuilder.pacing(bl2, n3);
        }
        return placementAvailabilitySettingsBuilder.build();
    }

    private JSONObject getSection(JSONObject jSONObject, String string) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(string);
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void parseConfigurations() {
        block36 : {
            block34 : {
                block35 : {
                    block33 : {
                        block25 : {
                            block26 : {
                                block24 : {
                                    block23 : {
                                        block32 : {
                                            block30 : {
                                                block31 : {
                                                    block22 : {
                                                        block29 : {
                                                            block27 : {
                                                                block28 : {
                                                                    var2_1 = this.getSection(this.mResponse, "configurations");
                                                                    var3_2 = this.getSection(var2_1, "adUnits");
                                                                    var4_3 = this.getSection(var2_1, "application");
                                                                    var5_4 = this.getSection(var3_2, "rewardedVideo");
                                                                    var6_5 = this.getSection(var3_2, "interstitial");
                                                                    var7_6 = this.getSection(var3_2, "offerwall");
                                                                    var8_7 = this.getSection(var3_2, "banner");
                                                                    var9_8 = this.getSection(var4_3, "events");
                                                                    var10_9 = this.getSection(var4_3, "loggers");
                                                                    var11_10 = this.getSection(var4_3, "segment");
                                                                    if (var4_3 != null) {
                                                                        var12_11 = var4_3.optBoolean("uuidEnabled", true);
                                                                        IronSourceUtils.saveBooleanToSharedPrefs(this.mContext, "uuidEnabled", var12_11);
                                                                    }
                                                                    if (var9_8 != null && !TextUtils.isEmpty((CharSequence)(var13_12 = var9_8.optString("abt")))) {
                                                                        IronSourceUtils.setABT(var13_12);
                                                                    }
                                                                    if (var5_4 == null) break block27;
                                                                    var86_13 = var5_4.optJSONArray("placements");
                                                                    var16_14 = var8_7;
                                                                    var87_15 = this.getSection(var5_4, "events");
                                                                    var14_16 = "events";
                                                                    var88_17 = this.getIntConfigValue(var5_4, var4_3, "maxNumOfAdaptersToLoadOnStart", 2);
                                                                    var15_18 = "maxNumOfAdaptersToLoadOnStart";
                                                                    var18_19 = "placements";
                                                                    var89_20 = this.getIntConfigValue(var5_4, var4_3, "adapterTimeOutInSeconds", 60);
                                                                    var90_21 = IronSourceUtils.mergeJsons(var87_15, var9_8);
                                                                    var17_22 = var9_8;
                                                                    var91_23 = var90_21.optBoolean("sendUltraEvents", false);
                                                                    var92_24 = var90_21.optBoolean("sendEventsToggle", false);
                                                                    var93_25 = var90_21.optString("serverEventsURL", "");
                                                                    var94_26 = var90_21.optString("serverEventsType", "");
                                                                    var95_27 = var90_21.optInt("backupThreshold", -1);
                                                                    var96_28 = var90_21.optInt("maxNumberOfEvents", -1);
                                                                    var97_29 = var90_21.optInt("maxEventsPerBatch", 5000);
                                                                    var98_30 = var90_21.optJSONArray("optOut");
                                                                    if (var98_30 == null) break block28;
                                                                    var99_31 = new int[var98_30.length()];
                                                                    var19_32 = "maxNumberOfEvents";
                                                                    break block29;
                                                                }
                                                                var19_32 = "maxNumberOfEvents";
                                                                var101_34 = null;
                                                                break block22;
                                                            }
                                                            var14_16 = "events";
                                                            var15_18 = "maxNumOfAdaptersToLoadOnStart";
                                                            var16_14 = var8_7;
                                                            var17_22 = var9_8;
                                                            var18_19 = "placements";
                                                            var19_32 = "maxNumberOfEvents";
                                                            var20_41 = null;
                                                            ** GOTO lbl73
                                                        }
                                                        for (var100_33 = 0; var100_33 < var98_30.length(); ++var100_33) {
                                                            var99_31[var100_33] = var98_30.optInt(var100_33);
                                                        }
                                                        var101_34 = var99_31;
                                                    }
                                                    var102_35 = new ApplicationEvents(var91_23, var92_24, var93_25, var94_26, var95_27, var96_28, var97_29, var101_34);
                                                    var103_36 = new RewardedVideoConfigurations(var88_17, var89_20, var102_35);
                                                    if (var86_13 != null) {
                                                        for (var106_37 = 0; var106_37 < var86_13.length(); ++var106_37) {
                                                            var107_38 = this.parseSingleRVPlacement(var86_13.optJSONObject(var106_37));
                                                            if (var107_38 == null) continue;
                                                            var103_36.addRewardedVideoPlacement(var107_38);
                                                        }
                                                    }
                                                    if (!TextUtils.isEmpty((CharSequence)(var104_39 = var5_4.optString("backFill")))) {
                                                        var103_36.setBackFillProviderName(var104_39);
                                                    }
                                                    if (!TextUtils.isEmpty((CharSequence)(var105_40 = var5_4.optString("premium")))) {
                                                        var103_36.setPremiumProviderName(var105_40);
                                                    }
                                                    var20_41 = var103_36;
lbl73: // 2 sources:
                                                    if (var6_5 == null) break block30;
                                                    var23_42 = var18_19;
                                                    var63_43 = var6_5.optJSONArray(var23_42);
                                                    var21_44 = var14_16;
                                                    var64_45 = this.getSection(var6_5, var21_44);
                                                    var22_46 = var15_18;
                                                    var65_47 = this.getIntConfigValue(var6_5, var4_3, var22_46, 2);
                                                    var66_48 = this.getIntConfigValue(var6_5, var4_3, "adapterTimeOutInSeconds", 60);
                                                    var67_49 = var17_22;
                                                    var68_50 = IronSourceUtils.mergeJsons(var64_45, var67_49);
                                                    var17_22 = var67_49;
                                                    var69_51 = var68_50.optBoolean("sendEventsToggle", false);
                                                    var70_52 = var68_50.optString("serverEventsURL", "");
                                                    var71_53 = var68_50.optString("serverEventsType", "");
                                                    var72_54 = var68_50.optInt("backupThreshold", -1);
                                                    var25_55 = "serverEventsType";
                                                    var73_56 = var19_32;
                                                    var74_57 = var68_50.optInt(var73_56, -1);
                                                    var24_58 = "sendEventsToggle";
                                                    var75_59 = var68_50.optInt("maxEventsPerBatch", 5000);
                                                    var76_60 = var68_50.optJSONArray("optOut");
                                                    if (var76_60 == null) break block31;
                                                    var77_61 = new int[var76_60.length()];
                                                    var19_32 = var73_56;
                                                    break block32;
                                                }
                                                var19_32 = var73_56;
                                                var79_63 = null;
                                                break block23;
                                            }
                                            var21_44 = var14_16;
                                            var22_46 = var15_18;
                                            var23_42 = var18_19;
                                            var24_58 = "sendEventsToggle";
                                            var25_55 = "serverEventsType";
                                            var26_70 = null;
                                            ** GOTO lbl130
                                        }
                                        for (var78_62 = 0; var78_62 < var76_60.length(); ++var78_62) {
                                            var77_61[var78_62] = var76_60.optInt(var78_62);
                                        }
                                        var79_63 = var77_61;
                                    }
                                    try {
                                        var80_64 = new ApplicationEvents(false, var69_51, var70_52, var71_53, var72_54, var74_57, var75_59, var79_63);
                                        var81_65 = new InterstitialConfigurations(var65_47, var66_48, var80_64);
                                        if (var63_43 != null) {
                                            for (var84_66 = 0; var84_66 < var63_43.length(); ++var84_66) {
                                                var85_67 = this.parseSingleISPlacement(var63_43.optJSONObject(var84_66));
                                                if (var85_67 == null) continue;
                                                var81_65.addInterstitialPlacement(var85_67);
                                            }
                                        }
                                        if (!TextUtils.isEmpty((CharSequence)(var82_68 = var6_5.optString("backFill")))) {
                                            var81_65.setBackFillProviderName(var82_68);
                                        }
                                        if (!TextUtils.isEmpty((CharSequence)(var83_69 = var6_5.optString("premium")))) {
                                            var81_65.setPremiumProviderName(var83_69);
                                        }
                                        var26_70 = var81_65;
lbl130: // 2 sources:
                                        if (var16_14 == null) ** GOTO lbl153
                                        var38_71 = var16_14;
                                        var39_72 = var38_71.optJSONArray(var23_42);
                                        var40_73 = this.getSection(var38_71, var21_44);
                                        var41_74 = this.getIntConfigValue(var38_71, var4_3, var22_46, 1);
                                        var42_75 = var24_58;
                                        var43_76 = var25_55;
                                        var44_77 = var19_32;
                                        var45_78 = this.getLongConfigValue(var38_71, var4_3, "atim", 10000L);
                                        var47_79 = this.getIntConfigValue(var38_71, var4_3, "bannerInterval", 60);
                                        var48_80 = IronSourceUtils.mergeJsons(var40_73, var17_22);
                                        var49_81 = var48_80.optBoolean(var42_75, false);
                                        var50_82 = var48_80.optString("serverEventsURL", "");
                                        var51_83 = var48_80.optString(var43_76, "");
                                        var52_84 = var48_80.optInt("backupThreshold", -1);
                                        var53_85 = var48_80.optInt(var44_77, -1);
                                        var54_86 = var48_80.optInt("maxEventsPerBatch", 5000);
                                        var55_87 = var48_80.optJSONArray("optOut");
                                        if (var55_87 != null) {
                                            var56_88 = new int[var55_87.length()];
                                        } else {
                                            var58_90 = null;
                                            break block24;
lbl153: // 1 sources:
                                            var27_95 = null;
                                            break block25;
                                        }
                                        for (var57_89 = 0; var57_89 < var55_87.length(); ++var57_89) {
                                            var56_88[var57_89] = var55_87.optInt(var57_89);
                                        }
                                        var58_90 = var56_88;
                                    }
                                    catch (Exception var1_106) {
                                        var1_106.printStackTrace();
                                        return;
                                    }
                                }
                                var59_91 = new ApplicationEvents(false, var49_81, var50_82, var51_83, var52_84, var53_85, var54_86, var58_90);
                                var60_92 = new BannerConfigurations(var41_74, var45_78, var59_91, var47_79);
                                if (var39_72 == null) break block26;
                                for (var61_93 = 0; var61_93 < var39_72.length(); ++var61_93) {
                                    var62_94 = this.parseSingleBNPlacement(var39_72.optJSONObject(var61_93));
                                    if (var62_94 == null) continue;
                                    var60_92.addBannerPlacement(var62_94);
                                }
                            }
                            var27_95 = var60_92;
                        }
                        if (var7_6 == null) break block33;
                        var28_96 = var7_6.optJSONArray(var23_42);
                        var29_97 = new OfferwallConfigurations();
                        if (var28_96 == null) break block34;
                        break block35;
                    }
                    var30_100 = null;
                    break block36;
                }
                for (var36_98 = 0; var36_98 < var28_96.length(); ++var36_98) {
                    var37_99 = this.parseSingleOWPlacement(var28_96.optJSONObject(var36_98));
                    if (var37_99 == null) continue;
                    var29_97.addOfferwallPlacement(var37_99);
                }
            }
            var30_100 = var29_97;
        }
        var31_101 = new ApplicationLogger(var10_9.optInt("server", 3), var10_9.optInt("publisher", 3), var10_9.optInt("console", 3));
        var32_102 = var11_10 != null ? new ServerSegmetData(var11_10.optString("name", ""), var11_10.optString("id", "-1"), var11_10.optJSONObject("custom")) : null;
        var33_103 = new ApplicationConfigurations(var31_101, var32_102, var4_3.optBoolean("integration", false));
        var34_104 = var4_3.optBoolean("allowLocation", false);
        IronSourceUtils.saveBooleanToSharedPrefs(this.mContext, "GeneralProperties.ALLOW_LOCATION_SHARED_PREFS_KEY", var34_104);
        this.mConfigurations = var35_105 = new Configurations(var20_41, var26_70, var30_100, var27_95, var33_103);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void parseProviderOrder() {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        block11 : {
            String string;
            String string2;
            JSONArray jSONArray3;
            try {
                JSONObject jSONObject = this.getSection(this.mResponse, "providerOrder");
                jSONArray3 = jSONObject.optJSONArray("rewardedVideo");
                jSONArray2 = jSONObject.optJSONArray("interstitial");
                jSONArray = jSONObject.optJSONArray("banner");
                this.mProviderOrder = new ProviderOrder();
                if (jSONArray3 == null || this.getConfigurations() == null || this.getConfigurations().getRewardedVideoConfigurations() == null) break block11;
                string2 = this.getConfigurations().getRewardedVideoConfigurations().getBackFillProviderName();
                string = this.getConfigurations().getRewardedVideoConfigurations().getPremiumProviderName();
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
            for (int i2 = 0; i2 < jSONArray3.length(); ++i2) {
                String string3 = jSONArray3.optString(i2);
                if (string3.equals((Object)string2)) {
                    this.mProviderOrder.setRVBackFillProvider(string2);
                    continue;
                }
                if (string3.equals((Object)string)) {
                    this.mProviderOrder.setRVPremiumProvider(string);
                }
                this.mProviderOrder.addRewardedVideoProvider(string3);
                ProviderSettings providerSettings = ProviderSettingsHolder.getProviderSettingsHolder().getProviderSettings(string3);
                if (providerSettings == null) continue;
                providerSettings.setRewardedVideoPriority(i2);
            }
        }
        if (jSONArray2 != null && this.getConfigurations() != null && this.getConfigurations().getInterstitialConfigurations() != null) {
            String string = this.getConfigurations().getInterstitialConfigurations().getBackFillProviderName();
            String string4 = this.getConfigurations().getInterstitialConfigurations().getPremiumProviderName();
            for (int i3 = 0; i3 < jSONArray2.length(); ++i3) {
                String string5 = jSONArray2.optString(i3);
                if (string5.equals((Object)string)) {
                    this.mProviderOrder.setISBackFillProvider(string);
                    continue;
                }
                if (string5.equals((Object)string4)) {
                    this.mProviderOrder.setISPremiumProvider(string4);
                }
                this.mProviderOrder.addInterstitialProvider(string5);
                ProviderSettings providerSettings = ProviderSettingsHolder.getProviderSettingsHolder().getProviderSettings(string5);
                if (providerSettings == null) continue;
                providerSettings.setInterstitialPriority(i3);
            }
        }
        if (jSONArray == null) return;
        {
            for (int i4 = 0; i4 < jSONArray.length(); ++i4) {
                String string = jSONArray.optString(i4);
                this.mProviderOrder.addBannerProvider(string);
                ProviderSettings providerSettings = ProviderSettingsHolder.getProviderSettingsHolder().getProviderSettings(string);
                if (providerSettings == null) continue;
                providerSettings.setBannerPriority(i4);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void parseProviderSettings() {
        try {
            this.mProviderSettingsHolder = ProviderSettingsHolder.getProviderSettingsHolder();
            JSONObject jSONObject = this.getSection(this.mResponse, "providerSettings");
            Iterator iterator = jSONObject.keys();
            do {
                if (!iterator.hasNext()) {
                    this.mProviderSettingsHolder.fillSubProvidersDetails();
                    return;
                }
                String string = (String)iterator.next();
                JSONObject jSONObject2 = jSONObject.optJSONObject(string);
                if (jSONObject2 == null) continue;
                boolean bl2 = jSONObject2.optBoolean("mpis", false);
                String string2 = jSONObject2.optString("spId", "0");
                String string3 = jSONObject2.optString("providerLoadName", string);
                JSONObject jSONObject3 = this.getSection(jSONObject2, "adUnits");
                JSONObject jSONObject4 = this.getSection(jSONObject2, "application");
                JSONObject jSONObject5 = this.getSection(jSONObject3, "rewardedVideo");
                JSONObject jSONObject6 = this.getSection(jSONObject3, "interstitial");
                JSONObject jSONObject7 = this.getSection(jSONObject3, "banner");
                JSONObject jSONObject8 = IronSourceUtils.mergeJsons(jSONObject5, jSONObject4);
                JSONObject jSONObject9 = IronSourceUtils.mergeJsons(jSONObject6, jSONObject4);
                JSONObject jSONObject10 = IronSourceUtils.mergeJsons(jSONObject7, jSONObject4);
                if (this.mProviderSettingsHolder.containsProviderSettings(string)) {
                    ProviderSettings providerSettings = this.mProviderSettingsHolder.getProviderSettings(string);
                    JSONObject jSONObject11 = providerSettings.getRewardedVideoSettings();
                    JSONObject jSONObject12 = providerSettings.getInterstitialSettings();
                    JSONObject jSONObject13 = providerSettings.getBannerSettings();
                    providerSettings.setRewardedVideoSettings(IronSourceUtils.mergeJsons(jSONObject11, jSONObject8));
                    providerSettings.setInterstitialSettings(IronSourceUtils.mergeJsons(jSONObject12, jSONObject9));
                    providerSettings.setBannerSettings(IronSourceUtils.mergeJsons(jSONObject13, jSONObject10));
                    providerSettings.setIsMultipleInstances(bl2);
                    providerSettings.setSubProviderId(string2);
                    continue;
                }
                if (this.mProviderSettingsHolder.containsProviderSettings("Mediation") && ("SupersonicAds".toLowerCase().equals((Object)string3.toLowerCase()) || "RIS".toLowerCase().equals((Object)string3.toLowerCase()))) {
                    ProviderSettings providerSettings = this.mProviderSettingsHolder.getProviderSettings("Mediation");
                    JSONObject jSONObject14 = providerSettings.getRewardedVideoSettings();
                    JSONObject jSONObject15 = providerSettings.getInterstitialSettings();
                    JSONObject jSONObject16 = new JSONObject(jSONObject14.toString());
                    JSONObject jSONObject17 = new JSONObject(jSONObject15.toString());
                    JSONObject jSONObject18 = IronSourceUtils.mergeJsons(jSONObject16, jSONObject8);
                    JSONObject jSONObject19 = IronSourceUtils.mergeJsons(jSONObject17, jSONObject9);
                    ProviderSettings providerSettings2 = new ProviderSettings(string, string3, jSONObject4, jSONObject18, jSONObject19, jSONObject10);
                    providerSettings2.setIsMultipleInstances(bl2);
                    providerSettings2.setSubProviderId(string2);
                    this.mProviderSettingsHolder.addProviderSettings(providerSettings2);
                    continue;
                }
                ProviderSettings providerSettings = new ProviderSettings(string, string3, jSONObject4, jSONObject8, jSONObject9, jSONObject10);
                providerSettings.setIsMultipleInstances(bl2);
                providerSettings.setSubProviderId(string2);
                this.mProviderSettingsHolder.addProviderSettings(providerSettings);
            } while (true);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private BannerPlacement parseSingleBNPlacement(JSONObject jSONObject) {
        if (jSONObject == null) return null;
        int n2 = jSONObject.optInt("placementId", -1);
        String string = jSONObject.optString("placementName", "");
        PlacementAvailabilitySettings placementAvailabilitySettings = this.getPlacementAvailabilitySettings(jSONObject);
        if (n2 < 0) return null;
        if (TextUtils.isEmpty((CharSequence)string)) return null;
        BannerPlacement bannerPlacement = new BannerPlacement(n2, string, placementAvailabilitySettings);
        if (placementAvailabilitySettings == null) return bannerPlacement;
        CappingManager.addCappingInfo(this.mContext, bannerPlacement);
        return bannerPlacement;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private InterstitialPlacement parseSingleISPlacement(JSONObject jSONObject) {
        if (jSONObject == null) return null;
        int n2 = jSONObject.optInt("placementId", -1);
        String string = jSONObject.optString("placementName", "");
        PlacementAvailabilitySettings placementAvailabilitySettings = this.getPlacementAvailabilitySettings(jSONObject);
        if (n2 < 0) return null;
        if (TextUtils.isEmpty((CharSequence)string)) return null;
        InterstitialPlacement interstitialPlacement = new InterstitialPlacement(n2, string, placementAvailabilitySettings);
        if (placementAvailabilitySettings == null) return interstitialPlacement;
        CappingManager.addCappingInfo(this.mContext, interstitialPlacement);
        return interstitialPlacement;
    }

    private OfferwallPlacement parseSingleOWPlacement(JSONObject jSONObject) {
        if (jSONObject != null) {
            int n2 = jSONObject.optInt("placementId", -1);
            String string = jSONObject.optString("placementName", "");
            if (n2 >= 0 && !TextUtils.isEmpty((CharSequence)string)) {
                return new OfferwallPlacement(n2, string);
            }
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Placement parseSingleRVPlacement(JSONObject jSONObject) {
        if (jSONObject == null) return null;
        int n2 = jSONObject.optInt("placementId", -1);
        String string = jSONObject.optString("placementName", "");
        String string2 = jSONObject.optString("virtualItemName", "");
        int n3 = jSONObject.optInt("virtualItemCount", -1);
        PlacementAvailabilitySettings placementAvailabilitySettings = this.getPlacementAvailabilitySettings(jSONObject);
        if (n2 < 0) return null;
        if (TextUtils.isEmpty((CharSequence)string)) return null;
        if (TextUtils.isEmpty((CharSequence)string2)) return null;
        if (n3 <= 0) return null;
        Placement placement = new Placement(n2, string, string2, n3, placementAvailabilitySettings);
        if (placementAvailabilitySettings == null) return placement;
        CappingManager.addCappingInfo(this.mContext, placement);
        return placement;
    }

    public Configurations getConfigurations() {
        return this.mConfigurations;
    }

    public List<IronSource.AD_UNIT> getInitiatedAdUnits() {
        if (this.mResponse != null && this.mConfigurations != null) {
            ProviderOrder providerOrder;
            ProviderOrder providerOrder2;
            ArrayList arrayList = new ArrayList();
            if (this.mConfigurations.getRewardedVideoConfigurations() != null && (providerOrder2 = this.mProviderOrder) != null && providerOrder2.getRewardedVideoProviderOrder().size() > 0) {
                arrayList.add((Object)IronSource.AD_UNIT.REWARDED_VIDEO);
            }
            if (this.mConfigurations.getInterstitialConfigurations() != null && (providerOrder = this.mProviderOrder) != null && providerOrder.getInterstitialProviderOrder().size() > 0) {
                arrayList.add((Object)IronSource.AD_UNIT.INTERSTITIAL);
            }
            if (this.mConfigurations.getOfferwallConfigurations() != null) {
                arrayList.add((Object)IronSource.AD_UNIT.OFFERWALL);
            }
            if (this.mConfigurations.getBannerConfigurations() != null) {
                arrayList.add((Object)IronSource.AD_UNIT.BANNER);
            }
            return arrayList;
        }
        return null;
    }

    public ProviderOrder getProviderOrder() {
        return this.mProviderOrder;
    }

    public ProviderSettingsHolder getProviderSettingsHolder() {
        return this.mProviderSettingsHolder;
    }

    public String getRVBackFillProvider() {
        try {
            String string = this.mProviderOrder.getRVBackFillProvider();
            return string;
        }
        catch (Exception exception) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getRVBackFillProvider", (Throwable)exception);
            return null;
        }
    }

    public String getRVPremiumProvider() {
        try {
            String string = this.mProviderOrder.getRVPremiumProvider();
            return string;
        }
        catch (Exception exception) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getRVPremiumProvider", (Throwable)exception);
            return null;
        }
    }

    public boolean isValidResponse() {
        boolean bl2 = this.mResponse != null;
        boolean bl3 = bl2 && !this.mResponse.has("error");
        boolean bl4 = bl3 && this.mProviderOrder != null;
        boolean bl5 = bl4 && this.mProviderSettingsHolder != null;
        return bl5 && this.mConfigurations != null;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", (Object)this.mAppKey);
            jSONObject.put("userId", (Object)this.mUserId);
            jSONObject.put("response", (Object)this.mResponse);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return jSONObject.toString();
    }
}

