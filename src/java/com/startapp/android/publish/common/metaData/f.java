/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.startapp.android.publish.common.metaData.MetaDataRequest
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.startapp.android.publish.common.metaData;

import android.content.Context;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.BaseRequest;
import com.startapp.android.publish.adsCommon.Utils.b;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.k;
import com.startapp.android.publish.adsCommon.k.a;
import com.startapp.android.publish.adsCommon.l;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.metaData.MetaDataRequest;
import com.startapp.android.publish.common.metaData.c;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.a.g;
import com.startapp.common.b.a.b;
import java.util.Map;

public class f
implements com.startapp.common.b.a.b {
    private static void a(final Context context, final b.b b2) {
        String string = k.a(context, "shared_prefs_appId", "");
        final AdPreferences adPreferences = new AdPreferences(k.a(context, "shared_prefs_devId", null), string);
        c c2 = new c(context, adPreferences, MetaDataRequest.a.e){
            private MetaData d;
            {
                super(context3, adPreferences3, a2);
                this.d = null;
            }

            @Override
            protected void a(Boolean bl) {
                try {
                    if (bl.booleanValue() && this.d != null && context != null) {
                        MetaData.update(context, this.d);
                    }
                    b.c(context);
                    if (b2 != null) {
                        b2.a(b.a.a);
                        return;
                    }
                }
                catch (Exception exception) {
                    com.startapp.android.publish.adsCommon.f.f.a(context, d.b, "PeriodicMetaData.onPostExecute", exception.getMessage(), "");
                }
            }

            @Override
            protected Boolean c() {
                g.a(3, "Loading MetaData");
                try {
                    l.b(context);
                    MetaDataRequest metaDataRequest = new MetaDataRequest(context, MetaDataRequest.a.e);
                    metaDataRequest.fillApplicationDetails(context, adPreferences, false);
                    metaDataRequest.fillLocationDetails(adPreferences, context);
                    this.d = i.a(a.a(context, AdsConstants.a(AdsConstants.ServiceApiType.METADATA), (BaseRequest)metaDataRequest, null).a(), MetaData.class);
                    return Boolean.TRUE;
                }
                catch (Exception exception) {
                    g.a(6, "Unable to handle GetMetaData command!!!!", exception);
                    return Boolean.FALSE;
                }
            }
        };
        c2.a();
    }

    @Override
    public void a(Context context, int n2, Map<String, String> map, b.b b2) {
        try {
            MetaData.init(context);
            if (MetaData.getInstance().isPeriodicMetaDataEnabled()) {
                f.a(context, b2);
                return;
            }
        }
        catch (Exception exception) {
            com.startapp.android.publish.adsCommon.f.f.a(context, d.b, "PeriodicMetaData.execute", exception.getMessage(), "");
        }
    }

}

