/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  com.appnext.core.a.b
 *  com.appnext.core.c
 *  com.appnext.core.callbacks.OnAdClicked
 *  com.appnext.core.callbacks.OnAdClosed
 *  com.appnext.core.callbacks.OnAdError
 *  com.appnext.core.callbacks.OnAdLoaded
 *  com.appnext.core.callbacks.OnAdOpened
 *  com.appnext.core.callbacks.OnECPMLoaded
 *  com.appnext.core.f
 *  com.appnext.core.j
 *  java.io.UnsupportedEncodingException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.net.URLDecoder
 *  java.net.URLEncoder
 */
package com.appnext.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.appnext.base.Appnext;
import com.appnext.core.a.b;
import com.appnext.core.c;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnAdOpened;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.f;
import com.appnext.core.j;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public abstract class Ad {
    public static final String ORIENTATION_AUTO = "automatic";
    public static final String ORIENTATION_DEFAULT = "not_set";
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    protected static boolean fq;
    private OnAdOpened adOpenedCallback;
    private c adRequest;
    private String cat = "";
    private OnAdClosed closeCallback;
    private int cnt = 50;
    protected Context context;
    private int maxVideoLength = 0;
    private int minVideoLength = 0;
    private boolean mute = false;
    private OnAdClicked onAdClicked;
    private OnAdError onAdError;
    private OnAdLoaded onAdLoaded;
    private String orientation = "not_set";
    private String pbk = "";
    private String placementID = "";
    private String sessionId = "";
    protected boolean setMute = false;

    public Ad(final Context context, String string2) {
        if (context != null) {
            if (string2 != null) {
                this.context = context;
                this.setPlacementID(string2);
                j.bh().d(context, string2);
                if (f.bb().equals((Object)"")) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(){

                        public final void run() {
                            f.m((Context)context);
                        }
                    });
                }
                new Thread(new Runnable(){

                    /*
                     * Exception decompiling
                     */
                    public final void run() {
                        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
                        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
                        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
                        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
                        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
                        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                        // org.benf.cfr.reader.entities.g.p(Method.java:396)
                        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                        // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                        // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
                }).start();
                b.bn();
                new Thread(new Runnable(){

                    public final void run() {
                        Appnext.init(context);
                    }
                }).start();
                return;
            }
            throw new IllegalArgumentException("placementID cannot be null");
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    protected Ad(Ad ad) {
        this.context = ad.context;
        this.setPlacementID(ad.getPlacementID());
        this.setCategories(ad.cat);
        this.setPostback(ad.getPostback());
        this.setCount(ad.getCount());
        this.setMinVideoLength(ad.getMinVideoLength());
        this.setMaxVideoLength(ad.getMaxVideoLength());
        this.setSessionId(ad.getSessionId());
        this.onAdClicked = ad.onAdClicked;
        this.onAdError = ad.onAdError;
        this.onAdLoaded = ad.onAdLoaded;
        this.closeCallback = ad.closeCallback;
        this.adOpenedCallback = ad.adOpenedCallback;
    }

    public void destroy() {
        this.context = null;
        this.onAdClicked = null;
        this.onAdError = null;
        this.onAdLoaded = null;
        this.closeCallback = null;
        this.adOpenedCallback = null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!this.getClass().isInstance(object) && !object.getClass().isInstance((Object)this)) {
            return false;
        }
        if (object instanceof Ad) {
            Ad ad = (Ad)object;
            return ad.getPlacementID().equals((Object)this.getPlacementID()) && ad.getCategories().equals((Object)this.getCategories()) && ad.getPostback().equals((Object)this.getPostback()) && ad.getMinVideoLength() == this.getMinVideoLength() && ad.getMaxVideoLength() == this.getMaxVideoLength() && ad.getCount() == this.getCount();
        }
        return super.equals(object);
    }

    public abstract String getAUID();

    protected c getAdRequest() {
        return this.adRequest;
    }

    public String getCategories() {
        return this.cat;
    }

    protected Context getContext() {
        return this.context;
    }

    protected int getCount() {
        return this.cnt;
    }

    public abstract void getECPM(OnECPMLoaded var1);

    public int getMaxVideoLength() {
        return this.maxVideoLength;
    }

    public int getMinVideoLength() {
        return this.minVideoLength;
    }

    public boolean getMute() {
        return this.mute;
    }

    public OnAdClicked getOnAdClickedCallback() {
        return this.onAdClicked;
    }

    public OnAdClosed getOnAdClosedCallback() {
        return this.closeCallback;
    }

    public OnAdError getOnAdErrorCallback() {
        return this.onAdError;
    }

    public OnAdLoaded getOnAdLoadedCallback() {
        return this.onAdLoaded;
    }

    public OnAdOpened getOnAdOpenedCallback() {
        return this.adOpenedCallback;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public String getPlacementID() {
        return this.placementID;
    }

    public String getPostback() {
        return this.pbk;
    }

    protected String getSessionId() {
        return this.sessionId;
    }

    public abstract String getTID();

    public abstract String getVID();

    public int hashCode() {
        return 31 * (31 * (31 * (31 * (31 * this.getPlacementID().hashCode() + this.getCategories().hashCode()) + this.getPostback().hashCode()) + this.getCount()) + this.getMinVideoLength()) + this.getMaxVideoLength();
    }

    public abstract boolean isAdLoaded();

    public abstract void loadAd();

    protected void setAdRequest(c c2) {
        this.adRequest = c2;
    }

    public void setCategories(String string2) {
        String string3;
        string3 = "";
        if (string2 == null) {
            string2 = string3;
        }
        try {
            if (string2.equals((Object)URLDecoder.decode((String)string2, (String)"UTF-8"))) {
                string2 = URLEncoder.encode((String)string2, (String)"UTF-8");
            }
            string3 = string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {}
        this.cat = string3;
    }

    protected void setCount(int n2) {
        this.cnt = n2;
    }

    public void setMaxVideoLength(int n2) {
        if (n2 >= 0) {
            if (n2 > 0 && this.getMinVideoLength() > 0 && n2 < this.getMinVideoLength()) {
                throw new IllegalArgumentException("Max Length cannot be lower than min length");
            }
            this.maxVideoLength = n2;
            return;
        }
        throw new IllegalArgumentException("Max Length must be higher than 0");
    }

    public void setMinVideoLength(int n2) {
        if (n2 >= 0) {
            if (n2 > 0 && this.getMaxVideoLength() > 0 && n2 > this.getMaxVideoLength()) {
                throw new IllegalArgumentException("Min Length cannot be higher than max length");
            }
            this.minVideoLength = n2;
            return;
        }
        throw new IllegalArgumentException("Min Length must be higher than 0");
    }

    public void setMute(boolean bl) {
        this.setMute = true;
        this.mute = bl;
    }

    public void setOnAdClickedCallback(OnAdClicked onAdClicked) {
        this.onAdClicked = onAdClicked;
    }

    public void setOnAdClosedCallback(OnAdClosed onAdClosed) {
        this.closeCallback = onAdClosed;
    }

    public void setOnAdErrorCallback(OnAdError onAdError) {
        this.onAdError = onAdError;
    }

    public void setOnAdLoadedCallback(OnAdLoaded onAdLoaded) {
        this.onAdLoaded = onAdLoaded;
    }

    public void setOnAdOpenedCallback(OnAdOpened onAdOpened) {
        this.adOpenedCallback = onAdOpened;
    }

    public void setOrientation(String string2) {
        if (string2 != null) {
            if (!(string2.equals((Object)"automatic") || string2.equals((Object)"not_set") || string2.equals((Object)"landscape") || string2.equals((Object)"portrait"))) {
                throw new IllegalArgumentException("Wrong orientation type");
            }
            this.orientation = string2;
            return;
        }
        throw new IllegalArgumentException("orientation type");
    }

    protected void setPlacementID(String string2) {
        this.placementID = string2;
    }

    public void setPostback(String string2) {
        String string3;
        string3 = "";
        if (string2 == null) {
            string2 = string3;
        }
        try {
            if (string2.equals((Object)URLDecoder.decode((String)string2, (String)"UTF-8"))) {
                string2 = URLEncoder.encode((String)string2, (String)"UTF-8");
            }
            string3 = string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {}
        this.pbk = string3;
    }

    protected void setSessionId(String string2) {
        this.sessionId = string2;
    }

    public abstract void showAd();

}

