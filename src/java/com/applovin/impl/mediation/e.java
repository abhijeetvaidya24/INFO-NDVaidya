/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  org.json.JSONObject
 */
package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class e
implements MaxAd {
    private final JSONObject a;
    private final j b;
    private final Object c = new Object();
    private boolean d;
    private boolean e;
    private a f;
    private a g;
    private a h;

    public e(JSONObject jSONObject, j j2) {
        this.a = jSONObject;
        this.b = j2;
    }

    public a a() {
        return this.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public a a(Activity activity) {
        boolean bl;
        a a2;
        Object object;
        Object object2 = object = this.c;
        // MONITORENTER : object2
        if (this.d) throw new IllegalStateException("Ad with backup was destroyed");
        this.d = bl = true;
        if (this.f != null) {
            a2 = this.f;
            bl = false;
        } else {
            if (this.g == null) throw new IllegalStateException("Ad with backup does not have either primary or backup ad to resolve");
            a2 = this.g;
        }
        // MONITOREXIT : object2
        if (bl) {
            this.b.a(activity).a(a2);
        }
        this.h = a2;
        return a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(a a2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (!this.e) {
                this.f = a2;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<a> b() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            this.e = true;
            ArrayList arrayList = new ArrayList(2);
            if (this.f != null) {
                arrayList.add((Object)this.f);
                this.f = null;
            }
            if (this.g != null) {
                arrayList.add((Object)this.g);
                this.g = null;
            }
            return arrayList;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(a a2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (!this.e) {
                this.g = a2;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean b(Activity activity) {
        Object object;
        Object object2 = object = this.c;
        // MONITORENTER : object2
        a a2 = this.g;
        a a3 = null;
        if (a2 != null) {
            this.f = this.g;
            this.g = null;
            a3 = this.f;
        }
        // MONITOREXIT : object2
        if (a3 != null) {
            this.b.a(activity).maybeScheduleBackupAdPromotedToPrimaryPostback(a3);
        }
        if (a3 == null) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.e) return true;
            if (!this.d) return false;
            return true;
        }
    }

    public long d() {
        return g.a(this.a, "ad_expiration_ms", this.b.a(com.applovin.impl.sdk.b.a.L), this.b);
    }

    @Override
    public String getAdUnitId() {
        return g.a(this.a, "ad_unit_id", null, this.b);
    }

    @Override
    public MaxAdFormat getFormat() {
        return m.b(g.a(this.a, "ad_format", null, this.b));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean isReady() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            return this.f != null || this.g != null;
            {
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[MediatedAdWithBackup, adUnitId=");
        stringBuilder.append(this.getAdUnitId());
        stringBuilder.append(", hasAd=");
        a a2 = this.f;
        boolean bl = true;
        boolean bl2 = a2 != null;
        stringBuilder.append(bl2);
        stringBuilder.append(", hasBackup=");
        if (this.g == null) {
            bl = false;
        }
        stringBuilder.append(bl);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

