/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.AdColonyUserMetadata;
import com.adcolony.sdk.a;
import com.adcolony.sdk.au;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.l;
import com.adcolony.sdk.n;
import com.adcolony.sdk.w;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyAppOptions {
    String a = "";
    String[] b;
    JSONArray c = w.b();
    JSONObject d = w.a();
    AdColonyUserMetadata e;

    public AdColonyAppOptions() {
        l l2;
        this.setOriginStore("google");
        if (a.b() && (l2 = a.a()).e()) {
            this.a(l2.d().a);
            this.a(l2.d().b);
        }
    }

    AdColonyAppOptions a(String string) {
        if (string == null) {
            return this;
        }
        this.a = string;
        w.a(this.d, "app_id", string);
        return this;
    }

    /* varargs */ AdColonyAppOptions a(String ... arrstring) {
        if (arrstring == null) {
            return this;
        }
        this.b = arrstring;
        this.c = w.b();
        for (int i2 = 0; i2 < arrstring.length; ++i2) {
            w.a(this.c, arrstring[i2]);
        }
        return this;
    }

    String a() {
        return this.a;
    }

    String[] b() {
        return this.b;
    }

    JSONArray c() {
        return this.c;
    }

    JSONObject d() {
        return this.d;
    }

    void e() {
        this.setOption("bundle_id", a.a().m().F());
    }

    void f() {
        if (w.i(this.d, "use_forced_controller")) {
            aw.a = w.d(this.d, "use_forced_controller");
        }
        if (w.i(this.d, "use_staging_launch_server") && w.d(this.d, "use_staging_launch_server")) {
            l.e = "https://adc3-launch-staging.adcolony.com/v4/launch";
        }
    }

    public boolean getKeepScreenOn() {
        return w.d(this.d, "keep_screen_on");
    }

    public JSONObject getMediationInfo() {
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "name", w.b(this.d, "mediation_network"));
        w.a(jSONObject, "version", w.b(this.d, "mediation_network_version"));
        return jSONObject;
    }

    public boolean getMultiWindowEnabled() {
        return w.d(this.d, "multi_window_enabled");
    }

    public JSONObject getPluginInfo() {
        JSONObject jSONObject = w.a();
        w.a(jSONObject, "name", w.b(this.d, "plugin"));
        w.a(jSONObject, "version", w.b(this.d, "plugin_version"));
        return jSONObject;
    }

    public AdColonyUserMetadata getUserMetadata() {
        return this.e;
    }

    public AdColonyAppOptions setGDPRConsentString(String string) {
        w.a(this.d, "consent_string", string);
        return this;
    }

    public AdColonyAppOptions setGDPRRequired(boolean bl) {
        this.setOption("gdpr_required", bl);
        return this;
    }

    public AdColonyAppOptions setOption(String string, String string2) {
        if (string != null && au.d(string) && au.d(string2)) {
            w.a(this.d, string, string2);
        }
        return this;
    }

    public AdColonyAppOptions setOption(String string, boolean bl) {
        if (au.d(string)) {
            w.a(this.d, string, bl);
        }
        return this;
    }

    public AdColonyAppOptions setOriginStore(String string) {
        if (au.d(string)) {
            this.setOption("origin_store", string);
        }
        return this;
    }

    public AdColonyAppOptions setUserMetadata(AdColonyUserMetadata adColonyUserMetadata) {
        this.e = adColonyUserMetadata;
        w.a(this.d, "user_metadata", adColonyUserMetadata.c);
        return this;
    }
}

