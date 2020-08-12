/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  com.tappx.a.a.a.h.g$2
 *  com.tappx.a.a.a.h.g$3
 *  com.tappx.a.a.a.h.g$4
 *  com.tappx.a.a.a.h.g$5
 *  com.tappx.sdk.android.PrivacyConsentActivity
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.ref.WeakReference
 *  java.util.concurrent.TimeUnit
 */
package com.tappx.a.a.a.h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tappx.a.a.a.h;
import com.tappx.a.a.a.h.a;
import com.tappx.a.a.a.h.c;
import com.tappx.a.a.a.h.d;
import com.tappx.a.a.a.h.e;
import com.tappx.a.a.a.h.g;
import com.tappx.a.a.a.h.i;
import com.tappx.a.a.a.h.j;
import com.tappx.a.a.a.h.l;
import com.tappx.sdk.android.PrivacyConsentActivity;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class g {
    private static final int a = 5;
    private static final long b = TimeUnit.DAYS.toSeconds(365L);
    private final j c;
    private final c d;
    private final e e;
    private final com.tappx.a.a.a.h.a f;
    private boolean g;

    g(j j2, c c2, e e2, com.tappx.a.a.a.h.a a2) {
        this.c = j2;
        this.d = c2;
        this.e = e2;
        this.f = a2;
    }

    private void a(Context context, String string2, String string3) {
        Intent intent = d.a(context, string2, string3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            String string4 = PrivacyConsentActivity.class.getName();
            String string5 = PrivacyConsentActivity.class.getSimpleName();
            com.tappx.a.a.a.c.a.b(h.a("dfKcWOaG8KPoMfm5zts08Qlu05+R8BIzO3YcOMbimy7M7b66oYD1J20myZSpOoOWRYcUsjDmTjtwSPWh2TgTXA"), string4, string5);
            return;
        }
    }

    private void a(a a2) {
        i i2 = this.c.b();
        String string2 = this.c.d();
        boolean bl2 = i2 != i.e;
        if (bl2) {
            a2.a();
            return;
        }
        if (string2 == null) {
            this.c(a2);
            return;
        }
        a2.a(string2, null);
    }

    static /* synthetic */ void a(g g2, Context context, String string2, String string3) {
        g2.a(context, string2, string3);
    }

    private void a(i i2) {
        if (this.c.b() == i2) {
            return;
        }
        this.c.a(i2);
        this.c.b(false);
        this.c.c(true);
        this.c.a(this.k());
        this.j();
    }

    private void a(WeakReference<Context> weakReference) {
        this.e.b();
        this.b((a)new 2(this, weakReference));
    }

    static /* synthetic */ boolean a(g g2, boolean bl2) {
        g2.g = bl2;
        return bl2;
    }

    static /* synthetic */ j b(g g2) {
        return g2.c;
    }

    private void b(a a2) {
        boolean bl2 = this.c.f();
        Boolean bl3 = this.c.a();
        if (Boolean.FALSE.equals((Object)bl3) && !bl2) {
            a2.a();
            return;
        }
        if (Boolean.TRUE.equals((Object)bl3) && !bl2) {
            this.a(a2);
            return;
        }
        this.c(a2);
    }

    private void c(a a2) {
        this.d.a((c.a)new 3(this, a2));
    }

    private long k() {
        return System.currentTimeMillis() / 1000L;
    }

    private void l() {
        long l2 = this.c.k();
        if (l2 <= 0L) {
            return;
        }
        if (Math.abs((long)(this.k() - l2)) > b) {
            this.c.c();
        }
    }

    public void a() {
        this.c.h();
        this.a(i.a);
    }

    public void a(Context context) {
        Boolean bl2 = this.c.a();
        boolean bl3 = Boolean.TRUE.equals((Object)bl2);
        String string2 = this.c.d();
        if (bl3 && string2 != null) {
            this.a(context, string2, null);
            return;
        }
        if (Boolean.FALSE.equals((Object)bl2)) {
            return;
        }
        this.c((a)new 4(this, context, string2));
    }

    public void a(Context context, final Runnable runnable) {
        final WeakReference weakReference = new WeakReference((Object)context);
        this.l();
        this.e.a(new Runnable(){

            public void run() {
                g.this.a((WeakReference<Context>)weakReference);
                if (runnable != null) {
                    g.this.e.a(runnable);
                }
            }
        });
    }

    public void a(Runnable runnable) {
        this.e.a(runnable);
    }

    public void a(String string2) {
        this.c.a(string2);
    }

    public void a(boolean bl2) {
        this.c.a(bl2);
    }

    public void a(boolean bl2, int n2, String string2) {
        this.c.a((Boolean)bl2);
        if (string2 != null) {
            this.c.b(string2);
        }
        if (this.c.i() != n2) {
            this.c.a(n2);
            this.f();
        }
    }

    public void b() {
        this.c.h();
        this.a(i.b);
    }

    public void c() {
        this.a(i.c);
    }

    public void d() {
        this.a(i.d);
    }

    public boolean e() {
        return this.c.e();
    }

    public void f() {
        this.c.b(true);
    }

    public l g() {
        Boolean bl2 = this.c.a();
        i i2 = this.c.b();
        String string2 = this.c.g();
        long l2 = this.c.k();
        l l3 = new l(bl2, i2, string2, l2);
        return l3;
    }

    public boolean h() {
        if (!Boolean.TRUE.equals((Object)this.c.a())) {
            return false;
        }
        return this.c.b().a();
    }

    public String i() {
        String string2 = this.c.l();
        if (string2 != null && string2.length() > 5) {
            return string2;
        }
        return null;
    }

    public void j() {
        if (this.g) {
            return;
        }
        if (!this.c.j()) {
            return;
        }
        i i2 = this.c.b();
        if (i2 == i.e) {
            return;
        }
        this.g = true;
        long l2 = this.c.k();
        long l3 = Math.max((long)(this.k() - l2), (long)0L);
        this.f.a(i2, l3, (a.a)new 5(this));
    }

    public static interface a {
        public void a();

        public void a(String var1, String var2);

        public void b();
    }

}

