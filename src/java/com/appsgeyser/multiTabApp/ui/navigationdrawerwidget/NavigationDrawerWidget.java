/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  androidx.appcompat.app.ActionBarDrawerToggle
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.graphics.drawable.RoundedBitmapDrawable
 *  androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
 *  androidx.drawerlayout.widget.DrawerLayout
 *  androidx.drawerlayout.widget.DrawerLayout$DrawerListener
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.NavigationDrawerWidgetSimpleListener
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 */
package com.appsgeyser.multiTabApp.ui.navigationdrawerwidget;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.drawerlayout.widget.DrawerLayout;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.controllers.INavigationController;
import com.appsgeyser.multiTabApp.controllers.WidgetsController;
import com.appsgeyser.multiTabApp.model.WidgetEntity;
import com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.DrawerWidgetModel;
import com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.NavigationDrawerWidgetAdapter;
import com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.NavigationDrawerWidgetClickListener;
import com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.NavigationDrawerWidgetSimpleListener;
import com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.SelectItemController;
import java.util.ArrayList;
import java.util.Collection;

public class NavigationDrawerWidget {
    private final MainNavigationActivity activity;
    private final ListView drawerListView;
    private ArrayList<DrawerWidgetModel> drawerWidgetModels;
    private boolean hasOptions;
    private final boolean hasTabs;
    private final DrawerLayout navigationDrawer;
    private final NavigationDrawerWidgetSimpleListener navigationDrawerWidgetSimpleListener;
    private final ImageView sliderHandle;
    private final Animation sliderHandleAnimation;
    private final Animation sliderHandleHideAnimation;
    private final INavigationController tabsController = Factory.getInstance().getTabsController();
    private boolean userKnowsAboutDrawer;

    public NavigationDrawerWidget(MainNavigationActivity mainNavigationActivity, boolean bl, boolean bl2, boolean bl3) {
        this.activity = mainNavigationActivity;
        this.navigationDrawer = (DrawerLayout)mainNavigationActivity.findViewById(2131296401);
        this.drawerListView = (ListView)mainNavigationActivity.findViewById(2131296465);
        this.sliderHandle = (ImageView)mainNavigationActivity.findViewById(2131296587);
        this.sliderHandleAnimation = AnimationUtils.loadAnimation((Context)mainNavigationActivity, (int)2130771991);
        this.sliderHandleAnimation.setRepeatCount(-1);
        this.sliderHandleHideAnimation = AnimationUtils.loadAnimation((Context)mainNavigationActivity, (int)2130771992);
        if (bl) {
            this.addTabsInListView();
        }
        this.hasTabs = bl;
        if (bl2) {
            this.userKnowsAboutDrawer = mainNavigationActivity.getPreferences(0).getBoolean("com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.NavigationDrawerWidget.userKnowsAboutDrawer", false);
            if (!this.userKnowsAboutDrawer) {
                this.showSliderHandle();
            }
            new Handler().postDelayed(new Runnable(){

                public void run() {
                    NavigationDrawerWidget.this.hideSliderHandle();
                }
            }, 20000L);
        }
        if (bl3) {
            this.initHeader();
            mainNavigationActivity.findViewById(2131296480).setVisibility(0);
            Toolbar toolbar = (Toolbar)mainNavigationActivity.findViewById(2131296480);
            toolbar.showOverflowMenu();
            mainNavigationActivity.setSupportActionBar(toolbar);
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle((Activity)mainNavigationActivity, this.navigationDrawer, toolbar, 2131755149, 2131755148);
            this.navigationDrawer.addDrawerListener((DrawerLayout.DrawerListener)actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
            NavigationDrawerWidgetAdapter navigationDrawerWidgetAdapter = new NavigationDrawerWidgetAdapter((Context)mainNavigationActivity, this.drawerWidgetModels);
            this.drawerListView.setAdapter((ListAdapter)navigationDrawerWidgetAdapter);
        }
        this.navigationDrawerWidgetSimpleListener = new NavigationDrawerWidgetSimpleListener(this);
        this.navigationDrawer.addDrawerListener((DrawerLayout.DrawerListener)this.navigationDrawerWidgetSimpleListener);
        NavigationDrawerWidgetClickListener navigationDrawerWidgetClickListener = new NavigationDrawerWidgetClickListener(this.tabsController, this.navigationDrawer, this.drawerListView, mainNavigationActivity);
        this.drawerListView.setOnItemClickListener((AdapterView.OnItemClickListener)navigationDrawerWidgetClickListener);
    }

    private void addTabsInListView() {
        WidgetsController widgetsController = Factory.getInstance().getWidgetsController();
        this.drawerWidgetModels = new ArrayList(widgetsController.tabsCount());
        int n2 = widgetsController.tabsCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            WidgetEntity widgetEntity = widgetsController.getTabByPosition(i2);
            this.drawerWidgetModels.add((Object)new DrawerWidgetModel(null, 0, widgetEntity.getName()));
        }
        this.drawerListView.post(new Runnable(){

            public void run() {
                int n2 = 1 + NavigationDrawerWidget.this.tabsController.getSelectedTabId();
                SelectItemController.selectItem(NavigationDrawerWidget.this.drawerListView, n2, NavigationDrawerWidget.this.activity);
            }
        });
    }

    private void initHeader() {
        if (this.drawerListView.getHeaderViewsCount() == 0) {
            LinearLayout linearLayout = (LinearLayout)this.activity.getLayoutInflater().inflate(2131492959, (ViewGroup)this.drawerListView, false);
            ((TextView)linearLayout.findViewById(2131296508)).setText((CharSequence)this.activity.getString(2131755074));
            this.drawerListView.addHeaderView((View)linearLayout, null, false);
            this.setCircularIconHeader();
        }
    }

    private void setCircularIconHeader() {
        Resources resources = this.activity.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource((Resources)resources, (int)2131165426);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create((Resources)resources, (Bitmap)bitmap);
        roundedBitmapDrawable.setCornerRadius((float)Math.max((int)bitmap.getWidth(), (int)bitmap.getHeight()) / 0.2f);
        ((ImageView)this.activity.findViewById(2131296507)).setImageDrawable((Drawable)roundedBitmapDrawable);
    }

    private void showSliderHandle() {
        this.sliderHandle.setVisibility(0);
        this.sliderHandle.bringToFront();
        this.sliderHandle.startAnimation(this.sliderHandleAnimation);
    }

    public void close() {
        ListView listView;
        DrawerLayout drawerLayout = this.navigationDrawer;
        if (drawerLayout != null && (listView = this.drawerListView) != null) {
            drawerLayout.closeDrawer((View)listView);
        }
    }

    public void hideMenuItem(long l2) {
        NavigationDrawerWidgetAdapter navigationDrawerWidgetAdapter = (NavigationDrawerWidgetAdapter)((HeaderViewListAdapter)this.drawerListView.getAdapter()).getWrappedAdapter();
        for (int i2 = 0; i2 < navigationDrawerWidgetAdapter.getCount(); ++i2) {
            DrawerWidgetModel drawerWidgetModel = navigationDrawerWidgetAdapter.getItem(i2);
            if (drawerWidgetModel == null || (long)drawerWidgetModel.getMenuId() != l2) continue;
            navigationDrawerWidgetAdapter.remove((Object)drawerWidgetModel);
        }
        navigationDrawerWidgetAdapter.notifyDataSetChanged();
        this.drawerListView.invalidate();
    }

    void hideSliderHandle() {
        if (!this.userKnowsAboutDrawer) {
            this.userKnowsAboutDrawer = true;
            this.activity.getPreferences(0).edit().putBoolean("com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.NavigationDrawerWidget.userKnowsAboutDrawer", this.userKnowsAboutDrawer).apply();
        }
        this.sliderHandle.clearAnimation();
        this.sliderHandleHideAnimation.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                NavigationDrawerWidget.this.sliderHandle.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.sliderHandle.startAnimation(this.sliderHandleHideAnimation);
    }

    public boolean isOpened() {
        return this.navigationDrawerWidgetSimpleListener.isOpened();
    }

    public void open() {
        this.navigationDrawer.openDrawer(3);
    }

    public void remove() {
        ListView listView = (ListView)this.activity.findViewById(2131296465);
        if (listView != null) {
            listView.setVisibility(8);
        }
        this.navigationDrawer.setDrawerLockMode(1);
        this.tabsController.setSwipeEnabled(true);
    }

    public void setOptions(ArrayList<DrawerWidgetModel> arrayList) {
        if (!this.hasOptions) {
            this.initHeader();
            if (this.hasTabs) {
                DrawerWidgetModel drawerWidgetModel = new DrawerWidgetModel(null, 0, null);
                drawerWidgetModel.setDivider(true);
                this.drawerWidgetModels.add((Object)drawerWidgetModel);
            } else {
                this.drawerWidgetModels = new ArrayList(arrayList.size());
            }
            this.drawerWidgetModels.addAll(arrayList);
            NavigationDrawerWidgetAdapter navigationDrawerWidgetAdapter = new NavigationDrawerWidgetAdapter((Context)this.activity, this.drawerWidgetModels);
            this.drawerListView.setAdapter((ListAdapter)navigationDrawerWidgetAdapter);
            if (this.hasTabs) {
                this.drawerListView.post(new Runnable(){

                    public void run() {
                        int n2 = 1 + NavigationDrawerWidget.this.tabsController.getSelectedTabId();
                        SelectItemController.selectItem(NavigationDrawerWidget.this.drawerListView, n2, NavigationDrawerWidget.this.activity);
                    }
                });
            }
            this.hasOptions = true;
        }
    }

    public void show() {
        this.drawerListView.setVisibility(0);
        this.sliderHandle.bringToFront();
        this.navigationDrawer.setDrawerLockMode(0);
    }

}

