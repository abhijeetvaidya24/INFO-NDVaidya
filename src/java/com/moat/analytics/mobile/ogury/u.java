/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.ogury.e
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.LinkedList
 */
package com.moat.analytics.mobile.ogury;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

final class u {
    private static final LinkedHashSet<String> \u0971 = new LinkedHashSet();

    u() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Optional<WebView> \u02ce(ViewGroup var0, boolean var1_1) {
        if (var0 != null) ** GOTO lbl4
        try {
            return Optional.empty();
lbl4: // 1 sources:
            if (var0 instanceof WebView) {
                return Optional.of((WebView)var0);
            }
            var2_2 = new LinkedList();
            var2_2.add((Object)var0);
            var4_3 = null;
            var5_4 = 0;
lbl10: // 3 sources:
            do {
                if (var2_2.isEmpty() != false) return Optional.ofNullable(var4_3);
                if (var5_4 >= 100) return Optional.ofNullable(var4_3);
                ++var5_4;
                var7_5 = (ViewGroup)var2_2.poll();
                var8_6 = var7_5.getChildCount();
                var9_7 = var4_3;
                break;
            } while (true);
        }
        catch (Exception v0) {
            return Optional.empty();
        }
        for (var10_8 = 0; var10_8 < var8_6; ++var10_8) {
            block6 : {
                block7 : {
                    var11_9 = var7_5.getChildAt(var10_8);
                    if (!(var11_9 instanceof WebView)) break block6;
                    e.1.\u02cb(3, "WebViewHound", (Object)var11_9, "Found WebView");
                    if (!var1_1 && !u.\u0971(String.valueOf((int)var11_9.hashCode()))) break block6;
                    if (var9_7 != null) break block7;
                    var9_7 = (WebView)var11_9;
                    break block6;
                }
                e.1.\u02cb(3, "WebViewHound", (Object)var11_9, "Ambiguous ad container: multiple WebViews reside within it.");
                e.1.\u0971("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
                var4_3 = null;
                ** GOTO lbl10
            }
            if (!(var11_9 instanceof ViewGroup)) continue;
            var2_2.add((Object)((ViewGroup)var11_9));
        }
        var4_3 = var9_7;
        ** while (true)
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean \u0971(String string2) {
        boolean bl2;
        String string3;
        try {
            bl2 = \u0971.add((Object)string2);
            if (\u0971.size() > 50) {
                Iterator iterator = \u0971.iterator();
                for (int i2 = 0; i2 < 25 && iterator.hasNext(); ++i2) {
                    iterator.next();
                    iterator.remove();
                }
            }
            string3 = bl2 ? "Newly Found WebView" : "Already Found WebView";
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return false;
        }
        e.1.\u02cb(3, "WebViewHound", null, string3);
        return bl2;
    }
}

