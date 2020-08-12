/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.RatingBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.appnext.ads.fullscreen.FullscreenAd
 *  com.appnext.core.AppnextAd
 *  com.appnext.core.a.b
 *  com.appnext.core.f
 *  com.appnext.core.k
 *  com.appnext.core.p
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 */
package com.appnext.ads.fullscreen;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appnext.R;
import com.appnext.ads.fullscreen.FullscreenAd;
import com.appnext.ads.fullscreen.h;
import com.appnext.core.AppnextAd;
import com.appnext.core.a.b;
import com.appnext.core.f;
import com.appnext.core.k;
import com.appnext.core.p;
import java.util.ArrayList;

public final class d
extends Fragment {
    private ImageView aS;
    private TextView aT;
    private h aU;
    private ArrayList<AppnextAd> ads;
    private boolean clicked = false;

    private void a(final RelativeLayout relativeLayout, final AppnextAd appnextAd, final boolean bl) {
        new Thread(new Runnable(){

            public final void run() {
                final Bitmap bitmap = f.Z((String)appnextAd.getImageURL());
                new Handler(Looper.getMainLooper()).post(new Runnable(){

                    public final void run() {
                        ((ImageView)relativeLayout.findViewById(R.id.icon)).setImageBitmap(bitmap);
                    }
                });
            }

        }).start();
        ((TextView)relativeLayout.findViewById(R.id.title)).setText((CharSequence)appnextAd.getAdTitle());
        ((RatingBar)relativeLayout.findViewById(R.id.rating)).setRating(Float.parseFloat((String)appnextAd.getStoreRating()));
        relativeLayout.findViewById(R.id.click).setOnClickListener(new View.OnClickListener(){

            public final void onClick(View view) {
                FullscreenAd fullscreenAd = new FullscreenAd(appnextAd);
                if (bl) {
                    d.this.report("post_roll_click_main");
                } else {
                    d.this.report("post_roll_click_suggested");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(fullscreenAd.getAppURL());
                    stringBuilder.append("&tem_id=");
                    String string2 = d.this.aU.isRewarded() ? "8" : "7";
                    stringBuilder.append(string2);
                    stringBuilder.append("05");
                    fullscreenAd.setAppURL(stringBuilder.toString());
                }
                d.this.aU.installClicked((AppnextAd)fullscreenAd);
                d.this.clicked = true;
            }
        });
    }

    private void report(String string2) {
        this.aU.report(string2, "S3");
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aU = (h)activity;
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.aU = (h)context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            RelativeLayout relativeLayout = (RelativeLayout)layoutInflater.inflate(this.aU.getTemplate("S3"), viewGroup, false);
            this.ads = this.aU.getPostRollAds();
            ImageView imageView = (ImageView)relativeLayout.findViewById(R.id.privacy);
            ImageView imageView2 = (ImageView)relativeLayout.findViewById(R.id.close);
            View view = relativeLayout.findViewById(R.id.click);
            this.aS = (ImageView)relativeLayout.findViewById(R.id.media);
            this.aT = (TextView)relativeLayout.findViewById(R.id.install);
            imageView.setOnClickListener(new View.OnClickListener(){

                public final void onClick(View view) {
                    d.this.aU.privacyClicked();
                }
            });
            if (k.a((AppnextAd)((AppnextAd)this.ads.get(0)), (p)this.aU.getConfigManager())) {
                k.a((Context)((Context)this.aU), (ImageView)imageView);
            }
            imageView2.setOnClickListener(new View.OnClickListener(){

                public final void onClick(View view) {
                    d.this.aU.closeClicked();
                }
            });
            view.setOnClickListener(new View.OnClickListener(){

                public final void onClick(View view) {
                    d.this.aU.installClicked((AppnextAd)d.this.ads.get(0));
                }
            });
            String string2 = this.aU.getCtaText();
            int n2 = Integer.parseInt((String)b.bn().b(this.aU.getLanguage(), "settings", "len"));
            if (!TextUtils.isEmpty((CharSequence)string2) && string2.length() > n2) {
                string2 = string2.substring(0, n2);
            }
            this.aT.setText((CharSequence)string2);
            this.aT.setTextSize(2, (float)Integer.parseInt((String)b.bn().b(this.aU.getLanguage(), "settings", "font_size_sp")));
            new Thread(new Runnable(){

                public final void run() {
                    final Bitmap bitmap = f.Z((String)((AppnextAd)d.this.ads.get(0)).getWideImageURL());
                    new Handler(Looper.getMainLooper()).post(new Runnable(){

                        public final void run() {
                            d.this.aS.setImageBitmap(bitmap);
                        }
                    });
                }

            }).start();
            this.a(relativeLayout, (AppnextAd)this.ads.get(0), true);
            View view2 = relativeLayout.findViewById(R.id.extra);
            if (view2 != null) {
                if (this.ads.size() > 1) {
                    this.a((RelativeLayout)view2.findViewById(R.id.item1), (AppnextAd)this.ads.get(1), false);
                } else {
                    view2.findViewById(R.id.item1).setVisibility(4);
                }
                if (this.ads.size() > 2) {
                    this.a((RelativeLayout)view2.findViewById(R.id.item2), (AppnextAd)this.ads.get(2), false);
                } else {
                    view2.findViewById(R.id.item2).setVisibility(4);
                }
                if (view2.findViewById(R.id.item3) != null) {
                    if (this.ads.size() > 3) {
                        this.a((RelativeLayout)view2.findViewById(R.id.item3), (AppnextAd)this.ads.get(3), false);
                    } else {
                        view2.findViewById(R.id.item3).setVisibility(4);
                    }
                }
            }
            this.report("post_roll_loaded");
            return relativeLayout;
        }
        catch (Throwable throwable) {
            this.aU.closeClicked();
            return null;
        }
    }

    public final void onDestroyView() {
        this.report("post_roll_click_none");
        super.onDestroyView();
    }

}

