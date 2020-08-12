/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Xml
 *  com.applovin.impl.sdk.e.o$a
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Stack
 *  java.util.concurrent.TimeUnit
 *  org.xml.sax.Attributes
 *  org.xml.sax.ContentHandler
 *  org.xml.sax.Locator
 *  org.xml.sax.SAXException
 */
package com.applovin.impl.sdk.e;

import android.util.Xml;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.p;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class o {
    private final p a;
    private final boolean b;
    private Stack<a> c;
    private StringBuilder d;
    private long e;
    private a f;

    o(com.applovin.impl.sdk.j j2) {
        if (j2 != null) {
            this.a = j2.u();
            this.b = j2.a(b.eW);
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    public static n a(String string2, com.applovin.impl.sdk.j j2) throws SAXException {
        return new o(j2).a(string2);
    }

    private Map<String, String> a(Attributes attributes) {
        if (attributes != null) {
            int n2 = attributes.getLength();
            HashMap hashMap = new HashMap(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                hashMap.put((Object)attributes.getQName(i2), (Object)attributes.getValue(i2));
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    public n a(String string2) throws SAXException {
        if (string2 != null) {
            this.d = new StringBuilder();
            this.c = new Stack();
            this.f = null;
            Xml.parse((String)string2, (ContentHandler)new ContentHandler(this){
                final /* synthetic */ o a;
                {
                    this.a = o2;
                }

                public void characters(char[] arrc, int n2, int n3) throws SAXException {
                    if (!this.a.b) {
                        n2 = 0;
                    }
                    String string2 = new String(Arrays.copyOfRange((char[])arrc, (int)n2, (int)n3)).trim();
                    if (j.b(string2)) {
                        this.a.d.append(string2);
                    }
                }

                public void endDocument() throws SAXException {
                    long l2 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - this.a.e;
                    p p2 = this.a.a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Finished parsing in ");
                    stringBuilder.append(l2);
                    stringBuilder.append(" seconds");
                    p2.a("XmlParser", stringBuilder.toString());
                }

                public void endElement(String string2, String string3, String string4) throws SAXException {
                    o o2 = this.a;
                    o2.f = o2.c.pop();
                    this.a.f.d(this.a.d.toString().trim());
                    this.a.d.setLength(0);
                }

                public void endPrefixMapping(String string2) throws SAXException {
                }

                public void ignorableWhitespace(char[] arrc, int n2, int n3) throws SAXException {
                }

                public void processingInstruction(String string2, String string3) throws SAXException {
                }

                public void setDocumentLocator(Locator locator) {
                }

                public void skippedEntity(String string2) throws SAXException {
                }

                public void startDocument() throws SAXException {
                    this.a.a.a("XmlParser", "Begin parsing...");
                    this.a.e = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void startElement(String string2, String string3, String string4, Attributes attributes) throws SAXException {
                    try {
                        boolean bl = this.a.c.isEmpty();
                        a a2 = null;
                        if (!bl) {
                            a2 = this.a.c.peek();
                        }
                        a a3 = new /* Unavailable Anonymous Inner Class!! */;
                        if (a2 != null) {
                            a2.a((n)a3);
                        }
                        this.a.c.push((Object)a3);
                        return;
                    }
                    catch (Exception exception) {
                        p p2 = this.a.a;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unable to process element <");
                        stringBuilder.append(string3);
                        stringBuilder.append(">");
                        p2.b("XmlParser", stringBuilder.toString(), exception);
                        throw new SAXException("Failed to start element", exception);
                    }
                }

                public void startPrefixMapping(String string2, String string3) throws SAXException {
                }
            });
            a a2 = this.f;
            if (a2 != null) {
                return a2;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }

}

