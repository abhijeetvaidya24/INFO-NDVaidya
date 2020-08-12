/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AerServAnalyticsEvent {
    public static final String ACTION_PARSE_XML = "parseXml";
    public static final String ACTION_REQUEST_AND_RENDER = "requestAndRender";
    public static final String CATEGORY_AD_REQUEST = "adRequest";
    public static final String CATEGORY_VAST = "vast";
    public static final String PARAM_BAD_VAST_XML = "badVastXml";
    public static final String PARAM_DURATION_MILLIS = "durationMillis";
    public static final String PARAM_EVENT = "event";
    public static final String PARAM_ICID = "icid";
    public static final String PARAM_ILINE = "iline";
    public static final String PARAM_PARSE_ERROR = "parseError";
    public static final String PARAM_VAST_VERSION = "vastVersion";
    public static final String PARAM_VAST_XML = "vastXml";
    public static final String VALUE_DOES_NOT_CONFORM_TO_SPEC = "Does not conform to spec";
    public static final String VALUE_EMPTY_VAST = "Empty VAST";
    public static final String VALUE_INVALID_XML = "Invalid XML";
    public static final String VALUE_MISSING_DELIVERY_OR_TYPE_ATTRIBUTE_IN_MEDIAFILE_ELEMENT = "Missing delivery or type attribute in MediaFile element";
    public static final String VALUE_MISSING_INLINE_AND_WRAPPER_ELEMENTS = "Missing InLine and Wrapper elements";
    public static final String VALUE_MISSING_INLINE_CREATIVES_ELEMENT = "Missing inline Creatives element";
    public static final String VALUE_MISSING_INLINE_IMPRESSION_ELEMENT = "Missing inline Impression element";
    public static final String VALUE_MISSING_INLINE_MEDIA_FILE_ELEMENT = "Missing MediaFile element";
    public static final String VALUE_MISSING_VAST_AD_TAG_URI_ELEMENT = "Missing VASTAdTagURI element";
    public static final String VALUE_MISSING_WRAPPER_CREATIVES_ELEMENT = "Missing wrapper Creatives element";
    public static final String VALUE_NO_SUPPORTED_MEDIA_TYPE_FOUND = "No supported media type found";
    private String action;
    private String category;
    private Map<String, Object> entries = new HashMap();
    private long timestamp;

    protected AerServAnalyticsEvent(String string, String string2) {
        this.category = string;
        this.action = string2;
        this.timestamp = System.currentTimeMillis();
    }

    protected void addArrayValue(String string, Object object) {
        if (this.entries.get((Object)string) == null || !(this.entries.get((Object)string) instanceof List)) {
            this.entries.put((Object)string, (Object)new ArrayList());
        }
        ((List)this.entries.get((Object)string)).add(object);
    }

    protected void addValue(String string, Object object) {
        this.entries.put((Object)string, object);
    }

    protected String getAction() {
        return this.action;
    }

    protected String getCategory() {
        return this.category;
    }

    protected Map<String, Object> getEntries() {
        return this.entries;
    }

    protected long getTimestamp() {
        return this.timestamp;
    }

    protected Object getValue(String string) {
        return this.entries.get((Object)string);
    }

    protected JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("category", (Object)this.getCategory());
        jSONObject.put("action", (Object)this.getAction());
        jSONObject.put("timestamp", this.getTimestamp());
        for (String string : this.getEntries().keySet()) {
            Object object = this.getEntries().get((Object)string);
            if (object instanceof List) {
                List list = (List)object;
                JSONArray jSONArray = new JSONArray();
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    jSONArray.put(iterator.next());
                }
                jSONObject.put(string, (Object)jSONArray);
                continue;
            }
            jSONObject.put(string, this.getEntries().get((Object)string));
        }
        return jSONObject;
    }
}

