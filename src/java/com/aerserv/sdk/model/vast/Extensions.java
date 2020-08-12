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

import com.aerserv.sdk.model.vast.Extension;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class Extensions
extends ArrayList<Extension>
implements Serializable {
    public static final String ELEMENT_NAME = "Extensions";
    private static final long serialVersionUID = -7301241949975187996L;

    public Extensions() {
    }

    public Extensions(Extensions extensions) {
        super((Collection)extensions);
    }

    public static Extensions createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        Extensions extensions = new Extensions();
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            if (n2 == 2 && "Extension".equals((Object)string)) {
                extensions.add((Object)Extension.createFromParser(xmlPullParser));
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return extensions;
    }
}

