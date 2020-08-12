/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 *  com.yandex.metrica.CounterConfiguration
 *  com.yandex.metrica.impl.bi
 *  com.yandex.metrica.impl.bk
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.bk;

public class r {
    private boolean a;
    private final String b;
    private final String c;

    public r(String string2, String string3, boolean bl2) {
        this.a = bl2;
        this.b = string2;
        this.c = string3;
    }

    public static r a(Context context, CounterConfiguration counterConfiguration, Integer n2, String string2) {
        String string3 = counterConfiguration.f();
        if (bi.a((String)string3)) {
            if (n2 != null) {
                int n3 = n2;
                String[] arrstring = context.getPackageManager().getPackagesForUid(n3);
                string2 = arrstring != null && arrstring.length > 0 ? arrstring[0] : null;
            }
        } else {
            string2 = string3;
        }
        if (!bi.a((String)string2)) {
            return new r(string2, bk.a((Context)context, (CounterConfiguration)counterConfiguration, (String)string2), counterConfiguration.C());
        }
        return null;
    }

    public static r a(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            return new r(string2, null, true);
        }
        return null;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return !this.a && !bk.b((String)this.c);
    }

    public boolean d() {
        return this.a;
    }

    public String toString() {
        String string2 = this.b;
        if (!this.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("_");
            stringBuilder.append(this.c);
            string2 = stringBuilder.toString();
        }
        return string2;
    }
}

