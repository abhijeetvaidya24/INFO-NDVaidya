/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 */
package com.tappx.a.a.a.j;

import java.security.MessageDigest;

public abstract class d {
    public static String a(String string2) {
        try {
            String string3 = d.a(MessageDigest.getInstance((String)"MD5").digest(string2.getBytes()));
            return string3;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] arrby) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            String string2 = Integer.toHexString((int)(255 & arrby[i2]));
            if (string2.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }
}

