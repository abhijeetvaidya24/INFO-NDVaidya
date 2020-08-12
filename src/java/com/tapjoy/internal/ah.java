/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.Iterator
 */
package com.tapjoy.internal;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class ah {
    public static Iterable a(ViewGroup viewGroup) {
        return new Iterable(new a(viewGroup)){
            final /* synthetic */ Iterator a;
            {
                this.a = iterator;
            }

            public final Iterator iterator() {
                return this.a;
            }
        };
    }

    static final class a
    implements Iterator {
        private final ViewGroup a;
        private int b;
        private int c = 0;

        public a(ViewGroup viewGroup) {
            this.a = viewGroup;
            this.b = viewGroup.getChildCount();
        }

        public final boolean hasNext() {
            return this.c < this.b;
        }

        public final /* synthetic */ Object next() {
            ViewGroup viewGroup = this.a;
            int n2 = this.c;
            this.c = n2 + 1;
            return viewGroup.getChildAt(n2);
        }

        public final void remove() {
            this.a.removeViewAt(-1 + this.c);
        }
    }

}

