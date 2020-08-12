/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Camera
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.os.Handler
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.startapp.android.publish.ads.banner.banner3d.a
 *  java.io.Serializable
 *  java.lang.ClassLoader
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 */
package com.startapp.android.publish.ads.banner.banner3d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.startapp.android.publish.ads.banner.BannerBase;
import com.startapp.android.publish.ads.banner.BannerInterface;
import com.startapp.android.publish.ads.banner.BannerListener;
import com.startapp.android.publish.ads.banner.BannerOptions;
import com.startapp.android.publish.ads.banner.banner3d.Banner3D;
import com.startapp.android.publish.ads.banner.banner3d.Banner3DFace;
import com.startapp.android.publish.ads.banner.banner3d.Banner3DSize;
import com.startapp.android.publish.ads.banner.banner3d.a;
import com.startapp.android.publish.ads.banner.c;
import com.startapp.android.publish.ads.banner.d;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.a.f;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.adinformation.b;
import com.startapp.android.publish.adsCommon.b;
import com.startapp.android.publish.adsCommon.h;
import com.startapp.android.publish.adsCommon.i;
import com.startapp.android.publish.common.model.AdDetails;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.a.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Banner3D
extends BannerBase
implements BannerInterface,
AdEventListener {
    private static final String TAG = "Banner3D";
    private static final int TIMEOUT_RESTORE = 200;
    protected AdPreferences adPreferences;
    protected boolean addedDisplayEvent = false;
    protected a ads;
    protected List<AdDetails> adsItems;
    protected boolean animation = false;
    protected boolean attachedToWindow = false;
    protected Camera camera = null;
    protected int currentBannerIndex = 0;
    protected boolean defaultLoad = true;
    protected List<Banner3DFace> faces = new ArrayList();
    protected boolean firstRotation = true;
    protected boolean firstRotationFinished = false;
    protected BannerListener listener;
    protected boolean loaded = false;
    protected boolean loading = false;
    private Runnable mAutoRotation = new Runnable(this){
        final /* synthetic */ Banner3D this$0;
        {
            this.this$0 = banner3D;
        }

        public void run() {
            if (this.this$0.loaded) {
                if (this.this$0.faces.size() == 0) {
                    return;
                }
                if (this.this$0.visible && this.this$0.isShown() && Banner3D.access$000(this.this$0)) {
                    Banner3DFace banner3DFace = (Banner3DFace)this.this$0.faces.get(this.this$0.getCurrentBannerIndex());
                    Banner3D.access$100(this.this$0, banner3DFace);
                    if (!this.this$0.addedDisplayEvent) {
                        Banner3D banner3D = this.this$0;
                        banner3D.addedDisplayEvent = true;
                        Banner3D.access$200(banner3D);
                    }
                }
                if (this.this$0.rotationEnabled) {
                    Banner3D banner3D = this.this$0;
                    int n2 = banner3D.getBannerOptions().b();
                    int n3 = !this.this$0.firstRotationFinished ? this.this$0.options.p() : 1;
                    banner3D.rotate(n2 * n3);
                }
                if (this.this$0.rotation > (float)(90 - this.this$0.getBannerOptions().b()) && this.this$0.rotation < (float)(90 + this.this$0.getBannerOptions().b()) && !this.this$0.firstRotation) {
                    if (this.this$0.attachedToWindow) {
                        Banner3D banner3D = this.this$0;
                        banner3D.postDelayed((Runnable)this, (long)banner3D.getBannerOptions().c());
                    }
                    this.this$0.rotating = false;
                } else {
                    Banner3D banner3D = this.this$0;
                    banner3D.postDelayed((Runnable)this, (long)banner3D.getBannerOptions().a());
                    this.this$0.rotating = true;
                }
                if (this.this$0.getNextBannerIndex() == 0) {
                    this.this$0.firstRotation = false;
                }
            }
        }
    };
    protected Matrix matrix = null;
    protected BannerOptions options;
    protected com.startapp.android.publish.adsCommon.adinformation.c overrides;
    protected Paint paint = null;
    protected boolean rotating = false;
    protected float rotation = 45.0f;
    protected boolean rotationEnabled = true;
    protected float startY = 0.0f;
    protected boolean touchDown = false;
    protected boolean visible = true;

    public Banner3D(Activity activity) {
        this((Context)activity);
    }

    public Banner3D(Activity activity, AttributeSet attributeSet) {
        this((Context)activity, attributeSet);
    }

    public Banner3D(Activity activity, AttributeSet attributeSet, int n2) {
        this((Context)activity, attributeSet, n2);
    }

    public Banner3D(Activity activity, BannerListener bannerListener) {
        this((Context)activity, bannerListener);
    }

    public Banner3D(Activity activity, AdPreferences adPreferences) {
        this((Context)activity, adPreferences);
    }

    public Banner3D(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        this((Context)activity, adPreferences, bannerListener);
    }

    public Banner3D(Activity activity, boolean bl) {
        this((Context)activity, bl);
    }

    public Banner3D(Activity activity, boolean bl, AdPreferences adPreferences) {
        this((Context)activity, bl, adPreferences);
    }

    @Deprecated
    public Banner3D(Context context) {
        this(context, true, null);
    }

    @Deprecated
    public Banner3D(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Banner3D(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        try {
            this.init();
            return;
        }
        catch (Exception exception) {
            com.startapp.android.publish.adsCommon.f.f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "Banner.init - unexpected error occurd", exception.getMessage(), "");
            return;
        }
    }

    @Deprecated
    public Banner3D(Context context, BannerListener bannerListener) {
        this(context, true, null);
        this.setBannerListener(bannerListener);
    }

    @Deprecated
    public Banner3D(Context context, AdPreferences adPreferences) {
        this(context, true, adPreferences);
    }

    @Deprecated
    public Banner3D(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        this(context, true, adPreferences);
        this.setBannerListener(bannerListener);
    }

    @Deprecated
    public Banner3D(Context context, boolean bl) {
        this(context, bl, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated
    public Banner3D(Context context, boolean bl, AdPreferences adPreferences) {
        super(context);
        try {
            this.defaultLoad = bl;
            this.adPreferences = adPreferences == null ? new AdPreferences() : adPreferences;
            this.init();
            return;
        }
        catch (Exception exception) {
            com.startapp.android.publish.adsCommon.f.f.a(context, com.startapp.android.publish.adsCommon.f.d.b, "Banner.init - unexpected error occurd", exception.getMessage(), "");
            return;
        }
    }

    static /* synthetic */ boolean access$000(Banner3D banner3D) {
        return banner3D.drawn;
    }

    static /* synthetic */ void access$100(Banner3D banner3D, Banner3DFace banner3DFace) {
        banner3D.makeImpression(banner3DFace);
    }

    static /* synthetic */ void access$200(Banner3D banner3D) {
        banner3D.addDisplayEventOnLoad();
    }

    static /* synthetic */ void access$300(Banner3D banner3D, AdPreferences adPreferences) {
        banner3D.setHardwareAcceleration(adPreferences);
    }

    static /* synthetic */ void access$400(Banner3D banner3D) {
        banner3D.loadBanner();
    }

    private void addAdInformationLayout() {
        int n2;
        int n3;
        RelativeLayout relativeLayout = new RelativeLayout(this.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.getFaceWidth(), this.getFaceHeight());
        layoutParams.addRule(13);
        layoutParams.rightMargin = n3 = this.getFaceStartLeft();
        layoutParams.leftMargin = n3;
        layoutParams.topMargin = n2 = this.getFaceStartTop();
        layoutParams.bottomMargin = n2;
        this.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
        new com.startapp.android.publish.adsCommon.adinformation.b(this.getContext(), b.b.a, AdPreferences.Placement.INAPP_BANNER, this.overrides).a(relativeLayout);
    }

    private void cleanFaces() {
        List<Banner3DFace> list = this.faces;
        if (list != null && !list.isEmpty()) {
            for (Banner3DFace banner3DFace : this.faces) {
                if (banner3DFace == null) continue;
                banner3DFace.e();
            }
        }
    }

    private void createFaces(List<AdDetails> list) {
        this.cleanFaces();
        this.removeAllViews();
        this.faces = new ArrayList();
        for (AdDetails adDetails : list) {
            List<Banner3DFace> list2 = this.faces;
            Banner3DFace banner3DFace = new Banner3DFace(this.getContext(), (ViewGroup)this, adDetails, this.getBannerOptions(), new com.startapp.android.publish.adsCommon.d.b(this.getAdTag()));
            list2.add((Object)banner3DFace);
        }
        this.currentBannerIndex = 0;
    }

    private void dispatchOnDetatchedFromWindow() {
        List<Banner3DFace> list = this.faces;
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((Banner3DFace)iterator.next()).c();
            }
        }
    }

    private void drawFace(Canvas canvas, Bitmap bitmap, int n2, int n3, int n4, int n5, float f2, float f3) {
        if (this.camera == null) {
            this.camera = new Camera();
        }
        this.camera.save();
        this.camera.translate(0.0f, 0.0f, (float)n5);
        this.camera.rotateX(f3);
        Camera camera = this.camera;
        float f4 = -n5;
        camera.translate(0.0f, 0.0f, f4);
        if (this.matrix == null) {
            this.matrix = new Matrix();
        }
        this.camera.getMatrix(this.matrix);
        this.camera.restore();
        this.matrix.preTranslate((float)(-n4), f4);
        this.matrix.postScale(f2, f2);
        this.matrix.postTranslate((float)(n3 + n4), (float)(n2 + n5));
        canvas.drawBitmap(bitmap, this.matrix, this.paint);
    }

    /*
     * Exception decompiling
     */
    private void drawFrame(Canvas var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl172 : RETURN : trying to set 1 previously set to 0
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

    private Bitmap getCurrentBitmap() {
        return ((Banner3DFace)this.faces.get(this.getCurrentBannerIndex())).b();
    }

    private int getFaceHeight() {
        return (int)((float)com.startapp.android.publish.adsCommon.Utils.h.a(this.getContext(), this.options.e()) * this.options.k());
    }

    private int getFaceStartLeft() {
        return (this.getWidth() - this.getFaceWidth()) / 2;
    }

    private int getFaceStartTop() {
        return (this.getHeight() - this.getFaceHeight()) / 2;
    }

    private int getFaceWidth() {
        return (int)((float)com.startapp.android.publish.adsCommon.Utils.h.a(this.getContext(), this.options.d()) * this.options.j());
    }

    private Bitmap getPreviousBitmap() {
        int n2 = (-1 + this.getCurrentBannerIndex() + this.faces.size()) % this.faces.size();
        return ((Banner3DFace)this.faces.get(n2)).b();
    }

    private int getTotalBaners() {
        return this.faces.size();
    }

    private void initFaces(List<AdDetails> list) {
        if (this.shouldCreateFaces()) {
            this.createFaces(list);
            return;
        }
        this.initFacesViews();
    }

    private void initFacesViews() {
        Iterator iterator = this.faces.iterator();
        while (iterator.hasNext()) {
            ((Banner3DFace)iterator.next()).a(this.getContext(), this.getBannerOptions(), (ViewGroup)this);
        }
    }

    private boolean isEventInsideBanner(MotionEvent motionEvent) {
        int n2 = this.getFaceWidth();
        int n3 = this.getFaceHeight();
        int n4 = this.getFaceStartLeft();
        int n5 = this.getFaceStartTop();
        return motionEvent.getX() >= (float)n4 && motionEvent.getY() >= (float)n5 && motionEvent.getX() <= (float)(n4 + n2) && motionEvent.getY() <= (float)(n5 + n3);
    }

    private void makeImpression(Banner3DFace banner3DFace) {
        i i2 = banner3DFace.a(this.getContext());
        if (i2 != null) {
            g.a(TAG, 3, "Banner3D Scheduling visibility check");
            this.startVisibilityRunnable(i2);
        }
    }

    private void nextBanner() {
        this.currentBannerIndex = (1 + this.currentBannerIndex) % this.getTotalBaners();
    }

    private void prevBanner() {
        this.currentBannerIndex = (-1 + this.currentBannerIndex + this.getTotalBaners()) % this.getTotalBaners();
    }

    private boolean setBannerSize(d d2) {
        return Banner3DSize.a(this.getContext(), this.getParent(), this.getBannerOptions(), this, d2);
    }

    private boolean shouldCreateFaces() {
        List<Banner3DFace> list = this.faces;
        return list == null || list.size() == 0;
        {
        }
    }

    private void startRotation() {
        if (this.attachedToWindow && this.drawn) {
            this.removeCallbacks(this.mAutoRotation);
            this.post(this.mAutoRotation);
        }
    }

    @Override
    protected int getBannerId() {
        return this.innerBanner3dId;
    }

    @Override
    protected String getBannerName() {
        return "StartApp Banner3D";
    }

    protected BannerOptions getBannerOptions() {
        return this.options;
    }

    protected int getCurrentBannerIndex() {
        return this.currentBannerIndex;
    }

    @Override
    protected int getHeightInDp() {
        return 50;
    }

    protected int getNextBannerIndex() {
        return (1 + this.currentBannerIndex) % this.getTotalBaners();
    }

    @Override
    protected int getOffset() {
        a a2 = this.ads;
        if (a2 == null) {
            return 0;
        }
        return a2.a();
    }

    @Override
    protected int getRefreshRate() {
        return c.a().b().h();
    }

    @Override
    protected int getWidthInDp() {
        return 300;
    }

    @Override
    public void hideBanner() {
        this.visible = false;
        this.setVisibility(8);
    }

    @Override
    protected void initRuntime() {
        if (!this.loading) {
            this.options = c.a().c();
            this.adsItems = new ArrayList();
            if (this.adPreferences == null) {
                this.adPreferences = new AdPreferences();
            }
            this.overrides = com.startapp.android.publish.adsCommon.adinformation.c.a();
            this.cleanFaces();
            this.faces = new ArrayList();
            this.loading = true;
            this.setBackgroundColor(0);
            if (this.getId() == -1) {
                this.setId(this.getBannerId());
            }
            new Handler().postDelayed(new Runnable(this){
                final /* synthetic */ Banner3D this$0;
                {
                    this.this$0 = banner3D;
                }

                public void run() {
                    if (this.this$0.defaultLoad) {
                        Banner3D banner3D = this.this$0;
                        Banner3D.access$300(banner3D, banner3D.adPreferences);
                        Banner3D.access$400(this.this$0);
                    }
                }
            }, 200L);
        }
    }

    protected void loadBanners(List<AdDetails> list, boolean bl) {
        this.adsItems = list;
        if (list != null) {
            d d2 = new d();
            if (this.setBannerSize(d2)) {
                BannerListener bannerListener;
                this.setMinimumWidth(com.startapp.android.publish.adsCommon.Utils.h.a(this.getContext(), this.options.d()));
                this.setMinimumHeight(com.startapp.android.publish.adsCommon.Utils.h.a(this.getContext(), this.options.e()));
                if (this.getLayoutParams() != null && this.getLayoutParams().width == -1) {
                    this.setMinimumWidth(com.startapp.android.publish.adsCommon.Utils.h.a(this.getContext(), d2.a()));
                }
                if (this.getLayoutParams() != null && this.getLayoutParams().height == -1) {
                    this.setMinimumHeight(com.startapp.android.publish.adsCommon.Utils.h.a(this.getContext(), d2.b()));
                }
                if (this.getLayoutParams() != null) {
                    if (this.getLayoutParams().width > 0) {
                        this.setMinimumWidth(this.getLayoutParams().width);
                    }
                    if (this.getLayoutParams().height > 0) {
                        this.setMinimumHeight(this.getLayoutParams().height);
                    }
                    if (this.getLayoutParams().width > 0 && this.getLayoutParams().height > 0) {
                        this.ads.a(true);
                    }
                }
                this.initFaces(list);
                this.addAdInformationLayout();
                if (this.paint == null) {
                    this.paint = new Paint();
                    this.paint.setAntiAlias(true);
                    this.paint.setFilterBitmap(true);
                }
                if (!this.animation) {
                    this.animation = true;
                    this.startRotation();
                }
                if (this.visible) {
                    this.setVisibility(0);
                }
                if ((bannerListener = this.listener) != null && bl) {
                    bannerListener.onReceiveAd((View)this);
                    return;
                }
            } else {
                g.a(TAG, 6, "Banner3DError in banner screen size");
                this.setErrorMessage("Error in banner screen size");
                this.setVisibility(8);
                BannerListener bannerListener = this.listener;
                if (bannerListener != null && bl) {
                    bannerListener.onFailedToReceiveAd((View)this);
                    return;
                }
            }
        } else {
            this.setErrorMessage("No ads to load");
            BannerListener bannerListener = this.listener;
            if (bannerListener != null && bl) {
                bannerListener.onFailedToReceiveAd((View)this);
            }
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
        BannerOptions bannerOptions = this.options;
        if (bannerOptions == null || !bannerOptions.o()) {
            this.firstRotation = false;
            this.firstRotationFinished = true;
        }
        this.startRotation();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
        this.removeCallbacks(this.mAutoRotation);
        this.dispatchOnDetatchedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.drawn && !this.loading) {
            this.drawn = true;
            this.startRotation();
        }
        if (!this.isInEditMode() && this.visible && !this.shouldCreateFaces()) {
            this.drawFrame(canvas);
        }
    }

    @Override
    public void onFailedToReceiveAd(Ad ad) {
        this.setErrorMessage(ad.getErrorMessage());
        BannerListener bannerListener = this.listener;
        if (bannerListener != null) {
            bannerListener.onFailedToReceiveAd((View)this);
        }
    }

    @Override
    public void onReceiveAd(Ad ad) {
        this.loaded = true;
        this.loading = false;
        this.overrides = this.ads.getAdInfoOverride();
        this.loadBanners(((h)ad).d(), true);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.visible = savedState.bIsVisible;
        if (this.visible) {
            this.adsItems = savedState.getDetails();
            this.rotation = savedState.getRotation();
            this.firstRotation = savedState.isFirstRotation();
            this.firstRotationFinished = savedState.isFirstRotationFinished();
            this.currentBannerIndex = savedState.getCurrentImage();
            Banner3DFace[] arrbanner3DFace = savedState.faces;
            this.cleanFaces();
            this.faces = new ArrayList();
            if (arrbanner3DFace != null) {
                for (int i2 = 0; i2 < arrbanner3DFace.length; ++i2) {
                    this.faces.add((Object)arrbanner3DFace[i2]);
                }
            }
            this.loaded = savedState.loaded;
            this.loading = savedState.loading;
            this.defaultLoad = savedState.bDefaultLoad;
            this.overrides = savedState.overrides;
            this.options = savedState.options;
            if (this.adsItems.size() == 0) {
                this.defaultLoad = true;
                this.init();
                return;
            }
            this.post(new Runnable(this){
                final /* synthetic */ Banner3D this$0;
                {
                    this.this$0 = banner3D;
                }

                public void run() {
                    Banner3D banner3D = this.this$0;
                    banner3D.loadBanners(banner3D.adsItems, false);
                }
            });
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        View.BaseSavedState baseSavedState = new View.BaseSavedState(super.onSaveInstanceState()){
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>(){

                public SavedState createFromParcel(Parcel parcel) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public SavedState[] newArray(int n2) {
                    return new SavedState[n2];
                }
            };
            public f adRulesResult;
            public boolean bDefaultLoad;
            public boolean bIsVisible;
            private int currentImage;
            private AdDetails[] details;
            public Banner3DFace[] faces;
            private int firstRotation;
            private int firstRotationFinished;
            public boolean loaded;
            public boolean loading;
            public BannerOptions options;
            public com.startapp.android.publish.adsCommon.adinformation.c overrides;
            private float rotation;
            {
                int n2 = parcel.readInt();
                int n3 = 0;
                if (n2 == 1) {
                    int n4;
                    this.bIsVisible = true;
                    this.currentImage = parcel.readInt();
                    this.rotation = parcel.readFloat();
                    this.firstRotation = parcel.readInt();
                    this.firstRotationFinished = parcel.readInt();
                    Parcelable[] arrparcelable = parcel.readParcelableArray(AdDetails.class.getClassLoader());
                    if (arrparcelable != null) {
                        this.details = new AdDetails[arrparcelable.length];
                        System.arraycopy((Object)arrparcelable, (int)0, (Object)this.details, (int)0, (int)arrparcelable.length);
                    }
                    int n5 = parcel.readInt();
                    this.loaded = false;
                    if (n5 == 1) {
                        this.loaded = true;
                    }
                    int n6 = parcel.readInt();
                    this.loading = false;
                    if (n6 == 1) {
                        this.loading = true;
                    }
                    int n7 = parcel.readInt();
                    this.bDefaultLoad = false;
                    if (n7 == 1) {
                        this.bDefaultLoad = true;
                    }
                    if ((n4 = parcel.readInt()) > 0) {
                        this.faces = new Banner3DFace[n4];
                        while (n3 < n4) {
                            this.faces[n3] = (Banner3DFace)parcel.readParcelable(Banner3DFace.class.getClassLoader());
                            ++n3;
                        }
                    }
                    this.overrides = (com.startapp.android.publish.adsCommon.adinformation.c)parcel.readSerializable();
                    this.options = (BannerOptions)parcel.readSerializable();
                    this.adRulesResult = (f)parcel.readSerializable();
                    return;
                }
                this.bIsVisible = false;
            }

            public int describeContents() {
                return 0;
            }

            public int getCurrentImage() {
                return this.currentImage;
            }

            public List<AdDetails> getDetails() {
                return Arrays.asList((Object[])this.details);
            }

            public float getRotation() {
                return this.rotation;
            }

            public boolean isFirstRotation() {
                return this.firstRotation == 1;
            }

            public boolean isFirstRotationFinished() {
                return this.firstRotationFinished == 1;
            }

            public void setCurrentImage(int n2) {
                this.currentImage = n2;
            }

            public void setDetails(List<AdDetails> list) {
                this.details = new AdDetails[list.size()];
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    this.details[i2] = (AdDetails)list.get(i2);
                }
            }

            public void setFirstRotation(boolean bl) {
                this.firstRotation = bl ? 1 : 0;
            }

            public void setFirstRotationFinished(boolean bl) {
                this.firstRotationFinished = bl ? 1 : 0;
            }

            public void setRotation(float f2) {
                this.rotation = f2;
            }

            public void writeToParcel(Parcel parcel, int n2) {
                Banner3DFace[] arrbanner3DFace;
                super.writeToParcel(parcel, n2);
                boolean bl = this.bIsVisible;
                if (!bl) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                parcel.writeInt(this.currentImage);
                parcel.writeFloat(this.rotation);
                parcel.writeInt(this.firstRotation);
                parcel.writeInt(this.firstRotationFinished);
                parcel.writeParcelableArray((Parcelable[])this.details, n2);
                parcel.writeInt((int)this.loaded);
                parcel.writeInt((int)this.loading);
                parcel.writeInt((int)this.bDefaultLoad);
                parcel.writeInt(this.faces.length);
                for (int i2 = 0; i2 < (arrbanner3DFace = this.faces).length; ++i2) {
                    parcel.writeParcelable((Parcelable)arrbanner3DFace[i2], n2);
                }
                parcel.writeSerializable((Serializable)this.overrides);
                parcel.writeSerializable((Serializable)this.options);
                parcel.writeSerializable((Serializable)this.adRulesResult);
            }

        };
        baseSavedState.bIsVisible = this.visible;
        baseSavedState.setDetails(this.adsItems);
        baseSavedState.setRotation(this.rotation);
        baseSavedState.setFirstRotation(this.firstRotation);
        baseSavedState.setFirstRotationFinished(this.firstRotationFinished);
        baseSavedState.setCurrentImage(this.currentBannerIndex);
        baseSavedState.options = this.options;
        baseSavedState.faces = new Banner3DFace[this.faces.size()];
        baseSavedState.loaded = this.loaded;
        baseSavedState.loading = this.loading;
        baseSavedState.overrides = this.overrides;
        for (int i2 = 0; i2 < this.faces.size(); ++i2) {
            baseSavedState.faces[i2] = (Banner3DFace)this.faces.get(i2);
        }
        return baseSavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        List<Banner3DFace> list;
        if (this.isEventInsideBanner(motionEvent) && (list = this.faces) != null) {
            if (list.size() == 0) {
                return false;
            }
            int n2 = motionEvent.getAction();
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return true;
                    }
                    if (this.startY - motionEvent.getY() < 10.0f) {
                        return true;
                    }
                    this.touchDown = false;
                    this.startY = motionEvent.getY();
                    return true;
                }
                if (this.touchDown) {
                    if (this.rotation < 45.0f) {
                        this.prevBanner();
                    }
                    this.touchDown = false;
                    this.rotationEnabled = false;
                    this.setClicked(true);
                    this.postDelayed(new Runnable(this){
                        final /* synthetic */ Banner3D this$0;
                        {
                            this.this$0 = banner3D;
                        }

                        public void run() {
                            this.this$0.rotationEnabled = true;
                        }
                    }, b.a().A());
                    ((Banner3DFace)this.faces.get(this.getCurrentBannerIndex())).b(this.getContext());
                    BannerListener bannerListener = this.listener;
                    if (bannerListener != null) {
                        bannerListener.onClick((View)this);
                        return true;
                    }
                }
            } else {
                this.touchDown = true;
                this.startY = motionEvent.getY();
            }
            return true;
        }
        return false;
    }

    @Override
    public void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        if (bl) {
            this.attachedToWindow = true;
            BannerOptions bannerOptions = this.options;
            if (bannerOptions == null || !bannerOptions.o()) {
                this.firstRotation = false;
                this.firstRotationFinished = true;
            }
            this.startRotation();
            return;
        }
        this.attachedToWindow = false;
        if (!this.rotating) {
            this.removeCallbacks(this.mAutoRotation);
        }
    }

    @Override
    protected void reload() {
        this.loaded = false;
        this.loading = true;
        this.animation = false;
        this.rotationEnabled = true;
        this.firstRotation = true;
        this.firstRotationFinished = false;
        this.addedDisplayEvent = false;
        this.drawn = false;
        this.adRulesResult = null;
        this.cleanFaces();
        this.faces = new ArrayList();
        this.ads = new a(this.getContext(), this.getOffset());
        if (this.adPreferences == null) {
            this.adPreferences = new AdPreferences();
        }
        this.ads.load(this.adPreferences, (AdEventListener)this);
    }

    protected void rotate(float f2) {
        this.rotation = f2 + this.rotation;
        if (this.rotation >= 90.0f) {
            this.nextBanner();
            this.rotation -= 90.0f;
        }
        if (this.rotation <= 0.0f) {
            this.prevBanner();
            this.rotation = 90.0f + this.rotation;
        }
        this.invalidate();
    }

    @Override
    public void setAdTag(String string) {
        this.adTag = string;
    }

    @Override
    protected void setBannerId(int n2) {
        this.innerBanner3dId = n2;
    }

    @Override
    public void setBannerListener(BannerListener bannerListener) {
        this.listener = bannerListener;
    }

    @Override
    public void showBanner() {
        this.visible = true;
        this.setVisibility(0);
    }

}

