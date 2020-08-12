/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Intent
 *  java.lang.String
 */
package com.startapp.android.publish.common.metaData;

import android.app.IntentService;
import android.content.Intent;

public class PeriodicMetaDataService
extends IntentService {
    public PeriodicMetaDataService() {
        super(PeriodicMetaDataService.class.getSimpleName());
    }

    protected void onHandleIntent(Intent intent) {
    }
}

