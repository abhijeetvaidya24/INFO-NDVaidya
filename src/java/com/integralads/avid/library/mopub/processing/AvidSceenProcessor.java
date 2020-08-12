/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONObject
 */
package com.integralads.avid.library.mopub.processing;

import android.view.View;
import com.integralads.avid.library.mopub.activity.AvidActivityStack;
import com.integralads.avid.library.mopub.processing.IAvidNodeProcessor;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AvidSceenProcessor
implements IAvidNodeProcessor {
    private final IAvidNodeProcessor childrenProcessor;

    public AvidSceenProcessor(IAvidNodeProcessor iAvidNodeProcessor) {
        this.childrenProcessor = iAvidNodeProcessor;
    }

    @Override
    public JSONObject getState(View view) {
        return AvidJSONUtil.getViewState(0, 0, 0, 0);
    }

    @Override
    public void iterateChildren(View view, JSONObject jSONObject, IAvidNodeProcessor.IAvidViewWalker iAvidViewWalker, boolean bl) {
        Iterator iterator = AvidActivityStack.getInstance().getRootViews().iterator();
        while (iterator.hasNext()) {
            iAvidViewWalker.walkView((View)iterator.next(), this.childrenProcessor, jSONObject);
        }
    }
}

