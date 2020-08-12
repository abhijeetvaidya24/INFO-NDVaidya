/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.amazon.device.ads.MobileAdsLogger
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.GooglePlayServices;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

class GooglePlayServicesAdapter {
    private static final String LOGTAG = "GooglePlayServicesAdapter";
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    GooglePlayServicesAdapter() {
    }

    public GooglePlayServices.AdvertisingInfo getAdvertisingIdentifierInfo() {
        AdvertisingIdClient.Info info;
        Context context = MobileAdsInfoStore.getInstance().getApplicationContext();
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo((Context)context);
        }
        catch (Exception exception) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{exception.getMessage()};
            mobileAdsLogger.v("Run time exception occured while retrieving Advertising Identifier:  %s", arrobject);
            return new GooglePlayServices.AdvertisingInfo();
        }
        catch (GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
            this.logger.v("Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.");
            return new GooglePlayServices.AdvertisingInfo();
        }
        catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
            this.logger.v("Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.");
            return GooglePlayServices.AdvertisingInfo.createNotAvailable();
        }
        catch (IOException iOException) {
            this.logger.e("Retrieving the Google Play Services Advertising Identifier caused an IOException.");
            return new GooglePlayServices.AdvertisingInfo();
        }
        catch (IllegalStateException illegalStateException) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{illegalStateException.getMessage()};
            mobileAdsLogger.e("The Google Play Services Advertising Identifier could not be retrieved: %s", arrobject);
            return new GooglePlayServices.AdvertisingInfo();
        }
        this.logger.v("The Google Play Services Advertising Identifier was successfully retrieved.");
        if (info != null) {
            String string = info.getId();
            boolean bl = info.isLimitAdTrackingEnabled();
            return new GooglePlayServices.AdvertisingInfo().setAdvertisingIdentifier(string).setLimitAdTrackingEnabled(bl);
        }
        return null;
    }
}

