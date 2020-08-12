/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.tapjoy.internal.gd$1
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import com.tapjoy.internal.bf;
import com.tapjoy.internal.cs;
import com.tapjoy.internal.fo;
import com.tapjoy.internal.fr;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.x;

public class gd
implements fr {
    private static final gd a = new 1();
    private final fr b;
    private final bf c;

    private gd() {
        this.b = null;
        this.c = null;
    }

    /* synthetic */ gd(byte by2) {
        this();
    }

    private gd(fr fr2) {
        Handler handler;
        this.b = fr2;
        Looper looper = Looper.myLooper();
        if (looper != null) {
            cs.a((Object)looper);
            handler = looper == Looper.getMainLooper() ? x.a() : new Handler(looper);
        } else {
            handler = null;
        }
        if (handler != null) {
            this.c = x.a(handler);
            new Object[1][0] = handler.getLooper();
            return;
        }
        if (Thread.currentThread() == fu.b()) {
            this.c = fu.a;
            return;
        }
        this.c = x.a(x.a());
    }

    static /* synthetic */ fr a(gd gd2) {
        return gd2.b;
    }

    public static gd a(fr fr2) {
        boolean bl = !(fr2 instanceof gd);
        if (bl) {
            if (fr2 != null) {
                return new gd(fr2);
            }
            return a;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void a(String string) {
        this.c.a(new Runnable(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ gd b;
            {
                this.b = gd2;
                this.a = string;
            }

            public final void run() {
                gd.a(this.b).a(this.a);
            }
        });
    }

    @Override
    public void a(String string, fo fo2) {
        this.c.a(new Runnable(this, string, fo2){
            final /* synthetic */ String a;
            final /* synthetic */ fo b;
            final /* synthetic */ gd c;
            {
                this.c = gd2;
                this.a = string;
                this.b = fo2;
            }

            public final void run() {
                gd.a(this.c).a(this.a, this.b);
            }
        });
    }

    @Override
    public void a(String string, String string2, fo fo2) {
        this.c.a(new Runnable(this, string, string2, fo2){
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ fo c;
            final /* synthetic */ gd d;
            {
                this.d = gd2;
                this.a = string;
                this.b = string2;
                this.c = fo2;
            }

            public final void run() {
                gd.a(this.d).a(this.a, this.b, this.c);
            }
        });
    }

    @Override
    public void b(String string) {
        this.c.a(new Runnable(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ gd b;
            {
                this.b = gd2;
                this.a = string;
            }

            public final void run() {
                gd.a(this.b).b(this.a);
            }
        });
    }

    @Override
    public void c(String string) {
        this.c.a(new Runnable(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ gd b;
            {
                this.b = gd2;
                this.a = string;
            }

            public final void run() {
                gd.a(this.b).c(this.a);
            }
        });
    }

    @Override
    public void d(String string) {
        this.c.a(new Runnable(this, string){
            final /* synthetic */ String a;
            final /* synthetic */ gd b;
            {
                this.b = gd2;
                this.a = string;
            }

            public final void run() {
                gd.a(this.b).d(this.a);
            }
        });
    }
}

