/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package io.presage.common.profig.schedule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.presage.common.profig.schedule.ProfigSyncIntentService;

public final class ProfigAlarmReceiver
extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        ProfigSyncIntentService.CamembertauCalvados.a(context);
    }
}

