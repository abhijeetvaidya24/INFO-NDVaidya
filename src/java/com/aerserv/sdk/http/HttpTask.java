/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  java.io.InputStream
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
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.http.HttpTaskListener;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.IOUtils;
import com.aerserv.sdk.utils.UrlBuilder;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpTask
extends AsyncTask<Object, Void, Boolean> {
    private static final String LOG_TAG = "HttpTask";
    private final int connectTimeout = 2000;
    private HttpURLConnection connection = null;
    private Map<String, List<String>> headers;
    private InputStream inputStream = null;
    private int readTimeout = AerServSettings.getHttpTimeout() - 2000;
    private String response;
    private int statusCode;
    private HttpTaskListener taskHandler;
    private String url;

    public HttpTask(String string, HttpTaskListener httpTaskListener) {
        this.taskHandler = httpTaskListener;
        this.url = string;
    }

    public HttpTask(String string, HttpTaskListener httpTaskListener, int n2) {
        this.taskHandler = httpTaskListener;
        this.url = string;
        this.readTimeout = n2;
    }

    /*
     * Exception decompiling
     */
    public void disconnect() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl11 : ALOAD_0 : trying to set 1 previously set to 0
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
        Throwable throwable22;
        block8 : {
            String string = this.url;
            if (string == null) return false;
            if (string.length() < 4) {
                return false;
            }
            try {
                try {
                    if (!this.url.startsWith("http")) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("http://");
                        stringBuilder.append(this.url);
                        this.url = stringBuilder.toString();
                    }
                    this.connection = (HttpURLConnection)new URL(this.url).openConnection();
                    String string2 = UrlBuilder.getUserAgent();
                    if (string2 != null) {
                        this.connection.setRequestProperty("User-Agent", string2);
                    }
                    this.connection.setRequestProperty("Connection", "close");
                    this.connection.setConnectTimeout(2000);
                    this.connection.setReadTimeout(this.readTimeout);
                    this.connection.connect();
                    this.statusCode = this.connection.getResponseCode();
                    if (this.statusCode == 200) {
                        this.inputStream = this.connection.getInputStream();
                        this.headers = this.connection.getHeaderFields();
                        this.response = IOUtils.inputStreamToString(this.inputStream, "UTF-8");
                    }
                }
                catch (Exception exception) {
                    String string3 = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Exception caught for the following url: ");
                    stringBuilder.append(this.url);
                    AerServLog.d(string3, stringBuilder.toString(), exception);
                    if (!(exception instanceof SocketTimeoutException)) break block8;
                    this.statusCode = 10001;
                }
            }
            catch (Throwable throwable22) {}
        }
        this.disconnect();
        HttpURLConnection httpURLConnection = this.connection;
        boolean bl = false;
        if (httpURLConnection == null) return bl;
        bl = true;
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

