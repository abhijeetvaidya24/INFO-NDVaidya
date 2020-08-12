/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.Window
 *  android.widget.RelativeLayout
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.util.UUID
 */
package com.aerserv.sdk.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.DefaultProviderListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.ProviderListenerLocator;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MoatUtils;
import com.aerserv.sdk.view.View;
import com.aerserv.sdk.view.ViewLocator;
import com.aerserv.sdk.view.component.BackButton;
import com.aerserv.sdk.view.component.CloseButton;
import java.io.Serializable;
import java.util.UUID;

public abstract class ASInterstitialActivity
extends Activity
implements View {
    private static final String LOG_TAG = "ASInterstitialActivity";
    protected final String VIEW_ID = UUID.randomUUID().toString();
    protected BackButton backButton;
    protected CloseButton closeButton;
    protected String controllerId;
    protected ProviderListener providerListener;
    protected RelativeLayout relativeLayout;

    protected abstract void buildInterstitialPlayer();

    public void onBackPressed() {
        if (this.backButton.isBackButtonEnable()) {
            AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.AD_DISMISSED);
            this.providerListener.onProviderFinished();
            this.finish();
            return;
        }
        AerServLog.d(this.getClass().getName(), "Back button press ignored");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        try {
            bundle2 = this.getIntent().getExtras().getBundle("payload");
            if (bundle2 == null) throw new IllegalArgumentException("Didn't get a correctly configured payload.  Cannot continue.");
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
            this.finish();
            return;
        }
        if (bundle2.getSerializable("controllerId") == null) throw new IllegalArgumentException("Didn't get a correctly configured payload.  Cannot continue.");
        this.controllerId = (String)bundle2.getSerializable("controllerId");
        this.providerListener = ProviderListenerLocator.getProviderListener(this.controllerId);
        this.backButton = new BackButton();
        boolean bl = bundle2.getBoolean("isBackButtonEnabled", false);
        int n2 = bundle2.getInt("backButtonTimeout", 0);
        this.backButton.setBackButtonEnable(bl);
        this.backButton.setTimeout(n2);
        if (this.providerListener == null) {
            this.providerListener = new DefaultProviderListener();
        }
        ViewLocator.getInstance().registerView(this.VIEW_ID, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ViewLocator.getInstance().unregisterView(this.VIEW_ID);
        MoatUtils.cleanup(this.controllerId);
    }

    protected abstract void playInterstitial();

    protected abstract void registerEvents();

    protected void tryToGoFullScreen() {
        try {
            this.requestWindowFeature(1);
            this.getWindow().setFlags(1024, 1024);
            return;
        }
        catch (Exception exception) {
            AerServLog.w(this.getClass().getName(), "Could not go full screen", exception);
            return;
        }
    }
}

