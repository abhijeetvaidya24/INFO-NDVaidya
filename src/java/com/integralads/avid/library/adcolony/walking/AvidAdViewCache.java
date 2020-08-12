/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistry
 *  com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession
 *  com.integralads.avid.library.adcolony.weakreference.AvidView
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 */
package com.integralads.avid.library.adcolony.walking;

import android.view.View;
import android.view.ViewParent;
import com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.ObstructionsWhiteList;
import com.integralads.avid.library.adcolony.utils.AvidViewUtil;
import com.integralads.avid.library.adcolony.walking.ViewType;
import com.integralads.avid.library.adcolony.weakreference.AvidView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AvidAdViewCache {
    private final AvidAdSessionRegistry a;
    private final HashMap<View, String> b = new HashMap();
    private final HashMap<View, ArrayList<String>> c = new HashMap();
    private final HashSet<View> d = new HashSet();
    private final HashSet<String> e = new HashSet();
    private final HashSet<String> f = new HashSet();
    private boolean g;

    public AvidAdViewCache(AvidAdSessionRegistry avidAdSessionRegistry) {
        this.a = avidAdSessionRegistry;
    }

    private void a(View view, InternalAvidAdSession internalAvidAdSession) {
        ArrayList arrayList = (ArrayList)this.c.get((Object)view);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.c.put((Object)view, (Object)arrayList);
        }
        arrayList.add((Object)internalAvidAdSession.getAvidAdSessionId());
    }

    private void a(InternalAvidAdSession internalAvidAdSession) {
        for (AvidView avidView : internalAvidAdSession.getObstructionsWhiteList().getWhiteList()) {
            if (avidView.isEmpty()) continue;
            this.a((View)avidView.get(), internalAvidAdSession);
        }
    }

    private boolean a(View view) {
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
        this.d.addAll((Collection)hashSet);
        return true;
    }

    public void cleanup() {
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g = false;
    }

    public ArrayList<String> getFriendlySessionIds(View view) {
        if (this.c.size() == 0) {
            return null;
        }
        ArrayList arrayList = (ArrayList)this.c.get((Object)view);
        if (arrayList != null) {
            this.c.remove((Object)view);
            Collections.sort((List)arrayList);
        }
        return arrayList;
    }

    public HashSet<String> getHiddenSessionIds() {
        return this.f;
    }

    public String getSessionId(View view) {
        if (this.b.size() == 0) {
            return null;
        }
        String string = (String)this.b.get((Object)view);
        if (string != null) {
            this.b.remove((Object)view);
        }
        return string;
    }

    public ViewType getViewType(View view) {
        if (this.d.contains((Object)view)) {
            return ViewType.ROOT_VIEW;
        }
        if (this.g) {
            return ViewType.OBSTRUCTION_VIEW;
        }
        return ViewType.UNDERLYING_VIEW;
    }

    public HashSet<String> getVisibleSessionIds() {
        return this.e;
    }

    public void onAdViewProcessed() {
        this.g = true;
    }

    public void prepare() {
        for (InternalAvidAdSession internalAvidAdSession : this.a.getInternalAvidAdSessions()) {
            View view = internalAvidAdSession.getView();
            if (!internalAvidAdSession.isActive() || view == null) continue;
            if (this.a(view)) {
                this.e.add((Object)internalAvidAdSession.getAvidAdSessionId());
                this.b.put((Object)view, (Object)internalAvidAdSession.getAvidAdSessionId());
                this.a(internalAvidAdSession);
                continue;
            }
            this.f.add((Object)internalAvidAdSession.getAvidAdSessionId());
        }
    }
}

