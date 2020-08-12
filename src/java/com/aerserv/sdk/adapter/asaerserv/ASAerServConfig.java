/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Properties
 *  org.json.JSONException
 */
package com.aerserv.sdk.adapter.asaerserv;

import android.content.Context;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.ProviderListenerLocator;
import com.aerserv.sdk.model.ad.ProviderAd;
import com.aerserv.sdk.utils.AerServLog;
import java.util.Properties;
import org.json.JSONException;

public class ASAerServConfig {
    private Context context;
    private String controllerId;
    private boolean isDebug;
    private ProviderAd providerAd;
    private ProviderListener providerListener;
    private Long showAdTimeout = null;

    public ASAerServConfig(Properties properties) throws JSONException {
        this.context = (Context)properties.get((Object)"context");
        if (this.context != null) {
            this.controllerId = (String)properties.get((Object)"controllerId");
            String string = this.controllerId;
            if (string != null && !string.isEmpty()) {
                this.providerListener = ProviderListenerLocator.getProviderListener(this.controllerId);
                if (this.providerListener != null) {
                    this.providerAd = (ProviderAd)properties.get((Object)"providerAd");
                    if (this.providerAd != null) {
                        boolean bl = properties.get((Object)"isDebug") != null && (Boolean)properties.get((Object)"isDebug") != false;
                        this.isDebug = bl;
                        if (properties.get((Object)"showAdTimeout") != null) {
                            try {
                                this.showAdTimeout = (Long)properties.get((Object)"showAdTimeout");
                                return;
                            }
                            catch (Exception exception) {
                                String string2 = ASAerServConfig.class.getSimpleName();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Error reading showAdTimeout: ");
                                stringBuilder.append(exception.getMessage());
                                AerServLog.w(string2, stringBuilder.toString());
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("properties does not contain providerAd");
                }
                throw new IllegalArgumentException("Could not locate provider listener. Cannot continue.");
            }
            throw new IllegalArgumentException("properties does not contain controllerId");
        }
        throw new IllegalArgumentException("properties does not contain context");
    }

    public Context getContext() {
        return this.context;
    }

    public String getControllerId() {
        return this.controllerId;
    }

    public ProviderAd getProviderAd() {
        return this.providerAd;
    }

    public ProviderListener getProviderListener() {
        return this.providerListener;
    }

    public Long getShowAdTimeout() {
        return this.showAdTimeout;
    }

    public boolean isDebug() {
        return this.isDebug;
    }
}

