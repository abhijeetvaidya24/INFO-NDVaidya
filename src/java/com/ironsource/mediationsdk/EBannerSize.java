/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.mediationsdk;

public final class EBannerSize
extends Enum<EBannerSize> {
    private static final /* synthetic */ EBannerSize[] $VALUES;
    public static final /* enum */ EBannerSize BANNER = new EBannerSize("banner");
    public static final /* enum */ EBannerSize LARGE = new EBannerSize("large");
    public static final /* enum */ EBannerSize RECTANGLE = new EBannerSize("rectangle");
    public static final /* enum */ EBannerSize SMART;
    @Deprecated
    public static final /* enum */ EBannerSize TABLET;
    private String mValue;

    static {
        TABLET = new EBannerSize("tablet");
        SMART = new EBannerSize("smart");
        EBannerSize[] arreBannerSize = new EBannerSize[]{BANNER, LARGE, RECTANGLE, TABLET, SMART};
        $VALUES = arreBannerSize;
    }

    private EBannerSize(String string2) {
        this.mValue = string2;
    }

    public static EBannerSize valueOf(String string) {
        return (EBannerSize)Enum.valueOf(EBannerSize.class, (String)string);
    }

    public static EBannerSize[] values() {
        return (EBannerSize[])$VALUES.clone();
    }

    public int getValue() {
        return 1 + this.ordinal();
    }

    public String toString() {
        return this.mValue;
    }
}

