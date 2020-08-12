/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 */
package com.applovin.impl.sdk.b;

import java.util.HashSet;

public class d<T> {
    public static final d<String> a = new d<String>("com.applovin.sdk.impl.isFirstRun", String.class);
    public static final d<Integer> b = new d<Integer>("com.applovin.sdk.last_version_code", Integer.class);
    public static final d<String> c = new d<String>("com.applovin.sdk.device_test_group", String.class);
    public static final d<String> d = new d<String>("com.applovin.sdk.variables", String.class);
    public static final d<Boolean> e = new d<Boolean>("com.applovin.sdk.compliance.has_user_consent", Boolean.class);
    public static final d<Boolean> f = new d<Boolean>("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);
    public static final d<HashSet> g = new d<HashSet>("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);
    public static final d<String> h = new d<String>("com.applovin.sdk.stats", String.class);
    public static final d<String> i = new d<String>("com.applovin.sdk.errors", String.class);
    public static final d<HashSet> j = new d<HashSet>("com.applovin.sdk.task.stats", HashSet.class);
    public static final d<String> k = new d<String>("com.applovin.sdk.network_response_code_mapping", String.class);
    public static final d<String> l = new d<String>("com.applovin.sdk.zones", String.class);
    public static final d<HashSet> m = new d<HashSet>("com.applovin.sdk.ad.stats", HashSet.class);
    public static final d<Integer> n = new d<Integer>("com.applovin.sdk.last_video_position", Integer.class);
    public static final d<Boolean> o = new d<Boolean>("com.applovin.sdk.should_resume_video", Boolean.class);
    public static final d<String> p = new d<String>("com.applovin.sdk.mediation.signal_providers", String.class);
    public static final d<String> q = new d<String>("com.applovin.sdk.mediation.auto_init_adapters", String.class);
    public static final d<String> r = new d<String>("com.applovin.sdk.persisted_data", String.class);
    private final String s;
    private final Class<T> t;

    public d(String string2, Class<T> class_) {
        this.s = string2;
        this.t = class_;
    }

    public String a() {
        return this.s;
    }

    public Class<T> b() {
        return this.t;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key{name='");
        stringBuilder.append(this.s);
        stringBuilder.append('\'');
        stringBuilder.append("type='");
        stringBuilder.append(this.t);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

