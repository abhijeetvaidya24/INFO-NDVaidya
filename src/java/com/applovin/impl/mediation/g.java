/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.applovin.impl.mediation.h
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  com.applovin.mediation.adapter.MaxAdapter
 *  com.applovin.mediation.adapters.MediationAdapterBase
 *  com.applovin.sdk.AppLovinSdk
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 */
package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class g {
    private final j a;
    private final p b;
    private final Object c = new Object();
    private final Map<String, Class<? extends MaxAdapter>> d = new HashMap();
    private final Set<String> e = new HashSet();

    g(j j2) {
        if (j2 != null) {
            this.a = j2;
            this.b = j2.u();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    private h a(e e2, Class<? extends MaxAdapter> class_) {
        block3 : {
            Constructor constructor = class_.getConstructor(new Class[]{AppLovinSdk.class});
            Object[] arrobject = new Object[]{this.a.K()};
            h h2 = new h(e2, (MaxAdapter)((MediationAdapterBase)constructor.newInstance(arrobject)), this.a);
            if (!h2.c()) break block3;
            return h2;
        }
        try {
            p p2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Adapter is disabled after initialization: ");
            stringBuilder.append((Object)e2);
            p2.e("MediationAdapterManager", stringBuilder.toString());
        }
        catch (Throwable throwable) {
            p p3 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to load adapter: ");
            stringBuilder.append((Object)e2);
            p3.c("MediationAdapterManager", stringBuilder.toString(), throwable);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Class<? extends MaxAdapter> a(String string) {
        try {
            p p2;
            String string2;
            Class class_ = Class.forName((String)string);
            if (class_ != null) {
                if (MaxAdapter.class.isAssignableFrom(class_)) {
                    return class_.asSubclass(MaxAdapter.class);
                }
                p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" error: not an instance of '");
                stringBuilder.append(MaxAdapter.class.getName());
                stringBuilder.append("'.");
                string2 = stringBuilder.toString();
            } else {
                p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No class found for ");
                stringBuilder.append(string);
                string2 = stringBuilder.toString();
            }
            p2.e("MediationAdapterManager", string2);
            return null;
        }
        catch (Throwable throwable) {
            p p3 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to load: ");
            stringBuilder.append(string);
            p3.c("MediationAdapterManager", stringBuilder.toString(), throwable);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    h a(e e2) {
        Object object;
        String string;
        String string2;
        block13 : {
            String string3;
            p p2;
            block12 : {
                block11 : {
                    if (e2 == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No adapter spec specified");
                        throw illegalArgumentException;
                    }
                    string = e2.u();
                    string2 = e2.t();
                    if (!TextUtils.isEmpty((CharSequence)string)) break block11;
                    p2 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No adapter name provided for ");
                    stringBuilder.append(string2);
                    stringBuilder.append(", not loading the adapter ");
                    string3 = stringBuilder.toString();
                    break block12;
                }
                if (!TextUtils.isEmpty((CharSequence)string2)) break block13;
                p2 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to find default classname for '");
                stringBuilder.append(string);
                stringBuilder.append("'");
                string3 = stringBuilder.toString();
            }
            p2.d("MediationAdapterManager", string3);
            return null;
        }
        Object object2 = object = this.c;
        synchronized (object2) {
            Class class_;
            if (this.e.contains((Object)string2)) {
                p p3 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Not attempting to load ");
                stringBuilder.append(string);
                stringBuilder.append(" due to prior errors");
                p3.a("MediationAdapterManager", stringBuilder.toString());
                return null;
            }
            if (this.d.containsKey((Object)string2)) {
                class_ = (Class)this.d.get((Object)string2);
            } else {
                class_ = this.a(string2);
                if (class_ == null) {
                    this.e.add((Object)string2);
                    p p4 = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to load adapter classname: ");
                    stringBuilder.append(string2);
                    p4.e("MediationAdapterManager", stringBuilder.toString());
                    return null;
                }
            }
            h h2 = this.a(e2, (Class<? extends MaxAdapter>)class_);
            if (h2 != null) {
                p p5 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Loaded ");
                stringBuilder.append(string);
                p5.a("MediationAdapterManager", stringBuilder.toString());
                this.d.put((Object)string2, (Object)class_);
                return h2;
            }
            p p6 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to load ");
            stringBuilder.append(string);
            p6.d("MediationAdapterManager", stringBuilder.toString());
            this.e.add((Object)string2);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    Collection<String> a() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            HashSet hashSet = new HashSet(this.d.size());
            Iterator iterator = this.d.values().iterator();
            do {
                if (!iterator.hasNext()) {
                    return Collections.unmodifiableSet((Set)hashSet);
                }
                hashSet.add((Object)((Class)iterator.next()).getName());
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    Collection<String> b() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            return Collections.unmodifiableSet(this.e);
        }
    }
}

