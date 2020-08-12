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
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.RatingBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.appnext.core.AppnextAd
 *  com.appnext.core.f
 *  com.appnext.core.k
 *  com.appnext.core.p
 *  java.lang.CharSequence
 *  java.lang.Float
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appnext.R;
import com.appnext.ads.fullscreen.i;
import com.appnext.core.AppnextAd;
import com.appnext.core.f;
import com.appnext.core.k;
import com.appnext.core.p;
import java.util.ArrayList;

public final class e
extends Fragment {
    private i bc;
    private TextView bd;
    private int be = 0;
    private ArrayList<AppnextAd> bf;
    private Handler handler;
    Runnable tick = new Runnable(){

        public final void run() {
            e.this.handler.removeCallbacks((Runnable)this);
            if (e.c(e.this) == 0) {
                e.this.bc.videoSelected((AppnextAd)e.this.bf.get(0));
                e.this.report("pre_roll_noclick");
                return;
            }
            if (e.this.bd != null) {
                TextView textView = e.this.bd;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(e.this.be);
                stringBuilder.append(" sec");
                textView.setText((CharSequence)stringBuilder.toString());
            }
            e.this.handler.postDelayed(e.this.tick, 1000L);
        }
    };

    private void a(ViewGroup viewGroup, final AppnextAd appnextAd, final int n2) {
        TextView textView = (TextView)viewGroup.findViewById(R.id.title);
        final ImageView imageView = (ImageView)viewGroup.findViewById(R.id.icon);
        final ImageView imageView2 = (ImageView)viewGroup.findViewById(R.id.background_image);
        RatingBar ratingBar = (RatingBar)viewGroup.findViewById(R.id.ratingBar);
        if (viewGroup.findViewById(R.id.playGameTextView) != null) {
            ((TextView)viewGroup.findViewById(R.id.playGameTextView)).setText((CharSequence)this.bc.getConfigManager().get("pre_cta_string"));
        }
        textView.setText((CharSequence)appnextAd.getAdTitle());
        ratingBar.setRating(Float.parseFloat((String)appnextAd.getStoreRating()));
        viewGroup.findViewById(R.id.click).setOnClickListener(new View.OnClickListener(){

            public final void onClick(View view) {
                e.this.bc.videoSelected(appnextAd);
                int n22 = n2;
                if (n22 == 0) {
                    e.this.report("pre_roll_left_click");
                    return;
                }
                if (n22 == 1) {
                    e.this.report("pre_roll_right_click");
                }
            }
        });
        if (imageView2 != null) {
            new Thread(new Runnable(){

                public final void run() {
                    final Bitmap bitmap = f.Z((String)appnextAd.getWideImageURL());
                    final Bitmap bitmap2 = f.Z((String)appnextAd.getImageURL());
                    new Handler(Looper.getMainLooper()).post(new Runnable(){

                        public final void run() {
                            imageView2.setImageBitmap(bitmap);
                            imageView.setImageBitmap(bitmap2);
                        }
                    });
                }

            }).start();
        }
        new Thread(new Runnable(){

            public final void run() {
                final Bitmap bitmap = imageView2 != null ? f.Z((String)appnextAd.getWideImageURL()) : null;
                final Bitmap bitmap2 = f.Z((String)appnextAd.getImageURL());
                new Handler(Looper.getMainLooper()).post(new Runnable(){

                    public final void run() {
                        if (imageView2 != null) {
                            imageView2.setImageBitmap(bitmap);
                        }
                        imageView.setImageBitmap(bitmap2);
                    }
                });
            }

        }).start();
    }

    static /* synthetic */ int c(e e2) {
        int n2;
        e2.be = n2 = -1 + e2.be;
        return n2;
    }

    private void report(String string2) {
        this.bc.report(string2, "S1");
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.bc = (i)activity;
        this.handler = new Handler();
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        this.bc = (i)context;
        this.handler = new Handler();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.getArguments() != null && this.getArguments().containsKey("time")) {
            this.be = this.getArguments().getInt("time");
        }
        if (bundle != null) {
            this.be = bundle.getInt("time");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        RelativeLayout relativeLayout;
        View view2;
        block4 : {
            try {
                relativeLayout = (RelativeLayout)layoutInflater.inflate(this.bc.getTemplate("S1"), viewGroup, false);
                view2 = relativeLayout.findViewById(R.id.item1);
                view = relativeLayout.findViewById(R.id.item2);
                ((TextView)relativeLayout.findViewById(R.id.title)).setText((CharSequence)this.bc.getConfigManager().get("pre_title_string1"));
                ((TextView)relativeLayout.findViewById(R.id.secondTile)).setText((CharSequence)this.bc.getConfigManager().get("pre_title_string2"));
                this.bd = (TextView)relativeLayout.findViewById(R.id.timer);
                this.bf = this.bc.getPreRollAds();
                if (this.bf.size() >= 2) break block4;
                this.bc.videoSelected((AppnextAd)this.bf.get(0));
                return null;
            }
            catch (Throwable throwable) {
                this.bc.closeClicked();
                return null;
            }
        }
        this.a((ViewGroup)view2, (AppnextAd)this.bf.get(0), 0);
        this.a((ViewGroup)view, (AppnextAd)this.bf.get(1), 1);
        relativeLayout.findViewById(R.id.privacy).setOnClickListener(new View.OnClickListener(){

            public final void onClick(View view) {
                e.this.bc.privacyClicked();
            }
        });
        if (k.a((AppnextAd)((AppnextAd)this.bf.get(0)), (p)this.bc.getConfigManager())) {
            k.a((Context)((Context)this.bc), (ImageView)((ImageView)relativeLayout.findViewById(R.id.privacy)));
        }
        TextView textView = this.bd;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.be);
        stringBuilder.append(" sec");
        textView.setText((CharSequence)stringBuilder.toString());
        this.report("pre_roll_loaded");
        return relativeLayout;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.handler.removeCallbacksAndMessages(null);
    }

    public final void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.tick);
    }

    public final void onResume() {
        super.onResume();
        this.handler.postDelayed(this.tick, 1000L);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("time", this.be);
        super.onSaveInstanceState(bundle);
    }

}

