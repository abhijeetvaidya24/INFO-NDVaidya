/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session.internal;

public final class SessionType
extends Enum<SessionType> {
    private static final /* synthetic */ SessionType[] $VALUES;
    public static final /* enum */ SessionType DISPLAY = new SessionType("display");
    public static final /* enum */ SessionType MANAGED_DISPLAY;
    public static final /* enum */ SessionType MANAGED_VIDEO;
    public static final /* enum */ SessionType VIDEO;
    private final String value;

    static {
        VIDEO = new SessionType("video");
        MANAGED_DISPLAY = new SessionType("managedDisplay");
        MANAGED_VIDEO = new SessionType("managedVideo");
        SessionType[] arrsessionType = new SessionType[]{DISPLAY, VIDEO, MANAGED_DISPLAY, MANAGED_VIDEO};
        $VALUES = arrsessionType;
    }

    private SessionType(String string2) {
        this.value = string2;
    }

    public static SessionType valueOf(String string) {
        return (SessionType)Enum.valueOf(SessionType.class, (String)string);
    }

    public static SessionType[] values() {
        return (SessionType[])$VALUES.clone();
    }

    public String toString() {
        return this.value;
    }
}

