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
package com.integralads.avid.library.adcolony;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.integralads.avid.library.adcolony.AvidTreeWalker;
import com.integralads.avid.library.adcolony.processing.AvidProcessorFactory;
import com.integralads.avid.library.adcolony.processing.IAvidNodeProcessor;
import com.integralads.avid.library.adcolony.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.adcolony.utils.AvidJSONUtil;
import com.integralads.avid.library.adcolony.utils.AvidTimestamp;
import com.integralads.avid.library.adcolony.utils.AvidViewUtil;
import com.integralads.avid.library.adcolony.walking.AvidAdViewCache;
import com.integralads.avid.library.adcolony.walking.AvidStatePublisher;
import com.integralads.avid.library.adcolony.walking.ViewType;
import com.integralads.avid.library.adcolony.walking.async.AvidAsyncTaskQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AvidTreeWalker
implements IAvidNodeProcessor.IAvidViewWalker {
    private static AvidTreeWalker b = new AvidTreeWalker();
    private static a c;
    private static final Runnable k;
    private List<AvidTreeWalkerTimeLogger> d = new ArrayList();
    private int e;
    private AvidProcessorFactory f = new AvidProcessorFactory();
    private AvidAdViewCache g = new AvidAdViewCache(AvidAdSessionRegistry.getInstance());
    private AvidStatePublisher h = new AvidStatePublisher(AvidAdSessionRegistry.getInstance(), new AvidAsyncTaskQueue());
    private double i;
    private double j;

    static {
        k = new Runnable(){

            public void run() {
                if (AvidTreeWalker.b() != null) {
                    AvidTreeWalker.b().sendEmptyMessage(0);
                    AvidTreeWalker.b().postDelayed(AvidTreeWalker.c(), 200L);
                }
            }
        };
    }

    private void a(long l2) {
        if (this.d.size() > 0) {
            Iterator iterator = this.d.iterator();
            while (iterator.hasNext()) {
                (iterator.next()).onTreeProcessed(this.e, l2);
            }
        }
    }

    private void a(View view, IAvidNodeProcessor iAvidNodeProcessor, JSONObject jSONObject, ViewType viewType) {
        boolean bl = viewType == ViewType.ROOT_VIEW;
        iAvidNodeProcessor.iterateChildren(view, jSONObject, this, bl);
    }

    private boolean a(View view, JSONObject jSONObject) {
        String string = this.g.getSessionId(view);
        if (string != null) {
            AvidJSONUtil.addAvidId(jSONObject, string);
            this.g.onAdViewProcessed();
            return true;
        }
        return false;
    }

    static /* synthetic */ a b() {
        return c;
    }

    private void b(View view, JSONObject jSONObject) {
        ArrayList<String> arrayList = this.g.getFriendlySessionIds(view);
        if (arrayList != null) {
            AvidJSONUtil.addFriendlyObstruction(jSONObject, arrayList);
        }
    }

    static /* synthetic */ Runnable c() {
        return k;
    }

    private void d() {
        this.e();
        this.a();
        this.f();
    }

    private void e() {
        this.e = 0;
        this.i = AvidTimestamp.getCurrentTime();
    }

    private void f() {
        this.j = AvidTimestamp.getCurrentTime();
        this.a((long)(this.j - this.i));
    }

    private void g() {
        if (c == null) {
            c = new Handler(){

                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    AvidTreeWalker.getInstance().d();
                }
            };
            c.postDelayed(k, 200L);
        }
    }

    public static AvidTreeWalker getInstance() {
        return b;
    }

    private void h() {
        a a2 = c;
        if (a2 != null) {
            a2.removeCallbacks(k);
            c = null;
        }
    }

    void a() {
        this.g.prepare();
        double d2 = AvidTimestamp.getCurrentTime();
        IAvidNodeProcessor iAvidNodeProcessor = this.f.getRootProcessor();
        if (this.g.getHiddenSessionIds().size() > 0) {
            JSONObject jSONObject = iAvidNodeProcessor.getState(null);
            this.h.publishEmptyState(jSONObject, this.g.getHiddenSessionIds(), d2);
        }
        if (this.g.getVisibleSessionIds().size() > 0) {
            JSONObject jSONObject = iAvidNodeProcessor.getState(null);
            this.a(null, iAvidNodeProcessor, jSONObject, ViewType.ROOT_VIEW);
            AvidJSONUtil.fixStateFrame(jSONObject);
            this.h.publishState(jSONObject, this.g.getVisibleSessionIds(), d2);
        } else {
            this.h.cleanupCache();
        }
        this.g.cleanup();
    }

    public void pause() {
        this.h();
    }

    public void start() {
        this.g();
        this.d();
    }

    public void stop() {
        this.pause();
        this.d.clear();
        this.h.cleanupCache();
    }

    @Override
    public void walkView(View view, IAvidNodeProcessor iAvidNodeProcessor, JSONObject jSONObject) {
        if (!AvidViewUtil.isViewVisible(view)) {
            return;
        }
        ViewType viewType = this.g.getViewType(view);
        if (viewType == ViewType.UNDERLYING_VIEW) {
            return;
        }
        JSONObject jSONObject2 = iAvidNodeProcessor.getState(view);
        AvidJSONUtil.addChildState(jSONObject, jSONObject2);
        if (!this.a(view, jSONObject2)) {
            this.b(view, jSONObject2);
            this.a(view, iAvidNodeProcessor, jSONObject2, viewType);
        }
        this.e = 1 + this.e;
    }

}

