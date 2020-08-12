/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  com.yandex.metrica.impl.ob.cd
 *  com.yandex.metrica.impl.ob.di
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.bp;
import com.yandex.metrica.impl.ob.bq;
import com.yandex.metrica.impl.ob.cd;
import com.yandex.metrica.impl.ob.di;
import com.yandex.metrica.impl.ob.dk;
import com.yandex.metrica.impl.ob.dl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class da {
    private Context a;

    public da(Context context) {
        this.a = context;
    }

    private static List<String> a(Map<String, ?> map, String string2) {
        ArrayList arrayList = new ArrayList();
        for (String string3 : map.keySet()) {
            if (!string3.startsWith(string2)) continue;
            arrayList.add((Object)string3.replace((CharSequence)string2, (CharSequence)""));
        }
        return arrayList;
    }

    private void a(bq bq2, String string2) {
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        long l2;
        String string8;
        cd cd2 = new cd(bq2, string2);
        di di2 = new di(this.a, string2);
        String string9 = di2.b(null);
        if (!TextUtils.isEmpty((CharSequence)string9)) {
            cd2.j(string9);
        }
        if (!TextUtils.isEmpty((CharSequence)(string3 = di2.a()))) {
            cd2.s(string3);
        }
        if (!TextUtils.isEmpty((CharSequence)(string8 = di2.d(null)))) {
            cd2.p(string8);
        }
        if (!TextUtils.isEmpty((CharSequence)(string7 = di2.f(null)))) {
            cd2.n(string7);
        }
        if (!TextUtils.isEmpty((CharSequence)(string4 = di2.g(null)))) {
            cd2.m(string4);
        }
        if (!TextUtils.isEmpty((CharSequence)(string5 = di2.c(null)))) {
            cd2.o(string5);
        }
        if ((l2 = di2.a(-1L)) != -1L) {
            cd2.b(l2);
        }
        if (!TextUtils.isEmpty((CharSequence)(string6 = di2.e(null)))) {
            cd2.l(string6);
        }
        cd2.h();
        di2.b();
    }

    public void a() {
        SharedPreferences sharedPreferences = dl.a(this.a, "_bidoptpreferences");
        if (sharedPreferences.getAll().size() > 0) {
            Map map;
            String string2 = sharedPreferences.getString(di.c.a(), null);
            di di2 = new di(this.a);
            if (!TextUtils.isEmpty((CharSequence)string2) && TextUtils.isEmpty((CharSequence)di2.a(null))) {
                di2.j(string2).k();
                sharedPreferences.edit().remove(di.c.a()).apply();
            }
            if ((map = sharedPreferences.getAll()).size() > 0) {
                for (String string3 : da.a(map, di.d.a())) {
                    String string4 = sharedPreferences.getString(new dk(di.d.a(), string3).b(), null);
                    di di3 = new di(this.a, string3);
                    if (TextUtils.isEmpty((CharSequence)string4) || !TextUtils.isEmpty((CharSequence)di3.b(null))) continue;
                    di3.i(string4).k();
                }
            }
            sharedPreferences.edit().clear().apply();
        }
    }

    public void b() {
        bq bq2 = bp.a(this.a).d();
        SharedPreferences sharedPreferences = dl.a(this.a, "_startupserviceinfopreferences");
        cd cd2 = new cd(bq2, null);
        String string2 = sharedPreferences.getString(di.c.a(), null);
        if (!TextUtils.isEmpty((CharSequence)string2) && TextUtils.isEmpty((CharSequence)cd2.a(null))) {
            cd2.k(string2).h();
            sharedPreferences.edit().remove(di.c.a()).apply();
        }
        cd cd3 = new cd(bq2, this.a.getPackageName());
        boolean bl2 = sharedPreferences.getBoolean(di.e.a(), false);
        if (bl2) {
            cd3.e(bl2).h();
        }
        cd cd4 = new cd(bq2, null);
        String string3 = sharedPreferences.getString(di.f.a(), null);
        if (!TextUtils.isEmpty((CharSequence)string3) && TextUtils.isEmpty((CharSequence)cd4.h(null))) {
            cd4.i(string3).h();
        }
        this.a(bq2, this.a.getPackageName());
        Iterator iterator = da.a(sharedPreferences.getAll(), di.d.a()).iterator();
        while (iterator.hasNext()) {
            this.a(bq2, (String)iterator.next());
        }
    }
}

