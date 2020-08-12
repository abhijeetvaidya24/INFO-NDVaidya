/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.g.e.a.a
 *  com.adincube.sdk.g.e.a.a$a
 *  com.adincube.sdk.h.a.a.a
 *  com.adincube.sdk.h.a.a.b
 *  java.lang.Exception
 *  java.lang.Object
 *  java.util.Iterator
 */
package com.adincube.sdk.g.e.a;

import com.adincube.sdk.g.e.a.a;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.util.c;
import java.util.Iterator;

public final class b
extends a {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c(e e2) {
        a.a a2 = this.a;
        try {
            Iterator iterator = c.a(e2, com.adincube.sdk.h.a.a.b.b, false).iterator();
            while (iterator.hasNext()) {
                if (!this.b((com.adincube.sdk.h.a.a.a)iterator.next())) continue;
                return;
            }
            if (a2 == null) return;
        }
        catch (Exception exception) {
            if (a2 == null) return;
            a2.a(exception);
            return;
        }
        a2.b();
    }

    public final void a(e e2) {
        this.c(e2);
    }

    public final boolean b(e e2) {
        Iterator iterator = c.a(e2, com.adincube.sdk.h.a.a.b.b, false).iterator();
        boolean bl = true;
        while (bl && iterator.hasNext()) {
            bl = b.a((com.adincube.sdk.h.a.a.a)((com.adincube.sdk.h.a.a.a)iterator.next()));
        }
        return bl;
    }

    public final void c(com.adincube.sdk.h.a.a.a a2) {
        this.c(a2.a);
    }
}

