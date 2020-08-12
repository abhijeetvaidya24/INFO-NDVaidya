/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.InputStream
 */
package com.tapjoy.internal;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class bh
extends FilterInputStream {
    public bh(InputStream inputStream) {
        super(inputStream);
    }

    public final int read(byte[] arrby) {
        int n2;
        int n3;
        for (n3 = 0; n3 < arrby.length; n3 += n2) {
            n2 = super.read(arrby, n3, arrby.length - n3);
            if (n2 != -1) continue;
            if (n3 != 0) {
                return n3;
            }
            return -1;
        }
        return n3;
    }

    public final int read(byte[] arrby, int n2, int n3) {
        int n4;
        int n5;
        for (n4 = 0; n4 < n3; n4 += n5) {
            n5 = super.read(arrby, n2 + n4, n3 - n4);
            if (n5 != -1) continue;
            if (n4 != 0) {
                return n4;
            }
            return -1;
        }
        return n4;
    }

    public final long skip(long l2) {
        long l3;
        long l4;
        for (l3 = 0L; l3 < l2; l3 += l4) {
            l4 = super.skip(l2 - l3);
            if (l4 != 0L) continue;
            if (super.read() < 0) break;
            ++l4;
        }
        return l3;
    }
}

