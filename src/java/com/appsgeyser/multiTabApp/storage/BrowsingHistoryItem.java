/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.storage;

public class BrowsingHistoryItem {
    private String date;
    private String id;
    private String title;
    private String url;

    public BrowsingHistoryItem(String string2, String string3, String string4, String string5) {
        this.id = string2;
        this.date = string3;
        this.title = string4;
        this.url = string5;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }
}

