/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.Display
 *  android.view.View
 *  android.view.WindowManager
 *  com.tappx.a.a.a.d.c
 *  com.tappx.a.a.a.d.q$1
 *  com.tappx.a.a.a.e.f
 *  com.tappx.a.a.b.k
 *  com.tappx.a.a.b.k$a
 *  com.tappx.a.a.b.k$b
 *  com.tappx.a.a.b.n
 *  com.tappx.a.a.b.s
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tappx.a.a.a.d.c;
import com.tappx.a.a.a.d.q;
import com.tappx.a.a.a.e.f;
import com.tappx.a.a.b.k;
import com.tappx.a.a.b.n;
import com.tappx.a.a.b.s;

public class q {
    private final Context a;
    private int b;
    private int c;
    private k d;
    private c.b e;
    private k.b f = new 1(this);

    public q(Context context) {
        this.a = context;
    }

    static /* synthetic */ int a(q q2) {
        return q2.b;
    }

    static /* synthetic */ int b(q q2) {
        return q2.c;
    }

    static /* synthetic */ c.b c(q q2) {
        return q2.e;
    }

    public void a() {
        k k2 = this.d;
        if (k2 != null) {
            k2.a();
        }
    }

    public void a(f f2, c.b b2) {
        this.e = b2;
        String string2 = f2.h();
        this.d = n.a((Context)this.a, (String)string2);
        this.d.a(this.f);
        this.d.a(s.a, string2, null);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int n2 = f2.k();
        int n3 = f2.i();
        this.b = (int)TypedValue.applyDimension((int)1, (float)n2, (DisplayMetrics)displayMetrics);
        this.c = (int)TypedValue.applyDimension((int)1, (float)n3, (DisplayMetrics)displayMetrics);
    }
}

