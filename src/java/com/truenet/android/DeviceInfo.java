/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.b.b.h
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.jetbrains.annotations.NotNull
 */
package com.truenet.android;

import a.a.b.b.h;
import org.jetbrains.annotations.NotNull;

public final class DeviceInfo {
    @NotNull
    private final String advertisingId;
    @NotNull
    private final String cellId;
    @NotNull
    private final String deviceManufacturer;
    @NotNull
    private final String deviceModel;
    @NotNull
    private final String deviceType;
    @NotNull
    private final String deviceVersion;
    @NotNull
    private final String isp;
    @NotNull
    private final String ispName;
    @NotNull
    private final String latitude;
    @NotNull
    private final String locale;
    @NotNull
    private final String locationAreaCode;
    @NotNull
    private final String longitude;
    @NotNull
    private final String networkOperName;
    @NotNull
    private final String networkType;
    @NotNull
    private final String osId;
    @NotNull
    private final String osVer;
    @NotNull
    private final String packageName;
    @NotNull
    private String publisherId;
    @NotNull
    private final String sdkVersion;
    @NotNull
    private final String signalLevel;
    @NotNull
    private final String userAgent;

    public DeviceInfo(@NotNull String string2, @NotNull String string3, @NotNull String string4, @NotNull String string5, @NotNull String string6, @NotNull String string7, @NotNull String string8, @NotNull String string9, @NotNull String string10, @NotNull String string11, @NotNull String string12, @NotNull String string13, @NotNull String string14, @NotNull String string15, @NotNull String string16, @NotNull String string17, @NotNull String string18, @NotNull String string19, @NotNull String string20, @NotNull String string21, @NotNull String string22) {
        h.b((Object)string2, (String)"latitude");
        h.b((Object)string3, (String)"longitude");
        h.b((Object)string4, (String)"userAgent");
        h.b((Object)string5, (String)"locale");
        h.b((Object)string6, (String)"advertisingId");
        h.b((Object)string7, (String)"osId");
        h.b((Object)string8, (String)"osVer");
        h.b((Object)string9, (String)"deviceModel");
        h.b((Object)string10, (String)"deviceManufacturer");
        h.b((Object)string11, (String)"deviceVersion");
        h.b((Object)string12, (String)"packageName");
        h.b((Object)string13, (String)"networkOperName");
        h.b((Object)string14, (String)"isp");
        h.b((Object)string15, (String)"ispName");
        h.b((Object)string16, (String)"cellId");
        h.b((Object)string17, (String)"locationAreaCode");
        h.b((Object)string18, (String)"networkType");
        h.b((Object)string19, (String)"signalLevel");
        h.b((Object)string20, (String)"deviceType");
        h.b((Object)string21, (String)"sdkVersion");
        h.b((Object)string22, (String)"publisherId");
        this.latitude = string2;
        this.longitude = string3;
        this.userAgent = string4;
        this.locale = string5;
        this.advertisingId = string6;
        this.osId = string7;
        this.osVer = string8;
        this.deviceModel = string9;
        this.deviceManufacturer = string10;
        this.deviceVersion = string11;
        this.packageName = string12;
        this.networkOperName = string13;
        this.isp = string14;
        this.ispName = string15;
        this.cellId = string16;
        this.locationAreaCode = string17;
        this.networkType = string18;
        this.signalLevel = string19;
        this.deviceType = string20;
        this.sdkVersion = string21;
        this.publisherId = string22;
    }

    @NotNull
    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, String string17, String string18, String string19, String string20, String string21, String string22, int n2, Object object) {
        String string23;
        String string24;
        String string25;
        String string26;
        String string27;
        String string28;
        String string29;
        String string30;
        String string31;
        String string32;
        String string33 = (n2 & 1) != 0 ? deviceInfo.latitude : string2;
        String string34 = (n2 & 2) != 0 ? deviceInfo.longitude : string3;
        String string35 = (n2 & 4) != 0 ? deviceInfo.userAgent : string4;
        String string36 = (n2 & 8) != 0 ? deviceInfo.locale : string5;
        String string37 = (n2 & 16) != 0 ? deviceInfo.advertisingId : string6;
        String string38 = (n2 & 32) != 0 ? deviceInfo.osId : string7;
        String string39 = (n2 & 64) != 0 ? deviceInfo.osVer : string8;
        String string40 = (n2 & 128) != 0 ? deviceInfo.deviceModel : string9;
        String string41 = (n2 & 256) != 0 ? deviceInfo.deviceManufacturer : string10;
        String string42 = (n2 & 512) != 0 ? deviceInfo.deviceVersion : string11;
        String string43 = (n2 & 1024) != 0 ? deviceInfo.packageName : string12;
        String string44 = (n2 & 2048) != 0 ? deviceInfo.networkOperName : string13;
        String string45 = (n2 & 4096) != 0 ? deviceInfo.isp : string14;
        String string46 = (n2 & 8192) != 0 ? deviceInfo.ispName : string15;
        String string47 = string46;
        String string48 = (n2 & 16384) != 0 ? deviceInfo.cellId : string16;
        if ((n2 & 32768) != 0) {
            string23 = string48;
            string32 = deviceInfo.locationAreaCode;
        } else {
            string23 = string48;
            string32 = string17;
        }
        if ((n2 & 65536) != 0) {
            string27 = string32;
            string26 = deviceInfo.networkType;
        } else {
            string27 = string32;
            string26 = string18;
        }
        if ((n2 & 131072) != 0) {
            string30 = string26;
            string25 = deviceInfo.signalLevel;
        } else {
            string30 = string26;
            string25 = string19;
        }
        if ((n2 & 262144) != 0) {
            string31 = string25;
            string28 = deviceInfo.deviceType;
        } else {
            string31 = string25;
            string28 = string20;
        }
        if ((n2 & 524288) != 0) {
            string24 = string28;
            string29 = deviceInfo.sdkVersion;
        } else {
            string24 = string28;
            string29 = string21;
        }
        String string49 = (n2 & 1048576) != 0 ? deviceInfo.publisherId : string22;
        return deviceInfo.copy(string33, string34, string35, string36, string37, string38, string39, string40, string41, string42, string43, string44, string45, string47, string23, string27, string30, string31, string24, string29, string49);
    }

    @NotNull
    public final String component1() {
        return this.latitude;
    }

    @NotNull
    public final String component10() {
        return this.deviceVersion;
    }

    @NotNull
    public final String component11() {
        return this.packageName;
    }

    @NotNull
    public final String component12() {
        return this.networkOperName;
    }

    @NotNull
    public final String component13() {
        return this.isp;
    }

    @NotNull
    public final String component14() {
        return this.ispName;
    }

    @NotNull
    public final String component15() {
        return this.cellId;
    }

    @NotNull
    public final String component16() {
        return this.locationAreaCode;
    }

    @NotNull
    public final String component17() {
        return this.networkType;
    }

    @NotNull
    public final String component18() {
        return this.signalLevel;
    }

    @NotNull
    public final String component19() {
        return this.deviceType;
    }

    @NotNull
    public final String component2() {
        return this.longitude;
    }

    @NotNull
    public final String component20() {
        return this.sdkVersion;
    }

    @NotNull
    public final String component21() {
        return this.publisherId;
    }

    @NotNull
    public final String component3() {
        return this.userAgent;
    }

    @NotNull
    public final String component4() {
        return this.locale;
    }

    @NotNull
    public final String component5() {
        return this.advertisingId;
    }

    @NotNull
    public final String component6() {
        return this.osId;
    }

    @NotNull
    public final String component7() {
        return this.osVer;
    }

    @NotNull
    public final String component8() {
        return this.deviceModel;
    }

    @NotNull
    public final String component9() {
        return this.deviceManufacturer;
    }

    @NotNull
    public final DeviceInfo copy(@NotNull String string2, @NotNull String string3, @NotNull String string4, @NotNull String string5, @NotNull String string6, @NotNull String string7, @NotNull String string8, @NotNull String string9, @NotNull String string10, @NotNull String string11, @NotNull String string12, @NotNull String string13, @NotNull String string14, @NotNull String string15, @NotNull String string16, @NotNull String string17, @NotNull String string18, @NotNull String string19, @NotNull String string20, @NotNull String string21, @NotNull String string22) {
        h.b((Object)string2, (String)"latitude");
        h.b((Object)string3, (String)"longitude");
        h.b((Object)string4, (String)"userAgent");
        h.b((Object)string5, (String)"locale");
        h.b((Object)string6, (String)"advertisingId");
        h.b((Object)string7, (String)"osId");
        h.b((Object)string8, (String)"osVer");
        h.b((Object)string9, (String)"deviceModel");
        h.b((Object)string10, (String)"deviceManufacturer");
        h.b((Object)string11, (String)"deviceVersion");
        h.b((Object)string12, (String)"packageName");
        h.b((Object)string13, (String)"networkOperName");
        h.b((Object)string14, (String)"isp");
        h.b((Object)string15, (String)"ispName");
        h.b((Object)string16, (String)"cellId");
        h.b((Object)string17, (String)"locationAreaCode");
        h.b((Object)string18, (String)"networkType");
        h.b((Object)string19, (String)"signalLevel");
        h.b((Object)string20, (String)"deviceType");
        h.b((Object)string21, (String)"sdkVersion");
        h.b((Object)string22, (String)"publisherId");
        DeviceInfo deviceInfo = new DeviceInfo(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22);
        return deviceInfo;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof DeviceInfo)) break block3;
                DeviceInfo deviceInfo = (DeviceInfo)object;
                if (h.a((Object)this.latitude, (Object)deviceInfo.latitude) && h.a((Object)this.longitude, (Object)deviceInfo.longitude) && h.a((Object)this.userAgent, (Object)deviceInfo.userAgent) && h.a((Object)this.locale, (Object)deviceInfo.locale) && h.a((Object)this.advertisingId, (Object)deviceInfo.advertisingId) && h.a((Object)this.osId, (Object)deviceInfo.osId) && h.a((Object)this.osVer, (Object)deviceInfo.osVer) && h.a((Object)this.deviceModel, (Object)deviceInfo.deviceModel) && h.a((Object)this.deviceManufacturer, (Object)deviceInfo.deviceManufacturer) && h.a((Object)this.deviceVersion, (Object)deviceInfo.deviceVersion) && h.a((Object)this.packageName, (Object)deviceInfo.packageName) && h.a((Object)this.networkOperName, (Object)deviceInfo.networkOperName) && h.a((Object)this.isp, (Object)deviceInfo.isp) && h.a((Object)this.ispName, (Object)deviceInfo.ispName) && h.a((Object)this.cellId, (Object)deviceInfo.cellId) && h.a((Object)this.locationAreaCode, (Object)deviceInfo.locationAreaCode) && h.a((Object)this.networkType, (Object)deviceInfo.networkType) && h.a((Object)this.signalLevel, (Object)deviceInfo.signalLevel) && h.a((Object)this.deviceType, (Object)deviceInfo.deviceType) && h.a((Object)this.sdkVersion, (Object)deviceInfo.sdkVersion) && h.a((Object)this.publisherId, (Object)deviceInfo.publisherId)) break block2;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getAdvertisingId() {
        return this.advertisingId;
    }

    @NotNull
    public final String getCellId() {
        return this.cellId;
    }

    @NotNull
    public final String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    @NotNull
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    @NotNull
    public final String getDeviceVersion() {
        return this.deviceVersion;
    }

    @NotNull
    public final String getIsp() {
        return this.isp;
    }

    @NotNull
    public final String getIspName() {
        return this.ispName;
    }

    @NotNull
    public final String getLatitude() {
        return this.latitude;
    }

    @NotNull
    public final String getLocale() {
        return this.locale;
    }

    @NotNull
    public final String getLocationAreaCode() {
        return this.locationAreaCode;
    }

    @NotNull
    public final String getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getNetworkOperName() {
        return this.networkOperName;
    }

    @NotNull
    public final String getNetworkType() {
        return this.networkType;
    }

    @NotNull
    public final String getOsId() {
        return this.osId;
    }

    @NotNull
    public final String getOsVer() {
        return this.osVer;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getPublisherId() {
        return this.publisherId;
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @NotNull
    public final String getSignalLevel() {
        return this.signalLevel;
    }

    @NotNull
    public final String getUserAgent() {
        return this.userAgent;
    }

    public int hashCode() {
        String string2 = this.latitude;
        int n2 = string2 != null ? string2.hashCode() : 0;
        int n3 = n2 * 31;
        String string3 = this.longitude;
        int n4 = string3 != null ? string3.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        String string4 = this.userAgent;
        int n6 = string4 != null ? string4.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        String string5 = this.locale;
        int n8 = string5 != null ? string5.hashCode() : 0;
        int n9 = 31 * (n7 + n8);
        String string6 = this.advertisingId;
        int n10 = string6 != null ? string6.hashCode() : 0;
        int n11 = 31 * (n9 + n10);
        String string7 = this.osId;
        int n12 = string7 != null ? string7.hashCode() : 0;
        int n13 = 31 * (n11 + n12);
        String string8 = this.osVer;
        int n14 = string8 != null ? string8.hashCode() : 0;
        int n15 = 31 * (n13 + n14);
        String string9 = this.deviceModel;
        int n16 = string9 != null ? string9.hashCode() : 0;
        int n17 = 31 * (n15 + n16);
        String string10 = this.deviceManufacturer;
        int n18 = string10 != null ? string10.hashCode() : 0;
        int n19 = 31 * (n17 + n18);
        String string11 = this.deviceVersion;
        int n20 = string11 != null ? string11.hashCode() : 0;
        int n21 = 31 * (n19 + n20);
        String string12 = this.packageName;
        int n22 = string12 != null ? string12.hashCode() : 0;
        int n23 = 31 * (n21 + n22);
        String string13 = this.networkOperName;
        int n24 = string13 != null ? string13.hashCode() : 0;
        int n25 = 31 * (n23 + n24);
        String string14 = this.isp;
        int n26 = string14 != null ? string14.hashCode() : 0;
        int n27 = 31 * (n25 + n26);
        String string15 = this.ispName;
        int n28 = string15 != null ? string15.hashCode() : 0;
        int n29 = 31 * (n27 + n28);
        String string16 = this.cellId;
        int n30 = string16 != null ? string16.hashCode() : 0;
        int n31 = 31 * (n29 + n30);
        String string17 = this.locationAreaCode;
        int n32 = string17 != null ? string17.hashCode() : 0;
        int n33 = 31 * (n31 + n32);
        String string18 = this.networkType;
        int n34 = string18 != null ? string18.hashCode() : 0;
        int n35 = 31 * (n33 + n34);
        String string19 = this.signalLevel;
        int n36 = string19 != null ? string19.hashCode() : 0;
        int n37 = 31 * (n35 + n36);
        String string20 = this.deviceType;
        int n38 = string20 != null ? string20.hashCode() : 0;
        int n39 = 31 * (n37 + n38);
        String string21 = this.sdkVersion;
        int n40 = string21 != null ? string21.hashCode() : 0;
        int n41 = 31 * (n39 + n40);
        String string22 = this.publisherId;
        int n42 = 0;
        if (string22 != null) {
            n42 = string22.hashCode();
        }
        return n41 + n42;
    }

    public final void setPublisherId(@NotNull String string2) {
        h.b((Object)string2, (String)"<set-?>");
        this.publisherId = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceInfo(latitude=");
        stringBuilder.append(this.latitude);
        stringBuilder.append(", longitude=");
        stringBuilder.append(this.longitude);
        stringBuilder.append(", userAgent=");
        stringBuilder.append(this.userAgent);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", advertisingId=");
        stringBuilder.append(this.advertisingId);
        stringBuilder.append(", osId=");
        stringBuilder.append(this.osId);
        stringBuilder.append(", osVer=");
        stringBuilder.append(this.osVer);
        stringBuilder.append(", deviceModel=");
        stringBuilder.append(this.deviceModel);
        stringBuilder.append(", deviceManufacturer=");
        stringBuilder.append(this.deviceManufacturer);
        stringBuilder.append(", deviceVersion=");
        stringBuilder.append(this.deviceVersion);
        stringBuilder.append(", packageName=");
        stringBuilder.append(this.packageName);
        stringBuilder.append(", networkOperName=");
        stringBuilder.append(this.networkOperName);
        stringBuilder.append(", isp=");
        stringBuilder.append(this.isp);
        stringBuilder.append(", ispName=");
        stringBuilder.append(this.ispName);
        stringBuilder.append(", cellId=");
        stringBuilder.append(this.cellId);
        stringBuilder.append(", locationAreaCode=");
        stringBuilder.append(this.locationAreaCode);
        stringBuilder.append(", networkType=");
        stringBuilder.append(this.networkType);
        stringBuilder.append(", signalLevel=");
        stringBuilder.append(this.signalLevel);
        stringBuilder.append(", deviceType=");
        stringBuilder.append(this.deviceType);
        stringBuilder.append(", sdkVersion=");
        stringBuilder.append(this.sdkVersion);
        stringBuilder.append(", publisherId=");
        stringBuilder.append(this.publisherId);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

