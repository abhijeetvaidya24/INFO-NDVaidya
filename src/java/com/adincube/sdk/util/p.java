/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Formatter
 */
package com.adincube.sdk.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public final class p {
    public static String a(String string, String string2) {
        if (string2 == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)string);
            messageDigest.reset();
            messageDigest.update(string2.getBytes("UTF-8"));
            String string3 = p.a(messageDigest.digest());
            return string3;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
        return "";
    }

    private static String a(byte[] arrby) {
        String string;
        Formatter formatter = new Formatter();
        int n2 = arrby.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = arrby[i2];
            Object[] arrobject = new Object[]{by};
            formatter.format("%02x", arrobject);
        }
        try {
            string = formatter.toString();
        }
        catch (Throwable throwable) {
            formatter.close();
            throw throwable;
        }
        formatter.close();
        return string;
    }
}

