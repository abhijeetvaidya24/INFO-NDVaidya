/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.adcolony.sdk;

import com.adcolony.sdk.au;

public class AdColonyCustomMessage {
    String a;
    String b;

    public AdColonyCustomMessage(String string, String string2) {
        if (au.d(string) || au.d(string2)) {
            this.a = string;
            this.b = string2;
        }
    }

    public String getMessage() {
        return this.b;
    }
}

