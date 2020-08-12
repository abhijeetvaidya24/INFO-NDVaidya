/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 *  java.util.Set
 */
package com.applovin.impl.sdk.c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class g {
    private static final Set<String> B = new HashSet(32);
    private static final Set<g> C = new HashSet(16);
    public static final g a = g.a("ad_req");
    public static final g b = g.a("ad_imp");
    public static final g c = g.a("ad_session_start");
    public static final g d = g.a("ad_imp_session");
    public static final g e = g.a("cached_files_expired");
    public static final g f = g.a("cache_drop_count");
    public static final g g = g.a("sdk_reset_state_count", true);
    public static final g h = g.a("ad_response_process_failures", true);
    public static final g i = g.a("response_process_failures", true);
    public static final g j = g.a("incent_shown_without_prompt_count", true);
    public static final g k = g.a("incent_prompt_accepted_count", true);
    public static final g l = g.a("incent_prompt_rejected_count", true);
    public static final g m = g.a("incent_failed_to_display_count", true);
    public static final g n = g.a("app_paused_and_resumed");
    public static final g o = g.a("cached_video_removed_count", true);
    public static final g p = g.a("med_ad_req");
    public static final g q = g.a("med_ad_response_process_failures", true);
    public static final g r = g.a("med_waterfall_ad_no_fill", true);
    public static final g s = g.a("med_waterfall_ad_adapter_load_failed", true);
    public static final g t = g.a("med_waterfall_ad_invalid_response", true);
    public static final g u = g.a("initial_load_count_inter", true);
    public static final g v = g.a("initial_load_count_rewarded", true);
    public static final g w = g.a("initial_load_count_banner", true);
    public static final g x = g.a("repeated_load_count_inter", true);
    public static final g y = g.a("repeated_load_count_rewarded", true);
    public static final g z = g.a("repeated_load_count_banner", true);
    private final String A;

    static {
        g.a("fullscreen_ad_nil_vc_count");
    }

    private g(String string2) {
        this.A = string2;
    }

    private static g a(String string2) {
        return g.a(string2, false);
    }

    private static g a(String string2, boolean bl) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (!B.contains((Object)string2)) {
                B.add((Object)string2);
                g g2 = new g(string2);
                if (bl) {
                    C.add((Object)g2);
                }
                return g2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key has already been used: ");
            stringBuilder.append(string2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("No key name specified");
    }

    public static Set<g> b() {
        return C;
    }

    public String a() {
        return this.A;
    }
}

