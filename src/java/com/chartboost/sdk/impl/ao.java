/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.ad;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ao {
    HttpURLConnection a(ad<?> ad2) throws IOException {
        return (HttpURLConnection)new URL(ad2.c).openConnection();
    }
}

