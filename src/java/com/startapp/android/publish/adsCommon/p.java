/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Reader
 *  java.io.StringReader
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  javax.xml.parsers.DocumentBuilder
 *  javax.xml.parsers.DocumentBuilderFactory
 *  javax.xml.transform.Result
 *  javax.xml.transform.Source
 *  javax.xml.transform.Transformer
 *  javax.xml.transform.TransformerFactory
 *  javax.xml.transform.dom.DOMSource
 *  javax.xml.transform.stream.StreamResult
 *  org.w3c.dom.CharacterData
 *  org.w3c.dom.Document
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 *  org.xml.sax.InputSource
 */
package com.startapp.android.publish.adsCommon;

import com.startapp.common.a.g;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class p {
    private static String a = "XmlTools";

    public static String a(Node node) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("omit-xml-declaration", "yes");
            transformer.setOutputProperty("method", "xml");
            transformer.setOutputProperty("indent", "no");
            transformer.setOutputProperty("encoding", "UTF-8");
            StringWriter stringWriter = new StringWriter();
            transformer.transform((Source)new DOMSource(node), (Result)new StreamResult((Writer)stringWriter));
            String string = stringWriter.toString();
            return string;
        }
        catch (Exception exception) {
            g.a(a, 6, "xmlDocumentToString", exception);
            return null;
        }
    }

    public static Document a(String string) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setIgnoringElementContentWhitespace(true);
            documentBuilderFactory.setIgnoringComments(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream((Reader)new StringReader(string));
            Document document = documentBuilder.parse(inputSource);
            return document;
        }
        catch (Exception exception) {
            g.a(a, 6, "stringToDocument", exception);
            return null;
        }
    }

    public static String b(Node node) {
        NodeList nodeList = node.getChildNodes();
        String string = null;
        for (int i2 = 0; i2 < nodeList.getLength() && (string = ((CharacterData)nodeList.item(i2)).getData().trim()).length() == 0; ++i2) {
        }
        return string;
    }
}

