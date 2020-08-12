/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.integralads.avid.library.mopub.AvidManager
 *  com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry
 *  com.integralads.avid.library.mopub.session.AvidDisplayAdSession
 *  com.integralads.avid.library.mopub.session.AvidManagedDisplayAdSession
 *  com.integralads.avid.library.mopub.session.AvidManagedVideoAdSession
 *  com.integralads.avid.library.mopub.session.AvidVideoAdSession
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidDisplayAdSession
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidManagedDisplayAdSession
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidManagedVideoAdSession
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidVideoAdSession
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.AvidContext;
import com.integralads.avid.library.mopub.AvidManager;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.AbstractAvidAdSession;
import com.integralads.avid.library.mopub.session.AvidDisplayAdSession;
import com.integralads.avid.library.mopub.session.AvidManagedDisplayAdSession;
import com.integralads.avid.library.mopub.session.AvidManagedVideoAdSession;
import com.integralads.avid.library.mopub.session.AvidVideoAdSession;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidDisplayAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidManagedDisplayAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidManagedVideoAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidVideoAdSession;

public class AvidAdSessionManager {
    public static <T extends AbstractAvidAdSession> T findAvidAdSessionById(String string) {
        return (T)AvidManager.getInstance().findAvidAdSessionById(string);
    }

    private static WebView findWebView(View view) {
        InternalAvidAdSession internalAvidAdSession = AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionByView(view);
        if (internalAvidAdSession != null) {
            return internalAvidAdSession.getWebView();
        }
        return null;
    }

    public static String getReleaseDate() {
        return AvidContext.getInstance().getAvidReleaseDate();
    }

    public static String getVersion() {
        return AvidContext.getInstance().getAvidVersion();
    }

    public static AvidDisplayAdSession startAvidDisplayAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidDisplayAdSession avidDisplayAdSession = new AvidDisplayAdSession();
        InternalAvidDisplayAdSession internalAvidDisplayAdSession = new InternalAvidDisplayAdSession(context, avidDisplayAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidDisplayAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession((AbstractAvidAdSession)avidDisplayAdSession, (InternalAvidAdSession)internalAvidDisplayAdSession);
        return avidDisplayAdSession;
    }

    public static AvidManagedDisplayAdSession startAvidManagedDisplayAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidManagedDisplayAdSession avidManagedDisplayAdSession = new AvidManagedDisplayAdSession();
        InternalAvidManagedDisplayAdSession internalAvidManagedDisplayAdSession = new InternalAvidManagedDisplayAdSession(context, avidManagedDisplayAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidManagedDisplayAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession((AbstractAvidAdSession)avidManagedDisplayAdSession, (InternalAvidAdSession)internalAvidManagedDisplayAdSession);
        return avidManagedDisplayAdSession;
    }

    public static AvidManagedVideoAdSession startAvidManagedVideoAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidManagedVideoAdSession avidManagedVideoAdSession = new AvidManagedVideoAdSession();
        InternalAvidManagedVideoAdSession internalAvidManagedVideoAdSession = new InternalAvidManagedVideoAdSession(context, avidManagedVideoAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidManagedVideoAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession((AbstractAvidAdSession)avidManagedVideoAdSession, (InternalAvidAdSession)internalAvidManagedVideoAdSession);
        return avidManagedVideoAdSession;
    }

    public static AvidVideoAdSession startAvidVideoAdSession(Context context, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        AvidManager.getInstance().init(context);
        AvidVideoAdSession avidVideoAdSession = new AvidVideoAdSession();
        InternalAvidVideoAdSession internalAvidVideoAdSession = new InternalAvidVideoAdSession(context, avidVideoAdSession.getAvidAdSessionId(), externalAvidAdSessionContext);
        internalAvidVideoAdSession.onStart();
        AvidManager.getInstance().registerAvidAdSession((AbstractAvidAdSession)avidVideoAdSession, (InternalAvidAdSession)internalAvidVideoAdSession);
        return avidVideoAdSession;
    }

    public static WebView webViewForSessionId(String string) {
        InternalAvidAdSession internalAvidAdSession = AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionById(string);
        if (internalAvidAdSession != null) {
            return internalAvidAdSession.getWebView();
        }
        return null;
    }

    public static WebView webViewForView(View view) {
        WebView webView = AvidAdSessionManager.findWebView(view);
        if (webView != null) {
            return webView;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup)view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); ++i2) {
            webView = AvidAdSessionManager.webViewForView(viewGroup.getChildAt(i2));
            if (webView == null) continue;
            return webView;
        }
        return webView;
    }
}

