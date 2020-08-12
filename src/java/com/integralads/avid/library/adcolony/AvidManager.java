/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 */
package com.integralads.avid.library.adcolony;

import android.app.Activity;
import android.content.Context;
import com.integralads.avid.library.adcolony.AvidBridge;
import com.integralads.avid.library.adcolony.AvidLoader;
import com.integralads.avid.library.adcolony.AvidStateWatcher;
import com.integralads.avid.library.adcolony.AvidTreeWalker;
import com.integralads.avid.library.adcolony.activity.AvidActivityStack;
import com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistryListener;
import com.integralads.avid.library.adcolony.session.AbstractAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.adcolony.utils.AvidJSONUtil;
import java.util.Collection;
import java.util.Iterator;

public class AvidManager
implements AvidLoader.AvidLoaderListener,
AvidStateWatcher.AvidStateWatcherListener,
AvidAdSessionRegistryListener {
    private static AvidManager a = new AvidManager();
    private static Context b;

    private void a() {
        AvidStateWatcher.getInstance().setStateWatcherListener(this);
        AvidStateWatcher.getInstance().start();
        if (AvidStateWatcher.getInstance().isActive()) {
            AvidTreeWalker.getInstance().start();
        }
    }

    private void b() {
        AvidActivityStack.getInstance().cleanup();
        AvidTreeWalker.getInstance().stop();
        AvidStateWatcher.getInstance().stop();
        AvidLoader.getInstance().unregisterAvidLoader();
        b = null;
    }

    private boolean c() {
        return true ^ AvidAdSessionRegistry.getInstance().isEmpty();
    }

    private void d() {
        AvidAdSessionRegistry.getInstance().setListener(null);
        Iterator iterator = AvidAdSessionRegistry.getInstance().getInternalAvidAdSessions().iterator();
        while (iterator.hasNext()) {
            ((InternalAvidAdSession)iterator.next()).getAvidBridgeManager().onAvidJsReady();
        }
        AvidAdSessionRegistry.getInstance().setListener(this);
    }

    public static AvidManager getInstance() {
        return a;
    }

    public InternalAvidAdSession findInternalAvidAdSessionById(String string) {
        return AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionById(string);
    }

    public void init(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
            AvidStateWatcher.getInstance().init(b);
            AvidAdSessionRegistry.getInstance().setListener(this);
            AvidJSONUtil.init(b);
        }
    }

    @Override
    public void onAppStateChanged(boolean bl) {
        if (bl) {
            AvidTreeWalker.getInstance().start();
            return;
        }
        AvidTreeWalker.getInstance().pause();
    }

    @Override
    public void onAvidLoaded() {
        if (this.c()) {
            this.d();
            if (AvidAdSessionRegistry.getInstance().hasActiveSessions()) {
                this.a();
            }
        }
    }

    public void registerActivity(Activity activity) {
        AvidActivityStack.getInstance().addActivity(activity);
    }

    public void registerAvidAdSession(AbstractAvidAdSession abstractAvidAdSession, InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistry.getInstance().registerAvidAdSession(abstractAvidAdSession, internalAvidAdSession);
    }

    @Override
    public void registryHasActiveSessionsChanged(AvidAdSessionRegistry avidAdSessionRegistry) {
        if (avidAdSessionRegistry.hasActiveSessions() && AvidBridge.isAvidJsReady()) {
            this.a();
            return;
        }
        this.b();
    }

    @Override
    public void registryHasSessionsChanged(AvidAdSessionRegistry avidAdSessionRegistry) {
        if (avidAdSessionRegistry.isEmpty()) {
            return;
        }
        if (!AvidBridge.isAvidJsReady()) {
            AvidLoader.getInstance().setListener(this);
            AvidLoader.getInstance().registerAvidLoader(b);
        }
    }
}

