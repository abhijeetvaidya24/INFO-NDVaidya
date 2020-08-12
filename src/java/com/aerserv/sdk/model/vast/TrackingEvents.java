/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import com.aerserv.sdk.model.vast.TrackingEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class TrackingEvents
extends ArrayList<TrackingEvent>
implements Serializable {
    public static final String ELEMENT_NAME = "TrackingEvents";
    private static final long serialVersionUID = -7122931272768731294L;

    public TrackingEvents() {
    }

    public TrackingEvents(TrackingEvents trackingEvents) {
        super((Collection)trackingEvents);
    }

    public static TrackingEvents createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        TrackingEvents trackingEvents = new TrackingEvents();
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            if (n2 == 2 && "Tracking".equals((Object)string)) {
                trackingEvents.add((Object)TrackingEvent.createFromParser(xmlPullParser));
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return trackingEvents;
    }
}

