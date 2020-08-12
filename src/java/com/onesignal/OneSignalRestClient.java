/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Thread$State
 *  java.lang.Throwable
 *  java.net.ConnectException
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.net.UnknownHostException
 *  java.util.Scanner
 *  org.json.JSONObject
 */
package com.onesignal;

import com.onesignal.OneSignal;
import com.onesignal.OneSignalPrefs;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;
import org.json.JSONObject;

class OneSignalRestClient {
    private static Thread callResponseHandlerOnFailure(final ResponseHandler responseHandler, final int n2, final String string2, final Throwable throwable) {
        if (responseHandler == null) {
            return null;
        }
        Thread thread = new Thread(new Runnable(){

            public void run() {
                responseHandler.onFailure(n2, string2, throwable);
            }
        });
        thread.start();
        return thread;
    }

    private static Thread callResponseHandlerOnSuccess(final ResponseHandler responseHandler, final String string2) {
        if (responseHandler == null) {
            return null;
        }
        Thread thread = new Thread(new Runnable(){

            public void run() {
                responseHandler.onSuccess(string2);
            }
        });
        thread.start();
        return thread;
    }

    public static void get(final String string2, final ResponseHandler responseHandler, final String string3) {
        new Thread(new Runnable(){

            public void run() {
                OneSignalRestClient.makeRequest(string2, null, null, responseHandler, 60000, string3);
            }
        }).start();
    }

    public static void getSync(String string2, ResponseHandler responseHandler, String string3) {
        OneSignalRestClient.makeRequest(string2, null, null, responseHandler, 60000, string3);
    }

    private static int getThreadTimeout(int n2) {
        return n2 + 5000;
    }

    private static void makeRequest(final String string2, final String string3, final JSONObject jSONObject, final ResponseHandler responseHandler, final int n2, final String string4) {
        if (string3 != null && OneSignal.shouldLogUserPrivacyConsentErrorMessageForMethodName(null)) {
            return;
        }
        final Thread[] arrthread = new Thread[1];
        Runnable runnable = new Runnable(){

            public void run() {
                arrthread[0] = OneSignalRestClient.startHTTPConnection(string2, string3, jSONObject, responseHandler, n2, string4);
            }
        };
        Thread thread = new Thread(runnable, "OS_HTTPConnection");
        thread.start();
        try {
            thread.join((long)OneSignalRestClient.getThreadTimeout(n2));
            if (thread.getState() != Thread.State.TERMINATED) {
                thread.interrupt();
            }
            if (arrthread[0] != null) {
                arrthread[0].join();
                return;
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private static HttpURLConnection newHttpURLConnection(String string2) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://onesignal.com/api/v1/");
        stringBuilder.append(string2);
        return (HttpURLConnection)new URL(stringBuilder.toString()).openConnection();
    }

    public static void post(final String string2, final JSONObject jSONObject, final ResponseHandler responseHandler) {
        new Thread(new Runnable(){

            public void run() {
                OneSignalRestClient.makeRequest(string2, "POST", jSONObject, responseHandler, 120000, null);
            }
        }).start();
    }

    public static void postSync(String string2, JSONObject jSONObject, ResponseHandler responseHandler) {
        OneSignalRestClient.makeRequest(string2, "POST", jSONObject, responseHandler, 120000, null);
    }

    public static void put(final String string2, final JSONObject jSONObject, final ResponseHandler responseHandler) {
        new Thread(new Runnable(){

            public void run() {
                OneSignalRestClient.makeRequest(string2, "PUT", jSONObject, responseHandler, 120000, null);
            }
        }).start();
    }

    public static void putSync(String string2, JSONObject jSONObject, ResponseHandler responseHandler) {
        OneSignalRestClient.makeRequest(string2, "PUT", jSONObject, responseHandler, 120000, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static Thread startHTTPConnection(String var0, String var1_1, JSONObject var2_2, ResponseHandler var3_3, int var4_4, String var5_5) {
        block29 : {
            block33 : {
                block32 : {
                    block31 : {
                        block30 : {
                            block35 : {
                                block36 : {
                                    block34 : {
                                        var6_6 = -1;
                                        var21_7 = OneSignal.LOG_LEVEL.DEBUG;
                                        var22_8 = new StringBuilder();
                                        var22_8.append("OneSignalRestClient: Making request to: https://onesignal.com/api/v1/");
                                        var22_8.append(var0);
                                        OneSignal.Log(var21_7, var22_8.toString());
                                        var10_9 = OneSignalRestClient.newHttpURLConnection(var0);
                                        try {
                                            block28 : {
                                                var10_9.setUseCaches(false);
                                                var10_9.setConnectTimeout(var4_4);
                                                var10_9.setReadTimeout(var4_4);
                                                var10_9.setRequestProperty("SDK-Version", "onesignal/android/031009");
                                                if (var2_2 != null) {
                                                    var10_9.setDoInput(true);
                                                }
                                                if (var1_1 != null) {
                                                    var10_9.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                                                    var10_9.setRequestMethod(var1_1);
                                                    var10_9.setDoOutput(true);
                                                }
                                                if (var2_2 != null) {
                                                    var97_10 = var2_2.toString();
                                                    var98_11 = OneSignal.LOG_LEVEL.DEBUG;
                                                    var99_12 = new StringBuilder();
                                                    var99_12.append("OneSignalRestClient: ");
                                                    var99_12.append(var1_1);
                                                    var99_12.append(" SEND JSON: ");
                                                    var99_12.append(var97_10);
                                                    OneSignal.Log(var98_11, var99_12.toString());
                                                    var104_13 = var97_10.getBytes("UTF-8");
                                                    var10_9.setFixedLengthStreamingMode(var104_13.length);
                                                    var10_9.getOutputStream().write(var104_13);
                                                }
                                                if (var5_5 != null) {
                                                    var88_14 = OneSignalPrefs.PREFS_ONESIGNAL;
                                                    var89_15 = new StringBuilder();
                                                    var89_15.append("PREFS_OS_ETAG_PREFIX_");
                                                    var89_15.append(var5_5);
                                                    var92_16 = OneSignalPrefs.getString(var88_14, var89_15.toString(), null);
                                                    if (var92_16 != null) {
                                                        var10_9.setRequestProperty("if-none-match", var92_16);
                                                        var93_17 = OneSignal.LOG_LEVEL.DEBUG;
                                                        var94_18 = new StringBuilder();
                                                        var94_18.append("OneSignalRestClient: Adding header if-none-match: ");
                                                        var94_18.append(var92_16);
                                                        OneSignal.Log(var93_17, var94_18.toString());
                                                    }
                                                }
                                                var6_6 = var10_9.getResponseCode();
                                                try {
                                                    var26_19 = OneSignal.LOG_LEVEL.VERBOSE;
                                                    var27_20 = new StringBuilder();
                                                    var27_20.append("OneSignalRestClient: After con.getResponseCode to: https://onesignal.com/api/v1/");
                                                    var27_20.append(var0);
                                                    OneSignal.Log(var26_19, var27_20.toString());
                                                    var30_21 = "";
                                                    var31_22 = "GET";
                                                    if (var6_6 == 200) break block28;
                                                    if (var6_6 == 304) ** GOTO lbl91
                                                }
                                                catch (Throwable var7_51) {
                                                    break block34;
                                                }
                                                var69_23 = OneSignal.LOG_LEVEL.DEBUG;
                                                var70_24 = new StringBuilder();
                                                var70_24.append("OneSignalRestClient: Failed request to: https://onesignal.com/api/v1/");
                                                var70_24.append(var0);
                                                OneSignal.Log(var69_23, var70_24.toString());
                                                var73_25 = var10_9.getErrorStream();
                                                if (var73_25 == null) {
                                                    var73_25 = var10_9.getInputStream();
                                                }
                                                if (var73_25 != null) {
                                                    var74_26 = new Scanner(var73_25, "UTF-8");
                                                    if (var74_26.useDelimiter("\\A").hasNext()) {
                                                        var30_21 = var74_26.next();
                                                    }
                                                    var74_26.close();
                                                    var75_27 = OneSignal.LOG_LEVEL.WARN;
                                                    var76_28 = new StringBuilder();
                                                    var76_28.append("OneSignalRestClient: ");
                                                    var76_28.append(var1_1);
                                                    var76_28.append(" RECEIVED JSON: ");
                                                    var76_28.append(var30_21);
                                                    OneSignal.Log(var75_27, var76_28.toString());
                                                } else {
                                                    var81_29 = OneSignal.LOG_LEVEL.WARN;
                                                    var82_30 = new StringBuilder();
                                                    var82_30.append("OneSignalRestClient: ");
                                                    var82_30.append(var1_1);
                                                    var82_30.append(" HTTP Code: ");
                                                    var82_30.append(var6_6);
                                                    var82_30.append(" No response body!");
                                                    OneSignal.Log(var81_29, var82_30.toString());
                                                }
                                                var15_31 = OneSignalRestClient.callResponseHandlerOnFailure(var3_3, var6_6, null, null);
                                                break block29;
lbl91: // 1 sources:
                                                var58_32 = OneSignalPrefs.PREFS_ONESIGNAL;
                                                var59_33 = new StringBuilder();
                                                var59_33.append("PREFS_OS_HTTP_CACHE_PREFIX_");
                                                var59_33.append(var5_5);
                                                var62_34 = OneSignalPrefs.getString(var58_32, var59_33.toString(), null);
                                                var63_35 = OneSignal.LOG_LEVEL.DEBUG;
                                                var64_36 = new StringBuilder();
                                                var64_36.append("OneSignalRestClient: ");
                                                if (var1_1 != null) break block30;
                                                break block31;
                                            }
                                            var32_37 = OneSignal.LOG_LEVEL.DEBUG;
                                            var33_38 = new StringBuilder();
                                            var34_39 = var6_6;
                                            try {
                                                var33_38.append("OneSignalRestClient: Successfully finished request to: https://onesignal.com/api/v1/");
                                                var33_38.append(var0);
                                                OneSignal.Log(var32_37, var33_38.toString());
                                                var37_40 = new Scanner(var10_9.getInputStream(), "UTF-8");
                                                if (var37_40.useDelimiter("\\A").hasNext()) {
                                                    var30_21 = var37_40.next();
                                                }
                                                var37_40.close();
                                                var38_41 = OneSignal.LOG_LEVEL.DEBUG;
                                                var39_42 = new StringBuilder();
                                                var39_42.append("OneSignalRestClient: ");
                                                if (var1_1 != null) break block32;
                                                break block33;
                                            }
                                            catch (Throwable var7_50) {
                                                var6_6 = var34_39;
                                                break block34;
                                            }
                                        }
                                        catch (Throwable var9_55) {
                                            break block35;
                                        }
                                        catch (Throwable var7_52) {
                                            // empty catch block
                                        }
                                    }
                                    var8_59 = var10_9;
                                    break block36;
                                    catch (Throwable var9_56) {
                                        var10_9 = null;
                                        break block35;
                                    }
                                    catch (Throwable var7_54) {
                                        var8_59 = null;
                                    }
                                }
                                try {
                                    if (!(var7_53 instanceof ConnectException) && !(var7_53 instanceof UnknownHostException)) {
                                        var16_60 = OneSignal.LOG_LEVEL.WARN;
                                        var17_61 = new StringBuilder();
                                        var17_61.append("OneSignalRestClient: ");
                                        var17_61.append(var1_1);
                                        var17_61.append(" Error thrown from network stack. ");
                                        OneSignal.Log(var16_60, var17_61.toString(), (Throwable)var7_53);
                                    } else {
                                        var11_62 = OneSignal.LOG_LEVEL.INFO;
                                        var12_63 = new StringBuilder();
                                        var12_63.append("OneSignalRestClient: Could not send last request, device is offline. Throwable: ");
                                        var12_63.append(var7_53.getClass().getName());
                                        OneSignal.Log(var11_62, var12_63.toString());
                                    }
                                    var15_31 = OneSignalRestClient.callResponseHandlerOnFailure(var3_3, var6_6, null, (Throwable)var7_53);
                                    if (var8_59 == null) return var15_31;
                                }
                                catch (Throwable var9_57) {
                                    var10_9 = var8_59;
                                }
                                var8_59.disconnect();
                                return var15_31;
                            }
                            if (var10_9 == null) throw var9_58;
                            var10_9.disconnect();
                            throw var9_58;
                        }
                        var31_22 = var1_1;
                    }
                    var64_36.append(var31_22);
                    var64_36.append(" - Using Cached response due to 304: ");
                    var64_36.append(var62_34);
                    OneSignal.Log(var63_35, var64_36.toString());
                    var15_31 = OneSignalRestClient.callResponseHandlerOnSuccess(var3_3, var62_34);
                    break block29;
                }
                var31_22 = var1_1;
            }
            var39_42.append(var31_22);
            var39_42.append(" RECEIVED JSON: ");
            var39_42.append(var30_21);
            OneSignal.Log(var38_41, var39_42.toString());
            if (var5_5 != null && (var44_43 = var10_9.getHeaderField("etag")) != null) {
                var45_44 = OneSignal.LOG_LEVEL.DEBUG;
                var46_45 = new StringBuilder();
                var46_45.append("OneSignalRestClient: Response has etag of ");
                var46_45.append(var44_43);
                var46_45.append(" so caching the response.");
                OneSignal.Log(var45_44, var46_45.toString());
                var50_46 = OneSignalPrefs.PREFS_ONESIGNAL;
                var51_47 = new StringBuilder();
                var51_47.append("PREFS_OS_ETAG_PREFIX_");
                var51_47.append(var5_5);
                OneSignalPrefs.saveString(var50_46, var51_47.toString(), var44_43);
                var54_48 = OneSignalPrefs.PREFS_ONESIGNAL;
                var55_49 = new StringBuilder();
                var55_49.append("PREFS_OS_HTTP_CACHE_PREFIX_");
                var55_49.append(var5_5);
                OneSignalPrefs.saveString(var54_48, var55_49.toString(), var30_21);
            }
            var15_31 = OneSignalRestClient.callResponseHandlerOnSuccess(var3_3, var30_21);
        }
        if (var10_9 == null) return var15_31;
        var10_9.disconnect();
        return var15_31;
    }

    static abstract class ResponseHandler {
        ResponseHandler() {
        }

        void onFailure(int n2, String string2, Throwable throwable) {
        }

        void onSuccess(String string2) {
        }
    }

}

