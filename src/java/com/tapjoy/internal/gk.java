/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.hm
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.tapjoy.internal;

import com.tapjoy.internal.cf;
import com.tapjoy.internal.ck;
import com.tapjoy.internal.cv;
import com.tapjoy.internal.cx;
import com.tapjoy.internal.cy;
import com.tapjoy.internal.ez;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.gi;
import com.tapjoy.internal.gj;
import com.tapjoy.internal.hm;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class gk
implements ck {
    public final gc a;
    Set b;
    private final Map c;
    private final Map d;

    public gk(gc gc2) {
        this.a = gc2;
        this.c = Collections.synchronizedMap((Map)new HashMap());
        this.d = cx.a();
        this.b = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(cf cf2, hm.a a2) {
        if (!(cf2 instanceof hm)) {
            throw new IllegalStateException(cf2.getClass().getName());
        }
        if (a2.b != null) {
            List list = a2.b;
            gk gk2 = this;
            synchronized (gk2) {
                HashSet hashSet = list instanceof Collection ? new HashSet(cv.a((Iterable)list)) : cy.a(list.iterator());
                this.b = hashSet;
            }
        }
        hm hm2 = (hm)cf2;
        String string = hm2.c;
        boolean bl = hm2.d;
        this.d.remove((Object)string);
        if (!bl) {
            this.c.put((Object)string, (Object)a2.a);
        }
        gj gj2 = a2.a;
        gd gd2 = this.a.p;
        if (gj2 instanceof gi) {
            fz.a("No content for \"{}\"", string);
            gd2.a(string);
            return;
        }
        fz.a("New content for \"{}\" is ready", string);
        if (bl) {
            gj2.a(gd2, new ez());
            return;
        }
        gd2.b(string);
    }

    @Override
    public final void a(cf cf2) {
        this.a(cf2, new hm.a(new gi(), null));
    }
}

