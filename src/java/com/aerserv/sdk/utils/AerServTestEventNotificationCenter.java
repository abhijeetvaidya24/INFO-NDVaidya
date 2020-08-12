/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package com.aerserv.sdk.utils;

import com.aerserv.sdk.utils.AerServTestEventListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AerServTestEventNotificationCenter {
    private static List<AerServTestEventListener> listeners = new ArrayList();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void addListener(AerServTestEventListener aerServTestEventListener) {
        List<AerServTestEventListener> list;
        List<AerServTestEventListener> list2 = list = listeners;
        synchronized (list2) {
            listeners.add((Object)aerServTestEventListener);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void fireAdvertiserEvent(Map<String, String> map) {
        List<AerServTestEventListener> list;
        ArrayList arrayList = new ArrayList();
        List<AerServTestEventListener> list2 = list = listeners;
        synchronized (list2) {
            arrayList.addAll(listeners);
        }
        new Thread(new Runnable((List)arrayList, map){
            final /* synthetic */ List val$listenersCopy;
            final /* synthetic */ Map val$params;
            {
                this.val$listenersCopy = list;
                this.val$params = map;
            }

            public void run() {
                try {
                    Iterator iterator = this.val$listenersCopy.iterator();
                    while (iterator.hasNext()) {
                        ((AerServTestEventListener)iterator.next()).onAdvertiserEvent((String)this.val$params.get((Object)"ev"), (Map<String, String>)this.val$params);
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeAllListeners() {
        List<AerServTestEventListener> list;
        List<AerServTestEventListener> list2 = list = listeners;
        synchronized (list2) {
            listeners.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeListener(AerServTestEventListener aerServTestEventListener) {
        List<AerServTestEventListener> list;
        List<AerServTestEventListener> list2 = list = listeners;
        synchronized (list2) {
            listeners.remove((Object)aerServTestEventListener);
            return;
        }
    }

}

