/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.b.a.a.a.b.i
 *  com.b.a.a.a.c.e
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.b.a.a.a.b.a;

import com.b.a.a.a.b.b;
import com.b.a.a.a.b.i;
import com.b.a.a.a.c.e;
import org.json.JSONObject;

public final class a {
    private final i a;

    private a(i i2) {
        this.a = i2;
    }

    public static a a(b b2) {
        i i2 = (i)b2;
        com.b.a.a.a.e.e.a(b2, "AdSession is null");
        com.b.a.a.a.e.e.g(i2);
        com.b.a.a.a.e.e.a(i2);
        com.b.a.a.a.e.e.b(i2);
        com.b.a.a.a.e.e.e(i2);
        a a2 = new a(i2);
        i2.f().a(a2);
        return a2;
    }

    private void b(float f2) {
        if (!(f2 <= 0.0f)) {
            return;
        }
        throw new IllegalArgumentException("Invalid Video duration");
    }

    private void c(float f2) {
        if (!(f2 < 0.0f) && !(f2 > 1.0f)) {
            return;
        }
        throw new IllegalArgumentException("Invalid Video volume");
    }

    public void a() {
        com.b.a.a.a.e.e.c(this.a);
        this.a.f().a("firstQuartile");
    }

    public void a(float f2) {
        this.c(f2);
        com.b.a.a.a.e.e.c(this.a);
        JSONObject jSONObject = new JSONObject();
        com.b.a.a.a.e.b.a(jSONObject, "videoPlayerVolume", (Object)Float.valueOf((float)f2));
        com.b.a.a.a.e.b.a(jSONObject, "deviceVolume", (Object)Float.valueOf((float)e.a().d()));
        this.a.f().a("volumeChange", jSONObject);
    }

    public void a(float f2, float f3) {
        this.b(f2);
        this.c(f3);
        com.b.a.a.a.e.e.c(this.a);
        JSONObject jSONObject = new JSONObject();
        com.b.a.a.a.e.b.a(jSONObject, "duration", (Object)Float.valueOf((float)f2));
        com.b.a.a.a.e.b.a(jSONObject, "videoPlayerVolume", (Object)Float.valueOf((float)f3));
        com.b.a.a.a.e.b.a(jSONObject, "deviceVolume", (Object)Float.valueOf((float)e.a().d()));
        this.a.f().a("start", jSONObject);
    }

    public void b() {
        com.b.a.a.a.e.e.c(this.a);
        this.a.f().a("midpoint");
    }

    public void c() {
        com.b.a.a.a.e.e.c(this.a);
        this.a.f().a("thirdQuartile");
    }

    public void d() {
        com.b.a.a.a.e.e.c(this.a);
        this.a.f().a("complete");
    }

    public void e() {
        com.b.a.a.a.e.e.c(this.a);
        this.a.f().a("pause");
    }

    public void f() {
        com.b.a.a.a.e.e.c(this.a);
        this.a.f().a("bufferStart");
    }

    public void g() {
        com.b.a.a.a.e.e.c(this.a);
        this.a.f().a("bufferFinish");
    }

    public void h() {
        com.b.a.a.a.e.e.c(this.a);
        this.a.f().a("skipped");
    }
}

