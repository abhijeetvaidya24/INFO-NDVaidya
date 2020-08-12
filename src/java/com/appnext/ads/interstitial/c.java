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
package com.appnext.ads.interstitial;

import com.appnext.core.f;
import com.appnext.core.p;
import java.util.HashMap;

public final class c
extends p {
    private static c cn;
    private String aQ;
    private HashMap<String, String> aR;

    private c() {
        StringBuilder stringBuilder = new StringBuilder("https://cdn.appnext.com/tools/sdk/confign/interstitial/");
        stringBuilder.append(f.bg());
        stringBuilder.append("/interstitial_config.txt");
        this.aQ = stringBuilder.toString();
        this.aR = null;
    }

    public static c K() {
        Class<c> class_ = c.class;
        synchronized (c.class) {
            if (cn == null) {
                cn = new c();
            }
            c c2 = cn;
            // ** MonitorExit[var2] (shouldn't be in output)
            return c2;
        }
    }

    @Override
    public final void a(HashMap<String, String> hashMap) {
        this.aR = hashMap;
    }

    @Override
    protected final String getUrl() {
        return this.aQ;
    }

    @Override
    protected final HashMap<String, String> n() {
        return this.aR;
    }

    @Override
    protected final HashMap<String, String> o() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"creative", (Object)"managed");
        hashMap.put((Object)"auto_play", (Object)"true");
        hashMap.put((Object)"mute", (Object)"false");
        hashMap.put((Object)"pview", (Object)"true");
        hashMap.put((Object)"min_internet_connection", (Object)"2g");
        hashMap.put((Object)"min_internet_connection_video", (Object)"3g");
        hashMap.put((Object)"urlApp_protection", (Object)"false");
        hashMap.put((Object)"can_close", (Object)"true");
        hashMap.put((Object)"video_length", (Object)"15");
        hashMap.put((Object)"button_text", (Object)"");
        hashMap.put((Object)"button_color", (Object)"");
        hashMap.put((Object)"skip_title", (Object)"");
        hashMap.put((Object)"remove_poster_on_auto_play", (Object)"true");
        hashMap.put((Object)"banner_expiration_time", (Object)"0");
        hashMap.put((Object)"show_rating", (Object)"true");
        hashMap.put((Object)"show_desc", (Object)"true");
        hashMap.put((Object)"new_button_text", (Object)"Install");
        hashMap.put((Object)"existing_button_text", (Object)"Open");
        hashMap.put((Object)"postpone_vta_sec", (Object)"0");
        hashMap.put((Object)"postpone_impression_sec", (Object)"0");
        hashMap.put((Object)"resolve_timeout", (Object)"8");
        hashMap.put((Object)"ads_caching_time_minutes", (Object)"0");
        hashMap.put((Object)"gdpr", (Object)"false");
        hashMap.put((Object)"clickType_A", (Object)"0");
        hashMap.put((Object)"didPrivacy", (Object)"false");
        hashMap.put((Object)"S1", (Object)"[{\"id\":\"multi\",\"p\":50},{\"id\":\"single\",\"p\":50}]");
        hashMap.put((Object)"stp_flag", (Object)"false");
        return hashMap;
    }

    public final void setUrl(String string2) {
        this.aQ = string2;
    }
}

