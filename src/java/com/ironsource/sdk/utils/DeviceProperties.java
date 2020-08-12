/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.sdk.utils;

import android.content.Context;
import com.ironsource.environment.DeviceStatus;

public class DeviceProperties {
    private static DeviceProperties mInstance;
    private int mDeviceApiLevel = DeviceStatus.getAndroidAPIVersion();
    private String mDeviceCarrier;
    private String mDeviceModel = DeviceStatus.getDeviceModel();
    private String mDeviceOem = DeviceStatus.getDeviceOEM();
    private String mDeviceOsType = DeviceStatus.getDeviceOs();
    private String mDeviceOsVersion = DeviceStatus.getAndroidOsVersion();

    private DeviceProperties(Context context) {
        this.mDeviceCarrier = DeviceStatus.getMobileCarrier(context);
    }

    public static DeviceProperties getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DeviceProperties(context);
        }
        return mInstance;
    }

    public static String getSupersonicSdkVersion() {
        return "5.53";
    }

    public int getDeviceApiLevel() {
        return this.mDeviceApiLevel;
    }

    public String getDeviceCarrier() {
        return this.mDeviceCarrier;
    }

    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    public String getDeviceOem() {
        return this.mDeviceOem;
    }

    public String getDeviceOsType() {
        return this.mDeviceOsType;
    }

    public String getDeviceOsVersion() {
        return this.mDeviceOsVersion;
    }

    public float getDeviceVolume(Context context) {
        return DeviceStatus.getSystemVolumePercent(context);
    }
}

