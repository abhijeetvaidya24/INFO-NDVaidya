/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package co.ogury.crashreport;

import co.ogury.crashreport.tx8640;

public final class SdkInfo {
    private final String aaid;
    private final String apiKey;
    private final String sdkVersion;

    public SdkInfo(String string, String string2, String string3) {
        tx8640.b(string, "sdkVersion");
        tx8640.b(string2, "apiKey");
        tx8640.b(string3, "aaid");
        this.sdkVersion = string;
        this.apiKey = string2;
        this.aaid = string3;
    }

    public final String getAaid() {
        return this.aaid;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }
}

