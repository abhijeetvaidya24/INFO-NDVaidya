/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk;

public final class RequestType
extends Enum<RequestType> {
    private static final /* synthetic */ RequestType[] $VALUES;
    public static final /* enum */ RequestType BANNER_REFRESH;
    public static final /* enum */ RequestType LOAD_AND_SHOW;
    public static final /* enum */ RequestType PRELOAD;
    public static final /* enum */ RequestType SHOW;

    static {
        LOAD_AND_SHOW = new RequestType();
        PRELOAD = new RequestType();
        SHOW = new RequestType();
        BANNER_REFRESH = new RequestType();
        RequestType[] arrrequestType = new RequestType[]{LOAD_AND_SHOW, PRELOAD, SHOW, BANNER_REFRESH};
        $VALUES = arrrequestType;
    }

    public static RequestType valueOf(String string) {
        return (RequestType)Enum.valueOf(RequestType.class, (String)string);
    }

    public static RequestType[] values() {
        return (RequestType[])$VALUES.clone();
    }
}

