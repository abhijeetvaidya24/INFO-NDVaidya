/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.events;

import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.events.AbstractEventsFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class IronbeastEventsFormatter
extends AbstractEventsFormatter {
    private final String DEFAULT_IB_EVENTS_URL = "https://track.atom-data.io";
    private final String IB_KEY_DATA = "data";
    private final String IB_KEY_TABLE = "table";
    private final String IB_TABLE_NAME = "super.dwh.mediation_events";

    IronbeastEventsFormatter(int n2) {
        this.mAdUnit = n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public String format(ArrayList<EventData> arrayList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        this.mGeneralProperties = jSONObject == null ? new JSONObject() : jSONObject;
        try {
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    JSONObject jSONObject3 = this.createJSONForEvent((EventData)iterator.next());
                    if (jSONObject3 == null) continue;
                    jSONArray.put((Object)jSONObject3);
                }
            }
            jSONObject2.put("table", (Object)"super.dwh.mediation_events");
            jSONObject2.put("data", (Object)this.createDataToSend(jSONArray));
            return jSONObject2.toString();
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return jSONObject2.toString();
    }

    @Override
    public String getDefaultEventsUrl() {
        return "https://track.atom-data.io";
    }

    @Override
    public String getFormatterType() {
        return "ironbeast";
    }
}

