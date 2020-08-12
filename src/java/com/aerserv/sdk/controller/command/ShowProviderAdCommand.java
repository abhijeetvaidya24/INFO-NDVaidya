/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.aerserv.sdk.controller.command;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.aerserv.sdk.AerServAdType;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.RequestType;
import com.aerserv.sdk.adapter.Provider;
import com.aerserv.sdk.adapter.SimultaneousAdLoader;
import com.aerserv.sdk.adapter.ThirdPartyProvider;
import com.aerserv.sdk.controller.command.Command;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.ProviderListenerLocator;
import com.aerserv.sdk.factory.ProviderFactory;
import com.aerserv.sdk.model.Asplc;
import com.aerserv.sdk.model.ad.ProviderAd;
import com.aerserv.sdk.model.ad.ThirdPartyProviderAd;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.view.View;
import com.aerserv.sdk.view.ViewLocator;
import org.json.JSONObject;

public class ShowProviderAdCommand
implements Command {
    private static final String LOG_TAG = "ShowProviderAdCommand";
    private ProviderAd ad;
    private AerServAdType aerServAdType;
    private Integer backButtonTimeout;
    private Context context;
    private String controllerId;
    private boolean isBackButtonEnabled;
    private boolean isDebug;
    private boolean isPreload;
    private String plc;
    private ProviderListener providerListener;
    private RequestType requestType;
    private String rid;
    private Long showAdTimeout;
    private String viewId;

    public ShowProviderAdCommand(Context context, ProviderAd providerAd, ProviderListener providerListener, AerServAdType aerServAdType, String string, String string2, boolean bl, boolean bl2, Long l2, boolean bl3, Integer n2, String string3, RequestType requestType, String string4) {
        this.context = context;
        this.ad = providerAd;
        this.providerListener = providerListener;
        this.aerServAdType = aerServAdType;
        this.viewId = string;
        this.controllerId = string2;
        this.isDebug = bl;
        this.isPreload = bl2;
        this.showAdTimeout = l2;
        this.isBackButtonEnabled = bl3;
        this.backButtonTimeout = n2;
        this.plc = string3;
        this.requestType = requestType;
        this.rid = string4;
        AerServLog.d(LOG_TAG, "ShowProviderAdCommand constructed");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void execute() {
        AerServLog.d(LOG_TAG, "Execute being called on ShowProviderAdCommand");
        String string = this.ad.getProviderName();
        if (this.aerServAdType == AerServAdType.INTERSTITIAL && ("ASAdColony".equals((Object)string) || "ASAdMob".equals((Object)string) || "ASAppLovin".equals((Object)string) || "ASAppNext".equals((Object)string) || "ASChartboost".equals((Object)string) || "ASFacebook".equals((Object)string) || "ASMillennial".equals((Object)string) || "ASMoPubSdk".equals((Object)string) || "ASRhythmOneSdk".equals((Object)string) || "ASMyTargetSdk".equals((Object)string) || "ASTremor".equals((Object)string) || "ASUnity".equals((Object)string) || "ASVungle".equals((Object)string) || "ASYahoo".equals((Object)string) || "ASInMobi".equals((Object)string))) {
            ThirdPartyProvider thirdPartyProvider;
            ProviderAd providerAd = this.ad;
            if (!(providerAd instanceof ThirdPartyProviderAd)) {
                AerServLog.i(LOG_TAG, "step4: Ad is not a ThirdPartyProviderAd.  Connot continue.");
                this.providerListener.onProviderFailure();
                return;
            }
            ThirdPartyProviderAd thirdPartyProviderAd = (ThirdPartyProviderAd)providerAd;
            AerServVirtualCurrency aerServVirtualCurrency = thirdPartyProviderAd.getVirtualCurrency();
            Asplc asplc = thirdPartyProviderAd.getAsplc();
            if (asplc == null) {
                AerServLog.i(LOG_TAG, "step4: asplc is null. Cannot continue.");
                this.providerListener.onProviderFailure();
                return;
            }
            asplc.setVc(aerServVirtualCurrency);
            if (TextUtils.isEmpty((CharSequence)asplc.getRid())) {
                asplc.setRid(this.rid);
                String string2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("step4: pre-init might failed. Reloading the ");
                stringBuilder.append(asplc.getAdapterName());
                stringBuilder.append(" lib.");
                AerServLog.i(string2, stringBuilder.toString());
                AerServSettings.initAdapterClassByName((Activity)this.context, asplc.getAdapterName(), asplc.getJsonObject());
            }
            if ((thirdPartyProvider = ThirdPartyProvider.getInstance(asplc, string, this.plc, this.controllerId, thirdPartyProviderAd.getData().optJSONObject(string), this.isDebug)) == null) {
                String string3 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("step4: ThirdPartyProvider ");
                stringBuilder.append(string);
                stringBuilder.append(" is null. Cannot continue.");
                AerServLog.i(string3, stringBuilder.toString());
                this.providerListener.onProviderFailure();
                return;
            }
            if (!thirdPartyProvider.hasAd(asplc.hasVcEnabled())) {
                String string4 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("step4: ");
                stringBuilder.append(string);
                stringBuilder.append(" ");
                stringBuilder.append(asplc.getAsplcId());
                stringBuilder.append(" of plc: ");
                stringBuilder.append(this.plc);
                stringBuilder.append(" has no ad. Try to load it again.");
                AerServLog.i(string4, stringBuilder.toString());
                SimultaneousAdLoader.getDynamicPrices(this.context, thirdPartyProvider, asplc, (int)asplc.getLoadTimeout());
            }
            if (!thirdPartyProvider.hasAd(asplc.hasVcEnabled())) {
                String string5 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("step4: ");
                stringBuilder.append(string);
                stringBuilder.append(" ");
                stringBuilder.append(asplc.getAsplcId());
                stringBuilder.append(" still has no ad. Cannot continue. Give up!");
                AerServLog.i(string5, stringBuilder.toString());
                this.providerListener.onProviderNoAd();
                return;
            }
            if (this.requestType == RequestType.PRELOAD) {
                thirdPartyProvider.reserveAd(this.context, true);
                return;
            }
            if (this.requestType == RequestType.SHOW) {
                thirdPartyProvider.showAd(this.context);
                return;
            }
            thirdPartyProvider.reserveAd(this.context, false);
            return;
        }
        View view = this.viewId != null ? ViewLocator.getInstance().locateView(this.viewId) : null;
        View view2 = view;
        Provider provider = ProviderFactory.buildProvider(this.ad, this.providerListener, this.context, this.aerServAdType, view2, this.controllerId, this.isDebug, this.isPreload, this.showAdTimeout, this.isBackButtonEnabled, this.backButtonTimeout);
        if (provider == null) {
            AerServLog.i(LOG_TAG, "step4: provider is null, cannot continue");
            if (this.ad instanceof ThirdPartyProviderAd) {
                if (ProviderListenerLocator.getProviderListener(this.controllerId) == null) return;
                this.providerListener.onProviderFailure();
                return;
            }
            this.providerListener.onProviderFailure();
            return;
        }
        try {
            provider.requestAd();
            return;
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "step4: There was an error trying to show ad", exception);
            this.providerListener.onProviderFailure();
        }
    }
}

