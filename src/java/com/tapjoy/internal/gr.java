/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.gz
 *  com.tapjoy.internal.hb
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 */
package com.tapjoy.internal;

import com.tapjoy.internal.bn;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.fo;
import com.tapjoy.internal.fp;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.ft;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.hb;
import java.util.Arrays;

abstract class gr
implements fo {
    private static final String[] a;

    static {
        Object[] arrobject = new String[]{"reward", "purchase", "custom_action"};
        a = arrobject;
        Arrays.sort((Object[])arrobject);
    }

    gr() {
    }

    public static gr a(String string, bs bs2) {
        if ("reward".equals((Object)string)) {
            return (gr)bs2.a(hb.a);
        }
        if ("purchase".equals((Object)string)) {
            return (gr)bs2.a(gz.a);
        }
        return null;
    }

    public static boolean a(String string) {
        return Arrays.binarySearch((Object[])a, (Object)string) >= 0;
    }

    @Override
    public final void a(fp fp2) {
        if (this instanceof fs) {
            fs fs2 = (fs)((Object)this);
            fp2.a(fs2.a(), fs2.b());
            return;
        }
        if (this instanceof ft) {
            ft ft2 = (ft)((Object)this);
            fp2.a(ft2.a(), ft2.b(), ft2.c(), ft2.d());
        }
    }
}

