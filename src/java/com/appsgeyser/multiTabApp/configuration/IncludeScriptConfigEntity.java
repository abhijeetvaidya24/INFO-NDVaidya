/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.configuration;

import java.io.Serializable;

public class IncludeScriptConfigEntity
implements Serializable {
    private final String file;
    private final String pattern;
    private final String regex;

    public IncludeScriptConfigEntity(String string2, String string3, String string4) {
        this.file = string4;
        this.pattern = string2;
        this.regex = string3;
    }

    public String getFile() {
        return this.file;
    }

    public String getPattern() {
        return this.pattern;
    }

    public String getRegex() {
        return this.regex;
    }
}

