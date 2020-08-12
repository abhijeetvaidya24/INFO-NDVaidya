/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.events;

import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.events.AbstractEventsFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class OutcomeEventsFormatter
extends AbstractEventsFormatter {
    private final String DEFAULT_OC_EVENTS_URL = "https://outcome.supersonicads.com/mediation/";

    OutcomeEventsFormatter(int n2) {
        this.mAdUnit = n2;
    }

    @Override
    public String format(ArrayList<EventData> arrayList, JSONObject jSONObject) {
        this.mGeneralProperties = jSONObject == null ? new JSONObject() : jSONObject;
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                JSONObject jSONObject2 = this.createJSONForEvent((EventData)iterator.next());
                if (jSONObject2 == null) continue;
                jSONArray.put((Object)jSONObject2);
            }
        }
        return this.createDataToSend(jSONArray);
    }

    @Override
    public String getDefaultEventsUrl() {
        return "https://outcome.supersonicads.com/mediation/";
    }

    @Override
    public String getFormatterType() {
        return "outcome";
    }
}

