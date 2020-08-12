/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 */
package com.appnext.banners;

import com.appnext.core.f;
import com.appnext.core.p;
import java.util.HashMap;

public final class d
extends p {
    private static d df;

    private d() {
    }

    public static d S() {
        Class<d> class_ = d.class;
        synchronized (d.class) {
            if (df == null) {
                df = new d();
            }
            d d2 = df;
            // ** MonitorExit[var2] (shouldn't be in output)
            return d2;
        }
    }

    @Override
    protected final String getUrl() {
        StringBuilder stringBuilder = new StringBuilder("https://cdn.appnext.com/tools/sdk/confign/banner/");
        stringBuilder.append(f.bg());
        stringBuilder.append("/banner_config.txt");
        return stringBuilder.toString();
    }

    @Override
    protected final HashMap<String, String> n() {
        return null;
    }

    @Override
    protected final HashMap<String, String> o() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"urlApp_protection", (Object)"true");
        hashMap.put((Object)"resolve_timeout", (Object)"8");
        hashMap.put((Object)"postpone_impression_sec", (Object)"0");
        hashMap.put((Object)"postpone_vta_sec", (Object)"0");
        hashMap.put((Object)"pview", (Object)"true");
        hashMap.put((Object)"banner_expiration_time", (Object)"0");
        hashMap.put((Object)"ads_caching_time_minutes", (Object)"0");
        hashMap.put((Object)"new_button_text", (Object)"Install");
        hashMap.put((Object)"existing_button_text", (Object)"Open");
        hashMap.put((Object)"gdpr", (Object)"false");
        hashMap.put((Object)"BANNER_cpiActiveFlow", (Object)"d");
        hashMap.put((Object)"BANNER_cpcActiveFlow", (Object)"b");
        hashMap.put((Object)"LARGE_BANNER_cpiActiveFlow", (Object)"d");
        hashMap.put((Object)"LARGE_BANNER_cpcActiveFlow", (Object)"b");
        hashMap.put((Object)"MEDIUM_RECTANGLE_cpiActiveFlow", (Object)"d");
        hashMap.put((Object)"MEDIUM_RECTANGLE_cpcActiveFlow", (Object)"b");
        hashMap.put((Object)"didPrivacy", (Object)"false");
        hashMap.put((Object)"impOne", (Object)"true");
        hashMap.put((Object)"_arFlag", (Object)"true");
        hashMap.put((Object)"banner_ar", (Object)"10");
        hashMap.put((Object)"large_banner_ar", (Object)"10");
        hashMap.put((Object)"medium_rectangle_ar", (Object)"10");
        hashMap.put((Object)"stp_flag", (Object)"false");
        return hashMap;
    }
}

