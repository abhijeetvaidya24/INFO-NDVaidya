/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.cert.X509Certificate
 *  java.util.Set
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.fb;
import com.yandex.metrica.impl.ob.fg;
import java.security.cert.X509Certificate;
import java.util.Set;

class ek {
    private fb a;

    public ek(fb fb2) {
        this.a = fb2;
    }

    public boolean a(X509Certificate[] arrx509Certificate) {
        Set<String> set = this.a.b();
        if (set.isEmpty()) {
            return false;
        }
        int n2 = arrx509Certificate.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!set.contains((Object)fg.a(arrx509Certificate[i2]))) continue;
            return true;
        }
        return false;
    }
}

