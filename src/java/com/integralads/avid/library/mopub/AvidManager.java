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
package com.integralads.avid.library.mopub;

import android.app.Activity;
import android.content.Context;
import com.integralads.avid.library.mopub.AvidBridge;
import com.integralads.avid.library.mopub.AvidLoader;
import com.integralads.avid.library.mopub.AvidStateWatcher;
import com.integralads.avid.library.mopub.AvidTreeWalker;
import com.integralads.avid.library.mopub.activity.AvidActivityStack;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistryListener;
import com.integralads.avid.library.mopub.session.AbstractAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.util.Collection;
import java.util.Iterator;

public class AvidManager
implements AvidLoader.AvidLoaderListener,
AvidStateWatcher.AvidStateWatcherListener,
AvidAdSessionRegistryListener {
    private static AvidManager avidManagerInstance = new AvidManager();
    private static Context context;

    public static AvidManager getInstance() {
        return avidManagerInstance;
    }

    private boolean isActive() {
        return true ^ AvidAdSessionRegistry.getInstance().isEmpty();
    }

    private void notifyAvidReady() {
        AvidAdSessionRegistry.getInstance().setListener(null);
        Iterator iterator = AvidAdSessionRegistry.getInstance().getInternalAvidAdSessions().iterator();
        while (iterator.hasNext()) {
            ((InternalAvidAdSession)iterator.next()).getAvidBridgeManager().onAvidJsReady();
        }
        AvidAdSessionRegistry.getInstance().setListener(this);
    }

    private void start() {
        AvidStateWatcher.getInstance().setStateWatcherListener(this);
        AvidStateWatcher.getInstance().start();
        if (AvidStateWatcher.getInstance().isActive()) {
            AvidTreeWalker.getInstance().start();
        }
    }

    private void stop() {
        AvidActivityStack.getInstance().cleanup();
        AvidTreeWalker.getInstance().stop();
        AvidStateWatcher.getInstance().stop();
        AvidLoader.getInstance().unregisterAvidLoader();
        context = null;
    }

    public AbstractAvidAdSession findAvidAdSessionById(String string) {
        return AvidAdSessionRegistry.getInstance().findAvidAdSessionById(string);
    }

    public InternalAvidAdSession findInternalAvidAdSessionById(String string) {
        return AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionById(string);
    }

    public void init(Context context) {
        if (AvidManager.context == null) {
            AvidManager.context = context.getApplicationContext();
            AvidStateWatcher.getInstance().init(AvidManager.context);
            AvidAdSessionRegistry.getInstance().setListener(this);
            AvidJSONUtil.init(AvidManager.context);
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
        if (this.isActive()) {
            this.notifyAvidReady();
            if (AvidAdSessionRegistry.getInstance().hasActiveSessions()) {
                this.start();
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
            this.start();
            return;
        }
        this.stop();
    }

    @Override
    public void registryHasSessionsChanged(AvidAdSessionRegistry avidAdSessionRegistry) {
        if (avidAdSessionRegistry.isEmpty()) {
            return;
        }
        if (!AvidBridge.isAvidJsReady()) {
            AvidLoader.getInstance().setListener(this);
            AvidLoader.getInstance().registerAvidLoader(context);
        }
    }
}

