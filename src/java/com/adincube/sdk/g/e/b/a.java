/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.adincube.sdk.j.b.b
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.adincube.sdk.g.e.b;

import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.h.b.c;
import com.adincube.sdk.mediation.w.f;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.o;
import com.adincube.sdk.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
implements View.OnTouchListener {
    public a a = null;
    public final List<b> b = new ArrayList();
    private e c = null;
    private f d = null;
    private com.adincube.sdk.g.e.a e = null;
    private AtomicBoolean f = new AtomicBoolean(false);
    private Long g = null;
    private Long h = null;

    public a(e e2, f f2, com.adincube.sdk.g.e.a a2) {
        this.c = e2;
        this.d = f2;
        this.e = a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void b() {
        List<b> list;
        List<b> list2 = list = this.b;
        // MONITORENTER : list2
        if (this.b.isEmpty()) {
            // MONITOREXIT : list2
            return;
        }
        // MONITOREXIT : list2
        if (!this.f.compareAndSet(false, true)) return;
        new Object[1][0] = this.d.r;
        o.a("MRAIDAutoRedirectDetector.analyzeRedirection", new Runnable(){

            public final void run() {
                a.this.f.set(false);
                a.b(a.this);
            }
        }, this.d.r);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static /* synthetic */ void b(a a2) {
        List<b> list;
        List<b> list2 = list = a2.b;
        // MONITORENTER : list2
        long l2 = System.currentTimeMillis();
        Iterator iterator = a2.b.iterator();
        while (iterator.hasNext()) {
            b b2 = (b)iterator.next();
            if (b2.e != null) {
                if (a2.a != null) {
                    a2.a.a(b2.c);
                }
            } else {
                if (l2 - b2.a < a2.d.r) continue;
                if (a2.a != null) {
                    a2.a.a(b2.b);
                }
                a2.a(b2);
            }
            iterator.remove();
        }
        boolean bl = !a2.b.isEmpty();
        // MONITOREXIT : list2
        if (!bl) return;
        try {
            a2.b();
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("MRAIDAutoRedirectDetector.analyzeWaitingPotentialAutoRedirection", new Object[]{throwable});
            ErrorReportingHelper.report("MRAIDAutoRedirectDetector.analyzeWaitingPotentialAutoRedirection", throwable);
            return;
        }
    }

    public final void a() {
        this.g = System.currentTimeMillis();
    }

    public final void a(b b2) {
        com.adincube.sdk.g.e.a a2 = this.e;
        e e2 = this.c;
        String string = b2.b.toString();
        long l2 = b2.d;
        Long l3 = b2.e;
        if (a2.c.a(a2.a.a(true, true), com.adincube.sdk.h.e.e, c.a)) {
            com.adincube.sdk.g.e.b b3 = a2.b;
            com.adincube.sdk.j.b.b b4 = new com.adincube.sdk.j.b.b();
            b4.a = b3.a;
            b4.j = e2;
            b4.k = string;
            b4.l = l2;
            b4.m = l3;
            b4.k();
        }
        a2.c.a(com.adincube.sdk.h.e.e, c.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(Uri uri, Intent intent) {
        List<b> list;
        if (this.h != null) return false;
        boolean bl = true;
        if (!bl) {
            return false;
        }
        a a2 = this.a;
        if (a2 != null) {
            a2.a();
        }
        b b2 = new b(0);
        b2.b = uri;
        b2.c = intent;
        b2.d = System.currentTimeMillis() - this.g;
        List<b> list2 = list = this.b;
        synchronized (list2) {
            this.b.add((Object)b2);
        }
        this.b();
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            List<b> list;
            if (motionEvent.getAction() != 0) return false;
            this.h = System.currentTimeMillis();
            List<b> list2 = list = this.b;
            // MONITORENTER : list2
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("MRAIDAutoRedirectDetector.onTouch", new Object[]{throwable});
            ErrorReportingHelper.report("MRAIDAutoRedirectDetector.onTouch", throwable);
        }
        Iterator iterator = this.b.iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : list2
                return false;
            }
            b b2 = (b)iterator.next();
            b2.e = System.currentTimeMillis() - b2.a;
        } while (true);
        return false;
    }

    public static interface a {
        public void a();

        public void a(Intent var1);

        public void a(Uri var1);
    }

    private static final class b {
        public long a = System.currentTimeMillis();
        public Uri b;
        public Intent c;
        public long d;
        public Long e;

        private b() {
        }

        /* synthetic */ b(byte by2) {
            this();
        }
    }

}

