/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.integralads.avid.library.mopub.weakreference.AvidView
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.integralads.avid.library.mopub.session.internal;

import android.view.View;
import com.integralads.avid.library.mopub.weakreference.AvidView;
import java.util.ArrayList;
import java.util.Iterator;

public class ObstructionsWhiteList {
    private final ArrayList<AvidView> whiteList = new ArrayList();

    public void add(View view) {
        this.whiteList.add((Object)new AvidView(view));
    }

    public boolean contains(View view) {
        Iterator iterator = this.whiteList.iterator();
        while (iterator.hasNext()) {
            if (!((AvidView)iterator.next()).contains((Object)view)) continue;
            return true;
        }
        return false;
    }

    public ArrayList<AvidView> getWhiteList() {
        return this.whiteList;
    }
}

