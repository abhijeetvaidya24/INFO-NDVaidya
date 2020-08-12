/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.sdk;

import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinSdkConfiguration;

public class SdkConfigurationImpl
implements AppLovinSdkConfiguration {
    private final j a;

    public SdkConfigurationImpl(j j2) {
        this.a = j2;
    }

    @Override
    public AppLovinSdkConfiguration.ConsentDialogState getConsentDialogState() {
        String string = this.a.a(b.fr);
        if ("applies".equalsIgnoreCase(string)) {
            return AppLovinSdkConfiguration.ConsentDialogState.APPLIES;
        }
        if ("does_not_apply".equalsIgnoreCase(string)) {
            return AppLovinSdkConfiguration.ConsentDialogState.DOES_NOT_APPLY;
        }
        return AppLovinSdkConfiguration.ConsentDialogState.UNKNOWN;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppLovinSdkConfiguration{getConsentDialogState=");
        stringBuilder.append((Object)this.getConsentDialogState());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

