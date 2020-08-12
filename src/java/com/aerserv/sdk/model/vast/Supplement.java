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

import com.aerserv.sdk.model.vast.Banner;
import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class Supplement
implements Serializable {
    public static final String ELEMENT_NAME = "Supplement";
    private static final long serialVersionUID = -1454018585324733039L;
    private Banner banner;

    public static Supplement createFromParser(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        Supplement supplement = new Supplement();
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            if (n2 == 2 && "Banner".equals((Object)string)) {
                supplement.banner = Banner.createFromParser(xmlPullParser);
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return supplement;
    }

    public Banner getBanner() {
        return this.banner;
    }
}

