/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.provider.Settings$SettingNotFoundException
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.amazon.device.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.amazon.device.ads.GooglePlayServices;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;

public class AmazonFireServicesAdapter {
    public static final int FIREOS_ADTRACKING_NOT_LIMITED = 0;
    private static final String LOGTAG = "AmazonFireServicesAdapter";
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    private AmazonFireServicesAdapter() {
    }

    public static AmazonFireServicesAdapter newAdapter() {
        return new AmazonFireServicesAdapter();
    }

    public GooglePlayServices.AdvertisingInfo getAdvertisingIdentifierInfo() {
        boolean bl;
        String string;
        block6 : {
            block5 : {
                ContentResolver contentResolver = MobileAdsInfoStore.getInstance().getApplicationContext().getContentResolver();
                int n = Settings.Secure.getInt((ContentResolver)contentResolver, (String)"limit_ad_tracking");
                string = Settings.Secure.getString((ContentResolver)contentResolver, (String)"advertising_id");
                MobileAdsLogger mobileAdsLogger = this.logger;
                bl = true;
                Object[] arrobject = new Object[bl];
                arrobject[0] = string;
                mobileAdsLogger.v("Fire Id retrieved : %s", arrobject);
                if (n == 0) break block5;
                try {
                    MobileAdsLogger mobileAdsLogger2 = this.logger;
                    Object[] arrobject2 = new Object[bl];
                    arrobject2[0] = string;
                    mobileAdsLogger2.v("Fire Device does not allow ad tracking : %s", arrobject2);
                    break block6;
                }
                catch (Exception exception) {
                    MobileAdsLogger mobileAdsLogger3 = this.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(" Attempt to retrieve fireID failed. Reason : %s ");
                    stringBuilder.append(exception.getLocalizedMessage());
                    mobileAdsLogger3.v(stringBuilder.toString());
                    return new GooglePlayServices.AdvertisingInfo();
                }
                catch (Settings.SettingNotFoundException settingNotFoundException) {
                    MobileAdsLogger mobileAdsLogger4 = this.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(" Advertising setting not found on this device : %s");
                    stringBuilder.append(settingNotFoundException.getLocalizedMessage());
                    mobileAdsLogger4.v(stringBuilder.toString());
                    return new GooglePlayServices.AdvertisingInfo();
                }
            }
            bl = false;
        }
        GooglePlayServices.AdvertisingInfo advertisingInfo = new GooglePlayServices.AdvertisingInfo();
        advertisingInfo.setAdvertisingIdentifier(string);
        advertisingInfo.setLimitAdTrackingEnabled(bl);
        return advertisingInfo;
    }
}

