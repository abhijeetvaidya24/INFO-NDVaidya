/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.amazon.device.ads;

class Version {
    private static String buildVersion = "5.8.2-dev";
    private static String devBuild = "(DEV)";
    private static String prefixVersion = "amznAdSDK-android-";
    private static String sdkVersion;
    private static String userAgentPrefixVersion = "AmazonAdSDK-Android/";
    private static String userAgentSDKVersion;

    Version() {
    }

    public static String getRawSDKVersion() {
        String string = buildVersion;
        if (string != null && !string.equals((Object)"")) {
            if (string.endsWith("x")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(devBuild);
                return stringBuilder.toString();
            }
        } else {
            string = devBuild;
        }
        return string;
    }

    public static String getSDKVersion() {
        if (sdkVersion == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(prefixVersion);
            stringBuilder.append(Version.getRawSDKVersion());
            sdkVersion = stringBuilder.toString();
        }
        return sdkVersion;
    }

    public static String getUserAgentSDKVersion() {
        if (userAgentSDKVersion == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(userAgentPrefixVersion);
            stringBuilder.append(Version.getRawSDKVersion());
            userAgentSDKVersion = stringBuilder.toString();
        }
        return userAgentSDKVersion;
    }

    static void setSDKVersion(String string) {
        sdkVersion = string;
    }
}

