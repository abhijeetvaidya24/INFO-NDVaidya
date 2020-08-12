/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.String
 */
package com.ogury.consent.manager.util.consent;

import com.ogury.consent.manager.tx6480;

public final class ConsentException
extends Exception {
    private String type;

    public ConsentException(String string2, String string3) {
        tx6480.b(string2, "type");
        tx6480.b(string3, "message");
        super(string3);
        this.type = string2;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String string2) {
        tx6480.b(string2, "<set-?>");
        this.type = string2;
    }
}

