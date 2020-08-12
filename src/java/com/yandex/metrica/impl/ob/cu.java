/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.yandex.metrica.impl.ob.cr
 *  com.yandex.metrica.impl.ob.cs
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.co;
import com.yandex.metrica.impl.ob.cq;
import com.yandex.metrica.impl.ob.cr;
import com.yandex.metrica.impl.ob.cs;

public class cu {
    private final String a;

    public cu(String string2) {
        this.a = string2;
    }

    public cq a(String string2) {
        if (!TextUtils.isEmpty((CharSequence)this.a) && co.a().c()) {
            return new cs(string2);
        }
        return new cr(string2);
    }
}

