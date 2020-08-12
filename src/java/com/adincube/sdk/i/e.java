/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 */
package com.adincube.sdk.i;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@SuppressLint(value={"NewApi"})
public final class e {
    private Map<String, a> a = new HashMap();

    private String a() {
        Iterator iterator = this.a.keySet().iterator();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            int n5 = 1.a[((a)((Object)this.a.get((Object)string))).ordinal()];
            if (n5 != 1) {
                if (n5 != 2) {
                    if (n5 != 3) continue;
                    ++n4;
                    continue;
                }
                ++n2;
                continue;
            }
            ++n3;
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{n2, n4 + (n3 + n2), n4};
        return String.format((Locale)locale, (String)"resources=[%d/%d] inError=[%d]", (Object[])arrobject);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(String string, String string2) {
        Map<String, a> map;
        a a2 = a.a(string);
        Map<String, a> map2 = map = this.a;
        synchronized (map2) {
            this.a.put((Object)string2, (Object)a2);
            Object[] arrobject = new Object[]{this.a(), a2.name(), string2.toString()};
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(boolean bl) {
        Map<String, a> map;
        Map<String, a> map2 = map = this.a;
        synchronized (map2) {
            String string;
            if (this.a.size() == 0) {
                return false;
            }
            Iterator iterator = this.a.keySet().iterator();
            do {
                if (!iterator.hasNext()) return true;
            } while (this.a.get((Object)(string = (String)iterator.next())) == a.b);
            if (!bl) return false;
            new Object[1][0] = this.a();
            return false;
        }
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("new");
        public static final /* enum */ a b = new a("loaded");
        public static final /* enum */ a c = new a("error");
        private static final /* synthetic */ a[] e;
        private String d;

        static {
            a[] arra = new a[]{a, b, c};
            e = arra;
        }

        private a(String string2) {
            this.d = string2;
        }

        public static a a(String string) {
            for (a a2 : a.a()) {
                if (!a2.d.equals((Object)string)) continue;
                return a2;
            }
            return null;
        }

        public static a[] a() {
            return (a[])e.clone();
        }
    }

}

