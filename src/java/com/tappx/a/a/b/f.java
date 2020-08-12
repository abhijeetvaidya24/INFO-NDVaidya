/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  java.lang.Object
 */
package com.tappx.a.a.b;

import android.view.MotionEvent;
import com.tappx.a.a.b.aa;

class f {
    private a a;

    public void a(MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (n2 != 0) {
            if (n2 != 1) {
                return;
            }
            a a2 = this.a;
            if (a2 != null) {
                a2.a();
                return;
            }
            aa.c("No listener, click ignored");
        }
    }

    public void a(a a2) {
        this.a = a2;
    }

    public static interface a {
        public void a();
    }

}

