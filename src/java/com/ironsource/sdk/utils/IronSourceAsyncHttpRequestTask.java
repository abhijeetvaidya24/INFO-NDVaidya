/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 */
package com.ironsource.sdk.utils;

import android.os.AsyncTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class IronSourceAsyncHttpRequestTask
extends AsyncTask<String, Integer, Integer> {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected /* varargs */ Integer doInBackground(String ... var1_1) {
        block7 : {
            var2_2 = null;
            var5_3 = (HttpURLConnection)new URL(var1_1[0]).openConnection();
            try {
                var5_3.setConnectTimeout(3000);
                var5_3.getInputStream();
                if (var5_3 == null) return 1;
            }
            catch (Throwable var7_4) {
                var2_2 = var5_3;
                var4_5 = var7_4;
                break block7;
            }
            catch (Exception var6_7) {
                var2_2 = var5_3;
                var3_8 = var6_7;
                ** GOTO lbl-1000
            }
            var5_3.disconnect();
            return 1;
            catch (Throwable var4_6) {
                break block7;
            }
            catch (Exception var3_9) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                var3_8.printStackTrace();
                if (var2_2 == null) return 1;
            }
            var2_2.disconnect();
            return 1;
        }
        if (var2_2 == null) throw var4_5;
        var2_2.disconnect();
        throw var4_5;
    }
}

