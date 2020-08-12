/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.startapp.android.publish.ads.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.startapp.android.publish.ads.a.c;
import com.startapp.android.publish.ads.a.d;
import com.startapp.android.publish.adsCommon.Utils.h;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.g.a.a;
import com.startapp.android.publish.adsCommon.g.a.e;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.common.a.g;
import java.util.Map;

public class d
extends c {
    private com.startapp.android.publish.adsCommon.g.a.d i = com.startapp.android.publish.adsCommon.g.a.d.a;
    private DisplayMetrics j;
    private b k;
    private com.startapp.android.publish.adsCommon.g.b.b l;
    private com.startapp.android.publish.adsCommon.g.c.a m;
    private ImageButton n;
    private boolean o = false;
    private boolean p = false;

    private void G() {
        try {
            this.b().getWindowManager().getDefaultDisplay().getMetrics(this.j);
            com.startapp.android.publish.adsCommon.g.a.c.a((Context)this.b(), this.j.widthPixels, this.j.heightPixels, this.d);
            com.startapp.android.publish.adsCommon.g.a.c.b((Context)this.b(), this.j.widthPixels, this.j.heightPixels, this.d);
            com.startapp.android.publish.adsCommon.g.a.c.a((Context)this.b(), 0, 0, this.j.widthPixels, this.j.heightPixels, this.d);
            com.startapp.android.publish.adsCommon.g.a.c.b((Context)this.b(), 0, 0, this.j.widthPixels, this.j.heightPixels, this.d);
            return;
        }
        catch (Exception exception) {
            f.a((Context)this.b(), com.startapp.android.publish.adsCommon.f.d.b, "MraidMode.updateDisplayMetrics", exception.getMessage(), "");
            return;
        }
    }

    private void H() {
        try {
            this.n = new ImageButton((Context)this.b());
            this.n.setBackgroundColor(0);
            this.n.setOnClickListener(new View.OnClickListener(this){
                final /* synthetic */ d a;
                {
                    this.a = d2;
                }

                public void onClick(View view) {
                    d.a(this.a).close();
                }
            });
            if (!this.o) {
                this.I();
            }
            int n2 = h.a((Context)this.b(), 50);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n2, n2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            this.f.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams);
            return;
        }
        catch (Exception exception) {
            f.a((Context)this.b(), com.startapp.android.publish.adsCommon.f.d.b, "MraidMode.addCloseRegion", exception.getMessage(), "");
            return;
        }
    }

    private void I() {
        try {
            if (this.n != null) {
                Drawable drawable = com.startapp.common.a.d.a(this.b().getResources(), "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA39pVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDY3IDc5LjE1Nzc0NywgMjAxNS8wMy8zMC0yMzo0MDo0MiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDozODRkZTAxYi00OWRkLWM4NDYtYThkNC0wZWRiMDMwYTZlODAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QkE0Q0U2MUY2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QkE0Q0U2MUU2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjlkZjAyMGU0LTNlYmUtZTY0ZC04YjRiLWM5ZWY4MTU4ZjFhYyIgc3RSZWY6ZG9jdW1lbnRJRD0iYWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOmU1MzEzNDdlLTZjMDEtMTFlNS1hZGZlLThmMTBjZWYxMGRiZSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PngNsEEAAANeSURBVHjatFfNS1tBEH+pUZOQ0B4i3sTSxHMRFNQoFBEP7dHgvyDiKWgguQra9F+oxqNiwOTQ+oFI1ZM3jSf1YK5FL41ooaKZzu+x+4gv2bx9Rgd+JNn5zO7s7IzH0CQiCvLHZ8YnxkfGe8ZbwS4zSowTxi/GT4/Hc2u8BLHjCOM745b06VboRJpx7GN8ZfyDxUqlQgcHB5RMJmloaIg6Ozupra3NBL5jDTzIQFYQdDOw5db5B8YxLDw+PtLKygr19PQQWDqIRqOUzWZNXUHH2rvBgr2M39C6uLig/v5+bcd2QLdUKskgYLNX57yvIL2zs0OhUOjZziU6Ojro8PBQBnGl3Alm+BknkMI54mybdS4BW3t7ezKIInzVCwDJYm4Zon4p5xLYzfPzcxlEpl7S3SNpmjlznZwQiXn/5CjEnTUzt5GBsbExamlpUfLBg0wjG8vLy3IXlqTzEAoH7m4kElEqTk1Nmfd7bW2tbhBYAw8ykFXZgQ9RJ1CsQghgEr/29/eVStPT09XFhdbX18nr9Vr81tZWyuVyFh+yMzMzSnvwJWjyDS+MYic2NzeV17O7u9vg2m79jsfjBv9bg7PbxOrqqjExMWHxIdvV1aW0V+VrFDtwhFCGh4cbnl0mk6kp+BsbGybsBNlGtkZGRqToEQK4xjfUc6csXlhYcHyFFhcXHe3Al6BrQz427e3tWldpfn5e6Rw83cIkHyvXAUAZb4SdsKZbPe0BaB+Bz+cjTiDlDmxtbZkybo9AKwn9fj9tb2875gBkINvIFnzJJMQ1PMV9GBgYUF6bQCBgFAoFY3x8/Ml6KpUy0un0kzXIQBY6KqrydapViPL5fM0/Rfcj+fhuJw5CqxBpleJYLEY3NzeW8dnZ2RoZrEmCLHQcSvGdWYrFe7CEFTwUqqjR85XLZUokEkoZ8CADWe3HqKoTcnyOdW5KI5m+vj56eHiQz3G0bkNyeXn5ag3J2dmZ/PffVC1Z8bVast3d3eqWLKDVlAaDwaadh8Nhvaa0XluOHg7n9lzn0MWRarfltp0oysEErRqGDTeDCbK9ajApuh7TxGiWERlrjWZzc3M0ODhYM5phDTzbaHb/rNHMFkhUNK13LobTv6K2RJ3se1yO519s4/k7wf5jG89/6I7n/wUYAGo3YtcprD4sAAAAAElFTkSuQmCC");
                this.n.setImageDrawable(drawable);
                this.n.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            }
        }
        catch (Exception exception) {
            f.a((Context)this.b(), com.startapp.android.publish.adsCommon.f.d.b, "MraidMode.showDefaultCloseButton", exception.getMessage(), "");
        }
    }

    private void J() {
        try {
            if (this.n != null) {
                this.n.setImageResource(17170445);
                return;
            }
        }
        catch (Exception exception) {
            f.a((Context)this.b(), com.startapp.android.publish.adsCommon.f.d.b, "MraidMode.removeDefaultCloseButton", exception.getMessage(), "");
        }
    }

    @Override
    public void a(Configuration configuration) {
        this.G();
    }

    @Override
    public void a(Bundle bundle) {
        super.a(bundle);
        if (this.j == null) {
            this.j = new DisplayMetrics();
        }
        if (this.l == null) {
            this.l = new com.startapp.android.publish.adsCommon.g.b.b((Context)this.b());
        }
        if (this.m == null) {
            this.m = new com.startapp.android.publish.adsCommon.g.c.a();
        }
        if (this.k == null) {
            this.k = new b(new a.a(this){
                final /* synthetic */ d a;
                {
                    this.a = d2;
                }

                public boolean a(String string) {
                    return this.a.a(string, true);
                }
            });
        }
    }

    @Override
    protected boolean a(String string, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("adClicked with url: ");
        stringBuilder.append(string);
        g.a("MraidMode", 3, stringBuilder.toString());
        this.i = com.startapp.android.publish.adsCommon.g.a.d.e;
        com.startapp.android.publish.adsCommon.g.a.c.a(this.i, this.d);
        try {
            boolean bl2 = super.a(string, bl);
            return bl2;
        }
        catch (Exception exception) {
            Activity activity = this.b();
            com.startapp.android.publish.adsCommon.f.d d2 = com.startapp.android.publish.adsCommon.f.d.b;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("url = [");
            stringBuilder2.append(string);
            stringBuilder2.append("], ");
            stringBuilder2.append(exception.getMessage());
            f.a((Context)activity, d2, "MraidMode.adClicked", stringBuilder2.toString(), "");
            return false;
        }
    }

    @Override
    protected boolean b(String string) {
        return false;
    }

    @Override
    public void s() {
        this.p = false;
        if (this.i == com.startapp.android.publish.adsCommon.g.a.d.b) {
            this.k.fireViewableChangeEvent();
        }
        super.s();
    }

    @Override
    public void u() {
        super.u();
        this.p = true;
        if (this.i == com.startapp.android.publish.adsCommon.g.a.d.b) {
            this.k.fireViewableChangeEvent();
        }
    }

    @Override
    protected void x() {
        this.d.setWebViewClient((WebViewClient)new e(this.k){

            public void onPageFinished(WebView webView, String string) {
                super.onPageFinished(webView, string);
                if (d.this.i == com.startapp.android.publish.adsCommon.g.a.d.a) {
                    com.startapp.android.publish.adsCommon.g.a.c.a("interstitial", webView);
                    com.startapp.android.publish.adsCommon.g.b.a.a((Context)d.this.b(), webView, d.this.l);
                    d.this.G();
                    d.this.H();
                    d.this.i = com.startapp.android.publish.adsCommon.g.a.d.b;
                    com.startapp.android.publish.adsCommon.g.a.c.a(d.this.i, webView);
                    com.startapp.android.publish.adsCommon.g.a.c.a(webView);
                    if (d.this.p) {
                        d.this.k.fireViewableChangeEvent();
                    }
                    if (MetaData.getInstance().isOmsdkEnabled()) {
                        d d2 = d.this;
                        d2.e = null;
                        if (d2.e != null) {
                            View view;
                            if (d.this.a != null && (view = d.this.a.a()) != null) {
                                d.this.e.b(view);
                            }
                            d.this.e.a((View)webView);
                            d.this.e.a();
                            com.b.a.a.a.b.a.a(d.this.e).a();
                        }
                    }
                }
            }
        });
        this.d.setWebChromeClient(new WebChromeClient(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
                try {
                    if (consoleMessage.messageLevel() == android.webkit.ConsoleMessage$MessageLevel.ERROR) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("WebChromeClient console error: ");
                        stringBuilder.append(consoleMessage.message());
                        g.a("MraidMode", 6, stringBuilder.toString());
                        if (consoleMessage.message().contains((java.lang.CharSequence)"mraid")) {
                            f.a((Context)this.a.b(), com.startapp.android.publish.adsCommon.f.d.b, "MraidMode.ConsoleError", consoleMessage.message(), "");
                        }
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("WebChromeClient console log: ");
                        stringBuilder.append(consoleMessage.message());
                        g.a("MraidMode", 3, stringBuilder.toString());
                    }
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("WebChromeClient onConsoleMessage Exception: ");
                    stringBuilder.append(exception.getMessage());
                    g.a("MraidMode", 6, stringBuilder.toString());
                }
                return super.onConsoleMessage(consoleMessage);
            }
        });
    }

    private class b
    extends com.startapp.android.publish.adsCommon.g.a.a {
        public b(a.a a2) {
            super(a2);
        }

        @Override
        public void close() {
            g.a("MraidMode", 3, "close");
            d.this.i = com.startapp.android.publish.adsCommon.g.a.d.e;
            com.startapp.android.publish.adsCommon.g.a.c.a(d.this.i, d.this.d);
            d.this.g.run();
        }

        public void fireViewableChangeEvent() {
            com.startapp.android.publish.adsCommon.g.a.c.a(d.this.d, d.this.p);
        }

        @Override
        public boolean isFeatureSupported(String string) {
            return d.this.l.a(string);
        }

        @Override
        public void setOrientationProperties(Map<String, String> map) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setOrientationProperties: ");
            stringBuilder.append(map);
            g.a("MraidMode", 3, stringBuilder.toString());
            boolean bl = Boolean.parseBoolean((String)((String)map.get((Object)"allowOrientationChange")));
            String string = (String)map.get((Object)"forceOrientation");
            if (d.f((d)d.this).a != bl || d.f((d)d.this).b != com.startapp.android.publish.adsCommon.g.c.a.a(string)) {
                d.f((d)d.this).a = bl;
                d.f((d)d.this).b = com.startapp.android.publish.adsCommon.g.c.a.a(string);
                this.applyOrientationProperties(d.this.b(), d.this.m);
            }
        }

        @Override
        public void useCustomClose(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("useCustomClose: ");
            stringBuilder.append(string);
            g.a("MraidMode", 3, stringBuilder.toString());
            boolean bl = Boolean.parseBoolean((String)string);
            if (d.this.o != bl) {
                d.this.o = bl;
                if (bl) {
                    d.this.J();
                    return;
                }
                d.this.I();
            }
        }
    }

}

