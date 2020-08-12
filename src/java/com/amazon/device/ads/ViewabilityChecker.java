/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.webkit.WebView
 *  com.amazon.device.ads.AdContainer
 *  com.amazon.device.ads.AdController
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import android.graphics.Rect;
import android.view.View;
import android.webkit.WebView;
import com.amazon.device.ads.AdContainer;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ViewabilityInfo;
import com.amazon.device.ads.ViewabilityOverlapCalculator;
import org.json.JSONException;
import org.json.JSONObject;

class ViewabilityChecker {
    static final String HEIGHT_AD = "height";
    static final String INSTRUMENTATION_URL = "instrumentationPixelUrl";
    static final String IS_AD_ONSCREEN = "isAdOnScreen";
    private static final String LOGTAG = "ViewabilityChecker";
    static final String VIEWABLE_PERCENTAGE = "viewablePercentage";
    static final String WIDTH_AD = "width";
    static final String X_POSITION_AD = "x";
    static final String Y_POSITION_AD = "y";
    private final AdController adController;
    private float adTotalArea;
    private View adView;
    private final MobileAdsLogger logger;
    private ViewabilityOverlapCalculator viewabilityOverlapCalculator;

    public ViewabilityChecker(AdController adController) {
        this(adController, new MobileAdsLoggerFactory(), new ViewabilityOverlapCalculator(adController));
    }

    ViewabilityChecker(AdController adController, MobileAdsLoggerFactory mobileAdsLoggerFactory, ViewabilityOverlapCalculator viewabilityOverlapCalculator) {
        this.adController = adController;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        if (this.adController != null) {
            this.viewabilityOverlapCalculator = viewabilityOverlapCalculator;
            return;
        }
        throw new IllegalArgumentException("AdController is null");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private JSONObject getJSONObject(float f2, boolean bl, View view) {
        JSONObject jSONObject = new JSONObject();
        int[] arrn = new int[2];
        try {
            jSONObject.put(VIEWABLE_PERCENTAGE, (double)f2);
            jSONObject.put(WIDTH_AD, view.getWidth());
            jSONObject.put(HEIGHT_AD, view.getHeight());
            if (bl) {
                this.adView.getLocationOnScreen(arrn);
            }
            jSONObject.put(X_POSITION_AD, arrn[0]);
            jSONObject.put(Y_POSITION_AD, arrn[1]);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{jSONException.getMessage()};
            mobileAdsLogger.w("JSON Error occured %s", arrobject);
            return null;
        }
    }

    private boolean hasWindowFocus() {
        View view = this.adController.getRootView();
        if (view == null) {
            return false;
        }
        return view.hasWindowFocus();
    }

    public ViewabilityInfo getViewabilityInfo() {
        float f2;
        Rect rect = new Rect();
        this.adView = this.adController.getAdContainer().getCurrentAdView();
        View view = this.adView;
        this.adTotalArea = view == null ? 0.0f : (float)(view.getWidth() * this.adView.getHeight());
        if ((double)this.adTotalArea == 0.0) {
            this.logger.w("AdView width and height not set");
            return null;
        }
        boolean bl = this.adView.getGlobalVisibleRect(rect);
        boolean bl2 = this.adView.isShown();
        boolean bl3 = this.hasWindowFocus();
        boolean bl4 = AndroidTargetUtils.isAdTransparent((View)this.adController.getAdContainer());
        if (bl4) {
            this.logger.forceLog(MobileAdsLogger.Level.WARN, "This ad view is transparent therefore it will not be considered viewable. Please ensure the ad view is completely opaque.", new Object[0]);
        }
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{bl, bl2, bl3, bl4};
        mobileAdsLogger.d("IsAdVisible: %s, IsAdShown: %s, windowHasFocus: %s, IsAdTransparent: %s", arrobject);
        boolean bl5 = bl && bl2 && bl3 && !bl4;
        if (bl5) {
            if (this.adController.isModal()) {
                f2 = 100.0f;
            } else {
                long l2 = System.currentTimeMillis();
                f2 = this.viewabilityOverlapCalculator.calculateViewablePercentage(this.adView, rect);
                long l3 = System.currentTimeMillis();
                MobileAdsLogger mobileAdsLogger2 = this.logger;
                Object[] arrobject2 = new Object[]{l3 - l2};
                mobileAdsLogger2.d("Total computation time: %d", arrobject2);
            }
        } else {
            f2 = 0.0f;
        }
        if (f2 == 0.0f) {
            bl5 = false;
        }
        return new ViewabilityInfo(bl5, this.getJSONObject(f2, bl5, this.adView));
    }
}

