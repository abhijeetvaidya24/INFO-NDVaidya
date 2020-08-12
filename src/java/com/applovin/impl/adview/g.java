/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.applovin.impl.adview.m
 *  com.applovin.impl.adview.o
 *  com.applovin.impl.adview.v
 *  com.applovin.impl.sdk.j
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import com.applovin.impl.adview.m;
import com.applovin.impl.adview.o;
import com.applovin.impl.adview.v;
import com.applovin.impl.sdk.j;

public abstract class g
extends View {
    protected final j a;
    protected final Context b;

    g(j j2, Context context) {
        super(context);
        this.b = context;
        this.a = j2;
    }

    public static g a(j j2, Context context, a a2) {
        if (a2.equals((Object)a.c)) {
            return new m(j2, context);
        }
        if (a2.equals((Object)a.b)) {
            return new o(j2, context);
        }
        return new v(j2, context);
    }

    public abstract void a(int var1);

    public abstract a getStyle();

    public abstract float getViewScale();

    public abstract void setViewScale(float var1);

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        private static final /* synthetic */ a[] d;

        static {
            a[] arra = new a[]{a, b, c};
            d = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])d.clone();
        }
    }

}

