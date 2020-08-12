/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 *  java.util.Random
 *  java.util.zip.GZIPInputStream
 */
package com.adincube.sdk.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Random;
import java.util.zip.GZIPInputStream;

public final class q {
    public static int a(int n2, boolean bl) {
        if (bl) {
            switch (n2) {
                default: {
                    return 3600000 + new Random().nextInt(3600000);
                }
                case 7: {
                    return 900000 + new Random().nextInt(900000);
                }
                case 6: {
                    return 60000 + new Random().nextInt(60000);
                }
                case 5: {
                    return 30000 + new Random().nextInt(30000);
                }
                case 4: {
                    return 10000 + new Random().nextInt(10000);
                }
                case 3: {
                    return 5000 + new Random().nextInt(5000);
                }
                case 2: {
                    return 2000 + new Random().nextInt(2000);
                }
                case 1: 
            }
            return 2000 + new Random().nextInt(2000);
        }
        switch (n2) {
            default: {
                return 3600000;
            }
            case 6: {
                return 900000;
            }
            case 5: {
                return 60000;
            }
            case 4: {
                return 30000;
            }
            case 3: {
                return 7000;
            }
            case 2: {
                return 3000;
            }
            case 1: 
        }
        return 1000;
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getResponseCode() >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        if ("gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }
}

