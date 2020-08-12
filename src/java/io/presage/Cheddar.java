/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  co.ogury.crashreport.CrashReport
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Arrays
 */
package io.presage;

import co.ogury.crashreport.CrashReport;
import io.presage.cl;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class Cheddar {
    public static final Cheddar a = new Cheddar();

    private Cheddar() {
    }

    public static String a(String string2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
            cl.a((Object)messageDigest, "MessageDigest.getInstance(\"MD5\")");
            Charset charset = Charset.forName((String)"US-ASCII");
            cl.a((Object)charset, "Charset.forName(\"US-ASCII\")");
            byte[] arrby = string2.getBytes(charset);
            cl.a((Object)arrby, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(arrby, 0, string2.length());
            byte[] arrby2 = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, arrby2);
            StringBuilder stringBuilder = new StringBuilder("%0");
            stringBuilder.append(arrby2.length << 1);
            stringBuilder.append("x");
            String string3 = String.format((String)stringBuilder.toString(), (Object[])Arrays.copyOf((Object[])new Object[]{bigInteger}, (int)1));
            cl.a((Object)string3, "java.lang.String.format(format, *args)");
            return string3;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            CrashReport.logException((Exception)((Exception)((Object)noSuchAlgorithmException)));
            return "";
        }
    }
}

