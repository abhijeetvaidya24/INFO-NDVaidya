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
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.aerserv.sdk.model.vast;

import android.net.Uri;
import com.aerserv.sdk.model.vast.AdResource;
import com.aerserv.sdk.model.vast.HTMLAdResource;
import com.aerserv.sdk.model.vast.IFrameAdResource;
import com.aerserv.sdk.model.vast.IconClicks;
import com.aerserv.sdk.model.vast.StaticAdResource;
import com.aerserv.sdk.utils.AerServLog;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class Icon
implements Serializable {
    public static final String DURATION_ATTR_NAME = "duration";
    public static final String ELEMENT_NAME = "Icon";
    public static final String HEIGHT_ATTR_NAME = "height";
    public static final String ICON_CLICKS_ELEMENT_NAME = "IconClicks";
    public static final String ICON_VIEW_TRACKING_ELEMENT_NAME = "IconViewTracking";
    private static final String LOG_TAG = "com.aerserv.sdk.model.vast.Icon";
    public static final String OFFSET_ATTR_NAME = "offset";
    public static final String PROGRAM_ATTR_NAME = "program";
    private static final String STATIC_AD_RESOURCE_CREATIVE_TYPE_ATTRIBUTE_NAME = "creativeType";
    private static final String STATIC_AD_RESOURCE_TYPE_ATTRIBUTE_NAME = "type";
    public static final String WIDTH_ATTR_NAME = "width";
    public static final String X_POSITION_ATTR_NAME = "xPosition";
    public static final String Y_POSITION_ATTR_NAME = "yPosition";
    private String duration;
    private Integer height;
    private IconClicks iconClicks;
    private String offset;
    private String program;
    private List<AdResource> resourceList = new ArrayList();
    private String viewTrackingUri;
    private Integer width;
    private String xPosition;
    private String yPosition;

    public static Icon createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        Icon icon = new Icon();
        do {
            if (n2 == 2) {
                String string2;
                Uri uri;
                if (ELEMENT_NAME.equals((Object)string)) {
                    icon.program = xmlPullParser.getAttributeValue(null, PROGRAM_ATTR_NAME);
                    try {
                        icon.width = Integer.valueOf((String)xmlPullParser.getAttributeValue(null, WIDTH_ATTR_NAME));
                        icon.height = Integer.valueOf((String)xmlPullParser.getAttributeValue(null, HEIGHT_ATTR_NAME));
                    }
                    catch (Exception exception) {
                        String string3 = LOG_TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Error parsing Icon width or height: ");
                        stringBuilder.append(exception.getMessage());
                        AerServLog.w(string3, stringBuilder.toString());
                    }
                    icon.xPosition = xmlPullParser.getAttributeValue(null, X_POSITION_ATTR_NAME);
                    icon.yPosition = xmlPullParser.getAttributeValue(null, Y_POSITION_ATTR_NAME);
                    icon.offset = xmlPullParser.getAttributeValue(null, OFFSET_ATTR_NAME);
                    icon.duration = xmlPullParser.getAttributeValue(null, DURATION_ATTR_NAME);
                } else if ("StaticResource".equals((Object)string)) {
                    StaticAdResource staticAdResource = new StaticAdResource();
                    String string4 = xmlPullParser.getAttributeValue(null, STATIC_AD_RESOURCE_CREATIVE_TYPE_ATTRIBUTE_NAME);
                    if (string4 == null) {
                        string4 = xmlPullParser.getAttributeValue(null, STATIC_AD_RESOURCE_TYPE_ATTRIBUTE_NAME);
                    }
                    staticAdResource.setMimeType(string4);
                    staticAdResource.setResourceUri(xmlPullParser.nextText().trim());
                    icon.resourceList.add((Object)staticAdResource);
                } else if ("IFrameResource".equals((Object)string)) {
                    IFrameAdResource iFrameAdResource = new IFrameAdResource();
                    iFrameAdResource.setiFrameUri(xmlPullParser.nextText().trim());
                    icon.resourceList.add((Object)iFrameAdResource);
                } else if ("HTMLResource".equals((Object)string)) {
                    HTMLAdResource hTMLAdResource = new HTMLAdResource();
                    hTMLAdResource.setHtml(xmlPullParser.nextText());
                    icon.resourceList.add((Object)hTMLAdResource);
                } else if (ICON_CLICKS_ELEMENT_NAME.equals((Object)string)) {
                    icon.iconClicks = IconClicks.createFromParser(xmlPullParser);
                } else if (ICON_VIEW_TRACKING_ELEMENT_NAME.equals((Object)string) && (uri = (string2 = xmlPullParser.nextText()) == null ? null : Uri.parse((String)string2.trim())) != null) {
                    icon.viewTrackingUri = uri.toString();
                }
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        } while (n2 != 3 || !ELEMENT_NAME.equals((Object)string));
        return icon;
    }

    public String getDuration() {
        return this.duration;
    }

    public Integer getHeight() {
        return this.height;
    }

    public IconClicks getIconClicks() {
        return this.iconClicks;
    }

    public String getOffset() {
        return this.offset;
    }

    public String getProgram() {
        return this.program;
    }

    public List<AdResource> getResourceList() {
        return this.resourceList;
    }

    public String getViewTrackingUri() {
        return this.viewTrackingUri;
    }

    public Integer getWidth() {
        return this.width;
    }

    public String getxPosition() {
        return this.xPosition;
    }

    public String getyPosition() {
        return this.yPosition;
    }
}

