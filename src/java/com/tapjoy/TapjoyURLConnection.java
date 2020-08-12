/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Reader
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tapjoy;

import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.internal.em;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class TapjoyURLConnection {
    public static final int TYPE_GET = 0;
    public static final int TYPE_POST = 1;

    public String getContentLength(String string2) {
        String string3;
        try {
            String string4 = string2.replaceAll(" ", "%20");
            StringBuilder stringBuilder = new StringBuilder("requestURL: ");
            stringBuilder.append(string4);
            TapjoyLog.d("TapjoyURLConnection", stringBuilder.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection)em.a(new URL(string4));
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(30000);
            string3 = httpURLConnection.getHeaderField("content-length");
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("Exception: ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e("TapjoyURLConnection", stringBuilder.toString());
            string3 = null;
        }
        StringBuilder stringBuilder = new StringBuilder("content-length: ");
        stringBuilder.append(string3);
        TapjoyLog.d("TapjoyURLConnection", stringBuilder.toString());
        return string3;
    }

    public TapjoyHttpURLResponse getRedirectFromURL(String string2) {
        return this.getResponseFromURL(string2, "", 0, true, null, null, null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String string2) {
        return this.getResponseFromURL(string2, "", 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String string2, String string3) {
        return this.getResponseFromURL(string2, string3, 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String string2, String string3, int n2) {
        return this.getResponseFromURL(string2, string3, n2, false, null, null, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public TapjoyHttpURLResponse getResponseFromURL(String var1_1, String var2_2, int var3_3, boolean var4_4, Map var5_5, String var6_6, String var7_7) {
        block22 : {
            block23 : {
                var8_8 = new TapjoyHttpURLResponse();
                var9_9 = new StringBuilder();
                var9_9.append(var1_1);
                var9_9.append(var2_2);
                var33_10 = var9_9.toString();
                var34_11 = new StringBuilder("http ");
                var35_12 = var3_3 == 0 ? "get" : "post";
                var34_11.append(var35_12);
                var34_11.append(": ");
                var34_11.append(var33_10);
                TapjoyLog.i("TapjoyURLConnection", var34_11.toString());
                var12_13 = (HttpURLConnection)em.a(new URL(var33_10));
                if (!var4_4) ** GOTO lbl17
                var12_13.setInstanceFollowRedirects(false);
lbl17: // 2 sources:
                var12_13.setConnectTimeout(15000);
                var12_13.setReadTimeout(30000);
                if (var5_5 != null) {
                    for (Map.Entry var54_15 : var5_5.entrySet()) {
                        var12_13.setRequestProperty((String)var54_15.getKey(), (String)var54_15.getValue());
                    }
                }
                if (var3_3 == 1) {
                    var12_13.setRequestMethod("POST");
                    if (var7_7 != null) {
                        var40_16 = new StringBuilder("Content-Type: ");
                        var40_16.append(var6_6);
                        TapjoyLog.i("TapjoyURLConnection", var40_16.toString());
                        TapjoyLog.i("TapjoyURLConnection", "Content:");
                        TapjoyLog.i("TapjoyURLConnection", var7_7);
                        var12_13.setRequestProperty("Content-Type", var6_6);
                        var12_13.setRequestProperty("Connection", "close");
                        var12_13.setDoOutput(true);
                        var12_13.setFixedLengthStreamingMode(var7_7.length());
                        var42_17 = new OutputStreamWriter(var12_13.getOutputStream());
                        var42_17.write(var7_7);
                        var42_17.close();
                    }
                }
                var12_13.connect();
                var8_8.statusCode = var12_13.getResponseCode();
                var8_8.headerFields = var12_13.getHeaderFields();
                var8_8.date = var12_13.getDate();
                var8_8.expires = var12_13.getExpiration();
                var43_18 = null;
                if (!var4_4) {
                    var43_18 = new BufferedReader((Reader)new InputStreamReader(var12_13.getInputStream()));
                }
                if (!var4_4) {
                    var44_19 = new StringBuilder();
                    while ((var45_20 = var43_18.readLine()) != null) {
                        var46_21 = new StringBuilder();
                        var46_21.append(var45_20);
                        var46_21.append('\n');
                        var44_19.append(var46_21.toString());
                    }
                    var8_8.response = var44_19.toString();
                }
                if (var8_8.statusCode == 302) {
                    var8_8.redirectURL = var12_13.getHeaderField("Location");
                }
                if ((var50_22 = var12_13.getHeaderField("content-length")) == null) ** GOTO lbl67
                {
                    catch (Exception var11_25) {}
                }
                try {
                    var8_8.contentLength = Integer.valueOf((String)var50_22);
                    ** GOTO lbl67
                }
                catch (Exception var51_23) {
                    var52_24 = new StringBuilder("Exception: ");
                    var52_24.append(var51_23.toString());
                    TapjoyLog.e("TapjoyURLConnection", var52_24.toString());
lbl67: // 3 sources:
                    if (var43_18 != null) {
                        var43_18.close();
                    }
                    break block22;
                }
                break block23;
                catch (Exception var10_27) {
                    var11_26 = var10_27;
                    var12_13 = null;
                }
            }
            var13_28 = new StringBuilder("Exception: ");
            var13_28.append(var11_26.toString());
            TapjoyLog.e("TapjoyURLConnection", var13_28.toString());
            var8_8.statusCode = 0;
            if (var12_13 != null) {
                try {
                    if (var8_8.response == null) {
                        var24_29 = new BufferedReader((Reader)new InputStreamReader(var12_13.getErrorStream()));
                        var25_30 = new StringBuilder();
                        while ((var26_31 = var24_29.readLine()) != null) {
                            var27_32 = new StringBuilder();
                            var27_32.append(var26_31);
                            var27_32.append('\n');
                            var25_30.append(var27_32.toString());
                        }
                        var8_8.response = var25_30.toString();
                    }
                }
                catch (Exception var21_33) {
                    var22_34 = new StringBuilder("Exception trying to get error code/content: ");
                    var22_34.append(var21_33.toString());
                    TapjoyLog.e("TapjoyURLConnection", var22_34.toString());
                }
            }
        }
        TapjoyLog.i("TapjoyURLConnection", "--------------------");
        var15_35 = new StringBuilder("response status: ");
        var15_35.append(var8_8.statusCode);
        TapjoyLog.i("TapjoyURLConnection", var15_35.toString());
        var17_36 = new StringBuilder("response size: ");
        var17_36.append(var8_8.contentLength);
        TapjoyLog.i("TapjoyURLConnection", var17_36.toString());
        if (var8_8.redirectURL != null && var8_8.redirectURL.length() > 0) {
            var19_37 = new StringBuilder("redirectURL: ");
            var19_37.append(var8_8.redirectURL);
            TapjoyLog.i("TapjoyURLConnection", var19_37.toString());
        }
        TapjoyLog.i("TapjoyURLConnection", "--------------------");
        return var8_8;
    }

    public TapjoyHttpURLResponse getResponseFromURL(String string2, Map map) {
        return this.getResponseFromURL(string2, TapjoyUtil.convertURLParams(map, false), 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String string2, Map map, int n2) {
        return this.getResponseFromURL(string2, TapjoyUtil.convertURLParams(map, false), n2);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String string2, Map map, Map map2, String string3) {
        String string4 = map != null ? TapjoyUtil.convertURLParams(map, false) : "";
        return this.getResponseFromURL(string2, string4, 1, false, map2, "application/json;charset=utf-8", string3);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String string2, Map map, Map map2, Map map3) {
        String string3 = map != null ? TapjoyUtil.convertURLParams(map, false) : "";
        return this.getResponseFromURL(string2, string3, 1, false, map2, "application/x-www-form-urlencoded", TapjoyUtil.convertURLParams(map3, false));
    }
}

