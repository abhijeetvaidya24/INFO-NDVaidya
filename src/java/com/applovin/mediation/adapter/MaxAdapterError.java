/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.mediation.adapter;

public class MaxAdapterError {
    public static final MaxAdapterError AD_NOT_READY;
    public static final MaxAdapterError BAD_REQUEST;
    public static final int ERROR_CODE_AD_NOT_READY = -5205;
    public static final int ERROR_CODE_BAD_REQUEST = -5203;
    public static final int ERROR_CODE_INTERNAL_ERROR = -5209;
    public static final int ERROR_CODE_INVALID_CONFIGURATION = -5202;
    public static final int ERROR_CODE_INVALID_LOAD_STATE = -5201;
    public static final int ERROR_CODE_NOT_INITIALIZED = -5204;
    public static final int ERROR_CODE_NO_CONNECTION = -5207;
    public static final int ERROR_CODE_NO_FILL = 204;
    public static final int ERROR_CODE_REWARD_ERROR = -5302;
    public static final int ERROR_CODE_SERVER_ERROR = -5208;
    public static final int ERROR_CODE_SIGNAL_COLLECTION_NOT_SUPPORTED = -5211;
    public static final int ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT = -5210;
    public static final int ERROR_CODE_TIMEOUT = -5206;
    public static final int ERROR_CODE_UNSPECIFIED = -5200;
    public static final int ERROR_CODE_WEBVIEW_ERROR = -5212;
    public static final MaxAdapterError INTERNAL_ERROR;
    public static final MaxAdapterError NOT_INITIALIZED;
    public static final MaxAdapterError NO_FILL;
    public static final MaxAdapterError REWARD_ERROR;
    public static final MaxAdapterError UNSPECIFIED;
    private final String adapterError;
    private final int errorCode;

    static {
        NO_FILL = new MaxAdapterError(204);
        UNSPECIFIED = new MaxAdapterError(-5200);
        BAD_REQUEST = new MaxAdapterError(-5203);
        NOT_INITIALIZED = new MaxAdapterError(-5204);
        AD_NOT_READY = new MaxAdapterError(-5205);
        INTERNAL_ERROR = new MaxAdapterError(-5209);
        REWARD_ERROR = new MaxAdapterError(-5302);
    }

    public MaxAdapterError(int n2) {
        this(n2, "0");
    }

    public MaxAdapterError(int n2, int n3) {
        this(n2, Integer.toString((int)n3));
    }

    public MaxAdapterError(int n2, String string2) {
        this.errorCode = n2;
        this.adapterError = string2;
    }

    public String getAdapterError() {
        return this.adapterError;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MaxAdapterError{errorCode=");
        stringBuilder.append(this.errorCode);
        stringBuilder.append(", adapterError='");
        stringBuilder.append(this.adapterError);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

