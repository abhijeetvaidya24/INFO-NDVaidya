/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.webkit.JavascriptInterface
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub.session.internal.jsbridge;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import org.json.JSONObject;

public class AvidJavascriptInterface {
    public static final String AVID_OBJECT = "avid";
    private final InternalAvidAdSessionContext avidAdSessionContext;
    private AvidJavascriptInterfaceCallback callback;
    private final Handler handler = new Handler();

    public AvidJavascriptInterface(InternalAvidAdSessionContext internalAvidAdSessionContext) {
        this.avidAdSessionContext = internalAvidAdSessionContext;
    }

    @JavascriptInterface
    public String getAvidAdSessionContext() {
        this.handler.post((Runnable)new CallbackRunnable());
        return this.avidAdSessionContext.getStubContext().toString();
    }

    public AvidJavascriptInterfaceCallback getCallback() {
        return this.callback;
    }

    public void setCallback(AvidJavascriptInterfaceCallback avidJavascriptInterfaceCallback) {
        this.callback = avidJavascriptInterfaceCallback;
    }

    public static interface AvidJavascriptInterfaceCallback {
        public void onAvidAdSessionContextInvoked();
    }

    class CallbackRunnable
    implements Runnable {
        CallbackRunnable() {
        }

        public void run() {
            if (AvidJavascriptInterface.this.callback != null) {
                AvidJavascriptInterface.this.callback.onAvidAdSessionContextInvoked();
                AvidJavascriptInterface.this.callback = null;
            }
        }
    }

}

