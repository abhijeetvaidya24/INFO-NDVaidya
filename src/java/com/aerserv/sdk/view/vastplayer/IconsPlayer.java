/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Paint
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.aerserv.sdk.controller.command.FireEventCommand
 *  com.aerserv.sdk.controller.command.LaunchBrowserCommand
 *  com.aerserv.sdk.model.vast.HTMLAdResource
 *  com.aerserv.sdk.model.vast.IFrameAdResource
 *  com.aerserv.sdk.model.vast.StaticAdResource
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.LinkedHashMap
 *  java.util.List
 */
package com.aerserv.sdk.view.vastplayer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.aerserv.sdk.controller.command.FireEventCommand;
import com.aerserv.sdk.controller.command.LaunchBrowserCommand;
import com.aerserv.sdk.model.vast.AdResource;
import com.aerserv.sdk.model.vast.HTMLAdResource;
import com.aerserv.sdk.model.vast.IFrameAdResource;
import com.aerserv.sdk.model.vast.Icon;
import com.aerserv.sdk.model.vast.IconClicks;
import com.aerserv.sdk.model.vast.Icons;
import com.aerserv.sdk.model.vast.StaticAdResource;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.DisplayUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.aerserv.sdk.view.vastplayer.IconsListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class IconsPlayer
extends RelativeLayout {
    private static final String LOG_TAG = "com.aerserv.sdk.view.vastplayer.IconsPlayer";
    private VastIconView currentView = null;
    private List<Icon> iconList = new ArrayList();
    private IconsListener listener;
    private final Object lock = new Object();

    public IconsPlayer(Context context, Icons icons, IconsListener iconsListener) {
        super(context);
        this.setBackgroundColor(0);
        int n = Math.round((float)(5.0f * context.getResources().getDisplayMetrics().density));
        this.setPadding(n, n, n, n);
        this.listener = iconsListener;
        this.iconList.addAll((Collection)icons);
        Collections.reverse(this.iconList);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Icon icon : this.iconList) {
            linkedHashMap.put((Object)icon.getProgram(), (Object)icon);
        }
        this.iconList.clear();
        this.iconList.addAll(linkedHashMap.values());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Icon icon : this.iconList) {
            linkedHashMap2.put((Object)this.parseOffset(icon), (Object)icon);
        }
        this.iconList.clear();
        this.iconList.addAll(linkedHashMap2.values());
        Collections.sort(this.iconList, (Comparator)new Comparator<Icon>(){

            public int compare(Icon icon, Icon icon2) {
                return (int)(IconsPlayer.this.parseOffset(icon) - IconsPlayer.this.parseOffset(icon2));
            }
        });
    }

    private String getHtml(StaticAdResource staticAdResource, int n, int n2) {
        Object[] arrobject = new Object[]{n, n2, staticAdResource.getResourceUri()};
        return String.format((String)"<!doctype html>\n<html lang=\"en\">\n  <head>\n    <style type=\"text/css\">\n      body {margin: 0; padding: 0; background-color: black;}\n      img {margin: auto; position: absolute; top: 0; left: 0; bottom: 0; right: 0;}\n    </style>\n  </head>\n  <body>\n    <img width=\"%d\" height=\"%d\" src=\"%s\">\n  </body>\n</html>", (Object[])arrobject);
    }

    private boolean isSupportedAdResource(AdResource adResource) {
        boolean bl;
        block8 : {
            block7 : {
                block4 : {
                    boolean bl2;
                    block6 : {
                        block5 : {
                            if (!(adResource instanceof StaticAdResource)) break block4;
                            String string = ((StaticAdResource)adResource).getMimeType();
                            if ("image/gif".equals((Object)string) || "image/jpeg".equals((Object)string)) break block5;
                            boolean bl3 = "image/png".equals((Object)string);
                            bl2 = false;
                            if (!bl3) break block6;
                        }
                        bl2 = true;
                    }
                    return bl2;
                }
                if (adResource instanceof HTMLAdResource) break block7;
                boolean bl4 = adResource instanceof IFrameAdResource;
                bl = false;
                if (!bl4) break block8;
            }
            bl = true;
        }
        return bl;
    }

    private long parseOffset(Icon icon) {
        if (TextUtils.isEmpty((CharSequence)icon.getOffset())) {
            return 0L;
        }
        return this.parseTime(icon.getOffset());
    }

    /*
     * Exception decompiling
     */
    private long parseTime(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl73 : LCONST_0 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private void removeCurrentView() {
        new Handler(this.getContext().getMainLooper()).post(new Runnable(){

            public void run() {
                if (IconsPlayer.this.currentView != null) {
                    IconsPlayer iconsPlayer = IconsPlayer.this;
                    iconsPlayer.removeView((View)iconsPlayer.currentView);
                    IconsPlayer.this.currentView.destroy();
                    IconsPlayer.this.invalidate();
                    IconsPlayer.this.currentView = null;
                }
            }
        });
    }

    private void showIcon(final Icon icon) {
        new Handler(this.getContext().getMainLooper()).post(new Runnable(){

            public void run() {
                try {
                    VastIconView vastIconView = new VastIconView(IconsPlayer.this.getContext(), icon);
                    IconsPlayer.this.addView((View)vastIconView);
                    IconsPlayer.this.currentView = vastIconView;
                    return;
                }
                catch (Exception exception) {
                    String string = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot create VAST icon view: ");
                    stringBuilder.append(exception.getMessage());
                    AerServLog.w(string, stringBuilder.toString());
                    return;
                }
            }
        });
    }

    public void destroy() {
        this.listener = null;
        this.removeCurrentView();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onTime(long l2, int n, int n2) {
        Object object;
        Object object2 = object = this.lock;
        synchronized (object2) {
            int n3 = this.iconList.size();
            Icon icon = null;
            if (n3 > 0) {
                long l3 = l2 LCMP this.parseOffset((Icon)this.iconList.get(0));
                icon = null;
                if (l3 >= 0) {
                    icon = (Icon)this.iconList.remove(0);
                }
            }
            if (this.currentView != null && (l2 >= this.currentView.closeTime || icon != null)) {
                this.removeCurrentView();
            }
            if (icon != null) {
                int n4 = DisplayUtils.convertDipToPx(this.getContext(), icon.getWidth());
                int n5 = DisplayUtils.convertDipToPx(this.getContext(), icon.getHeight());
                int n6 = n4 * n5;
                int n7 = n * n2;
                double d2 = n6;
                double d3 = n7;
                Double.isNaN((double)d3);
                if (d2 <= d3 * 0.2) {
                    this.showIcon(icon);
                } else {
                    String string = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Icon area ");
                    stringBuilder.append(n6);
                    stringBuilder.append(" is larger than 20% of ad area ");
                    stringBuilder.append(n7);
                    AerServLog.d(string, stringBuilder.toString());
                }
            }
            return;
        }
    }

    private class VastIconView
    extends WebView {
        private AdResource adResource;
        private long closeTime;

        public VastIconView(Context context, final Icon icon) throws Exception {
            Exception exception;
            super(context);
            this.closeTime = TextUtils.isEmpty((CharSequence)icon.getDuration()) ? Long.MAX_VALUE : IconsPlayer.this.parseOffset(icon) + IconsPlayer.this.parseTime(icon.getDuration());
            List<AdResource> list = icon.getResourceList();
            Collections.sort(list, (Comparator)new Comparator<AdResource>(){

                public int compare(AdResource adResource, AdResource adResource2) {
                    if (adResource instanceof HTMLAdResource) {
                        return -1;
                    }
                    if (adResource instanceof StaticAdResource) {
                        return -1;
                    }
                    return 1;
                }
            });
            for (AdResource adResource : list) {
                if (!IconsPlayer.this.isSupportedAdResource(adResource)) continue;
                this.adResource = adResource;
                break;
            }
            if (this.adResource != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtils.convertDipToPx(this.getContext(), icon.getWidth()), DisplayUtils.convertDipToPx(this.getContext(), icon.getHeight()));
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                this.setHorizontalScrollBarEnabled(false);
                this.setVerticalScrollBarEnabled(false);
                this.getSettings().setJavaScriptEnabled(true);
                this.setBackgroundColor(0);
                this.setWebChromeClient(new WebChromeClient());
                if (VersionUtils.checkVersion(11)) {
                    this.setLayerType(1, null);
                }
                this.setWebViewClient(new WebViewClient(){

                    public void onPageFinished(WebView webView, String string) {
                        super.onPageFinished(webView, string);
                        new FireEventCommand(icon.getViewTrackingUri()).execute();
                    }
                });
                this.setOnTouchListener(new View.OnTouchListener(){

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            IconsPlayer.this.listener.onTouched();
                            new FireEventCommand(icon.getIconClicks().getClickTrackingUriList()).execute();
                            new LaunchBrowserCommand(VastIconView.this.getContext(), icon.getIconClicks().getClickThroughUri()).execute();
                        }
                        return true;
                    }
                });
                AdResource adResource = this.adResource;
                if (adResource instanceof HTMLAdResource) {
                    this.loadData(((HTMLAdResource)adResource).getHtml(), "text/html", "UTF-8");
                    return;
                }
                if (adResource instanceof StaticAdResource) {
                    this.loadData(IconsPlayer.this.getHtml((StaticAdResource)adResource, icon.getWidth(), icon.getHeight()), "text/html", "UTF-8");
                    return;
                }
                if (adResource instanceof IFrameAdResource) {
                    this.loadUrl(((IFrameAdResource)adResource).getiFrameUri());
                }
                return;
            }
            exception = new Exception("Cannot find supported ad resource");
            throw exception;
        }

        public void destroy() {
            this.removeAllViews();
            this.clearHistory();
            this.clearCache(true);
            this.loadUrl("about:blank");
            this.onPause();
            this.removeAllViews();
            this.destroyDrawingCache();
            this.pauseTimers();
            super.destroy();
        }

    }

}

