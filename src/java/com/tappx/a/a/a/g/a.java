/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tappx.a.a.a.g;

import android.content.Context;
import com.tappx.a.a.a.d.ag;
import com.tappx.a.a.a.d.x;
import com.tappx.a.a.a.e;
import com.tappx.a.a.a.e.c;
import com.tappx.a.a.a.e.d;
import com.tappx.a.a.a.g.a;
import com.tappx.a.a.a.h;
import com.tappx.a.a.a.h.g;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxAdError;

public abstract class a
implements ag.a {
    protected final g a;
    protected AdRequest b;
    boolean c;
    private final ag d;
    private final Context e;
    private final com.tappx.a.a.a.i.a.a f;
    private final c g;
    private final x h;
    private String i;
    private String j;

    a(Context context, c c2) {
        this(context, c2, com.tappx.a.a.a.h.h.a(context).a());
    }

    a(Context context, c c2, g g2) {
        this.e = context;
        this.g = c2;
        e e2 = this.f();
        this.a = g2;
        this.d = e2.g();
        this.h = e2.h();
        this.d.a(this);
        this.f = e2.f();
    }

    static /* synthetic */ void a(a a2, AdRequest adRequest) {
        a2.c(adRequest);
    }

    private void c(AdRequest adRequest) {
        com.tappx.a.a.a.c.a.a(h.a("mo5jy7IL/t1GLb3J/P8gjQ"), new Object[0]);
        com.tappx.a.a.a.c.a.e("CpJSwAt+xAYUOl939gSabw", new Object[0]);
        this.b = adRequest;
        if (adRequest == null) {
            adRequest = new AdRequest();
        }
        try {
            this.g();
        }
        catch (a a2) {}
        if (!this.h.a()) {
            this.a(TappxAdError.NETWORK_ERROR);
            return;
        }
        this.d();
        this.d.a(this.i, this.j, this.g, adRequest);
    }

    private e f() {
        return e.a(this.e);
    }

    private void g() {
        String string = this.i;
        boolean bl = false;
        if (string == null) {
            com.tappx.a.a.a.c.a.b(h.a("ql/gpRHeskeYCNYrbDS7nxNb5jI2ynHn201S0j/Gqul8JUVryuBrMPjdaYQ+79ST"), new Object[0]);
            bl = true;
        }
        if (!bl) {
            return;
        }
        this.a(TappxAdError.DEVELOPER_ERROR);
        throw new Exception(){};
    }

    public Context a() {
        return this.e;
    }

    @Override
    public final void a(d d2) {
        if (this.c) {
            return;
        }
        this.a.a(d2.f(), d2.e(), d2.g());
        com.tappx.a.a.a.c.a.a(h.a("ftLVnAFo4UVdmS7TEXHP3z1+tuYsCsVdhGwkH7sMMCI"), new Object[0]);
        com.tappx.a.a.a.c.a.e("7+KAkb3Ej2KFLftBLdWrHXNw5SyHuZNhHCgeqkrxnXg", new Object[0]);
        this.b(d2);
    }

    @Override
    public final void a(com.tappx.a.a.a.e.h h2) {
        if (this.c) {
            return;
        }
        TappxAdError tappxAdError = this.b(h2);
        String string = h.a("8V2SkLfQtXT7yOPHxqrPlAg6jp+lx+rvQTk+I2vfHWM");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append((Object)tappxAdError);
        com.tappx.a.a.a.c.a.a(stringBuilder.toString(), new Object[0]);
        Object[] arrobject = new Object[]{String.valueOf((Object)((Object)tappxAdError))};
        com.tappx.a.a.a.c.a.e("lgaGjSo8VdlXgzQ7qLaLqzOElG/CkYie3dvHgxY0q1o", arrobject);
        this.a(tappxAdError);
    }

    public void a(AdRequest adRequest) {
        this.b(adRequest);
    }

    protected abstract void a(TappxAdError var1);

    public void a(String string) {
        this.i = string;
    }

    TappxAdError b(com.tappx.a.a.a.e.h h2) {
        int n2 = 2.a[h2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            return TappxAdError.UNSPECIFIED;
                        }
                        return TappxAdError.SERVER_ERROR;
                    }
                    return TappxAdError.NO_FILL;
                }
                return TappxAdError.NETWORK_ERROR;
            }
            return TappxAdError.INTERNAL_ERROR;
        }
        return TappxAdError.DEVELOPER_ERROR;
    }

    public void b() {
        this.c = true;
        this.d.a();
    }

    protected abstract void b(d var1);

    protected void b(AdRequest adRequest) {
        this.a.a(new Runnable(this, adRequest){
            final /* synthetic */ AdRequest a;
            final /* synthetic */ a b;
            {
                this.b = a2;
                this.a = adRequest;
            }

            public void run() {
                a.a(this.b, this.a);
            }
        });
    }

    void b(String string) {
        this.j = string;
    }

    public void c() {
        this.b(this.b);
    }

    void c(String string) {
        if (string == null) {
            return;
        }
        this.f.a(string);
    }

    protected void d() {
    }

    void e() {
        this.c();
    }

}

