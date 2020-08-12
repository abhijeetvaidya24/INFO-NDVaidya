/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package com.appsgeyser.sdk.deviceidparser;

import android.content.Context;
import com.appsgeyser.sdk.deviceidparser.DeviceIdParameters;

public interface IDeviceIdParserListener {
    public void onDeviceIdParametersObtained(Context var1, DeviceIdParameters var2);
}

