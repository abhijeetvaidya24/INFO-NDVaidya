/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk;

public final class AerServAdType
extends Enum<AerServAdType> {
    private static final /* synthetic */ AerServAdType[] $VALUES;
    public static final /* enum */ AerServAdType BANNER = new AerServAdType();
    public static final /* enum */ AerServAdType INTERSTITIAL = new AerServAdType();

    static {
        AerServAdType[] arraerServAdType = new AerServAdType[]{BANNER, INTERSTITIAL};
        $VALUES = arraerServAdType;
    }

    public static AerServAdType valueOf(String string) {
        return (AerServAdType)Enum.valueOf(AerServAdType.class, (String)string);
    }

    public static AerServAdType[] values() {
        return (AerServAdType[])$VALUES.clone();
    }
}

