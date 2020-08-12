/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import android.net.Uri;
import com.aerserv.sdk.model.vast.DeliveryMethod;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.VASTUtils;
import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class MediaFile
implements Serializable {
    private static final String API_FRAMEWORK_ATTRIBUTE_NAME = "apiFramework";
    private static final String DELIVERY_ATTRIBUTE_NAME = "delivery";
    public static final String ELEMENT_NAME = "MediaFile";
    private static final String HEIGHT_ATTRIBUTE_NAME = "height";
    private static final String MIME_TYPE_ATTRIBUTE_NAME = "type";
    public static final String VPAID_API_FRAMEWORK = "VPAID";
    private static final String WIDTH_ATTRIBUTE_NAME = "width";
    private static final long serialVersionUID = -8739593100332448185L;
    private String apiFramework;
    private DeliveryMethod deliveryMethod;
    private int height;
    private String mediaUri;
    private String mimeType;
    private int width;

    public static MediaFile createFromParser(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        MediaFile mediaFile = new MediaFile();
        do {
            if (n2 == 2 && ELEMENT_NAME.equals((Object)string)) {
                mediaFile.deliveryMethod = DeliveryMethod.get(xmlPullParser.getAttributeValue(null, DELIVERY_ATTRIBUTE_NAME));
                mediaFile.width = VASTUtils.safeToInt(xmlPullParser.getAttributeValue(null, WIDTH_ATTRIBUTE_NAME));
                mediaFile.height = VASTUtils.safeToInt(xmlPullParser.getAttributeValue(null, HEIGHT_ATTRIBUTE_NAME));
                mediaFile.apiFramework = xmlPullParser.getAttributeValue(null, API_FRAMEWORK_ATTRIBUTE_NAME);
                String string2 = xmlPullParser.getAttributeValue(null, MIME_TYPE_ATTRIBUTE_NAME);
                String string3 = xmlPullParser.nextText();
                Uri uri = string3 == null ? null : Uri.parse((String)string3.trim());
                if (uri != null) {
                    mediaFile.mediaUri = uri.toString();
                }
                mediaFile.mimeType = string2;
                String string4 = MediaFile.class.getSimpleName();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mimeType determined to be: ");
                stringBuilder.append(mediaFile.mimeType);
                AerServLog.v(string4, stringBuilder.toString());
                n2 = xmlPullParser.getEventType();
            } else {
                n2 = xmlPullParser.next();
            }
            string = xmlPullParser.getName();
        } while (n2 != 3 || !ELEMENT_NAME.equals((Object)string));
        return mediaFile;
    }

    public String getApiFramework() {
        return this.apiFramework;
    }

    public DeliveryMethod getDeliveryMethod() {
        return this.deliveryMethod;
    }

    public int getHeight() {
        return this.height;
    }

    public String getMediaUri() {
        return this.mediaUri;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getWidth() {
        return this.width;
    }
}

