/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIIIIIll
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage.core;

import android.os.Parcel;
import android.os.Parcelable;
import io.presage.core.lIIIlIlI;

public final class IlIllIIl
implements Parcelable {
    public static final Parcelable.Creator<IlIllIIl> CREATOR;
    public static final String IIIIIlll;
    public static final String IIIIlIII;
    public static final String IIIIlIIl;
    public static final String IIIIlIlI;
    public static final String IIIIlIll;
    public static final String IIIIllII;
    Long IIIIIIII;
    String IIIIIIIl;
    String IIIIIIlI;
    String IIIIIIll;
    Long IIIIIlII;
    Long IIIIIlIl;
    Long IIIIIllI = 1L;

    static {
        IIIIIlll = lIIIlIlI.IIIIIIll.IIIIIIII;
        IIIIlIII = lIIIlIlI.IIIIIIll.IIIIIIIl;
        IIIIlIIl = lIIIlIlI.IIIIIIll.IIIIIIlI;
        IIIIlIlI = lIIIlIlI.IIIIIIll.IIIIIIll;
        IIIIlIll = lIIIlIlI.IIIIIIll.IIIIIlII;
        IIIIllII = lIIIlIlI.IIIIIIll.IIIIIlIl;
        CREATOR = new Parcelable.Creator<IlIllIIl>(){

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new IlIllIIl(parcel);
            }
        };
    }

    public IlIllIIl() {
    }

    protected IlIllIIl(Parcel parcel) {
        this.IIIIIIIl = parcel.readString();
        this.IIIIIIlI = parcel.readString();
        this.IIIIIlII = parcel.readLong();
        this.IIIIIlIl = parcel.readLong();
        this.IIIIIllI = parcel.readLong();
        this.IIIIIIll = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append(IIIIIlll);
        stringBuilder.append(": ");
        stringBuilder.append(this.IIIIIIIl);
        stringBuilder.append(", ");
        stringBuilder.append(IIIIlIII);
        stringBuilder.append(":");
        stringBuilder.append(this.IIIIIIlI);
        stringBuilder.append(", ");
        stringBuilder.append(IIIIlIIl);
        stringBuilder.append(": ");
        stringBuilder.append((Object)this.IIIIIlII);
        stringBuilder.append(", ");
        stringBuilder.append(IIIIlIlI);
        stringBuilder.append(":");
        stringBuilder.append((Object)this.IIIIIlIl);
        stringBuilder.append(", ");
        stringBuilder.append(IIIIlIll);
        stringBuilder.append(":");
        stringBuilder.append((Object)this.IIIIIllI);
        stringBuilder.append(",");
        stringBuilder.append(IIIIllII);
        stringBuilder.append(": ");
        stringBuilder.append(this.IIIIIIll);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.IIIIIIIl);
        parcel.writeString(this.IIIIIIlI);
        parcel.writeLong(this.IIIIIlII.longValue());
        parcel.writeLong(this.IIIIIlIl.longValue());
        parcel.writeLong(this.IIIIIllI.longValue());
        parcel.writeString(this.IIIIIIll);
    }

}

