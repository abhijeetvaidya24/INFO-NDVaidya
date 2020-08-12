/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package com.adincube.sdk.h.c;

import com.adincube.sdk.g.b.c.h;
import com.adincube.sdk.g.b.c.i;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.h.c.d;
import com.adincube.sdk.h.c.e;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class f
implements Iterator<e> {
    public List<e> a = new ArrayList();
    private d b = null;
    private List<com.adincube.sdk.g.b.c.e> c = null;
    private List<e> d = new ArrayList();
    private e e = null;

    public f(d d2, List<com.adincube.sdk.g.b.c.e> list) {
        this.b = d2;
        this.c = list;
        this.d.addAll(d2.d);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private e b() {
        Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            e e2 = (e)iterator.next();
            if (!e2.c()) {
                try {
                    if (e2.f == null) continue;
                    com.adincube.sdk.g.b.c.e e3 = this.b.f.b(e2).e();
                    if (this.c.contains((Object)e3)) {
                        return null;
                    }
                    if (e2.f.d()) {
                        return e2;
                    }
                    if (e3 != com.adincube.sdk.g.b.c.e.c) continue;
                    this.a.add((Object)e2);
                    continue;
                }
                catch (Throwable throwable) {
                    Object[] arrobject = new Object[]{e2.b(), throwable};
                    a.c("Error caught while inquiring network '%s' for status. Mediation will continue.", arrobject);
                    ErrorReportingHelper.report("ReadyNetworkOrderElementIterator.next", e2.a, this.b.a, throwable);
                }
            }
            iterator.remove();
        }
        return null;
    }

    public final e a() {
        if (!this.hasNext()) {
            return null;
        }
        e e2 = this.e;
        this.d.remove((Object)e2);
        this.e = null;
        return e2;
    }

    public final boolean hasNext() {
        if (this.d.size() == 0) {
            return false;
        }
        if (this.e == null) {
            this.e = this.b();
        }
        return this.e != null;
    }

    public final /* synthetic */ Object next() {
        return this.a();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

