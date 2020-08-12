/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  com.aerserv.sdk.view.ASVastInterstitialActivity
 *  com.aerserv.sdk.view.ASVpaidInterstitalActivity
 *  com.aerserv.sdk.view.ASWebviewInterstitialActivity
 *  com.aerserv.sdk.view.AerServFullScreenAdActivity
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Properties
 *  org.json.JSONException
 */
package com.aerserv.sdk.adapter.asaerserv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.adapter.Provider;
import com.aerserv.sdk.adapter.asaerserv.ASAerServConfig;
import com.aerserv.sdk.adapter.asaerserv.ASAerServInterstitialProvider;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.model.ad.AdType;
import com.aerserv.sdk.model.ad.ProviderAd;
import com.aerserv.sdk.model.ad.VASTProviderAd;
import com.aerserv.sdk.model.vast.Vpaid;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.view.ASVastInterstitialActivity;
import com.aerserv.sdk.view.ASVpaidInterstitalActivity;
import com.aerserv.sdk.view.ASWebviewInterstitialActivity;
import com.aerserv.sdk.view.AerServFullScreenAdActivity;
import java.io.Serializable;
import java.util.Properties;
import org.json.JSONException;

public class ASAerServInterstitialProvider
implements Provider {
    private ASAerServConfig asAerServConfig;
    private Properties properties;

    public ASAerServInterstitialProvider(Properties properties) throws JSONException {
        this.properties = properties;
        this.asAerServConfig = new ASAerServConfig(properties);
    }

    public static Provider getInstance(Properties properties) throws JSONException {
        return new ASAerServInterstitialProvider(properties);
    }

    @Override
    public void requestAd() {
        Intent intent;
        ProviderAd providerAd = this.asAerServConfig.getProviderAd();
        String string = this.getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Requesting ad from AerServ Interstitial Provider with type ");
        stringBuilder.append((Object)providerAd.getAdType());
        AerServLog.d(string, stringBuilder.toString());
        Bundle bundle = new Bundle();
        bundle.putBoolean("isBackButtonEnabled", ((Boolean)this.properties.get((Object)"isBackButtonEnabled")).booleanValue());
        bundle.putInt("backButtonTimeout", ((Integer)this.properties.get((Object)"backButtonTimeout")).intValue());
        switch (1.$SwitchMap$com$aerserv$sdk$model$ad$AdType[providerAd.getAdType().ordinal()]) {
            default: {
                AerServEventListenerLocator.fireEvent(this.asAerServConfig.getControllerId(), AerServEvent.AD_FAILED);
                this.asAerServConfig.getProviderListener().onProviderFailShow();
                intent = null;
                break;
            }
            case 6: {
                if (((VASTProviderAd)providerAd).getVpaid() != null) {
                    AerServLog.d(this.getClass().getName(), "VAST is a VPAID creative");
                    intent = new Intent(this.asAerServConfig.getContext(), ASVpaidInterstitalActivity.class);
                    break;
                }
                intent = new Intent(this.asAerServConfig.getContext(), ASVastInterstitialActivity.class);
                break;
            }
            case 2: {
                bundle.putString("mraidPlayVideoUrl", this.properties.getProperty("mraidPlayVideoUrl"));
            }
            case 3: {
                bundle.putString("mraidBannerViewId", this.properties.getProperty("mraidBannerViewId"));
                bundle.putString("mraidExpandUrl", this.properties.getProperty("mraidExpandUrl"));
            }
            case 4: {
                Object object = this.properties.get((Object)"mraidExpandCustomClose");
                boolean bl = object != null && (Boolean)object != false;
                bundle.putBoolean("mraidExpandCustomClose", bl);
            }
            case 5: {
                intent = new Intent(this.asAerServConfig.getContext(), ASWebviewInterstitialActivity.class);
                break;
            }
            case 1: {
                intent = new Intent(this.asAerServConfig.getContext(), AerServFullScreenAdActivity.class);
            }
        }
        if (intent != null) {
            bundle.putSerializable("providerAd", (Serializable)providerAd);
            bundle.putSerializable("controllerId", (Serializable)this.asAerServConfig.getControllerId());
            bundle.putLong("showAdTimeout", this.asAerServConfig.getShowAdTimeout().longValue());
            intent.putExtra("payload", bundle);
            intent.setFlags(268435456);
            this.asAerServConfig.getContext().startActivity(intent);
        }
    }
}

