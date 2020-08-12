/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 */
package com.b.a.a.a.b;

import android.webkit.WebView;
import com.b.a.a.a.b.e;
import com.b.a.a.a.b.g;
import com.b.a.a.a.b.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class d {
    private final g a;
    private final WebView b;
    private final List<h> c = new ArrayList();
    private final String d;
    private final String e;
    private final e f;

    private d(g g2, WebView webView, String string2, List<h> list, String string3) {
        e e2;
        this.a = g2;
        this.b = webView;
        this.d = string2;
        if (list != null) {
            this.c.addAll(list);
            e2 = e.b;
        } else {
            e2 = e.a;
        }
        this.f = e2;
        this.e = string3;
    }

    public static d a(g g2, WebView webView, String string2) {
        com.b.a.a.a.e.e.a(g2, "Partner is null");
        com.b.a.a.a.e.e.a((Object)webView, "WebView is null");
        if (string2 != null) {
            com.b.a.a.a.e.e.a(string2, 256, "CustomReferenceData is greater than 256 characters");
        }
        d d2 = new d(g2, webView, null, null, string2);
        return d2;
    }

    public static d a(g g2, String string2, List<h> list, String string3) {
        com.b.a.a.a.e.e.a(g2, "Partner is null");
        com.b.a.a.a.e.e.a((Object)string2, "OMID JS script content is null");
        com.b.a.a.a.e.e.a(list, "VerificationScriptResources is null");
        if (string3 != null) {
            com.b.a.a.a.e.e.a(string3, 256, "CustomReferenceData is greater than 256 characters");
        }
        d d2 = new d(g2, null, string2, list, string3);
        return d2;
    }

    public g a() {
        return this.a;
    }

    public List<h> b() {
        return Collections.unmodifiableList(this.c);
    }

    public WebView c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.d;
    }

    public e f() {
        return this.f;
    }
}

