/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.rtf1;

public final class expandedcolortbl {
    private String a = "";
    private String b = "";
    private String c = "";
    private rtf1 d;

    public final expandedcolortbl a(rtf1 rtf12) {
        this.d = rtf12;
        return this;
    }

    public final expandedcolortbl a(String string2) {
        tx6480.b(string2, "requestMethod");
        this.a = string2;
        return this;
    }

    public final String a() {
        return this.a;
    }

    public final expandedcolortbl b(String string2) {
        tx6480.b(string2, "requestBody");
        this.b = string2;
        return this;
    }

    public final String b() {
        return this.b;
    }

    public final expandedcolortbl c(String string2) {
        tx6480.b(string2, "url");
        this.c = string2;
        return this;
    }

    public final String c() {
        return this.c;
    }

    public final rtf1 d() {
        return this.d;
    }
}

