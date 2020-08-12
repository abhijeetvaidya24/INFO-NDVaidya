/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 */
package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdRegistrationExecutor;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AdActivity
extends Activity {
    static final String ADAPTER_KEY = "adapter";
    private static final String LOGTAG = "AdActivity";
    private ActivityAdapterFactory activityAdapterFactory;
    private AdActivityAdapter adapter;
    private AdRegistrationExecutor amazonAdRegistration;
    private MobileAdsLogger logger;

    public AdActivity() {
        this(new MobileAdsLoggerFactory(), AdRegistration.getAmazonAdRegistrationExecutor(), new ActivityAdapterFactory(new MobileAdsLoggerFactory()));
    }

    AdActivity(MobileAdsLoggerFactory mobileAdsLoggerFactory, AdRegistrationExecutor adRegistrationExecutor, ActivityAdapterFactory activityAdapterFactory) {
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.amazonAdRegistration = adRegistrationExecutor;
        this.activityAdapterFactory = activityAdapterFactory;
    }

    private void initializeSdk() {
        if (this.logger == null) {
            this.setLoggerFactory(new MobileAdsLoggerFactory());
        }
        if (this.amazonAdRegistration == null) {
            this.setAmazonAdRegistrationExecutor(AdRegistration.getAmazonAdRegistrationExecutor());
        }
        if (this.activityAdapterFactory == null) {
            this.setActivityAdapterFactory(new ActivityAdapterFactory(new MobileAdsLoggerFactory()));
        }
        this.amazonAdRegistration.initializeAds(this.getApplicationContext());
    }

    public void onBackPressed() {
        if (!this.adapter.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.adapter.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        this.initializeSdk();
        AdActivityAdapter adActivityAdapter = this.adapter = this.activityAdapterFactory.createAdapter(this.getIntent());
        if (adActivityAdapter == null) {
            super.onCreate(bundle);
            this.finish();
            return;
        }
        adActivityAdapter.setActivity(this);
        this.adapter.preOnCreate();
        super.onCreate(bundle);
        this.adapter.onCreate();
    }

    public void onDestroy() {
        this.adapter.onDestroy();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.adapter.onPause();
    }

    public void onResume() {
        super.onResume();
        this.adapter.onResume();
    }

    public void onStop() {
        this.adapter.onStop();
        super.onStop();
    }

    public void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        if (bl) {
            this.adapter.onWindowFocusChanged();
        }
    }

    void setActivityAdapterFactory(ActivityAdapterFactory activityAdapterFactory) {
        this.activityAdapterFactory = activityAdapterFactory;
    }

    void setAmazonAdRegistrationExecutor(AdRegistrationExecutor adRegistrationExecutor) {
        this.amazonAdRegistration = adRegistrationExecutor;
    }

    void setLoggerFactory(MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
    }

    static class ActivityAdapterFactory {
        private final MobileAdsLogger logger;

        public ActivityAdapterFactory(MobileAdsLoggerFactory mobileAdsLoggerFactory) {
            this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        AdActivityAdapter createAdapter(Intent intent) {
            Class class_;
            String string = intent.getStringExtra(AdActivity.ADAPTER_KEY);
            if (string == null) {
                this.logger.e("Unable to launch the AdActivity due to an internal error.");
                return null;
            }
            try {
                class_ = Class.forName((String)string);
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.logger.e("Unable to get the adapter class.");
                return null;
            }
            Constructor constructor = class_.getDeclaredConstructor(new Class[0]);
            try {
                return (AdActivityAdapter)constructor.newInstance(new Object[0]);
            }
            catch (InvocationTargetException invocationTargetException) {
                this.logger.e("Invocation target exception when instantiating the adapter.");
                return null;
            }
            catch (IllegalAccessException illegalAccessException) {
                this.logger.e("Illegal access exception when instantiating the adapter.");
                return null;
            }
            catch (InstantiationException instantiationException) {
                this.logger.e("Instantiation exception when instantiating the adapter.");
                return null;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logger.e("Illegal arguments given to the default constructor.");
                return null;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                this.logger.e("No default constructor exists for the adapter.");
                return null;
            }
            catch (SecurityException securityException) {
                this.logger.e("Security exception when trying to get the default constructor.");
                return null;
            }
        }
    }

    public static interface AdActivityAdapter {
        public boolean onBackPressed();

        public void onConfigurationChanged(Configuration var1);

        public void onCreate();

        public void onDestroy();

        public void onPause();

        public void onResume();

        public void onStop();

        public void onWindowFocusChanged();

        public void preOnCreate();

        public void setActivity(Activity var1);
    }

}

