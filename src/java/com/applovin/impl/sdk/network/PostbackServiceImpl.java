/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.f;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;

public class PostbackServiceImpl
implements AppLovinPostbackService {
    private final j a;

    public PostbackServiceImpl(j j2) {
        this.a = j2;
    }

    @Override
    public void dispatchPostbackAsync(String string, AppLovinPostbackListener appLovinPostbackListener) {
        this.dispatchPostbackRequest(f.b(this.a).d(string).b(false).b(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(f f2, q.a a2, AppLovinPostbackListener appLovinPostbackListener) {
        com.applovin.impl.sdk.d.j j2 = new com.applovin.impl.sdk.d.j(f2, a2, this.a, appLovinPostbackListener);
        this.a.C().a(j2, a2);
    }

    public void dispatchPostbackRequest(f f2, AppLovinPostbackListener appLovinPostbackListener) {
        this.dispatchPostbackRequest(f2, q.a.d, appLovinPostbackListener);
    }
}

