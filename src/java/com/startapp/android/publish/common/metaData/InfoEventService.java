/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  com.startapp.android.publish.common.metaData.InfoEventService$1
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.common.metaData;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.startapp.android.publish.common.metaData.InfoEventService;
import com.startapp.common.b.a;
import com.startapp.common.b.a.b;

public class InfoEventService
extends Service {
    private static final String a = "InfoEventService";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        a.a((Context)this);
        boolean bl = a.a(intent, (b.b)new 1(this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onHandleIntent: RunnerManager.runJob");
        stringBuilder.append(bl);
        a.a(3, a, stringBuilder.toString(), null);
        return super.onStartCommand(intent, n2, n3);
    }
}

