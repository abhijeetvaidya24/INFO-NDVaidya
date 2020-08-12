/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.model.ad;

public final class AdType
extends Enum<AdType> {
    private static final /* synthetic */ AdType[] $VALUES;
    public static final /* enum */ AdType EXPANDED_MRAID;
    public static final /* enum */ AdType HTML;
    public static final /* enum */ AdType MRAID;
    public static final /* enum */ AdType THIRD_PARTY;
    public static final /* enum */ AdType VAST;
    public static final /* enum */ AdType VIDEO;
    public static final /* enum */ AdType VIDEO_WITH_END_CARD;

    static {
        HTML = new AdType();
        VAST = new AdType();
        THIRD_PARTY = new AdType();
        MRAID = new AdType();
        EXPANDED_MRAID = new AdType();
        VIDEO = new AdType();
        VIDEO_WITH_END_CARD = new AdType();
        AdType[] arradType = new AdType[]{HTML, VAST, THIRD_PARTY, MRAID, EXPANDED_MRAID, VIDEO, VIDEO_WITH_END_CARD};
        $VALUES = arradType;
    }

    public static AdType valueOf(String string) {
        return (AdType)Enum.valueOf(AdType.class, (String)string);
    }

    public static AdType[] values() {
        return (AdType[])$VALUES.clone();
    }
}

