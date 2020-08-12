/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.TimeUnit
 */
package com.applovin.impl.sdk.b;

import com.applovin.impl.sdk.b.b;
import java.util.concurrent.TimeUnit;

public class a<T>
extends b<T> {
    public static final b<Boolean> A;
    public static final b<Long> B;
    public static final b<Long> C;
    public static final b<Long> D;
    public static final b<Boolean> E;
    public static final b<Boolean> F;
    public static final b<Boolean> G;
    public static final b<Long> H;
    public static final b<Long> I;
    public static final b<Boolean> J;
    public static final b<Boolean> K;
    public static final b<Long> L;
    public static final b<Long> M;
    public static final b<Boolean> N;
    public static final b<Boolean> O;
    public static final b<Long> P;
    public static final b<String> a;
    public static final b<String> b;
    public static final b<Boolean> c;
    public static final b<Long> d;
    public static final b<Long> e;
    public static final b<Boolean> f;
    public static final b<Boolean> g;
    public static final b<String> h;
    public static final b<Boolean> i;
    public static final b<Integer> j;
    public static final b<Boolean> k;
    public static final b<Long> l;
    public static final b<Integer> m;
    public static final b<Integer> n;
    public static final b<Integer> o;
    public static final b<Long> p;
    public static final b<Integer> q;
    public static final b<Boolean> r;
    public static final b<Long> s;
    public static final b<Integer> t;
    public static final b<Integer> u;
    public static final b<Long> v;
    public static final b<Long> w;
    public static final b<String> x;
    public static final b<Long> y;
    public static final b<Boolean> z;

    static {
        a = a.a("mediation_endpoint", "https://ms.applovin.com/");
        b = a.a("mediation_backup_endpoint", "https://ms.applvn.com/");
        Boolean bl = true;
        c = a.a("immediate_mediation_ad_fetch_after_signal_collection", bl);
        d = a.a("fetch_next_ad_retry_delay_ms", TimeUnit.SECONDS.toMillis(2L));
        e = a.a("fetch_next_ad_timeout_ms", TimeUnit.SECONDS.toMillis(5L));
        f = a.a("pass_extra_parameters", bl);
        Boolean bl2 = false;
        g = a.a("process_ad_waterfall_immediately", bl2);
        h = a.a("postback_macros", "{\"{MCODE}\":\"mcode\",\"{BCODE}\":\"bcode\",\"{ICODE}\":\"icode\",\"{SCODE}\":\"scode\"}");
        i = a.a("persistent_mediated_postbacks", bl2);
        Integer n2 = 3;
        j = a.a("max_signal_collector_threads", n2);
        k = a.a("signal_collector_clear_threads", bl2);
        l = a.a("max_signal_provider_latency_ms", 30000L);
        Integer n3 = 20;
        m = a.a("max_adapter_version_length", n3);
        n = a.a("max_adapter_sdk_version_length", n3);
        o = a.a("max_adapter_signal_length", 5120);
        Long l2 = -1L;
        p = a.a("init_completion_delay_ms", l2);
        q = a.a("max_auto_init_adapters_threads", n2);
        r = a.a("run_adapter_operations_on_ui_thread", bl);
        s = a.a("default_adapter_timeout_ms", TimeUnit.SECONDS.toMillis(10L));
        t = a.a("default_ad_view_width", -1);
        u = a.a("default_ad_view_height", 50);
        v = a.a("ad_refresh_ms", TimeUnit.SECONDS.toMillis(30L));
        w = a.a("ad_load_failure_refresh_ms", TimeUnit.SECONDS.toMillis(30L));
        x = a.a("ad_load_failure_refresh_ignore_error_codes", "204");
        y = a.a("refresh_ad_on_app_resume_elapsed_threshold_ms", 0L);
        z = a.a("refresh_ad_view_timer_responds_to_background", bl);
        A = a.a("refresh_ad_view_timer_responds_to_store_kit", bl);
        Long l3 = 150L;
        B = a.a("ad_view_fade_in_animation_ms", l3);
        C = a.a("ad_view_fade_out_animation_ms", l3);
        D = a.a("fullscreen_display_delay_ms", 600L);
        E = a.a("is_testing", bl2);
        F = a.a("process_next_waterfall_ad_on_mediation_main_queue", bl2);
        G = a.a("use_mediated_sdk_queues", bl);
        H = a.a("ad_view_refresh_precache_request_viewability_undesired_flags", 118L);
        I = a.a("ad_view_refresh_precache_request_delay_ms", TimeUnit.SECONDS.toMillis(2L));
        J = a.a("ad_view_block_publisher_load_if_refresh_scheduled", bl);
        K = a.a("fullscreen_ads_block_publisher_load_if_another_showing", bl);
        L = a.a("ad_expiration_ms", TimeUnit.HOURS.toMillis(4L));
        M = a.a("ad_hidden_timeout_ms", l2);
        N = a.a("fdq", bl2);
        O = a.a("schedule_ad_hidden_on_ad_dismiss", bl2);
        P = a.a("ad_hidden_on_ad_dismiss_callback_delay_ms", TimeUnit.SECONDS.toMillis(1L));
    }
}

