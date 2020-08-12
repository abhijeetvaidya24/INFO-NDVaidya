/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.model.vast.Ad
 *  com.aerserv.sdk.model.vast.Creative
 *  com.aerserv.sdk.model.vast.InLine
 *  com.aerserv.sdk.model.vast.LinearCreative
 *  com.aerserv.sdk.model.vast.Wrapper
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.Serializable
 *  java.io.StringReader
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 *  java.util.SortedSet
 *  java.util.TreeSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package com.aerserv.sdk.model.vast;

import com.aerserv.sdk.analytics.AerServAnalytics;
import com.aerserv.sdk.analytics.AerServAnalyticsUtils;
import com.aerserv.sdk.model.vast.Ad;
import com.aerserv.sdk.model.vast.Creative;
import com.aerserv.sdk.model.vast.Creatives;
import com.aerserv.sdk.model.vast.InLine;
import com.aerserv.sdk.model.vast.LinearCreative;
import com.aerserv.sdk.model.vast.MediaFile;
import com.aerserv.sdk.model.vast.Wrapper;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.VASTUtils;
import com.aerserv.sdk.utils.VastErrorHandler;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class VAST
implements Serializable {
    public static final String ELEMENT_NAME = "VAST";
    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String LOG_TAG = "VAST";
    private static final String SEQUENCE_ATTRIBUTE_NAME = "sequence";
    private static final String VERSION_ATTRIBUTE_NAME = "version";
    private static final long serialVersionUID = -4731883515971181112L;
    private TreeSet<Ad> ads = new TreeSet();
    private String version;
    private VAST wrappedVast;

    private static VAST createFromParser(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        VAST vAST = new VAST();
        vAST.version = xmlPullParser.getAttributeValue(null, VERSION_ATTRIBUTE_NAME);
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        boolean bl = true;
        do {
            if (n2 == 3 && "VAST".equals((Object)string)) {
                if (AerServAnalytics.getInstance().isEnabled() && (bl || vAST.ads.size() == 0)) {
                    AerServAnalytics.getInstance().addVastParseError("Empty VAST");
                }
                if (bl) {
                    VastErrorHandler.fireError(VastErrorHandler.Error.EMPTY_VAST);
                    return vAST;
                }
                if (vAST.ads.size() == 0) {
                    VastErrorHandler.fireError(VastErrorHandler.Error.MISSING_INLINE_AD_ELEMENT);
                }
                return vAST;
            }
            if (!"VAST".equals((Object)string)) {
                bl = false;
            }
            if (n2 == 2 && "Ad".equals((Object)string)) {
                Ad ad = VAST.parseAdObject(xmlPullParser);
                vAST.ads.add((Object)ad);
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        } while (true);
    }

    private static Ad parseAdObject(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n2 = xmlPullParser.getEventType();
        String string = xmlPullParser.getName();
        InLine inLine = null;
        String string2 = xmlPullParser.getAttributeValue(null, ID_ATTRIBUTE_NAME);
        String string3 = xmlPullParser.getAttributeValue(null, SEQUENCE_ATTRIBUTE_NAME);
        Integer n3 = string3 != null && string3.length() != 0 ? Integer.valueOf((String)string3) : null;
        boolean bl = false;
        do {
            block39 : {
                InLine inLine2;
                block41 : {
                    block40 : {
                        if (n2 == 3 && "Ad".equals((Object)string)) {
                            boolean bl2 = inLine instanceof InLine;
                            if (bl2) {
                                InLine inLine3 = inLine;
                                if (inLine3.getCreatives() != null && !inLine3.getCreatives().isEmpty()) {
                                    Iterator iterator = inLine3.getCreatives().iterator();
                                    boolean bl3 = false;
                                    boolean bl4 = false;
                                    while (iterator.hasNext()) {
                                        LinearCreative linearCreative;
                                        Creative creative = (Creative)iterator.next();
                                        if (!(creative instanceof LinearCreative) || (linearCreative = (LinearCreative)creative).getMediaFiles() == null) continue;
                                        for (MediaFile mediaFile : linearCreative.getMediaFiles()) {
                                            if (mediaFile.getMimeType() != null) {
                                                boolean bl5 = bl4 || mediaFile.getMimeType().endsWith("mp4") || mediaFile.getMimeType().endsWith("3gpp") || mediaFile.getMimeType().endsWith("javascript");
                                                bl4 = bl5;
                                            }
                                            bl3 = true;
                                        }
                                    }
                                    if (!bl3) {
                                        VastErrorHandler.fireError(VastErrorHandler.Error.MISSING_INLINE_MEDIA_FILE_ELEMENT);
                                    }
                                    if (!bl4) {
                                        VastErrorHandler.fireError(VastErrorHandler.Error.NO_SUPPORTED_MEDIA_TYPE_FOUND);
                                    }
                                } else {
                                    VastErrorHandler.fireError(VastErrorHandler.Error.MISSING_INLINE_CREATIVES_ELEMENT);
                                }
                            } else if (inLine instanceof Wrapper) {
                                Wrapper wrapper = (Wrapper)inLine;
                                if (wrapper.getCreatives() == null || wrapper.getCreatives().isEmpty()) {
                                    VastErrorHandler.fireError(VastErrorHandler.Error.MISSING_WRAPPER_CREATIVES_ELEMENT);
                                }
                                if (wrapper.getAdTagUri() == null) {
                                    VastErrorHandler.fireError(VastErrorHandler.Error.MISSING_VAST_AD_TAG_URI_ELEMENT);
                                }
                            } else if (!bl) {
                                VastErrorHandler.fireError(VastErrorHandler.Error.MISSING_INLINE_AND_WRAPPER_ELEMENTS);
                            }
                            if (AerServAnalytics.getInstance().isEnabled()) {
                                if (bl2) {
                                    InLine inLine4 = inLine;
                                    if (inLine4.getCreatives() != null && !inLine4.getCreatives().isEmpty()) {
                                        Iterator iterator = inLine4.getCreatives().iterator();
                                        boolean bl6 = false;
                                        boolean bl7 = false;
                                        while (iterator.hasNext()) {
                                            LinearCreative linearCreative;
                                            Creative creative = (Creative)iterator.next();
                                            if (!(creative instanceof LinearCreative) || (linearCreative = (LinearCreative)creative).getMediaFiles() == null) continue;
                                            for (MediaFile mediaFile : linearCreative.getMediaFiles()) {
                                                if (mediaFile.getMimeType() != null) {
                                                    boolean bl8 = bl7 || mediaFile.getMimeType().endsWith("mp4") || mediaFile.getMimeType().endsWith("3gpp") || mediaFile.getMimeType().endsWith("javascript");
                                                    bl7 = bl8;
                                                }
                                                bl6 = true;
                                            }
                                        }
                                        if (!bl6) {
                                            AerServAnalytics.getInstance().addVastParseError("Missing MediaFile element");
                                        }
                                        if (!bl7) {
                                            AerServAnalytics.getInstance().addVastParseError("No supported media type found");
                                        }
                                    } else {
                                        AerServAnalytics.getInstance().addVastParseError("Missing inline Creatives element");
                                    }
                                } else if (inLine instanceof Wrapper) {
                                    Wrapper wrapper = (Wrapper)inLine;
                                    if (wrapper.getCreatives() == null || wrapper.getCreatives().isEmpty()) {
                                        AerServAnalytics.getInstance().addVastParseError("Missing wrapper Creatives element");
                                    }
                                    if (wrapper.getAdTagUri() == null) {
                                        AerServAnalytics.getInstance().addVastParseError("Missing VASTAdTagURI element");
                                    }
                                } else if (!bl) {
                                    AerServAnalytics.getInstance().addVastParseError("Missing InLine and Wrapper elements");
                                }
                            }
                            if (inLine != null) {
                                inLine.id = string2;
                                inLine.sequencePosition = n3;
                            }
                            return inLine;
                        }
                        if (n2 != 2) break block39;
                        if (!"InLine".equals((Object)string)) break block40;
                        inLine2 = InLine.createFromParser((XmlPullParser)xmlPullParser);
                        if (inLine2.impressionUris.isEmpty() && !VASTUtils.inLineContainsVpaid(inLine2)) {
                            AerServLog.d(LOG_TAG, "Throwing away inline vast because it doesn't have an impression element");
                            if (AerServAnalytics.getInstance().isEnabled() && (inLine2.impressionUris == null || inLine2.impressionUris.isEmpty())) {
                                AerServAnalytics.getInstance().addVastParseError("Missing inline Impression element");
                            }
                            if (inLine2.impressionUris == null || inLine2.impressionUris.isEmpty()) {
                                VastErrorHandler.fireError(VastErrorHandler.Error.MISSING_INLINE_IMPRESSION_ELEMENT);
                            }
                            inLine2 = inLine;
                        }
                        break block41;
                    }
                    if (!"Wrapper".equals((Object)string)) break block39;
                    inLine2 = Wrapper.createFromParser((XmlPullParser)xmlPullParser);
                }
                inLine = inLine2;
                bl = true;
            }
            n2 = xmlPullParser.next();
            string = xmlPullParser.getName();
        } while (true);
    }

    public static VAST parseXml(String string) throws XmlPullParserException, IOException {
        String string2 = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parseXml being called with on: ");
        stringBuilder.append(string);
        AerServLog.v(string2, stringBuilder.toString());
        if (AerServAnalytics.getInstance().isEnabled()) {
            AerServAnalytics.getInstance().addTransientValue("vast", "parseXml", "vastXml", string);
            String string3 = AerServAnalyticsUtils.findValueInUrl(string, "iline");
            AerServAnalytics.getInstance().addValue("vast", "parseXml", "iline", string3, false);
            String string4 = AerServAnalyticsUtils.findValueInUrl(string, "icid");
            AerServAnalytics.getInstance().addValue("vast", "parseXml", "icid", string4, false);
        }
        VAST vAST = null;
        XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
        xmlPullParserFactory.setNamespaceAware(true);
        XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
        xmlPullParser.setInput((Reader)new StringReader(string));
        int n2 = xmlPullParser.getEventType();
        while (n2 != 1) {
            if (n2 == 2 && "VAST".equals((Object)xmlPullParser.getName())) {
                vAST = VAST.createFromParser(xmlPullParser);
            }
            n2 = xmlPullParser.next();
        }
        return vAST;
    }

    public TreeSet<Ad> getAds() {
        return new TreeSet(this.ads);
    }

    public String getVersion() {
        return this.version;
    }

    public VAST getWrappedVAST() {
        return this.wrappedVast;
    }

    public void setWrappedVast(VAST vAST) {
        this.wrappedVast = vAST;
    }
}

