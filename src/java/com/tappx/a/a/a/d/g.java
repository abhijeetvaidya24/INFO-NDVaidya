/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.tappx.a.a.a.d.c
 *  com.tappx.a.a.a.d.h
 *  com.tappx.a.a.a.d.i
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import android.view.View;
import com.tappx.a.a.a.d.c;
import com.tappx.a.a.a.d.h;
import com.tappx.a.a.a.d.i;

public interface g {
    public void a();

    public void a(c.b var1, Runnable var2);

    public void a(String var1, int var2, int var3);

    public void b();

    public View c();

    public static class a {
        public static g a(Context context) {
            try {
                i i2 = new i(context);
                return i2;
            }
            catch (Throwable throwable) {
                com.tappx.a.a.a.c.a.b(com.tappx.a.a.a.h.a("krJOYpdJwB0z9kroej+tvgvunIIlLf/GdGehIr+r2OSbd/1jAuDbW6Z7w8Rb+zP0p97z+Ss5rCSYnT4eKWDNHxv5azbxwwxG3XGQe+SC2+3s6Z9kUQ084l1qIWDEae3FGWLeg8k8luby4GoV6Q0RRg"), new Object[0]);
                return new h();
            }
        }
    }

}

