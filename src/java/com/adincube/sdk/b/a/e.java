/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageButton
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
package com.adincube.sdk.b.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class e
implements View.OnClickListener {
    boolean a = false;
    public Set<a> b = new HashSet();
    private Context c;
    private com.adincube.sdk.b.a.a.e d;
    private ImageButton e = null;
    private Drawable f = null;
    private Drawable g = null;

    public e(Context context, com.adincube.sdk.b.a.a.e e2) {
        this.c = context;
        this.d = e2;
    }

    public final ImageButton a() {
        if (this.e == null) {
            this.e = new ImageButton(this.c);
            this.e.setBackgroundDrawable(null);
            this.e.setOnClickListener((View.OnClickListener)this);
            this.e.setAdjustViewBounds(true);
        }
        return this.e;
    }

    public final void a(boolean bl, boolean bl2) {
        if (this.a == bl && !bl2) {
            return;
        }
        if (this.g == null) {
            Context context = this.c;
            byte[] arrby = com.adincube.sdk.util.e.a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAYAAABV7bNHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA5VJREFUeNrsmz1oFEEUx3cvJwomnBi0ESSIRgSjiZLCQhCChagg2iSFICJRG7EJiincFCqihXZGxSKKdoIflRYpoogmpyQGMVFO8QMFFT9AxTNk/S/uwRU3M29u9zYzO/Pgx8G8vTdz/9uZnY+3ru/7jjW2ZawEViArkBXICmQFsgJZgQy1LOUi13VnvKGY0Lbg42nS9boazaSDhn4At8EVMBSWWYHKBCq3SXAaDIA/poxBnsS1zeA8eAG6atm3VcHz/xvLL7JB0BR3uzIK3TlHI8bYAMZAZ9q6GFUcyjjTAK6BE8H4moYu5lXoKqxrc2AXGPFpdglkorZRNXF84nc3gjxBpAHg6iiQx/lR1BjB3XEQ/BKIdFw3gTzBD5KN1wImBTE7dRHII3SLauI2ggecmD/AUtUF8oiDa7XxGwQiDaosEFUcP2I988FLTuydsjGTWIvJTgJdzpxtmvD9lWAYzKngewOWgaIqE8U4Zsgly4N1hOvGwRGGbzHYo8pEUaZbUbpYYFPgMKHuOjDKiD8hMzdSTRzqYvUsoQ2bOHV0xC1QkkZtwyFCux8z6rio22q+GjtGGJP6GeVbqeMv9SmW5LajK9GGUdDGaV8OfGbsva8BT9J+qrEabOP4v4N7DB/liZiKY59ugX+IUb7WFIE6QD3HP8IoX2KKQLNAO8dfYJQ3mXSy2szxvecM4MYI1Mjx/WSU15skUBwHkakW6AvHN1fyzkqlQBMc3yJG+TdTBPob7v84ko/z16YIdFfQXdolH/+pE6hf4F8vOYFM1WI1H94hrPbNA58Yi9XWcLGb2jtoCuwX/HldDHE+OsRsNZ0F6hEMzoHtY5TfcmgHAGSBXEn6aizOSXBGcM0WsIrhu0qfTuq1aV8EBwh1Z8E4I/4zlQ4OvRgFug9aifX2cOJ3p/XgkGpBt3oEZlfwvQLLw8mlo8og7SUwJpVsAbjBECewXhlxaj0GJZ28kBNkn90xOf1lIRjmxPxabQZsGhKo2kBBEHOHiSl4deHT6rdAnD4Tkzg3gzFCd72gc5arbBpwkBy1lyhMYOeiZriqIFAlkVjXFYnCTIcxY2mfau9pRHlXo/S02h5n27KKrMy98DNKNlqws7gbvIuzYaoIVC6SrBXCrY/rNdm90/iFuiAX8VS4dTFVq0qzjl72FtwEl8HDJCrUSaAV4HnSlerUxWbE7HvzViArkBXICmQFsgJZgUy1fwIMAL0jl379L/YCAAAAAElFTkSuQmCC".toCharArray());
            Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length);
            bitmap.setDensity(480);
            this.g = l.a(context, bitmap);
        }
        Drawable drawable = this.g;
        float f2 = 1.0f;
        if (bl) {
            if (this.f == null) {
                Context context = this.c;
                byte[] arrby = com.adincube.sdk.util.e.a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAYAAABV7bNHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAONJREFUeNrs3EEOgkAMQFEx3Ft68jEeQKImzLT1/YQdC/ICm2nDNsa46X13BIAAAQIECBAgQAIEqD/QAegc5wGoEE4WoLQ4GYBS46wGSo+zEqgEziqgMjgrgErhzAYqhzMTqCTOLKCyODOASuNcDVQe50qgFjiv9g/v+9v5tAMzQIAAAQIECBAgAQIECBAgQIAA6Qeg7csrvEHnHV2Qrp5qBKDmSLMmqwGoKdLs7Y4A1Axp1YZZAGqCtHrLNQAVR8qyaR+AiiLtiZ7lyAi0+XdHjU8MECBAgAQIECBAgAC16inAAAx7JBiffjKJAAAAAElFTkSuQmCC".toCharArray());
                Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length);
                bitmap.setDensity(480);
                this.f = l.a(context, bitmap);
            }
            drawable = this.f;
            f2 = 0.0f;
        }
        this.a = bl;
        this.a().setImageDrawable(drawable);
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            ((a)iterator.next()).a(bl, bl2);
        }
        this.d.a(f2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onClick(View view) {
        boolean bl;
        try {
            if (view != this.e) return;
            {
                bl = !this.a;
            }
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("VideoPlayerUIContainer.onClick", new Object[]{throwable});
            ErrorReportingHelper.report("VideoPlayerUIContainer.onClick", throwable);
            return;
        }
        this.a(bl, false);
    }

    public static interface a {
        public void a(boolean var1, boolean var2);
    }

}

