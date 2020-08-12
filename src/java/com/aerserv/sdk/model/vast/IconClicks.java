/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import android.net.Uri;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class IconClicks
implements Serializable {
    public static final String ELEMENT_NAME = "IconClicks";
    public static final String ICON_CLICK_THROUGH_ELEMENT_NAME = "IconClickThrough";
    public static final String ICON_CLICK_TRACKING_ELEMENT_NAME = "IconClickTracking";
    private String clickThroughUri;
    private List<String> clickTrackingUriList = new ArrayList();

    public static IconClicks createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        IconClicks iconClicks = new IconClicks();
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            if (n2 == 2) {
                Uri uri;
                String string2;
                if (ICON_CLICK_THROUGH_ELEMENT_NAME.equals((Object)string)) {
                    String string3 = xmlPullParser.nextText();
                    Uri uri2 = string3 == null ? null : Uri.parse((String)string3.trim());
                    if (uri2 != null) {
                        iconClicks.clickThroughUri = uri2.toString();
                    }
                } else if (ICON_CLICK_TRACKING_ELEMENT_NAME.equals((Object)string) && (uri = (string2 = xmlPullParser.nextText()) == null ? null : Uri.parse((String)string2.trim())) != null) {
                    iconClicks.clickTrackingUriList.add((Object)uri.toString());
                }
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return iconClicks;
    }

    public String getClickThroughUri() {
        return this.clickThroughUri;
    }

    public List<String> getClickTrackingUriList() {
        return this.clickTrackingUriList;
    }
}

