/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class AppEvent {
    private final String eventName;
    private final HashMap<String, String> properties;
    private final long timestamp;

    protected AppEvent(String string) {
        this(string, -1L);
    }

    public AppEvent(String string, long l2) {
        this.eventName = string;
        this.timestamp = l2;
        this.properties = new HashMap();
    }

    public static AppEvent createAppEventWithTimestamp(AppEvent appEvent, long l2) {
        return new AppEvent(appEvent.eventName, l2);
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getProperty(String string) {
        return (String)this.properties.get((Object)string);
    }

    public Set<Map.Entry<String, String>> getPropertyEntries() {
        return this.properties.entrySet();
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public AppEvent setProperty(String string, String string2) {
        this.properties.put((Object)string, (Object)string2);
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(65);
        stringBuilder.append("Application Event {Name: ");
        stringBuilder.append(this.eventName);
        stringBuilder.append(", Timestamp: ");
        stringBuilder.append(this.timestamp);
        for (String string : this.properties.keySet()) {
            stringBuilder.append(", ");
            stringBuilder.append(string);
            stringBuilder.append(": ");
            stringBuilder.append((String)this.properties.get((Object)string));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

