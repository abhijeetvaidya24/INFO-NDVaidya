/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.String
 *  java.util.Hashtable
 */
package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJConnectListener;
import com.tapjoy.internal.dv;
import com.tapjoy.internal.dw;
import com.tapjoy.internal.fe;
import java.util.Hashtable;

final class dw
extends dv {
    private final fe b = new fe(this){
        final /* synthetic */ dw a;
        {
            this.a = dw2;
        }

        protected final boolean a(Context context, String string, Hashtable hashtable, TJConnectListener tJConnectListener) {
            return dw.a(this.a, context, string, hashtable, tJConnectListener);
        }
    };

    dw() {
    }

    static /* synthetic */ boolean a(dw dw2, Context context, String string, Hashtable hashtable, TJConnectListener tJConnectListener) {
        return super.a(context, string, hashtable, tJConnectListener);
    }

    @Override
    public final boolean a(Context context, String string, Hashtable hashtable, TJConnectListener tJConnectListener) {
        return this.b.b(context, string, hashtable, tJConnectListener);
    }
}

