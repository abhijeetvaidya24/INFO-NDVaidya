/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.appsgeyser.multiTabApp.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

public class DefaultUrlsHolder {
    private static DefaultUrlsHolder instance;
    private ArrayList<String> domains = new ArrayList();
    private ArrayList<String> urls = new ArrayList();

    private DefaultUrlsHolder() {
    }

    private String _getDomainFromUrl(String string2) {
        URI uRI;
        try {
            uRI = new URI(string2);
        }
        catch (URISyntaxException uRISyntaxException) {
            uRISyntaxException.printStackTrace();
            uRI = null;
        }
        String string3 = null;
        if (uRI != null) {
            string3 = uRI.getHost();
        }
        return string3;
    }

    private boolean _isDefaultHost(String string2) {
        String string3 = string2.toLowerCase();
        Iterator iterator = this.domains.iterator();
        while (iterator.hasNext()) {
            if (!string3.contains((CharSequence)((String)iterator.next()))) continue;
            return true;
        }
        return false;
    }

    private String convertUrl(String string2) {
        if (string2 != null && string2.length() > 0 && (string2 = string2.trim()).charAt(-1 + string2.length()) == '/') {
            string2 = string2.substring(0, -1 + string2.length());
        }
        return string2;
    }

    public static DefaultUrlsHolder getInstance() {
        if (instance == null) {
            instance = new DefaultUrlsHolder();
        }
        return instance;
    }

    public void addUrl(String string2) {
        if (string2 != null) {
            String string3;
            String string4 = this.convertUrl(string2);
            if (!this.containsUrl(string4)) {
                this.urls.add((Object)string4);
            }
            if ((string3 = this._getDomainFromUrl(string4)) != null && !this.domains.contains((Object)string3)) {
                this.domains.add((Object)string3.toLowerCase());
            }
        }
    }

    public boolean containsUrl(String string2) {
        String string3 = this.convertUrl(string2);
        return this.urls.contains((Object)string3);
    }

    public boolean isDefaultUrl(String string2) {
        if (string2.startsWith("file://")) {
            return true;
        }
        String string3 = this.convertUrl(string2);
        return this.urls.contains((Object)string3);
    }

    public boolean isPermittedDomain(String string2) {
        if (string2.startsWith("file://")) {
            return true;
        }
        String string3 = this._getDomainFromUrl(string2);
        return string3 != null && !string3.equals((Object)"") && this._isDefaultHost(string3);
    }
}

