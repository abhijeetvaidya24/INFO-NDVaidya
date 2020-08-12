/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.net.Uri
 *  android.util.Log
 *  android.view.View
 *  android.webkit.ConsoleMessage
 *  android.webkit.GeolocationPermissions
 *  android.webkit.GeolocationPermissions$Callback
 *  android.webkit.JsResult
 *  android.webkit.PermissionRequest
 *  android.webkit.ValueCallback
 *  android.webkit.WebChromeClient
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.webkit.WebChromeClient$FileChooserParams
 *  android.webkit.WebView
 *  androidx.core.app.ActivityCompat
 *  androidx.core.content.ContextCompat
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  com.appsgeyser.multiTabApp.controllers.WebContentController
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.browser;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.controllers.WebContentController;
import com.appsgeyser.multiTabApp.ui.dialog.SimpleDialogs;

public class BrowserWebChromeClient
extends WebChromeClient {
    public static final String WEB_VIEW_LOG_PREFIX = "webConsoleMessage";
    private WebContentController _webController;

    public BrowserWebChromeClient(WebContentController webContentController) {
        this._webController = webContentController;
    }

    private void askForPermission(String string2, String string3, int n2) {
        if (ContextCompat.checkSelfPermission((Context)Factory.getInstance().getMainNavigationActivity(), (String)string3) != 0) {
            ActivityCompat.requestPermissions((Activity)Factory.getInstance().getMainNavigationActivity(), (String[])new String[]{string3}, (int)n2);
        }
    }

    public View getVideoLoadingProgressView() {
        return Factory.getInstance().getMainNavigationActivity().getVideoLoadingProgressView();
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Object[] arrobject = new Object[]{consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId()};
        Log.d((String)WEB_VIEW_LOG_PREFIX, (String)String.format((String)"%s @ %d: %s", (Object[])arrobject));
        return true;
    }

    public void onGeolocationPermissionsShowPrompt(String string2, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(string2, callback);
        callback.invoke(string2, true, true);
    }

    public void onHideCustomView() {
        super.onHideCustomView();
        Factory.getInstance().getMainNavigationActivity().onHideCustomView();
    }

    public boolean onJsConfirm(WebView webView, String string2, String string3, final JsResult jsResult) {
        SimpleDialogs.createConfirmDialog(Factory.getInstance().getMainNavigationActivity().getConfig().getWidgetName(), string3, webView.getContext(), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                jsResult.confirm();
            }
        }, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                jsResult.cancel();
            }
        }).show();
        return true;
    }

    public void onPermissionRequest(final PermissionRequest permissionRequest) {
        Factory.getInstance().getMainNavigationActivity().runOnUiThread(new Runnable(){

            @TargetApi(value=21)
            public void run() {
                for (String string2 : permissionRequest.getResources()) {
                    int n2 = -1;
                    int n3 = string2.hashCode();
                    if (n3 != -1660821873) {
                        if (n3 == 968612586 && string2.equals((Object)"android.webkit.resource.AUDIO_CAPTURE")) {
                            n2 = 0;
                        }
                    } else if (string2.equals((Object)"android.webkit.resource.VIDEO_CAPTURE")) {
                        n2 = 1;
                    }
                    if (n2 != 0) {
                        if (n2 != 1) continue;
                        BrowserWebChromeClient.this.askForPermission(permissionRequest.getOrigin().toString(), "android.permission.CAMERA", 776);
                        continue;
                    }
                    BrowserWebChromeClient.this.askForPermission(permissionRequest.getOrigin().toString(), "android.permission.RECORD_AUDIO", 777);
                }
                PermissionRequest permissionRequest2 = permissionRequest;
                permissionRequest2.grant(permissionRequest2.getResources());
            }
        });
    }

    public void onProgressChanged(WebView webView, int n2) {
        this._webController.setProgressBarState(n2);
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
        Factory.getInstance().getMainNavigationActivity().onShowCustomView(view, customViewCallback);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return Factory.getInstance().getMainNavigationActivity().openFileChooser(webView, valueCallback, fileChooserParams);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        this.openFileChooser(valueCallback, "");
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String string2) {
        Factory.getInstance().getMainNavigationActivity().openFileChooser(valueCallback, string2);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String string2, String string3) {
        this.openFileChooser(valueCallback, string2);
    }

}

