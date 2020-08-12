/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.text.TextUtils
 *  android.view.View
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 */
package com.aerserv.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MoatData;
import com.aerserv.sdk.utils.RegexUtils;
import com.aerserv.sdk.utils.StringUtils;
import com.moat.analytics.mobile.aer.MoatFactory;
import com.moat.analytics.mobile.aer.NativeDisplayTracker;
import com.moat.analytics.mobile.aer.NativeVideoTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MoatUtils {
    private static final String LOG_TAG = "com.aerserv.sdk.utils.MoatUtils";
    private static final String STATIC_PARTNER_CODE = "aerservnative722147260635";
    private static final String VERIFICATION_PATTERN = "<Verification vendor=[\"'](Moat|MOAT|moat)[\"']>\\s*(<(\\s|.)*?>\\s*)*?<\\/Verification>";
    private static final String VIDEO_PARTNER_CODE = "aerservnativevideo709050655357";
    private static final String VIEWABLE_IMPRESSION_PATTERN = "<ViewableImpression id=[\"'](.)*?[\"']>\\s*(<(\\s|.)*?>\\s*)*?<\\/ViewableImpression>";
    private static Object lock;
    private static Map<String, MoatData> moatDataMap;

    static {
        moatDataMap = new HashMap();
        lock = new Object();
    }

    public static void cleanup(String string) {
        MoatUtils.stopTracking(string, true);
    }

    public static void createTracker(String string, Activity activity, View view) {
        MoatUtils.createTracker(string, activity, view, null, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void createTracker(String string, Activity activity, View view, MediaPlayer mediaPlayer, boolean bl) {
        try {
            Object object;
            Object object2 = object = lock;
            // MONITORENTER : object2
        }
        catch (Exception exception) {
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error creating Moat Tracker: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string2, stringBuilder.toString(), exception);
            return;
        }
        if (!MoatUtils.isEnabled(moatDataMap, string)) {
            // MONITOREXIT : object2
            return;
        }
        if (moatDataMap.get((Object)string) == null) {
            moatDataMap.put((Object)string, (Object)new MoatData());
        }
        MoatData moatData = (MoatData)moatDataMap.get((Object)string);
        if (bl) {
            moatData.setMediaPlayer(mediaPlayer);
            moatData.setView(view);
        }
        moatData.setAppName(activity.getApplicationContext().getPackageName());
        MoatFactory moatFactory = MoatFactory.create(activity);
        if (bl) {
            if (moatData.getNativeVideoTracker() != null) {
                String string3 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Video tracker for controllerId ");
                stringBuilder.append(string);
                stringBuilder.append(" already exits.  Reusing existing one.");
                AerServLog.v(string3, stringBuilder.toString());
                // MONITOREXIT : object2
                return;
            }
            String string4 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Create video tracker for controllerId ");
            stringBuilder.append(string);
            AerServLog.v(string4, stringBuilder.toString());
            moatData.setNativeVideoTracker(moatFactory.createNativeVideoTracker(VIDEO_PARTNER_CODE));
            return;
        }
        if (moatData.getNativeDisplayTracker() != null) {
            String string5 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Displace tracker for controllerId ");
            stringBuilder.append(string);
            stringBuilder.append(" already exits.  Reusing existing one.");
            AerServLog.v(string5, stringBuilder.toString());
            // MONITOREXIT : object2
            return;
        }
        String string6 = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Create display tracker for controllerId ");
        stringBuilder.append(string);
        AerServLog.v(string6, stringBuilder.toString());
        moatData.setNativeDisplayTracker(moatFactory.createNativeDisplayTracker(view, STATIC_PARTNER_CODE));
        // MONITOREXIT : object2
    }

    private static HashMap<String, String> getNativeAdIds(MoatData moatData) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"moatClientLevel1", (Object)moatData.getAdvertiserId());
        hashMap.put((Object)"moatClientLevel2", (Object)moatData.getCampaignId());
        hashMap.put((Object)"moatClientLevel3", (Object)moatData.getLineItemId());
        hashMap.put((Object)"moatClientLevel4", (Object)moatData.getCreativeId());
        hashMap.put((Object)"moatClientSlicer1", (Object)moatData.getAppName());
        hashMap.put((Object)"moatClientSlicer2", (Object)moatData.getPlacement());
        return hashMap;
    }

    private static HashMap<String, String> getVideoAdIds(MoatData moatData) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"level1", (Object)moatData.getAdvertiserId());
        hashMap.put((Object)"level2", (Object)moatData.getCampaignId());
        hashMap.put((Object)"level3", (Object)moatData.getLineItemId());
        hashMap.put((Object)"level4", (Object)moatData.getCreativeId());
        hashMap.put((Object)"slicer1", (Object)moatData.getAppName());
        hashMap.put((Object)"slicer2", (Object)moatData.getPlacement());
        if (!TextUtils.isEmpty((CharSequence)moatData.getMoatVastId())) {
            hashMap.put((Object)"zMoatVASTIDs", (Object)moatData.getMoatVastId());
        }
        return hashMap;
    }

    private static boolean isEnabled(Map<String, MoatData> map, String string) {
        return map.get((Object)string) == null || ((MoatData)map.get((Object)string)).isEnabled();
        {
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void parseAndSetAdIdentifiers(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Object object;
            Object object2 = object = lock;
            // MONITORENTER : object2
        }
        catch (Exception exception) {
            String string4 = LOG_TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Error parsing and setting Moat ad identifiers: ");
            stringBuilder2.append(exception.getMessage());
            AerServLog.w(string4, stringBuilder2.toString(), exception);
            return;
        }
        if (!MoatUtils.isEnabled(moatDataMap, string)) {
            // MONITOREXIT : object2
            return;
        }
        if (moatDataMap.get((Object)string) == null) {
            moatDataMap.put((Object)string, (Object)new MoatData());
        }
        MoatData moatData = (MoatData)moatDataMap.get((Object)string);
        moatData.setAdvertiserId(StringUtils.findValueInUrl(string3, "buyer", "AermarketHosted"));
        moatData.setLineItemId(StringUtils.findValueInUrl(string3, "iline"));
        moatData.setCreativeId(StringUtils.findValueInUrl(string3, "icid"));
        moatData.setPlacement(string2);
        Iterator iterator = RegexUtils.findStringWithPattern(string3, VERIFICATION_PATTERN).iterator();
        while (iterator.hasNext()) {
            Iterator iterator2 = RegexUtils.findStringWithPattern((String)iterator.next(), VIEWABLE_IMPRESSION_PATTERN).iterator();
            while (iterator2.hasNext()) {
                stringBuilder.append((String)iterator2.next());
                stringBuilder.append(";");
            }
        }
        if (stringBuilder.length() >= 1) {
            moatData.setMoatVastId(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
        }
        Object[] arrobject = new Object[]{moatData.getAdvertiserId(), moatData.getCampaignId(), moatData.getLineItemId(), moatData.getCreativeId(), moatData.getPlacement(), moatData.getMoatVastId()};
        String string5 = String.format((String)"Ad identifiers set to advertiserId=%s, campaignId=%s, lineItemId=%s, creativeId=%s, placement=%s, zmoatVastIds=%s", (Object[])arrobject);
        AerServLog.v(LOG_TAG, string5);
        // MONITOREXIT : object2
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void setEnabled(String string, boolean bl) {
        try {
            Object object;
            Object object2 = object = lock;
            // MONITORENTER : object2
        }
        catch (Exception exception) {
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error enabling/disabling Moat: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string2, stringBuilder.toString(), exception);
            return;
        }
        if (moatDataMap.get((Object)string) == null) {
            moatDataMap.put((Object)string, (Object)new MoatData());
        }
        ((MoatData)moatDataMap.get((Object)string)).setEnabled(bl);
        // MONITOREXIT : object2
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void startTracking(String string) {
        try {
            Object object;
            Object object2 = object = lock;
            // MONITORENTER : object2
        }
        catch (Exception exception) {
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error starting Moat tracking: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string2, stringBuilder.toString(), exception);
            return;
        }
        if (!MoatUtils.isEnabled(moatDataMap, string)) {
            // MONITOREXIT : object2
            return;
        }
        MoatData moatData = (MoatData)moatDataMap.get((Object)string);
        if (moatData == null) {
            String string3 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot start tracking for controllerId ");
            stringBuilder.append(string);
            stringBuilder.append(".  moatData is null");
            AerServLog.d(string3, stringBuilder.toString());
            // MONITOREXIT : object2
            return;
        }
        if (moatData.isStarted()) {
            // MONITOREXIT : object2
            return;
        }
        moatData.setStarted(true);
        if (moatData.getNativeDisplayTracker() != null) {
            String string4 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Start display tracking for controllerId ");
            stringBuilder.append(string);
            stringBuilder.append(", for adIds ");
            stringBuilder.append(MoatUtils.getNativeAdIds(moatData));
            AerServLog.v(string4, stringBuilder.toString());
            moatData.getNativeDisplayTracker().track((Map<String, String>)MoatUtils.getNativeAdIds(moatData));
        }
        if (moatData.getNativeVideoTracker() != null) {
            String string5 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Start video tracking for controllerId ");
            stringBuilder.append(string);
            stringBuilder.append(", for adIds ");
            stringBuilder.append(MoatUtils.getVideoAdIds(moatData));
            AerServLog.v(string5, stringBuilder.toString());
            moatData.getNativeVideoTracker().trackVideoAd((Map<String, String>)MoatUtils.getVideoAdIds(moatData), moatData.getMediaPlayer(), moatData.getView());
        }
        // MONITOREXIT : object2
    }

    public static void stopTracking(String string) {
        MoatUtils.stopTracking(string, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private static void stopTracking(String string, boolean bl) {
        try {
            Object object;
            Object object2 = object = lock;
            // MONITORENTER : object2
        }
        catch (Exception exception) {
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error stopping Moat tracking: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string2, stringBuilder.toString(), exception);
            return;
        }
        if (!MoatUtils.isEnabled(moatDataMap, string)) {
            if (bl) {
                moatDataMap.remove((Object)string);
            }
            // MONITOREXIT : object2
            return;
        }
        MoatData moatData = (MoatData)moatDataMap.get((Object)string);
        if (moatData == null) {
            // MONITOREXIT : object2
            return;
        }
        if (moatData.isStarted()) {
            moatData.setStarted(false);
            if (moatData.getNativeDisplayTracker() != null) {
                String string3 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Stop display tracking for controllerId ");
                stringBuilder.append(string);
                AerServLog.v(string3, stringBuilder.toString());
                moatData.getNativeDisplayTracker().stopTracking();
            }
            if (moatData.getNativeVideoTracker() != null) {
                String string4 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Stop video tracking for controllerId ");
                stringBuilder.append(string);
                AerServLog.v(string4, stringBuilder.toString());
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"type", (Object)"AdVideoComplete");
                moatData.getNativeVideoTracker().dispatchEvent((Map<String, Object>)hashMap);
            }
        }
        if (bl) {
            String string5 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Removing Moat tracker for controllerId ");
            stringBuilder.append(string);
            AerServLog.v(string5, stringBuilder.toString());
            moatDataMap.remove((Object)string);
        }
        // MONITOREXIT : object2
    }
}

