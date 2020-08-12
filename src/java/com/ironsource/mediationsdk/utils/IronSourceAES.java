/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.Key
 *  java.security.spec.AlgorithmParameterSpec
 *  java.util.Arrays
 *  javax.crypto.Cipher
 *  javax.crypto.spec.IvParameterSpec
 *  javax.crypto.spec.SecretKeySpec
 */
package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class IronSourceAES {
    private static boolean mDidSendEncryptionFailEventInSession;

    public static String decode(String string, String string2) {
        Class<IronSourceAES> class_ = IronSourceAES.class;
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty((CharSequence)string)) {
                // ** MonitorExit[var15_2] (shouldn't be in output)
                return "";
            }
            if (TextUtils.isEmpty((CharSequence)string2)) {
                // ** MonitorExit[var15_2] (shouldn't be in output)
                return "";
            }
            SecretKeySpec secretKeySpec = IronSourceAES.getKey(string);
            byte[] arrby = new byte[16];
            Arrays.fill((byte[])arrby, (byte)0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(arrby);
            byte[] arrby2 = Base64.decode((String)string2, (int)0);
            Cipher cipher = Cipher.getInstance((String)"AES/CBC/PKCS7Padding");
            cipher.init(2, (Key)secretKeySpec, (AlgorithmParameterSpec)ivParameterSpec);
            String string3 = new String(cipher.doFinal(arrby2));
            // ** MonitorExit[var15_2] (shouldn't be in output)
            return string3;
        }
    }

    public static String encode(String string, String string2) {
        Class<IronSourceAES> class_ = IronSourceAES.class;
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty((CharSequence)string)) {
                // ** MonitorExit[var10_2] (shouldn't be in output)
                return "";
            }
            if (TextUtils.isEmpty((CharSequence)string2)) {
                // ** MonitorExit[var10_2] (shouldn't be in output)
                return "";
            }
            SecretKeySpec secretKeySpec = IronSourceAES.getKey(string);
            byte[] arrby = string2.getBytes("UTF8");
            byte[] arrby2 = new byte[16];
            Arrays.fill((byte[])arrby2, (byte)0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(arrby2);
            Cipher cipher = Cipher.getInstance((String)"AES/CBC/PKCS7Padding");
            cipher.init(1, (Key)secretKeySpec, (AlgorithmParameterSpec)ivParameterSpec);
            String string3 = Base64.encodeToString((byte[])cipher.doFinal(arrby), (int)0).replaceAll(System.getProperty((String)"line.separator"), "");
            // ** MonitorExit[var10_2] (shouldn't be in output)
            return string3;
        }
    }

    private static SecretKeySpec getKey(String string) throws UnsupportedEncodingException {
        byte[] arrby = new byte[32];
        Arrays.fill((byte[])arrby, (byte)0);
        byte[] arrby2 = string.getBytes("UTF-8");
        int n2 = arrby2.length < arrby.length ? arrby2.length : arrby.length;
        System.arraycopy((Object)arrby2, (int)0, (Object)arrby, (int)0, (int)n2);
        return new SecretKeySpec(arrby, "AES");
    }
}

