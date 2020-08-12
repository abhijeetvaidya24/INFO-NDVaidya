/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.startapp.android.publish.adsCommon.BaseRequest
 *  com.startapp.android.publish.adsCommon.f.e
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.startapp.android.publish.adsCommon.f;

import android.content.Context;
import com.startapp.android.publish.adsCommon.BaseRequest;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.e;
import com.startapp.android.publish.adsCommon.l;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.g;

public class g {
    private final Context a;
    private final AdPreferences b;
    private final e c;
    private final a d;

    public g(Context context, AdPreferences adPreferences, e e2, a a2) {
        this.a = context;
        this.b = adPreferences;
        this.c = e2;
        this.d = a2;
    }

    public void a() {
        com.startapp.common.g.a(g.a.a, new Runnable(){

            public void run() {
                boolean bl = g.this.b();
                if (g.this.d != null) {
                    g.this.d.a(bl);
                }
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected boolean b() {
        var1_1 = new StringBuilder();
        var1_1.append("Sending InfoEvent ");
        var1_1.append((Object)this.c);
        com.startapp.common.a.g.a(3, var1_1.toString());
        try {
            i.a(this.a, this.b);
        }
        catch (Exception var4_5) {
            com.startapp.common.a.g.a(6, "Unable to fill AdPreferences ", var4_5);
            return false;
        }
        try {
            l.b(this.a);
            this.c.fillLocationDetails(this.b, this.a);
            this.c.fillApplicationDetails(this.a, this.b);
            ** GOTO lbl-1000
        }
        catch (Exception v0) {
            try lbl-1000: // 2 sources:
            {
                com.startapp.common.a.g.a(3, "Networking InfoEvent");
                var7_2 = MetaData.getInstance().getAnalyticsConfig().a();
                if (d.c.equals((Object)this.c.e())) {
                    var7_2 = MetaData.getInstance().getAnalyticsConfig().b();
                }
                var8_3 = var7_2;
                com.startapp.android.publish.adsCommon.k.a.a(this.a, var8_3, (BaseRequest)this.c, null, MetaData.getInstance().getAnalyticsConfig().d(), MetaData.getInstance().getAnalyticsConfig().e());
                return true;
            }
            catch (com.startapp.common.e var6_4) {
                com.startapp.common.a.g.a(6, "Unable to send InfoEvent command!!!!", (Throwable)var6_4);
                return false;
            }
        }
    }

    public static interface a {
        public void a(boolean var1);
    }

}

