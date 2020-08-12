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
package com.integralads.avid.library.adcolony.session.internal.jsbridge;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSessionContext;
import org.json.JSONObject;

public class AvidJavascriptInterface {
    private final InternalAvidAdSessionContext a;
    private final Handler b = new Handler();
    private AvidJavascriptInterfaceCallback c;

    public AvidJavascriptInterface(InternalAvidAdSessionContext internalAvidAdSessionContext) {
        this.a = internalAvidAdSessionContext;
    }

    @JavascriptInterface
    public String getAvidAdSessionContext() {
        this.b.post((Runnable)new a());
        return this.a.getStubContext().toString();
    }

    public void setCallback(AvidJavascriptInterfaceCallback avidJavascriptInterfaceCallback) {
        this.c = avidJavascriptInterfaceCallback;
    }

    public static interface AvidJavascriptInterfaceCallback {
        public void onAvidAdSessionContextInvoked();
    }

    class a
    implements Runnable {
        a() {
        }

        public void run() {
            if (AvidJavascriptInterface.this.c != null) {
                AvidJavascriptInterface.this.c.onAvidAdSessionContextInvoked();
                AvidJavascriptInterface.this.c = null;
            }
        }
    }

}

