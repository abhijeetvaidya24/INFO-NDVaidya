/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session.internal;

public final class MediaType
extends Enum<MediaType> {
    public static final /* enum */ MediaType DISPLAY = new MediaType("display");
    public static final /* enum */ MediaType VIDEO = new MediaType("video");
    private static final /* synthetic */ MediaType[] b;
    private final String a;

    static {
        MediaType[] arrmediaType = new MediaType[]{DISPLAY, VIDEO};
        b = arrmediaType;
    }

    private MediaType(String string2) {
        this.a = string2;
    }

    public static MediaType valueOf(String string) {
        return (MediaType)Enum.valueOf(MediaType.class, (String)string);
    }

    public static MediaType[] values() {
        return (MediaType[])b.clone();
    }

    public String toString() {
        return this.a;
    }
}

