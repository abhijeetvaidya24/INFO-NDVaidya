/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  com.appnext.banners.BannerActivity$1
 *  com.appnext.banners.BannerActivity$Banner
 *  com.appnext.banners.BannerActivity$a
 *  com.appnext.banners.BannerAd
 *  com.appnext.banners.BannerAdData
 *  com.appnext.banners.BannerAdRequest
 *  com.appnext.banners.LargeBannerAd
 *  com.appnext.banners.MediumRectangleAd
 *  com.appnext.banners.SmallBannerAd
 *  com.appnext.banners.b
 *  com.appnext.core.AppnextAd
 *  com.appnext.core.q
 *  com.appnext.core.q$a
 *  java.io.Serializable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.appnext.banners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.appnext.banners.BannerActivity;
import com.appnext.banners.BannerAd;
import com.appnext.banners.BannerAdData;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerSize;
import com.appnext.banners.LargeBannerAd;
import com.appnext.banners.MediumRectangleAd;
import com.appnext.banners.SmallBannerAd;
import com.appnext.banners.b;
import com.appnext.banners.e;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
public class BannerActivity
extends Activity {
    String ap;
    BannerAd bannerAd;
    BannerAdData cF;
    String cG;
    String cH;
    String cI;
    String cJ;
    e cK;
    Banner cL;
    boolean cd;
    BannerAdData selectedAd;
    q userAction;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static BannerSize n(String var0) {
        block5 : {
            block3 : {
                block4 : {
                    var1_1 = var0.hashCode();
                    if (var1_1 == -1966536496) break block3;
                    if (var1_1 == -96588539) break block4;
                    if (var1_1 != 1951953708 || !var0.equals((Object)"BANNER")) ** GOTO lbl-1000
                    var2_2 = 0;
                    break block5;
                }
                if (!var0.equals((Object)"MEDIUM_RECTANGLE")) ** GOTO lbl-1000
                var2_2 = 2;
                break block5;
            }
            if (var0.equals((Object)"LARGE_BANNER")) {
                var2_2 = 1;
            } else lbl-1000: // 3 sources:
            {
                var2_2 = -1;
            }
        }
        if (var2_2 == 0) return BannerSize.BANNER;
        if (var2_2 == 1) return BannerSize.LARGE_BANNER;
        if (var2_2 == 2) {
            return BannerSize.MEDIUM_RECTANGLE;
        }
        var3_3 = new StringBuilder("Wrong banner size ");
        var3_3.append(var0);
        throw new IllegalArgumentException(var3_3.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected final Ad c(String var1_1, String var2_2) {
        block5 : {
            block3 : {
                block4 : {
                    var3_3 = var2_2.hashCode();
                    if (var3_3 == -1966536496) break block3;
                    if (var3_3 == -96588539) break block4;
                    if (var3_3 != 1951953708 || !var2_2.equals((Object)"BANNER")) ** GOTO lbl-1000
                    var4_4 = 0;
                    break block5;
                }
                if (!var2_2.equals((Object)"MEDIUM_RECTANGLE")) ** GOTO lbl-1000
                var4_4 = 2;
                break block5;
            }
            if (var2_2.equals((Object)"LARGE_BANNER")) {
                var4_4 = 1;
            } else lbl-1000: // 3 sources:
            {
                var4_4 = -1;
            }
        }
        if (var4_4 == 0) return new SmallBannerAd((Context)this, var1_1);
        if (var4_4 == 1) return new LargeBannerAd((Context)this, var1_1);
        if (var4_4 == 2) {
            return new MediumRectangleAd((Context)this, var1_1);
        }
        var5_5 = new StringBuilder("Wrong banner size ");
        var5_5.append(var2_2);
        throw new IllegalArgumentException(var5_5.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void onCreate(Bundle var1_1) {
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        super.onCreate(var1_1);
        this.cK = new /* Unavailable Anonymous Inner Class!! */;
        var3_2 = new LinearLayout((Context)this);
        var4_3 = -1;
        var3_2.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(var4_3, var4_3));
        this.setContentView((View)var3_2);
        this.userAction = new q((Context)this, (q.a)new 1(this));
        try {
            block25 : {
                block23 : {
                    block24 : {
                        var5_4 = this.getIntent().getExtras();
                        this.ap = var5_4.getString("placement");
                        this.cI = var5_4.getString("size");
                        var6_5 = this.ap;
                        var7_6 = this.cI;
                        var8_7 = var7_6.hashCode();
                        if (var8_7 == -1966536496) break block23;
                        if (var8_7 == -96588539) break block24;
                        if (var8_7 != 1951953708 || !var7_6.equals((Object)"BANNER")) ** GOTO lbl-1000
                        var10_8 = 0;
                        break block25;
                    }
                    if (!var7_6.equals((Object)"MEDIUM_RECTANGLE")) ** GOTO lbl-1000
                    var10_8 = 2;
                    break block25;
                }
                var9_9 = var7_6.equals((Object)"LARGE_BANNER");
                if (var9_9) {
                    var10_8 = 1;
                } else lbl-1000: // 3 sources:
                {
                    var10_8 = -1;
                }
            }
            if (var10_8 != 0) {
                if (var10_8 != 1) {
                    if (var10_8 != 2) {
                        var22_11 = new StringBuilder("Wrong banner size ");
                        var22_11.append(var7_6);
                        throw new IllegalArgumentException(var22_11.toString());
                    }
                    var11_10 = new MediumRectangleAd((Context)this, var6_5);
                } else {
                    var11_10 = new LargeBannerAd((Context)this, var6_5);
                }
            } else {
                var11_10 = new SmallBannerAd((Context)this, var6_5);
            }
            this.bannerAd = (BannerAd)var11_10;
            this.bannerAd.setPostback(var5_4.getString("postback"));
            this.bannerAd.setCategories(var5_4.getString("category"));
            this.cH = var5_4.getString("clicked");
            this.cd = var5_4.getBoolean("shouldClose", false);
            this.selectedAd = (BannerAdData)var5_4.getSerializable("selected");
            this.cG = b.R().l((Ad)this.bannerAd);
            var12_12 = b.R().f((Ad)this.bannerAd);
            var13_13 = new JSONArray();
            if (var12_12 != null) {
                var14_14 = var12_12.iterator();
                while (var14_14.hasNext()) {
                    var13_13.put((Object)new JSONObject(new BannerAdData((AppnextAd)var14_14.next()).getAdJSON()));
                }
            }
            this.cJ = new JSONObject().put("apps", (Object)var13_13).toString();
        }
        catch (Throwable v0) {
            this.finish();
            return;
        }
        this.cL = new /* Unavailable Anonymous Inner Class!! */;
        var3_2.addView((View)this.cL);
        this.cL.getLayoutParams().height = var4_3;
        this.cL.getLayoutParams().width = var4_3;
        this.cL.setPlacementId(this.ap);
        var15_15 = this.cL;
        var16_16 = this.cI;
        var17_17 = var16_16.hashCode();
        if (var17_17 != -1966536496) {
            if (var17_17 != -96588539) {
                if (var17_17 == 1951953708 && var16_16.equals((Object)"BANNER")) {
                    var4_3 = 0;
                }
            } else if (var16_16.equals((Object)"MEDIUM_RECTANGLE")) {
                var4_3 = 2;
            }
        } else if (var16_16.equals((Object)"LARGE_BANNER")) {
            var4_3 = 1;
        }
        if (var4_3 != 0) {
            if (var4_3 != 1) {
                if (var4_3 != 2) {
                    var19_19 = new StringBuilder("Wrong banner size ");
                    var19_19.append(var16_16);
                    throw new IllegalArgumentException(var19_19.toString());
                }
                var18_18 = BannerSize.MEDIUM_RECTANGLE;
            } else {
                var18_18 = BannerSize.LARGE_BANNER;
            }
        } else {
            var18_18 = BannerSize.BANNER;
        }
        var15_15.setBannerSize(var18_18);
        this.cL.loadAd(null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void onDestroy() {
        super.onDestroy();
        try {
            this.userAction.destroy();
            ** GOTO lbl-1000
        }
        catch (Throwable v0) {
            try lbl-1000: // 2 sources:
            {
                this.bannerAd.destroy();
                ** GOTO lbl-1000
            }
            catch (Throwable v1) {
                try lbl-1000: // 2 sources:
                {
                    this.cL.destroy();
                    return;
                }
                catch (Throwable v2) {}
            }
        }
    }
}

