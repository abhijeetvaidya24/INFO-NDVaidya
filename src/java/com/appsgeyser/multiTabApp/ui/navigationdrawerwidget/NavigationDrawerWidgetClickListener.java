/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Adapter
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListView
 *  androidx.drawerlayout.widget.DrawerLayout
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.lang.Object
 */
package com.appsgeyser.multiTabApp.ui.navigationdrawerwidget;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.controllers.INavigationController;
import com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.DrawerWidgetModel;
import com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.SelectItemController;

class NavigationDrawerWidgetClickListener
implements AdapterView.OnItemClickListener {
    private final MainNavigationActivity activity;
    private final ListView drawerListView;
    private final DrawerLayout navigationDrawer;
    private final INavigationController tabsController;

    NavigationDrawerWidgetClickListener(INavigationController iNavigationController, DrawerLayout drawerLayout, ListView listView, MainNavigationActivity mainNavigationActivity) {
        this.tabsController = iNavigationController;
        this.navigationDrawer = drawerLayout;
        this.drawerListView = listView;
        this.activity = mainNavigationActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
        DrawerWidgetModel drawerWidgetModel = (DrawerWidgetModel)adapterView.getAdapter().getItem(n2);
        if (drawerWidgetModel.getMenuId() != 0) {
            drawerWidgetModel.select();
        } else {
            SelectItemController.selectItem(this.drawerListView, n2, this.activity);
            this.tabsController.swipeOnPage((int)l2, false);
        }
        this.navigationDrawer.closeDrawers();
    }
}

