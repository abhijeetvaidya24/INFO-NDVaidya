/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;

class ConnectionInfo {
    private static final String LOGTAG = "ConnectionInfo";
    private static final String WIFI_NAME = "Wifi";
    private String connectionType;
    private ConnectivityManager connectivityManager;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    ConnectionInfo(ConnectivityManager connectivityManager) {
        this.initialize(connectivityManager);
    }

    public ConnectionInfo(MobileAdsInfoStore mobileAdsInfoStore) {
        this.initialize((ConnectivityManager)mobileAdsInfoStore.getApplicationContext().getSystemService("connectivity"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void generateConnectionType() {
        NetworkInfo networkInfo = null;
        try {
            ConnectivityManager connectivityManager = this.connectivityManager;
            networkInfo = null;
            if (connectivityManager != null) {
                networkInfo = this.connectivityManager.getActiveNetworkInfo();
            }
        }
        catch (SecurityException securityException) {
            this.logger.d("Unable to get active network information: %s", new Object[]{securityException});
        }
        if (networkInfo == null) {
            this.connectionType = Integer.toString((int)0);
            return;
        }
        if (networkInfo.getType() == 1) {
            this.connectionType = WIFI_NAME;
            return;
        }
        this.connectionType = Integer.toString((int)networkInfo.getSubtype());
    }

    private void initialize(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
        this.refresh();
    }

    public String getConnectionType() {
        return this.connectionType;
    }

    public boolean isWiFi() {
        return WIFI_NAME.equals((Object)this.getConnectionType());
    }

    public void refresh() {
        this.generateConnectionType();
    }
}

