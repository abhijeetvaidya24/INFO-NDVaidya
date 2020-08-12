/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.UUID
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.aerserv.sdk.view.component;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.aerserv.sdk.AerServConfig;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServTransactionInformation;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.PlayPauseListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MoatUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.aerserv.sdk.view.View;
import com.aerserv.sdk.view.ViewLocator;
import com.aerserv.sdk.view.component.ASWebView;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class ASWebView
extends WebView
implements View {
    protected static final String BODY = "<body style='margin:0;padding:0;position:relative;'>";
    private static final String LOG_TAG = "com.aerserv.sdk.view.component.ASWebView";
    private static final int RENDER_WAIT_INTERVAL = 500;
    private static final String TAG = "AS";
    public final String VIEW_ID = UUID.randomUUID().toString();
    private int callCounter = 0;
    private String controllerId;
    private AtomicBoolean isAdDetected = new AtomicBoolean(false);
    private final Object monitor = new Object();
    private PlayPauseListener playPauseListener;
    private ProviderListener providerListener = null;
    private Long showAdTimeout;
    private AerServTransactionInformation transactionInformation;

    public ASWebView(Context context, String string, Long l2, AerServTransactionInformation aerServTransactionInformation) {
        super(context);
        this.controllerId = string;
        this.showAdTimeout = l2;
        this.transactionInformation = aerServTransactionInformation;
        if (context instanceof Activity) {
            MoatUtils.createTracker(string, (Activity)context, (android.view.View)this);
        }
        this.setup();
    }

    static /* synthetic */ Long access$000(ASWebView aSWebView) {
        return aSWebView.showAdTimeout;
    }

    static /* synthetic */ AtomicBoolean access$100(ASWebView aSWebView) {
        return aSWebView.isAdDetected;
    }

    static /* synthetic */ String access$200() {
        return LOG_TAG;
    }

    static /* synthetic */ ProviderListener access$300(ASWebView aSWebView) {
        return aSWebView.providerListener;
    }

    static /* synthetic */ AerServTransactionInformation access$500(ASWebView aSWebView) {
        return aSWebView.transactionInformation;
    }

    private void bitMapTest() {
        if (this.providerListener == null) {
            return;
        }
        AerServLog.d(LOG_TAG, "running bitmap test");
        this.isAdDetected.set(false);
        this.setDrawingCacheEnabled(true);
        this.buildDrawingCache();
        new Thread(new Runnable(this, this){
            final /* synthetic */ ASWebView this$0;
            final /* synthetic */ ASWebView val$self;
            {
                this.this$0 = aSWebView;
                this.val$self = aSWebView2;
            }

            /*
             * Exception decompiling
             */
            public void run(}
        java.lang.IllegalStateException: Parameters not created
        
        