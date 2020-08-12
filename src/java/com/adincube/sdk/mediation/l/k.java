/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  com.flurry.android.FlurryAgent
 *  java.lang.Object
 */
package com.adincube.sdk.mediation.l;

import android.app.Application;
import android.content.Context;
import com.flurry.android.FlurryAgent;

public final class k {
    private Context a = null;
    private int b = 0;

    public final void a() {
        k k2 = this;
        synchronized (k2) {
            block5 : {
                int n2 = this.b;
                if (n2 != 0) break block5;
                return;
            }
            this.b = -1 + this.b;
            if (this.b == 0) {
                FlurryAgent.onEndSession((Context)this.a);
                this.a = null;
            }
            return;
        }
    }

    public final void a(Context context) {
        k k2 = this;
        synchronized (k2) {
            block5 : {
                boolean bl;
                if (FlurryAgent.getSessionId() != null || !(bl = context instanceof Application)) break block5;
                return;
            }
            if (this.b == 0) {
                this.a = context;
                FlurryAgent.onStartSession((Context)context);
            }
            this.b = 1 + this.b;
            return;
        }
    }
}

