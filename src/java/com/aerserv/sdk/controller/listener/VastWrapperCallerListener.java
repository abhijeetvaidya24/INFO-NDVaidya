/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.aerserv.sdk.controller.listener;

import com.aerserv.sdk.model.vast.VAST;

public interface VastWrapperCallerListener {
    public void wrapperCallFailed();

    public void wrapperResultsReceived(VAST var1);
}

