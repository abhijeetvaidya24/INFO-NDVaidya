/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.os.SystemClock
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 */
package com.tapjoy.internal;

import android.graphics.Point;
import android.os.SystemClock;
import com.tapjoy.internal.bn;
import com.tapjoy.internal.bo;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.fo;
import com.tapjoy.internal.gr;
import com.tapjoy.internal.gt;
import com.tapjoy.internal.gv;
import com.tapjoy.internal.gy;
import com.tapjoy.internal.ha;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class gx
extends gt {
    public static final bn n = new bn(){

        @Override
        public final /* synthetic */ Object a(bs bs2) {
            return new gx(bs2);
        }
    };
    public ha a;
    public ha b;
    public ha c;
    public Point d;
    public ha e;
    public ha f;
    public String g;
    public fo h;
    public ArrayList i = new ArrayList();
    public ArrayList j = new ArrayList();
    public Map k;
    public long l;
    public gy m;

    public gx() {
    }

    gx(bs bs2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        bs2.h();
        String string = null;
        String string2 = null;
        while (bs2.j()) {
            String string3 = bs2.l();
            if ("frame".equals((Object)string3)) {
                bs2.h();
                while (bs2.j()) {
                    String string4 = bs2.l();
                    if ("portrait".equals((Object)string4)) {
                        this.a = (ha)ha.e.a(bs2);
                        continue;
                    }
                    if ("landscape".equals((Object)string4)) {
                        this.b = (ha)ha.e.a(bs2);
                        continue;
                    }
                    if ("close_button".equals((Object)string4)) {
                        this.c = (ha)ha.e.a(bs2);
                        continue;
                    }
                    if ("close_button_offset".equals((Object)string4)) {
                        this.d = (Point)bo.a.a(bs2);
                        continue;
                    }
                    bs2.s();
                }
                bs2.i();
                continue;
            }
            if ("creative".equals((Object)string3)) {
                bs2.h();
                while (bs2.j()) {
                    String string5 = bs2.l();
                    if ("portrait".equals((Object)string5)) {
                        this.e = (ha)ha.e.a(bs2);
                        continue;
                    }
                    if ("landscape".equals((Object)string5)) {
                        this.f = (ha)ha.e.a(bs2);
                        continue;
                    }
                    bs2.s();
                }
                bs2.i();
                continue;
            }
            if ("url".equals((Object)string3)) {
                this.g = bs2.b();
                continue;
            }
            if (gr.a(string3)) {
                this.h = gr.a(string3, bs2);
                continue;
            }
            if ("mappings".equals((Object)string3)) {
                bs2.h();
                while (bs2.j()) {
                    String string6 = bs2.l();
                    if ("portrait".equals((Object)string6)) {
                        bs2.a((List)this.i, gv.h);
                        continue;
                    }
                    if ("landscape".equals((Object)string6)) {
                        bs2.a((List)this.j, gv.h);
                        continue;
                    }
                    bs2.s();
                }
                bs2.i();
                continue;
            }
            if ("meta".equals((Object)string3)) {
                this.k = bs2.d();
                continue;
            }
            if ("ttl".equals((Object)string3)) {
                double d2 = bs2.p();
                this.l = SystemClock.elapsedRealtime() + (long)(d2 * 1000.0);
                continue;
            }
            if ("no_more_today".equals((Object)string3)) {
                this.m = (gy)gy.d.a(bs2);
                continue;
            }
            if ("ad_content".equals((Object)string3)) {
                string = bs2.b();
                continue;
            }
            if ("redirect_url".equals((Object)string3)) {
                string2 = bs2.b();
                continue;
            }
            bs2.s();
        }
        bs2.i();
        if (this.g == null) {
            this.g = "";
        }
        if ((arrayList2 = this.i) != null) {
            for (gv gv2 : arrayList2) {
                if (gv2.f == null) {
                    gv2.f = string;
                }
                if (gv2.e != null) continue;
                gv2.e = string2;
            }
        }
        if ((arrayList = this.j) != null) {
            for (gv gv3 : arrayList) {
                if (gv3.f == null) {
                    gv3.f = string;
                }
                if (gv3.e != null) continue;
                gv3.e = string2;
            }
        }
    }

    public final boolean a() {
        return this.c != null && this.a != null && this.e != null;
    }

    public final boolean b() {
        return this.c != null && this.b != null && this.f != null;
    }

}

