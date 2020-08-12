/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.integralads.avid.library.adcolony.processing;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.integralads.avid.library.adcolony.processing.IAvidNodeProcessor;
import com.integralads.avid.library.adcolony.utils.AvidJSONUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class AvidViewProcessor
implements IAvidNodeProcessor {
    private final int[] a = new int[2];

    private void a(ViewGroup viewGroup, JSONObject jSONObject, IAvidNodeProcessor.IAvidViewWalker iAvidViewWalker) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); ++i2) {
            iAvidViewWalker.walkView(viewGroup.getChildAt(i2), this, jSONObject);
        }
    }

    @TargetApi(value=21)
    private void b(ViewGroup viewGroup, JSONObject jSONObject, IAvidNodeProcessor.IAvidViewWalker iAvidViewWalker) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < viewGroup.getChildCount(); ++i2) {
            View view = viewGroup.getChildAt(i2);
            ArrayList arrayList = (ArrayList)hashMap.get((Object)Float.valueOf((float)view.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put((Object)Float.valueOf((float)view.getZ()), (Object)arrayList);
            }
            arrayList.add((Object)view);
        }
        ArrayList arrayList = new ArrayList((Collection)hashMap.keySet());
        Collections.sort((List)arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Iterator iterator2 = ((ArrayList)hashMap.get((Object)((Float)iterator.next()))).iterator();
            while (iterator2.hasNext()) {
                iAvidViewWalker.walkView((View)iterator2.next(), this, jSONObject);
            }
        }
    }

    @Override
    public JSONObject getState(View view) {
        int n2 = view.getWidth();
        int n3 = view.getHeight();
        view.getLocationOnScreen(this.a);
        int[] arrn = this.a;
        return AvidJSONUtil.getViewState(arrn[0], arrn[1], n2, n3);
    }

    @Override
    public void iterateChildren(View view, JSONObject jSONObject, IAvidNodeProcessor.IAvidViewWalker iAvidViewWalker, boolean bl) {
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup)view;
        if (bl && Build.VERSION.SDK_INT >= 21) {
            this.b(viewGroup, jSONObject, iAvidViewWalker);
            return;
        }
        this.a(viewGroup, jSONObject, iAvidViewWalker);
    }
}

