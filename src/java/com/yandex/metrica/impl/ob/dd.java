/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import com.yandex.metrica.impl.ob.dk;
import com.yandex.metrica.impl.ob.dl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class dd {
    private static final dk c = new dk("UNDEFINED_");
    protected final String a;
    protected final SharedPreferences b;
    private final Map<String, Object> d = new HashMap();
    private boolean e = false;

    public dd(Context context, String string2) {
        this.a = string2;
        this.b = this.a(context);
        this.h();
    }

    protected SharedPreferences a(Context context) {
        return dl.a(context, this.f());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected <T extends dd> T a(String string2, Object object) {
        dd dd2 = this;
        synchronized (dd2) {
            if (object != null) {
                this.d.put((Object)string2, object);
            }
            return (T)this;
        }
    }

    protected abstract String f();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected <T extends dd> T h(String string2) {
        dd dd2 = this;
        synchronized (dd2) {
            this.d.put((Object)string2, (Object)this);
            return (T)this;
        }
    }

    protected void h() {
        new dk(c.a(), this.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected <T extends dd> T i() {
        dd dd2 = this;
        synchronized (dd2) {
            this.e = true;
            this.d.clear();
            return (T)this;
        }
    }

    protected String j() {
        return this.a;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void k() {
        block12 : {
            var13_1 = this;
            // MONITORENTER : var13_1
            var2_2 = this.b.edit();
            if (!this.e) break block12;
            var2_2.clear();
            var2_2.apply();
            ** GOTO lbl33
        }
        var3_3 = this.d.entrySet().iterator();
lbl11: // 2 sources:
        do {
            if (var3_3.hasNext()) {
                var4_4 = (Map.Entry)var3_3.next();
                var5_5 = (String)var4_4.getKey();
                var6_6 = var4_4.getValue();
                if (var6_6 == this) {
                    var2_2.remove(var5_5);
                    continue;
                }
                if (var6_6 instanceof String) {
                    var2_2.putString(var5_5, (String)var6_6);
                    continue;
                }
                if (var6_6 instanceof Long) {
                    var2_2.putLong(var5_5, ((Long)var6_6).longValue());
                    continue;
                }
                if (var6_6 instanceof Integer) {
                    var2_2.putInt(var5_5, ((Integer)var6_6).intValue());
                    continue;
                }
                if (var6_6 instanceof Boolean) {
                    var2_2.putBoolean(var5_5, ((Boolean)var6_6).booleanValue());
                    continue;
                }
                break;
            }
            var2_2.apply();
lbl33: // 2 sources:
            this.d.clear();
            this.e = false;
            // MONITOREXIT : var13_1
            return;
            break;
        } while (true);
        if (var6_6 != null) throw new UnsupportedOperationException();
        ** while (true)
    }
}

