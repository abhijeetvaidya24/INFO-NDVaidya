/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.mediationsdk.config;

import com.ironsource.mediationsdk.logger.IronSourceError;

public class ConfigValidationResult {
    private IronSourceError mIronSourceError = null;
    private boolean mIsValid = true;

    public IronSourceError getIronSourceError() {
        return this.mIronSourceError;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void setInvalid(IronSourceError ironSourceError) {
        this.mIsValid = false;
        this.mIronSourceError = ironSourceError;
    }

    public String toString() {
        if (this.isValid()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("valid:");
            stringBuilder.append(this.mIsValid);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("valid:");
        stringBuilder.append(this.mIsValid);
        stringBuilder.append(", IronSourceError:");
        stringBuilder.append((Object)this.mIronSourceError);
        return stringBuilder.toString();
    }
}

