/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adincube.sdk.h.b
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.n.a
 *  com.vidcoin.sdkandroid.VidCoin
 *  com.vidcoin.sdkandroid.core.VidCoinBase
 *  com.vidcoin.sdkandroid.core.VidCoinBase$VCUserGender
 *  com.vidcoin.sdkandroid.core.VidCoinBase$VCUserInfos
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.ab;

import android.app.Activity;
import android.content.Context;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.ab.a;
import com.adincube.sdk.mediation.ab.b;
import com.adincube.sdk.mediation.c;
import com.adincube.sdk.mediation.e;
import com.adincube.sdk.mediation.i;
import com.vidcoin.sdkandroid.VidCoin;
import com.vidcoin.sdkandroid.core.VidCoinBase;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
implements i {
    b a = null;

    public a() {
        VidCoin.class.getSimpleName();
    }

    @Override
    public final com.adincube.sdk.mediation.i.a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return null;
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        return null;
    }

    @Override
    public final void a(Context context) {
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new b(jSONObject);
    }

    @Override
    public final void a(g g2) {
        HashMap hashMap;
        block1 : {
            String string;
            block4 : {
                VidCoinBase.VCUserGender vCUserGender;
                block5 : {
                    block2 : {
                        block3 : {
                            hashMap = new HashMap();
                            if (g2.d != null) {
                                hashMap.put((Object)VidCoinBase.VCUserInfos.VC_USER_BIRTH_YEAR, (Object)Integer.toString((int)g2.b()));
                            }
                            if (g2.a == null) break block1;
                            int n2 = 1.a[g2.a.ordinal()];
                            if (n2 == 1) break block2;
                            if (n2 == 2) break block3;
                            string = null;
                            break block4;
                        }
                        vCUserGender = VidCoinBase.VCUserGender.VC_USER_GENDER_FEMALE;
                        break block5;
                    }
                    vCUserGender = VidCoinBase.VCUserGender.VC_USER_GENDER_MALE;
                }
                string = vCUserGender.toString();
            }
            hashMap.put((Object)VidCoinBase.VCUserInfos.VC_USER_GENDER, (Object)string);
        }
        VidCoin.getInstance().setUserInfos((Map)hashMap);
    }

    @Override
    public final boolean a() {
        return this.a != null;
    }

    @Override
    public final c b() {
        return null;
    }

    @Override
    public final String b(Context context) {
        return "1.3.1";
    }

    @Override
    public final e c() {
        return this.a;
    }

    @Override
    public final boolean d() {
        return false;
    }

    @Override
    public final boolean e() {
        return false;
    }

    @Override
    public final String f() {
        return "VidCoin";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return null;
    }
}

