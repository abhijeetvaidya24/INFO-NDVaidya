/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session.internal;

public final class MediaType
extends Enum<MediaType> {
    private static final /* synthetic */ MediaType[] $VALUES;
    public static final /* enum */ MediaType DISPLAY = new MediaType("display");
    public static final /* enum */ MediaType VIDEO = new MediaType("video");
    private final String value;

    static {
        MediaType[] arrmediaType = new MediaType[]{DISPLAY, VIDEO};
        $VALUES = arrmediaType;
    }

    private MediaType(String string2) {
        this.value = string2;
    }

    public static MediaType valueOf(String string) {
        return (MediaType)Enum.valueOf(MediaType.class, (String)string);
    }

    public static MediaType[] values() {
        return (MediaType[])$VALUES.clone();
    }

    public String toString() {
        return this.value;
    }
}

