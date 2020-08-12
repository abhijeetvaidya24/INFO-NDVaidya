/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.startapp.common.b.a;

import android.content.Context;
import java.util.Map;

public interface b {
    public void a(Context var1, int var2, Map<String, String> var3, b var4);

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

    public static interface b {
        public void a(a var1);
    }

}

