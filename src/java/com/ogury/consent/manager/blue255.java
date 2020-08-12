/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.expandedcolortbl;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.rtf1;

public final class blue255 {
    private String a;
    private String b;
    private String c;
    private rtf1 d;

    public blue255(expandedcolortbl expandedcolortbl2) {
        tx6480.b(expandedcolortbl2, "builder");
        this.a = "";
        this.b = "";
        this.c = "";
        this.a = expandedcolortbl2.a();
        this.b = expandedcolortbl2.b();
        this.c = expandedcolortbl2.c();
        this.d = expandedcolortbl2.d();
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final rtf1 d() {
        return this.d;
    }
}

