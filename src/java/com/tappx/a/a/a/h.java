/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.Key
 *  javax.crypto.Cipher
 *  javax.crypto.spec.SecretKeySpec
 */
package com.tappx.a.a.a;

import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class h {
    private static volatile h a;
    private static final String b = "UTF-8";
    private static final byte[] c;
    private static final byte[] d;
    private static final String e = "AES";
    private static final String f = "Missing library";
    private static final int i = 24;
    private Cipher g;
    private Cipher h;

    static {
        c = new byte[]{81, 80, 55, 68, 109, 116, 116, 52, 54, 67, 104, 99, 71, 108, 52, 81, 67, 102, 100, 86};
        d = new byte[]{-30, 31, 11, 37, 23, 88};
    }

    public h() {
        this(c, d);
    }

    public h(String string2) {
        this(string2.getBytes(), d);
    }

    public h(byte[] arrby, byte[] arrby2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(h.a(arrby, arrby2), e);
            this.g = Cipher.getInstance((String)e);
            this.g.init(1, (Key)secretKeySpec);
            this.h = Cipher.getInstance((String)e);
            this.h.init(2, (Key)secretKeySpec);
        }
        catch (Exception exception) {}
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h a() {
        h h2 = a;
        if (h2 != null) {
            return h2;
        }
        Class<h> class_ = h.class;
        synchronized (h.class) {
            h h3 = a;
            if (h3 == null) {
                a = h3 = new h();
            }
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return h3;
        }
    }

    public static String a(String string2) {
        return h.a().c(string2);
    }

    @Deprecated
    public static void a(h h2) {
        a = h2;
    }

    private static byte[] a(byte[] arrby, byte[] arrby2) {
        if (arrby == null) {
            return arrby2;
        }
        if (arrby2 == null) {
            return arrby;
        }
        byte[] arrby3 = new byte[24];
        System.arraycopy((Object)arrby, (int)0, (Object)arrby3, (int)0, (int)arrby.length);
        System.arraycopy((Object)arrby2, (int)0, (Object)arrby3, (int)arrby.length, (int)(arrby3.length - arrby.length));
        return arrby3;
    }

    public String b(String string2) {
        if (string2 == null) {
            return null;
        }
        try {
            String string3 = new String(Base64.encode((byte[])this.g.doFinal(string2.getBytes(b)), (int)0), b);
            return string3;
        }
        catch (Exception exception) {
            return "";
        }
    }

    public String c(String string2) {
        if (string2 == null) {
            return null;
        }
        try {
            byte[] arrby = Base64.decode((String)string2, (int)0);
            String string3 = new String(this.h.doFinal(arrby), b);
            return string3;
        }
        catch (Exception exception) {
            return "";
        }
    }
}

