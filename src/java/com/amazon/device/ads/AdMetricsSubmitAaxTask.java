/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package com.amazon.device.ads;

import android.os.AsyncTask;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.WebRequest;

class AdMetricsSubmitAaxTask
extends AsyncTask<WebRequest, Void, Void> {
    private static final String LOGTAG = "AdMetricsSubmitAaxTask";
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    AdMetricsSubmitAaxTask() {
    }

    public /* varargs */ Void doInBackground(WebRequest ... arrwebRequest) {
        for (WebRequest webRequest : arrwebRequest) {
            try {
                webRequest.makeCall();
            }
            catch (WebRequest.WebRequestException webRequestException) {
                int n = 1.$SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[webRequestException.getStatus().ordinal()];
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            if (n != 4) {
                                continue;
                            }
                        } else {
                            MobileAdsLogger mobileAdsLogger = this.logger;
                            Object[] arrobject = new Object[]{webRequestException.getMessage()};
                            mobileAdsLogger.e("Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", arrobject);
                        }
                        MobileAdsLogger mobileAdsLogger = this.logger;
                        Object[] arrobject = new Object[]{webRequestException.getMessage()};
                        mobileAdsLogger.e("Unable to submit metrics for ad because of unsupported character encoding, msg: %s", arrobject);
                        continue;
                    }
                    MobileAdsLogger mobileAdsLogger = this.logger;
                    Object[] arrobject = new Object[]{webRequestException.getMessage()};
                    mobileAdsLogger.e("Unable to submit metrics for ad due to Network Failure, msg: %s", arrobject);
                    continue;
                }
                MobileAdsLogger mobileAdsLogger = this.logger;
                Object[] arrobject = new Object[]{webRequestException.getMessage()};
                mobileAdsLogger.e("Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", arrobject);
            }
        }
        return null;
    }

}

