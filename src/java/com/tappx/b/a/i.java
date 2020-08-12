/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.NameValuePair
 *  org.apache.http.client.HttpClient
 *  org.apache.http.client.methods.HttpDelete
 *  org.apache.http.client.methods.HttpEntityEnclosingRequestBase
 *  org.apache.http.client.methods.HttpGet
 *  org.apache.http.client.methods.HttpHead
 *  org.apache.http.client.methods.HttpOptions
 *  org.apache.http.client.methods.HttpPost
 *  org.apache.http.client.methods.HttpPut
 *  org.apache.http.client.methods.HttpTrace
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.entity.ByteArrayEntity
 *  org.apache.http.message.BasicNameValuePair
 *  org.apache.http.params.HttpConnectionParams
 *  org.apache.http.params.HttpParams
 */
package com.tappx.b.a;

import com.tappx.b.a.l;
import com.tappx.b.n;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

@Deprecated
public class i
implements l {
    private static final String b = "Content-Type";
    protected final HttpClient a;

    public i(HttpClient httpClient) {
        this.a = httpClient;
    }

    private static List<NameValuePair> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String string : map.keySet()) {
            arrayList.add((Object)new BasicNameValuePair(string, (String)map.get((Object)string)));
        }
        return arrayList;
    }

    static HttpUriRequest a(n<?> n2, Map<String, String> map) {
        switch (n2.f()) {
            default: {
                throw new IllegalStateException("Unknown request method.");
            }
            case 7: {
                HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase = new HttpEntityEnclosingRequestBase(n2.k()){
                    public static final String a = "PATCH";
                    {
                        this.setURI(URI.create((String)string));
                    }
                    {
                        this.setURI(uRI);
                    }

                    public String getMethod() {
                        return a;
                    }
                };
                httpEntityEnclosingRequestBase.addHeader(b, n2.u());
                i.a(httpEntityEnclosingRequestBase, n2);
                return httpEntityEnclosingRequestBase;
            }
            case 6: {
                return new HttpTrace(n2.k());
            }
            case 5: {
                return new HttpOptions(n2.k());
            }
            case 4: {
                return new HttpHead(n2.k());
            }
            case 3: {
                return new HttpDelete(n2.k());
            }
            case 2: {
                HttpPut httpPut = new HttpPut(n2.k());
                httpPut.addHeader(b, n2.u());
                i.a((HttpEntityEnclosingRequestBase)httpPut, n2);
                return httpPut;
            }
            case 1: {
                HttpPost httpPost = new HttpPost(n2.k());
                httpPost.addHeader(b, n2.u());
                i.a((HttpEntityEnclosingRequestBase)httpPost, n2);
                return httpPost;
            }
            case 0: {
                return new HttpGet(n2.k());
            }
            case -1: 
        }
        byte[] arrby = n2.b();
        if (arrby != null) {
            HttpPost httpPost = new HttpPost(n2.k());
            httpPost.addHeader(b, n2.r());
            httpPost.setEntity((HttpEntity)new ByteArrayEntity(arrby));
            return httpPost;
        }
        return new HttpGet(n2.k());
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, n<?> n2) {
        byte[] arrby = n2.a();
        if (arrby != null) {
            httpEntityEnclosingRequestBase.setEntity((HttpEntity)new ByteArrayEntity(arrby));
        }
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String string : map.keySet()) {
            httpUriRequest.setHeader(string, (String)map.get((Object)string));
        }
    }

    protected void a(HttpUriRequest httpUriRequest) {
    }

    @Override
    public HttpResponse b(n<?> n2, Map<String, String> map) {
        HttpUriRequest httpUriRequest = i.a(n2, map);
        i.a(httpUriRequest, map);
        i.a(httpUriRequest, n2.c());
        this.a(httpUriRequest);
        HttpParams httpParams = httpUriRequest.getParams();
        int n3 = n2.x();
        HttpConnectionParams.setConnectionTimeout((HttpParams)httpParams, (int)5000);
        HttpConnectionParams.setSoTimeout((HttpParams)httpParams, (int)n3);
        return this.a.execute(httpUriRequest);
    }

}

