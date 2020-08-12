/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.opengl.GLSurfaceView
 *  com.tapjoy.internal.fu$1
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 */
package com.tapjoy.internal;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import com.tapjoy.internal.bf;
import com.tapjoy.internal.cd;
import com.tapjoy.internal.d;
import com.tapjoy.internal.fu;

public final class fu {
    public static final bf a;
    private static Activity b;
    private static final cd c;
    private static final cd d;

    static {
        c = new cd();
        d = new cd();
        a = new 1();
    }

    public static Activity a() {
        Activity activity = b;
        if (activity == null) {
            activity = d.a();
        }
        return activity;
    }

    static void a(GLSurfaceView gLSurfaceView) {
        new Object[1][0] = gLSurfaceView;
        c.a((Object)gLSurfaceView);
        gLSurfaceView.queueEvent(new Runnable(){

            public final void run() {
                Thread thread = Thread.currentThread();
                new Object[1][0] = thread;
                d.a((Object)thread);
            }
        });
    }

    public static Thread b() {
        return (Thread)d.a();
    }

    static /* synthetic */ cd c() {
        return c;
    }

}

