/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.Window
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.RelativeLayout;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdControllerFactory;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdUtils2;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.DisplayUtils;
import com.amazon.device.ads.ExpandProperties;
import com.amazon.device.ads.ForceOrientation;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.LayoutFactory;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ModalAdActivityAdapter;
import com.amazon.device.ads.OrientationProperties;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.Size;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ViewUtils;
import org.json.JSONObject;

class ModalAdActivityAdapter
implements AdActivity.AdActivityAdapter {
    private static final String CONTENT_DESCRIPTION_AD_CONTAINER_VIEW = "adContainerView";
    private static final String CONTENT_DESCRIPTION_EXPANSION_VIEW = "expansionView";
    private static final String LOGTAG = "ModalAdActivityAdapter";
    private Activity activity;
    private ViewGroup adContainerView;
    private AdControlAccessor adControlAccessor;
    private final AdUtils2 adUtils;
    private final AndroidBuildInfo buildInfo;
    private final ExpandProperties expandProperties;
    private ViewGroup expansionView;
    private final JSONUtils.JSONUtilities jsonUtils;
    private Size lastReportedSize;
    private final LayoutFactory layoutFactory;
    private final MobileAdsLogger logger;
    private final OrientationProperties orientationProperties;
    private String url;
    private final ViewUtils viewUtils;

    public ModalAdActivityAdapter() {
        this(new MobileAdsLoggerFactory(), new AdUtils2(), new JSONUtils.JSONUtilities(), new ExpandProperties(), new OrientationProperties(), new AndroidBuildInfo(), new LayoutFactory(), new ViewUtils());
    }

    ModalAdActivityAdapter(MobileAdsLoggerFactory mobileAdsLoggerFactory, AdUtils2 adUtils2, JSONUtils.JSONUtilities jSONUtilities, ExpandProperties expandProperties, OrientationProperties orientationProperties, AndroidBuildInfo androidBuildInfo, LayoutFactory layoutFactory, ViewUtils viewUtils) {
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.adUtils = adUtils2;
        this.jsonUtils = jSONUtilities;
        this.expandProperties = expandProperties;
        this.orientationProperties = orientationProperties;
        this.buildInfo = androidBuildInfo;
        this.layoutFactory = layoutFactory;
        this.viewUtils = viewUtils;
    }

    static /* synthetic */ ViewGroup access$100(ModalAdActivityAdapter modalAdActivityAdapter) {
        return modalAdActivityAdapter.expansionView;
    }

    static /* synthetic */ ViewUtils access$200(ModalAdActivityAdapter modalAdActivityAdapter) {
        return modalAdActivityAdapter.viewUtils;
    }

    static /* synthetic */ AdControlAccessor access$300(ModalAdActivityAdapter modalAdActivityAdapter) {
        return modalAdActivityAdapter.adControlAccessor;
    }

    static /* synthetic */ Size access$400(ModalAdActivityAdapter modalAdActivityAdapter) {
        return modalAdActivityAdapter.lastReportedSize;
    }

    static /* synthetic */ Size access$402(ModalAdActivityAdapter modalAdActivityAdapter, Size size) {
        modalAdActivityAdapter.lastReportedSize = size;
        return size;
    }

    private Size computeExpandedSizeInPixels(ExpandProperties expandProperties) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expanding Ad to ");
        stringBuilder.append(expandProperties.getWidth());
        stringBuilder.append("x");
        stringBuilder.append(expandProperties.getHeight());
        mobileAdsLogger.d(stringBuilder.toString());
        return new Size(this.adUtils.deviceIndependentPixelToPixel(expandProperties.getWidth()), this.adUtils.deviceIndependentPixelToPixel(expandProperties.getHeight()));
    }

    private void createExpandedView() {
        this.expansionView = this.layoutFactory.createLayout((Context)this.activity, LayoutFactory.LayoutType.RELATIVE_LAYOUT, CONTENT_DESCRIPTION_EXPANSION_VIEW);
        this.adContainerView = this.layoutFactory.createLayout((Context)this.activity, LayoutFactory.LayoutType.FRAME_LAYOUT, CONTENT_DESCRIPTION_AD_CONTAINER_VIEW);
    }

    private void expandAd() {
        if (this.url != null) {
            this.adControlAccessor.stashView();
        }
        Size size = this.computeExpandedSizeInPixels(this.expandProperties);
        this.createExpandedView();
        this.adControlAccessor.moveViewToViewGroup(this.adContainerView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1), true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(size.getWidth(), size.getHeight());
        layoutParams.addRule(13);
        this.expansionView.addView((View)this.adContainerView, (ViewGroup.LayoutParams)layoutParams);
        this.activity.setContentView((View)this.expansionView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        this.adControlAccessor.enableCloseButton(true ^ this.expandProperties.getUseCustomClose());
    }

    private void finishActivity() {
        if (!this.activity.isFinishing()) {
            this.adControlAccessor = null;
            this.activity.finish();
        }
    }

    private void orientationPropertyChange() {
        if (this.adControlAccessor.isVisible()) {
            if (!this.adControlAccessor.isModal()) {
                return;
            }
            Activity activity = this.activity;
            if (activity == null) {
                this.logger.e("unable to handle orientation property change because the context did not contain an activity");
                return;
            }
            int n2 = activity.getRequestedOrientation();
            MobileAdsLogger mobileAdsLogger = this.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Current Orientation: ");
            stringBuilder.append(n2);
            mobileAdsLogger.d(stringBuilder.toString());
            int n3 = 2.$SwitchMap$com$amazon$device$ads$ForceOrientation[this.orientationProperties.getForceOrientation().ordinal()];
            if (n3 != 1) {
                if (n3 == 2) {
                    this.activity.setRequestedOrientation(6);
                }
            } else {
                this.activity.setRequestedOrientation(7);
            }
            if (ForceOrientation.NONE.equals((Object)this.orientationProperties.getForceOrientation())) {
                if (this.orientationProperties.isAllowOrientationChange().booleanValue()) {
                    this.activity.setRequestedOrientation(-1);
                } else {
                    Activity activity2 = this.activity;
                    activity2.setRequestedOrientation(DisplayUtils.determineCanonicalScreenOrientation((Context)activity2, this.buildInfo));
                }
            }
            int n4 = this.activity.getRequestedOrientation();
            MobileAdsLogger mobileAdsLogger2 = this.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("New Orientation: ");
            stringBuilder2.append(n4);
            mobileAdsLogger2.d(stringBuilder2.toString());
            if (n4 != n2) {
                this.reportSizeChangeEvent();
            }
        }
    }

    private void reportSizeChangeEvent() {
        this.expansionView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this){
            final /* synthetic */ ModalAdActivityAdapter this$0;
            {
                this.this$0 = modalAdActivityAdapter;
            }

            public void onGlobalLayout() {
                ModalAdActivityAdapter.access$200(this.this$0).removeOnGlobalLayoutListener(ModalAdActivityAdapter.access$100(this.this$0).getViewTreeObserver(), this);
                com.amazon.device.ads.Position position = ModalAdActivityAdapter.access$300(this.this$0).getCurrentPosition();
                if (position == null) {
                    return;
                }
                Size size = position.getSize();
                if (size != null && !size.equals(ModalAdActivityAdapter.access$400(this.this$0))) {
                    ModalAdActivityAdapter.access$402(this.this$0, size);
                    AdControlAccessor adControlAccessor = ModalAdActivityAdapter.access$300(this.this$0);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("mraidBridge.sizeChange(");
                    stringBuilder.append(size.getWidth());
                    stringBuilder.append(",");
                    stringBuilder.append(size.getHeight());
                    stringBuilder.append(");");
                    adControlAccessor.injectJavascript(stringBuilder.toString());
                }
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        AdControlAccessor adControlAccessor = this.adControlAccessor;
        if (adControlAccessor != null) {
            return adControlAccessor.onBackButtonPress();
        }
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        this.reportSizeChangeEvent();
    }

    @Override
    public void onCreate() {
        Intent intent = this.activity.getIntent();
        String string = intent.getStringExtra("url");
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            this.url = string;
        }
        JSONObject jSONObject = this.jsonUtils.getJSONObjectFromString(intent.getStringExtra("expandProperties"));
        this.expandProperties.fromJSONObject(jSONObject);
        if (this.url != null) {
            this.expandProperties.setWidth(-1);
            this.expandProperties.setHeight(-1);
        }
        JSONObject jSONObject2 = this.jsonUtils.getJSONObjectFromString(intent.getStringExtra("orientationProperties"));
        this.orientationProperties.fromJSONObject(jSONObject2);
        AndroidTargetUtils.enableHardwareAcceleration(this.buildInfo, this.activity.getWindow());
        AdControlAccessor adControlAccessor = this.adControlAccessor = AdControllerFactory.getCachedAdControlAccessor();
        if (adControlAccessor == null) {
            this.logger.e("Failed to show expanded ad due to an error in the Activity.");
            this.activity.finish();
            return;
        }
        adControlAccessor.setAdActivity(this.activity);
        this.adControlAccessor.addSDKEventListener(new ModalAdSDKEventListener());
        this.expandAd();
        this.orientationPropertyChange();
        this.adControlAccessor.fireAdEvent(new AdEvent(AdEvent.AdEventType.EXPANDED));
        this.adControlAccessor.injectJavascript("mraidBridge.stateChange('expanded');");
        this.reportSizeChangeEvent();
    }

    @Override
    public void onDestroy() {
        AdControlAccessor adControlAccessor = this.adControlAccessor;
        if (adControlAccessor != null) {
            adControlAccessor.closeAd();
        }
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onStop() {
        AdControlAccessor adControlAccessor;
        if (this.activity.isFinishing() && (adControlAccessor = this.adControlAccessor) != null) {
            adControlAccessor.closeAd();
        }
    }

    @Override
    public void onWindowFocusChanged() {
    }

    @Override
    public void preOnCreate() {
        this.activity.requestWindowFeature(1);
        this.activity.getWindow().setFlags(1024, 1024);
        AndroidTargetUtils.hideActionAndStatusBars(this.buildInfo, this.activity);
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    private class ModalAdSDKEventListener
    implements SDKEventListener {
        private ModalAdSDKEventListener() {
        }

        @Override
        public void onSDKEvent(SDKEvent sDKEvent, AdControlAccessor adControlAccessor) {
            if (sDKEvent.getEventType().equals((Object)SDKEvent.SDKEventType.CLOSED)) {
                ModalAdActivityAdapter.this.finishActivity();
            }
        }
    }

}

