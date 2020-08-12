/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.lang.Exception
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.ProtocolException
 *  java.net.SocketTimeoutException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.HashMap
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.amazon.device.ads;

import com.amazon.device.ads.HttpURLConnectionWebRequest;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class HttpURLConnectionWebRequest
extends WebRequest {
    private static final String LOGTAG = "HttpURLConnectionWebRequest";
    private HttpURLConnection connection;

    HttpURLConnectionWebRequest() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void writePostBody(HttpURLConnection var1_1) throws WebRequest.WebRequestException {
        block16 : {
            var2_2 = new StringBuilder();
            if (this.requestBody != null) {
                var2_2.append(this.requestBody);
            } else if (this.postParameters != null && !this.postParameters.isEmpty()) {
                for (Map.Entry var18_4 : this.postParameters.entrySet()) {
                    var2_2.append((String)var18_4.getKey());
                    var2_2.append("=");
                    var2_2.append(WebUtils.getURLEncodedString((String)var18_4.getValue()));
                    var2_2.append("&");
                }
                var2_2.deleteCharAt(var2_2.lastIndexOf("&"));
            }
            if (this.logRequestBodyEnabled && this.getRequestBody() != null) {
                var15_5 = this.logSessionIdEnabled == false ? this.getRequestBody().replaceAll(",\\s*\"\\s*sessionId\\s*\"\\s*:\\s*\".*?\"|\\s*\"\\s*sessionId\\s*\"\\s*:\\s*\".*?\"\\s*,*", "") : this.getRequestBody();
                this.getLogger().d("Request Body: %s", new Object[]{var15_5});
            }
            var3_6 = null;
            var4_7 = new OutputStreamWriter(var1_1.getOutputStream(), "UTF-8");
            var4_7.write(var2_2.toString());
            try {
                var4_7.close();
                return;
            }
            catch (IOException var12_8) {
                var13_9 = this.getLogger();
                var14_10 = new Object[]{var12_8.getMessage()};
                var13_9.e("Problem while closing output stream writer for request body: %s", var14_10);
                throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Problem while closing output stream writer for request body", var12_8);
            }
            catch (Throwable var8_11) {
                var3_6 = var4_7;
                break block16;
            }
            catch (IOException var5_14) {
                var3_6 = var4_7;
                ** GOTO lbl-1000
            }
            catch (Throwable var8_12) {
                break block16;
            }
            catch (IOException var5_15) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                var6_17 = this.getLogger();
                var7_18 = new Object[]{var5_16.getMessage()};
                var6_17.e("Problem while creating output steam for request body: %s", var7_18);
                throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Problem while creating output steam for request body", (Throwable)var5_16);
            }
        }
        if (var3_6 == null) throw var8_13;
        try {
            var3_6.close();
            throw var8_13;
        }
        catch (IOException var9_19) {
            var10_20 = this.getLogger();
            var11_21 = new Object[]{var9_19.getMessage()};
            var10_20.e("Problem while closing output stream writer for request body: %s", var11_21);
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Problem while closing output stream writer for request body", var9_19);
        }
    }

    @Override
    protected void closeConnection() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.connection = null;
        }
    }

    @Override
    protected WebRequest.WebResponse doHttpNetworkCall(URL uRL) throws WebRequest.WebRequestException {
        if (this.connection != null) {
            this.closeConnection();
        }
        try {
            this.connection = this.openConnection(uRL);
        }
        catch (IOException iOException) {
            MobileAdsLogger mobileAdsLogger = this.getLogger();
            Object[] arrobject = new Object[]{iOException.getMessage()};
            mobileAdsLogger.e("Problem while opening the URL connection: %s", arrobject);
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Problem while opening the URL connection", iOException);
        }
        this.setupRequestProperties(this.connection);
        try {
            this.connection.connect();
        }
        catch (Exception exception) {
            MobileAdsLogger mobileAdsLogger = this.getLogger();
            Object[] arrobject = new Object[]{exception.getMessage()};
            mobileAdsLogger.e("Problem while connecting to URL: %s", arrobject);
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "Probem while connecting to URL", exception);
        }
        catch (SocketTimeoutException socketTimeoutException) {
            MobileAdsLogger mobileAdsLogger = this.getLogger();
            Object[] arrobject = new Object[]{socketTimeoutException.getMessage()};
            mobileAdsLogger.e("Socket timed out while connecting to URL: %s", arrobject);
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_TIMEOUT, "Socket timed out while connecting to URL", socketTimeoutException);
        }
        return this.prepareResponse(this.connection);
    }

    @Override
    protected String getSubLogTag() {
        return LOGTAG;
    }

    protected HttpURLConnection openConnection(URL uRL) throws IOException {
        return (HttpURLConnection)uRL.openConnection();
    }

    protected WebRequest.WebResponse prepareResponse(HttpURLConnection httpURLConnection) throws WebRequest.WebRequestException {
        WebRequest.WebResponse webResponse = new WebRequest.WebResponse(this);
        try {
            webResponse.setHttpStatusCode(httpURLConnection.getResponseCode());
            webResponse.setHttpStatus(httpURLConnection.getResponseMessage());
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            MobileAdsLogger mobileAdsLogger = this.getLogger();
            Object[] arrobject = new Object[]{indexOutOfBoundsException.getMessage()};
            mobileAdsLogger.e("IndexOutOfBoundsException while getting the response status code: %s", arrobject);
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.MALFORMED_URL, "IndexOutOfBoundsException while getting the response status code", indexOutOfBoundsException);
        }
        catch (IOException iOException) {
            MobileAdsLogger mobileAdsLogger = this.getLogger();
            Object[] arrobject = new Object[]{iOException.getMessage()};
            mobileAdsLogger.e("IOException while getting the response status code: %s", arrobject);
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException while getting the response status code", iOException);
        }
        catch (SocketTimeoutException socketTimeoutException) {
            MobileAdsLogger mobileAdsLogger = this.getLogger();
            Object[] arrobject = new Object[]{socketTimeoutException.getMessage()};
            mobileAdsLogger.e("Socket Timeout while getting the response status code: %s", arrobject);
            throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_TIMEOUT, "Socket Timeout while getting the response status code", socketTimeoutException);
        }
        if (webResponse.getHttpStatusCode() == 200) {
            try {
                webResponse.setInputStream(httpURLConnection.getInputStream());
                return webResponse;
            }
            catch (IOException iOException) {
                MobileAdsLogger mobileAdsLogger = this.getLogger();
                Object[] arrobject = new Object[]{iOException.getMessage()};
                mobileAdsLogger.e("IOException while reading the input stream from response: %s", arrobject);
                throw new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.NETWORK_FAILURE, "IOException while reading the input stream from response", iOException);
            }
        }
        return webResponse;
    }

    protected void setupRequestProperties(HttpURLConnection httpURLConnection) throws WebRequest.WebRequestException {
        try {
            httpURLConnection.setRequestMethod(this.getHttpMethod().name());
        }
        catch (ProtocolException protocolException) {
            WebRequest.WebRequestException webRequestException;
            MobileAdsLogger mobileAdsLogger = this.getLogger();
            Object[] arrobject = new Object[]{protocolException.getMessage()};
            mobileAdsLogger.e("Invalid client protocol: %s", arrobject);
            webRequestException = new WebRequest.WebRequestException(this, WebRequest.WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", protocolException);
            throw webRequestException;
        }
        for (Map.Entry entry : this.headers.entrySet()) {
            if (entry.getValue() == null || ((String)entry.getValue()).equals((Object)"")) continue;
            httpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
        }
        httpURLConnection.setConnectTimeout(this.getTimeout());
        httpURLConnection.setReadTimeout(this.getTimeout());
        this.logUrl(httpURLConnection.getURL().toString());
        int n2 = 1.$SwitchMap$com$amazon$device$ads$WebRequest$HttpMethod[this.getHttpMethod().ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                return;
            }
            httpURLConnection.setDoOutput(true);
            this.writePostBody(httpURLConnection);
            return;
        }
        httpURLConnection.setDoOutput(false);
        return;
    }
}

