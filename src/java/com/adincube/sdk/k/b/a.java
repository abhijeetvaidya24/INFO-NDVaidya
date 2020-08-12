/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  com.adincube.sdk.k.b.a.c
 *  com.adincube.sdk.k.b.a.d
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package com.adincube.sdk.k.b;

import android.annotation.SuppressLint;
import com.adincube.sdk.k.b.a.c;
import com.adincube.sdk.k.b.a.d;
import com.adincube.sdk.util.z;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressLint(value={"NewApi"})
public final class a {
    private Node a;
    private List<com.adincube.sdk.k.b.a.a> b = null;

    public a(Node node) {
        this.a = node;
    }

    public final List<com.adincube.sdk.k.b.a.a> a() {
        if (this.b == null) {
            this.b = new ArrayList();
            NodeList nodeList = z.a(this.a, "Ad/InLine | Ad/Wrapper");
            for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
                Node node = nodeList.item(i2);
                Object object = "InLine".equals((Object)node.getNodeName()) ? new c(node) : ("Wrapper".equals((Object)node.getNodeName()) ? new d(node) : null);
                if (object == null) continue;
                this.b.add(object);
            }
        }
        return this.b;
    }

    public final List<com.adincube.sdk.k.b.a.a> a(int n2) {
        ArrayList arrayList = new ArrayList();
        for (com.adincube.sdk.k.b.a.a a2 : this.a()) {
            if (a2.e() != n2 || a2.a() != null) continue;
            arrayList.add((Object)a2);
        }
        return arrayList;
    }
}

