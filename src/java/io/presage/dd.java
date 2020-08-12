/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.bi
 *  java.lang.Throwable
 *  java.util.NoSuchElementException
 */
package io.presage;

import io.presage.bi;
import java.util.NoSuchElementException;

public final class dd
extends bi {
    private final int a;
    private boolean b;
    private int c;
    private final int d;

    public dd(int n2, int n3, int n4) {
        this.d = n4;
        this.a = n3;
        int n5 = this.d;
        boolean bl2 = true;
        if (!(n5 > 0 ? n2 <= n3 : n2 >= n3)) {
            bl2 = false;
        }
        this.b = bl2;
        if (!this.b) {
            n2 = this.a;
        }
        this.c = n2;
    }

    public final int a() {
        int n2 = this.c;
        if (n2 == this.a) {
            if (this.b) {
                this.b = false;
                return n2;
            }
            throw (Throwable)new NoSuchElementException();
        }
        this.c = n2 + this.d;
        return n2;
    }

    public final boolean hasNext() {
        return this.b;
    }
}

