/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
package com.appsgeyser.multiTabApp.ui.navigationwidget;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.appsgeyser.multiTabApp.ui.navigationwidget.NavigationWidgetCustomIcon;
import java.util.HashMap;

public interface INavigationWidget {
    public void attachAutocomplete();

    public HashMap<String, NavigationWidgetCustomIcon> getCustomIcons();

    public ViewGroup getNawigationWidgetView();

    public boolean isVisible();

    public void onPageFinished(WebView var1, String var2);

    public void onPageStart(WebView var1, String var2);

    public void setHideOnInternalUrls(boolean var1);

    public void setUrl(String var1);
}

