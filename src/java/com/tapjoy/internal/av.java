/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.tapjoy.internal;

import com.tapjoy.internal.as;
import com.tapjoy.internal.at;

public abstract class av
implements as {
    protected abstract at a(Object var1, boolean var2);

    @Override
    public final Object a(Object object) {
        at at2 = this.a(object, false);
        if (at2 != null) {
            return at2.a();
        }
        return null;
    }

    @Override
    public void a(Object object, Object object2) {
        this.a(object, true).a(object2);
    }
}

