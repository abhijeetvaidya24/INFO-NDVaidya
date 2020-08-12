/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.ogury.consent.manager;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ogury.consent.manager.tx6480;

public final class cocoasubrtf100
implements IInterface {
    private final IBinder a;

    public cocoasubrtf100(IBinder iBinder) {
        tx6480.b((Object)iBinder, "binder");
        this.a = iBinder;
    }

    public final String a() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            String string2 = parcel2.readString();
            tx6480.a((Object)string2, "reply.readString()");
            return string2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public final boolean a(boolean bl2) throws RemoteException {
        boolean bl3;
        Parcel parcel;
        Parcel parcel2;
        block3 : {
            parcel = Parcel.obtain();
            parcel2 = Parcel.obtain();
            try {
                parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                bl3 = true;
            }
            catch (Throwable throwable) {
                parcel2.recycle();
                parcel.recycle();
                throw throwable;
            }
            parcel.writeInt((int)bl3);
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            int n2 = parcel2.readInt();
            if (n2 != 0) break block3;
            bl3 = false;
        }
        parcel2.recycle();
        parcel.recycle();
        return bl3;
    }

    public final IBinder asBinder() {
        return this.a;
    }
}

