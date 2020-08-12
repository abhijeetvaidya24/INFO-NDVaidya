/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.model.ad;

import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.model.Asplc;
import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.model.ad.AdType;
import com.aerserv.sdk.model.ad.ProviderAd;
import com.aerserv.sdk.utils.AerServLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ThirdPartyProviderAd
implements ProviderAd {
    private static final String LOG_TAG = "ThirdPartyProviderAd";
    private String adapterName;
    private Asplc asplc;
    private transient JSONObject data;
    private String providerName;
    private AerServVirtualCurrency virtualCurrencyData;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ThirdPartyProviderAd(Placement placement) {
        try {
            JSONObject jSONObject = new JSONObject(placement.getAdMarkup());
            String string = (String)jSONObject.keys().next();
            if (string != null && string.length() != 0) {
                int n2;
                this.providerName = string;
                if (string != null && string.length() > 3 && string.startsWith("AS")) {
                    this.adapterName = string.substring(2);
                }
                JSONObject jSONObject2 = (JSONObject)jSONObject.get(string);
                this.virtualCurrencyData = placement.getVc();
                if (this.virtualCurrencyData != null) {
                    jSONObject2.put("vc", (Object)this.virtualCurrencyData);
                }
                if ((n2 = placement.getAsplcid()) > 0) {
                    this.asplc = Asplc.getAsplc(n2);
                    if (this.asplc == null) {
                        String string2 = LOG_TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("step3: Unknown asplcid: ");
                        stringBuilder.append(n2);
                        AerServLog.w(string2, stringBuilder.toString());
                        try {
                            jSONObject2.put("asplcid", n2);
                            jSONObject2.put("baseEventUrl", (Object)placement.getSdkBaseEventUrl());
                            jSONObject2.put("adapterName", (Object)this.adapterName);
                            this.asplc = Asplc.putAsplc(jSONObject2);
                        }
                        catch (Exception exception) {
                            String string3 = LOG_TAG;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Failed to create asplc instance for :");
                            stringBuilder2.append(n2);
                            AerServLog.e(string3, stringBuilder2.toString(), exception);
                        }
                    } else {
                        if (this.virtualCurrencyData != null) {
                            this.asplc.setVc(this.virtualCurrencyData);
                        }
                        if (jSONObject2 != null) {
                            this.asplc.setLoadTimeout(jSONObject2);
                        }
                        String string4 = LOG_TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("asplcid: ");
                        stringBuilder.append(n2);
                        AerServLog.d(string4, stringBuilder.toString());
                    }
                }
                if (this.asplc.getLoadTimeout() != 6000L) {
                    jSONObject2.put("Timeout", this.asplc.getLoadTimeout());
                }
                if (!jSONObject2.has(string)) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(string, (Object)jSONObject2);
                    this.data = jSONObject3;
                    return;
                }
                this.data = jSONObject2;
                return;
            }
            throw new IllegalArgumentException("The provider name cannot be null or empty.");
        }
        catch (JSONException jSONException) {
            AerServLog.e(LOG_TAG, "There was an error creating ThirdPartyAd as could not parse json", (Exception)((Object)jSONException));
            return;
        }
    }

    @Override
    public AdType getAdType() {
        return AdType.THIRD_PARTY;
    }

    public String getAdapterName() {
        return this.adapterName;
    }

    public Asplc getAsplc() {
        return this.asplc;
    }

    public JSONObject getData() {
        return this.data;
    }

    @Override
    public boolean getIsShowAdCommandRequiredOnPreload() {
        return true;
    }

    @Override
    public String getProviderName() {
        return this.providerName;
    }

    @Override
    public AerServVirtualCurrency getVirtualCurrency() {
        return this.virtualCurrencyData;
    }
}

