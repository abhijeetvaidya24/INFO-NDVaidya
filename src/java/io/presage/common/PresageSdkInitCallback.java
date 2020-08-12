/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.presage.common;

public interface PresageSdkInitCallback {
    public void onSdkInitFailed();

    public void onSdkInitialized();

    public void onSdkNotInitialized();
}

