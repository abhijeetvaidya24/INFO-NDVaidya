/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  com.mopub.common.MoPub
 *  com.mopub.common.privacy.PersonalInfoManager
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.r;

import android.content.Context;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.aa.c;
import com.mopub.common.MoPub;
import com.mopub.common.privacy.PersonalInfoManager;

public final class m
implements c {
    @Override
    public final void a(Context context, d d2) {
        PersonalInfoManager personalInfoManager = MoPub.getPersonalInformationManager();
        if (personalInfoManager == null) {
            return;
        }
        if (d2 == d.c) {
            personalInfoManager.grantConsent();
            return;
        }
        if (d2 == d.d) {
            personalInfoManager.revokeConsent();
        }
    }

    @Override
    public final void a(Context context, String string) {
    }

    @Override
    public final boolean a() {
        return false;
    }

    @Override
    public final String b() {
        return "mopub-inc";
    }
}

