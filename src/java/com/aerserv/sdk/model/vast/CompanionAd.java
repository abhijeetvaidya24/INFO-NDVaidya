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
 *  java.util.Iterator
 *  java.util.List
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import android.net.Uri;
import com.aerserv.sdk.model.vast.AdResource;
import com.aerserv.sdk.model.vast.EventType;
import com.aerserv.sdk.model.vast.HTMLAdResource;
import com.aerserv.sdk.model.vast.IFrameAdResource;
import com.aerserv.sdk.model.vast.StaticAdResource;
import com.aerserv.sdk.model.vast.TrackingEvent;
import com.aerserv.sdk.model.vast.TrackingEvents;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class CompanionAd
implements Serializable {
    private static final String COMPANION_CLICKTHROUGH_ELEMENT_NAME = "CompanionClickThrough";
    private static final String COMPANION_CLICK_TRACKING_ELEMENT_NAME = "CompanionClickTracking";
    public static final String ELEMENT_NAME = "Companion";
    private static final String HEIGHT_ATTRIBUTE_NAME = "height";
    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String STATIC_AD_CREATIVE_TYPE_ATTRIBUTE_NAME = "creativeType";
    private static final String WIDTH_ATTRIBUTE_NAME = "width";
    private static final long serialVersionUID = -1669755351366796612L;
    private String clickThrough;
    private List<String> clickTrackingUris = new ArrayList();
    private TrackingEvents creativeViewTrackingEvents = new TrackingEvents();
    private int height;
    private String id;
    private List<AdResource> resourceList = new ArrayList();
    private int width;

    private void addCreativeViewTrackingEvents(TrackingEvents trackingEvents) {
        Iterator iterator = trackingEvents.iterator();
        while (iterator.hasNext()) {
            TrackingEvent trackingEvent = (TrackingEvent)iterator.next();
            if (!trackingEvent.getEventType().equals((Object)EventType.CREATIVE_VIEW)) continue;
            this.creativeViewTrackingEvents.add((Object)trackingEvent);
        }
    }

    public static CompanionAd createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        CompanionAd companionAd = new CompanionAd();
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            if (n2 == 2) {
                Uri uri;
                String string2;
                if (ELEMENT_NAME.equals((Object)string)) {
                    companionAd.width = Integer.valueOf((String)xmlPullParser.getAttributeValue(null, WIDTH_ATTRIBUTE_NAME));
                    companionAd.height = Integer.valueOf((String)xmlPullParser.getAttributeValue(null, HEIGHT_ATTRIBUTE_NAME));
                    companionAd.id = xmlPullParser.getAttributeValue(null, ID_ATTRIBUTE_NAME);
                } else if ("StaticResource".equals((Object)string)) {
                    StaticAdResource staticAdResource = new StaticAdResource();
                    staticAdResource.setMimeType(xmlPullParser.getAttributeValue(null, STATIC_AD_CREATIVE_TYPE_ATTRIBUTE_NAME));
                    staticAdResource.setResourceUri(xmlPullParser.nextText().trim());
                    companionAd.resourceList.add((Object)staticAdResource);
                } else if ("IFrameResource".equals((Object)string)) {
                    IFrameAdResource iFrameAdResource = new IFrameAdResource();
                    iFrameAdResource.setiFrameUri(xmlPullParser.nextText().trim());
                    companionAd.resourceList.add((Object)iFrameAdResource);
                } else if ("HTMLResource".equals((Object)string)) {
                    HTMLAdResource hTMLAdResource = new HTMLAdResource();
                    hTMLAdResource.setHtml(xmlPullParser.nextText());
                    companionAd.resourceList.add((Object)hTMLAdResource);
                } else if ("TrackingEvents".equals((Object)string)) {
                    companionAd.addCreativeViewTrackingEvents(TrackingEvents.createFromParser(xmlPullParser));
                } else if (COMPANION_CLICKTHROUGH_ELEMENT_NAME.equals((Object)string)) {
                    String string3 = xmlPullParser.nextText();
                    Uri uri2 = string3 == null ? null : Uri.parse((String)string3.trim());
                    if (uri2 != null) {
                        companionAd.clickThrough = uri2.toString();
                    }
                } else if (COMPANION_CLICK_TRACKING_ELEMENT_NAME.equals((Object)string) && (uri = (string2 = xmlPullParser.nextText()) == null ? null : Uri.parse((String)string2.trim())) != null) {
                    companionAd.clickTrackingUris.add((Object)uri.toString());
                }
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return companionAd;
    }

    public String getClickThrough() {
        return this.clickThrough;
    }

    public List<String> getClickTrackingUris() {
        return new ArrayList(this.clickTrackingUris);
    }

    public TrackingEvents getCreativeViewTrackingEvents() {
        return this.creativeViewTrackingEvents;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public List<AdResource> getResourceList() {
        return this.resourceList;
    }

    public int getWidth() {
        return this.width;
    }
}

