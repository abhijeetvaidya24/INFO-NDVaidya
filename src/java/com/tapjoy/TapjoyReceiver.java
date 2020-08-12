/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.os.Bundle
 *  com.tapjoy.internal.dy
 *  com.tapjoy.internal.dy$a
 *  com.tapjoy.internal.eb
 *  com.tapjoy.internal.ef
 *  com.tapjoy.internal.ge
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.tapjoy.internal.dy;
import com.tapjoy.internal.eb;
import com.tapjoy.internal.ef;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.ge;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gn;
import java.util.List;

public class TapjoyReceiver
extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        ge.b((Context)context);
        if ("com.tapjoy.PUSH_CLICK".equals((Object)intent.getAction())) {
            String string2 = intent.getStringExtra("com.tapjoy.PUSH_ID");
            String string3 = intent.getStringExtra("com.tapjoy.PUSH_PAYLOAD");
            String string4 = intent.getStringExtra("com.tapjoy.PUSH_PLACEMENT");
            if (string2 != null && string2.length() != 0) {
                Intent intent2;
                PackageManager packageManager = context.getPackageManager();
                String string5 = context.getPackageName();
                Intent intent3 = new Intent("android.intent.action.MAIN");
                intent3.setPackage(string5);
                intent3.addCategory("android.intent.category.LAUNCHER");
                List list = packageManager.queryIntentActivities(intent3, 0);
                if (list != null && list.size() > 0) {
                    intent2 = new Intent(intent3);
                    intent2.setFlags(268435456);
                    intent2.setClassName(((ResolveInfo)list.get((int)0)).activityInfo.packageName, ((ResolveInfo)list.get((int)0)).activityInfo.name);
                } else {
                    intent2 = null;
                }
                if (intent2 != null) {
                    if (string3 != null) {
                        intent2.putExtra("com.tapjoy.PUSH_PAYLOAD", string3);
                    }
                    gc gc2 = gc.a(context);
                    if (gc2.f.c(string2)) {
                        gb gb2 = gc2.g;
                        dy.a a2 = gb2.a(eb.APP, "push_click");
                        a2.s = new ef(null, null, string2);
                        gb2.a(a2);
                    }
                    if (string4 != null) {
                        gn.a(string2, string4);
                    }
                    context.startActivity(intent2);
                } else {
                    fz.b("No intent that can be used to launch the main activity.");
                }
            }
        }
        if (this.isOrderedBroadcast()) {
            this.setResult(-1, null, null);
        }
    }
}

