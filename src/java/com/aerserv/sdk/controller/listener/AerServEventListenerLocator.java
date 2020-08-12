/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.aerserv.sdk.AerServInternalEventListener
 *  com.aerserv.sdk.controller.command.FireEventCommand
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.aerserv.sdk.controller.listener;

import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServEventListener;
import com.aerserv.sdk.AerServInternalEventListener;
import com.aerserv.sdk.controller.command.FireEventCommand;
import com.aerserv.sdk.utils.AerServLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AerServEventListenerLocator {
    private static final String LOG_TAG = "AerServEventListenerLocator";
    private static final Map<String, Map<AerServEvent, List<String>>> events;
    private static final Map<String, List<AerServEventListener>> listeners;
    private static final Object lock;

    static {
        listeners = new ConcurrentHashMap();
        events = new ConcurrentHashMap();
        lock = new Object();
    }

    private AerServEventListenerLocator() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void createAndRegister(String string, AerServEventListener aerServEventListener) {
        Object object;
        if (string == null) {
            AerServLog.d(LOG_TAG, "Cannot create and register listeners because listenerId is null.");
            return;
        }
        Object object2 = object = lock;
        synchronized (object2) {
            listeners.put((Object)string, (Object)new ArrayList());
            ((List)listeners.get((Object)string)).add((Object)aerServEventListener);
            return;
        }
    }

    public static void fireEvent(String string, AerServEvent aerServEvent) {
        AerServEventListenerLocator.fireEvent(string, aerServEvent, (List<Object>)new ArrayList());
    }

    public static void fireEvent(String string, AerServEvent aerServEvent, Object object) {
        AerServEventListenerLocator.fireEvent(string, aerServEvent, (List<Object>)Arrays.asList((Object[])new Object[]{object}));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void fireEvent(String string, AerServEvent aerServEvent, List<Object> list) {
        Object object;
        Object object2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event firing with type ");
        stringBuilder.append((Object)aerServEvent);
        stringBuilder.append(" and args ");
        stringBuilder.append(list.toString());
        AerServLog.d("AerServEvent", stringBuilder.toString());
        if (string == null) {
            AerServLog.d(LOG_TAG, "Cannot fire event because listenerId is null.");
            return;
        }
        if (aerServEvent == null) {
            AerServLog.d(LOG_TAG, "Cannot fire event because event is null.");
            return;
        }
        Object object3 = object2 = lock;
        // MONITORENTER : object3
        ArrayList arrayList = !listeners.containsKey((Object)string) ? null : new ArrayList((Collection)listeners.get((Object)string));
        // MONITOREXIT : object3
        if (arrayList != null && !arrayList.isEmpty()) {
            new Thread(new Runnable((List)arrayList, aerServEvent, list){
                final /* synthetic */ List val$args;
                final /* synthetic */ AerServEvent val$event;
                final /* synthetic */ List val$listenerList;
                {
                    this.val$listenerList = list;
                    this.val$event = aerServEvent;
                    this.val$args = list2;
                }

                public void run() {
                    try {
                        for (AerServEventListener aerServEventListener : this.val$listenerList) {
                            if (this.val$event.isInternal()) {
                                if (!(aerServEventListener instanceof AerServInternalEventListener)) continue;
                                ((AerServInternalEventListener)aerServEventListener).onAerServInternalEvent(this.val$event, this.val$args);
                                continue;
                            }
                            aerServEventListener.onAerServEvent(this.val$event, (List<Object>)this.val$args);
                        }
                    }
                    catch (Exception exception) {
                        AerServLog.e(LOG_TAG, "Exception caught", exception);
                    }
                }
            }).start();
        }
        Object object4 = object = lock;
        // MONITORENTER : object4
        HashMap hashMap = !events.containsKey((Object)string) ? null : new HashMap((Map)events.get((Object)string));
        // MONITOREXIT : object4
        if (hashMap == null) return;
        new FireEventCommand((List)hashMap.get((Object)aerServEvent)).execute();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void register(String string, AerServEventListener aerServEventListener) {
        Object object;
        if (string == null) {
            AerServLog.d(LOG_TAG, "Cannot register listener because listenerId is null.");
            return;
        }
        Object object2 = object = lock;
        synchronized (object2) {
            if (!listeners.containsKey((Object)string)) {
                AerServLog.d(LOG_TAG, "Cannot find listenerId in listeners to register listener.");
                return;
            }
            ((List)listeners.get((Object)string)).add((Object)aerServEventListener);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void registerEventUrls(String string, Map<AerServEvent, List<String>> map) {
        Object object;
        if (string == null) {
            AerServLog.d(LOG_TAG, "Cannot register eventUrl because listenerId is null.");
            return;
        }
        if (map == null) {
            AerServLog.d(LOG_TAG, "Cannot register eventUrl because map is null.");
            return;
        }
        Object object2 = object = lock;
        synchronized (object2) {
            events.put((Object)string, map);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeListener(String string, AerServEventListener aerServEventListener) {
        Object object;
        if (string == null) {
            AerServLog.d(LOG_TAG, "Cannot remove listener because listenerId is null.");
            return;
        }
        if (aerServEventListener == null) {
            AerServLog.d(LOG_TAG, "Cannot remove listener because listener is null.");
            return;
        }
        Object object2 = object = lock;
        synchronized (object2) {
            if (!listeners.containsKey((Object)string)) {
                AerServLog.d(LOG_TAG, "Cannot find listenerId in listeners to remove listener");
                return;
            }
            ((List)listeners.get((Object)string)).remove((Object)aerServEventListener);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void unregister(String string) {
        Object object;
        if (string == null) {
            AerServLog.d(LOG_TAG, "Cannot unregister listeners because listenerId is null.");
            return;
        }
        Object object2 = object = lock;
        synchronized (object2) {
            listeners.remove((Object)string);
            events.remove((Object)string);
            return;
        }
    }

}

