/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package com.adincube.sdk.k.b.a;

import android.annotation.SuppressLint;
import com.adincube.sdk.k.b.b.b;
import com.adincube.sdk.util.z;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressLint(value={"NewApi"})
public abstract class a {
    protected Node a;
    private List<String> b = null;
    private List<String> c = null;
    private List<b> d = null;

    public a(Node node) {
        this.a = node;
    }

    public final Integer a() {
        return z.f(this.a.getParentNode(), "sequence");
    }

    public final boolean a(int n2) {
        return !this.b(n2).isEmpty();
    }

    public final List<String> b() {
        if (this.b == null) {
            this.b = z.c(this.a, "Error");
        }
        return this.b;
    }

    public final List<b> b(int n2) {
        ArrayList arrayList = new ArrayList();
        for (b b2 : this.d()) {
            if (b2.a() != n2) continue;
            arrayList.add((Object)b2);
        }
        return arrayList;
    }

    public final List<String> c() {
        if (this.c == null) {
            this.c = z.c(this.a, "Impression");
        }
        return this.c;
    }

    public final List<b> d() {
        if (this.d == null) {
            this.d = new ArrayList();
            NodeList nodeList = z.a(this.a, "Creatives/Creative/Linear | Creatives/Creative/CompanionAds | Creatives/Creative/NonLinearAds");
            for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
                b b2 = b.a(this, nodeList.item(i2));
                if (b2 == null) continue;
                this.d.add((Object)b2);
            }
        }
        return this.d;
    }

    public abstract int e();
}

