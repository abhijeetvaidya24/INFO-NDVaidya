/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  com.b.a.a.a.b.i
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.b.a.a.a.h;

import android.view.View;
import android.view.ViewParent;
import com.b.a.a.a.b.i;
import com.b.a.a.a.c.a;
import com.b.a.a.a.e.f;
import com.b.a.a.a.h.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class b {
    private final HashMap<View, String> a = new HashMap();
    private final HashMap<View, ArrayList<String>> b = new HashMap();
    private final HashSet<View> c = new HashSet();
    private final HashSet<String> d = new HashSet();
    private final HashSet<String> e = new HashSet();
    private boolean f;

    private void a(View view, i i2) {
        ArrayList arrayList = (ArrayList)this.b.get((Object)view);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.b.put((Object)view, (Object)arrayList);
        }
        arrayList.add((Object)i2.g());
    }

    private void a(i i2) {
        Iterator iterator = i2.d().iterator();
        while (iterator.hasNext()) {
            View view = (View)((com.b.a.a.a.f.a)((Object)iterator.next())).get();
            if (view == null) continue;
            this.a(view, i2);
        }
    }

    private boolean d(View view) {
        if (!view.hasWindowFocus()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            if (f.d(view)) {
                hashSet.add((Object)view);
                ViewParent viewParent = view.getParent();
                if (viewParent instanceof View) {
                    view = (View)viewParent;
                    continue;
                }
                view = null;
                continue;
            }
            return false;
        }
        this.c.addAll((Collection)hashSet);
        return true;
    }

    public String a(View view) {
        if (this.a.size() == 0) {
            return null;
        }
        String string2 = (String)this.a.get((Object)view);
        if (string2 != null) {
            this.a.remove((Object)view);
        }
        return string2;
    }

    public HashSet<String> a() {
        return this.d;
    }

    public ArrayList<String> b(View view) {
        if (this.b.size() == 0) {
            return null;
        }
        ArrayList arrayList = (ArrayList)this.b.get((Object)view);
        if (arrayList != null) {
            this.b.remove((Object)view);
            Collections.sort((List)arrayList);
        }
        return arrayList;
    }

    public HashSet<String> b() {
        return this.e;
    }

    public d c(View view) {
        if (this.c.contains((Object)view)) {
            return d.a;
        }
        if (this.f) {
            return d.b;
        }
        return d.c;
    }

    public void c() {
        a a2 = a.a();
        if (a2 != null) {
            for (i i2 : a2.c()) {
                View view = i2.h();
                if (!i2.i()) continue;
                if (view != null && this.d(view)) {
                    this.d.add((Object)i2.g());
                    this.a.put((Object)view, (Object)i2.g());
                    this.a(i2);
                    continue;
                }
                this.e.add((Object)i2.g());
            }
        }
    }

    public void d() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f = false;
    }

    public void e() {
        this.f = true;
    }
}

