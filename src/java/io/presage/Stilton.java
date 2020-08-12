/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  io.presage.j
 *  io.presage.l
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Map
 */
package io.presage;

import android.webkit.WebView;
import io.presage.StRomans;
import io.presage.TommedeSavoie;
import io.presage.j;
import io.presage.l;
import java.util.Collection;
import java.util.Map;

public final class Stilton {
    private final Map<String, j> a;
    private final Map<String, TommedeSavoie> b;

    public Stilton(Map<String, j> map, Map<String, TommedeSavoie> map2) {
        this.a = map;
        this.b = map2;
    }

    public static void a(j j2, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.callPendingMethodCallback(\"");
        stringBuilder.append(string2);
        stringBuilder.append("\", null, {webviewId:\"");
        stringBuilder.append(string3);
        stringBuilder.append("\"})");
        StringBuilder stringBuilder2 = new StringBuilder("ogySdkMraidGateway.callPendingMethodCallback(\"");
        stringBuilder2.append(string2);
        stringBuilder2.append("\", null, {webviewId:\"");
        stringBuilder2.append(string3);
        stringBuilder2.append("\"})");
        l.a((j)j2, (String)stringBuilder2.toString());
    }

    private final void b(String string2) {
        for (j j2 : this.a.values()) {
            TommedeSavoie tommedeSavoie = (TommedeSavoie)this.b.get((Object)StRomans.b((WebView)j2));
            if (tommedeSavoie == null || !tommedeSavoie.d()) continue;
            l.a((j)j2, (String)string2);
        }
    }

    public final void a() {
        this.b("ogySdkMraidGateway.callEventListeners(\"ogyOnCloseSystem\", {})");
    }

    public final void a(String string2) {
        StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.updateCurrentAppOrientation({orientation: \"");
        stringBuilder.append(string2);
        stringBuilder.append("\", locked: false})");
        this.b(stringBuilder.toString());
    }

    public final void a(String string2, boolean bl2, boolean bl3, String string3, String string4) {
        StringBuilder stringBuilder = new StringBuilder("ogySdkMraidGateway.callEventListeners(\"ogyOnNavigation\", {event: \"");
        stringBuilder.append(string2);
        stringBuilder.append("\", canGoBack: ");
        stringBuilder.append(bl3);
        stringBuilder.append(", canGoForward: ");
        stringBuilder.append(bl2);
        stringBuilder.append(", webviewId: \"");
        stringBuilder.append(string3);
        stringBuilder.append("\", url: \"");
        stringBuilder.append(string4);
        stringBuilder.append("\"})");
        this.b(stringBuilder.toString());
    }
}

