/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.adview;

public final class AppLovinAdViewDisplayErrorCode
extends Enum<AppLovinAdViewDisplayErrorCode> {
    public static final /* enum */ AppLovinAdViewDisplayErrorCode UNSPECIFIED = new AppLovinAdViewDisplayErrorCode();
    private static final /* synthetic */ AppLovinAdViewDisplayErrorCode[] a;

    static {
        AppLovinAdViewDisplayErrorCode[] arrappLovinAdViewDisplayErrorCode = new AppLovinAdViewDisplayErrorCode[]{UNSPECIFIED};
        a = arrappLovinAdViewDisplayErrorCode;
    }

    public static AppLovinAdViewDisplayErrorCode valueOf(String string) {
        return (AppLovinAdViewDisplayErrorCode)Enum.valueOf(AppLovinAdViewDisplayErrorCode.class, (String)string);
    }

    public static AppLovinAdViewDisplayErrorCode[] values() {
        return (AppLovinAdViewDisplayErrorCode[])a.clone();
    }
}

