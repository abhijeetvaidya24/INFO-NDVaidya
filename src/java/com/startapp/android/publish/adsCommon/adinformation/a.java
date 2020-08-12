/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.adsCommon.adinformation;

import android.content.Context;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.adinformation.AdInformationConfig;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.common.a.e;
import java.io.Serializable;

public class a
implements Serializable {
    private static a a = new a();
    private static Object b = new Object();
    private static final long serialVersionUID = 1L;
    @com.startapp.common.c.f(a=true)
    private AdInformationConfig AdInformation = AdInformationConfig.a();
    private String adInformationMetadataUpdateVersion = AdsConstants.h;

    public a() {
        this.a().g();
    }

    public static void a(Context context) {
        a a2 = e.a(context, "StartappAdInfoMetadata", a.class);
        a a3 = new a();
        if (a2 != null) {
            boolean bl = i.a(a2, a3);
            if (!a2.f() && bl) {
                f.a(context, d.k, "AdInformationMetaData", "", "");
            }
            a2.e();
            a = a2;
        } else {
            a = a3;
        }
        a.b().a().g();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, a a2) {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            a2.adInformationMetadataUpdateVersion = AdsConstants.h;
            a = a2;
            AdInformationConfig.a(a.b().AdInformation);
            a.b().a().g();
            e.a(context, "StartappAdInfoMetadata", (Serializable)a2);
            return;
        }
    }

    public static a b() {
        return a;
    }

    private void e() {
        this.AdInformation.k();
    }

    private boolean f() {
        return true ^ AdsConstants.h.equals((Object)this.adInformationMetadataUpdateVersion);
    }

    public AdInformationConfig a() {
        return this.AdInformation;
    }

    public String c() {
        return this.AdInformation.b();
    }

    public String d() {
        return this.AdInformation.c();
    }
}

