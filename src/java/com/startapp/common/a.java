/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.startapp.common;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.startapp.common.a.d;
import com.startapp.common.g;

public class a {
    String a;
    a b;
    int c;

    public a(String string, a a2, int n2) {
        this.a = string;
        this.b = a2;
        this.c = n2;
    }

    public void a() {
        g.a(g.a.b, new Runnable(){

            public void run() {
                final Bitmap bitmap = d.b(a.this.a);
                new Handler(Looper.getMainLooper()).post(new Runnable(){

                    public void run() {
                        if (a.this.b != null) {
                            a.this.b.a(bitmap, a.this.c);
                        }
                    }
                });
            }

        });
    }

    public static interface a {
        public void a(Bitmap var1, int var2);
    }

}

