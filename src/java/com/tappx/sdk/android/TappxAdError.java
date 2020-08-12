/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.sdk.android;

public final class TappxAdError
extends Enum<TappxAdError> {
    public static final /* enum */ TappxAdError DEVELOPER_ERROR;
    public static final /* enum */ TappxAdError INTERNAL_ERROR;
    public static final /* enum */ TappxAdError NETWORK_ERROR;
    public static final /* enum */ TappxAdError NO_FILL;
    public static final /* enum */ TappxAdError SERVER_ERROR;
    public static final /* enum */ TappxAdError UNSPECIFIED;
    private static final /* synthetic */ TappxAdError[] a;

    static {
        NO_FILL = new TappxAdError();
        SERVER_ERROR = new TappxAdError();
        DEVELOPER_ERROR = new TappxAdError();
        INTERNAL_ERROR = new TappxAdError();
        NETWORK_ERROR = new TappxAdError();
        UNSPECIFIED = new TappxAdError();
        TappxAdError[] arrtappxAdError = new TappxAdError[]{NO_FILL, SERVER_ERROR, DEVELOPER_ERROR, INTERNAL_ERROR, NETWORK_ERROR, UNSPECIFIED};
        a = arrtappxAdError;
    }

    public static TappxAdError valueOf(String string2) {
        return (TappxAdError)Enum.valueOf(TappxAdError.class, (String)string2);
    }

    public static TappxAdError[] values() {
        return (TappxAdError[])a.clone();
    }
}

