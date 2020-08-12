/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.w;
import org.json.JSONObject;

public class AdColonyAdOptions {
    boolean a;
    boolean b;
    JSONObject d = w.a();

    public AdColonyAdOptions enableConfirmationDialog(boolean bl) {
        this.a = bl;
        w.a(this.d, "confirmation_enabled", true);
        return this;
    }

    public AdColonyAdOptions enableResultsDialog(boolean bl) {
        this.b = bl;
        w.a(this.d, "results_enabled", true);
        return this;
    }
}

