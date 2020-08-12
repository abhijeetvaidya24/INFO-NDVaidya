/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Point
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.ClassLoader
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.startapp.android.publish.ads.banner.banner3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.startapp.android.publish.ads.banner.BannerOptions;
import com.startapp.android.publish.ads.banner.banner3d.Banner3DFace;
import com.startapp.android.publish.ads.banner.banner3d.b;
import com.startapp.android.publish.adsCommon.Utils.h;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.adsCommon.i;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdDetails;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.a;
import com.startapp.common.a.g;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Banner3DFace
implements Parcelable,
a.a {
    public static final Parcelable.Creator<Banner3DFace> CREATOR = new Parcelable.Creator<Banner3DFace>(){

        public Banner3DFace a(Parcel parcel) {
            return new Banner3DFace(parcel);
        }

        public Banner3DFace[] a(int n2) {
            return new Banner3DFace[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private AdDetails a;
    private Point b;
    private Bitmap c = null;
    private Bitmap d = null;
    private AtomicBoolean e = new AtomicBoolean(false);
    private com.startapp.android.publish.adsCommon.d.b f;
    private i g = null;
    private b h = null;

    public Banner3DFace(Context context, ViewGroup viewGroup, AdDetails adDetails, BannerOptions bannerOptions, com.startapp.android.publish.adsCommon.d.b b2) {
        this.a = adDetails;
        this.f = b2;
        this.a(context, bannerOptions, viewGroup);
    }

    public Banner3DFace(Parcel parcel) {
        this.a = (AdDetails)parcel.readParcelable(AdDetails.class.getClassLoader());
        this.b = new Point(1, 1);
        this.b.x = parcel.readInt();
        this.b.y = parcel.readInt();
        this.c = (Bitmap)parcel.readParcelable(Bitmap.class.getClassLoader());
        boolean[] arrbl = new boolean[1];
        parcel.readBooleanArray(arrbl);
        this.e.set(arrbl[0]);
        this.f = (com.startapp.android.publish.adsCommon.d.b)parcel.readSerializable();
    }

    private Bitmap a(View view) {
        view.measure(view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmap = Bitmap.createBitmap((int)view.getMeasuredWidth(), (int)view.getMeasuredHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.draw(canvas);
        return bitmap;
    }

    private void a(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    private void f() {
        this.d = this.a((View)this.h);
        if (this.b.x > 0 && this.b.y > 0) {
            this.d = Bitmap.createScaledBitmap((Bitmap)this.d, (int)this.b.x, (int)this.b.y, (boolean)false);
        }
    }

    private long g() {
        if (this.a().getDelayImpressionInSeconds() != null) {
            return TimeUnit.SECONDS.toMillis(this.a().getDelayImpressionInSeconds().longValue());
        }
        return TimeUnit.SECONDS.toMillis(MetaData.getInstance().getIABDisplayImpressionDelayInSeconds());
    }

    public i a(Context context) {
        if (this.a().getTrackingUrl() != null && this.e.compareAndSet(false, true)) {
            i i2;
            String[] arrstring = new String[]{this.a().getTrackingUrl()};
            this.g = i2 = new i(context, arrstring, this.f, this.g());
            return this.g;
        }
        return null;
    }

    public AdDetails a() {
        return this.a;
    }

    public void a(Context context, BannerOptions bannerOptions, ViewGroup viewGroup) {
        int n2 = h.a(context, -5 + bannerOptions.e());
        this.b = new Point((int)((float)h.a(context, bannerOptions.d()) * bannerOptions.j()), (int)((float)h.a(context, bannerOptions.e()) * bannerOptions.k()));
        this.h = new b(context, new Point(bannerOptions.d(), bannerOptions.e()));
        this.h.setText(this.a().getTitle());
        this.h.setRating(this.a().getRating());
        this.h.setDescription(this.a().getDescription());
        this.h.setButtonText(this.a.isCPE());
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            this.h.a(bitmap, n2, n2);
        } else {
            this.h.a(17301651, n2, n2);
            new a(this.a().getImageUrl(), this, 0).a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" Banner Face Image Async Request: [");
            stringBuilder.append(this.a().getTitle());
            stringBuilder.append("]");
            g.a("Banner3DFace", 3, stringBuilder.toString());
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b.x, this.b.y);
        layoutParams.addRule(13);
        viewGroup.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams);
        this.h.setVisibility(8);
        this.f();
    }

    @Override
    public void a(Bitmap bitmap, int n2) {
        b b2;
        if (bitmap != null && (b2 = this.h) != null) {
            this.c = bitmap;
            b2.setImage(bitmap);
            this.f();
        }
    }

    public Bitmap b() {
        return this.d;
    }

    public void b(Context context) {
        String string = this.a().getIntentPackageName();
        boolean bl = c.a(context, AdPreferences.Placement.INAPP_BANNER);
        i i2 = this.g;
        if (i2 != null) {
            i2.a(true);
        }
        if (string != null && !"null".equals((Object)string) && !TextUtils.isEmpty((CharSequence)string)) {
            c.a(string, this.a().getIntentDetails(), this.a().getClickUrl(), context, this.f);
            return;
        }
        if (this.a().isSmartRedirect() && !bl) {
            c.a(context, this.a().getClickUrl(), this.a().getTrackingClickUrl(), this.a().getPackageName(), this.f, com.startapp.android.publish.adsCommon.b.a().A(), com.startapp.android.publish.adsCommon.b.a().B(), this.a().isStartappBrowserEnabled(), this.a().shouldSendRedirectHops(), false);
            return;
        }
        String string2 = this.a().getClickUrl();
        String string3 = this.a().getTrackingClickUrl();
        com.startapp.android.publish.adsCommon.d.b b2 = this.f;
        boolean bl2 = this.a().isStartappBrowserEnabled() && !bl;
        c.a(context, string2, string3, b2, bl2, false);
    }

    public void c() {
        i i2 = this.g;
        if (i2 != null) {
            i2.a(false);
        }
    }

    public void d() {
        this.a(this.c);
        this.a(this.d);
        this.c = null;
        this.d = null;
    }

    public int describeContents() {
        return 0;
    }

    public void e() {
        b b2;
        this.d();
        i i2 = this.g;
        if (i2 != null) {
            i2.a(false);
        }
        if ((b2 = this.h) != null) {
            b2.removeAllViews();
            this.h = null;
        }
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.a(), n2);
        parcel.writeInt(this.b.x);
        parcel.writeInt(this.b.y);
        parcel.writeParcelable((Parcelable)this.c, n2);
        boolean[] arrbl = new boolean[]{this.e.get()};
        parcel.writeBooleanArray(arrbl);
        parcel.writeSerializable((Serializable)this.f);
    }
}

