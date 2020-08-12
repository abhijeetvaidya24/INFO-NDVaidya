/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.util.AbstractQueue
 *  java.util.Iterator
 */
package com.tapjoy.internal;

import com.tapjoy.internal.ay;
import com.tapjoy.internal.bc;
import java.util.AbstractQueue;
import java.util.Iterator;

public abstract class ay
extends AbstractQueue
implements bc {
    public Iterator iterator() {
        return new Iterator(this){
            final /* synthetic */ ay a;
            private int b;
            {
                this.a = ay2;
                this.b = 0;
            }

            public final boolean hasNext() {
                return this.b < this.a.size();
            }

            public final java.lang.Object next() {
                ay ay2 = this.a;
                int n2 = this.b;
                this.b = n2 + 1;
                return ay2.a(n2);
            }

            public final void remove() {
                if (this.b == 1) {
                    this.a.b(1);
                    this.b = 0;
                    return;
                }
                throw new java.lang.UnsupportedOperationException("For the first element only");
            }
        };
    }
}

