/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.ironsource.mediationsdk;

import android.util.Pair;
import java.util.ArrayList;

public class IntegrationData {
    public String[] activities;
    public String[] broadcastReceivers;
    public ArrayList<Pair<String, String>> externalLibs;
    public String name;
    public String sdkName;
    public String[] services;
    public boolean validateWriteExternalStorage;
    public String version;

    public IntegrationData(String string, String string2) {
        this.name = string;
        this.version = string2;
        this.activities = null;
        this.sdkName = null;
        this.externalLibs = null;
        this.broadcastReceivers = null;
        this.services = null;
        this.validateWriteExternalStorage = false;
    }
}

