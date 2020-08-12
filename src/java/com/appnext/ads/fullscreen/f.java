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
package com.appnext.ads.fullscreen;

import com.appnext.core.p;
import java.util.HashMap;

public final class f
extends p {
    private static f bt;
    private String aQ;
    private HashMap<String, String> aR;

    private f() {
        StringBuilder stringBuilder = new StringBuilder("https://cdn.appnext.com/tools/sdk/confign/rewarded/");
        stringBuilder.append(com.appnext.core.f.bg());
        stringBuilder.append("/rewarded_config.txt");
        this.aQ = stringBuilder.toString();
        this.aR = null;
    }

    public static f q() {
        Class<f> class_ = f.class;
        synchronized (f.class) {
            if (bt == null) {
                bt = new f();
            }
            f f2 = bt;
            // ** MonitorExit[var2] (shouldn't be in output)
            return f2;
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
        hashMap.put((Object)"can_close", (Object)"true");
        hashMap.put((Object)"show_close", (Object)"false");
        hashMap.put((Object)"video_length", (Object)"15");
        hashMap.put((Object)"mute", (Object)"false");
        hashMap.put((Object)"urlApp_protection", (Object)"false");
        hashMap.put((Object)"pview", (Object)"true");
        hashMap.put((Object)"min_internet_connection_video", (Object)"3g");
        hashMap.put((Object)"banner_expiration_time", (Object)"0");
        hashMap.put((Object)"default_mode", (Object)"normal");
        hashMap.put((Object)"postpone_vta_sec", (Object)"0");
        hashMap.put((Object)"postpone_impression_sec", (Object)"0");
        hashMap.put((Object)"resolve_timeout", (Object)"8");
        hashMap.put((Object)"num_saved_videos", (Object)"5");
        hashMap.put((Object)"caption_text_time", (Object)"3");
        hashMap.put((Object)"pre_title_string1", (Object)"Which Ad");
        hashMap.put((Object)"pre_title_string2", (Object)"Would you like to watch?");
        hashMap.put((Object)"pre_cta_string", (Object)"Play this ad");
        hashMap.put((Object)"ads_caching_time_minutes", (Object)"0");
        hashMap.put((Object)"gdpr", (Object)"false");
        hashMap.put((Object)"clickType_a", (Object)"0");
        hashMap.put((Object)"clickType_b", (Object)"0");
        hashMap.put((Object)"didPrivacy", (Object)"false");
        hashMap.put((Object)"stp_flag", (Object)"false");
        return hashMap;
    }

    public final void setUrl(String string2) {
        this.aQ = string2;
    }
}

