/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 */
package com.startapp.android.publish.ads.video.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.startapp.android.publish.ads.video.c.a.a.b;
import com.startapp.common.a.h;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class c {
    protected int a;
    protected int b;
    private int c;

    public c(Context context) {
        this.a(context);
    }

    private void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.a = displayMetrics.widthPixels;
        this.b = displayMetrics.heightPixels;
        this.c = this.a * this.b;
        if (!h.a(context).equals((Object)"WIFI")) {
            this.c = (int)(0.75f * (float)this.c);
        }
    }

    private boolean a(b b2) {
        return b2.b().matches("video/.*(?i)(mp4|3gpp|mp2t|webm|matroska)");
    }

    public b a(List<b> list) {
        if (list != null && this.c(list) != 0) {
            Collections.sort(list, this.a());
            return this.b(list);
        }
        return null;
    }

    protected Comparator<b> a() {
        return new a();
    }

    protected b b(List<b> list) {
        if (list != null && list.size() > 0) {
            return (b)list.get(0);
        }
        return null;
    }

    protected int c(List<b> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            b b2 = (b)iterator.next();
            if (b2.f() && this.a(b2)) continue;
            iterator.remove();
        }
        return list.size();
    }

    private class a
    implements Comparator<b> {
        private a() {
        }

        public int a(b b2, b b3) {
            int n2;
            int n3 = b2.d() * b2.e();
            int n4 = b3.d() * b3.e();
            int n5 = Math.abs((int)(n3 - c.this.c));
            if (n5 < (n2 = Math.abs((int)(n4 - c.this.c)))) {
                return -1;
            }
            return n5 > n2;
        }

        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((b)object, (b)object2);
        }
    }

}

