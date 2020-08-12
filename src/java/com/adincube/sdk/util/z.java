/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  javax.xml.namespace.QName
 *  javax.xml.xpath.XPath
 *  javax.xml.xpath.XPathConstants
 *  javax.xml.xpath.XPathExpressionException
 *  javax.xml.xpath.XPathFactory
 *  org.w3c.dom.NamedNodeMap
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package com.adincube.sdk.util;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressLint(value={"NewApi"})
public final class z {
    private static XPathFactory a;

    public static String a(String string) {
        return string.replaceAll("\n|\t", "");
    }

    public static Map<String, String> a(Node node) {
        HashMap hashMap = new HashMap();
        if (node.getAttributes() != null) {
            for (int i2 = 0; i2 < node.getAttributes().getLength(); ++i2) {
                Node node2 = node.getAttributes().item(i2);
                hashMap.put((Object)node2.getNodeName(), (Object)node2.getNodeValue());
            }
        }
        return hashMap;
    }

    public static NodeList a(Node node, String string) {
        try {
            if (a == null) {
                a = XPathFactory.newInstance();
            }
            NodeList nodeList = (NodeList)a.newXPath().evaluate(string, (Object)node, XPathConstants.NODESET);
            return nodeList;
        }
        catch (XPathExpressionException xPathExpressionException) {
            throw new RuntimeException((Throwable)xPathExpressionException);
        }
    }

    public static Node b(Node node, String string) {
        ArrayList arrayList = new ArrayList();
        NodeList nodeList = node.getChildNodes();
        for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
            if (!string.equals((Object)nodeList.item(i2).getNodeName())) continue;
            arrayList.add((Object)nodeList.item(i2));
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (Node)arrayList.get(0);
    }

    public static List<String> c(Node node, String string) {
        ArrayList arrayList = new ArrayList();
        NodeList nodeList = node.getChildNodes();
        for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
            if (!string.equals((Object)nodeList.item(i2).getNodeName())) continue;
            arrayList.add((Object)z.a(nodeList.item(i2).getTextContent()));
        }
        return arrayList;
    }

    public static String d(Node node, String string) {
        Node node2 = z.b(node, string);
        if (node2 == null) {
            return null;
        }
        return z.a(node2.getTextContent());
    }

    public static String e(Node node, String string) {
        if (node.getAttributes() == null) {
            return null;
        }
        Node node2 = node.getAttributes().getNamedItem(string);
        String string2 = null;
        if (node2 != null) {
            string2 = node2.getTextContent();
        }
        return string2;
    }

    public static Integer f(Node node, String string) {
        String string2 = z.e(node, string);
        if (string2 != null) {
            return Integer.parseInt((String)string2);
        }
        return null;
    }
}

