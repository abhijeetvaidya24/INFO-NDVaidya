/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.Throwable
 */
package com.adincube.sdk.util;

import com.adincube.sdk.util.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class w {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String a(InputStream var0) {
        block14 : {
            var1_1 = new StringBuffer();
            var2_2 = null;
            var3_3 = new BufferedReader((Reader)new InputStreamReader(var0, "UTF-8"));
            while ((var8_4 = var3_3.readLine()) != null) {
                var1_1.append(var8_4);
            }
            var10_5 = var1_1.toString();
            try {
                var3_3.close();
                return var10_5;
            }
            catch (IOException var11_6) {
                a.c("readStream() IOException finally", new Object[]{var11_6});
                return var10_5;
            }
            catch (Throwable var6_7) {
                var2_2 = var3_3;
                break block14;
            }
            catch (IOException var4_10) {
                var2_2 = var3_3;
                ** GOTO lbl-1000
            }
            catch (Throwable var6_8) {
                break block14;
            }
            catch (IOException var4_11) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                a.c("readStream() IOException", new Object[]{var4_12});
                if (var2_2 == null) return "";
            }
            try {
                var2_2.close();
                return "";
            }
            catch (IOException var5_13) {
                a.c("readStream() IOException finally", new Object[]{var5_13});
            }
            return "";
        }
        if (var2_2 == null) throw var6_9;
        try {
            var2_2.close();
            throw var6_9;
        }
        catch (IOException var7_14) {
            a.c("readStream() IOException finally", new Object[]{var7_14});
            throw var6_9;
        }
    }
}

