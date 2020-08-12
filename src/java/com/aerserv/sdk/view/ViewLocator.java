/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.aerserv.sdk.view;

import com.aerserv.sdk.view.View;
import java.util.HashMap;
import java.util.Map;

public class ViewLocator {
    private static ViewLocator instance;
    private static Object monitor;
    private Map<String, View> viewMap = new HashMap();

    static {
        monitor = new Object();
    }

    private ViewLocator() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ViewLocator getInstance() {
        Object object;
        Object object2 = object = monitor;
        synchronized (object2) {
            if (instance == null) {
                instance = new ViewLocator();
            }
            return instance;
        }
    }

    public void clear() {
        this.viewMap.clear();
    }

    public View locateView(String string) {
        return (View)this.viewMap.get((Object)string);
    }

    public void registerView(String string, View view) {
        this.viewMap.put((Object)string, (Object)view);
    }

    public void unregisterView(String string) {
        if (this.viewMap.containsKey((Object)string)) {
            this.viewMap.remove((Object)string);
        }
    }
}

