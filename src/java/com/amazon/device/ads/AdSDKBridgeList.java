/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdSDKBridge;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class AdSDKBridgeList
implements Iterable<AdSDKBridge> {
    private final HashMap<String, AdSDKBridge> bridgesByName = new HashMap();

    public void addBridge(AdSDKBridge adSDKBridge) {
        this.bridgesByName.put((Object)adSDKBridge.getName(), (Object)adSDKBridge);
    }

    public void clear() {
        this.bridgesByName.clear();
    }

    public boolean contains(AdSDKBridge adSDKBridge) {
        return this.bridgesByName.containsKey((Object)adSDKBridge.getName());
    }

    public Iterator<AdSDKBridge> iterator() {
        return this.bridgesByName.values().iterator();
    }
}

