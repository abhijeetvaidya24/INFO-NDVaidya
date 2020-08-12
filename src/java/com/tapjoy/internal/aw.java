/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Set
 */
package com.tapjoy.internal;

import com.tapjoy.internal.ar;
import com.tapjoy.internal.at;
import com.tapjoy.internal.av;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public final class aw
extends av {
    private final LinkedHashMap a = new LinkedHashMap(0, 0.75f, true);
    private int b = 10;

    private void a() {
        int n2 = this.a.size() - this.b;
        if (n2 > 0) {
            Iterator iterator = this.a.entrySet().iterator();
            while (n2 > 0 && iterator.hasNext()) {
                --n2;
                iterator.next();
                iterator.remove();
            }
        }
    }

    @Override
    protected final at a(Object object, boolean bl) {
        ar ar2 = (ar)this.a.get(object);
        if (ar2 == null && bl) {
            ar2 = new ar(object);
            this.a.put(object, (Object)ar2);
            this.a();
        }
        return ar2;
    }

    @Override
    public final void a(Object object, Object object2) {
        super.a(object, object2);
        this.a();
    }
}

