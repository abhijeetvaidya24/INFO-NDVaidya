/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.mediation.mediabrix.c$1
 *  com.mediabrix.android.api.IAdEventsListener
 *  com.mediabrix.android.api.MediabrixAPI
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayDeque
 *  java.util.Queue
 */
package com.adincube.sdk.mediation.mediabrix;

import android.content.Context;
import com.adincube.sdk.mediation.mediabrix.b;
import com.adincube.sdk.mediation.mediabrix.c;
import com.mediabrix.android.api.IAdEventsListener;
import com.mediabrix.android.api.MediabrixAPI;
import java.util.ArrayDeque;
import java.util.Queue;

public class c {
    private b a = null;
    private boolean b = false;
    private boolean c = false;
    private Queue<a> d = new ArrayDeque();
    private b.b e = new 1(this);

    public c(b b2) {
        this.a = b2;
        this.a.i = this.e;
    }

    public final void a(Context context, String string) {
        c c2 = this;
        synchronized (c2) {
            if (!this.c && !this.b) {
                this.c = true;
                MediabrixAPI.setDebug((boolean)false);
                MediabrixAPI.getInstance().initialize(context.getApplicationContext(), "https://mobile.mediabrix.com/v2/manifest/", string, (IAdEventsListener)this.a);
            }
            return;
        }
    }

    public final void a(a a2) {
        c c2 = this;
        synchronized (c2) {
            if (!this.b) {
                this.d.add((Object)a2);
                return;
            }
            a2.a();
            return;
        }
    }

    public final void b(a a2) {
        c c2 = this;
        synchronized (c2) {
            this.d.remove((Object)a2);
            return;
        }
    }

    public static interface a {
        public void a();
    }

}

