/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URL
 *  java.net.URLConnection
 */
package com.tapjoy.internal;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public final class em {
    private static em a = new em();

    public static InputStream a(String string2) {
        URLConnection uRLConnection = new URL(string2).openConnection();
        uRLConnection.connect();
        return uRLConnection.getInputStream();
    }

    public static URLConnection a(URL uRL) {
        return uRL.openConnection();
    }
}

