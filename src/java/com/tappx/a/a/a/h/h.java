/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  com.tappx.a.a.a.h.k
 *  com.tappx.sdk.android.TappxPrivacyManager
 *  java.lang.Class
 *  java.lang.Object
 */
package com.tappx.a.a.a.h;

import android.content.Context;
import android.content.SharedPreferences;
import com.tappx.a.a.a.b.i;
import com.tappx.a.a.a.h.a;
import com.tappx.a.a.a.h.c;
import com.tappx.a.a.a.h.e;
import com.tappx.a.a.a.h.g;
import com.tappx.a.a.a.h.j;
import com.tappx.a.a.a.h.k;
import com.tappx.sdk.android.TappxPrivacyManager;

public final class h {
    private static volatile h a;
    private final Context b;
    private final e c = new e();

    private h(Context context) {
        this.b = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h a(Context context) {
        h h2 = a;
        if (h2 != null) {
            return h2;
        }
        Class<h> class_ = h.class;
        synchronized (h.class) {
            h h3 = a;
            if (h3 != null) return h3;
            a = new h(context.getApplicationContext());
            return a;
        }
    }

    private com.tappx.a.a.a.b.g d() {
        return new com.tappx.a.a.a.b.g(this.g().o());
    }

    private a e() {
        return new a(this.f());
    }

    private i f() {
        return this.g().d();
    }

    private com.tappx.a.a.a.e g() {
        return com.tappx.a.a.a.e.a(this.b);
    }

    private j h() {
        return new j(this.g().o());
    }

    public g a() {
        return new g(this.h(), new c(this.f(), this.d()), this.c(), this.e());
    }

    public TappxPrivacyManager b() {
        return new k(this.a());
    }

    e c() {
        return this.c;
    }
}

