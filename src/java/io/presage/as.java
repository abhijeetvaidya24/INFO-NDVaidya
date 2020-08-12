/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.ar
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.NoSuchElementException
 */
package io.presage;

import io.presage.ao;
import io.presage.ar;
import io.presage.cl;
import java.util.NoSuchElementException;

class as
extends ar {
    public static final char a(char[] arrc) {
        int n2 = arrc.length;
        if (n2 != 0) {
            if (n2 == 1) {
                return arrc[0];
            }
            throw (Throwable)new IllegalArgumentException("Array has more than one element.");
        }
        throw (Throwable)new NoSuchElementException("Array is empty.");
    }

    public static final <T> boolean a(T[] arrT, T t2) {
        return ao.b(arrT, t2) >= 0;
    }

    public static final <T> int b(T[] arrT, T t2) {
        int n2;
        if (t2 == null) {
            int n3 = arrT.length;
            for (n2 = 0; n2 < n3; ++n2) {
                if (arrT[n2] != null) continue;
                return n2;
            }
        } else {
            int n4 = arrT.length;
            while (n2 < n4) {
                if (cl.a(t2, arrT[n2])) {
                    return n2;
                }
                ++n2;
            }
        }
        return -1;
    }
}

