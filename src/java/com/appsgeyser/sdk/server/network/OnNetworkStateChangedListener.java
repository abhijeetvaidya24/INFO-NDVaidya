/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk.server.network;

public abstract class OnNetworkStateChangedListener {
    private String id;

    protected OnNetworkStateChangedListener(String string2) {
        this.id = string2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            OnNetworkStateChangedListener onNetworkStateChangedListener = (OnNetworkStateChangedListener)object;
            return this.id.equals((Object)onNetworkStateChangedListener.id);
        }
        return false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public abstract void networkIsDown();

    public abstract void networkIsUp();
}

