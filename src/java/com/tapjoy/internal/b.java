/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.Notification$InboxStyle
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.widget.RemoteViews
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

final class b {
    Notification.Builder a;

    public b(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int n2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int n3, int n4, boolean bl2, boolean bl3, int n5, CharSequence charSequence4) {
        Notification.Builder builder = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        int n6 = 2 & notification.flags;
        boolean bl4 = true;
        boolean bl5 = n6 != 0;
        Notification.Builder builder2 = builder.setOngoing(bl5);
        boolean bl6 = (8 & notification.flags) != 0;
        Notification.Builder builder3 = builder2.setOnlyAlertOnce(bl6);
        boolean bl7 = (16 & notification.flags) != 0;
        Notification.Builder builder4 = builder3.setAutoCancel(bl7).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((128 & notification.flags) == 0) {
            bl4 = false;
        }
        this.a = builder4.setFullScreenIntent(pendingIntent2, bl4).setLargeIcon(bitmap).setNumber(n2).setUsesChronometer(bl3).setPriority(n5).setProgress(n3, n4, bl2);
    }

    public final void a(CharSequence charSequence, boolean bl2, CharSequence charSequence2, ArrayList arrayList) {
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle(this.a).setBigContentTitle(charSequence);
        if (bl2) {
            inboxStyle.setSummaryText(charSequence2);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            inboxStyle.addLine((CharSequence)iterator.next());
        }
    }
}

