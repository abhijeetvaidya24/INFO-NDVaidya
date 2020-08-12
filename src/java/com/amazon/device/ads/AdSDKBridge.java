/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.JavascriptInteractor;
import com.amazon.device.ads.SDKEventListener;

interface AdSDKBridge {
    public String getJavascript();

    public JavascriptInteractor.Executor getJavascriptInteractorExecutor();

    public String getName();

    public SDKEventListener getSDKEventListener();

    public boolean hasNativeExecution();
}

