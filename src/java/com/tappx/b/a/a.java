/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.SocketTimeoutException
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  org.apache.http.Header
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.StatusLine
 *  org.apache.http.conn.ConnectTimeoutException
 */
package com.tappx.b.a;

import com.tappx.b.a.d;
import com.tappx.b.a.k;
import com.tappx.b.a.l;
import com.tappx.b.g;
import com.tappx.b.n;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;

class a
extends d {
    private final l a;

    a(l l2) {
        this.a = l2;
    }

    @Override
    public k a(n<?> n2, Map<String, String> map) {
        HttpResponse httpResponse;
        try {
            httpResponse = this.a.b(n2, map);
        }
        catch (ConnectTimeoutException connectTimeoutException) {
            SocketTimeoutException socketTimeoutException;
            socketTimeoutException = new SocketTimeoutException(connectTimeoutException.getMessage());
            throw socketTimeoutException;
        }
        int n3 = httpResponse.getStatusLine().getStatusCode();
        Header[] arrheader = httpResponse.getAllHeaders();
        ArrayList arrayList = new ArrayList(arrheader.length);
        for (Header header : arrheader) {
            arrayList.add((Object)new g(header.getName(), header.getValue()));
        }
        if (httpResponse.getEntity() == null) {
            return new k(n3, (List<g>)arrayList);
        }
        long l2 = httpResponse.getEntity().getContentLength();
        if ((long)((int)l2) == l2) {
            return new k(n3, (List<g>)arrayList, (int)httpResponse.getEntity().getContentLength(), httpResponse.getEntity().getContent());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response too large: ");
        stringBuilder.append(l2);
        throw new IOException(stringBuilder.toString());
    }
}

