/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  org.w3c.dom.Document
 *  org.w3c.dom.Element
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package com.startapp.android.publish.ads.video.c.b;

import android.content.Context;
import com.startapp.android.publish.ads.video.c.a.a;
import com.startapp.android.publish.ads.video.c.a.c;
import com.startapp.android.publish.ads.video.c.a.e;
import com.startapp.android.publish.adsCommon.k;
import com.startapp.android.publish.adsCommon.p;
import com.startapp.common.a.g;
import com.startapp.common.a.h;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class b {
    private final int a;
    private final int b;
    private e c;
    private StringBuilder d = new StringBuilder(500);
    private long e = -1L;

    public b(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public static String a(Document document) {
        NodeList nodeList;
        if (document != null && (nodeList = document.getElementsByTagName("VAST")) != null && nodeList.getLength() > 0) {
            return p.a(nodeList.item(0));
        }
        return null;
    }

    public static Document a(String string) {
        if (string != null && string.length() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<VASTS>");
            stringBuilder.append(string);
            stringBuilder.append("</VASTS>");
            return p.a(stringBuilder.toString());
        }
        return null;
    }

    public static Document b(String string) {
        Document document = p.a(string);
        if (document != null) {
            document.getDocumentElement().normalize();
        }
        return document;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public a a(Context context, String string, int n2) {
        h.a a2;
        long l2;
        if (n2 >= this.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VAST wrapping exceeded max limit of ");
            stringBuilder.append(this.a);
            g.a("VASTProcessor", 6, stringBuilder.toString());
            return a.l;
        }
        long l3 = System.currentTimeMillis();
        long l4 = l3 - (l2 = this.e);
        if (l4 > (long)this.b && l2 > 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VAST wrapping exceeded timeout ");
            stringBuilder.append(l4);
            g.a("VASTProcessor", 6, stringBuilder.toString());
            return a.k;
        }
        Document document = b.b(string);
        if (document == null) {
            return a.b;
        }
        String string2 = b.a(document);
        if (document.getChildNodes().getLength() == 0) return a.m;
        if (document.getChildNodes().item(0).getChildNodes().getLength() == 0) return a.m;
        if (string2 == null) return a.m;
        this.d.append(string2);
        NodeList nodeList = document.getElementsByTagName("VASTAdTagURI");
        if (nodeList == null) return a.a;
        if (nodeList.getLength() == 0) return a.a;
        String string3 = p.b(nodeList.item(0));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrapper URL: ");
        stringBuilder.append(string3);
        g.a("VASTProcessor", 3, stringBuilder.toString());
        try {
            a2 = h.a(context, string3.replace((CharSequence)" ", (CharSequence)"%20"), null, k.a(context, "User-Agent", "-1"), false);
            if (a2 == null) return a.m;
        }
        catch (Exception exception) {
            g.a("VASTProcessor", 6, "processXml network", exception);
            return a.j;
        }
        if (a2.a() == null) return a.m;
        return this.a(context, a2.a(), n2 + 1);
    }

    public a a(Context context, String string, c c2) {
        this.c = null;
        this.e = System.currentTimeMillis();
        a a2 = this.a(context, string, 0);
        if (a2 == a.b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("processXml error ");
            stringBuilder.append((Object)a2);
            g.a("VASTProcessor", 3, stringBuilder.toString());
            return a.b;
        }
        Document document = b.a(this.d.toString());
        if (document == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("wrapMergedVastDocWithVasts error ");
            stringBuilder.append((Object)a2);
            g.a("VASTProcessor", 3, stringBuilder.toString());
            return a.b;
        }
        this.c = new e(document);
        if (!this.c.a(c2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("validate error ");
            stringBuilder.append((Object)a2);
            g.a("VASTProcessor", 3, stringBuilder.toString());
            if (a2 == a.a) {
                a2 = a.r;
            }
        }
        return a2;
    }

    public e a() {
        return this.c;
    }
}

