/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.tapjoy.mraid.controller.Abstract$Dimensions
 *  com.tapjoy.mraid.controller.Abstract$PlayerProperties
 *  com.tapjoy.mraid.view.ActionHandler$1
 *  com.tapjoy.mraid.view.MraidView
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tapjoy.mraid.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.MraidPlayer;
import com.tapjoy.mraid.util.Utils;
import com.tapjoy.mraid.view.ActionHandler;
import com.tapjoy.mraid.view.MraidView;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ActionHandler
extends Activity {
    private HashMap a = new HashMap();
    private RelativeLayout b;

    private MraidPlayer a(Bundle bundle, MraidView.Action action) {
        RelativeLayout.LayoutParams layoutParams;
        Abstract.PlayerProperties playerProperties = bundle.getParcelable("player_properties");
        Abstract.Dimensions dimensions = bundle.getParcelable("expand_dimensions");
        MraidPlayer mraidPlayer = new MraidPlayer((Context)this);
        mraidPlayer.setPlayData(playerProperties, Utils.getData("expand_url", bundle));
        if (!playerProperties.inline && playerProperties.startStyle.equals((Object)"fullscreen")) {
            this.getWindow().setFlags(1024, 1024);
            this.getWindow().setFlags(16777216, 16777216);
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(dimensions.width, dimensions.height);
            layoutParams.topMargin = dimensions.y;
            layoutParams.leftMargin = dimensions.x;
        }
        mraidPlayer.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.b.addView((View)mraidPlayer);
        this.a.put((Object)action, (Object)mraidPlayer);
        mraidPlayer.setListener((Player)new 1(this));
        return mraidPlayer;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        Bundle bundle2 = this.getIntent().getExtras();
        this.b = new RelativeLayout((Context)this);
        this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.b.setBackgroundColor(-16777216);
        this.setContentView((View)this.b);
        String string2 = bundle2.getString("action");
        if (string2 != null) {
            MraidView.Action action = MraidView.Action.valueOf(string2);
            int n2 = 2.a[action.ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    return;
                }
                this.a(bundle2, action).playVideo();
                return;
            }
            this.a(bundle2, action).playAudio();
        }
    }

    protected void onStop() {
        for (Map.Entry entry : this.a.entrySet()) {
            int n2 = 2.a[((MraidView.Action)((Object)entry.getKey())).ordinal()];
            if (n2 != 1 && n2 != 2) continue;
            ((MraidPlayer)((Object)entry.getValue())).releasePlayer();
        }
        super.onStop();
    }

}

