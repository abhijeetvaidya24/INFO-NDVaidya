/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.b.b.h
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.jetbrains.annotations.NotNull
 */
package com.truenet.android;

import a.a.b.b.h;
import org.jetbrains.annotations.NotNull;

public final class Link {
    @NotNull
    private final String htmlStorage;
    @NotNull
    private final String imageStorage;
    @NotNull
    private final String instanceId;
    @NotNull
    private final String metaData;
    @NotNull
    private final String validationUrl;

    public Link() {
        this("", "", "", "", "");
    }

    public Link(@NotNull String string2, @NotNull String string3, @NotNull String string4, @NotNull String string5, @NotNull String string6) {
        h.b((Object)string2, (String)"instanceId");
        h.b((Object)string3, (String)"validationUrl");
        h.b((Object)string4, (String)"imageStorage");
        h.b((Object)string5, (String)"htmlStorage");
        h.b((Object)string6, (String)"metaData");
        this.instanceId = string2;
        this.validationUrl = string3;
        this.imageStorage = string4;
        this.htmlStorage = string5;
        this.metaData = string6;
    }

    @NotNull
    public static /* synthetic */ Link copy$default(Link link, String string2, String string3, String string4, String string5, String string6, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = link.instanceId;
        }
        if ((n2 & 2) != 0) {
            string3 = link.validationUrl;
        }
        String string7 = string3;
        if ((n2 & 4) != 0) {
            string4 = link.imageStorage;
        }
        String string8 = string4;
        if ((n2 & 8) != 0) {
            string5 = link.htmlStorage;
        }
        String string9 = string5;
        if ((n2 & 16) != 0) {
            string6 = link.metaData;
        }
        String string10 = string6;
        return link.copy(string2, string7, string8, string9, string10);
    }

    @NotNull
    public final String component1() {
        return this.instanceId;
    }

    @NotNull
    public final String component2() {
        return this.validationUrl;
    }

    @NotNull
    public final String component3() {
        return this.imageStorage;
    }

    @NotNull
    public final String component4() {
        return this.htmlStorage;
    }

    @NotNull
    public final String component5() {
        return this.metaData;
    }

    @NotNull
    public final Link copy(@NotNull String string2, @NotNull String string3, @NotNull String string4, @NotNull String string5, @NotNull String string6) {
        h.b((Object)string2, (String)"instanceId");
        h.b((Object)string3, (String)"validationUrl");
        h.b((Object)string4, (String)"imageStorage");
        h.b((Object)string5, (String)"htmlStorage");
        h.b((Object)string6, (String)"metaData");
        Link link = new Link(string2, string3, string4, string5, string6);
        return link;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof Link)) break block3;
                Link link = (Link)object;
                if (h.a((Object)this.instanceId, (Object)link.instanceId) && h.a((Object)this.validationUrl, (Object)link.validationUrl) && h.a((Object)this.imageStorage, (Object)link.imageStorage) && h.a((Object)this.htmlStorage, (Object)link.htmlStorage) && h.a((Object)this.metaData, (Object)link.metaData)) break block2;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getHtmlStorage() {
        return this.htmlStorage;
    }

    @NotNull
    public final String getImageStorage() {
        return this.imageStorage;
    }

    @NotNull
    public final String getInstanceId() {
        return this.instanceId;
    }

    @NotNull
    public final String getMetaData() {
        return this.metaData;
    }

    @NotNull
    public final String getValidationUrl() {
        return this.validationUrl;
    }

    public int hashCode() {
        String string2 = this.instanceId;
        int n2 = string2 != null ? string2.hashCode() : 0;
        int n3 = n2 * 31;
        String string3 = this.validationUrl;
        int n4 = string3 != null ? string3.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        String string4 = this.imageStorage;
        int n6 = string4 != null ? string4.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        String string5 = this.htmlStorage;
        int n8 = string5 != null ? string5.hashCode() : 0;
        int n9 = 31 * (n7 + n8);
        String string6 = this.metaData;
        int n10 = 0;
        if (string6 != null) {
            n10 = string6.hashCode();
        }
        return n9 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Link(instanceId=");
        stringBuilder.append(this.instanceId);
        stringBuilder.append(", validationUrl=");
        stringBuilder.append(this.validationUrl);
        stringBuilder.append(", imageStorage=");
        stringBuilder.append(this.imageStorage);
        stringBuilder.append(", htmlStorage=");
        stringBuilder.append(this.htmlStorage);
        stringBuilder.append(", metaData=");
        stringBuilder.append(this.metaData);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

