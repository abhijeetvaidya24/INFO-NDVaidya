/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.adincube.sdk.b.a.d$a
 *  com.adincube.sdk.h.a.c
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
package com.adincube.sdk.b.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.adincube.sdk.b.a.d;
import com.adincube.sdk.h.a.c;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.j;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@TargetApi(value=14)
public final class d
implements View.OnClickListener,
j {
    Context a;
    public Set<a> b = new HashSet();
    private c c;
    private SurfaceView d = null;
    private SurfaceHolder e = null;

    public d(Context context, c c2) {
        this.a = context;
        this.c = c2;
    }

    public final SurfaceView a() {
        if (this.d == null) {
            this.d = new SurfaceView(this.a);
            this.d.setZOrderMediaOverlay(true);
            this.d.setSoundEffectsEnabled(true);
            this.d.setOnClickListener((View.OnClickListener)this);
            this.e = this.d.getHolder();
            this.e.setKeepScreenOn(true);
            this.e.setSizeFromLayout();
        }
        return this.d;
    }

    @Override
    public final void b() {
        SurfaceHolder surfaceHolder = this.e;
        if (surfaceHolder != null && surfaceHolder.getSurface() != null) {
            this.e.getSurface().release();
        }
    }

    public final void onClick(View view) {
        try {
            if (view == this.d) {
                Iterator iterator = this.b.iterator();
                while (iterator.hasNext()) {
                    (iterator.next()).a(view);
                }
            }
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("VideoPlayerUIContainer.onClick", new Object[]{throwable});
            ErrorReportingHelper.report("VideoPlayerUIContainer.onClick", (e)this.c, throwable);
            return;
        }
    }
}

