/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  java.lang.Object
 */
package com.appsgeyser.multiTabApp.plugins;

import android.content.Context;
import android.webkit.WebView;
import com.appsgeyser.multiTabApp.plugins.IApplicationPlugin;

public class PluginsLoader {
    public static void loadPlugins(Context context, WebView webView) {
        IApplicationPlugin[] arriApplicationPlugin = new IApplicationPlugin[]{};
        int n2 = arriApplicationPlugin.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arriApplicationPlugin[i2].load(context, webView);
        }
    }
}

