/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.amazon.device.ads;

import android.view.ViewTreeObserver;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import com.amazon.device.ads.MRAIDAdSDKEventListener;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEventListener;

class MRAIDAdSDKEventListener
implements SDKEventListener {
    private static final String LOGTAG = "MRAIDAdSDKEventListener";
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    private MRAIDAdSDKBridge mraidAdSDKBridge;

    MRAIDAdSDKEventListener(MRAIDAdSDKBridge mRAIDAdSDKBridge) {
        this.mraidAdSDKBridge = mRAIDAdSDKBridge;
    }

    static /* synthetic */ MRAIDAdSDKBridge access$000(MRAIDAdSDKEventListener mRAIDAdSDKEventListener) {
        return mRAIDAdSDKEventListener.mraidAdSDKBridge;
    }

    private void handleBridgeAddedEvent(SDKEvent sDKEvent, AdControlAccessor adControlAccessor) {
        String string = sDKEvent.getParameter("bridgeName");
        if (string != null && string.equals((Object)this.mraidAdSDKBridge.getName())) {
            int n2 = 2.$SwitchMap$com$amazon$device$ads$AdState[adControlAccessor.getAdState().ordinal()];
            if (n2 != 1 && n2 != 2) {
                if (n2 != 3) {
                    return;
                }
                if (!adControlAccessor.isModal()) {
                    this.handleDefaultEvent(adControlAccessor);
                    this.handleReadyEvent(adControlAccessor);
                    return;
                }
            } else {
                this.handleShowingEvent(adControlAccessor);
                this.handleDefaultEvent(adControlAccessor);
                this.handleReadyEvent(adControlAccessor);
            }
        }
    }

    private void handleClosedEvent(AdControlAccessor adControlAccessor) {
        if (adControlAccessor.getAdState().equals((Object)AdState.EXPANDED)) {
            this.mraidAdSDKBridge.collapseExpandedAd(adControlAccessor);
            return;
        }
        if (adControlAccessor.getAdState().equals((Object)AdState.SHOWING)) {
            adControlAccessor.injectJavascript("mraidBridge.stateChange('hidden');");
            adControlAccessor.injectJavascript("mraidBridge.viewableChange('false');");
        }
    }

    private void handleDefaultEvent(AdControlAccessor adControlAccessor) {
        adControlAccessor.injectJavascript("mraidBridge.stateChange('default');");
    }

    private void handleReadyEvent(AdControlAccessor adControlAccessor) {
        adControlAccessor.injectJavascript("mraidBridge.ready();");
    }

    private void handleShowingEvent(AdControlAccessor adControlAccessor) {
        adControlAccessor.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, adControlAccessor){
            final /* synthetic */ MRAIDAdSDKEventListener this$0;
            final /* synthetic */ AdControlAccessor val$adControlAccessor;
            {
                this.this$0 = mRAIDAdSDKEventListener;
                this.val$adControlAccessor = adControlAccessor;
            }

            public void onGlobalLayout() {
                com.amazon.device.ads.Position position = this.val$adControlAccessor.getCurrentPosition();
                if (position != null) {
                    this.val$adControlAccessor.removeOnGlobalLayoutListener(this);
                    MRAIDAdSDKEventListener.access$000(this.this$0).updateDefaultPosition(position.getSize().getWidth(), position.getSize().getHeight(), position.getX(), position.getY());
                    MRAIDAdSDKEventListener.access$000(this.this$0).orientationPropertyChange();
                }
            }
        });
    }

    private void handleViewableEvent(SDKEvent sDKEvent, AdControlAccessor adControlAccessor) {
        String string = sDKEvent.getParameter("IS_VIEWABLE");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mraidBridge.viewableChange(");
        stringBuilder.append(string);
        stringBuilder.append(");");
        adControlAccessor.injectJavascript(stringBuilder.toString());
    }

    @Override
    public void onSDKEvent(SDKEvent sDKEvent, AdControlAccessor adControlAccessor) {
        this.logger.d(sDKEvent.getEventType().toString());
        switch (2.$SwitchMap$com$amazon$device$ads$SDKEvent$SDKEventType[sDKEvent.getEventType().ordinal()]) {
            default: {
                return;
            }
            case 9: {
                this.handleViewableEvent(sDKEvent, adControlAccessor);
                return;
            }
            case 8: {
                this.handleBridgeAddedEvent(sDKEvent, adControlAccessor);
                return;
            }
            case 6: 
            case 7: {
                adControlAccessor.injectJavascript("mraidBridge.stateChange('hidden');");
                return;
            }
            case 5: {
                this.mraidAdSDKBridge.reportSizeChangeEvent();
                return;
            }
            case 4: {
                this.handleClosedEvent(adControlAccessor);
                return;
            }
            case 3: {
                this.handleShowingEvent(adControlAccessor);
                this.handleDefaultEvent(adControlAccessor);
                this.handleReadyEvent(adControlAccessor);
                return;
            }
            case 2: {
                this.handleDefaultEvent(adControlAccessor);
                this.handleReadyEvent(adControlAccessor);
            }
            case 1: 
        }
    }
}

