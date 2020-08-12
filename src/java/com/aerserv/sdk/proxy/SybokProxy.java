/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.BufferedReader
 *  java.io.BufferedWriter
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Reader
 *  java.io.Writer
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.aerserv.sdk.proxy;

import android.content.Context;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.UrlBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SybokProxy {
    private static final String LOG_TAG = "SybokProxy";
    private static URL SYBOK_TIMEOUT_URL;
    private static URL SYBOK_URL;

    static {
        try {
            SYBOK_URL = new URL("https://debug.aerserv.com/sybok/");
            SYBOK_TIMEOUT_URL = new URL("https://debug.aerserv.com/sybok/sdk/timeout");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void sendParams(URL uRL, String string) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setReadTimeout(1000);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(string);
            bufferedWriter.close();
            outputStream.close();
            BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            do {
                String string2;
                if ((string2 = bufferedReader.readLine()) == null) {
                    bufferedReader.close();
                    return;
                }
                stringBuilder.append(string2);
            } while (true);
        }
        catch (Exception exception) {}
    }

    public static void sendTimeoutLogSybok(final Context context, final String string, final int n2, final int n3, final String string2) {
        if (!AerServSettings.getCentralLoggingEnabled()) {
            return;
        }
        Runnable runnable = new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("{\"sid\": \"");
                    stringBuilder.append(AerServSettings.getSessionId());
                    stringBuilder.append("\", \"rid\": \"");
                    stringBuilder.append(string);
                    stringBuilder.append("\", \"adid\": \"");
                    stringBuilder.append(UrlBuilder.getAdid(context));
                    stringBuilder.append("\", \"timeoutEnum\": ");
                    stringBuilder.append(n2);
                    stringBuilder.append(", \"timeoutLength\": ");
                    stringBuilder.append(n3);
                    String string3 = AerServSettings.getSiteId();
                    if (string3 != null) {
                        stringBuilder.append(", \"appId\": \"");
                        stringBuilder.append(AerServSettings.getSiteId());
                        stringBuilder.append("\"");
                    }
                    stringBuilder.append(", \"plc\": \"");
                    stringBuilder.append(string2);
                    stringBuilder.append("\"");
                    stringBuilder.append('}');
                    String string22 = LOG_TAG;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("send to sybok: ");
                    stringBuilder2.append(stringBuilder.toString());
                    AerServLog.d(string22, stringBuilder2.toString());
                    SybokProxy.sendParams(SYBOK_TIMEOUT_URL, stringBuilder.toString());
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
        };
        new Thread(runnable).start();
    }

    public static void sendTimeoutLogSybok(String string, int n2, int n3, String string2) {
        SybokProxy.sendTimeoutLogSybok(null, string, n2, n3, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void sendToSybok(List<String> list, Exception exception) {
        if (!AerServSettings.getCentralLoggingEnabled()) {
            return;
        }
        try {
            final JSONObject jSONObject = UrlBuilder.getParams();
            if (list != null && list.size() > 0) {
                jSONObject.put("logs", (Object)new JSONArray((Collection)list.subList(0, Math.min((int)AerServSettings.getCentralLoggingLineCount(), (int)list.size()))));
            }
            ArrayList arrayList = new ArrayList();
            AerServLog.logE(exception, (List<String>)arrayList);
            JSONArray jSONArray = new JSONArray((Collection)arrayList);
            JSONObject jSONObject2 = new JSONObject();
            if (AerServSettings.getCentralLoggingSendStackTrace()) {
                jSONObject2.put("stackTrace", (Object)jSONArray);
            }
            jSONObject2.put("name", (Object)exception.getClass().getSimpleName());
            String string = exception.getMessage() == null ? "null" : exception.getMessage();
            jSONObject2.put("message", (Object)string);
            if (exception.getStackTrace().length > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(exception.getStackTrace()[0].getClassName());
                stringBuilder.append(".");
                stringBuilder.append(exception.getStackTrace()[0].getMethodName());
                jSONObject2.put("method", (Object)stringBuilder.toString());
                jSONObject2.put("line", exception.getStackTrace()[0].getLineNumber());
            }
            jSONObject.put("exception", (Object)jSONObject2);
            jSONObject.put("timestamp", System.currentTimeMillis());
            new Thread(new Runnable(){

                public void run() {
                    try {
                        SybokProxy.sendParams(SYBOK_URL, jSONObject.toString());
                    }
                    catch (Exception exception) {}
                }
            }).start();
            return;
        }
        catch (Exception exception2) {}
    }

}

