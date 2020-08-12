/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  com.adcolony.sdk.AdColonyNativeAdView$1
 *  com.adcolony.sdk.AdColonyNativeAdView$EngagementButton
 *  com.adcolony.sdk.ad
 *  com.adcolony.sdk.ax
 *  com.adcolony.sdk.e
 *  com.adcolony.sdk.w
 *  com.adcolony.sdk.y
 *  com.adcolony.sdk.y$a
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.adcolony.sdk.AdColonyNativeAdView;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ax;
import com.adcolony.sdk.e;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
@Deprecated
public class AdColonyNativeAdView
extends ax {
    private EngagementButton c;
    private boolean d;
    private String e;
    private String f;
    private String g;

    AdColonyNativeAdView(Context context, ad ad2, e e2) {
        super(context, ad2, e2);
        JSONObject jSONObject = ad2.c();
        this.setNative(true);
        this.d = w.d((JSONObject)jSONObject, (String)"engagement_enabled");
        this.e = w.b((JSONObject)jSONObject, (String)"engagement_click_action");
        this.f = w.b((JSONObject)jSONObject, (String)"engagement_click_action_type");
        this.g = w.b((JSONObject)jSONObject, (String)"engagement_text");
        if (this.d) {
            this.c = new /* Unavailable Anonymous Inner Class!! */;
            this.c.setText((CharSequence)this.g);
            this.c.setOnClickListener((View.OnClickListener)new 1(this));
        }
    }

    public String getAdvertiserName() {
        if (this.c()) {
            new y.a().a("Ignoring call to getAdvertiserName() as view has been destroyed").a(y.e);
            return "";
        }
        return super.getAdvertiserName();
    }

    public String getDescription() {
        if (this.c()) {
            new y.a().a("Ignoring call to getDescription() as view has been destroyed").a(y.e);
            return "";
        }
        return super.getDescription();
    }

    public EngagementButton getEngagementButton() {
        if (this.c()) {
            new y.a().a("Ignoring call to getEngagementButton() as view has been destroyed").a(y.e);
            return null;
        }
        return this.c;
    }

    public ImageView getIcon() {
        ImageView imageView = super.getIcon();
        if (imageView == null) {
            return null;
        }
        if (this.c()) {
            new y.a().a("Ignoring call to getIcon() as view has been destroyed").a(y.e);
            return null;
        }
        return imageView;
    }

    public String getTitle() {
        if (this.c()) {
            new y.a().a("Ignoring call to getTitle() as view has been destroyed").a(y.e);
            return "";
        }
        return super.getTitle();
    }
}

