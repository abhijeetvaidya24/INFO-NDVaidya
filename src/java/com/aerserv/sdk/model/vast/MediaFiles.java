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

import com.aerserv.sdk.analytics.AerServAnalytics;
import com.aerserv.sdk.model.vast.DeliveryMethod;
import com.aerserv.sdk.model.vast.MediaFile;
import com.aerserv.sdk.utils.StringUtils;
import com.aerserv.sdk.utils.VastErrorHandler;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class MediaFiles
extends ArrayList<MediaFile>
implements Serializable {
    public static final String ELEMENT_NAME = "MediaFiles";
    private static final long serialVersionUID = 4355742768182949621L;

    public MediaFiles() {
    }

    public MediaFiles(MediaFiles mediaFiles) {
        super((Collection)mediaFiles);
    }

    public static MediaFiles createFromParser(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        MediaFiles mediaFiles = new MediaFiles();
        while (n2 != 3 || !ELEMENT_NAME.equals((Object)string)) {
            if (n2 == 2 && "MediaFile".equals((Object)string)) {
                MediaFile mediaFile = MediaFile.createFromParser(xmlPullParser);
                if (mediaFile.getDeliveryMethod() != null && StringUtils.isNotBlank(mediaFile.getMimeType())) {
                    mediaFiles.add((Object)mediaFile);
                } else {
                    VastErrorHandler.fireError(VastErrorHandler.Error.MISSING_DELIVERY_OR_TYPE_ATTRIBUTE_IN_MEDIAFILE_ELEMENT);
                    if (AerServAnalytics.getInstance().isEnabled()) {
                        AerServAnalytics.getInstance().addVastParseError("Missing delivery or type attribute in MediaFile element");
                    }
                }
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        }
        return mediaFiles;
    }
}

