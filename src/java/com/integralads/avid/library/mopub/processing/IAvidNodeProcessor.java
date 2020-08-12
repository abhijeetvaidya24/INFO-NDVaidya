/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub.processing;

import android.view.View;
import org.json.JSONObject;

public interface IAvidNodeProcessor {
    public JSONObject getState(View var1);

    public void iterateChildren(View var1, JSONObject var2, IAvidViewWalker var3, boolean var4);

    public static interface IAvidViewWalker {
        public void walkView(View var1, IAvidNodeProcessor var2, JSONObject var3);
    }

}

