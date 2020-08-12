/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.aerserv.sdk.model.vast.HTMLAdResource
 *  com.aerserv.sdk.model.vast.IFrameAdResource
 *  com.aerserv.sdk.model.vast.StaticAdResource
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import android.net.Uri;
import com.aerserv.sdk.model.vast.AdResource;
import com.aerserv.sdk.model.vast.HTMLAdResource;
import com.aerserv.sdk.model.vast.IFrameAdResource;
import com.aerserv.sdk.model.vast.StaticAdResource;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class NonLinearAd
implements Serializable {
    public static final String ELEMENT_NAME = "NonLinear";
    private static final String HEIGHT_ATTRIBUTE_NAME = "height";
    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String NONLINEAR_CLICKTHROUGH_ELEMENT_NAME = "NonLinearClickThrough";
    private static final String NONLINEAR_CLICK_TRACKING_ELEMENT_NAME = "NonLinearClickTracking";
    private static final String STATIC_AD_CREATIVE_TYPE_ATTRIBUTE_NAME = "creativeType";
    private static final String WIDTH_ATTRIBUTE_NAME = "width";
    private static final long serialVersionUID = -3141832957648526768L;
    private AdResource adResource;
    private String clickThrough;
    private List<String> clickTrackingUris = new ArrayList();
    private int height;
    private String id;
    private int width;

    public static NonLinearAd createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        NonLinearAd nonLinearAd = new NonLinearAd();
        String string = xmlPullParser.getName();
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            String string2;
            Uri uri;
            if (n2 == 2 && ELEMENT_NAME.equals((Object)string)) {
                nonLinearAd.width = Integer.valueOf((String)xmlPullParser.getAttributeValue(null, WIDTH_ATTRIBUTE_NAME));
                nonLinearAd.height = Integer.valueOf((String)xmlPullParser.getAttributeValue(null, HEIGHT_ATTRIBUTE_NAME));
                nonLinearAd.id = xmlPullParser.getAttributeValue(null, ID_ATTRIBUTE_NAME);
            } else if ("StaticResource".equals((Object)string)) {
                StaticAdResource staticAdResource = new StaticAdResource();
                staticAdResource.setMimeType(xmlPullParser.getAttributeValue(null, STATIC_AD_CREATIVE_TYPE_ATTRIBUTE_NAME));
                String string3 = xmlPullParser.nextText();
                Uri uri2 = string3 == null ? null : Uri.parse((String)string3.trim());
                if (uri2 != null) {
                    staticAdResource.setResourceUri(uri2.toString());
                }
                nonLinearAd.adResource = staticAdResource;
            } else if ("IFrameResource".equals((Object)string)) {
                IFrameAdResource iFrameAdResource = new IFrameAdResource();
                String string4 = xmlPullParser.nextText();
                Uri uri3 = string4 == null ? null : Uri.parse((String)string4.trim());
                if (uri3 != null) {
                    iFrameAdResource.setiFrameUri(uri3.toString());
                }
                nonLinearAd.adResource = iFrameAdResource;
            } else if ("HTMLResource".equals((Object)string)) {
                HTMLAdResource hTMLAdResource = new HTMLAdResource();
                hTMLAdResource.setHtml(xmlPullParser.nextText());
                nonLinearAd.adResource = hTMLAdResource;
            } else if (NONLINEAR_CLICK_TRACKING_ELEMENT_NAME.equals((Object)string)) {
                String string5 = xmlPullParser.nextText();
                Uri uri4 = string5 == null ? null : Uri.parse((String)string5.trim());
                if (uri4 != null) {
                    nonLinearAd.clickTrackingUris.add((Object)uri4.toString());
                }
            } else if (NONLINEAR_CLICKTHROUGH_ELEMENT_NAME.equals((Object)string) && (uri = (string2 = xmlPullParser.nextText()) == null ? null : Uri.parse((String)string2.trim())) != null) {
                nonLinearAd.clickThrough = uri.toString();
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return nonLinearAd;
    }

    public AdResource getAdResource() {
        return this.adResource;
    }

    public String getClickThrough() {
        return this.clickThrough;
    }

    public List<String> getClickTrackingUris() {
        return new ArrayList(this.clickTrackingUris);
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public int getWidth() {
        return this.width;
    }
}

