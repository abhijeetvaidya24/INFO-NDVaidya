/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.aerserv.sdk.model.vast;

import com.aerserv.sdk.model.vast.AdResource;

public final class HTMLAdResource
extends AdResource {
    public static final String ELEMENT_NAME = "HTMLResource";
    private static final long serialVersionUID = 7359599195165470144L;
    private String html;

    public String getHtml() {
        return this.html;
    }

    public void setHtml(String string) {
        this.html = string;
    }
}

