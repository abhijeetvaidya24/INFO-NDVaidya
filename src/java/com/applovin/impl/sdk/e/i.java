/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.e.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class i {
    public static String a(String string2, String string3) {
        return i.a(string2, string3, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
    }

    public static String a(String string2, String string3, long l2) {
        return i.a(string2, string3, l2, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
    }

    /*
     * Exception decompiling
     */
    private static String a(String var0, String var1, long var2, byte[] var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl502 : ALOAD : trying to set 0 previously set to 1
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(String string2, String string3, byte[] arrby) {
        int n2;
        byte[] arrby3;
        ByteArrayOutputStream byteArrayOutputStream;
        int n3;
        long l6;
        int n6;
        int n5;
        byte[] arrby4;
        ByteArrayInputStream byteArrayInputStream;
        int n4;
        long l4;
        byte by;
        if (string3 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No SDK key specified");
            throw illegalArgumentException;
        }
        if (string3.length() < 80) throw new IllegalArgumentException("SDK key is too short");
        if (arrby == null) throw new IllegalArgumentException("No salt specified");
        if (arrby.length < 32) throw new IllegalArgumentException("Salt is too short");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return string2;
        }
        if (string2.trim().startsWith("{")) {
            return string2;
        }
        String[] arrstring = string2.split(":");
        String string5 = arrstring[0];
        try {
            if (!"1".equals((Object)string5)) return null;
            if (arrstring.length != 4) {
                return null;
            }
            n2 = 1;
            String string4 = arrstring[n2];
            String string6 = arrstring[2];
            byte[] arrby2 = i.a(arrstring[3]);
            if (!string3.endsWith(string6)) {
                return null;
            }
            if (!i.a(arrby).equals((Object)string4)) return null;
            arrby3 = i.a(string3.substring(0, 32), arrby);
            byteArrayInputStream = new ByteArrayInputStream(arrby2);
            long l2 = (long)(255 & (byteArrayInputStream.read() ^ arrby3[0])) << 0;
            long l3 = 255 & (byteArrayInputStream.read() ^ arrby3[n2]);
            n3 = 8;
            l4 = l2 | l3 << n3 | (long)(255 & (byteArrayInputStream.read() ^ arrby3[2])) << 16 | (long)(255 & (byteArrayInputStream.read() ^ arrby3[3])) << 24 | (long)(255 & (byteArrayInputStream.read() ^ arrby3[4])) << 32;
            n4 = byteArrayInputStream.read();
            by = arrby3[5];
        }
        catch (IOException iOException) {
            return null;
        }
        long l5 = l4 | (long)(255 & (n4 ^ by)) << 40;
        l6 = l5 | (long)(255 & (byteArrayInputStream.read() ^ arrby3[6])) << 48 | (long)(255 & (byteArrayInputStream.read() ^ arrby3[7])) << 56;
        byteArrayOutputStream = new ByteArrayOutputStream();
        arrby4 = new byte[n3];
        n5 = byteArrayInputStream.read(arrby4);
        n6 = 0;
        while (n5 >= 0) {
            long l7 = l6 + (long)n6;
            long l8 = -4417276706812531889L * (l7 ^ l7 >> 33);
            long l9 = -8796714831421723037L * (l8 ^ l8 >> 29);
            long l10 = l9 ^ l9 >> 32;
            byteArrayOutputStream.write((int)((byte)((long)(arrby4[0] ^ arrby3[(n6 + 0) % arrby3.length]) ^ 255L & l10 >> 0)));
            byteArrayOutputStream.write((int)((byte)((long)(arrby4[n2] ^ arrby3[(n6 + 1) % arrby3.length]) ^ 255L & l10 >> n3)));
            int n7 = arrby4[2] ^ arrby3[(n6 + 2) % arrby3.length];
            long l11 = l6;
            byteArrayOutputStream.write((int)((byte)((long)n7 ^ 255L & l10 >> 16)));
            byteArrayOutputStream.write((int)((byte)((long)(arrby4[3] ^ arrby3[(n6 + 3) % arrby3.length]) ^ 255L & l10 >> 24)));
            byteArrayOutputStream.write((int)((byte)((long)(arrby4[4] ^ arrby3[(n6 + 4) % arrby3.length]) ^ 255L & l10 >> 32)));
            byteArrayOutputStream.write((int)((byte)((long)(arrby4[5] ^ arrby3[(n6 + 5) % arrby3.length]) ^ 255L & l10 >> 40)));
            byteArrayOutputStream.write((int)((byte)((long)(arrby4[6] ^ arrby3[(n6 + 6) % arrby3.length]) ^ 255L & l10 >> 48)));
            byteArrayOutputStream.write((int)((byte)((long)(arrby4[7] ^ arrby3[(n6 + 7) % arrby3.length]) ^ 255L & l10 >> 56)));
            int n8 = byteArrayInputStream.read(arrby4);
            n6 += 8;
            n5 = n8;
            l6 = l11;
            n3 = 8;
            n2 = 1;
        }
        try {
            return new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
        }
        catch (IOException iOException) {
            return null;
        }
    }

    private static String a(byte[] arrby) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-1");
            messageDigest.update(arrby);
            String string2 = j.a(messageDigest.digest());
            return string2;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("SHA-1 algorithm not found", (Throwable)noSuchAlgorithmException);
        }
    }

    private static byte[] a(String string2) {
        return Base64.decode((String)i.b(string2), (int)0);
    }

    private static byte[] a(String string2, byte[] arrby) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-256");
            messageDigest.update(arrby);
            messageDigest.update(string2.getBytes("UTF-8"));
            byte[] arrby2 = messageDigest.digest();
            return arrby2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("UTF-8 encoding not found", (Throwable)unsupportedEncodingException);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("SHA-1 algorithm not found", (Throwable)noSuchAlgorithmException);
        }
    }

    private static String b(String string2) {
        return string2.replace('-', '+').replace('_', '/').replace('*', '=');
    }

    private static String b(byte[] arrby) throws UnsupportedEncodingException {
        return i.c(Base64.encode((byte[])arrby, (int)2));
    }

    private static String c(byte[] arrby) throws UnsupportedEncodingException {
        return new String(arrby, "UTF-8").replace('+', '-').replace('/', '_').replace('=', '*');
    }
}

