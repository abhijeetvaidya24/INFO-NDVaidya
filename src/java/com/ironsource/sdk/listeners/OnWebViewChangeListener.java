/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.sdk.listeners;

public interface OnWebViewChangeListener {
    public boolean onBackButtonPressed();

    public void onCloseRequested();

    public void onOrientationChanged(String var1, int var2);
}

