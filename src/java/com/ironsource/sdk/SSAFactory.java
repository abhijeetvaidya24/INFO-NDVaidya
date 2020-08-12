/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.ironsource.sdk.agent.IronSourceAdsPublisherAgent
 *  java.lang.Exception
 *  java.lang.Object
 */
package com.ironsource.sdk;

import android.app.Activity;
import com.ironsource.sdk.SSAPublisher;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;

public class SSAFactory {
    public static SSAPublisher getPublisherInstance(Activity activity) throws Exception {
        return IronSourceAdsPublisherAgent.getInstance((Activity)activity);
    }
}

