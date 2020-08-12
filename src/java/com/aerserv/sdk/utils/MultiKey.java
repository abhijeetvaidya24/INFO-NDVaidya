/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Arrays
 */
package com.aerserv.sdk.utils;

import java.util.Arrays;

public class MultiKey {
    private Object[] keys;

    public /* varargs */ MultiKey(Object ... arrobject) {
        this.keys = new Object[arrobject.length];
        for (int i2 = 0; i2 < arrobject.length; ++i2) {
            this.keys[i2] = arrobject[i2];
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MultiKey)) {
            return false;
        }
        MultiKey multiKey = (MultiKey)object;
        return Arrays.equals((Object[])this.keys, (Object[])multiKey.keys);
    }

    public boolean hasKey(Object object) {
        Object[] arrobject;
        for (int i2 = 0; i2 < (arrobject = this.keys).length; ++i2) {
            if (arrobject[i2] == null || !arrobject[i2].equals(object)) continue;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode((Object[])this.keys);
    }
}

