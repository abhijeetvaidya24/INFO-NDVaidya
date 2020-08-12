/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import com.aerserv.sdk.model.vast.Icon;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class Icons
extends ArrayList<Icon>
implements Serializable {
    public static final String ELEMENT_NAME = "Icons";

    public static Icons createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        Icons icons = new Icons();
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            if (n2 == 2 && "Icon".equals((Object)string)) {
                icons.add((Object)Icon.createFromParser(xmlPullParser));
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return icons;
    }
}

