/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.ad;

import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
    private final j a;
    private final p b;
    private LinkedHashSet<d> c;
    private final Object d = new Object();
    private volatile boolean e;

    public e(j j2) {
        this.a = j2;
        this.b = j2.u();
        this.c = this.c();
    }

    private LinkedHashSet<d> b(JSONArray jSONArray) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject = g.a(jSONArray, i2, null, this.a);
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading zone: ");
            stringBuilder.append(g.a(jSONObject, this.a));
            stringBuilder.append("...");
            p2.a("AdZoneManager", stringBuilder.toString());
            linkedHashSet.add((Object)d.a(g.a(jSONObject, "id", null, this.a), jSONObject, this.a));
        }
        return linkedHashSet;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private LinkedHashSet<d> c() {
        Throwable throwable2222;
        LinkedHashSet<d> linkedHashSet;
        block8 : {
            linkedHashSet = new LinkedHashSet<d>();
            String string2 = this.a.a(com.applovin.impl.sdk.b.d.l);
            if (!com.applovin.impl.sdk.e.j.b(string2)) break block8;
            JSONArray jSONArray = new JSONArray(string2);
            if (jSONArray.length() > 0) {
                linkedHashSet = this.b(jSONArray);
                break block8;
            }
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to inflate json string: ");
            stringBuilder.append(string2);
            p2.a("AdZoneManager", stringBuilder.toString());
        }
        if (linkedHashSet.isEmpty()) return linkedHashSet;
        p p3 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Retrieved persisted zones: ");
        stringBuilder.append(linkedHashSet);
        p3.a("AdZoneManager", stringBuilder.toString());
        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            ((d)iterator.next()).a(this.a);
        }
        return linkedHashSet;
        {
            catch (Throwable throwable2222) {
            }
            catch (Throwable throwable3) {}
            {
                this.b.b("AdZoneManager", "Encountered error retrieving persisted zones", throwable3);
            }
            if (linkedHashSet.isEmpty()) return linkedHashSet;
            p p4 = this.b;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Retrieved persisted zones: ");
            stringBuilder2.append(linkedHashSet);
            p4.a("AdZoneManager", stringBuilder2.toString());
            Iterator iterator2 = linkedHashSet.iterator();
            while (iterator2.hasNext()) {
                ((d)iterator2.next()).a(this.a);
            }
            return linkedHashSet;
        }
        if (linkedHashSet.isEmpty()) throw throwable2222;
        p p5 = this.b;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Retrieved persisted zones: ");
        stringBuilder3.append((Object)linkedHashSet);
        p5.a("AdZoneManager", stringBuilder3.toString());
        Iterator iterator3 = linkedHashSet.iterator();
        while (iterator3.hasNext()) {
            ((d)iterator3.next()).a(this.a);
        }
        throw throwable2222;
    }

    private void c(JSONArray jSONArray) {
        if (this.a.a(b.eb).booleanValue()) {
            this.b.a("AdZoneManager", "Persisting zones...");
            this.a.a(com.applovin.impl.sdk.b.d.l, jSONArray.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public LinkedHashSet<d> a(JSONArray jSONArray) {
        Object object;
        if (jSONArray == null) {
            return new LinkedHashSet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(jSONArray.length());
        Object object2 = object = this.d;
        // MONITORENTER : object2
        boolean bl = this.e;
        LinkedHashSet<d> linkedHashSet2 = null;
        if (!bl) {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found ");
            stringBuilder.append(jSONArray.length());
            stringBuilder.append(" zone(s)...");
            p2.a("AdZoneManager", stringBuilder.toString());
            linkedHashSet2 = this.b(jSONArray);
            linkedHashSet = new LinkedHashSet(linkedHashSet2);
            linkedHashSet.removeAll(this.c);
            this.c = linkedHashSet2;
            this.e = true;
        }
        // MONITOREXIT : object2
        if (linkedHashSet2 == null) return linkedHashSet;
        this.c(jSONArray);
        this.b.a("AdZoneManager", "Finished loading zones");
        return linkedHashSet;
    }

    public boolean a() {
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(d d2) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return this.c.contains((Object)d2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LinkedHashSet<d> b() {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return this.c;
        }
    }
}

