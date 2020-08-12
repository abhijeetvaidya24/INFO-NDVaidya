/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Handler
 *  android.os.Looper
 *  io.presage.core.IIlIIllI
 *  io.presage.core.IlIllllI$2
 *  io.presage.core.IlIllllI$4
 *  io.presage.core.IllIIIII
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIIIIlIl
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 */
package io.presage.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import io.presage.core.IIlIIllI;
import io.presage.core.IIlIIlll;
import io.presage.core.IlIllIIl;
import io.presage.core.IlIllIll;
import io.presage.core.IlIllllI;
import io.presage.core.IllIIIII;
import io.presage.core.IllIIIIl;
import io.presage.core.IllIIlIl;
import io.presage.core.IllIIlll;
import io.presage.core.lIIIlIlI;
import java.util.ArrayList;

public final class IlIllllI
extends BroadcastReceiver {
    private static final String IIIIIIlI = lIIIlIlI.IIIIIlIl.IIIIIIII;
    private static final String IIIIIIll = lIIIlIlI.IIIIIlIl.IIIIIIIl;
    final Handler IIIIIIII = new Handler(Looper.getMainLooper());
    Runnable IIIIIIIl;
    private Context IIIIIlII;

    static /* synthetic */ void IIIIIIII(IlIllllI ilIllllI, IlIllIIl ilIllIIl, IIlIIllI iIlIIllI, boolean bl2, boolean bl3) {
        String string2;
        StringBuilder stringBuilder;
        if (bl3) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(ilIllIIl.IIIIIIll);
            string2 = IIIIIIlI;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(ilIllIIl.IIIIIIll);
            string2 = IIIIIIll;
        }
        stringBuilder.append(string2);
        IllIIIIl.IIIIIIII(iIlIIllI, new IllIIlll(stringBuilder.toString(), IllIIlll.IIIIIIIl, (IllIIlIl)new IllIIIII()), (IllIIIIl.IIIIIIII)new 4(ilIllllI, bl2, iIlIIllI, ilIllIIl));
    }

    public final void onReceive(Context context, Intent intent) {
        this.IIIIIlII = context;
        if ("android.intent.action.PACKAGE_ADDED".equals((Object)intent.getAction()) && !intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
            if (intent.getDataString() == null) {
                return;
            }
            final String string2 = intent.getDataString().split(":")[1];
            new Object[1][0] = string2;
            IIlIIllI iIlIIllI = IIlIIlll.IIIIIIII().IIIIIIIl();
            if (string2 != null) {
                for (IlIllIIl ilIllIIl : IlIllIll.IIIIIIlI) {
                    if (ilIllIIl.IIIIIIIl == null || !ilIllIIl.IIIIIIIl.equals((Object)string2)) continue;
                    new Object[1][0] = ilIllIIl;
                    if (ilIllIIl.IIIIIlIl + ilIllIIl.IIIIIIII > System.currentTimeMillis()) {
                        IllIIIIl.IIIIIIII(iIlIIllI, new IllIIlll(ilIllIIl.IIIIIIlI, IllIIlll.IIIIIIIl, (IllIIlIl)new IllIIIII()), (IllIIIIl.IIIIIIII)new 2(this, ilIllIIl, iIlIIllI));
                        return;
                    }
                    if (ilIllIIl.IIIIIlII + ilIllIIl.IIIIIIII <= System.currentTimeMillis()) break;
                    this.IIIIIIIl = new Runnable(){

                        public final void run() {
                            if (IlIllllI.this.IIIIIlII != null) {
                                if (IlIllllI.this.IIIIIlII.getPackageManager() == null) {
                                    return;
                                }
                                Intent intent = IlIllllI.this.IIIIIlII.getPackageManager().getLaunchIntentForPackage(string2);
                                IlIllllI.this.IIIIIlII.startActivity(intent);
                            }
                        }
                    };
                    break;
                }
            }
        }
    }

}

