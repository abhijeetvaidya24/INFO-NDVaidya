/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.omsdk;

import java.io.Serializable;

public class VerificationDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String javascriptResourceUrl;
    private String vendorKey;
    private String verificationParameters;

    public VerificationDetails() {
    }

    public VerificationDetails(String string, String string2, String string3) {
        this.vendorKey = string;
        this.javascriptResourceUrl = string2;
        this.verificationParameters = string3;
    }

    public String getVendorKey() {
        return this.vendorKey;
    }

    public String getVerificationParameters() {
        return this.verificationParameters;
    }

    public String getVerificationScriptUrl() {
        return this.javascriptResourceUrl;
    }
}

