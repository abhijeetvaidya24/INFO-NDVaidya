/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
package com.adcolony.sdk;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class az {
    public static String a(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-1");
        messageDigest.update(string.getBytes("iso-8859-1"), 0, string.length());
        return az.a(messageDigest.digest());
    }

    private static String a(byte[] arrby) {
        StringBuilder stringBuilder = new StringBuilder();
        block0 : for (byte by2 : arrby) {
            int n2 = 15 & by2 >>> 4;
            int n3 = 0;
            do {
                int n4 = n2 >= 0 && n2 <= 9 ? n2 + 48 : 97 + (n2 - 10);
                stringBuilder.append((char)n4);
                n2 = by2 & 15;
                int n5 = n3 + 1;
                if (n3 >= 1) {
                    continue block0;
                }
                n3 = n5;
            } while (true);
        }
        return stringBuilder.toString();
    }
}

