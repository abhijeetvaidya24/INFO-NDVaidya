/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.security.Key
 *  java.security.MessageDigest
 *  java.security.SecureRandom
 *  java.security.spec.AlgorithmParameterSpec
 *  java.util.Arrays
 *  java.util.zip.CRC32
 *  javax.crypto.Cipher
 *  javax.crypto.KeyGenerator
 *  javax.crypto.SecretKey
 *  javax.crypto.spec.IvParameterSpec
 *  javax.crypto.spec.SecretKeySpec
 */
package com.appnext.base.b;

import android.text.TextUtils;
import android.util.Base64;
import com.appnext.base.b.f;
import com.appnext.base.b.i;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class h {
    private static final String fv = "rasre";
    private static final h fw = new h();

    private h() {
    }

    public static Long I(String string2) {
        try {
            if (TextUtils.isEmpty((CharSequence)string2)) {
            }
            CRC32 cRC32 = new CRC32();
            cRC32.update(string2.getBytes());
            Long l2 = cRC32.getValue();
            return l2;
        }
        finally {
            return null;
        }
    }

    public static String J(String string2) {
        try {
            if (TextUtils.isEmpty((CharSequence)string2)) {
            }
            CRC32 cRC32 = new CRC32();
            cRC32.update(string2.getBytes());
            String string3 = Long.toHexString((long)cRC32.getValue());
            return string3;
        }
        finally {
            return null;
        }
    }

    private static byte[] L(String string2) {
        try {
            if (TextUtils.isEmpty((CharSequence)string2)) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(f.getKey());
            byte[] arrby = Arrays.copyOf((byte[])stringBuilder.toString().getBytes("utf-8"), (int)16);
            return arrby;
        }
        finally {
            return null;
        }
    }

    private static String a(byte[] arrby) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = arrby.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = Integer.toHexString((int)(255 & arrby[i2]));
            if (string2.length() == 1) {
                stringBuffer.append('0');
            }
            stringBuffer.append(string2);
        }
        return stringBuffer.toString();
    }

    private static byte[] a(byte[] arrby, byte[] arrby2) {
        byte[] arrby3 = new byte[16 + arrby2.length];
        for (int i2 = 0; i2 < arrby3.length; ++i2) {
            byte by = i2 < 16 ? arrby[i2] : arrby2[i2 - 16];
            arrby3[i2] = by;
        }
        return arrby3;
    }

    public static h aO() {
        return fw;
    }

    private static String aP() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance((String)"AES");
            keyGenerator.init(128);
            String string2 = Base64.encodeToString((byte[])keyGenerator.generateKey().getEncoded(), (int)0);
            return string2;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static void init() {
    }

    public final String K(String string2) {
        byte[] arrby;
        Cipher cipher;
        byte[] arrby2;
        block8 : {
            String string3;
            block7 : {
                block6 : {
                    try {
                        if (!TextUtils.isEmpty((CharSequence)string2)) break block6;
                        return null;
                    }
                    catch (Throwable throwable) {
                        return null;
                    }
                }
                arrby2 = new byte[16];
                new SecureRandom().nextBytes(arrby2);
                cipher = Cipher.getInstance((String)"AES/CBC/PKCS5Padding");
                string3 = i.aQ().getString(fv, null);
                if (TextUtils.isEmpty((CharSequence)string3)) {
                    string3 = h.aP();
                    i.aQ().putString(fv, string3);
                }
                if (!TextUtils.isEmpty((CharSequence)string3)) break block7;
                return null;
            }
            arrby = h.L(string3);
            if (arrby != null) break block8;
            return null;
        }
        cipher.init(1, (Key)new SecretKeySpec(arrby, "AES"), (AlgorithmParameterSpec)new IvParameterSpec(arrby2));
        String string4 = Base64.encodeToString((byte[])h.a(arrby2, cipher.doFinal(string2.getBytes("utf-8"))), (int)2);
        return string4;
    }

    public final String M(String string2) {
        byte[] arrby;
        Cipher cipher;
        byte[] arrby2;
        byte[] arrby3;
        block7 : {
            String string3;
            block6 : {
                block5 : {
                    try {
                        if (!TextUtils.isEmpty((CharSequence)string2)) break block5;
                        return null;
                    }
                    catch (Throwable throwable) {
                        return null;
                    }
                }
                byte[] arrby4 = Base64.decode((String)string2, (int)2);
                arrby = Arrays.copyOfRange((byte[])arrby4, (int)0, (int)16);
                arrby3 = Arrays.copyOfRange((byte[])arrby4, (int)16, (int)arrby4.length);
                cipher = Cipher.getInstance((String)"AES/CBC/PKCS5Padding");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i.aQ().getString(fv, null));
                stringBuilder.append(f.getKey());
                string3 = stringBuilder.toString();
                if (!TextUtils.isEmpty((CharSequence)string3)) break block6;
                return null;
            }
            arrby2 = h.L(string3);
            if (arrby2 != null) break block7;
            return null;
        }
        cipher.init(2, (Key)new SecretKeySpec(arrby2, "AES"), (AlgorithmParameterSpec)new IvParameterSpec(arrby));
        String string4 = new String(cipher.doFinal(arrby3), "utf-8");
        return string4;
    }

    public final String N(String string2) {
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-256");
        messageDigest.update(string2.getBytes());
        byte[] arrby = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = arrby.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string3 = Integer.toHexString((int)(255 & arrby[i2]));
            if (string3.length() == 1) {
                stringBuffer.append('0');
            }
            stringBuffer.append(string3);
        }
        try {
            String string4 = stringBuffer.toString();
            return string4;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    public final byte[] f(String var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl46.1 : ACONST_NULL : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }
}

