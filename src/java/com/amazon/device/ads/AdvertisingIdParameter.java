/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.UserIdParameter;
import com.amazon.device.ads.WebRequest;

class AdvertisingIdParameter
implements UserIdParameter {
    private static final String DEVICE_ID_KEY = "deviceId";
    private final AdvertisingIdentifier advertisingIdentifier;
    private AdvertisingIdentifier.Info advertisingIndentifierInfo;
    private final DebugProperties debugProperties;
    private DeviceInfo deviceInfo;
    private final Settings settings;

    public AdvertisingIdParameter() {
        this(new AdvertisingIdentifier(), Settings.getInstance(), DebugProperties.getInstance(), MobileAdsInfoStore.getInstance().getDeviceInfo());
    }

    AdvertisingIdParameter(AdvertisingIdentifier advertisingIdentifier, Settings settings, DebugProperties debugProperties, DeviceInfo deviceInfo) {
        this.advertisingIdentifier = advertisingIdentifier;
        this.settings = settings;
        this.debugProperties = debugProperties;
        this.deviceInfo = deviceInfo;
    }

    private boolean canIdentify() {
        if (this.advertisingIndentifierInfo == null) {
            AdvertisingIdentifier advertisingIdentifier = this.advertisingIdentifier;
            int n2 = this.settings.getInt("configVersion", 0);
            boolean bl = false;
            if (n2 != 0) {
                bl = true;
            }
            advertisingIdentifier.setShouldSetCurrentAdvertisingIdentifier(bl);
            this.advertisingIndentifierInfo = this.advertisingIdentifier.getAdvertisingIdentifierInfo();
        }
        if (this.deviceInfo == null) {
            this.deviceInfo = MobileAdsInfoStore.getInstance().getDeviceInfo();
        }
        return this.advertisingIndentifierInfo.canDo();
    }

    @Override
    public boolean evaluate(WebRequest webRequest) {
        String string;
        if (this.canIdentify() && (string = this.debugProperties.getDebugPropertyAsString("debug.idfa", this.advertisingIndentifierInfo.getAdvertisingIdentifier())) != null) {
            webRequest.putUnencodedQueryParameter("idfa", string);
            return true;
        }
        String string2 = this.settings.getString(DEVICE_ID_KEY, this.deviceInfo.getUdidSha1());
        webRequest.putUnencodedQueryParameter(DEVICE_ID_KEY, this.debugProperties.getDebugPropertyAsString("debug.sha1udid", string2));
        return true;
    }
}

