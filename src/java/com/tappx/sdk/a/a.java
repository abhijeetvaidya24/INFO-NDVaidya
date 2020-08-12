/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.sdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.tappx.a.a.b.b;

public class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

        public a a(Parcel parcel) {
            return new a(parcel);
        }

        public a[] a(int n2) {
            return new a[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private int a;
    private boolean b;
    private b c = b.a;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private com.tappx.a.a.b.a h;

    public a() {
    }

    private a(Parcel parcel) {
        this.a = parcel.readInt();
        byte by = parcel.readByte();
        boolean bl = true;
        boolean bl2 = by != 0;
        this.b = bl2;
        this.c = b.a(parcel.readString());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        boolean bl3 = parcel.readByte() != 0;
        this.f = bl3;
        if (parcel.readByte() == 0) {
            bl = false;
        }
        this.g = bl;
        this.h = com.tappx.a.a.b.a.a(parcel.readString());
    }

    public int a() {
        return this.a;
    }

    public a a(int n2) {
        this.a = n2;
        return this;
    }

    public a a(com.tappx.a.a.b.a a2) {
        this.h = a2;
        return this;
    }

    public a a(b b2) {
        if (b2 == null) {
            b2 = b.a;
        }
        this.c = b2;
        return this;
    }

    public a a(boolean bl) {
        this.b = bl;
        return this;
    }

    public a b(int n2) {
        this.d = n2;
        return this;
    }

    public a b(boolean bl) {
        this.f = bl;
        return this;
    }

    public boolean b() {
        return this.b;
    }

    public b c() {
        return this.c;
    }

    public a c(int n2) {
        this.e = n2;
        return this;
    }

    public a c(boolean bl) {
        this.g = bl;
        return this;
    }

    public int d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public com.tappx.a.a.b.a h() {
        return this.h;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.a);
        parcel.writeByte((byte)(this.b ? 1 : 0));
        parcel.writeString(b.a(this.c));
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeByte((byte)(this.f ? 1 : 0));
        parcel.writeByte((byte)(this.g ? 1 : 0));
        parcel.writeString(com.tappx.a.a.b.a.a(this.h));
    }

}

