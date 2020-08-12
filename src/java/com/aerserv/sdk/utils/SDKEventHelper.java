/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.controller.command.FireEventCommand
 *  com.aerserv.sdk.model.ad.ThirdPartyProviderAd
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.UUID
 */
package com.aerserv.sdk.utils;

import com.aerserv.sdk.controller.command.FireEventCommand;
import com.aerserv.sdk.model.Asplc;
import com.aerserv.sdk.model.ad.ThirdPartyProviderAd;
import com.aerserv.sdk.utils.UrlBuilder;
import java.util.UUID;

public class SDKEventHelper {
    public static final String SDK_AD_RETURNED = "34";
    public static final String SDK_ATTEMPT = "12";
    public static final String SDK_CONNECTION_ERROR = "35";
    public static final String SDK_FAILURE = "14";
    public static final String SDK_FAIL_SHOW = "36";
    public static final String SDK_IMPRESSION = "13";
    public static final String SDK_REFRESH = "37";

    public static final void sendEvent(ThirdPartyProviderAd thirdPartyProviderAd, String string, String string2, String string3) {
        Asplc asplc = thirdPartyProviderAd.getAsplc();
        if (asplc != null) {
            SDKEventHelper.sendEvent(asplc.getSdkEventUrl(), asplc.getAdapterName(), string3, string, string2);
        }
    }

    public static final void sendEvent(String string, String string2, String string3, String string4, String string5) {
        new FireEventCommand(string.replace((CharSequence)"${rid}", (CharSequence)string3).replace((CharSequence)"${plc}", (CharSequence)string5).replace((CharSequence)"${buyer}", (CharSequence)string2).replace((CharSequence)"${ev}", (CharSequence)string4).replace((CharSequence)"${eu}", (CharSequence)UUID.randomUUID().toString()).replace((CharSequence)"${sdkv}", (CharSequence)"3.1.1").replace((CharSequence)"${adid}", (CharSequence)UrlBuilder.getAdid(null))).execute();
    }
}

