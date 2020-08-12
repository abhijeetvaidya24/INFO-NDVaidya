/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.Uri
 *  android.os.IBinder
 *  io.presage.common.appinstall.AppInstallListenService$installBroadcastReceiver
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage.common.appinstall;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import io.presage.VacherinSuisse;
import io.presage.VacherinduhautDoubsMontdOr;
import io.presage.cl;
import io.presage.common.appinstall.AppInstallListenService;

public final class AppInstallListenService
extends Service {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private String b = "";
    private String c = "";
    private final installBroadcastReceiver.1 d = new BroadcastReceiver(this){
        final /* synthetic */ AppInstallListenService a;
        {
            this.a = appInstallListenService;
        }

        public final void onReceive(Context context, Intent intent) {
            AppInstallListenService.a(this.a, intent);
        }
    };

    private final void a() {
        int n2 = ((CharSequence)this.b).length();
        boolean bl2 = true;
        boolean bl3 = n2 == 0;
        if (!bl3) {
            if (((CharSequence)this.c).length() != 0) {
                bl2 = false;
            }
            if (!bl2) {
                Context context = (Context)this;
                if (VacherinduhautDoubsMontdOr.a(context, this.b)) {
                    this.d();
                    return;
                }
                VacherinduhautDoubsMontdOr.c(context, this.c);
                return;
            }
        }
        this.e();
    }

    private final void a(Intent intent) {
        String string2 = intent.getStringExtra("app_to_install_package");
        if (string2 == null) {
            string2 = "";
        }
        this.b = string2;
        String string3 = intent.getStringExtra("google_play_url");
        if (string3 == null) {
            string3 = "";
        }
        this.c = string3;
        this.b();
        this.c();
    }

    public static final /* synthetic */ void a(AppInstallListenService appInstallListenService, Intent intent) {
        appInstallListenService.b(intent);
    }

    private final void b() {
        Context context = (Context)this;
        Intent intent = new Intent(context, AppInstallListenService.class);
        intent.setAction("notification_clicked");
        PendingIntent pendingIntent = PendingIntent.getService((Context)context, (int)23, (Intent)intent, (int)0);
        VacherinSuisse vacherinSuisse = new VacherinSuisse(context);
        cl.a((Object)pendingIntent, "pendingIntent");
        this.startForeground(19, vacherinSuisse.a(pendingIntent));
    }

    private final void b(Intent intent) {
        Uri uri = intent.getData();
        cl.a((Object)uri, "intent.data");
        String string2 = uri.getEncodedSchemeSpecificPart();
        StringBuilder stringBuilder = new StringBuilder("action ");
        stringBuilder.append(intent.getAction());
        stringBuilder.append(" package: ");
        stringBuilder.append(string2);
        if (cl.a((Object)string2, (Object)this.b)) {
            this.d();
        }
    }

    private final void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.registerReceiver((BroadcastReceiver)this.d, intentFilter);
    }

    private final void d() {
        VacherinduhautDoubsMontdOr.b((Context)this, this.b);
        this.e();
    }

    private final void e() {
        this.stopForeground(true);
        this.stopSelf();
    }

    private final void f() {
        try {
            this.unregisterReceiver((BroadcastReceiver)this.d);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final void onDestroy() {
        this.f();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int n2, int n3) {
        String string2 = intent.getAction();
        if (string2 != null) {
            int n4 = string2.hashCode();
            if (n4 != -1190505608) {
                if (n4 != 109883352) {
                    if (n4 == 1058972883 && string2.equals((Object)"notification_clicked")) {
                        this.a();
                    }
                } else if (string2.equals((Object)"start_service")) {
                    this.a(intent);
                }
            } else if (string2.equals((Object)"stop_service")) {
                this.e();
            }
        }
        return 1;
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}

