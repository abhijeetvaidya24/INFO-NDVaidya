/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 */
package com.moat.analytics.mobile.tjy;

import android.view.View;
import com.moat.analytics.mobile.tjy.bn;
import com.moat.analytics.mobile.tjy.bo;
import java.util.Iterator;

class bp
implements Iterator {
    final /* synthetic */ bo a;
    private int b = -1;

    private bp(bo bo2) {
        this.a = bo2;
    }

    /* synthetic */ bp(bo bo2, bn bn2) {
        this(bo2);
    }

    public View a() {
        this.b = 1 + this.b;
        return bo.a(this.a).getChildAt(this.b);
    }

    public boolean hasNext() {
        return 1 + this.b < bo.a(this.a).getChildCount();
    }

    public /* synthetic */ Object next() {
        return this.a();
    }

    public void remove() {
        throw new UnsupportedOperationException("Not implemented. Under development.");
    }
}

