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
package io.presage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.presage.cl;

public final class Echourgnacalaliqueurdenoix
implements IInterface {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final IBinder b;

    public Echourgnacalaliqueurdenoix(IBinder iBinder) {
        this.b = iBinder;
    }

    public final String a() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.b.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            String string2 = parcel2.readString();
            cl.a((Object)string2, "reply.readString()");
            return string2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.b;
    }

    public final boolean b() throws RemoteException {
        boolean bl2;
        Parcel parcel;
        Parcel parcel2;
        block3 : {
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            try {
                parcel2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                bl2 = true;
            }
            catch (Throwable throwable) {
                parcel.recycle();
                parcel2.recycle();
                throw throwable;
            }
            parcel2.writeInt((int)bl2);
            this.b.transact(2, parcel2, parcel, 0);
            parcel.readException();
            int n2 = parcel.readInt();
            if (n2 != 0) break block3;
            bl2 = false;
        }
        parcel.recycle();
        parcel2.recycle();
        return bl2;
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}

