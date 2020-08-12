/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.view.animation.AnimationUtils
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.ads.list3d;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.AnimationUtils;

public abstract class Dynamics
implements Parcelable {
    protected float a;
    protected float b;
    protected float c = Float.MAX_VALUE;
    protected float d = -3.4028235E38f;
    protected long e = 0L;

    public Dynamics() {
    }

    public Dynamics(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = AnimationUtils.currentAnimationTimeMillis();
    }

    public float a() {
        return this.a;
    }

    public void a(double d2) {
        double d3 = this.a;
        Double.isNaN((double)d3);
        this.a = (float)(d3 * d2);
    }

    public void a(float f2) {
        this.c = f2;
    }

    public void a(float f2, float f3, long l2) {
        this.b = f3;
        this.a = f2;
        this.e = l2;
    }

    protected abstract void a(int var1);

    public void a(long l2) {
        long l3 = this.e;
        if (l3 != 0L) {
            int n2 = (int)(l2 - l3);
            int n3 = 50;
            if (n2 <= n3) {
                n3 = n2;
            }
            this.a(n3);
        }
        this.e = l2;
    }

    public boolean a(float f2, float f3) {
        boolean bl = Math.abs((float)this.b) < f2;
        float f4 = this.a;
        boolean bl2 = f4 - f3 < this.c && f4 + f3 > this.d;
        return bl && bl2;
    }

    public float b() {
        return this.b;
    }

    public void b(float f2) {
        this.d = f2;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected float c() {
        float f2 = this.a;
        float f3 = this.c;
        if (f2 > f3) {
            return f3 - f2;
        }
        f3 = this.d;
        if (!(f2 < f3)) return 0.0f;
        return f3 - f2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position: [");
        stringBuilder.append(this.a);
        stringBuilder.append("], Velocity:[");
        stringBuilder.append(this.b);
        stringBuilder.append("], MaxPos: [");
        stringBuilder.append(this.c);
        stringBuilder.append("], mMinPos: [");
        stringBuilder.append(this.d);
        stringBuilder.append("] LastTime:[");
        stringBuilder.append(this.e);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
    }
}

