/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.integralads.avid.library.adcolony.weakreference.AvidView
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.integralads.avid.library.adcolony.session.internal;

import android.view.View;
import com.integralads.avid.library.adcolony.weakreference.AvidView;
import java.util.ArrayList;

public class ObstructionsWhiteList {
    private final ArrayList<AvidView> a = new ArrayList();

    public void add(View view) {
        this.a.add((Object)new AvidView(view));
    }

    public ArrayList<AvidView> getWhiteList() {
        return this.a;
    }
}

