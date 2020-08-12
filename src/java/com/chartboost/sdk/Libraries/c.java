/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.chartboost.sdk.Tracking.a
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Locale
 */
package com.chartboost.sdk.Libraries;

import com.chartboost.sdk.Tracking.a;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class c {
    private c() {
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static byte[] a(byte[] arrby) {
        Class<c> class_ = c.class;
        // MONITORENTER : com.chartboost.sdk.Libraries.c.class
        if (arrby == null) {
            // MONITOREXIT : class_
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-1");
        messageDigest.update(arrby);
        byte[] arrby2 = messageDigest.digest();
        // MONITOREXIT : class_
        return arrby2;
        catch (Exception exception) {
            a.a(c.class, (String)"sha1", (Exception)exception);
            // MONITOREXIT : class_
            return null;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            a.a(c.class, (String)"sha1", (Exception)((Object)noSuchAlgorithmException));
            // MONITOREXIT : class_
            return null;
        }
    }

    public static String b(byte[] arrby) {
        if (arrby == null) {
            return null;
        }
        BigInteger bigInteger = new BigInteger(1, arrby);
        Locale locale = Locale.US;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%0");
        stringBuilder.append(arrby.length << 1);
        stringBuilder.append("x");
        return String.format((Locale)locale, (String)stringBuilder.toString(), (Object[])new Object[]{bigInteger});
    }
}

