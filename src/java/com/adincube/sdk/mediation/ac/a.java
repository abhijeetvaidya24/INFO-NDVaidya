/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.vungle.warren.LoadAdCallback
 *  com.vungle.warren.PlayAdCallback
 */
package com.adincube.sdk.mediation.ac;

import com.adincube.sdk.mediation.ac.a;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.k;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;

public final class a
extends k {
    public final LoadAdCallback d = new LoadAdCallback(this){
        final /* synthetic */ a a;
        {
            this.a = a2;
        }
    };
    public final PlayAdCallback e = new PlayAdCallback(this){
        final /* synthetic */ a a;
        {
            this.a = a2;
        }
    };

    public a(b b2) {
        super(b2);
    }
}

