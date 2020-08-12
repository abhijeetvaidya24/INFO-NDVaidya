/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 */
package com.moat.analytics.mobile.aer;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.aer.base.functional.a;
import com.moat.analytics.mobile.aer.bl;
import com.moat.analytics.mobile.aer.bn;
import com.moat.analytics.mobile.aer.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

class bm
implements bl {
    bm() {
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public a<WebView> a(ViewGroup viewGroup) {
        if (viewGroup instanceof WebView) {
            return a.a((WebView)viewGroup);
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add((Object)viewGroup);
        HashSet hashSet = new HashSet();
        int n2 = 0;
        block0 : do {
            WebView webView = null;
            block1 : do {
                if (!linkedList.isEmpty() && n2 < 100) {
                    ++n2;
                } else {
                    return a.b(webView);
                }
                Iterator<View> iterator = new bo((ViewGroup)linkedList.poll(), null).iterator();
                do {
                    ViewGroup viewGroup2;
                    if (!iterator.hasNext()) continue block1;
                    View view = (View)iterator.next();
                    if (view instanceof WebView) {
                        if (webView == null) {
                            webView = (WebView)view;
                        } else {
                            Log.e((String)"MoatWebViewHound", (String)"Ambiguous ad container: multiple WebViews reside within it.");
                            continue block0;
                        }
                    }
                    if (!(view instanceof ViewGroup) || hashSet.contains((Object)(viewGroup2 = (ViewGroup)view))) continue;
                    hashSet.add((Object)viewGroup2);
                    linkedList.add((Object)viewGroup2);
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
    }
}

