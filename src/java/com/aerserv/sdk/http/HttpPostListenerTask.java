/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  java.io.BufferedReader
 *  java.io.BufferedWriter
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Reader
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.net.HttpURLConnection
 *  java.net.SocketTimeoutException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.List
 *  java.util.Map
 */
package com.aerserv.sdk.http;

import android.os.AsyncTask;
import com.aerserv.sdk.http.HttpTaskListener;
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
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpPostListenerTask
extends AsyncTask<Object, Void, Boolean> {
    private static final String LOG_TAG = "HttpPostListenerTask";
    private final int connectTimeout = 2000;
    private HttpURLConnection connection = null;
    private Map<String, List<String>> headers;
    private String paramsJson;
    private final int readTimeout;
    private BufferedReader reader = null;
    private String response;
    private int statusCode;
    private HttpTaskListener taskHandler;
    private String url;
    private BufferedWriter writer = null;

    public HttpPostListenerTask(String string, String string2, HttpTaskListener httpTaskListener, int n2) {
        this.taskHandler = httpTaskListener;
        this.url = string;
        this.paramsJson = string2;
        this.readTimeout = n2;
    }

    /*
     * Exception decompiling
     */
    public void disconnect() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl17 : ALOAD_0 : trying to set 1 previously set to 0
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
    protected /* varargs */ Boolean doInBackground(Object ... arrobject) {
        boolean bl;
        Throwable throwable22;
        block10 : {
            this.connection = null;
            bl = true;
            try {
                try {
                    this.connection = (HttpURLConnection)new URL(this.url).openConnection();
                    this.connection.setDoOutput(bl);
                    String string = UrlBuilder.getUserAgent();
                    if (string != null) {
                        this.connection.setRequestProperty("User-Agent", string);
                    }
                    this.connection.setConnectTimeout(2000);
                    this.connection.setReadTimeout(this.readTimeout);
                    this.connection.setRequestProperty("Connection", "close");
                    this.connection.setRequestProperty("Content-Type", "application/json");
                    this.connection.setRequestMethod("POST");
                    if (this.paramsJson != null) {
                        this.writer = new BufferedWriter((Writer)new OutputStreamWriter(this.connection.getOutputStream()));
                        this.writer.write(this.paramsJson);
                        this.writer.flush();
                    }
                    this.statusCode = this.connection.getResponseCode();
                    if (this.statusCode / 100 == 2) {
                        String string2;
                        this.headers = this.connection.getHeaderFields();
                        this.reader = new BufferedReader((Reader)new InputStreamReader(this.connection.getInputStream(), "UTF-8"));
                        StringBuilder stringBuilder = new StringBuilder();
                        while ((string2 = this.reader.readLine()) != null) {
                            stringBuilder.append(string2);
                        }
                        this.response = stringBuilder.toString();
                    } else {
                        String string3 = LOG_TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("HTTP/s error connecting to ");
                        stringBuilder.append(this.url);
                        stringBuilder.append(" Error code=");
                        stringBuilder.append(this.statusCode);
                        AerServLog.w(string3, stringBuilder.toString());
                    }
                }
                catch (Exception exception) {
                    String string = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error sending or reading HTTP/s request: ");
                    stringBuilder.append(this.url);
                    stringBuilder.append(" ");
                    stringBuilder.append(exception.getMessage());
                    AerServLog.w(string, stringBuilder.toString(), exception);
                    if (!(exception instanceof SocketTimeoutException)) break block10;
                    this.statusCode = 10001;
                }
            }
            catch (Throwable throwable22) {}
        }
        this.disconnect();
        if (this.connection != null) {
            return bl;
        }
        bl = false;
        return bl;
        this.disconnect();
        throw throwable22;
    }

    protected void onPostExecute(Boolean bl) {
        try {
            if (this.taskHandler != null) {
                if (bl.booleanValue() && this.statusCode == 200) {
                    this.taskHandler.onHttpTaskSuccess(this.url, this.statusCode, this.headers, this.response);
                    return;
                }
                this.taskHandler.onHttpTaskFailure(this.url, this.statusCode);
                return;
            }
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
        }
    }
}

