/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.adincube.sdk.d.c;

import java.util.Locale;

public final class a
extends Exception {
    public a(int n2) {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{n2};
        super(String.format((Locale)locale, (String)"%d", (Object[])arrobject));
    }
}

