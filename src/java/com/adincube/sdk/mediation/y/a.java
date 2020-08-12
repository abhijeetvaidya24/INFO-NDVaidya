/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.mediation.y.a$1
 *  com.tapjoy.TJConnectListener
 *  com.tapjoy.TJPlacement
 *  com.tapjoy.Tapjoy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Hashtable
 *  java.util.Set
 */
package com.adincube.sdk.mediation.y;

import android.content.Context;
import com.adincube.sdk.mediation.y.a;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.Tapjoy;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public final class a {
    final Set<TJPlacement> a = new HashSet();
    boolean b = false;
    boolean c = false;
    private final TJConnectListener d = new 1(this);

    public final void a(Context context, String string) {
        if (!this.b && !this.c) {
            this.b = true;
            Tapjoy.connect((Context)context, (String)string, (Hashtable)new Hashtable(), (TJConnectListener)this.d);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(TJPlacement tJPlacement) {
        Set<TJPlacement> set;
        Set<TJPlacement> set2 = set = this.a;
        synchronized (set2) {
            if (!this.c) {
                this.a.add((Object)tJPlacement);
            } else {
                tJPlacement.requestContent();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(TJPlacement tJPlacement) {
        Set<TJPlacement> set;
        if (tJPlacement == null) {
            return;
        }
        Set<TJPlacement> set2 = set = this.a;
        synchronized (set2) {
            this.a.remove((Object)tJPlacement);
            return;
        }
    }
}

