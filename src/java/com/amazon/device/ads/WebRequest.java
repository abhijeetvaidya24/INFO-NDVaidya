/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.HttpURLConnectionWebRequest
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.MalformedURLException
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.util.HashMap
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.amazon.device.ads;

import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.HttpURLConnectionWebRequest;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ResponseReader;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebUtils2;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class WebRequest {
    private static final String CHARSET_KEY = "charset";
    public static final String CHARSET_UTF_16 = "UTF-16";
    public static final String CHARSET_UTF_8 = "UTF-8";
    public static final String CONTENT_TYPE_CSS = "text/css";
    public static final String CONTENT_TYPE_HTML = "text/html";
    public static final String CONTENT_TYPE_JAVASCRIPT = "application/javascript";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_PLAIN_TEXT = "text/plain";
    public static final int DEFAULT_PORT = -1;
    public static final int DEFAULT_TIMEOUT = 20000;
    private static final String HEADER_ACCEPT_KEY = "Accept";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String LOGTAG = "WebRequest";
    String acceptContentType = null;
    String charset = null;
    String contentType = null;
    private boolean disconnectEnabled = true;
    protected final HashMap<String, String> headers = new HashMap();
    private HttpMethod httpMethod = HttpMethod.GET;
    boolean logRequestBodyEnabled = false;
    boolean logResponseEnabled = false;
    boolean logSessionIdEnabled = false;
    private String logTag = LOGTAG;
    protected boolean logUrlEnabled = false;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(this.logTag);
    private MetricsCollector metricsCollector;
    private String nonSecureHost = null;
    private String path = null;
    private int port = -1;
    protected HashMap<String, String> postParameters = new HashMap();
    protected QueryStringParameters queryStringParameters = new QueryStringParameters();
    String requestBody = null;
    protected boolean secure = Settings.getInstance().getBoolean("tlsEnabled", false);
    private String secureHost = null;
    protected Metrics.MetricType serviceCallLatencyMetric;
    private int timeout = 20000;
    private String urlString = null;

    WebRequest() {
    }

    private String getLogTag() {
        return this.logTag;
    }

    protected void appendQuery(StringBuilder stringBuilder) {
        this.queryStringParameters.append(stringBuilder);
    }

    protected abstract void closeConnection();

    public void convertToJSONPostRequest() {
        this.setHttpMethod(HttpMethod.POST);
        this.putHeader("Accept", "application/json");
        this.putHeader("Content-Type", "application/json; charset=UTF-8");
    }

    protected URI createURI(String string) throws MalformedURLException, URISyntaxException {
        return this.createURI(this.createURL(string));
    }

    protected URI createURI(URL uRL) throws URISyntaxException {
        return uRL.toURI();
    }

    protected URL createURL(String string) throws MalformedURLException {
        return new URL(string);
    }

    protected URI createUri() throws URISyntaxException, MalformedURLException {
        return new URL(this.getUrlString()).toURI();
    }

    protected abstract WebResponse doHttpNetworkCall(URL var1) throws WebRequestException;

    public void enableLog(boolean bl) {
        this.enableLogUrl(bl);
        this.enableLogRequestBody(bl);
        this.enableLogResponse(bl);
    }

    public void enableLogRequestBody(boolean bl) {
        this.logRequestBodyEnabled = bl;
    }

    public void enableLogResponse(boolean bl) {
        this.logResponseEnabled = bl;
    }

    public void enableLogSessionID(boolean bl) {
        this.logSessionIdEnabled = bl;
    }

    public void enableLogUrl(boolean bl) {
        this.logUrlEnabled = bl;
    }

    public String getAcceptContentType() {
        return this.acceptContentType;
    }

    public String getCharset() {
        return this.charset;
    }

    public String getContentType() {
        return this.contentType;
    }

    public boolean getDisconnectEnabled() {
        return this.disconnectEnabled;
    }

    public String getHeader(String string) {
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            return (String)this.headers.get((Object)string);
        }
        throw new IllegalArgumentException("The name must not be null or empty string.");
    }

    public String getHost() {
        if (this.getUseSecure()) {
            return this.secureHost;
        }
        return this.nonSecureHost;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    protected MobileAdsLogger getLogger() {
        return this.logger;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public String getPostParameter(String string) {
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            return (String)this.postParameters.get((Object)string);
        }
        throw new IllegalArgumentException("The name must not be null or empty string.");
    }

    public String getQueryParameter(String string) {
        return this.queryStringParameters.get(string);
    }

    public String getRequestBody() {
        if (this.getRequestBodyString() != null) {
            return this.getRequestBodyString();
        }
        if (this.postParameters.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : this.postParameters.entrySet()) {
            stringBuilder.append((String)entry.getKey());
            stringBuilder.append('=');
            stringBuilder.append((String)entry.getValue());
            stringBuilder.append(";\n");
        }
        return stringBuilder.toString();
    }

    public String getRequestBodyString() {
        return this.requestBody;
    }

    protected String getScheme() {
        if (this.getUseSecure()) {
            return "https";
        }
        return "http";
    }

    protected abstract String getSubLogTag();

    public int getTimeout() {
        return this.timeout;
    }

    protected String getUrl() {
        String string = this.urlString;
        if (string != null) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(this.getScheme());
        stringBuilder.append("://");
        stringBuilder.append(this.getHost());
        if (this.getPort() != -1) {
            stringBuilder.append(":");
            stringBuilder.append(this.getPort());
        }
        stringBuilder.append(this.getPath());
        this.appendQuery(stringBuilder);
        return stringBuilder.toString();
    }

    public String getUrlString() {
        return this.urlString;
    }

    public boolean getUseSecure() {
        return DebugProperties.getInstance().getDebugPropertyAsBoolean("debug.useSecure", this.secure);
    }

    protected void logUrl(String string) {
        if (this.logUrlEnabled) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{this.getHttpMethod(), string};
            mobileAdsLogger.d("%s %s", arrobject);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public WebResponse makeCall() throws WebRequestException {
        Throwable throwable2222;
        URL uRL;
        if (ThreadUtils.isOnMainThread()) {
            this.logger.e("The network request should not be performed on the main thread.");
        }
        this.setContentTypeHeaders();
        String string = this.getUrl();
        try {
            uRL = this.createURL(string);
        }
        catch (MalformedURLException malformedURLException) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{malformedURLException.getMessage()};
            mobileAdsLogger.e("Problem with URI syntax: %s", arrobject);
            WebRequestStatus webRequestStatus = WebRequestStatus.MALFORMED_URL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not construct URL from String ");
            stringBuilder.append(string);
            throw new WebRequestException(webRequestStatus, stringBuilder.toString(), malformedURLException);
        }
        this.writeMetricStart(this.serviceCallLatencyMetric);
        WebResponse webResponse = this.doHttpNetworkCall(uRL);
        this.writeMetricStop(this.serviceCallLatencyMetric);
        if (!this.logResponseEnabled) return webResponse;
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{webResponse.getHttpStatusCode(), webResponse.getHttpStatus()};
        mobileAdsLogger.d("Response: %s %s", arrobject);
        return webResponse;
        {
            catch (Throwable throwable2222) {
            }
            catch (WebRequestException webRequestException) {}
            {
                throw webRequestException;
            }
        }
        this.writeMetricStop(this.serviceCallLatencyMetric);
        throw throwable2222;
    }

    public void putHeader(String string, String string2) {
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            this.headers.put((Object)string, (Object)string2);
            return;
        }
        throw new IllegalArgumentException("The name must not be null or empty string.");
    }

    public void putPostParameter(String string, String string2) {
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            if (string2 == null) {
                this.postParameters.remove((Object)string);
                return;
            }
            this.postParameters.put((Object)string, (Object)string2);
            return;
        }
        throw new IllegalArgumentException("The name must not be null or empty string.");
    }

    public String putUnencodedQueryParameter(String string, String string2) {
        return this.queryStringParameters.putUnencoded(string, string2);
    }

    public void putUrlEncodedQueryParameter(String string, String string2) {
        this.queryStringParameters.putUrlEncoded(string, string2);
    }

    public void setAcceptContentType(String string) {
        this.acceptContentType = this.contentType;
    }

    public void setAdditionalQueryParamsString(String string) {
        this.queryStringParameters.setRawAppendage(string);
    }

    public void setCharset(String string) {
        this.charset = string;
    }

    public void setContentType(String string) {
        this.contentType = string;
    }

    protected void setContentTypeHeaders() {
        String string;
        if (this.acceptContentType != null) {
            this.putHeader("Accept", this.contentType);
        }
        if ((string = this.contentType) != null) {
            if (this.charset != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("; charset=");
                stringBuilder.append(this.charset);
                string = stringBuilder.toString();
            }
            this.putHeader("Content-Type", string);
        }
    }

    public void setDisconnectEnabled(boolean bl) {
        this.disconnectEnabled = bl;
    }

    public void setExternalLogTag(String string) {
        if (string == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LOGTAG);
            stringBuilder.append(" ");
            stringBuilder.append(this.getSubLogTag());
            this.logTag = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" ");
            stringBuilder.append(LOGTAG);
            stringBuilder.append(" ");
            stringBuilder.append(this.getSubLogTag());
            this.logTag = stringBuilder.toString();
        }
        this.logger.withLogTag(this.logTag);
    }

    public void setHost(String string) {
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            this.secureHost = string;
            this.nonSecureHost = string;
            return;
        }
        throw new IllegalArgumentException("The host must not be null.");
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        if (httpMethod != null) {
            this.httpMethod = httpMethod;
            return;
        }
        throw new IllegalArgumentException("The httpMethod must not be null.");
    }

    public void setMetricsCollector(MetricsCollector metricsCollector) {
        this.metricsCollector = metricsCollector;
    }

    public void setNonSecureHost(String string) {
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            this.nonSecureHost = string;
            return;
        }
        throw new IllegalArgumentException("The host must not be null.");
    }

    public void setPath(String string) {
        if (string.charAt(0) != '/') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('/');
            stringBuilder.append(string);
            this.path = stringBuilder.toString();
            return;
        }
        this.path = string;
    }

    public void setPort(int n) {
        this.port = n;
    }

    public void setQueryStringParameters(QueryStringParameters queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
    }

    public void setRequestBodyString(String string) {
        this.requestBody = string;
    }

    public void setSecureHost(String string) {
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            this.secureHost = string;
            return;
        }
        throw new IllegalArgumentException("The host must not be null.");
    }

    public void setServiceCallLatencyMetric(Metrics.MetricType metricType) {
        this.serviceCallLatencyMetric = metricType;
    }

    public void setTimeout(int n) {
        this.timeout = n;
    }

    public void setUrlString(String string) {
        if (string != null && this.getUseSecure() && string.startsWith("http:")) {
            string = string.replaceFirst("http", "https");
        }
        this.urlString = string;
    }

    public void setUseSecure(boolean bl) {
        this.secure = bl;
    }

    public String toString() {
        return this.getUrl();
    }

    protected void writeMetricStart(Metrics.MetricType metricType) {
        MetricsCollector metricsCollector;
        if (metricType != null && (metricsCollector = this.metricsCollector) != null) {
            metricsCollector.startMetric(metricType);
        }
    }

    protected void writeMetricStop(Metrics.MetricType metricType) {
        MetricsCollector metricsCollector;
        if (metricType != null && (metricsCollector = this.metricsCollector) != null) {
            metricsCollector.stopMetric(metricType);
        }
    }

    public static final class HttpMethod
    extends Enum<HttpMethod> {
        private static final /* synthetic */ HttpMethod[] $VALUES;
        public static final /* enum */ HttpMethod GET = new HttpMethod("GET");
        public static final /* enum */ HttpMethod POST = new HttpMethod("POST");
        private final String methodString;

        static {
            HttpMethod[] arrhttpMethod = new HttpMethod[]{GET, POST};
            $VALUES = arrhttpMethod;
        }

        private HttpMethod(String string2) {
            this.methodString = string2;
        }

        public static HttpMethod valueOf(String string) {
            return (HttpMethod)Enum.valueOf(HttpMethod.class, (String)string);
        }

        public static HttpMethod[] values() {
            return (HttpMethod[])$VALUES.clone();
        }

        public String toString() {
            return this.methodString;
        }
    }

    static class QueryStringParameters {
        private final HashMap<String, String> params = new HashMap();
        private String rawAppendage;

        QueryStringParameters() {
        }

        void append(StringBuilder stringBuilder) {
            if (this.size() == 0 && StringUtils.isNullOrEmpty(this.rawAppendage)) {
                return;
            }
            stringBuilder.append("?");
            boolean bl = true;
            for (Map.Entry entry : this.params.entrySet()) {
                if (bl) {
                    bl = false;
                } else {
                    stringBuilder.append("&");
                }
                stringBuilder.append((String)entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String)entry.getValue());
            }
            String string = this.rawAppendage;
            if (string != null && !string.equals((Object)"")) {
                if (this.size() != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(this.rawAppendage);
            }
        }

        String get(String string) {
            if (!StringUtils.isNullOrWhiteSpace(string)) {
                return (String)this.params.get((Object)string);
            }
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }

        String putUnencoded(String string, String string2) {
            WebUtils2 webUtils2 = new WebUtils2();
            String string3 = webUtils2.getURLEncodedString(string);
            this.putUrlEncoded(string3, webUtils2.getURLEncodedString(string2));
            return string3;
        }

        void putUrlEncoded(String string, String string2) {
            if (!StringUtils.isNullOrWhiteSpace(string)) {
                if (string2 == null) {
                    this.params.remove((Object)string);
                    return;
                }
                this.params.put((Object)string, (Object)string2);
                return;
            }
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }

        void putUrlEncoded(String string, boolean bl) {
            this.putUrlEncoded(string, Boolean.toString((boolean)bl));
        }

        void putUrlEncodedIfNotNullOrEmpty(String string, String string2) {
            this.putUrlEncodedIfTrue(string, string2, true ^ StringUtils.isNullOrEmpty(string2));
        }

        void putUrlEncodedIfTrue(String string, String string2, boolean bl) {
            if (bl) {
                this.putUrlEncoded(string, string2);
            }
        }

        void setRawAppendage(String string) {
            this.rawAppendage = string;
        }

        int size() {
            return this.params.size();
        }
    }

    public class WebRequestException
    extends Exception {
        private static final long serialVersionUID = -4980265484926465548L;
        private final WebRequestStatus status;

        protected WebRequestException(WebRequestStatus webRequestStatus, String string) {
            this(webRequestStatus, string, null);
        }

        protected WebRequestException(WebRequestStatus webRequestStatus, String string, Throwable throwable) {
            super(string, throwable);
            this.status = webRequestStatus;
        }

        public WebRequestStatus getStatus() {
            return this.status;
        }
    }

    public static class WebRequestFactory {
        public WebRequest createJSONGetWebRequest() {
            WebRequest webRequest = this.createWebRequest();
            webRequest.setHttpMethod(HttpMethod.GET);
            webRequest.putHeader(WebRequest.HEADER_ACCEPT_KEY, WebRequest.CONTENT_TYPE_JSON);
            return webRequest;
        }

        public WebRequest createJSONPostWebRequest() {
            WebRequest webRequest = this.createWebRequest();
            webRequest.convertToJSONPostRequest();
            return webRequest;
        }

        public WebRequest createWebRequest() {
            return new HttpURLConnectionWebRequest();
        }
    }

    class WebRequestInputStream
    extends InputStream {
        private final InputStream decoratedStream;

        public WebRequestInputStream(InputStream inputStream) {
            this.decoratedStream = inputStream;
        }

        public void close() throws IOException {
            this.decoratedStream.close();
            if (WebRequest.this.disconnectEnabled) {
                WebRequest.this.closeConnection();
            }
        }

        public int read() throws IOException {
            return this.decoratedStream.read();
        }
    }

    public static final class WebRequestStatus
    extends Enum<WebRequestStatus> {
        private static final /* synthetic */ WebRequestStatus[] $VALUES;
        public static final /* enum */ WebRequestStatus INVALID_CLIENT_PROTOCOL;
        public static final /* enum */ WebRequestStatus MALFORMED_URL;
        public static final /* enum */ WebRequestStatus NETWORK_FAILURE;
        public static final /* enum */ WebRequestStatus NETWORK_TIMEOUT;
        public static final /* enum */ WebRequestStatus UNSUPPORTED_ENCODING;

        static {
            NETWORK_FAILURE = new WebRequestStatus();
            NETWORK_TIMEOUT = new WebRequestStatus();
            MALFORMED_URL = new WebRequestStatus();
            INVALID_CLIENT_PROTOCOL = new WebRequestStatus();
            UNSUPPORTED_ENCODING = new WebRequestStatus();
            WebRequestStatus[] arrwebRequestStatus = new WebRequestStatus[]{NETWORK_FAILURE, NETWORK_TIMEOUT, MALFORMED_URL, INVALID_CLIENT_PROTOCOL, UNSUPPORTED_ENCODING};
            $VALUES = arrwebRequestStatus;
        }

        public static WebRequestStatus valueOf(String string) {
            return (WebRequestStatus)Enum.valueOf(WebRequestStatus.class, (String)string);
        }

        public static WebRequestStatus[] values() {
            return (WebRequestStatus[])$VALUES.clone();
        }
    }

    public class WebResponse {
        private String httpStatus;
        private int httpStatusCode;
        private WebRequestInputStream inputStream;

        protected WebResponse() {
        }

        public String getHttpStatus() {
            return this.httpStatus;
        }

        public int getHttpStatusCode() {
            return this.httpStatusCode;
        }

        public ResponseReader getResponseReader() {
            ResponseReader responseReader = new ResponseReader(this.inputStream);
            responseReader.enableLog(WebRequest.this.logResponseEnabled);
            responseReader.setExternalLogTag(WebRequest.this.getLogTag());
            return responseReader;
        }

        public boolean isHttpStatusCodeOK() {
            return this.getHttpStatusCode() == 200;
        }

        protected void setHttpStatus(String string) {
            this.httpStatus = string;
        }

        protected void setHttpStatusCode(int n) {
            this.httpStatusCode = n;
        }

        protected void setInputStream(InputStream inputStream) {
            this.inputStream = new WebRequestInputStream(inputStream);
        }
    }

}

