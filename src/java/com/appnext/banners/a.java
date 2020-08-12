/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.media.MediaPlayer
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.VideoView
 *  com.appnext.banners.BannerAdData
 *  com.appnext.banners.LargeBannerAd
 *  com.appnext.banners.MediumRectangleAd
 *  com.appnext.banners.SmallBannerAd
 *  com.appnext.banners.i
 *  com.appnext.core.AppnextAd
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 */
package com.appnext.banners;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;
import com.appnext.banners.BannerAd;
import com.appnext.banners.BannerAdData;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerListener;
import com.appnext.banners.BannerSize;
import com.appnext.banners.LargeBannerAd;
import com.appnext.banners.MediumRectangleAd;
import com.appnext.banners.R;
import com.appnext.banners.SmallBannerAd;
import com.appnext.banners.a;
import com.appnext.banners.b;
import com.appnext.banners.d;
import com.appnext.banners.e;
import com.appnext.banners.i;
import com.appnext.banners.j;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.AppnextError;
import com.appnext.core.ECPM;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.d;
import com.appnext.core.e;
import com.appnext.core.f;
import com.appnext.core.p;
import com.appnext.core.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class a
extends e {
    private final int TICK = 330;
    private BannerAdRequest adRequest;
    private ArrayList<AppnextAd> ads;
    private BannerAd bannerAd;
    private boolean clickEnabled = true;
    private BannerAdData currentAd;
    private int currentPosition = 0;
    private boolean finished = false;
    private int lastProgress = 0;
    private boolean loaded = false;
    private Handler mHandler;
    private MediaPlayer mediaPlayer;
    private boolean reportedImpression = false;
    private i serviceHelper;
    private boolean started = false;
    private String template = "";
    private Runnable tick = new Runnable(this){
        final /* synthetic */ a cU;
        {
            this.cU = a2;
        }

        /*
         * Exception decompiling
         */
        public final void run(java.lang.IllegalStateException: Parameters not created
        
        