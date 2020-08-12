/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.Iterator
 */
package com.moat.analytics.mobile.tjy;

import android.view.ViewGroup;
import com.moat.analytics.mobile.tjy.bn;
import com.moat.analytics.mobile.tjy.bp;
import java.util.Iterator;

class bo
implements Iterable {
    private final ViewGroup a;

    private bo(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    /* synthetic */ bo(ViewGroup viewGroup, bn bn2) {
        this(viewGroup);
    }

    static /* synthetic */ ViewGroup a(bo bo2) {
        return bo2.a;
    }

    public Iterator iterator() {
        return new bp(this, null);
    }
}

