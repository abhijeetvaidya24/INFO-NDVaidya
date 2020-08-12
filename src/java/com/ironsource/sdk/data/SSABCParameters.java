/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.ironsource.sdk.data;

import com.ironsource.sdk.data.SSAObj;

public class SSABCParameters
extends SSAObj {
    private String CONNECTION_RETRIES = "connectionRetries";
    private String mConnectionRetries;

    public SSABCParameters() {
    }

    public SSABCParameters(String string) {
        super(string);
        if (this.containsKey(this.CONNECTION_RETRIES)) {
            this.setConnectionRetries(this.getString(this.CONNECTION_RETRIES));
        }
    }

    public String getConnectionRetries() {
        return this.mConnectionRetries;
    }

    public void setConnectionRetries(String string) {
        this.mConnectionRetries = string;
    }
}

