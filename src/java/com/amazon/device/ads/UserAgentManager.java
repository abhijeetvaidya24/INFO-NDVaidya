/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.Version;
import com.amazon.device.ads.WebViewFactory;

class UserAgentManager {
    private final ThreadUtils.ThreadRunner threadRunner;
    private String userAgentStringWithSDKVersion;
    private String userAgentStringWithoutSDKVersion;
    private final WebViewFactory webViewFactory;

    public UserAgentManager() {
        this(new ThreadUtils.ThreadRunner(), WebViewFactory.getInstance());
    }

    UserAgentManager(ThreadUtils.ThreadRunner threadRunner, WebViewFactory webViewFactory) {
        this.threadRunner = threadRunner;
        this.webViewFactory = webViewFactory;
    }

    public String getUserAgentString() {
        return this.userAgentStringWithSDKVersion;
    }

    public void populateUserAgentString(final Context context) {
        this.threadRunner.execute(new Runnable(){

            public void run() {
                UserAgentManager userAgentManager = UserAgentManager.this;
                userAgentManager.setUserAgentString(userAgentManager.webViewFactory.createWebView(context).getSettings().getUserAgentString());
            }
        }, ThreadUtils.ExecutionStyle.RUN_ASAP, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }

    public void setUserAgentString(String string) {
        if (string != null && !string.equals((Object)this.userAgentStringWithoutSDKVersion) && !string.equals((Object)this.userAgentStringWithSDKVersion)) {
            this.userAgentStringWithoutSDKVersion = string;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" ");
            stringBuilder.append(Version.getUserAgentSDKVersion());
            this.userAgentStringWithSDKVersion = stringBuilder.toString();
        }
    }

}

