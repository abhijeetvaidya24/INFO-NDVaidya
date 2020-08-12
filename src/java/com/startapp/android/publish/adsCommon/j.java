/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.adsCommon;

import android.content.Context;
import com.startapp.android.publish.adsCommon.BaseRequest;
import com.startapp.android.publish.adsCommon.Utils.d;
import com.startapp.android.publish.adsCommon.Utils.e;
import com.startapp.android.publish.adsCommon.i.a;
import com.startapp.android.publish.adsCommon.i.b;
import com.startapp.common.a.c;

public class j
extends BaseRequest {
    private b a;
    private String b;

    public j(Context context) {
        this.a = a.a(context);
        this.b = c.j(context);
    }

    @Override
    public e getNameValueMap() {
        e e2 = super.getNameValueMap();
        if (e2 == null) {
            e2 = new d();
        }
        e2.a("placement", "INAPP_DOWNLOAD", true);
        b b2 = this.a;
        if (b2 != null) {
            e2.a("install_referrer", b2.a(), true);
            e2.a("referrer_click_timestamp_seconds", this.a.b(), true);
            e2.a("install_begin_timestamp_seconds", this.a.c(), true);
        }
        e2.a("apkSig", this.b, true);
        return e2;
    }
}

