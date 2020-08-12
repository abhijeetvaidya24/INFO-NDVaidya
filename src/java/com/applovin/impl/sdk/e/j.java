/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.net.URLEncoder
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.b.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;

public class j {
    private static final char[] a = "0123456789abcdef".toCharArray();

    public static int a(String string2) {
        return j.a(string2, 0);
    }

    public static int a(String string2, int n2) {
        if (j.d(string2)) {
            n2 = Integer.parseInt((String)string2);
        }
        return n2;
    }

    public static String a(int n2, String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return string2;
        }
        if (n2 > string2.length()) {
            n2 = string2.length();
        }
        return string2.substring(0, n2);
    }

    public static String a(String string2, com.applovin.impl.sdk.j j2) {
        return j.a(string2, j2.a(b.Z), j2.a(b.Y));
    }

    private static String a(String string2, Integer n2, String string3) {
        if (string3 != null) {
            if (string2 != null && string2.length() >= 1) {
                if (string3.length() >= 1) {
                    String string4;
                    block8 : {
                        if ("none".equals((Object)string3)) {
                            return string2;
                        }
                        MessageDigest messageDigest = MessageDigest.getInstance((String)string3);
                        messageDigest.update(string2.getBytes("UTF-8"));
                        string4 = j.a(messageDigest.digest());
                        if (string4 == null) break block8;
                        try {
                            if (n2 <= 0) break block8;
                            string4 = string4.substring(0, Math.min((int)n2, (int)string4.length()));
                        }
                        catch (UnsupportedEncodingException unsupportedEncodingException) {
                            throw new RuntimeException("Programming error: UTF-8 is not know encoding", (Throwable)unsupportedEncodingException);
                        }
                        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown algorithm \"");
                            stringBuilder.append(string3);
                            stringBuilder.append("\"");
                            throw new RuntimeException(stringBuilder.toString(), (Throwable)noSuchAlgorithmException);
                        }
                    }
                    return string4;
                }
                return string2;
            }
            return "";
        }
        throw new IllegalArgumentException("No algorithm specified");
    }

    public static String a(String string2, String string3, String string4) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (TextUtils.isEmpty((CharSequence)string3)) {
                return string2;
            }
            Uri.Builder builder = Uri.parse((String)string2).buildUpon();
            builder.appendQueryParameter(string3, string4);
            string2 = builder.build().toString();
        }
        return string2;
    }

    public static String a(String string2, Map<String, String> map) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return string2;
        }
        if (map != null) {
            if (map.isEmpty()) {
                return string2;
            }
            Uri.Builder builder = Uri.parse((String)string2).buildUpon();
            for (Map.Entry entry : map.entrySet()) {
                builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue());
            }
            string2 = builder.build().toString();
        }
        return string2;
    }

    public static String a(boolean bl) {
        if (bl) {
            return "1";
        }
        return "0";
    }

    public static String a(byte[] arrby) {
        IllegalArgumentException illegalArgumentException;
        if (arrby != null) {
            char[] arrc = new char[2 * arrby.length];
            for (int i2 = 0; i2 < arrby.length; ++i2) {
                int n2 = i2 * 2;
                char[] arrc2 = a;
                arrc[n2] = arrc2[(240 & arrby[i2]) >>> 4];
                arrc[n2 + 1] = arrc2[15 & arrby[i2]];
            }
            return new String(arrc);
        }
        illegalArgumentException = new IllegalArgumentException("No data specified");
        throw illegalArgumentException;
    }

    public static boolean a(String string2, String string3) {
        return j.b(string2) && j.b(string3) && string2.toLowerCase().contains((CharSequence)string3.toLowerCase());
    }

    public static boolean b(String string2) {
        return true ^ TextUtils.isEmpty((CharSequence)string2);
    }

    public static String c(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public static boolean d(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return false;
        }
        char c2 = string2.charAt(0);
        int n2 = c2 != '-' && c2 != '+' ? 0 : 1;
        int n3 = string2.length();
        if (n2 == 1 && n3 == 1) {
            return false;
        }
        while (n2 < n3) {
            if (!Character.isDigit((char)string2.charAt(n2))) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static String e(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            try {
                String string3 = URLEncoder.encode((String)string2, (String)"UTF-8");
                return string3;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new UnsupportedOperationException((Throwable)unsupportedEncodingException);
            }
        }
        return "";
    }

    public static String f(String string2) {
        return j.a(string2, -1, "SHA-1");
    }
}

