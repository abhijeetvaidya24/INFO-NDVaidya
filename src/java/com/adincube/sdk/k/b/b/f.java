/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.w3c.dom.Node
 */
package com.adincube.sdk.k.b.b;

import android.annotation.SuppressLint;
import com.adincube.sdk.k.b.b.b;
import com.adincube.sdk.k.b.b.g;
import com.adincube.sdk.util.z;
import org.w3c.dom.Node;

@SuppressLint(value={"NewApi"})
public final class f {
    public b a;
    private Node b;

    public f(b b2, Node node) {
        this.a = b2;
        this.b = node;
    }

    public final g a() {
        try {
            g g2 = g.a(z.e(this.b, "delivery"));
            return g2;
        }
        catch (Throwable throwable) {
            return g.c;
        }
    }

    public final String b() {
        return z.e(this.b, "type");
    }

    public final Integer c() {
        return z.f(this.b, "width");
    }

    public final Integer d() {
        return z.f(this.b, "height");
    }

    public final Integer e() {
        return z.f(this.b, "bitrate");
    }

    public final String f() {
        return z.a(this.b.getTextContent());
    }
}

