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
package com.integralads.avid.library.adcolony.session.internal;

import android.content.Context;
import com.integralads.avid.library.adcolony.AvidContext;
import com.integralads.avid.library.adcolony.session.ExternalAvidAdSessionContext;
import org.json.JSONException;
import org.json.JSONObject;

public class InternalAvidAdSessionContext {
    private String a;
    private ExternalAvidAdSessionContext b;
    private String c;
    private String d;

    public InternalAvidAdSessionContext(Context context, String string, String string2, String string3, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidContext.getInstance().init(context);
        this.a = string;
        this.b = externalAvidAdSessionContext;
        this.c = string2;
        this.d = string3;
    }

    public String getAvidAdSessionId() {
        return this.a;
    }

    public JSONObject getFullContext() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avidAdSessionId", (Object)this.a);
            jSONObject.put("bundleIdentifier", (Object)AvidContext.getInstance().getBundleId());
            jSONObject.put("partner", (Object)AvidContext.getInstance().getPartnerName());
            jSONObject.put("partnerVersion", (Object)this.b.getPartnerVersion());
            jSONObject.put("avidLibraryVersion", (Object)AvidContext.getInstance().getAvidVersion());
            jSONObject.put("avidAdSessionType", (Object)this.c);
            jSONObject.put("mediaType", (Object)this.d);
            jSONObject.put("isDeferred", this.b.isDeferred());
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
            jSONObject.put("avidApiLevel", (Object)"2");
            jSONObject.put("mode", (Object)"stub");
            return jSONObject;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return jSONObject;
        }
    }
}

