/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry
 *  com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
 *  com.integralads.avid.library.mopub.weakreference.AvidView
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 */
package com.integralads.avid.library.mopub.walking;

import android.view.View;
import android.view.ViewParent;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.ObstructionsWhiteList;
import com.integralads.avid.library.mopub.utils.AvidViewUtil;
import com.integralads.avid.library.mopub.walking.ViewType;
import com.integralads.avid.library.mopub.weakreference.AvidView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AvidAdViewCache {
    private final AvidAdSessionRegistry adSessionRegistry;
    private final HashMap<View, String> adViews = new HashMap();
    private final HashMap<View, ArrayList<String>> friendlyObstructions = new HashMap();
    private final HashSet<String> hiddenSessionIds = new HashSet();
    private boolean isAdViewProcessed;
    private final HashSet<View> rootViews = new HashSet();
    private final HashSet<String> visibleSessionIds = new HashSet();

    public AvidAdViewCache(AvidAdSessionRegistry avidAdSessionRegistry) {
        this.adSessionRegistry = avidAdSessionRegistry;
    }

    private void addFriendlyObstruction(View view, InternalAvidAdSession internalAvidAdSession) {
        ArrayList arrayList = (ArrayList)this.friendlyObstructions.get((Object)view);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.friendlyObstructions.put((Object)view, (Object)arrayList);
        }
        arrayList.add((Object)internalAvidAdSession.getAvidAdSessionId());
    }

    private boolean buildRootViews(View view) {
        if (!view.hasWindowFocus()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            if (AvidViewUtil.isViewVisible(view)) {
                hashSet.add((Object)view);
                ViewParent viewParent = view.getParent();
                if (viewParent instanceof View) {
                    view = (View)viewParent;
                    continue;
                }
                view = null;
                continue;
            }
            return false;
        }
        this.rootViews.addAll((Collection)hashSet);
        return true;
    }

    private void prepareFriendlyObstructions(InternalAvidAdSession internalAvidAdSession) {
        for (AvidView avidView : internalAvidAdSession.getObstructionsWhiteList().getWhiteList()) {
            if (avidView.isEmpty()) continue;
            this.addFriendlyObstruction((View)avidView.get(), internalAvidAdSession);
        }
    }

    public void cleanup() {
        this.adViews.clear();
        this.friendlyObstructions.clear();
        this.rootViews.clear();
        this.visibleSessionIds.clear();
        this.hiddenSessionIds.clear();
        this.isAdViewProcessed = false;
    }

    public ArrayList<String> getFriendlySessionIds(View view) {
        if (this.friendlyObstructions.size() == 0) {
            return null;
        }
        ArrayList arrayList = (ArrayList)this.friendlyObstructions.get((Object)view);
        if (arrayList != null) {
            this.friendlyObstructions.remove((Object)view);
            Collections.sort((List)arrayList);
        }
        return arrayList;
    }

    public HashSet<String> getHiddenSessionIds() {
        return this.hiddenSessionIds;
    }

    public String getSessionId(View view) {
        if (this.adViews.size() == 0) {
            return null;
        }
        String string = (String)this.adViews.get((Object)view);
        if (string != null) {
            this.adViews.remove((Object)view);
        }
        return string;
    }

    public ViewType getViewType(View view) {
        if (this.rootViews.contains((Object)view)) {
            return ViewType.ROOT_VIEW;
        }
        if (this.isAdViewProcessed) {
            return ViewType.OBSTRUCTION_VIEW;
        }
        return ViewType.UNDERLYING_VIEW;
    }

    public HashSet<String> getVisibleSessionIds() {
        return this.visibleSessionIds;
    }

    public void onAdViewProcessed() {
        this.isAdViewProcessed = true;
    }

    public void prepare() {
        for (InternalAvidAdSession internalAvidAdSession : this.adSessionRegistry.getInternalAvidAdSessions()) {
            View view = internalAvidAdSession.getView();
            if (!internalAvidAdSession.isActive() || view == null) continue;
            if (this.buildRootViews(view)) {
                this.visibleSessionIds.add((Object)internalAvidAdSession.getAvidAdSessionId());
                this.adViews.put((Object)view, (Object)internalAvidAdSession.getAvidAdSessionId());
                this.prepareFriendlyObstructions(internalAvidAdSession);
                continue;
            }
            this.hiddenSessionIds.add((Object)internalAvidAdSession.getAvidAdSessionId());
        }
    }
}

