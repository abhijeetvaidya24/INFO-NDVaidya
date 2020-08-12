/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  java.lang.Object
 */
package com.startapp.android.publish.ads.banner;

import android.graphics.Point;

public class d {
    private Point a = new Point();

    public d() {
    }

    public d(int n2, int n3) {
        this.a(n2, n3);
    }

    public int a() {
        return this.a.x;
    }

    public void a(int n2) {
        this.a.x = n2;
    }

    public void a(int n2, int n3) {
        this.a(n2);
        this.b(n3);
    }

    public int b() {
        return this.a.y;
    }

    public void b(int n2) {
        this.a.y = n2;
    }
}

