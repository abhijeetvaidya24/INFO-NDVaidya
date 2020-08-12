/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.CountDownTimer
 *  com.adincube.sdk.b.a.a.e$a
 *  com.adincube.sdk.b.a.a.g
 *  com.adincube.sdk.b.a.a.h
 *  com.adincube.sdk.g.e.c.a
 *  com.adincube.sdk.h.a.a.a
 *  com.adincube.sdk.h.g.a
 *  java.lang.Double
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Map
 */
package com.adincube.sdk.k;

import android.os.CountDownTimer;
import com.adincube.sdk.b.a.a.e;
import com.adincube.sdk.b.a.a.g;
import com.adincube.sdk.b.a.a.h;
import com.adincube.sdk.k.b.b.d;
import com.adincube.sdk.k.b.b.i;
import com.adincube.sdk.k.c;
import com.adincube.sdk.util.h.b;
import com.adincube.sdk.util.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public final class c
extends CountDownTimer
implements e.a,
j {
    private com.adincube.sdk.h.a.a.a a;
    private e b;
    private com.adincube.sdk.b.a.c c;
    private com.adincube.sdk.g.e.c.a d;
    private long e;
    private List<a> f = new ArrayList();

    public c(e e2, com.adincube.sdk.b.a.c c2, com.adincube.sdk.g.e.c.a a2, com.adincube.sdk.h.a.a.a a3, Long l2) {
        super(Integer.MAX_VALUE, 1000L);
        this.b = e2;
        this.c = c2;
        this.d = a2;
        this.a = a3;
        this.e = b.a(a3);
        this.a(d.c, 0.25);
        this.a(d.d, 0.5);
        this.a(d.e, 0.75);
        for (i i2 : com.adincube.sdk.k.d.a.b(a3, d.u)) {
            String string = (String)i2.c.get((Object)"offset");
            Object object = new Object(0){
                public int a;
                public d b;
                public List<String> c;
                {
                    this();
                }
            };
            object.a = (int)com.adincube.sdk.h.g.a.a((String)string, (long)this.e).a;
            object.b = d.u;
            object.c = Collections.singletonList((Object)i2.b);
            this.f.add(object);
        }
        Collections.sort(this.f, (Comparator)new Comparator<a>(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }
        });
        if (l2 != null) {
            Iterator iterator = this.f.iterator();
            while (iterator.hasNext()) {
                if ((long)(iterator.next()).a > l2) continue;
                iterator.remove();
            }
        }
        e2.a(this);
    }

    private void a(d d2, double d3) {
        long l2 = b.a(this.a);
        List<String> list = com.adincube.sdk.k.d.a.a(this.a, d2);
        if (!list.isEmpty()) {
            Object object = new /* invalid duplicate definition of identical inner class */;
            double d4 = l2;
            Double.isNaN((double)d4);
            object.a = (int)(d3 * d4);
            object.b = d2;
            object.c = list;
            this.f.add(object);
        }
    }

    public final void a(e e2) {
        this.onTick(0L);
        this.cancel();
    }

    public final void a(e e2, g g2) {
        this.cancel();
    }

    @Override
    public final void b() {
        this.cancel();
    }

    public final void b(e e2) {
        this.start();
    }

    public final void b_() {
    }

    public final void onFinish() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onTick(long l2) {
        boolean bl;
        try {
            if (!this.b.n()) {
                return;
            }
            bl = this.b.a() == h.f;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("VASTTimeBasedTrackingEventController.onTick()", new Object[]{throwable});
            return;
        }
        long l3 = this.b.o();
        ListIterator listIterator = this.f.listIterator();
        while (listIterator.hasNext()) {
            a a2 = listIterator.next();
            if (!bl && (long)a2.a > l3) break;
            if (!bl) {
                Object[] arrobject = new Object[]{a2.b.w, l3, this.e};
            } else {
                new Object[1][0] = a2.b.w;
            }
            this.d.a("TimeEvent", a2.c, this.a, Long.valueOf((long)l3));
            this.c.a(a2.b);
            listIterator.remove();
        }
    }

}

