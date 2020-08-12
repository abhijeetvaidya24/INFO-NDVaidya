/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.k.b.b.a
 *  com.adincube.sdk.k.b.b.e
 *  com.adincube.sdk.k.b.b.h
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package com.adincube.sdk.k.b.b;

import com.adincube.sdk.k.b.b.a;
import com.adincube.sdk.k.b.b.d;
import com.adincube.sdk.k.b.b.e;
import com.adincube.sdk.k.b.b.h;
import com.adincube.sdk.k.b.b.i;
import com.adincube.sdk.util.z;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class b {
    public com.adincube.sdk.k.b.a.a a;
    protected Node b;
    private List<i> c;

    protected b(com.adincube.sdk.k.b.a.a a2, Node node) {
        this.a = a2;
        this.b = node;
    }

    public static b a(com.adincube.sdk.k.b.a.a a2, Node node) {
        if ("Linear".equals((Object)node.getNodeName())) {
            return new e(a2, node);
        }
        if ("NonLinear".equals((Object)node.getNodeName())) {
            return new h(a2, node);
        }
        if ("CompanionAds".equals((Object)node.getNodeName())) {
            return new a(a2, node);
        }
        return null;
    }

    public abstract int a();

    public final List<i> b() {
        if (this.c == null) {
            this.c = new ArrayList();
            NodeList nodeList = z.a(this.b, "TrackingEvents/Tracking");
            for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
                Node node = nodeList.item(i2);
                d d2 = d.a(z.e(node, "event"));
                i i3 = d2 == d.v ? null : new i(d2, node);
                if (i3 == null) continue;
                this.c.add((Object)i3);
            }
        }
        return this.c;
    }
}

