/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.adincube.sdk.g.b.c.a$1
 *  com.adincube.sdk.g.b.c.a$2
 *  com.adincube.sdk.g.b.c.a$a
 *  com.adincube.sdk.g.b.c.e
 *  com.adincube.sdk.g.b.c.h
 *  com.adincube.sdk.g.b.c.i
 *  com.adincube.sdk.h.c.e
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.g.b.c;

import android.os.Handler;
import android.os.Looper;
import com.adincube.sdk.g.b.c.a;
import com.adincube.sdk.g.b.c.e;
import com.adincube.sdk.g.b.c.h;
import com.adincube.sdk.g.b.c.i;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;
import com.adincube.sdk.util.d.c;

public abstract class a
implements com.adincube.sdk.mediation.a {
    protected com.adincube.sdk.h.c.e a;
    a b = null;
    private i c;
    private boolean d;

    public a(i i2, com.adincube.sdk.h.c.e e2, a a2, boolean bl) {
        this.c = i2;
        this.a = e2;
        this.b = a2;
        this.d = bl;
    }

    public final void a(com.adincube.sdk.h.c.e e2) {
        if (this.d) {
            new Handler(Looper.getMainLooper()).post((Runnable)new 1(this, e2));
            return;
        }
        this.b.a(e2);
    }

    @Override
    public final void a(j j2) {
        block6 : {
            e e2;
            h h2;
            block8 : {
                block4 : {
                    block7 : {
                        block5 : {
                            if (this.a.f == null) {
                                return;
                            }
                            if (this.c.m()) {
                                return;
                            }
                            h2 = this.c.b(this.a);
                            int n2 = 2.a[j2.b.ordinal()];
                            if (n2 == 1) break block4;
                            if (n2 == 2) break block5;
                            if (n2 != 3 && n2 != 4) break block6;
                            if (j2.a != null) {
                                String string = c.a(j2.a);
                                StringBuilder stringBuilder = new StringBuilder("Unexpected error occurred when loading ad for network '");
                                stringBuilder.append(string);
                                stringBuilder.append("'. Category: ");
                                stringBuilder.append(j2.b.e);
                                stringBuilder.append(". Error code: ");
                                stringBuilder.append(j2.a());
                                com.adincube.sdk.util.a.c(stringBuilder.toString(), new Object[0]);
                            }
                            break block7;
                        }
                        if (j2.a != null) {
                            String string = c.a(j2.a);
                            Object[] arrobject = new Object[]{string, j2.a()};
                        }
                    }
                    e2 = e.e;
                    break block8;
                }
                e2 = e.d;
            }
            h2.a(e2);
        }
        this.a(this.a);
    }
}

