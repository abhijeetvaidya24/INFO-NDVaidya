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

import com.appnext.core.f;
import com.appnext.core.p;
import java.util.HashMap;

public final class c
extends p {
    private static c aP;
    private String aQ;
    private HashMap<String, String> aR;

    private c() {
        StringBuilder stringBuilder = new StringBuilder("https://cdn.appnext.com/tools/sdk/confign/fullscreen/");
        stringBuilder.append(f.bg());
        stringBuilder.append("/fullscreen_config.txt");
        this.aQ = stringBuilder.toString();
        this.aR = null;
    }

    public static c m() {
        Class<c> class_ = c.class;
        synchronized (c.class) {
            if (aP == null) {
                aP = new c();
            }
            c c2 = aP;
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
        hashMap.put((Object)"can_close", (Object)"true");
        hashMap.put((Object)"show_close", (Object)"true");
        hashMap.put((Object)"show_close_time", (Object)"2000");
        hashMap.put((Object)"video_length", (Object)"15");
        hashMap.put((Object)"mute", (Object)"false");
        hashMap.put((Object)"urlApp_protection", (Object)"false");
        hashMap.put((Object)"pview", (Object)"true");
        hashMap.put((Object)"min_internet_connection_video", (Object)"3g");
        hashMap.put((Object)"banner_expiration_time", (Object)"0");
        hashMap.put((Object)"postpone_vta_sec", (Object)"0");
        hashMap.put((Object)"postpone_impression_sec", (Object)"0");
        hashMap.put((Object)"resolve_timeout", (Object)"8");
        hashMap.put((Object)"num_saved_videos", (Object)"5");
        hashMap.put((Object)"caption_text_time", (Object)"3");
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

