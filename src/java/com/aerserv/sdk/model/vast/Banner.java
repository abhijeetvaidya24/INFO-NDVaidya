/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import android.net.Uri;
import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class Banner
implements Serializable {
    public static final String ELEMENT_NAME = "Banner";
    private static final String HEIGHT_ATTRIBUTE_NAME = "height";
    private static final String MIME_TYPE_ATTRIBUTE_NAME = "type";
    private static final String WIDTH_ATTRIBUTE_NAME = "width";
    private static final long serialVersionUID = 1626903126428538152L;
    private String bannerUri;
    private Integer height;
    private String mimeType;
    private Integer width;

    public static Banner createFromParser(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        Banner banner = new Banner();
        do {
            if (n2 == 2) {
                if (ELEMENT_NAME.equals((Object)string)) {
                    banner.height = Integer.valueOf((String)xmlPullParser.getAttributeValue(null, HEIGHT_ATTRIBUTE_NAME));
                    banner.width = Integer.valueOf((String)xmlPullParser.getAttributeValue(null, WIDTH_ATTRIBUTE_NAME));
                    banner.mimeType = xmlPullParser.getAttributeValue(null, MIME_TYPE_ATTRIBUTE_NAME);
                    String string2 = xmlPullParser.nextText();
                    Uri uri = string2 == null ? null : Uri.parse((String)string2.trim());
                    if (uri != null) {
                        banner.bannerUri = uri.toString();
                    }
                }
                n2 = xmlPullParser.getEventType();
            } else {
                n2 = xmlPullParser.next();
            }
            string = xmlPullParser.getName();
        } while (n2 != 3 || !ELEMENT_NAME.equals((Object)string));
        return banner;
    }

    public String getBannerUri() {
        return this.bannerUri;
    }

    public Integer getHeight() {
        return this.height;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Integer getWidth() {
        return this.width;
    }
}

