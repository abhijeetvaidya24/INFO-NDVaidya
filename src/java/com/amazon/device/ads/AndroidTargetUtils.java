/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.graphics.Paint
 *  android.graphics.drawable.Drawable
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.Window
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.widget.ImageButton
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.Executor
 */
package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.ThreadUtils;
import java.util.concurrent.Executor;

class AndroidTargetUtils {
    public static final AndroidClassAdapter defaultAndroidClassAdapter = new AndroidClassAdapter(new AndroidBuildInfo());

    private AndroidTargetUtils() {
    }

    public static final void disableHardwareAcceleration(View view) {
        HoneycombTargetUtils.disableHardwareAcceleration(view);
    }

    public static void enableHardwareAcceleration(AndroidBuildInfo androidBuildInfo, Window window) {
        if (AndroidTargetUtils.isAtLeastAndroidAPI(androidBuildInfo, 11)) {
            HoneycombTargetUtils.enableHardwareAcceleration(window);
        }
    }

    public static void enableWebViewDebugging(boolean bl) {
        if (AndroidTargetUtils.isAtLeastAndroidAPI(19)) {
            KitKatTargetUtils.enableWebViewDebugging(bl);
        }
    }

    public static /* varargs */ <T> void executeAsyncTask(ThreadUtils.MobileAdsAsyncTask<T, ?, ?> mobileAdsAsyncTask, T ... arrT) {
        if (AndroidTargetUtils.isAtLeastAndroidAPI(11)) {
            HoneycombTargetUtils.executeAsyncTaskWithThreadPooling(mobileAdsAsyncTask, arrT);
            return;
        }
        mobileAdsAsyncTask.execute((Object[])arrT);
    }

    public static AndroidClassAdapter getDefaultAndroidClassAdapter() {
        return defaultAndroidClassAdapter;
    }

    public static void hideActionAndStatusBars(AndroidBuildInfo androidBuildInfo, Activity activity) {
        if (AndroidTargetUtils.isAtLeastAndroidAPI(androidBuildInfo, 11)) {
            HoneycombTargetUtils.hideActionBar(activity);
        }
        if (AndroidTargetUtils.isAtLeastAndroidAPI(androidBuildInfo, 16)) {
            JellyBeanTargetUtils.hideStatusBar(activity);
        }
    }

    @TargetApi(value=11)
    public static boolean isAdTransparent(View view) {
        return AndroidTargetUtils.isAtLeastAndroidAPI(11) && view.getAlpha() == 0.0f;
    }

    public static boolean isAndroidAPI(int n) {
        return Build.VERSION.SDK_INT == n;
    }

    public static boolean isAndroidAPI(AndroidBuildInfo androidBuildInfo, int n) {
        return androidBuildInfo.getSDKInt() == n;
    }

    public static boolean isAtLeastAndroidAPI(int n) {
        return Build.VERSION.SDK_INT >= n;
    }

    public static boolean isAtLeastAndroidAPI(AndroidBuildInfo androidBuildInfo, int n) {
        return androidBuildInfo.getSDKInt() >= n;
    }

    public static boolean isAtOrBelowAndroidAPI(int n) {
        return Build.VERSION.SDK_INT <= n;
    }

    public static boolean isAtOrBelowAndroidAPI(AndroidBuildInfo androidBuildInfo, int n) {
        return androidBuildInfo.getSDKInt() <= n;
    }

    public static boolean isBetweenAndroidAPIs(AndroidBuildInfo androidBuildInfo, int n, int n2) {
        return AndroidTargetUtils.isAtLeastAndroidAPI(androidBuildInfo, n) && AndroidTargetUtils.isAtOrBelowAndroidAPI(androidBuildInfo, n2);
    }

    public static void removeJavascriptInterface(WebView webView, String string) {
        HoneycombTargetUtils.removeJavascriptInterface(webView, string);
    }

    public static void setBackgroundDrawable(View view, Drawable drawable) {
        if (AndroidTargetUtils.isAtLeastAndroidAPI(16)) {
            JellyBeanTargetUtils.setBackgroundForLinerLayout(view, drawable);
            return;
        }
        view.setBackgroundDrawable(drawable);
    }

    public static void setImageButtonAlpha(ImageButton imageButton, int n) {
        if (AndroidTargetUtils.isAtLeastAndroidAPI(16)) {
            JellyBeanTargetUtils.setImageButtonAlpha(imageButton, n);
            return;
        }
        imageButton.setAlpha(n);
    }

    public static class AndroidClassAdapter {
        private final AndroidBuildInfo androidBuildInfo;

        public AndroidClassAdapter(AndroidBuildInfo androidBuildInfo) {
            this.androidBuildInfo = androidBuildInfo;
        }

        private boolean isAtLeastAndroidAPI(int n) {
            return AndroidTargetUtils.isAtLeastAndroidAPI(this.androidBuildInfo, n);
        }

        public WebSettingsAdapter withWebSettings(WebSettings webSettings) {
            return new WebSettingsAdapter(webSettings);
        }

        public class WebSettingsAdapter {
            private final WebSettings webSettings;

            public WebSettingsAdapter(WebSettings webSettings) {
                this.webSettings = webSettings;
            }

            public void setMediaPlaybackRequiresUserGesture(boolean bl) {
                if (AndroidClassAdapter.this.isAtLeastAndroidAPI(17)) {
                    JellyBeanMR1TargetUtils.setMediaPlaybackRequiresUserGesture(this.webSettings, bl);
                }
            }
        }

    }

    @TargetApi(value=11)
    private static class HoneycombTargetUtils {
        private HoneycombTargetUtils() {
        }

        public static final void disableHardwareAcceleration(View view) {
            view.setLayerType(1, null);
        }

        protected static void enableHardwareAcceleration(Window window) {
            window.setFlags(16777216, 16777216);
        }

        protected static final /* varargs */ <T> void executeAsyncTaskWithThreadPooling(ThreadUtils.MobileAdsAsyncTask<T, ?, ?> mobileAdsAsyncTask, T ... arrT) {
            mobileAdsAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])arrT);
        }

        protected static void hideActionBar(Activity activity) {
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        }

        protected static void removeJavascriptInterface(WebView webView, String string) {
            webView.removeJavascriptInterface(string);
        }
    }

    @TargetApi(value=17)
    private static class JellyBeanMR1TargetUtils {
        private JellyBeanMR1TargetUtils() {
        }

        public static void setMediaPlaybackRequiresUserGesture(WebSettings webSettings, boolean bl) {
            webSettings.setMediaPlaybackRequiresUserGesture(bl);
        }
    }

    @TargetApi(value=16)
    private static class JellyBeanTargetUtils {
        private JellyBeanTargetUtils() {
        }

        public static void hideStatusBar(Activity activity) {
            activity.getWindow().getDecorView().setSystemUiVisibility(4);
        }

        public static void setBackgroundForLinerLayout(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        protected static void setImageButtonAlpha(ImageButton imageButton, int n) {
            imageButton.setImageAlpha(n);
        }
    }

    @TargetApi(value=19)
    private static class KitKatTargetUtils {
        private KitKatTargetUtils() {
        }

        public static void enableWebViewDebugging(final boolean bl) {
            ThreadUtils.executeOnMainThread(new Runnable(){

                public void run() {
                    WebView.setWebContentsDebuggingEnabled((boolean)bl);
                }
            });
        }

    }

}

