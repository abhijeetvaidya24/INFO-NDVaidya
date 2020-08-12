/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class Extension
implements Serializable {
    public static final String ELEMENT_NAME = "Extension";
    public static final String TYPE_ATTRIBUTE = "type";
    private static final long serialVersionUID = 5583198814589348693L;
    private String type = "";

    public static Extension createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        Extension extension = new Extension();
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            if (n2 == 2 && ELEMENT_NAME.equals((Object)string)) {
                extension.type = xmlPullParser.getAttributeValue(null, TYPE_ATTRIBUTE);
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return extension;
    }

    public String getType() {
        return this.type;
    }
}

