/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.bs
 *  com.tapjoy.internal.hc$1
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bn;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.ha;
import com.tapjoy.internal.hc;
import com.tapjoy.internal.he;

public final class hc {
    public static final bn n = new 1();
    public he a;
    public he b;
    public he c;
    public he d;
    public int e = 9;
    public int f = 10;
    public String g;
    public String h;
    public String i;
    public boolean j = false;
    public String k;
    public ha l;
    public ha m;

    public hc(bs bs2) {
        bs2.h();
        while (bs2.j()) {
            String string2 = bs2.l();
            if ("x".equals((Object)string2)) {
                this.a = he.a(bs2.m());
                continue;
            }
            if ("y".equals((Object)string2)) {
                this.b = he.a(bs2.m());
                continue;
            }
            if ("width".equals((Object)string2)) {
                this.c = he.a(bs2.m());
                continue;
            }
            if ("height".equals((Object)string2)) {
                this.d = he.a(bs2.m());
                continue;
            }
            if ("url".equals((Object)string2)) {
                this.g = bs2.m();
                continue;
            }
            if ("redirect_url".equals((Object)string2)) {
                this.h = bs2.m();
                continue;
            }
            if ("ad_content".equals((Object)string2)) {
                this.i = bs2.m();
                continue;
            }
            if ("dismiss".equals((Object)string2)) {
                this.j = bs2.n();
                continue;
            }
            if ("value".equals((Object)string2)) {
                this.k = bs2.m();
                continue;
            }
            if ("image".equals((Object)string2)) {
                this.l = (ha)ha.e.a(bs2);
                continue;
            }
            if ("image_clicked".equals((Object)string2)) {
                this.m = (ha)ha.e.a(bs2);
                continue;
            }
            if ("align".equals((Object)string2)) {
                String string3 = bs2.m();
                if ("left".equals((Object)string3)) {
                    this.e = 9;
                    continue;
                }
                if ("right".equals((Object)string3)) {
                    this.e = 11;
                    continue;
                }
                if ("center".equals((Object)string3)) {
                    this.e = 14;
                    continue;
                }
                bs2.s();
                continue;
            }
            if ("valign".equals((Object)string2)) {
                String string4 = bs2.m();
                if ("top".equals((Object)string4)) {
                    this.f = 10;
                    continue;
                }
                if ("middle".equals((Object)string4)) {
                    this.f = 15;
                    continue;
                }
                if ("bottom".equals((Object)string4)) {
                    this.f = 12;
                    continue;
                }
                bs2.s();
                continue;
            }
            bs2.s();
        }
        bs2.i();
    }
}

