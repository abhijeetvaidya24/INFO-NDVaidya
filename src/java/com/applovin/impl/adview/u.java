/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebSettings
 *  android.webkit.WebSettings$PluginState
 *  com.applovin.impl.sdk.e.g
 *  com.applovin.impl.sdk.e.j
 *  com.applovin.impl.sdk.j
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.applovin.impl.adview;

import android.webkit.WebSettings;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.j;
import org.json.JSONObject;

public final class u {
    private com.applovin.impl.sdk.j a;
    private JSONObject b;

    public u(JSONObject jSONObject, com.applovin.impl.sdk.j j2) {
        this.a = j2;
        this.b = jSONObject;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Integer a() {
        int n2;
        String string = g.a((JSONObject)this.b, (String)"mixed_content_mode", null, (com.applovin.impl.sdk.j)this.a);
        if (!j.b((String)string)) return null;
        if ("always_allow".equalsIgnoreCase(string)) {
            n2 = 0;
            do {
                return n2;
                break;
            } while (true);
        }
        if ("never_allow".equalsIgnoreCase(string)) {
            n2 = 1;
            return n2;
        }
        if (!"compatibility_mode".equalsIgnoreCase(string)) return null;
        n2 = 2;
        return n2;
    }

    public WebSettings.PluginState b() {
        String string = g.a((JSONObject)this.b, (String)"plugin_state", null, (com.applovin.impl.sdk.j)this.a);
        if (j.b((String)string)) {
            if ("on".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON_DEMAND;
            }
            if ("off".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.OFF;
            }
        }
        return null;
    }

    public Boolean c() {
        return g.a((JSONObject)this.b, (String)"allow_file_access", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean d() {
        return g.a((JSONObject)this.b, (String)"load_with_overview_mode", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean e() {
        return g.a((JSONObject)this.b, (String)"use_wide_view_port", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean f() {
        return g.a((JSONObject)this.b, (String)"allow_content_access", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean g() {
        return g.a((JSONObject)this.b, (String)"use_built_in_zoom_controls", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean h() {
        return g.a((JSONObject)this.b, (String)"display_zoom_controls", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean i() {
        return g.a((JSONObject)this.b, (String)"save_form_data", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean j() {
        return g.a((JSONObject)this.b, (String)"geolocation_enabled", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean k() {
        return g.a((JSONObject)this.b, (String)"need_initial_focus", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean l() {
        return g.a((JSONObject)this.b, (String)"allow_file_access_from_file_urls", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean m() {
        return g.a((JSONObject)this.b, (String)"allow_universal_access_from_file_urls", null, (com.applovin.impl.sdk.j)this.a);
    }

    public Boolean n() {
        return g.a((JSONObject)this.b, (String)"offscreen_pre_raster", null, (com.applovin.impl.sdk.j)this.a);
    }
}

