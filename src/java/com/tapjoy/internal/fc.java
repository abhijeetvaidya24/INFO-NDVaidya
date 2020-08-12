/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tapjoy.internal.fc$a
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Observer
 */
package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.internal.ev;
import com.tapjoy.internal.fc;
import com.tapjoy.internal.gc;
import java.util.Observer;

/*
 * Exception performing whole class analysis.
 */
abstract class fc {
    volatile a b;

    fc() {
    }

    protected abstract TJPlacement a(Context var1, TJPlacementListener var2, Object var3);

    protected abstract String a(Object var1);

    protected boolean a() {
        return !TapjoyConnectCore.isFullScreenViewOpen();
    }

    protected boolean a(Observer observer) {
        if (TapjoyConnectCore.isFullScreenViewOpen()) {
            ev.e.addObserver(observer);
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                return false;
            }
            ev.e.deleteObserver(observer);
        }
        if (!gc.a().d()) {
            ev.c.addObserver(observer);
            if (!gc.a().d()) {
                return false;
            }
            ev.c.deleteObserver(observer);
        }
        return true;
    }

    protected a b(Object object) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final boolean c(Object object) {
        if (!this.a()) {
            return false;
        }
        fc fc2 = this;
        // MONITORENTER : fc2
        a a2 = this.b;
        a a3 = null;
        if (a2 == null) {
            this.b = a3 = this.b(object);
        }
        // MONITOREXIT : fc2
        if (a3 == null) return false;
        a3.a();
        return true;
    }
}

