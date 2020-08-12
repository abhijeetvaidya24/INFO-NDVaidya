/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.appsgeyser.multiTabApp.controllers.WebContentController
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.controllers;

import android.net.Uri;
import com.appsgeyser.multiTabApp.controllers.WebContentController;
import com.appsgeyser.multiTabApp.controllers.WidgetsController;

public interface INavigationController {
    public String findTabIdToOpenFromDeepLink(Uri var1);

    public void firstBannerWasShown();

    public WebContentController getSelectedTab();

    public int getSelectedTabId();

    public void initWithTabs(WidgetsController var1);

    public void isTabsControllerReady(OnTabsControllerReady var1);

    public boolean onBackKeyDown();

    public void onPause();

    public void onResume();

    public void setSwipeEnabled(boolean var1);

    public void swipeOnPage(int var1, boolean var2);

    public void swipeOnPageByTabId(String var1);

    public static interface OnTabsControllerReady {
        public void tabsControllerReady(boolean var1);
    }

}

