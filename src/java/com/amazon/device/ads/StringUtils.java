/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.amazon.device.ads;

import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringUtils {
    private static final String LOGTAG = "StringUtils";
    private static final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    private StringUtils() {
    }

    public static boolean containsRegEx(String string, String string2) {
        return Pattern.compile((String)string).matcher((CharSequence)string2).find();
    }

    protected static boolean doesExceptionContainLockedDatabaseMessage(Exception exception) {
        if (exception != null && exception.getMessage() != null) {
            return exception.getMessage().contains((CharSequence)"database is locked");
        }
        return false;
    }

    public static String getFirstMatch(String string, String string2) {
        Matcher matcher = Pattern.compile((String)string).matcher((CharSequence)string2);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static final boolean isNullOrEmpty(String string) {
        return string == null || string.equals((Object)"");
        {
        }
    }

    public static final boolean isNullOrWhiteSpace(String string) {
        return StringUtils.isNullOrEmpty(string) || string.trim().equals((Object)"");
        {
        }
    }

    /*
     * Exception decompiling
     */
    public static String readStringFromInputStream(InputStream var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl42 : ALOAD_1 : trying to set 1 previously set to 0
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

    public static String sha1(String string) {
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-1");
        messageDigest.update(string.getBytes());
        byte[] arrby = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        do {
            if (n >= arrby.length) break;
            stringBuilder.append(Integer.toHexString((int)(256 | 255 & arrby[n])).substring(1));
            ++n;
        } while (true);
        try {
            String string2 = stringBuilder.toString();
            return string2;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return "";
        }
    }
}

