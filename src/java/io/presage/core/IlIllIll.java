/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package io.presage.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import io.presage.core.IlIllIIl;
import io.presage.core.lIIIIIlI;
import java.util.ArrayList;
import java.util.Iterator;

public final class IlIllIll
extends BroadcastReceiver {
    public static final String IIIIIIII = lIIIIIlI.IIIIIIIl.IIIIIIII;
    public static final String IIIIIIIl = lIIIIIlI.IIIIIIIl.IIIIIIIl;
    static final ArrayList<IlIllIIl> IIIIIIlI = new ArrayList();

    public final void onReceive(Context context, Intent intent) {
        if (IIIIIIIl.equals((Object)intent.getAction())) {
            IlIllIIl ilIllIIl = (IlIllIIl)intent.getParcelableExtra(IIIIIIII);
            if (ilIllIIl == null) {
                return;
            }
            ilIllIIl.IIIIIIII = System.currentTimeMillis();
            IIIIIIlI.add((Object)ilIllIIl);
            Iterator iterator = IIIIIIlI.iterator();
            while (iterator.hasNext()) {
                IlIllIIl ilIllIIl2 = (IlIllIIl)iterator.next();
                if (ilIllIIl2.IIIIIIII + ilIllIIl2.IIIIIlII >= System.currentTimeMillis()) continue;
                iterator.remove();
            }
        }
    }
}

