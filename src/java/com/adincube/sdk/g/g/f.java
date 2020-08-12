/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.g.g.e
 *  io.presage.core.Core
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.g.g;

import android.content.Context;
import com.adincube.sdk.g.g.e;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.d;
import io.presage.core.Core;

public final class f
implements e {
    private boolean a = false;

    public static boolean a() {
        try {
            Core.class.getSimpleName();
            return true;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return false;
        }
    }

    public final void r() {
        Context context;
        if (!this.a && f.a() && (context = com.adincube.sdk.util.f.a()) != null) {
            try {
                Core.initialize((Context)context, (String)d.b());
            }
            catch (Throwable throwable) {
                ErrorReportingHelper.report("OguryDataManager.start", throwable);
            }
            this.a = true;
        }
    }
}

