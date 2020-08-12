/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  io.presage.j
 *  io.presage.l
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import io.presage.BrillatSavarin;
import io.presage.Mimolette24mois;
import io.presage.StRomans;
import io.presage.TommeCrayeuse;
import io.presage.j;
import io.presage.l;

public final class StMarcellin {
    private final Context a;
    private final FrameLayout b;
    private final BrillatSavarin c;

    public StMarcellin(Context context, FrameLayout frameLayout, BrillatSavarin brillatSavarin) {
        this.a = context;
        this.b = frameLayout;
        this.c = brillatSavarin;
    }

    private static FrameLayout.LayoutParams a(TommeCrayeuse tommeCrayeuse, FrameLayout.LayoutParams layoutParams) {
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        StMarcellin.b(tommeCrayeuse, layoutParams);
        StMarcellin.a(layoutParams, tommeCrayeuse);
        return layoutParams;
    }

    public static void a(WebView webView, TommeCrayeuse tommeCrayeuse) {
        ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        webView.setLayoutParams((ViewGroup.LayoutParams)StMarcellin.a(tommeCrayeuse, (FrameLayout.LayoutParams)layoutParams));
    }

    private static void a(FrameLayout.LayoutParams layoutParams, TommeCrayeuse tommeCrayeuse) {
        int n2 = tommeCrayeuse.e();
        int n3 = -1;
        int n4 = n2 <= 0 ? -1 : Mimolette24mois.b(tommeCrayeuse.e());
        layoutParams.width = n4;
        if (tommeCrayeuse.d() > 0) {
            n3 = Mimolette24mois.b(tommeCrayeuse.d());
        }
        layoutParams.height = n3;
    }

    private static void b(TommeCrayeuse tommeCrayeuse, FrameLayout.LayoutParams layoutParams) {
        if (tommeCrayeuse.g() != -1) {
            layoutParams.leftMargin = Mimolette24mois.b(tommeCrayeuse.g());
        }
        if (tommeCrayeuse.f() != -1) {
            layoutParams.topMargin = Mimolette24mois.b(tommeCrayeuse.f());
        }
    }

    public final j a(TommeCrayeuse tommeCrayeuse) {
        FrameLayout.LayoutParams layoutParams = StMarcellin.a(tommeCrayeuse, null);
        j j2 = l.a((Context)this.a, (BrillatSavarin)this.c);
        if (j2 == null) {
            return null;
        }
        j2.setTag((Object)tommeCrayeuse.c());
        StRomans.a((WebView)j2);
        this.b.addView((View)j2, (ViewGroup.LayoutParams)layoutParams);
        return j2;
    }

    public final void a(WebView webView) {
        this.b.removeView((View)webView);
    }
}

