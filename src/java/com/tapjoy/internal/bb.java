/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.util.List
 */
package com.tapjoy.internal;

import java.util.List;

public final class bb {
    public static void a(List list, int n2) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        if (n2 >= 0) {
            if (n2 > 0) {
                int n3 = list.size();
                if (n2 <= n3) {
                    if (n2 == n3) {
                        list.clear();
                        return;
                    }
                    do {
                        int n4 = n2 - 1;
                        if (n2 > 0) {
                            list.remove(0);
                            n2 = n4;
                            continue;
                        }
                        break;
                    } while (true);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            return;
        }
        indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }
}

