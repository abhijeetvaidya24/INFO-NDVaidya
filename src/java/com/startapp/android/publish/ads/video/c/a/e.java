/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  javax.xml.namespace.QName
 *  javax.xml.xpath.XPath
 *  javax.xml.xpath.XPathConstants
 *  javax.xml.xpath.XPathFactory
 *  org.w3c.dom.Document
 *  org.w3c.dom.NamedNodeMap
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package com.startapp.android.publish.ads.video.c.a;

import android.text.TextUtils;
import com.startapp.android.publish.ads.video.c.a.a.a;
import com.startapp.android.publish.ads.video.c.a.a.d;
import com.startapp.android.publish.ads.video.c.a.b;
import com.startapp.android.publish.ads.video.c.a.c;
import com.startapp.android.publish.adsCommon.p;
import com.startapp.android.publish.omsdk.AdVerification;
import com.startapp.android.publish.omsdk.VerificationDetails;
import com.startapp.common.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class e {
    private static String a = "VASTModel";
    private HashMap<b, List<com.startapp.android.publish.ads.video.c.a.a.c>> b;
    private List<com.startapp.android.publish.ads.video.c.a.a.b> c;
    private int d;
    private com.startapp.android.publish.ads.video.c.a.a.e e;
    private List<String> f;
    private List<String> g;
    private int h;
    private com.startapp.android.publish.ads.video.c.a.a.b i = null;
    private List<a> j;
    private AdVerification k;

    public e(Document document) {
        this.d = this.c(document);
        this.b = this.a(document);
        this.c = this.b(document);
        this.e = this.d(document);
        this.f = this.e(document);
        this.g = this.f(document);
        this.h = this.g(document);
        this.j = this.h(document);
        this.k = this.i(document);
    }

    private static int a(String string) {
        String[] arrstring = string.split(":");
        return 3600 * Integer.parseInt((String)arrstring[0]) + 60 * Integer.parseInt((String)arrstring[1]) + Integer.parseInt((String)arrstring[2]);
    }

    /*
     * Exception decompiling
     */
    private HashMap<b, List<com.startapp.android.publish.ads.video.c.a.a.c>> a(Document var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private List<String> a(Document document, String string) {
        ArrayList arrayList;
        block4 : {
            int n2;
            NodeList nodeList;
            g.a(a, 3, "getListFromXPath");
            arrayList = new ArrayList();
            try {
                nodeList = (NodeList)XPathFactory.newInstance().newXPath().evaluate(string, (Object)document, XPathConstants.NODESET);
                if (nodeList == null) break block4;
                n2 = 0;
            }
            catch (Exception exception) {
                g.a(a, 6, exception.getMessage(), exception);
                return null;
            }
            do {
                if (n2 >= nodeList.getLength()) break;
                arrayList.add((Object)p.b(nodeList.item(n2)));
                ++n2;
            } while (true);
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private List<com.startapp.android.publish.ads.video.c.a.a.b> b(Document document) {
        ArrayList arrayList;
        block3 : {
            NodeList nodeList;
            g.a(a, 3, "getMediaFiles");
            arrayList = new ArrayList();
            XPath xPath = XPathFactory.newInstance().newXPath();
            try {
                nodeList = (NodeList)xPath.evaluate("//MediaFile", (Object)document, XPathConstants.NODESET);
                if (nodeList == null) break block3;
            }
            catch (Exception exception) {
                g.a(a, 6, exception.getMessage(), exception);
                return null;
            }
            for (int j = 0; j < nodeList.getLength(); ++j) {
                com.startapp.android.publish.ads.video.c.a.a.b b2 = new com.startapp.android.publish.ads.video.c.a.a.b();
                Node node = nodeList.item(j);
                NamedNodeMap namedNodeMap = node.getAttributes();
                Node node2 = namedNodeMap.getNamedItem("apiFramework");
                String string = node2 == null ? null : node2.getNodeValue();
                b2.e(string);
                Node node3 = namedNodeMap.getNamedItem("bitrate");
                Integer n2 = node3 == null ? null : Integer.valueOf((String)node3.getNodeValue());
                b2.a(n2);
                Node node4 = namedNodeMap.getNamedItem("delivery");
                String string2 = node4 == null ? null : node4.getNodeValue();
                b2.c(string2);
                Node node5 = namedNodeMap.getNamedItem("height");
                Integer n3 = node5 == null ? null : Integer.valueOf((String)node5.getNodeValue());
                b2.c(n3);
                Node node6 = namedNodeMap.getNamedItem("width");
                Integer n4 = node6 == null ? null : Integer.valueOf((String)node6.getNodeValue());
                b2.b(n4);
                Node node7 = namedNodeMap.getNamedItem("id");
                String string3 = node7 == null ? null : node7.getNodeValue();
                b2.b(string3);
                Node node8 = namedNodeMap.getNamedItem("maintainAspectRatio");
                Boolean bl = node8 == null ? null : Boolean.valueOf((String)node8.getNodeValue());
                b2.b(bl);
                Node node9 = namedNodeMap.getNamedItem("scalable");
                Boolean bl2 = node9 == null ? null : Boolean.valueOf((String)node9.getNodeValue());
                b2.a(bl2);
                Node node10 = namedNodeMap.getNamedItem("type");
                String string4 = node10 == null ? null : node10.getNodeValue();
                b2.d(string4);
                b2.a(p.b(node));
                if (!b2.f()) continue;
                arrayList.add((Object)b2);
            }
        }
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int c(Document document) {
        g.a(a, 3, "getDuration");
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList)xPath.evaluate("//Duration", (Object)document, XPathConstants.NODESET);
        if (nodeList == null) return Integer.MAX_VALUE;
        try {
            if (nodeList.getLength() <= 0) return Integer.MAX_VALUE;
            return e.a(p.b(nodeList.item(0)));
        }
        catch (Exception exception) {
            g.a(a, 6, exception.getMessage(), exception);
        }
        return Integer.MAX_VALUE;
    }

    private com.startapp.android.publish.ads.video.c.a.a.e d(Document document) {
        com.startapp.android.publish.ads.video.c.a.a.e e2;
        block8 : {
            NodeList nodeList;
            int n2;
            g.a(a, 3, "getVideoClicks");
            e2 = new com.startapp.android.publish.ads.video.c.a.a.e();
            try {
                nodeList = (NodeList)XPathFactory.newInstance().newXPath().evaluate("//VideoClicks", (Object)document, XPathConstants.NODESET);
                if (nodeList == null) break block8;
                n2 = 0;
            }
            catch (Exception exception) {
                g.a(a, 6, exception.getMessage(), exception);
                return null;
            }
            do {
                if (n2 >= nodeList.getLength()) break;
                NodeList nodeList2 = nodeList.item(n2).getChildNodes();
                int n3 = 0;
                do {
                    block9 : {
                        if (n3 >= nodeList2.getLength()) break;
                        Node node = nodeList2.item(n3);
                        String string = node.getNodeName();
                        String string2 = p.b(node);
                        if (string.equalsIgnoreCase("ClickTracking")) {
                            e2.b().add((Object)string2);
                            break block9;
                        }
                        if (string.equalsIgnoreCase("ClickThrough")) {
                            e2.a(string2);
                            break block9;
                        }
                        if (!string.equalsIgnoreCase("CustomClick")) break block9;
                        e2.c().add((Object)string2);
                    }
                    ++n3;
                } while (true);
                ++n2;
            } while (true);
        }
        return e2;
    }

    private List<String> e(Document document) {
        g.a(a, 3, "getImpressions");
        return this.a(document, "//Impression");
    }

    private List<String> f(Document document) {
        g.a(a, 3, "getErrorUrl");
        return this.a(document, "//Error");
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int g(Document document) {
        g.a(a, 3, "getSkipOffset");
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList)xPath.evaluate("//Linear", (Object)document, XPathConstants.NODESET);
        if (nodeList == null) return Integer.MAX_VALUE;
        int n2 = 0;
        do {
            int n3 = nodeList.getLength();
            if (n2 >= n3) return Integer.MAX_VALUE;
            try {
                if (nodeList.item(n2).getAttributes().getNamedItem("skipoffset") != null) {
                    return e.a(nodeList.item(n2).getAttributes().getNamedItem("skipoffset").getNodeValue());
                }
            }
            catch (Exception exception) {
                g.a(a, 6, exception.getMessage(), exception);
            }
            ++n2;
        } while (true);
        {
            catch (Exception exception) {
                g.a(a, 6, exception.getMessage(), exception);
            }
        }
        return Integer.MAX_VALUE;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private List<a> h(Document document) {
        ArrayList arrayList;
        block6 : {
            NodeList nodeList;
            g.a(a, 3, "getIcons");
            arrayList = new ArrayList();
            XPath xPath = XPathFactory.newInstance().newXPath();
            try {
                nodeList = (NodeList)xPath.evaluate("//Icon", (Object)document, XPathConstants.NODESET);
                if (nodeList == null) break block6;
            }
            catch (Exception exception) {
                g.a(a, 6, exception.getMessage(), exception);
                return null;
            }
            block2 : for (int j = 0; j < nodeList.getLength(); ++j) {
                a a2 = new a();
                Node node = nodeList.item(j);
                NamedNodeMap namedNodeMap = node.getAttributes();
                Node node2 = namedNodeMap.getNamedItem("program");
                String string = node2 == null ? null : node2.getNodeValue();
                a2.a(string);
                Node node3 = namedNodeMap.getNamedItem("width");
                Integer n2 = node3 == null ? null : Integer.valueOf((String)node3.getNodeValue());
                a2.a(n2);
                Node node4 = namedNodeMap.getNamedItem("height");
                Integer n3 = node4 == null ? null : Integer.valueOf((String)node4.getNodeValue());
                a2.b(n3);
                Node node5 = namedNodeMap.getNamedItem("xPosition");
                Integer n4 = node5 == null ? null : Integer.valueOf((String)node5.getNodeValue());
                a2.c(n4);
                Node node6 = namedNodeMap.getNamedItem("yPosition");
                Integer n5 = node6 == null ? null : Integer.valueOf((String)node6.getNodeValue());
                a2.d(n5);
                Node node7 = namedNodeMap.getNamedItem("duration");
                Integer n6 = node7 == null ? null : Integer.valueOf((String)node7.getNodeValue());
                a2.e(n6);
                Node node8 = namedNodeMap.getNamedItem("offset");
                Integer n7 = node8 == null ? null : Integer.valueOf((String)node8.getNodeValue());
                a2.f(n7);
                Node node9 = namedNodeMap.getNamedItem("apiFramework");
                String string2 = node9 == null ? null : node9.getNodeValue();
                a2.b(string2);
                Node node10 = namedNodeMap.getNamedItem("pxratio");
                Integer n8 = node10 == null ? null : Integer.valueOf((String)node10.getNodeValue());
                a2.g(n8);
                NodeList nodeList2 = node.getChildNodes();
                int n9 = 0;
                do {
                    block11 : {
                        NodeList nodeList3;
                        block9 : {
                            block7 : {
                                String string3;
                                String string4;
                                block10 : {
                                    block8 : {
                                        if (n9 >= nodeList2.getLength()) break block7;
                                        Node node11 = nodeList2.item(n9);
                                        string3 = node11.getNodeName();
                                        string4 = p.b(node11);
                                        if (!string3.equalsIgnoreCase("IconClicks")) break block8;
                                        nodeList3 = node.getChildNodes();
                                        break block9;
                                    }
                                    if (!string3.equalsIgnoreCase("ClickTracking")) break block10;
                                    a2.f().add((Object)string4);
                                    break block11;
                                }
                                if (!string3.equalsIgnoreCase("StaticResource")) break block11;
                                d d2 = new d();
                                d2.b(string4);
                                Node node12 = node.getAttributes().getNamedItem("creativeType");
                                String string5 = node12 == null ? null : node12.getNodeValue();
                                d2.a(string5);
                                if (!d2.a()) break block11;
                                a2.e().add((Object)d2);
                                break block11;
                            }
                            if (!a2.h()) continue block2;
                            arrayList.add((Object)a2);
                            continue block2;
                        }
                        for (int i2 = 0; i2 < nodeList3.getLength(); ++i2) {
                            Node node13 = nodeList2.item(n9);
                            String string6 = node13.getNodeName();
                            String string7 = p.b(node13);
                            if (string6.equalsIgnoreCase("ClickThrough")) {
                                a2.c(string7);
                                continue;
                            }
                            if (!string6.equalsIgnoreCase("IconViewTracking")) continue;
                            a2.g().add((Object)string7);
                        }
                    }
                    ++n9;
                } while (true);
            }
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private AdVerification i(Document document) {
        NodeList nodeList;
        int n2;
        ArrayList arrayList;
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            nodeList = (NodeList)xPath.evaluate("//AdVerifications", (Object)document, XPathConstants.NODESET);
            if (nodeList == null) return null;
            arrayList = new ArrayList();
            n2 = 0;
        }
        catch (Exception exception) {
            g.a(a, 6, exception.getMessage(), exception);
            return null;
        }
        block2 : do {
            if (n2 >= nodeList.getLength()) {
                if (arrayList.isEmpty()) return null;
                return new AdVerification((VerificationDetails[])arrayList.toArray((Object[])new VerificationDetails[arrayList.size()]));
            }
            NodeList nodeList2 = nodeList.item(n2).getChildNodes();
            int n3 = 0;
            do {
                block12 : {
                    Node node;
                    block13 : {
                        block11 : {
                            if (n3 >= nodeList2.getLength()) break block11;
                            node = nodeList2.item(n3);
                            if (!node.getNodeName().equalsIgnoreCase("Verification")) break block12;
                            break block13;
                        }
                        ++n2;
                        continue block2;
                    }
                    NamedNodeMap namedNodeMap = node.getAttributes();
                    String string = namedNodeMap != null && namedNodeMap.getNamedItem("vendor") != null ? namedNodeMap.getNamedItem("vendor").getNodeValue() : null;
                    NodeList nodeList3 = node.getChildNodes();
                    String string2 = null;
                    String string3 = null;
                    String string4 = "";
                    int n4 = 0;
                    do {
                        if (n4 >= nodeList3.getLength()) {
                            if (TextUtils.isEmpty((CharSequence)string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3) || !"omid".equalsIgnoreCase(string4)) break;
                            arrayList.add((Object)new VerificationDetails(string, string2, string3));
                            break;
                        }
                        Node node2 = nodeList3.item(n4);
                        if (node2.getNodeName().equalsIgnoreCase("JavaScriptResource")) {
                            Node node3 = node2.getAttributes().getNamedItem("apiFramework");
                            if (node3 != null) {
                                string4 = node3.getNodeValue();
                            }
                            string2 = p.b(node2);
                        } else if (node2.getNodeName().equalsIgnoreCase("VerificationParameters")) {
                            string3 = p.b(node2);
                        }
                        ++n4;
                    } while (true);
                }
                ++n3;
            } while (true);
            break;
        } while (true);
    }

    public HashMap<b, List<com.startapp.android.publish.ads.video.c.a.a.c>> a() {
        return this.b;
    }

    public boolean a(c c2) {
        this.i = com.startapp.android.publish.ads.video.c.b.a.a(this, c2);
        return this.i != null;
    }

    public List<com.startapp.android.publish.ads.video.c.a.a.b> b() {
        return this.c;
    }

    public com.startapp.android.publish.ads.video.c.a.a.e c() {
        return this.e;
    }

    public List<String> d() {
        return this.f;
    }

    public List<String> e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public com.startapp.android.publish.ads.video.c.a.a.b g() {
        return this.i;
    }

    public AdVerification h() {
        return this.k;
    }
}

