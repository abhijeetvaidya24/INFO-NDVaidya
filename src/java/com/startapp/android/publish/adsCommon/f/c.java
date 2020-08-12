/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.startapp.android.publish.adsCommon.f.b
 *  com.startapp.android.publish.adsCommon.f.e
 *  com.startapp.android.publish.adsCommon.h.a
 *  com.startapp.android.publish.adsCommon.h.b
 *  com.startapp.android.publish.adsCommon.h.c
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.ArrayList
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.startapp.android.publish.adsCommon.f;

import android.content.Context;
import com.startapp.android.publish.adsCommon.f.b;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.e;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.h.a;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.metaData.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class c {
    static AtomicBoolean f = new AtomicBoolean(false);
    Context a;
    com.startapp.common.d b;
    ArrayList<a> c;
    int d;
    b e;
    private Runnable g = new Runnable(){

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void run() {
            1 var4_1 = this;
            synchronized (var4_1) {
                int n2;
                c c2 = c.this;
                c2.d = n2 = -1 + c2.d;
                if (n2 == 0) {
                    com.startapp.common.a.g.a("DataEventTask", 3, "sending DataEvent");
                    f.a(c.this.a, (e)c.this.e, "");
                    c.f.set(false);
                    c.this.b();
                }
                return;
            }
        }
    };

    public c(Context context, boolean bl) {
        this(context, bl, null);
    }

    public c(Context context, boolean bl, com.startapp.common.d d2) {
        this.a = context;
        this.b = d2;
        this.c = new ArrayList();
        this.e = new b(d.c);
        this.e.a(bl);
        if (MetaData.getInstance().getSensorsConfig().b()) {
            this.c.add((Object)new com.startapp.android.publish.adsCommon.h.c(context, this.g, this.e));
        }
        if (MetaData.getInstance().getBluetoothConfig().b()) {
            this.c.add((Object)new com.startapp.android.publish.adsCommon.h.b(context, this.g, this.e));
        }
        this.d = this.c.size();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void a() {
        if (this.d > 0) {
            boolean bl = f.compareAndSet(false, true);
            int n2 = 0;
            if (bl) {
                while (n2 < this.d) {
                    ((a)this.c.get(n2)).a();
                    ++n2;
                }
                return;
            }
        }
        this.b();
    }

    void b() {
        com.startapp.common.d d2 = this.b;
        if (d2 != null) {
            d2.a(null);
        }
    }

    public b c() {
        return this.e;
    }

}

