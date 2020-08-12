/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import com.integralads.avid.library.mopub.AvidContext;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
import org.json.JSONException;
import org.json.JSONObject;

public class InternalAvidAdSessionContext {
    public static final String AVID_API_LEVEL = "2";
    public static final String AVID_STUB_MODE = "stub";
    public static final String CONTEXT_AVID_AD_SESSION_ID = "avidAdSessionId";
    public static final String CONTEXT_AVID_AD_SESSION_TYPE = "avidAdSessionType";
    public static final String CONTEXT_AVID_API_LEVEL = "avidApiLevel";
    public static final String CONTEXT_AVID_LIBRARY_VERSION = "avidLibraryVersion";
    public static final String CONTEXT_BUNDLE_IDENTIFIER = "bundleIdentifier";
    public static final String CONTEXT_IS_DEFERRED = "isDeferred";
    public static final String CONTEXT_MEDIA_TYPE = "mediaType";
    public static final String CONTEXT_MODE = "mode";
    public static final String CONTEXT_PARTNER = "partner";
    public static final String CONTEXT_PARTNER_VERSION = "partnerVersion";
    private ExternalAvidAdSessionContext avidAdSessionContext;
    private String avidAdSessionId;
    private String avidAdSessionType;
    private String mediaType;

    public InternalAvidAdSessionContext(Context context, String string, String string2, String string3, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidContext.getInstance().init(context);
        this.avidAdSessionId = string;
        this.avidAdSessionContext = externalAvidAdSessionContext;
        this.avidAdSessionType = string2;
        this.mediaType = string3;
    }

    public ExternalAvidAdSessionContext getAvidAdSessionContext() {
        return this.avidAdSessionContext;
    }

    public String getAvidAdSessionId() {
        return this.avidAdSessionId;
    }

    public JSONObject getFullContext() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CONTEXT_AVID_AD_SESSION_ID, (Object)this.avidAdSessionId);
            jSONObject.put(CONTEXT_BUNDLE_IDENTIFIER, (Object)AvidContext.getInstance().getBundleId());
            jSONObject.put(CONTEXT_PARTNER, (Object)AvidContext.getInstance().getPartnerName());
            jSONObject.put(CONTEXT_PARTNER_VERSION, (Object)this.avidAdSessionContext.getPartnerVersion());
            jSONObject.put(CONTEXT_AVID_LIBRARY_VERSION, (Object)AvidContext.getInstance().getAvidVersion());
            jSONObject.put(CONTEXT_AVID_AD_SESSION_TYPE, (Object)this.avidAdSessionType);
            jSONObject.put(CONTEXT_MEDIA_TYPE, (Object)this.mediaType);
            jSONObject.put(CONTEXT_IS_DEFERRED, this.avidAdSessionContext.isDeferred());
            return jSONObject;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return jSONObject;
        }
    }

    public JSONObject getStubContext() {
        JSONObject jSONObject = this.getFullContext();
        try {
            jSONObject.put(CONTEXT_AVID_API_LEVEL, (Object)AVID_API_LEVEL);
            jSONObject.put(CONTEXT_MODE, (Object)AVID_STUB_MODE);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return jSONObject;
        }
    }

    public void setAvidAdSessionContext(ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        this.avidAdSessionContext = externalAvidAdSessionContext;
    }
}

