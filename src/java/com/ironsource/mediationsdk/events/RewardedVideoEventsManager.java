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

public class RewardedVideoEventsManager
extends BaseEventsManager {
    private static RewardedVideoEventsManager sInstance;
    private String mCurrentOWPlacment;
    private String mCurrentRVPlacment;

    private RewardedVideoEventsManager() {
        this.mFormatterType = "outcome";
        this.mAdUnitType = 3;
        this.mEventType = "RV";
        this.mCurrentRVPlacment = "";
        this.mCurrentOWPlacment = "";
    }

    public static RewardedVideoEventsManager getInstance() {
        Class<RewardedVideoEventsManager> class_ = RewardedVideoEventsManager.class;
        synchronized (RewardedVideoEventsManager.class) {
            if (sInstance == null) {
                sInstance = new RewardedVideoEventsManager();
                sInstance.initState();
            }
            RewardedVideoEventsManager rewardedVideoEventsManager = sInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return rewardedVideoEventsManager;
        }
    }

    @Override
    protected String getCurrentPlacement(int n2) {
        if (n2 != 15 && (n2 < 300 || n2 >= 400)) {
            return this.mCurrentRVPlacment;
        }
        return this.mCurrentOWPlacment;
    }

    @Override
    protected int getSessionDepth(EventData eventData) {
        int n2 = SessionDepthManager.getInstance().getSessionDepth(1);
        if (eventData.getEventId() == 15 || eventData.getEventId() >= 300 && eventData.getEventId() < 400) {
            n2 = SessionDepthManager.getInstance().getSessionDepth(0);
        }
        return n2;
    }

    @Override
    protected boolean increaseSessionDepthIfNeeded(EventData eventData) {
        if (eventData.getEventId() == 6) {
            SessionDepthManager.getInstance().increaseSessionDepth(1);
            return false;
        }
        if (eventData.getEventId() == 305) {
            SessionDepthManager.getInstance().increaseSessionDepth(0);
        }
        return false;
    }

    @Override
    protected boolean isTopPriorityEvent(EventData eventData) {
        return eventData.getEventId() == 6 || eventData.getEventId() == 5 || eventData.getEventId() == 10 || eventData.getEventId() == 14 || eventData.getEventId() == 305;
        {
        }
    }

    @Override
    protected void setCurrentPlacement(EventData eventData) {
        if (eventData.getEventId() != 15 && (eventData.getEventId() < 300 || eventData.getEventId() >= 400)) {
            this.mCurrentRVPlacment = eventData.getAdditionalDataJSON().optString("placement");
            return;
        }
        this.mCurrentOWPlacment = eventData.getAdditionalDataJSON().optString("placement");
    }

    @Override
    protected boolean shouldExtractCurrentPlacement(EventData eventData) {
        return eventData.getEventId() == 2 || eventData.getEventId() == 10;
        {
        }
    }

    @Override
    protected boolean shouldIncludeCurrentPlacement(EventData eventData) {
        return eventData.getEventId() == 5 || eventData.getEventId() == 6 || eventData.getEventId() == 8 || eventData.getEventId() == 9 || eventData.getEventId() == 19 || eventData.getEventId() == 20 || eventData.getEventId() == 305;
        {
        }
    }
}

