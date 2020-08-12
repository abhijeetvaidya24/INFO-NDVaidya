/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bn;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.gt;
import com.tapjoy.internal.hc;
import com.tapjoy.internal.hd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class gu
extends gt {
    public static final bn d = new bn(){

        @Override
        public final /* synthetic */ Object a(bs bs2) {
            return new gu(bs2);
        }
    };
    public ArrayList a = new ArrayList();
    public Map b;
    public float c;

    public gu(bs bs2) {
        bs2.h();
        String string = null;
        String string2 = null;
        while (bs2.j()) {
            String string3 = bs2.l();
            if ("layouts".equals((Object)string3)) {
                bs2.a((List)this.a, hd.d);
                continue;
            }
            if ("meta".equals((Object)string3)) {
                this.b = bs2.d();
                continue;
            }
            if ("max_show_time".equals((Object)string3)) {
                this.c = (float)bs2.p();
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
        ArrayList arrayList = this.a;
        if (arrayList != null) {
            for (hd hd2 : arrayList) {
                if (hd2.c == null) continue;
                for (hc hc2 : hd2.c) {
                    if (hc2.i == null) {
                        hc2.i = string;
                    }
                    if (hc2.h != null) continue;
                    hc2.h = string2;
                }
            }
        }
    }

}

