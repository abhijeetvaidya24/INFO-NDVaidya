/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.text.TextUtils
 *  com.ironsource.mediationsdk.IronSourceObject
 *  com.ironsource.mediationsdk.events.BaseEventsManager$2
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.events;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.eventsmodule.DataBaseEventsStorage;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.eventsmodule.EventsSender;
import com.ironsource.eventsmodule.IEventsSenderResultListener;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.events.AbstractEventsFormatter;
import com.ironsource.mediationsdk.events.BaseEventsManager;
import com.ironsource.mediationsdk.events.EventsFormatterFactory;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ServerSegmetData;
import com.ironsource.mediationsdk.sdk.GeneralProperties;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseEventsManager {
    final String DATABASE_NAME = "supersonic_sdk.db";
    final int DATABASE_VERSION = 5;
    final int DEFAULT_BACKUP_THRESHOLD = 1;
    final int DEFAULT_MAX_EVENTS_PER_BATCH = 5000;
    final int DEFAULT_MAX_NUMBER_OF_EVENTS = 100;
    final String KEY_PLACEMENT = "placement";
    final String KEY_PROVIDER = "provider";
    private final String MEDIATION_ABT = "abt";
    int mAdUnitType;
    private int mBackupThreshold = 1;
    private Context mContext;
    private DataBaseEventsStorage mDbStorage;
    private EventThread mEventThread;
    String mEventType;
    private AbstractEventsFormatter mFormatter;
    String mFormatterType;
    private boolean mHadTopPriorityEvent = false;
    private boolean mHasServerResponse;
    private boolean mIsEventsEnabled = true;
    private ArrayList<EventData> mLocalEvents;
    private IronSourceLoggerManager mLoggerManager;
    private int mMaxEventsPerBatch = 5000;
    private int mMaxNumberOfEvents = 100;
    private int[] mOptOutEvents;
    private IronSourceSegment mSegment;
    private ServerSegmetData mServerSegmentData;
    private String mSessionId;
    private int mTotalEvents;

    static /* synthetic */ EventThread access$1300(BaseEventsManager baseEventsManager) {
        return baseEventsManager.mEventThread;
    }

    static /* synthetic */ int access$602(BaseEventsManager baseEventsManager, int n2) {
        baseEventsManager.mTotalEvents = n2;
        return n2;
    }

    static /* synthetic */ int access$608(BaseEventsManager baseEventsManager) {
        int n2 = baseEventsManager.mTotalEvents;
        baseEventsManager.mTotalEvents = n2 + 1;
        return n2;
    }

    private void backupEventsToDb() {
        this.mDbStorage.saveEvents((List<EventData>)this.mLocalEvents, this.mEventType);
        this.mLocalEvents.clear();
    }

    private ArrayList<EventData> initCombinedEventList(ArrayList<EventData> arrayList, ArrayList<EventData> arrayList2, int n2) {
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        Collections.sort((List)arrayList3, (Comparator)new Comparator<EventData>(){

            public int compare(EventData eventData, EventData eventData2) {
                if (eventData.getTimeStamp() >= eventData2.getTimeStamp()) {
                    return 1;
                }
                return -1;
            }
        });
        if (arrayList3.size() <= n2) {
            return new ArrayList((Collection)arrayList3);
        }
        ArrayList arrayList4 = new ArrayList((Collection)arrayList3.subList(0, n2));
        List list = arrayList3.subList(n2, arrayList3.size());
        this.mDbStorage.saveEvents((List<EventData>)list, this.mEventType);
        return arrayList4;
    }

    private void sendEvents() {
        this.mHadTopPriorityEvent = false;
        ArrayList<EventData> arrayList = this.mDbStorage.loadEvents(this.mEventType);
        ArrayList<EventData> arrayList2 = this.initCombinedEventList(this.mLocalEvents, arrayList, this.mMaxEventsPerBatch);
        this.mLocalEvents.clear();
        this.mDbStorage.clearEvents(this.mEventType);
        this.mTotalEvents = 0;
        if (arrayList2.size() > 0) {
            JSONObject jSONObject = GeneralProperties.getProperties().toJSON();
            try {
                this.updateSegmentsData(jSONObject);
                String string = IronSourceUtils.getAbt();
                if (!TextUtils.isEmpty((CharSequence)string)) {
                    jSONObject.put("abt", (Object)string);
                }
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            String string = this.mFormatter.format(arrayList2, jSONObject);
            EventsSender eventsSender = new EventsSender((IEventsSenderResultListener)new 2(this));
            Object[] arrobject = new Object[]{string, this.mFormatter.getEventsServerUrl(), arrayList2};
            eventsSender.execute(arrobject);
        }
    }

    private boolean shouldBackupEventsToDb(ArrayList<EventData> arrayList) {
        boolean bl2 = false;
        if (arrayList != null) {
            int n2 = arrayList.size();
            int n3 = this.mBackupThreshold;
            bl2 = false;
            if (n2 >= n3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private boolean shouldEventBeLogged(EventData eventData) {
        int[] arrn;
        if (eventData != null && (arrn = this.mOptOutEvents) != null && arrn.length > 0) {
            int[] arrn2;
            int n2 = eventData.getEventId();
            for (int i2 = 0; i2 < (arrn2 = this.mOptOutEvents).length; ++i2) {
                if (n2 != arrn2[i2]) continue;
                return false;
            }
        }
        return true;
    }

    private boolean shouldSendEvents() {
        return (this.mTotalEvents >= this.mMaxNumberOfEvents || this.mHadTopPriorityEvent) && this.mHasServerResponse;
    }

    private void updateSegmentsData(JSONObject jSONObject) {
        try {
            if (this.mSegment != null) {
                if (this.mSegment.getAge() > 0) {
                    jSONObject.put("age", this.mSegment.getAge());
                }
                if (!TextUtils.isEmpty((CharSequence)this.mSegment.getGender())) {
                    jSONObject.put("gen", (Object)this.mSegment.getGender());
                }
                if (this.mSegment.getLevel() > 0) {
                    jSONObject.put("lvl", this.mSegment.getLevel());
                }
                if (this.mSegment.getIsPaying() != null) {
                    jSONObject.put("pay", this.mSegment.getIsPaying().get());
                }
                if (this.mSegment.getIapt() > 0.0) {
                    jSONObject.put("iapt", this.mSegment.getIapt());
                }
                if (this.mSegment.getUcd() > 0L) {
                    jSONObject.put("ucd", this.mSegment.getUcd());
                }
            }
            if (this.mServerSegmentData != null) {
                String string = this.mServerSegmentData.getSegmentId();
                if (!TextUtils.isEmpty((CharSequence)string)) {
                    jSONObject.put("segmentId", (Object)string);
                }
                JSONObject jSONObject2 = this.mServerSegmentData.getCustomSegments();
                Iterator iterator = jSONObject2.keys();
                while (iterator.hasNext()) {
                    String string2 = (String)iterator.next();
                    jSONObject.put(string2, jSONObject2.get(string2));
                }
            }
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
    }

    private void verifyCurrentFormatter(String string) {
        AbstractEventsFormatter abstractEventsFormatter = this.mFormatter;
        if (abstractEventsFormatter == null || !abstractEventsFormatter.getFormatterType().equals((Object)string)) {
            this.mFormatter = EventsFormatterFactory.getFormatter(string, this.mAdUnitType);
        }
    }

    protected abstract String getCurrentPlacement(int var1);

    protected abstract int getSessionDepth(EventData var1);

    protected abstract boolean increaseSessionDepthIfNeeded(EventData var1);

    void initState() {
        this.mLocalEvents = new ArrayList();
        this.mTotalEvents = 0;
        this.mFormatter = EventsFormatterFactory.getFormatter(this.mFormatterType, this.mAdUnitType);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mEventType);
        stringBuilder.append("EventThread");
        this.mEventThread = new EventThread(stringBuilder.toString());
        this.mEventThread.start();
        this.mEventThread.prepareHandler();
        this.mLoggerManager = IronSourceLoggerManager.getLogger();
        this.mSessionId = IronSourceObject.getInstance().getSessionId();
    }

    protected abstract boolean isTopPriorityEvent(EventData var1);

    public void log(final EventData eventData) {
        BaseEventsManager baseEventsManager = this;
        synchronized (baseEventsManager) {
            this.mEventThread.postTask(new Runnable(){

                public void run() {
                    if (eventData != null) {
                        if (!BaseEventsManager.this.mIsEventsEnabled) {
                            return;
                        }
                        eventData.addToAdditionalData("eventSessionId", BaseEventsManager.this.mSessionId);
                        eventData.addToAdditionalData("connectionType", IronSourceUtils.getConnectionType(BaseEventsManager.this.mContext));
                        try {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("{\"eventId\":");
                            stringBuilder.append(eventData.getEventId());
                            stringBuilder.append(",\"timestamp\":");
                            stringBuilder.append(eventData.getTimeStamp());
                            stringBuilder.append(",");
                            stringBuilder.append(eventData.getAdditionalData().substring(1));
                            String string = stringBuilder.toString();
                            BaseEventsManager.this.mLoggerManager.log(IronSourceLogger.IronSourceTag.EVENT, string.replace((CharSequence)",", (CharSequence)"\n"), 0);
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        if (BaseEventsManager.this.shouldEventBeLogged(eventData)) {
                            if (eventData.getEventId() != 14 && eventData.getEventId() != 40 && eventData.getEventId() != 41) {
                                int n2 = BaseEventsManager.this.getSessionDepth(eventData);
                                if (BaseEventsManager.this.increaseSessionDepthIfNeeded(eventData)) {
                                    n2 = BaseEventsManager.this.getSessionDepth(eventData);
                                }
                                eventData.addToAdditionalData("sessionDepth", n2);
                            }
                            if (BaseEventsManager.this.shouldExtractCurrentPlacement(eventData)) {
                                BaseEventsManager.this.setCurrentPlacement(eventData);
                            } else if (!TextUtils.isEmpty((CharSequence)BaseEventsManager.this.getCurrentPlacement(eventData.getEventId())) && BaseEventsManager.this.shouldIncludeCurrentPlacement(eventData)) {
                                EventData eventData2 = eventData;
                                eventData2.addToAdditionalData("placement", BaseEventsManager.this.getCurrentPlacement(eventData2.getEventId()));
                            }
                            BaseEventsManager.this.mLocalEvents.add((Object)eventData);
                            BaseEventsManager.access$608(BaseEventsManager.this);
                        }
                        boolean bl2 = BaseEventsManager.this.isTopPriorityEvent(eventData);
                        if (!BaseEventsManager.this.mHadTopPriorityEvent && bl2) {
                            BaseEventsManager.this.mHadTopPriorityEvent = true;
                        }
                        if (BaseEventsManager.this.mDbStorage != null) {
                            if (BaseEventsManager.this.shouldSendEvents()) {
                                BaseEventsManager.this.sendEvents();
                                return;
                            }
                            BaseEventsManager baseEventsManager = BaseEventsManager.this;
                            if (baseEventsManager.shouldBackupEventsToDb((ArrayList<EventData>)baseEventsManager.mLocalEvents) || bl2) {
                                BaseEventsManager.this.backupEventsToDb();
                            }
                        }
                    }
                }
            });
            return;
        }
    }

    public void sendEventToUrl(EventData eventData, String string) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)eventData);
            String string2 = this.mFormatter.format((ArrayList<EventData>)arrayList, GeneralProperties.getProperties().toJSON());
            new EventsSender().execute(new Object[]{string2, string, null});
        }
        catch (Exception exception) {}
    }

    public void setBackupThreshold(int n2) {
        if (n2 > 0) {
            this.mBackupThreshold = n2;
        }
    }

    protected abstract void setCurrentPlacement(EventData var1);

    public void setEventsUrl(String string, Context context) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            AbstractEventsFormatter abstractEventsFormatter = this.mFormatter;
            if (abstractEventsFormatter != null) {
                abstractEventsFormatter.setEventsServerUrl(string);
            }
            IronSourceUtils.saveDefaultEventsURL(context, this.mEventType, string);
        }
    }

    public void setFormatterType(String string, Context context) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.mFormatterType = string;
            IronSourceUtils.saveDefaultEventsFormatterType(context, this.mEventType, string);
            this.verifyCurrentFormatter(string);
        }
    }

    public void setHasServerResponse(boolean bl2) {
        this.mHasServerResponse = bl2;
    }

    public void setIsEventsEnabled(boolean bl2) {
        this.mIsEventsEnabled = bl2;
    }

    public void setMaxEventsPerBatch(int n2) {
        if (n2 > 0) {
            this.mMaxEventsPerBatch = n2;
        }
    }

    public void setMaxNumberOfEvents(int n2) {
        if (n2 > 0) {
            this.mMaxNumberOfEvents = n2;
        }
    }

    public void setOptOutEvents(int[] arrn, Context context) {
        this.mOptOutEvents = arrn;
        IronSourceUtils.saveDefaultOptOutEvents(context, this.mEventType, arrn);
    }

    public void setServerSegmentData(ServerSegmetData serverSegmetData) {
        BaseEventsManager baseEventsManager = this;
        synchronized (baseEventsManager) {
            this.mServerSegmentData = serverSegmetData;
            return;
        }
    }

    protected abstract boolean shouldExtractCurrentPlacement(EventData var1);

    protected abstract boolean shouldIncludeCurrentPlacement(EventData var1);

    public void start(Context context, IronSourceSegment ironSourceSegment) {
        BaseEventsManager baseEventsManager = this;
        synchronized (baseEventsManager) {
            this.mFormatterType = IronSourceUtils.getDefaultEventsFormatterType(context, this.mEventType, this.mFormatterType);
            this.verifyCurrentFormatter(this.mFormatterType);
            this.mFormatter.setEventsServerUrl(IronSourceUtils.getDefaultEventsURL(context, this.mEventType, null));
            this.mDbStorage = DataBaseEventsStorage.getInstance(context, "supersonic_sdk.db", 5);
            this.backupEventsToDb();
            this.mOptOutEvents = IronSourceUtils.getDefaultOptOutEvents(context, this.mEventType);
            this.mSegment = ironSourceSegment;
            this.mContext = context;
            return;
        }
    }

    public void triggerEventsSend() {
        this.sendEvents();
    }

    private class EventThread
    extends HandlerThread {
        private Handler mHandler;

        EventThread(String string) {
            super(string);
        }

        void postTask(Runnable runnable) {
            this.mHandler.post(runnable);
        }

        void prepareHandler() {
            this.mHandler = new Handler(this.getLooper());
        }
    }

}

