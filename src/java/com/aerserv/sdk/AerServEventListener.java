/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package com.aerserv.sdk;

import com.aerserv.sdk.AerServEvent;
import java.util.List;

public interface AerServEventListener {
    public static final int AD_FAILED_CODE = 1;
    public static final int AD_FAILED_REASON;

    public void onAerServEvent(AerServEvent var1, List<Object> var2);
}

