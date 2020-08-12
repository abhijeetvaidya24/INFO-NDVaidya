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
 *  java.util.FormatterClosedException
 *  java.util.IllegalFormatException
 */
package io.presage.core;

import io.presage.core.lIIIIlIl;
import io.presage.core.lIIIlIlI;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;

public final class lIIIIllI {
    private static final String IIIIIIII = lIIIlIlI.IIIlIlIl.IIIIIIII;

    public static String IIIIIIII(String string) {
        return lIIIIllI.IIIIIIII(string, IIIIIIII);
    }

    public static String IIIIIIII(String string, String string2) {
        void var2_6;
        if (string == null) {
            return string;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)string2);
            messageDigest.reset();
            messageDigest.update(string.getBytes("UTF-8"));
            String string3 = lIIIIllI.IIIIIIII(messageDigest.digest());
            return string3;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        throw new lIIIIlIl((Throwable)var2_6);
    }

    private static String IIIIIIII(byte[] arrby) {
        lIIIIlIl lIIIIlIl2;
        void var2_9;
        if (arrby == null) {
            return null;
        }
        Formatter formatter = new Formatter();
        int n2 = arrby.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = arrby[i2];
            Object[] arrobject = new Object[]{by};
            formatter.format("%02x", arrobject);
        }
        try {
            String string = formatter.toString();
            formatter.close();
            return string;
        }
        catch (FormatterClosedException formatterClosedException) {
        }
        catch (IllegalFormatException illegalFormatException) {
            // empty catch block
        }
        lIIIIlIl2 = new lIIIIlIl((Throwable)var2_9);
        throw lIIIIlIl2;
    }
}

