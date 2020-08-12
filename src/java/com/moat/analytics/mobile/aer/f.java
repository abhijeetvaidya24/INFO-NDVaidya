/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.media.AudioManager
 *  android.os.Handler
 *  android.util.Log
 *  android.view.View
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.aer;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.moat.analytics.mobile.aer.MoatAdEvent;
import com.moat.analytics.mobile.aer.MoatAdEventType;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.g;
import com.moat.analytics.mobile.aer.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

abstract class f<PlayerOrIMAAd> {
    protected static final MoatAdEventType[] b;
    protected boolean a;
    protected final Map<MoatAdEventType, Integer> c;
    protected final Handler d;
    protected Map<String, String> e;
    protected WeakReference<PlayerOrIMAAd> f;
    protected WeakReference<View> g;
    protected final com.moat.analytics.mobile.aer.a h;
    protected final al i;
    private boolean j;
    private WeakReference<Context> k;
    private z l;

    static {
        MoatAdEventType[] arrmoatAdEventType = new MoatAdEventType[]{MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};
        b = arrmoatAdEventType;
    }

    public f(String string, com.moat.analytics.mobile.aer.a a2, al al2) {
        this.i = al2;
        this.h = a2;
        this.a("Initializing.");
        this.l = new z(string, al2, a2);
        this.c = new HashMap();
        this.d = new Handler();
        this.k = new WeakReference((Object)a2.c());
        this.j = false;
        this.a = false;
    }

    private int a(AudioManager audioManager) {
        return audioManager.getStreamVolume(3);
    }

    private MoatAdEvent a(Map<String, Object> map) {
        MoatAdEventType moatAdEventType = MoatAdEventType.fromString((String)map.get((Object)"type"));
        Integer n2 = map.containsKey((Object)"playHead") ? (Integer)map.get((Object)"playHead") : MoatAdEvent.TIME_UNAVAILABLE;
        Double d2 = map.containsKey((Object)"adVolume") ? (Double)map.get((Object)"adVolume") : MoatAdEvent.VOLUME_UNAVAILABLE;
        return new MoatAdEvent(moatAdEventType, n2, d2);
    }

    static /* synthetic */ z a(f f2) {
        return f2.l;
    }

    static /* synthetic */ z a(f f2, z z2) {
        f2.l = z2;
        return z2;
    }

    private void b(MoatAdEvent moatAdEvent) {
        JSONObject jSONObject = this.a(moatAdEvent);
        Object[] arrobject = new Object[]{jSONObject.toString()};
        this.a(String.format((String)"Received event: %s", (Object[])arrobject));
        this.l.a(jSONObject);
        MoatAdEventType moatAdEventType = moatAdEvent.eventType;
        if (moatAdEventType == MoatAdEventType.AD_EVT_COMPLETE || moatAdEventType == MoatAdEventType.AD_EVT_STOPPED || moatAdEventType == MoatAdEventType.AD_EVT_SKIPPED) {
            this.c.put((Object)moatAdEventType, (Object)1);
            this.c();
        }
    }

    protected abstract Map<String, Object> a();

    /*
     * Exception decompiling
     */
    protected JSONObject a(MoatAdEvent var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl16 : NEW : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    protected void a(String string) {
        if (this.i.b() || this.a) {
            Log.d((String)"MoatVideoTracker", (String)string);
        }
    }

    protected boolean a(Integer n2, Integer n3) {
        int n4 = n3 - n2;
        double d2 = n3.intValue();
        Double.isNaN((double)d2);
        double d3 = Math.min((double)750.0, (double)(d2 * 0.05));
        return (double)n4 <= d3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(Map<String, String> map, PlayerOrIMAAd PlayerOrIMAAd, View view) {
        boolean bl2;
        boolean bl3;
        if (map == null) {
            try {
                this.a("trackVideoAd received null adIds object. Not tracking.");
                bl3 = false;
                break block9;
            }
            catch (Exception exception) {}
            a.a(exception);
            bl2 = false;
        } else {
            block9 : {
                bl3 = true;
            }
            if (view == null) {
                this.a("trackVideoAd received null video view instance");
            }
            if (PlayerOrIMAAd == null) {
                this.a("trackVideoAd received null ad instance. Not tracking.");
                bl3 = false;
            }
            if (bl3) {
                String string;
                Object[] arrobject = new Object[3];
                arrobject[0] = new JSONObject(map).toString();
                arrobject[1] = PlayerOrIMAAd.toString();
                if (view != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(view.getClass().getSimpleName());
                    stringBuilder.append("@");
                    stringBuilder.append(view.hashCode());
                    string = stringBuilder.toString();
                } else {
                    string = "null";
                }
                arrobject[2] = string;
                this.a(String.format((String)"trackVideoAd tracking ids: %s | ad: %s | view: %s", (Object[])arrobject));
                this.e = map;
                this.f = new WeakReference(PlayerOrIMAAd);
                this.g = new WeakReference((Object)view);
                this.b();
            }
            bl2 = bl3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attempt to start tracking ad was ");
        String string = bl2 ? "" : "un";
        stringBuilder.append(string);
        stringBuilder.append("successful.");
        this.a(stringBuilder.toString());
        return bl2;
    }

    protected void b() {
        Map<String, Object> map = this.a();
        Integer n2 = (Integer)map.get((Object)"width");
        Integer n3 = (Integer)map.get((Object)"height");
        Integer n4 = (Integer)map.get((Object)"duration");
        this.a(String.format((String)"Player metadata: height = %d, width = %d, duration = %d", (Object[])new Object[]{n3, n2, n4}));
        this.l.a((View)this.g.get(), this.e, n2, n3, n4);
    }

    protected void c() {
        if (!this.j) {
            g g2 = new g(this);
            this.d.postDelayed((Runnable)g2, 500L);
            this.j = true;
        }
    }

    public void changeTargetView(View view) {
        if (this.i.b()) {
            String string;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("changing view to ");
            if (view != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(view.getClass().getSimpleName());
                stringBuilder2.append("@");
                stringBuilder2.append(view.hashCode());
                string = stringBuilder2.toString();
            } else {
                string = "null";
            }
            stringBuilder.append(string);
            Log.d((String)"MoatVideoTracker", (String)stringBuilder.toString());
        }
        this.g = new WeakReference((Object)view);
        this.l.a(view);
    }

    protected double d() {
        AudioManager audioManager = (AudioManager)((Context)this.k.get()).getSystemService("audio");
        int n2 = this.a(audioManager);
        int n3 = audioManager.getStreamMaxVolume(3);
        double d2 = n2;
        double d3 = n3;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        return d2 / d3;
    }

    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        try {
            this.b(moatAdEvent);
            return;
        }
        catch (Exception exception) {
            a.a(exception);
            return;
        }
    }

    public void dispatchEvent(Map<String, Object> map) {
        try {
            this.b(this.a(map));
            return;
        }
        catch (Exception exception) {
            a.a(exception);
            return;
        }
    }

    protected boolean e() {
        return this.c.containsKey((Object)((Object)MoatAdEventType.AD_EVT_COMPLETE)) || this.c.containsKey((Object)((Object)MoatAdEventType.AD_EVT_STOPPED)) || this.c.containsKey((Object)((Object)MoatAdEventType.AD_EVT_SKIPPED));
        {
        }
    }

    public void setDebug(boolean bl2) {
        this.a = bl2;
    }
}

