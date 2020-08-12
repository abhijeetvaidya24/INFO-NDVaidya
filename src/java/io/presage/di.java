/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.dh
 */
package io.presage;

import io.presage.dh;

class di
extends dh {
    public static final int a(int n2) {
        if (n2 < 0) {
            n2 = 0;
        }
        return n2;
    }

    public static final int a(int n2, int n3) {
        if (n2 > n3) {
            return n3;
        }
        return n2;
    }
}

