/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.ironsource.mediationsdk.model.BannerPlacement
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Calendar
 *  java.util.TimeZone
 */
package com.ironsource.mediationsdk.utils;

import android.content.Context;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.PlacementAvailabilitySettings;
import com.ironsource.mediationsdk.model.PlacementCappingType;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Calendar;
import java.util.TimeZone;

public class CappingManager {
    public static void addCappingInfo(Context context, BannerPlacement bannerPlacement) {
        Class<CappingManager> class_ = CappingManager.class;
        synchronized (CappingManager.class) {
            if (context != null && bannerPlacement != null) {
                PlacementAvailabilitySettings placementAvailabilitySettings;
                block5 : {
                    placementAvailabilitySettings = bannerPlacement.getPlacementAvailabilitySettings();
                    if (placementAvailabilitySettings != null) break block5;
                    return;
                }
                CappingManager.addCappingInfo(context, "Banner", bannerPlacement.getPlacementName(), placementAvailabilitySettings);
                // ** MonitorExit[var4_2] (shouldn't be in output)
                return;
            }
            // ** MonitorExit[var4_2] (shouldn't be in output)
            return;
        }
    }

    public static void addCappingInfo(Context context, InterstitialPlacement interstitialPlacement) {
        Class<CappingManager> class_ = CappingManager.class;
        synchronized (CappingManager.class) {
            if (context != null && interstitialPlacement != null) {
                PlacementAvailabilitySettings placementAvailabilitySettings;
                block5 : {
                    placementAvailabilitySettings = interstitialPlacement.getPlacementAvailabilitySettings();
                    if (placementAvailabilitySettings != null) break block5;
                    return;
                }
                CappingManager.addCappingInfo(context, "Interstitial", interstitialPlacement.getPlacementName(), placementAvailabilitySettings);
                // ** MonitorExit[var4_2] (shouldn't be in output)
                return;
            }
            // ** MonitorExit[var4_2] (shouldn't be in output)
            return;
        }
    }

    public static void addCappingInfo(Context context, Placement placement) {
        Class<CappingManager> class_ = CappingManager.class;
        synchronized (CappingManager.class) {
            if (context != null && placement != null) {
                PlacementAvailabilitySettings placementAvailabilitySettings;
                block5 : {
                    placementAvailabilitySettings = placement.getPlacementAvailabilitySettings();
                    if (placementAvailabilitySettings != null) break block5;
                    return;
                }
                CappingManager.addCappingInfo(context, "Rewarded Video", placement.getPlacementName(), placementAvailabilitySettings);
                // ** MonitorExit[var4_2] (shouldn't be in output)
                return;
            }
            // ** MonitorExit[var4_2] (shouldn't be in output)
            return;
        }
    }

    private static void addCappingInfo(Context context, String string, String string2, PlacementAvailabilitySettings placementAvailabilitySettings) {
        boolean bl2 = placementAvailabilitySettings.isDeliveryEnabled();
        IronSourceUtils.saveBooleanToSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.IS_DELIVERY_ENABLED", string2), bl2);
        if (!bl2) {
            return;
        }
        boolean bl3 = placementAvailabilitySettings.isCappingEnabled();
        IronSourceUtils.saveBooleanToSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.IS_CAPPING_ENABLED", string2), bl3);
        if (bl3) {
            int n2 = placementAvailabilitySettings.getCappingValue();
            IronSourceUtils.saveIntToSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.MAX_NUMBER_OF_SHOWS", string2), n2);
            PlacementCappingType placementCappingType = placementAvailabilitySettings.getCappingType();
            IronSourceUtils.saveStringToSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.CAPPING_TYPE", string2), placementCappingType.toString());
        }
        boolean bl4 = placementAvailabilitySettings.isPacingEnabled();
        IronSourceUtils.saveBooleanToSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.IS_PACING_ENABLED", string2), bl4);
        if (bl4) {
            int n3 = placementAvailabilitySettings.getPacingValue();
            IronSourceUtils.saveIntToSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.SECONDS_BETWEEN_SHOWS", string2), n3);
        }
    }

    private static String constructSharedPrefsKey(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("_");
        stringBuilder.append(string2);
        stringBuilder.append("_");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static void incrementShowCounter(Context context, InterstitialPlacement interstitialPlacement) {
        Class<CappingManager> class_ = CappingManager.class;
        synchronized (CappingManager.class) {
            if (interstitialPlacement != null) {
                CappingManager.incrementShowCounter(context, "Interstitial", interstitialPlacement.getPlacementName());
            }
            return;
        }
    }

    public static void incrementShowCounter(Context context, Placement placement) {
        Class<CappingManager> class_ = CappingManager.class;
        synchronized (CappingManager.class) {
            if (placement != null) {
                CappingManager.incrementShowCounter(context, "Rewarded Video", placement.getPlacementName());
            }
            return;
        }
    }

    private static void incrementShowCounter(Context context, String string, String string2) {
        String string3 = CappingManager.constructSharedPrefsKey(string, "CappingManager.IS_PACING_ENABLED", string2);
        int n2 = 0;
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, string3, false)) {
            long l2 = System.currentTimeMillis();
            IronSourceUtils.saveLongToSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", string2), l2);
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.IS_CAPPING_ENABLED", string2), false)) {
            IronSourceUtils.getIntFromSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.MAX_NUMBER_OF_SHOWS", string2), 0);
            String string4 = CappingManager.constructSharedPrefsKey(string, "CappingManager.CURRENT_NUMBER_OF_SHOWS", string2);
            int n3 = IronSourceUtils.getIntFromSharedPrefs(context, string4, 0);
            boolean bl2 = n3 == 0;
            if (bl2) {
                PlacementCappingType placementCappingType;
                String string5 = IronSourceUtils.getStringFromSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.CAPPING_TYPE", string2), PlacementCappingType.PER_DAY.toString());
                PlacementCappingType[] arrplacementCappingType = PlacementCappingType.values();
                int n4 = arrplacementCappingType.length;
                do {
                    placementCappingType = null;
                    if (n2 >= n4) break;
                    PlacementCappingType placementCappingType2 = arrplacementCappingType[n2];
                    if (placementCappingType2.value.equals((Object)string5)) {
                        placementCappingType = placementCappingType2;
                        break;
                    }
                    ++n2;
                } while (true);
                long l3 = CappingManager.initTimeThreshold(placementCappingType);
                IronSourceUtils.saveLongToSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.CAPPING_TIME_THRESHOLD", string2), l3);
            }
            IronSourceUtils.saveIntToSharedPrefs(context, string4, n3 + 1);
        }
    }

    private static long initTimeThreshold(PlacementCappingType placementCappingType) {
        Calendar calendar = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"UTC"));
        int n2 = 1.$SwitchMap$com$ironsource$mediationsdk$model$PlacementCappingType[placementCappingType.ordinal()];
        if (n2 != 1) {
            if (n2 == 2) {
                calendar.set(14, 0);
                calendar.set(13, 0);
                calendar.set(12, 0);
                calendar.add(11, 1);
            }
        } else {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(11, 0);
            calendar.add(6, 1);
        }
        return calendar.getTimeInMillis();
    }

    public static boolean isBnPlacementCapped(Context context, String string) {
        Class<CappingManager> class_ = CappingManager.class;
        synchronized (CappingManager.class) {
            ECappingStatus eCappingStatus = CappingManager.isPlacementCapped(context, "Banner", string);
            ECappingStatus eCappingStatus2 = ECappingStatus.NOT_CAPPED;
            boolean bl2 = eCappingStatus != eCappingStatus2;
            return bl2;
        }
    }

    public static ECappingStatus isPlacementCapped(Context context, InterstitialPlacement interstitialPlacement) {
        Class<CappingManager> class_ = CappingManager.class;
        synchronized (CappingManager.class) {
            block5 : {
                if (context != null && interstitialPlacement != null) {
                    if (interstitialPlacement.getPlacementAvailabilitySettings() == null) break block5;
                    ECappingStatus eCappingStatus = CappingManager.isPlacementCapped(context, "Interstitial", interstitialPlacement.getPlacementName());
                    // ** MonitorExit[var5_2] (shouldn't be in output)
                    return eCappingStatus;
                }
            }
            ECappingStatus eCappingStatus = ECappingStatus.NOT_CAPPED;
            // ** MonitorExit[var5_2] (shouldn't be in output)
            return eCappingStatus;
        }
    }

    public static ECappingStatus isPlacementCapped(Context context, Placement placement) {
        Class<CappingManager> class_ = CappingManager.class;
        synchronized (CappingManager.class) {
            block5 : {
                if (context != null && placement != null) {
                    if (placement.getPlacementAvailabilitySettings() == null) break block5;
                    ECappingStatus eCappingStatus = CappingManager.isPlacementCapped(context, "Rewarded Video", placement.getPlacementName());
                    // ** MonitorExit[var5_2] (shouldn't be in output)
                    return eCappingStatus;
                }
            }
            ECappingStatus eCappingStatus = ECappingStatus.NOT_CAPPED;
            // ** MonitorExit[var5_2] (shouldn't be in output)
            return eCappingStatus;
        }
    }

    private static ECappingStatus isPlacementCapped(Context context, String string, String string2) {
        int n2;
        long l2;
        long l3 = System.currentTimeMillis();
        if (!IronSourceUtils.getBooleanFromSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.IS_DELIVERY_ENABLED", string2), true)) {
            return ECappingStatus.CAPPED_PER_DELIVERY;
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.IS_PACING_ENABLED", string2), false) && l3 - (l2 = IronSourceUtils.getLongFromSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", string2), 0L)) < (long)((n2 = IronSourceUtils.getIntFromSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.SECONDS_BETWEEN_SHOWS", string2), 0)) * 1000)) {
            return ECappingStatus.CAPPED_PER_PACE;
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.IS_CAPPING_ENABLED", string2), false)) {
            int n3 = IronSourceUtils.getIntFromSharedPrefs(context, CappingManager.constructSharedPrefsKey(string, "CappingManager.MAX_NUMBER_OF_SHOWS", string2), 0);
            String string3 = CappingManager.constructSharedPrefsKey(string, "CappingManager.CURRENT_NUMBER_OF_SHOWS", string2);
            int n4 = IronSourceUtils.getIntFromSharedPrefs(context, string3, 0);
            String string4 = CappingManager.constructSharedPrefsKey(string, "CappingManager.CAPPING_TIME_THRESHOLD", string2);
            if (l3 >= IronSourceUtils.getLongFromSharedPrefs(context, string4, 0L)) {
                IronSourceUtils.saveIntToSharedPrefs(context, string3, 0);
                IronSourceUtils.saveLongToSharedPrefs(context, string4, 0L);
            } else if (n4 >= n3) {
                return ECappingStatus.CAPPED_PER_COUNT;
            }
        }
        return ECappingStatus.NOT_CAPPED;
    }

    public static final class ECappingStatus
    extends Enum<ECappingStatus> {
        private static final /* synthetic */ ECappingStatus[] $VALUES;
        public static final /* enum */ ECappingStatus CAPPED_PER_COUNT;
        public static final /* enum */ ECappingStatus CAPPED_PER_DELIVERY;
        public static final /* enum */ ECappingStatus CAPPED_PER_PACE;
        public static final /* enum */ ECappingStatus NOT_CAPPED;

        static {
            CAPPED_PER_DELIVERY = new ECappingStatus();
            CAPPED_PER_COUNT = new ECappingStatus();
            CAPPED_PER_PACE = new ECappingStatus();
            NOT_CAPPED = new ECappingStatus();
            ECappingStatus[] arreCappingStatus = new ECappingStatus[]{CAPPED_PER_DELIVERY, CAPPED_PER_COUNT, CAPPED_PER_PACE, NOT_CAPPED};
            $VALUES = arreCappingStatus;
        }

        public static ECappingStatus valueOf(String string) {
            return (ECappingStatus)Enum.valueOf(ECappingStatus.class, (String)string);
        }

        public static ECappingStatus[] values() {
            return (ECappingStatus[])$VALUES.clone();
        }
    }

}

