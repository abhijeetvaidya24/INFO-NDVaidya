/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  android.view.View
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.integralads.avid.library.mopub.AvidTreeWalker;
import com.integralads.avid.library.mopub.processing.AvidProcessorFactory;
import com.integralads.avid.library.mopub.processing.IAvidNodeProcessor;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.integralads.avid.library.mopub.utils.AvidTimestamp;
import com.integralads.avid.library.mopub.utils.AvidViewUtil;
import com.integralads.avid.library.mopub.walking.AvidAdViewCache;
import com.integralads.avid.library.mopub.walking.AvidStatePublisher;
import com.integralads.avid.library.mopub.walking.ViewType;
import com.integralads.avid.library.mopub.walking.async.AvidAsyncTaskQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AvidTreeWalker
implements IAvidNodeProcessor.IAvidViewWalker {
    private static AvidTreeWalker avidTreeWalker = new AvidTreeWalker();
    private static TreeWalkerHandler handler;
    private static final Runnable viewTreeUpdaterRunnable;
    private AvidAdViewCache adViewCache = new AvidAdViewCache(AvidAdSessionRegistry.getInstance());
    private double endTime;
    private int objectsCount;
    private AvidProcessorFactory processorFactory = new AvidProcessorFactory();
    private double startTime;
    private AvidStatePublisher statePublisher = new AvidStatePublisher(AvidAdSessionRegistry.getInstance(), new AvidAsyncTaskQueue());
    private List<AvidTreeWalkerTimeLogger> timeLoggers = new ArrayList();

    static {
        viewTreeUpdaterRunnable = new Runnable(){

            public void run() {
                if (AvidTreeWalker.access$100() != null) {
                    AvidTreeWalker.access$100().sendEmptyMessage(0);
                    AvidTreeWalker.access$100().postDelayed(AvidTreeWalker.access$200(), 200L);
                }
            }
        };
    }

    static /* synthetic */ TreeWalkerHandler access$100() {
        return handler;
    }

    static /* synthetic */ Runnable access$200() {
        return viewTreeUpdaterRunnable;
    }

    private void afterWalk() {
        this.endTime = AvidTimestamp.getCurrentTime();
        this.notifyTimeLogger((long)(this.endTime - this.startTime));
    }

    private void beforeWalk() {
        this.objectsCount = 0;
        this.startTime = AvidTimestamp.getCurrentTime();
    }

    private void checkFriendlyObstruction(View view, JSONObject jSONObject) {
        ArrayList<String> arrayList = this.adViewCache.getFriendlySessionIds(view);
        if (arrayList != null) {
            AvidJSONUtil.addFriendlyObstruction(jSONObject, arrayList);
        }
    }

    public static AvidTreeWalker getInstance() {
        return avidTreeWalker;
    }

    private boolean handleAdView(View view, JSONObject jSONObject) {
        String string = this.adViewCache.getSessionId(view);
        if (string != null) {
            AvidJSONUtil.addAvidId(jSONObject, string);
            this.adViewCache.onAdViewProcessed();
            return true;
        }
        return false;
    }

    private void notifyTimeLogger(long l2) {
        if (this.timeLoggers.size() > 0) {
            Iterator iterator = this.timeLoggers.iterator();
            while (iterator.hasNext()) {
                (iterator.next()).onTreeProcessed(this.objectsCount, l2);
            }
        }
    }

    private void startTreeWalkerUpdater() {
        if (handler == null) {
            handler = new Handler(){

                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    AvidTreeWalker.getInstance().updateTreeState();
                }
            };
            handler.postDelayed(viewTreeUpdaterRunnable, 200L);
        }
    }

    private void stopTreeWalkerUpdater() {
        TreeWalkerHandler treeWalkerHandler = handler;
        if (treeWalkerHandler != null) {
            treeWalkerHandler.removeCallbacks(viewTreeUpdaterRunnable);
            handler = null;
        }
    }

    private void updateTreeState() {
        this.beforeWalk();
        this.doWalk();
        this.afterWalk();
    }

    private void walkViewChildren(View view, IAvidNodeProcessor iAvidNodeProcessor, JSONObject jSONObject, ViewType viewType) {
        boolean bl = viewType == ViewType.ROOT_VIEW;
        iAvidNodeProcessor.iterateChildren(view, jSONObject, this, bl);
    }

    public void addTimeLogger(AvidTreeWalkerTimeLogger avidTreeWalkerTimeLogger) {
        if (!this.timeLoggers.contains((Object)avidTreeWalkerTimeLogger)) {
            this.timeLoggers.add((Object)avidTreeWalkerTimeLogger);
        }
    }

    void doWalk() {
        this.adViewCache.prepare();
        double d2 = AvidTimestamp.getCurrentTime();
        IAvidNodeProcessor iAvidNodeProcessor = this.processorFactory.getRootProcessor();
        if (this.adViewCache.getHiddenSessionIds().size() > 0) {
            JSONObject jSONObject = iAvidNodeProcessor.getState(null);
            this.statePublisher.publishEmptyState(jSONObject, this.adViewCache.getHiddenSessionIds(), d2);
        }
        if (this.adViewCache.getVisibleSessionIds().size() > 0) {
            JSONObject jSONObject = iAvidNodeProcessor.getState(null);
            this.walkViewChildren(null, iAvidNodeProcessor, jSONObject, ViewType.ROOT_VIEW);
            AvidJSONUtil.fixStateFrame(jSONObject);
            this.statePublisher.publishState(jSONObject, this.adViewCache.getVisibleSessionIds(), d2);
        } else {
            this.statePublisher.cleanupCache();
        }
        this.adViewCache.cleanup();
    }

    public void pause() {
        this.stopTreeWalkerUpdater();
    }

    public void removeTimeLogger(AvidTreeWalkerTimeLogger avidTreeWalkerTimeLogger) {
        if (this.timeLoggers.contains((Object)avidTreeWalkerTimeLogger)) {
            this.timeLoggers.remove((Object)avidTreeWalkerTimeLogger);
        }
    }

    public void start() {
        this.startTreeWalkerUpdater();
        this.updateTreeState();
    }

    public void stop() {
        this.pause();
        this.timeLoggers.clear();
        this.statePublisher.cleanupCache();
    }

    @Override
    public void walkView(View view, IAvidNodeProcessor iAvidNodeProcessor, JSONObject jSONObject) {
        if (!AvidViewUtil.isViewVisible(view)) {
            return;
        }
        ViewType viewType = this.adViewCache.getViewType(view);
        if (viewType == ViewType.UNDERLYING_VIEW) {
            return;
        }
        JSONObject jSONObject2 = iAvidNodeProcessor.getState(view);
        AvidJSONUtil.addChildState(jSONObject, jSONObject2);
        if (!this.handleAdView(view, jSONObject2)) {
            this.checkFriendlyObstruction(view, jSONObject2);
            this.walkViewChildren(view, iAvidNodeProcessor, jSONObject2, viewType);
        }
        this.objectsCount = 1 + this.objectsCount;
    }

}

