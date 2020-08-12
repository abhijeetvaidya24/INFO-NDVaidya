/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  org.apache.http.Header
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.ProtocolVersion
 *  org.apache.http.StatusLine
 *  org.apache.http.entity.BasicHttpEntity
 *  org.apache.http.message.BasicHeader
 *  org.apache.http.message.BasicHttpResponse
 *  org.apache.http.message.BasicStatusLine
 */
package com.tappx.b.a;

import com.tappx.b.a.k;
import com.tappx.b.a.l;
import com.tappx.b.g;
import com.tappx.b.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public abstract class d
implements l {
    public abstract k a(n<?> var1, Map<String, String> var2);

    @Deprecated
    @Override
    public final HttpResponse b(n<?> n2, Map<String, String> map) {
        k k2 = this.a(n2, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse((StatusLine)new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), k2.a(), ""));
        ArrayList arrayList = new ArrayList();
        for (g g2 : k2.b()) {
            arrayList.add((Object)new BasicHeader(g2.a(), g2.b()));
        }
        basicHttpResponse.setHeaders((Header[])arrayList.toArray((Object[])new Header[arrayList.size()]));
        InputStream inputStream = k2.d();
        if (inputStream != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(inputStream);
            basicHttpEntity.setContentLength((long)k2.c());
            basicHttpResponse.setEntity((HttpEntity)basicHttpEntity);
        }
        return basicHttpResponse;
    }
}

