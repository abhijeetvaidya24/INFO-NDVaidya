/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.widget.RemoteViews
 *  com.tapjoy.internal.a$g
 *  com.tapjoy.internal.a$h
 *  com.tapjoy.internal.a$i
 *  com.tapjoy.internal.a$j
 *  com.tapjoy.internal.a$k
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.System
 *  java.util.ArrayList
 */
package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.RemoteViews;
import com.tapjoy.internal.a;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis.
 */
public final class a {
    private static final f a;

    static {
        a = Build.VERSION.SDK_INT >= 16 ? new /* Unavailable Anonymous Inner Class!! */ : (Build.VERSION.SDK_INT >= 14 ? new /* Unavailable Anonymous Inner Class!! */ : (Build.VERSION.SDK_INT >= 11 ? new /* Unavailable Anonymous Inner Class!! */ : (Build.VERSION.SDK_INT >= 9 ? new /* Unavailable Anonymous Inner Class!! */ : new /* Unavailable Anonymous Inner Class!! */)));
    }

    public static /* synthetic */ f a() {
        return a;
    }

    public static final class a {
        public int a;
        public CharSequence b;
        public PendingIntent c;
    }

    public static final class d {
        Context a;
        public CharSequence b;
        public CharSequence c;
        public PendingIntent d;
        PendingIntent e;
        RemoteViews f;
        public Bitmap g;
        CharSequence h;
        int i;
        int j;
        boolean k;
        l l;
        CharSequence m;
        int n;
        int o;
        boolean p;
        ArrayList q = new ArrayList();
        public Notification r = new Notification();

        public d(Context context) {
            this.a = context;
            this.r.when = System.currentTimeMillis();
            this.r.audioStreamType = -1;
            this.j = 0;
        }

        public final d a(l l2) {
            l l3;
            if (this.l != l2 && (l3 = (this.l = l2)) != null && l3.d != this) {
                l3.d = this;
                if (l3.d != null) {
                    l3.d.a(l3);
                }
            }
            return this;
        }
    }

    public static interface f {
        public Notification a(d var1);
    }

    public static abstract class l {
        d d;
        public CharSequence e;
        CharSequence f;
        boolean g = false;
    }

}

