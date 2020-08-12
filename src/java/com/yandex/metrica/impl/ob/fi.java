/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.yandex.metrica.impl.ob.fo
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.os.Build;
import com.yandex.metrica.impl.ob.fo;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

class fi
extends fo {
    private Map<String, String> a;

    public fi(String string, Map<String, String> map) {
        super(0, string, null);
        this.a = map;
    }

    public String a() {
        String string = super.a();
        Map<String, String> map = this.a;
        Uri.Builder builder = Uri.parse((String)string).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue());
        }
        return builder.build().toString();
    }

    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{2, 12, 20};
        String string = String.format((Locale)locale, (String)"%s.%s.%s", (Object[])arrobject);
        String string2 = Build.DEVICE;
        String string3 = Build.VERSION.RELEASE;
        hashMap.put((Object)"User-agent", (Object)String.format((Locale)Locale.US, (String)"com.yandex.mobile.pinning/%s (%s; Android %s)", (Object[])new Object[]{string, string2, string3}));
        return hashMap;
    }
}

