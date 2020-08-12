/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.ironsource.sdk.agent.IronSourceAdsPublisherAgent
 *  com.ironsource.sdk.controller.IronSourceWebView
 *  java.lang.Exception
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.sdk.handlers;

import android.app.Activity;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;
import com.ironsource.sdk.controller.IronSourceWebView;
import com.ironsource.sdk.data.SSAEnums;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;

public class BackButtonHandler {
    public static BackButtonHandler mInstance;

    public static BackButtonHandler getInstance() {
        BackButtonHandler backButtonHandler = mInstance;
        if (backButtonHandler == null) {
            backButtonHandler = new BackButtonHandler();
        }
        return backButtonHandler;
    }

    public boolean handleBackButton(Activity activity) {
        SSAEnums.BackButtonState backButtonState = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getBackButtonState();
        int n2 = 1.$SwitchMap$com$ironsource$sdk$data$SSAEnums$BackButtonState[backButtonState.ordinal()];
        if (n2 != 1 && n2 != 2) {
            block5 : {
                if (n2 != 3) {
                    return false;
                }
                IronSourceWebView ironSourceWebView = IronSourceAdsPublisherAgent.getInstance((Activity)activity).getWebViewController();
                if (ironSourceWebView == null) break block5;
                try {
                    ironSourceWebView.nativeNavigationPressed("back");
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }

}

