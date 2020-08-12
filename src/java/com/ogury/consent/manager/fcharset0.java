/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.util.Base64
 *  android.webkit.WebView
 *  com.ogury.consent.manager.fcharset0$ansi
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URLDecoder
 *  java.nio.charset.Charset
 *  java.util.Date
 *  org.json.JSONObject
 */
package com.ogury.consent.manager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import android.webkit.WebView;
import com.ogury.consent.manager.ConsentActivity;
import com.ogury.consent.manager.ConsentManager;
import com.ogury.consent.manager.Helvetica;
import com.ogury.consent.manager.cf0;
import com.ogury.consent.manager.colortbl;
import com.ogury.consent.manager.fcharset0;
import com.ogury.consent.manager.fs24;
import com.ogury.consent.manager.green255;
import com.ogury.consent.manager.margl1440;
import com.ogury.consent.manager.rtf1;
import com.ogury.consent.manager.tx5040;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.ConsentException;
import com.ogury.consent.manager.util.consent.ansicpg1252;
import com.ogury.consent.manager.util.consent.cocoasubrtf100;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Date;
import org.json.JSONObject;

public final class fcharset0 {
    public static final rtf1 a = new rtf1(null);

    private static void a(Context context) {
        if (context instanceof ConsentActivity) {
            ((ConsentActivity)context).finish();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void a(String var0, Context var1_1, com.ogury.consent.manager.util.consent.rtf1 var2_2, WebView var3_3) {
        block7 : {
            block8 : {
                tx6480.b(var0, "url");
                tx6480.b((Object)var1_1, "context");
                tx6480.b(var2_2, "callback");
                tx6480.b((Object)var3_3, "webView");
                var4_4 = var0.toLowerCase();
                tx6480.a((Object)var4_4, "(this as java.lang.String).toLowerCase()");
                if (!fs24.a(var4_4, "https://ogyconsent", false, 2, null)) break block7;
                var13_5 = var0.substring(20);
                tx6480.a((Object)var13_5, "(this as java.lang.String).substring(startIndex)");
                if (!fs24.a(var13_5, "consent=", false, 2, null)) break block8;
                new ansicpg1252();
                tx6480.b(var13_5, "consent");
                var15_6 = URLDecoder.decode((String)var13_5, (String)"UTF-8");
                if (var15_6 == null || (var16_8 = rtf1.rtf1.a(fs24.a(var15_6, "consent=", null, 2, null))) == null || (var17_9 = var16_8.optJSONObject("response")) == null || (var18_10 = var17_9.optJSONObject("response")) == null) ** GOTO lbl-1000
                var20_11 = com.ogury.consent.manager.util.consent.ansi.a();
                var21_12 = var17_9.optString("lastOpt");
                tx6480.a((Object)var21_12, "responseObject.optString(\"lastOpt\")");
                var20_11.a(rtf1.rtf1.b(var21_12));
                var23_13 = com.ogury.consent.manager.util.consent.ansi.a();
                var24_14 = var18_10.optString("iabString");
                tx6480.a((Object)var24_14, "consentResponseObject.optString(\"iabString\")");
                var23_13.c(var24_14);
                var26_15 = com.ogury.consent.manager.util.consent.ansi.a();
                var27_16 = var18_10.optString("purposes");
                tx6480.a((Object)var27_16, "consentResponseObject.optString(\"purposes\")");
                var26_15.d(var27_16);
                var29_17 = com.ogury.consent.manager.util.consent.ansi.a();
                var30_18 = var18_10.optString("refusedVendors");
                tx6480.a((Object)var30_18, "consentResponseObject.optString(\"refusedVendors\")");
                var29_17.b(var30_18);
                var32_19 = com.ogury.consent.manager.util.consent.ansi.a();
                var33_20 = var18_10.optString("acceptedVendors");
                tx6480.a((Object)var33_20, "consentResponseObject.optString(\"acceptedVendors\")");
                var32_19.a(var33_20);
                var34_21 = var16_8.optJSONObject("sdk");
                if (var34_21 == null) lbl-1000: // 2 sources:
                {
                    var39_7 = "parsing-error";
                } else {
                    var36_22 = com.ogury.consent.manager.util.consent.ansi.c();
                    var37_23 = var34_21.optString("crashReportUrl");
                    tx6480.a((Object)var37_23, "sdkObject.optString(\"crashReportUrl\")");
                    var36_22.c(var37_23);
                    if (var34_21.has("cacheFor")) {
                        com.ogury.consent.manager.util.consent.ansi.a(new Date().getTime() + 1000L * var16_8.optLong("cacheFor"));
                    }
                    var39_7 = com.ogury.consent.manager.util.consent.ansi.a().c().toString();
                }
                if (tx6480.a((Object)var39_7, (Object)"parsing-error")) {
                    var2_2.a(new ConsentException(var39_7, ""));
                    cocoasubrtf100.a("");
                } else {
                    colortbl.a(var1_1, (Helvetica)new ansi(var2_2, var39_7, var1_1));
                }
                fcharset0.a(var1_1);
                return;
            }
            if (fs24.a(var13_5, "ogyRedirect=", false, 2, null)) {
                var1_1.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)fs24.a(var13_5, "ogyRedirect=", null, 2, null))));
                return;
            }
            if (fs24.a(var13_5, "error=", false, 2, null) == false) return;
            var2_2.a(new ConsentException("form-error", ""));
            fcharset0.a(var1_1);
            return;
        }
        var5_24 = var0;
        if (fs24.a(var5_24, (CharSequence)"?ready", false, 2, null)) {
            var3_3.setVisibility(0);
            var6_25 = new StringBuilder("javascript:(function(){ogFormBridge.init(\"");
            var8_26 = com.ogury.consent.manager.util.consent.ansi.b().a();
            tx6480.b(var8_26, "$receiver");
            var9_27 = var8_26.getBytes(cf0.a);
            tx6480.a((Object)var9_27, "(this as java.lang.String).getBytes(charset)");
            var10_28 = Base64.encodeToString((byte[])var9_27, (int)11);
            tx6480.a((Object)var10_28, "Base64.encodeToString(by\u2026ADDING + Base64.URL_SAFE)");
            var6_25.append(var10_28);
            var6_25.append("\")})()");
            var3_3.loadUrl(var6_25.toString());
            var2_2.a("ready");
            return;
        }
        if (fs24.a(var5_24, (CharSequence)"success", false, 2, null) == false) return;
        var2_2.a("success");
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(tx5040 tx50402) {
            this();
        }
    }

}

