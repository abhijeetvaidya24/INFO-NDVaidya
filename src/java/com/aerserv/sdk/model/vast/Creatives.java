/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.model.vast.CompanionAdsCreative
 *  com.aerserv.sdk.model.vast.Creative
 *  com.aerserv.sdk.model.vast.LinearCreative
 *  com.aerserv.sdk.model.vast.NonLinearAdsCreative
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.SortedSet
 *  java.util.TreeSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import com.aerserv.sdk.model.vast.CompanionAdsCreative;
import com.aerserv.sdk.model.vast.Creative;
import com.aerserv.sdk.model.vast.LinearCreative;
import com.aerserv.sdk.model.vast.NonLinearAdsCreative;
import com.aerserv.sdk.utils.AerServLog;
import java.io.IOException;
import java.io.Serializable;
import java.util.SortedSet;
import java.util.TreeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class Creatives
extends TreeSet<Creative>
implements Serializable {
    public static final String AD_ID_ATTRIBUTE_NAME = "AdID";
    public static final String ELEMENT_NAME = "Creatives";
    public static final String ID_ATTRIBUTE_NAME = "id";
    private static final String LOG_TAG = "com.aerserv.sdk.model.vast.Creatives";
    public static final String SEQUENCE_ATTRIBUTE_NAME = "sequence";
    private static final long serialVersionUID = 8773439605354981861L;

    public Creatives() {
    }

    public Creatives(Creatives creatives) {
        super((SortedSet)creatives);
    }

    public static Creatives createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        Creatives creatives = new Creatives();
        String string2 = null;
        String string3 = null;
        Integer n3 = null;
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            if (n2 == 2) {
                if ("Creative".equals((Object)string)) {
                    String string4;
                    String string5;
                    Integer n4;
                    block14 : {
                        block13 : {
                            string5 = xmlPullParser.getAttributeValue(null, ID_ATTRIBUTE_NAME);
                            string4 = xmlPullParser.getAttributeValue(null, AD_ID_ATTRIBUTE_NAME);
                            String string6 = xmlPullParser.getAttributeValue(null, SEQUENCE_ATTRIBUTE_NAME);
                            if (string6 != null) {
                                try {
                                    if (string6.length() == 0) break block13;
                                    n4 = Integer.valueOf((String)string6);
                                    break block14;
                                }
                                catch (Exception exception) {
                                    String string7 = LOG_TAG;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Could not parse creative sequence: ");
                                    stringBuilder.append(exception.getMessage());
                                    AerServLog.i(string7, stringBuilder.toString());
                                }
                            }
                        }
                        n4 = null;
                    }
                    string3 = string4;
                    n3 = n4;
                    string2 = string5;
                } else if ("Linear".equals((Object)string)) {
                    LinearCreative linearCreative = LinearCreative.createFromParser((XmlPullParser)xmlPullParser);
                    linearCreative.creativeId = string2;
                    linearCreative.adId = string3;
                    linearCreative.sequencePosition = n3;
                    creatives.add((Object)linearCreative);
                } else if ("CompanionAds".equals((Object)string)) {
                    CompanionAdsCreative companionAdsCreative = CompanionAdsCreative.createFromParser((XmlPullParser)xmlPullParser);
                    companionAdsCreative.creativeId = string2;
                    companionAdsCreative.adId = string3;
                    companionAdsCreative.sequencePosition = n3;
                    creatives.add((Object)companionAdsCreative);
                } else if ("NonLinearAds".equals((Object)string)) {
                    NonLinearAdsCreative nonLinearAdsCreative = NonLinearAdsCreative.createFromParser((XmlPullParser)xmlPullParser);
                    nonLinearAdsCreative.creativeId = string2;
                    nonLinearAdsCreative.adId = string3;
                    nonLinearAdsCreative.sequencePosition = n3;
                    creatives.add((Object)nonLinearAdsCreative);
                }
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return creatives;
    }
}

