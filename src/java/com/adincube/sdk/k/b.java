/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.h.a.a.a
 *  com.adincube.sdk.h.a.a.b
 *  com.adincube.sdk.h.a.a.c
 *  com.adincube.sdk.h.a.e
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.k.a.a
 *  com.adincube.sdk.k.b.a.d
 *  com.adincube.sdk.mediation.w.f
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.List
 *  javax.xml.parsers.DocumentBuilder
 *  javax.xml.parsers.DocumentBuilderFactory
 *  org.w3c.dom.Document
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 *  org.xml.sax.SAXException
 */
package com.adincube.sdk.k;

import com.adincube.sdk.h.a.a.c;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.k.a.a;
import com.adincube.sdk.k.b.a.d;
import com.adincube.sdk.mediation.w.f;
import com.adincube.sdk.util.n;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public final class b {
    public e a;
    public com.adincube.sdk.k.b.a b = null;
    public f c = null;
    public List<com.adincube.sdk.k.b.a.a> d = new ArrayList();

    public b(e e2, com.adincube.sdk.k.b.a a2) {
        this.a = e2;
        this.b = a2;
        this.c = com.adincube.sdk.g.a.a().a((boolean)true, (boolean)true).S;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static com.adincube.sdk.k.b.a a(com.adincube.sdk.h.a.a.a var0) {
        block17 : {
            var1_1 = null;
            var2_2 = 0;
            var10_3 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            var11_4 = n.a(com.adincube.sdk.util.f.a(), var0);
            var16_5 = var10_3.parse(var11_4);
            try {
                var11_4.close();
                break block17;
            }
            catch (Throwable v0) {}
            break block17;
            catch (Throwable var15_9) {
                var1_1 = var11_4;
                var4_10 = var15_9;
                ** GOTO lbl48
            }
            catch (Throwable var14_12) {
                var1_1 = var11_4;
                var8_13 = var14_12;
                ** GOTO lbl-1000
            }
            catch (IOException var13_15) {
                var1_1 = var11_4;
                var6_16 = var13_15;
                ** GOTO lbl55
            }
            catch (SAXException var12_18) {
                var1_1 = var11_4;
                var3_19 = var12_18;
                throw new com.adincube.sdk.k.a.b(a.a, var3_19);
            }
        }
        var18_6 = var16_5.getChildNodes();
        do {
            var19_7 = var18_6.getLength();
            var20_8 = null;
            if (var2_2 >= var19_7) break;
            if ("VAST".equals((Object)var18_6.item(var2_2).getNodeName())) {
                var20_8 = new com.adincube.sdk.k.b.a(var18_6.item(var2_2));
                break;
            }
            ++var2_2;
        } while (true);
        if (var20_8 == null) throw new com.adincube.sdk.k.a.b(a.b, "No VAST tag at root of XML document.");
        return var20_8;
        catch (Throwable var4_11) {
            ** GOTO lbl48
        }
        catch (Throwable var8_14) {
            // empty catch block
        }
lbl-1000: // 2 sources:
        {
            new Object[1][0] = var8_13;
            throw new com.adincube.sdk.k.a.b(a.a, var8_13);
lbl48: // 2 sources:
            try {
                var1_1.close();
                throw var4_10;
            }
            catch (Throwable v1) {
                throw var4_10;
            }
            catch (IOException var6_17) {
                var1_1 = null;
            }
lbl55: // 2 sources:
            new Object[1][0] = var6_16;
            throw new com.adincube.sdk.k.a.b(a.j, var6_16);
        }
        catch (SAXException var3_20) {
            var1_1 = null;
            throw new com.adincube.sdk.k.a.b(a.a, var3_19);
        }
    }

    public final com.adincube.sdk.h.a.a.a a(com.adincube.sdk.k.b.a.a a2) {
        d d2 = (d)a2;
        return new c(this.a, com.adincube.sdk.h.a.a.b.a, false, new URL(d2.f()));
    }
}

