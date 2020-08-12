/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.LinkedList
 */
package com.moat.analytics.mobile.cha;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.base.functional.Optional;
import com.moat.analytics.mobile.cha.o;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

final class x {
    private static final LinkedHashSet<String> \u02cb = new LinkedHashSet();

    x() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Optional<WebView> \u02ca(ViewGroup var0, boolean var1_1) {
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
                    a.\u02cf(3, "WebViewHound", (Object)var11_9, "Found WebView");
                    if (!var1_1 && !x.\u02ca(String.valueOf((int)var11_9.hashCode()))) break block6;
                    if (var9_7 != null) break block7;
                    var9_7 = (WebView)var11_9;
                    break block6;
                }
                a.\u02cf(3, "WebViewHound", (Object)var11_9, "Ambiguous ad container: multiple WebViews reside within it.");
                a.\u02ca("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
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
    private static boolean \u02ca(String string) {
        boolean bl2;
        String string2;
        try {
            bl2 = \u02cb.add((Object)string);
            if (\u02cb.size() > 50) {
                Iterator iterator = \u02cb.iterator();
                for (int i2 = 0; i2 < 25 && iterator.hasNext(); ++i2) {
                    iterator.next();
                    iterator.remove();
                }
            }
            string2 = bl2 ? "Newly Found WebView" : "Already Found WebView";
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return false;
        }
        a.\u02cf(3, "WebViewHound", null, string2);
        return bl2;
    }
}

