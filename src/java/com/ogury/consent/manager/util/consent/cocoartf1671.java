/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  co.ogury.crashreport.CrashReport
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.ogury.consent.manager.util.consent;

import android.util.Log;
import co.ogury.crashreport.CrashReport;
import com.ogury.consent.manager.ConsentListener;
import com.ogury.consent.manager.ConsentManager;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.ConsentException;

public final class cocoartf1671
implements ConsentListener {
    private final ConsentListener a;

    public cocoartf1671(ConsentListener consentListener) {
        tx6480.b(consentListener, "delegate");
        this.a = consentListener;
    }

    @Override
    public final void onComplete(ConsentManager.Answer answer) {
        tx6480.b((Object)answer, "answer");
        try {
            this.a.onComplete(answer);
            return;
        }
        catch (Exception exception) {
            CrashReport.logException((Exception)exception);
            Log.d((String)"consentCallback", (String)"callback catch exception");
            return;
        }
    }

    @Override
    public final void onError(ConsentException consentException) {
        tx6480.b((Object)consentException, "exception");
        try {
            this.a.onError(consentException);
            return;
        }
        catch (Exception exception) {
            CrashReport.logException((Exception)exception);
            Log.d((String)"consentCallback", (String)"callback catch exception");
            return;
        }
    }
}

