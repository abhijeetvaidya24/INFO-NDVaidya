/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  com.adincube.sdk.h.b.b
 *  java.io.ByteArrayOutputStream
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Key
 *  java.security.spec.AlgorithmParameterSpec
 *  java.util.zip.GZIPOutputStream
 *  javax.crypto.Cipher
 *  javax.crypto.spec.IvParameterSpec
 *  javax.crypto.spec.SecretKeySpec
 */
package com.adincube.sdk.util;

import android.annotation.SuppressLint;
import com.adincube.sdk.h.b.b;
import com.adincube.sdk.util.a;
import com.adincube.sdk.util.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class g {
    public static String a(b b2, String string) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream((OutputStream)byteArrayOutputStream);
            gZIPOutputStream.write(string.getBytes("UTF-8"));
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            String string2 = g.a(b2, byteArrayOutputStream.toByteArray());
            return string2;
        }
        catch (Exception exception) {
            a.c("DataEncryptionHelper.gzipAndEncode()", new Object[]{exception});
            return null;
        }
    }

    @SuppressLint(value={"TrulyRandom"})
    private static String a(b b2, byte[] arrby) {
        SecretKeySpec secretKeySpec;
        IvParameterSpec ivParameterSpec;
        block3 : {
            try {
                ivParameterSpec = new IvParameterSpec(e.a("c1hLaUM5dDhkVnFvMTVOYw=="));
                secretKeySpec = g.a(b2);
                if (secretKeySpec != null) break block3;
                return null;
            }
            catch (Exception exception) {
                a.c("DataEncryptionHelper.encrypt()", new Object[]{exception});
                return null;
            }
        }
        Cipher cipher = Cipher.getInstance((String)"AES/CBC/PKCS5Padding");
        cipher.init(1, (Key)secretKeySpec, (AlgorithmParameterSpec)ivParameterSpec);
        String string = new String(e.a(cipher.doFinal(arrby)));
        return string;
    }

    private static SecretKeySpec a(b b2) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        if (b2 != null) {
            for (n2 = 0; n2 < 11; ++n2) {
                stringBuilder.append(b2.d.charAt(n2));
                stringBuilder.append("HTXDVXV3Fag".charAt(n2));
            }
        } else {
            while (n2 < 11) {
                stringBuilder.append("0");
                stringBuilder.append("HTXDVXV3Fag".charAt(n2));
                ++n2;
            }
        }
        stringBuilder.append("==");
        String string = stringBuilder.toString();
        if (string == null) {
            return null;
        }
        return new SecretKeySpec(e.a(string), "AES");
    }
}

