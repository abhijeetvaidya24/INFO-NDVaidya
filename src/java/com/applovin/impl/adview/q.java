/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.e.g
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.applovin.impl.adview;

import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import org.json.JSONObject;

public class q {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final boolean e;
    private final int f;
    private final int g;
    private final int h;
    private final float i;
    private final float j;

    public q(JSONObject jSONObject, j j2) {
        p p2 = j2.u();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Updating video button properties with JSON = ");
        stringBuilder.append(g.a((JSONObject)jSONObject, (j)j2));
        p2.b("VideoButtonProperties", stringBuilder.toString());
        this.a = g.a((JSONObject)jSONObject, (String)"width", (int)64, (j)j2);
        this.b = g.a((JSONObject)jSONObject, (String)"height", (int)7, (j)j2);
        this.c = g.a((JSONObject)jSONObject, (String)"margin", (int)20, (j)j2);
        this.d = g.a((JSONObject)jSONObject, (String)"gravity", (int)85, (j)j2);
        this.e = g.a((JSONObject)jSONObject, (String)"tap_to_fade", (Boolean)false, (j)j2);
        this.f = g.a((JSONObject)jSONObject, (String)"tap_to_fade_duration_milliseconds", (int)500, (j)j2);
        this.g = g.a((JSONObject)jSONObject, (String)"fade_in_duration_milliseconds", (int)500, (j)j2);
        this.h = g.a((JSONObject)jSONObject, (String)"fade_out_duration_milliseconds", (int)500, (j)j2);
        this.i = g.a((JSONObject)jSONObject, (String)"fade_in_delay_seconds", (float)1.0f, (j)j2);
        this.j = g.a((JSONObject)jSONObject, (String)"fade_out_delay_seconds", (float)6.0f, (j)j2);
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            q q2 = (q)object;
            if (this.a != q2.a) {
                return false;
            }
            if (this.b != q2.b) {
                return false;
            }
            if (this.c != q2.c) {
                return false;
            }
            if (this.d != q2.d) {
                return false;
            }
            if (this.e != q2.e) {
                return false;
            }
            if (this.f != q2.f) {
                return false;
            }
            if (this.g != q2.g) {
                return false;
            }
            if (this.h != q2.h) {
                return false;
            }
            if (Float.compare((float)q2.i, (float)this.i) != 0) {
                return false;
            }
            return Float.compare((float)q2.j, (float)this.j) == 0;
        }
        return false;
    }

    public long f() {
        return this.f;
    }

    public long g() {
        return this.g;
    }

    public long h() {
        return this.h;
    }

    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * this.a + this.b) + this.c) + this.d) + this.e) + this.f) + this.g) + this.h);
        float f2 = this.i;
        int n3 = f2 != 0.0f ? Float.floatToIntBits((float)f2) : 0;
        int n4 = 31 * (n2 + n3);
        float f3 = this.j;
        float f4 = f3 FCMPL 0.0f;
        int n5 = 0;
        if (f4 != false) {
            n5 = Float.floatToIntBits((float)f3);
        }
        return n4 + n5;
    }

    public float i() {
        return this.i;
    }

    public float j() {
        return this.j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoButtonProperties{widthPercentOfScreen=");
        stringBuilder.append(this.a);
        stringBuilder.append(", heightPercentOfScreen=");
        stringBuilder.append(this.b);
        stringBuilder.append(", margin=");
        stringBuilder.append(this.c);
        stringBuilder.append(", gravity=");
        stringBuilder.append(this.d);
        stringBuilder.append(", tapToFade=");
        stringBuilder.append(this.e);
        stringBuilder.append(", tapToFadeDurationMillis=");
        stringBuilder.append(this.f);
        stringBuilder.append(", fadeInDurationMillis=");
        stringBuilder.append(this.g);
        stringBuilder.append(", fadeOutDurationMillis=");
        stringBuilder.append(this.h);
        stringBuilder.append(", fadeInDelay=");
        stringBuilder.append(this.i);
        stringBuilder.append(", fadeOutDelay=");
        stringBuilder.append(this.j);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

