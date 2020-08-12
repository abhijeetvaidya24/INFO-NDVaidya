/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.opengl.GLSurfaceView
 *  com.tapjoy.internal.dw
 *  com.tapjoy.internal.es
 *  com.tapjoy.internal.fa
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Hashtable
 *  java.util.Map
 *  java.util.Set
 */
package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.internal.dw;
import com.tapjoy.internal.es;
import com.tapjoy.internal.fa;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public abstract class du {
    private static final du b;
    private static du c;
    protected volatile boolean a = false;

    static {
        fa.a();
        es.a();
        dw dw2 = new dw();
        b = dw2;
        c = dw2;
    }

    du() {
    }

    public static du a() {
        return c;
    }

    public abstract TJPlacement a(String var1, TJPlacementListener var2);

    public abstract void a(float var1);

    public abstract void a(int var1);

    public abstract void a(int var1, TJAwardCurrencyListener var2);

    public abstract void a(int var1, TJSpendCurrencyListener var2);

    public abstract void a(int var1, String var2);

    public abstract void a(Activity var1);

    public abstract void a(GLSurfaceView var1);

    public abstract void a(TJEarnedCurrencyListener var1);

    public abstract void a(TJGetCurrencyBalanceListener var1);

    public abstract void a(TJVideoListener var1);

    public abstract void a(String var1);

    public abstract void a(String var1, long var2);

    public abstract void a(String var1, TJSetUserIDListener var2);

    public abstract void a(String var1, String var2);

    public abstract void a(String var1, String var2, double var3, String var5);

    public abstract void a(String var1, String var2, long var3);

    public abstract void a(String var1, String var2, String var3, String var4);

    public abstract void a(String var1, String var2, String var3, String var4, long var5);

    public abstract void a(String var1, String var2, String var3, String var4, String var5, long var6);

    public abstract void a(String var1, String var2, String var3, String var4, String var5, long var6, String var8, long var9);

    public abstract void a(String var1, String var2, String var3, String var4, String var5, long var6, String var8, long var9, String var11, long var12);

    public abstract void a(String var1, String var2, String var3, String var4, Map var5);

    public abstract void a(Set var1);

    public abstract void a(boolean var1);

    public abstract boolean a(Context var1, String var2);

    public abstract boolean a(Context var1, String var2, Hashtable var3, TJConnectListener var4);

    public abstract String b();

    public abstract void b(int var1);

    public abstract void b(Activity var1);

    public abstract void b(String var1);

    public abstract void b(String var1, String var2, String var3, String var4);

    public abstract void b(boolean var1);

    public abstract float c();

    public abstract void c(Activity var1);

    public abstract void c(String var1);

    public abstract void c(boolean var1);

    public abstract void d();

    public abstract void d(String var1);

    public abstract void e();

    public abstract void e(String var1);

    public abstract Set f();

    public abstract void f(String var1);

    public abstract String g(String var1);

    public abstract void g();

    public abstract void h(String var1);

    public abstract boolean h();

    public abstract boolean i();
}

