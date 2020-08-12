/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.startapp.android.publish.adsCommon;

import android.content.Context;
import android.os.Handler;
import com.startapp.android.publish.adsCommon.adListeners.AdDisplayListener;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.adsCommon.d.b;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.common.a.g;
import java.util.concurrent.atomic.AtomicBoolean;

public class i {
    private static final boolean a = MetaData.getInstance().isSupportIABViewability();
    private Handler b = new Handler();
    private long c;
    private Context d;
    private long e = -1L;
    private long f;
    private boolean g;
    private boolean h;
    private String[] i;
    private b j;
    private AtomicBoolean k = new AtomicBoolean(false);

    public i(Context context, String[] arrstring, b b2, long l2) {
        this.d = context.getApplicationContext();
        this.i = arrstring;
        this.j = b2;
        this.c = l2;
    }

    private void a(long l2) {
        if (!this.h) {
            this.h = true;
            if (!this.g) {
                this.g = true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling timer to: ");
            stringBuilder.append(l2);
            stringBuilder.append(" millis, Num urls = ");
            stringBuilder.append(this.i.length);
            g.a("ScheduledImpression", 3, stringBuilder.toString());
            this.f = System.currentTimeMillis();
            this.b.postDelayed(new Runnable(){

                public void run() {
                    g.a("ScheduledImpression", 4, "Timer elapsed");
                    i.this.b(true);
                }
            }, l2);
            return;
        }
        g.a("ScheduledImpression", 3, "Already running");
    }

    private void d() {
        g.a("ScheduledImpression", 4, "reset");
        this.g = false;
        this.b.removeCallbacksAndMessages(null);
        this.h = false;
        this.e = -1L;
        this.f = 0L;
    }

    public void a() {
        g.a("ScheduledImpression", 4, "schedule");
        if (!this.c()) {
            if (a) {
                this.a(this.c);
                return;
            }
            g.a("ScheduledImpression", 3, "Delay feature disabled, sending impression now!");
            this.b(true);
            return;
        }
        g.a("ScheduledImpression", 3, "Already sent impression. Must call cancel(true/false) to reschedule");
    }

    public void a(boolean bl) {
        if (this.g) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cancel(");
            stringBuilder.append(bl);
            stringBuilder.append(")");
            g.a("ScheduledImpression", 4, stringBuilder.toString());
            this.b(bl);
            this.d();
        }
    }

    public void b() {
        if (this.g && this.h) {
            g.a("ScheduledImpression", 4, "pause");
            this.b.removeCallbacksAndMessages(null);
            this.e = System.currentTimeMillis();
            this.c -= this.e - this.f;
            this.h = false;
        }
    }

    protected void b(boolean bl) {
        if (this.k.compareAndSet(false, true)) {
            if (bl) {
                g.a("ScheduledImpression", 3, "Sending impression");
                c.a(this.d, this.i, this.j);
                return;
            }
            g.a("ScheduledImpression", 3, "Sending non-impression");
            c.a(this.d, this.i, this.j.getAdTag(), AdDisplayListener.NotDisplayedReason.AD_CLOSED_TOO_QUICKLY.toString());
            return;
        }
        g.a("ScheduledImpression", 4, "Already sent");
    }

    public boolean c() {
        return this.k.get();
    }

}

