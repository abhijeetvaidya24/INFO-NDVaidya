/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AdController
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.SDKEvent;
import java.util.concurrent.atomic.AtomicBoolean;

class AdCloser {
    private static final String LOGTAG = "AdCloser";
    private final AdController adController;
    private final AtomicBoolean isClosing = new AtomicBoolean(false);
    private final MobileAdsLogger logger;

    public AdCloser(AdController adController) {
        this(adController, new MobileAdsLoggerFactory());
    }

    AdCloser(AdController adController, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.adController = adController;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean closeAd() {
        int n;
        boolean bl;
        boolean bl2;
        block6 : {
            block5 : {
                block3 : {
                    block4 : {
                        this.logger.d("Ad is attempting to close.");
                        boolean bl3 = this.adController.getAdState().equals((Object)AdState.READY_TO_LOAD);
                        int n2 = 0;
                        if (bl3) return (boolean)n2;
                        AtomicBoolean atomicBoolean = this.isClosing;
                        n = 1;
                        boolean bl4 = atomicBoolean.getAndSet((boolean)n);
                        n2 = 0;
                        if (bl4) return (boolean)n2;
                        int n3 = this.adController.getAdControlCallback().adClosing();
                        if (n3 == 0) break block3;
                        if (n3 == n) break block4;
                        bl = false;
                        break block5;
                    }
                    bl = true;
                    bl2 = true;
                    break block6;
                }
                bl = true;
            }
            bl2 = false;
        }
        if (bl) {
            this.adController.fireSDKEvent(new SDKEvent(SDKEvent.SDKEventType.CLOSED));
        } else {
            n = 0;
        }
        if (bl2) {
            this.adController.resetToReady();
        }
        this.isClosing.set(false);
        return (boolean)n;
    }
}

