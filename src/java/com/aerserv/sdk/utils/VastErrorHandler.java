/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.controller.command.FireEventCommand
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.aerserv.sdk.utils;

import com.aerserv.sdk.controller.command.FireEventCommand;
import com.aerserv.sdk.utils.AerServLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VastErrorHandler {
    private static final String LOG_TAG = "com.aerserv.sdk.utils.VastErrorHandler";
    private static Map<Error, String> errorCodeMap;
    private static List<String> errorUriList;

    static {
        errorUriList = new ArrayList();
        errorCodeMap = new HashMap();
        errorCodeMap.put((Object)Error.DOES_NOT_CONFORM_TO_SPEC, (Object)"101");
        errorCodeMap.put((Object)Error.INVALID_XML, (Object)"100");
        errorCodeMap.put((Object)Error.MISSING_INLINE_AND_WRAPPER_ELEMENTS, (Object)"101");
        errorCodeMap.put((Object)Error.MISSING_INLINE_AD_ELEMENT, (Object)"101");
        errorCodeMap.put((Object)Error.MISSING_INLINE_IMPRESSION_ELEMENT, (Object)"101");
        errorCodeMap.put((Object)Error.MISSING_INLINE_MEDIA_FILE_ELEMENT, (Object)"101");
        errorCodeMap.put((Object)Error.MISSING_INLINE_CREATIVES_ELEMENT, (Object)"101");
        errorCodeMap.put((Object)Error.MISSING_DELIVERY_OR_TYPE_ATTRIBUTE_IN_MEDIAFILE_ELEMENT, (Object)"403");
        errorCodeMap.put((Object)Error.MISSING_WRAPPER_CREATIVES_ELEMENT, (Object)"101");
        errorCodeMap.put((Object)Error.MISSING_VAST_AD_TAG_URI_ELEMENT, (Object)"101");
        errorCodeMap.put((Object)Error.NO_SUPPORTED_MEDIA_TYPE_FOUND, (Object)"403");
        errorCodeMap.put((Object)Error.VIDEO_PLAYER_ERROR, (Object)"405");
        errorCodeMap.put((Object)Error.EMPTY_VAST, (Object)"303");
        errorCodeMap.put((Object)Error.GENERAL_COMPANION_ADS_ERROR, (Object)"600");
        errorCodeMap.put((Object)Error.UNDEFINED_ERROR, (Object)"900");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void addErrorUri(String string) {
        List<String> list;
        List<String> list2 = list = errorUriList;
        synchronized (list2) {
            errorUriList.add((Object)string);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void fireError(Error error) {
        List<String> list;
        ArrayList arrayList;
        List<String> list2 = list = errorUriList;
        synchronized (list2) {
            arrayList = new ArrayList(errorUriList);
            errorUriList.clear();
        }
        new Thread(new Runnable((List)arrayList, error){
            final /* synthetic */ Error val$error;
            final /* synthetic */ List val$errorUriListCopy;
            {
                this.val$errorUriListCopy = list;
                this.val$error = error;
            }

            public void run() {
                for (String string : this.val$errorUriListCopy) {
                    String string2 = (String)errorCodeMap.get((Object)this.val$error);
                    if (string2 != null) {
                        string = string.replace((CharSequence)"[ERRORCODE]", (CharSequence)string2);
                    } else {
                        String string3 = LOG_TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unmapped VAST error ");
                        stringBuilder.append(this.val$error.name());
                        AerServLog.i(string3, stringBuilder.toString());
                    }
                    new FireEventCommand(Arrays.asList((Object[])new String[]{string})).execute();
                }
            }
        }).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void newRequest() {
        List<String> list;
        List<String> list2 = list = errorUriList;
        synchronized (list2) {
            errorUriList.clear();
            return;
        }
    }

    public static final class Error
    extends Enum<Error> {
        private static final /* synthetic */ Error[] $VALUES;
        public static final /* enum */ Error DOES_NOT_CONFORM_TO_SPEC = new Error();
        public static final /* enum */ Error EMPTY_VAST;
        public static final /* enum */ Error GENERAL_COMPANION_ADS_ERROR;
        public static final /* enum */ Error INVALID_XML;
        public static final /* enum */ Error MISSING_DELIVERY_OR_TYPE_ATTRIBUTE_IN_MEDIAFILE_ELEMENT;
        public static final /* enum */ Error MISSING_INLINE_AD_ELEMENT;
        public static final /* enum */ Error MISSING_INLINE_AND_WRAPPER_ELEMENTS;
        public static final /* enum */ Error MISSING_INLINE_CREATIVES_ELEMENT;
        public static final /* enum */ Error MISSING_INLINE_IMPRESSION_ELEMENT;
        public static final /* enum */ Error MISSING_INLINE_MEDIA_FILE_ELEMENT;
        public static final /* enum */ Error MISSING_VAST_AD_TAG_URI_ELEMENT;
        public static final /* enum */ Error MISSING_WRAPPER_CREATIVES_ELEMENT;
        public static final /* enum */ Error NO_SUPPORTED_MEDIA_TYPE_FOUND;
        public static final /* enum */ Error UNDEFINED_ERROR;
        public static final /* enum */ Error VIDEO_PLAYER_ERROR;

        static {
            INVALID_XML = new Error();
            MISSING_INLINE_AND_WRAPPER_ELEMENTS = new Error();
            MISSING_INLINE_AD_ELEMENT = new Error();
            MISSING_INLINE_IMPRESSION_ELEMENT = new Error();
            MISSING_INLINE_MEDIA_FILE_ELEMENT = new Error();
            MISSING_INLINE_CREATIVES_ELEMENT = new Error();
            MISSING_DELIVERY_OR_TYPE_ATTRIBUTE_IN_MEDIAFILE_ELEMENT = new Error();
            MISSING_WRAPPER_CREATIVES_ELEMENT = new Error();
            MISSING_VAST_AD_TAG_URI_ELEMENT = new Error();
            NO_SUPPORTED_MEDIA_TYPE_FOUND = new Error();
            VIDEO_PLAYER_ERROR = new Error();
            EMPTY_VAST = new Error();
            GENERAL_COMPANION_ADS_ERROR = new Error();
            UNDEFINED_ERROR = new Error();
            Error[] arrerror = new Error[]{DOES_NOT_CONFORM_TO_SPEC, INVALID_XML, MISSING_INLINE_AND_WRAPPER_ELEMENTS, MISSING_INLINE_AD_ELEMENT, MISSING_INLINE_IMPRESSION_ELEMENT, MISSING_INLINE_MEDIA_FILE_ELEMENT, MISSING_INLINE_CREATIVES_ELEMENT, MISSING_DELIVERY_OR_TYPE_ATTRIBUTE_IN_MEDIAFILE_ELEMENT, MISSING_WRAPPER_CREATIVES_ELEMENT, MISSING_VAST_AD_TAG_URI_ELEMENT, NO_SUPPORTED_MEDIA_TYPE_FOUND, VIDEO_PLAYER_ERROR, EMPTY_VAST, GENERAL_COMPANION_ADS_ERROR, UNDEFINED_ERROR};
            $VALUES = arrerror;
        }

        public static Error valueOf(String string) {
            return (Error)Enum.valueOf(Error.class, (String)string);
        }

        public static Error[] values() {
            return (Error[])$VALUES.clone();
        }
    }

}

