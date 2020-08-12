/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package co.ogury.crashreport;

import co.ogury.crashreport.tx8640;

public final class CrashConfig {
    private final String packageName;
    private final String url;

    public CrashConfig(String string, String string2) {
        tx8640.b(string, "url");
        tx8640.b(string2, "packageName");
        this.url = string;
        this.packageName = string2;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getUrl() {
        return this.url;
    }
}

