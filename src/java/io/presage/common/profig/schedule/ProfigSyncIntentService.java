/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.common.profig.schedule;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import io.presage.CoeurdArras;
import io.presage.cl;

public final class ProfigSyncIntentService
extends IntentService {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);

    public ProfigSyncIntentService() {
        super("ProfigService");
    }

    protected final void onHandleIntent(Intent intent) {
        Context context = this.getApplicationContext();
        cl.a((Object)context, "applicationContext");
        CamembertauCalvados.b(context);
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        public static void a(Context context) {
            context.startService(new Intent(context, ProfigSyncIntentService.class));
        }

        public static void b(Context context) {
            try {
                CoeurdArras.CamembertauCalvados camembertauCalvados = CoeurdArras.a;
                Context context2 = context.getApplicationContext();
                cl.a((Object)context2, "context.applicationContext");
                CoeurdArras.a(camembertauCalvados.a(context2));
                return;
            }
            catch (Exception exception) {
                return;
            }
        }
    }

}

