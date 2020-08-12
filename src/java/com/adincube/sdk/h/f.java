/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package com.adincube.sdk.h;

import android.content.Context;
import com.adincube.sdk.util.b.j;

public final class f {
    public int a;
    public int b;

    public f(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public static f a(Context context, int n2, int n3) {
        return new f(j.b(context, n2), j.b(context, n3));
    }
}

