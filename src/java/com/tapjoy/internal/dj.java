/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dk;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.do;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.dq;

public abstract class dj
extends dn {
    protected dj(Class class_) {
        super(dk.a, class_);
    }

    public abstract dq a(int var1);

    @Override
    public final /* synthetic */ Object a(do do_) {
        int n2 = do_.d();
        dq dq2 = this.a(n2);
        if (dq2 != null) {
            return dq2;
        }
        throw new dn.a(n2, this.a);
    }

    @Override
    public final /* synthetic */ void a(dp dp2, Object object) {
        dp2.c(((dq)object).a());
    }
}

