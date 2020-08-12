/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.analytics.AerServAnalytics$1
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Map
 */
package com.aerserv.sdk.analytics;

import com.aerserv.sdk.AerServEventListener;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.analytics.AerServAnalytics;
import com.aerserv.sdk.analytics.AerServAnalyticsEvent;
import com.aerserv.sdk.analytics.AerServAnalyticsProxy;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.utils.MultiKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AerServAnalytics {
    private static AerServAnalytics singleton = new AerServAnalytics();
    private Map<MultiKey, AerServAnalyticsEvent> events = new HashMap();
    private String os = null;
    private String plc = null;
    private String rid = null;
    private String sdkVersion = null;
    private Map<MultiKey, AerServAnalyticsEvent> transientEvents = new HashMap();
    private String userAgent = null;

    private AerServAnalytics() {
    }

    private boolean contains(String string, String string2, String string3) {
        return this.getValue(string, string2, string3) != null;
    }

    public static AerServAnalytics getInstance() {
        return singleton;
    }

    private Object getValue(String string, String string2, String string3) {
        MultiKey multiKey = new MultiKey(string, string2);
        if (this.events.get((Object)multiKey) == null) {
            return null;
        }
        return ((AerServAnalyticsEvent)this.events.get((Object)multiKey)).getValue(string3);
    }

    private boolean isEnabled(String string, String string2) {
        return AerServSettings.isAnalyticsEventEnabled(string, string2, this.plc);
    }

    private boolean shouldSendToServer(AerServAnalyticsEvent aerServAnalyticsEvent) {
        if ("vast".equals((Object)aerServAnalyticsEvent.getCategory()) && "parseXml".equals((Object)aerServAnalyticsEvent.getAction())) {
            return this.contains(aerServAnalyticsEvent.getCategory(), aerServAnalyticsEvent.getAction(), "parseError");
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addArrayValue(String string, String string2, String string3, Object object) {
        Map<MultiKey, AerServAnalyticsEvent> map;
        if (!this.isEnabled(string, string2)) {
            return;
        }
        MultiKey multiKey = new MultiKey(string, string2);
        Map<MultiKey, AerServAnalyticsEvent> map2 = map = this.events;
        synchronized (map2) {
            if (this.events.get((Object)multiKey) == null) {
                this.events.put((Object)multiKey, (Object)new AerServAnalyticsEvent(string, string2));
            }
            ((AerServAnalyticsEvent)this.events.get((Object)multiKey)).addArrayValue(string3, object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addTransientValue(String string, String string2, String string3, Object object) {
        Map<MultiKey, AerServAnalyticsEvent> map;
        if (!this.isEnabled(string, string2)) {
            return;
        }
        Map<MultiKey, AerServAnalyticsEvent> map2 = map = this.transientEvents;
        synchronized (map2) {
            MultiKey multiKey = new MultiKey(string, string2);
            if (this.transientEvents.get((Object)multiKey) == null) {
                this.transientEvents.put((Object)multiKey, (Object)new AerServAnalyticsEvent(string, string2));
            }
            ((AerServAnalyticsEvent)this.transientEvents.get((Object)multiKey)).addValue(string3, object);
            return;
        }
    }

    public void addValue(String string, String string2, String string3, Object object) {
        if (this.isEnabled(string, string2)) {
            this.addValue(string, string2, string3, object, true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addValue(String string, String string2, String string3, Object object, boolean bl) {
        Map<MultiKey, AerServAnalyticsEvent> map;
        if (!this.isEnabled(string, string2)) {
            return;
        }
        MultiKey multiKey = new MultiKey(string, string2);
        Map<MultiKey, AerServAnalyticsEvent> map2 = map = this.events;
        synchronized (map2) {
            if (!bl && this.contains(string, string2, string3)) {
                return;
            }
            if (this.events.get((Object)multiKey) == null) {
                this.events.put((Object)multiKey, (Object)new AerServAnalyticsEvent(string, string2));
            }
            ((AerServAnalyticsEvent)this.events.get((Object)multiKey)).addValue(string3, object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addVastParseError(String string) {
        Object object;
        Map<MultiKey, AerServAnalyticsEvent> map;
        Map<MultiKey, AerServAnalyticsEvent> map2;
        if (!this.isEnabled("vast", "parseXml")) {
            return;
        }
        Map<MultiKey, AerServAnalyticsEvent> map3 = map = this.transientEvents;
        synchronized (map3) {
            object = this.getTransientValue("vast", "parseXml", "vastXml");
        }
        Map<MultiKey, AerServAnalyticsEvent> map4 = map2 = this.events;
        synchronized (map4) {
            boolean bl = this.contains("vast", "parseXml", "parseError");
            boolean bl2 = this.contains("vast", "parseXml", "badVastXml");
            if (!(bl && bl2 || object == null || !(object instanceof String))) {
                this.addValue("vast", "parseXml", "badVastXml", (String)object);
            }
            this.addArrayValue("vast", "parseXml", "parseError", string);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getTransientValue(String string, String string2, String string3) {
        Map<MultiKey, AerServAnalyticsEvent> map;
        if (!this.isEnabled(string, string2)) {
            return null;
        }
        MultiKey multiKey = new MultiKey(string, string2);
        Map<MultiKey, AerServAnalyticsEvent> map2 = map = this.transientEvents;
        synchronized (map2) {
            if (this.transientEvents.get((Object)multiKey) != null) return ((AerServAnalyticsEvent)this.transientEvents.get((Object)multiKey)).getValue(string3);
            return null;
        }
    }

    public boolean isEnabled() {
        return AerServSettings.isAnalyticsEnabled(this.plc);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void newRequest(String string, String string2, boolean bl) {
        Map<MultiKey, AerServAnalyticsEvent> map;
        Map<MultiKey, AerServAnalyticsEvent> map2;
        Map<MultiKey, AerServAnalyticsEvent> map3 = map2 = this.events;
        // MONITORENTER : map3
        Map<MultiKey, AerServAnalyticsEvent> map4 = map = this.transientEvents;
        // MONITORENTER : map4
        this.events.clear();
        this.transientEvents.clear();
        this.plc = string;
        // MONITOREXIT : map4
        // MONITOREXIT : map3
        if (!this.isEnabled()) return;
        this.sdkVersion = this.sdkVersion;
        this.os = this.os;
        this.userAgent = this.userAgent;
        AerServAnalytics.getInstance().addTransientValue("adRequest", "requestAndRender", "controllerId", string2);
        AerServAnalytics.getInstance().addTransientValue("adRequest", "requestAndRender", "startTime", System.currentTimeMillis());
        AerServEventListenerLocator.register(string2, (AerServEventListener)new 1(this, string2, bl));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void sendToServer() {
        Map<MultiKey, AerServAnalyticsEvent> map;
        if (!this.isEnabled()) {
            return;
        }
        Map<MultiKey, AerServAnalyticsEvent> map2 = map = this.events;
        synchronized (map2) {
            ArrayList arrayList = new ArrayList();
            for (AerServAnalyticsEvent aerServAnalyticsEvent : this.events.values()) {
                if (!this.shouldSendToServer(aerServAnalyticsEvent)) continue;
                aerServAnalyticsEvent.addValue("plc", this.plc);
                aerServAnalyticsEvent.addValue("sdkVersion", this.sdkVersion);
                aerServAnalyticsEvent.addValue("os", this.os);
                aerServAnalyticsEvent.addValue("userAgent", this.userAgent);
                aerServAnalyticsEvent.addValue("rid", this.rid);
                arrayList.add((Object)aerServAnalyticsEvent);
            }
            if (!arrayList.isEmpty()) {
                AerServAnalyticsProxy.send((Collection<AerServAnalyticsEvent>)arrayList);
            }
            this.events.clear();
            return;
        }
    }

    public void setRid(String string) {
        this.rid = string;
    }
}

