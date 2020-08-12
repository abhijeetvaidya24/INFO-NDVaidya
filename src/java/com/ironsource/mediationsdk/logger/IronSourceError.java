/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.mediationsdk.logger;

public class IronSourceError {
    private int mErrorCode;
    private String mErrorMsg;

    public IronSourceError(int n2, String string) {
        this.mErrorCode = n2;
        if (string == null) {
            string = "";
        }
        this.mErrorMsg = string;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMsg;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.mErrorCode);
        stringBuilder.append(", errorMessage:");
        stringBuilder.append(this.mErrorMsg);
        return stringBuilder.toString();
    }
}

