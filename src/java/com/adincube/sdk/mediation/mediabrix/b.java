/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.n.b
 *  com.adincube.sdk.mediation.v.a
 *  com.adincube.sdk.mediation.v.b
 *  com.mediabrix.android.api.IAdEventsListener
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
package com.adincube.sdk.mediation.mediabrix;

import com.adincube.sdk.util.ErrorReportingHelper;
import com.mediabrix.android.api.IAdEventsListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b
implements IAdEventsListener {
    private static b k;
    com.adincube.sdk.mediation.n.a a = null;
    com.adincube.sdk.mediation.v.a b = null;
    String c = null;
    String d = null;
    com.adincube.sdk.mediation.a e = null;
    com.adincube.sdk.mediation.a f = null;
    com.adincube.sdk.mediation.n.b g = null;
    com.adincube.sdk.mediation.v.b h = null;
    b i = null;
    Set<a> j = new HashSet();

    private b() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b a() {
        if (k != null) return k;
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (k != null) return k;
            k = new b();
            // ** MonitorExit[var1] (shouldn't be in output)
            return k;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onAdClosed(String string) {
        try {
            Set<a> set;
            if (this.c != null && this.c.equals((Object)string) && this.g != null) {
                this.g.d((com.adincube.sdk.mediation.b)this.a);
            }
            if (this.d != null && this.d.equals((Object)string) && this.h != null) {
                this.h.d((com.adincube.sdk.mediation.b)this.b);
            }
            Set<a> set2 = set = this.j;
            // MONITORENTER : set2
        }
        catch (Throwable throwable) {
            new Object[1][0] = throwable;
            ErrorReportingHelper.report("MediaBrixEventListenerAdapter.onAdClosed", throwable);
            return;
        }
        Iterator iterator = this.j.iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : set2
                return;
            }
            ((a)iterator.next()).a();
        } while (true);
    }

    public static interface a {
        public void a();
    }

    public static interface b {
    }

}

