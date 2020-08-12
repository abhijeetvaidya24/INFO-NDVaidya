/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.Notification$MediaStyle
 *  android.app.Notification$Style
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.widget.RemoteViews
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import io.presage.R;
import io.presage.ak;
import io.presage.cl;

public final class VacherinSuisse {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final Context b;

    public VacherinSuisse(Context context) {
        this.b = context;
    }

    private final Notification.Builder a() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b();
            return new Notification.Builder(this.b, "Presage_Channel_Id");
        }
        return new Notification.Builder(this.b);
    }

    private static void a(Notification.Builder builder, RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setStyle((Notification.Style)new Notification.MediaStyle()).setCustomContentView(remoteViews);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            builder.setContent(remoteViews);
        }
    }

    @TargetApi(value=26)
    private final void b() {
        NotificationChannel notificationChannel = new NotificationChannel("Presage_Channel_Id", (CharSequence)"Presage_Channel_Name", 0);
        notificationChannel.setLockscreenVisibility(-1);
        Object object = this.b.getSystemService("notification");
        if (object != null) {
            ((NotificationManager)object).createNotificationChannel(notificationChannel);
            return;
        }
        throw new ak("null cannot be cast to non-null type android.app.NotificationManager");
    }

    public final Notification a(PendingIntent pendingIntent) {
        RemoteViews remoteViews = new RemoteViews(this.b.getPackageName(), R.layout.presage_notification);
        Notification.Builder builder = this.a().setContentTitle((CharSequence)this.b.getString(R.string.presage_app_install_notification_title)).setContentText((CharSequence)this.b.getString(R.string.presage_app_install_wait)).setSmallIcon(R.drawable.ic_presage_notification_icon).setContentIntent(pendingIntent);
        cl.a((Object)builder, "notificationBuilder");
        VacherinSuisse.a(builder, remoteViews);
        Notification notification = builder.getNotification();
        cl.a((Object)notification, "notificationBuilder.notification");
        return notification;
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}

