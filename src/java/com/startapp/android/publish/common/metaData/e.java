/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.startapp.android.publish.common.metaData;

import android.content.Context;
import com.startapp.android.publish.adsCommon.Utils.b;
import com.startapp.android.publish.adsCommon.f.c;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.common.a.g;
import com.startapp.common.b.a.b;
import com.startapp.common.d;
import java.util.Map;

public class e
implements com.startapp.common.b.a.b {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void a(final Context context, int n2, Map<String, String> map, final b.b b2) {
        g.a("PeriodicInfoEvent", 3, "PeriodicInfoEvent execute");
        MetaData.init(context);
        MetaData.getInstance().setReady(true);
        if (MetaData.getInstance().isPeriodicInfoEventEnabled()) {
            new c(context, true, new d(){

                @Override
                public void a(Object object) {
                    if (b2 != null) {
                        b.d(context);
                        b2.a(b.a.a);
                    }
                }
            }).a();
            return;
        }
        if (b2 == null) return;
        try {
            b.d(context);
            b2.a(b.a.a);
            return;
        }
        catch (Exception exception) {
            f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "PeriodicInfoEvent.execute", exception.getMessage(), "");
        }
    }

}

