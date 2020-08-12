/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.multiTabApp.suggestions.RemoteSuggestionItem
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  org.xml.sax.Attributes
 *  org.xml.sax.SAXException
 *  org.xml.sax.helpers.DefaultHandler
 */
package com.appsgeyser.multiTabApp.suggestions;

import com.appsgeyser.multiTabApp.suggestions.RemoteSuggestionItem;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SuggestionsHandler
extends DefaultHandler {
    private final int CAPACITY_DEFAULT = 6;
    private final String XML_ATTRIBUTE_DATA = "data";
    private final String XML_TAG_SUGGESTION = "suggestion";
    private int capacity = 6;
    private ArrayList<RemoteSuggestionItem> results = new ArrayList();

    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public ArrayList<RemoteSuggestionItem> getResult() {
        return this.results;
    }

    public void startDocument() throws SAXException {
        super.startDocument();
    }

    public void startElement(String string2, String string3, String string4, Attributes attributes) throws SAXException {
        String string5;
        super.startElement(string2, string3, string4, attributes);
        if (this.results.size() >= this.capacity) {
            return;
        }
        if (string4 != null && attributes != null && string4.equals((Object)"suggestion") && (string5 = attributes.getValue("data")) != null) {
            this.results.add((Object)new RemoteSuggestionItem(string5));
        }
    }
}

