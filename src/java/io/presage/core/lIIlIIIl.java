/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.presage.core;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import io.presage.core.lIIIlIlI;

final class lIIlIIIl
implements IInterface {
    private static final String IIIIIIII = lIIIlIlI.IIIIIIIl.IIIIIIII;
    private IBinder IIIIIIIl;

    public lIIlIIIl(IBinder iBinder) {
        this.IIIIIIIl = iBinder;
    }

    public final String IIIIIIII() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken(IIIIIIII);
            this.IIIIIIIl.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            String string = parcel2.readString();
            return string;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public final boolean IIIIIIIl() {
        boolean bl2;
        Parcel parcel;
        Parcel parcel2;
        block3 : {
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            try {
                parcel2.writeInterfaceToken(IIIIIIII);
                bl2 = true;
            }
            catch (Throwable throwable) {
                parcel.recycle();
                parcel2.recycle();
                throw throwable;
            }
            parcel2.writeInt((int)bl2);
            this.IIIIIIIl.transact(2, parcel2, parcel, 0);
            parcel.readException();
            int n2 = parcel.readInt();
            if (n2 != 0) break block3;
            bl2 = false;
        }
        parcel.recycle();
        parcel2.recycle();
        return bl2;
    }

    public final IBinder asBinder() {
        return this.IIIIIIIl;
    }
}

