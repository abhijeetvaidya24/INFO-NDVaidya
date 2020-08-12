/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.yandex.metrica.impl.ob.cy
 *  com.yandex.metrica.impl.ob.cz
 *  java.lang.Object
 *  java.util.List
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Build;
import com.yandex.metrica.impl.ob.cv;
import com.yandex.metrica.impl.ob.cw;
import com.yandex.metrica.impl.ob.cy;
import com.yandex.metrica.impl.ob.cz;
import com.yandex.metrica.impl.utils.d;
import java.util.List;

public class cx {
    cv a(Context context) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new cy(context);
        }
        return new cz(context);
    }

    public List<cw> a(Context context, List<cw> list) {
        List<cw> list2 = this.a(context).a();
        if (d.a(list2, list)) {
            list2 = null;
        }
        return list2;
    }
}

