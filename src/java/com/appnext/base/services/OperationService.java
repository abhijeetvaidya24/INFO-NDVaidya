/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.appnext.base.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appnext.base.operations.a;
import com.appnext.base.services.b;

public class OperationService
extends IntentService {
    public OperationService() {
        super(OperationService.class.getName());
    }

    protected void onHandleIntent(Intent intent) {
        try {
            String string2 = intent.getStringExtra("config_data_obj");
            Bundle bundle = intent.getBundleExtra("more_data");
            b b2 = new b();
            Intent intent2 = (Intent)intent.clone();
            b2.a(this.getApplicationContext(), string2, null, bundle, (Object)intent2, null);
        }
        catch (Throwable throwable) {}
    }
}

