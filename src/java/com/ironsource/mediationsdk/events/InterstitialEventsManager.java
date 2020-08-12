/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.events;

import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.events.BaseEventsManager;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import org.json.JSONObject;

public class InterstitialEventsManager
extends BaseEventsManager {
    private static InterstitialEventsManager sInstance;
    private String mCurrentISPlacement;

    private InterstitialEventsManager() {
        this.mFormatterType = "ironbeast";
        this.mAdUnitType = 2;
        this.mEventType = "IS";
        this.mCurrentISPlacement = "";
    }

    public static InterstitialEventsManager getInstance() {
        Class<InterstitialEventsManager> class_ = InterstitialEventsManager.class;
        synchronized (InterstitialEventsManager.class) {
            if (sInstance == null) {
                sInstance = new InterstitialEventsManager();
                sInstance.initState();
            }
            InterstitialEventsManager interstitialEventsManager = sInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return interstitialEventsManager;
        }
    }

    @Override
    protected String getCurrentPlacement(int n2) {
        return this.mCurrentISPlacement;
    }

    @Override
    protected int getSessionDepth(EventData eventData) {
        boolean bl = eventData.getEventId() >= 3000 && eventData.getEventId() < 4000;
        SessionDepthManager sessionDepthManager = SessionDepthManager.getInstance();
        int n2 = bl ? 3 : 2;
        return sessionDepthManager.getSessionDepth(n2);
    }

    @Override
    protected boolean increaseSessionDepthIfNeeded(EventData eventData) {
        if (eventData.getEventId() == 26) {
            SessionDepthManager.getInstance().increaseSessionDepth(2);
        } else if (eventData.getEventId() == 3305) {
            SessionDepthManager.getInstance().increaseSessionDepth(3);
        }
        return false;
    }

    @Override
    protected boolean isTopPriorityEvent(EventData eventData) {
        return eventData.getEventId() == 26 || eventData.getEventId() == 25 || eventData.getEventId() == 3005 || eventData.getEventId() == 3015;
        {
        }
    }

    @Override
    protected void setCurrentPlacement(EventData eventData) {
        this.mCurrentISPlacement = eventData.getAdditionalDataJSON().optString("placement");
    }

    @Override
    protected boolean shouldExtractCurrentPlacement(EventData eventData) {
        return eventData.getEventId() == 23 || eventData.getEventId() == 3001;
        {
        }
    }

    @Override
    protected boolean shouldIncludeCurrentPlacement(EventData eventData) {
        return eventData.getEventId() == 25 || eventData.getEventId() == 26 || eventData.getEventId() == 28 || eventData.getEventId() == 29 || eventData.getEventId() == 34;
        {
        }
    }
}

