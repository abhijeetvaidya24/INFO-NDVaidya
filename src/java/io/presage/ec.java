/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package io.presage;

import io.presage.du;
import io.presage.eb;

class ec
extends eb {
    public static final boolean a(String string, String string2) {
        return string.startsWith(string2);
    }

    public static final boolean a(String string, String string2, int n2, int n3, boolean bl2) {
        if (!bl2) {
            return string.regionMatches(0, string2, n2, n3);
        }
        return string.regionMatches(bl2, 0, string2, n2, n3);
    }

    public static /* synthetic */ boolean b(String string, String string2) {
        return du.a(string, string2);
    }
}

