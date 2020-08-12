/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.h.g.a
 *  com.adincube.sdk.k.a.a
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package com.adincube.sdk.k.b.b;

import com.adincube.sdk.h.g.a;
import com.adincube.sdk.k.b.b.b;
import com.adincube.sdk.k.b.b.c;
import com.adincube.sdk.k.b.b.f;
import com.adincube.sdk.util.z;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class e
extends b {
    private List<f> c = null;

    public e(com.adincube.sdk.k.b.a.a a2, Node node) {
        super(a2, node);
    }

    @Override
    public final int a() {
        return c.a;
    }

    public final long c() {
        String string = z.d(this.b, "Duration");
        a a2 = string.contains((CharSequence)"%") ? null : a.b((String)string, (long)Long.MAX_VALUE);
        if (a2 != null) {
            return a2.a;
        }
        com.adincube.sdk.k.a.a a3 = com.adincube.sdk.k.a.a.a;
        StringBuilder stringBuilder = new StringBuilder("Time '");
        stringBuilder.append(string);
        stringBuilder.append("' cannot be parse into a valid duration.");
        throw new com.adincube.sdk.k.a.b(a3, stringBuilder.toString());
    }

    public final String d() {
        Node node = z.b(this.b, "VideoClicks");
        if (node == null) {
            return null;
        }
        return z.d(node, "ClickThrough");
    }

    public final List<String> e() {
        Node node = z.b(this.b, "VideoClicks");
        if (node == null) {
            return new ArrayList();
        }
        return z.c(node, "ClickTracking");
    }

    public final boolean f() {
        return this.g() != null;
    }

    public final String g() {
        String string = z.e(this.b, "skipoffset");
        if (string != null) {
            if (a.a((String)string, (long)Integer.MAX_VALUE) != null) {
                return string;
            }
            com.adincube.sdk.k.a.a a2 = com.adincube.sdk.k.a.a.a;
            StringBuilder stringBuilder = new StringBuilder("Offset '");
            stringBuilder.append(string);
            stringBuilder.append("' cannot be parsed into a valid duration.");
            throw new com.adincube.sdk.k.a.b(a2, stringBuilder.toString());
        }
        return string;
    }

    public final List<f> h() {
        if (this.c == null) {
            this.c = new ArrayList();
            NodeList nodeList = z.a(this.b, "MediaFiles/MediaFile");
            for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
                this.c.add((Object)new f(this, nodeList.item(i2)));
            }
        }
        return this.c;
    }
}

