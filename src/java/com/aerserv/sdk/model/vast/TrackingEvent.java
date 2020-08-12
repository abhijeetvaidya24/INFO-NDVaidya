/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import android.net.Uri;
import com.aerserv.sdk.model.vast.EventType;
import com.aerserv.sdk.utils.TimeSpan;
import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class TrackingEvent
implements Serializable {
    public static final String ELEMENT_NAME = "Tracking";
    private static final String EVENT_ATTRIBUTE_NAME = "event";
    private static final String OFFSET_ATTRIBUTE_NAME = "offset";
    private EventType eventType;
    private TimeSpan offset;
    private String trackingUri;

    public static TrackingEvent createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        TrackingEvent trackingEvent = new TrackingEvent();
        do {
            if (n2 == 2 && ELEMENT_NAME.equals((Object)string)) {
                trackingEvent.eventType = EventType.get(xmlPullParser.getAttributeValue(null, EVENT_ATTRIBUTE_NAME));
                trackingEvent.setOffset(xmlPullParser.getAttributeValue(null, OFFSET_ATTRIBUTE_NAME));
                String string2 = xmlPullParser.nextText();
                Uri uri = string2 == null ? null : Uri.parse((String)string2.trim());
                if (uri != null) {
                    trackingEvent.trackingUri = uri.toString();
                }
                n2 = xmlPullParser.getEventType();
                string = xmlPullParser.getName();
                continue;
            }
            n2 = xmlPullParser.next();
        } while (n2 != 3 || !ELEMENT_NAME.equals((Object)string));
        return trackingEvent;
    }

    private void setOffset(String string) {
        TimeSpan timeSpan = string == null ? null : new TimeSpan(string);
        this.offset = timeSpan;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    public TimeSpan getOffset() {
        return this.offset;
    }

    public String getTrackingUri() {
        return this.trackingUri;
    }
}

