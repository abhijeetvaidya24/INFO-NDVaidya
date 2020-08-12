/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.startapp.android.publish.common.model;

import com.startapp.android.publish.adsCommon.BaseResponse;
import com.startapp.android.publish.adsCommon.adinformation.c;
import com.startapp.android.publish.common.model.AdDetails;
import com.startapp.common.c.f;
import java.util.ArrayList;
import java.util.List;

public class GetAdResponse
extends BaseResponse {
    private static final long serialVersionUID = 1L;
    @f(a=true)
    private c adInfoOverrides = c.a();
    @f(b="Ljava/util/ArrayList;", c="Lcom/startapp/android/publish/common/model/AdDetails;")
    private List<AdDetails> adsDetails = new ArrayList();
    private boolean inAppBrowser;
    @f(b="Lcom/startapp/android/publish/common/model/GetAdResponse$inAppBrowserPreLoad;")
    private inAppBrowserPreLoad inAppBrowserPreLoad;
    private String productId;
    private String publisherId;

    public c getAdInfoOverride() {
        return this.adInfoOverrides;
    }

    public List<AdDetails> getAdsDetails() {
        return this.adsDetails;
    }

    public inAppBrowserPreLoad getInAppBrowserPreLoad() {
        return this.inAppBrowserPreLoad;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPublisherId() {
        return this.publisherId;
    }

    public boolean isInAppBrowser() {
        return this.inAppBrowser;
    }

    public void setAdsDetails(List<AdDetails> list) {
        this.adsDetails = list;
    }

    public void setInAppBrowser(boolean bl) {
        this.inAppBrowser = bl;
    }

    public void setInAppBrowserPreLoad(inAppBrowserPreLoad inAppBrowserPreLoad2) {
        this.inAppBrowserPreLoad = inAppBrowserPreLoad2;
    }

    public void setProductId(String string) {
        this.productId = string;
    }

    public void setPublisherId(String string) {
        this.publisherId = string;
    }

}

