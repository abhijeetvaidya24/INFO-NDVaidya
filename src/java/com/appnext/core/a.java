/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.appnext.core;

import android.os.Handler;
import com.appnext.core.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class a {
    private ArrayList<?> ads = null;
    private Long fK = 0L;
    private ArrayList<d.a> fL = new ArrayList();
    private String fM = "";
    private String placementID;
    private int state = 0;

    public final String A() {
        return this.fM;
    }

    public final void O(String string2) {
        this.fM = string2;
    }

    public final void P(final String string2) {
        a a2 = this;
        synchronized (a2) {
            new Handler().post(new Runnable(){

                public final void run() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll((Collection)a.this.fL);
                    for (d.a a2 : arrayList) {
                        if (a2 == null) continue;
                        a2.error(string2);
                    }
                    a.this.fL.clear();
                }
            });
            return;
        }
    }

    public final void a(a a2) {
        ArrayList<d.a> arrayList;
        if (a2 != null && (arrayList = a2.fL) != null) {
            this.fL.addAll(arrayList);
        }
    }

    public final void a(d.a a2) {
        if (a2 != null) {
            this.fL.add((Object)a2);
        }
    }

    public final void a(Long l2) {
        this.fK = l2;
    }

    public final void a(ArrayList<?> arrayList, boolean bl) {
        this.ads = arrayList;
        if (bl) {
            this.fK = System.currentTimeMillis();
        }
    }

    public final Long aS() {
        return this.fK;
    }

    public final void b(d.a a2) {
        if (a2 != null) {
            this.fL.remove((Object)a2);
        }
    }

    public final void d(ArrayList<?> arrayList) {
        this.a(arrayList, true);
    }

    public final void e(final ArrayList<?> arrayList) {
        a a2 = this;
        synchronized (a2) {
            new Handler().post(new Runnable(){

                public final void run() {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll((Collection)a.this.fL);
                    for (d.a a2 : arrayList2) {
                        if (a2 == null) continue;
                        a2.a(arrayList);
                    }
                    a.this.fL.clear();
                }
            });
            return;
        }
    }

    public final ArrayList<?> getAds() {
        if (this.ads == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.ads.iterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return arrayList;
    }

    public final String getPlacementID() {
        return this.placementID;
    }

    public final int getState() {
        return this.state;
    }

    public final void setPlacementID(String string2) {
        this.placementID = string2;
    }

    public final void setState(int n2) {
        this.state = n2;
    }

}

