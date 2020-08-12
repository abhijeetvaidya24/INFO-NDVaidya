/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  com.appsgeyser.multiTabApp.controllers.ITabContentController
 *  com.appsgeyser.multiTabApp.controllers.WebContentController
 *  java.lang.Exception
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
package com.appsgeyser.multiTabApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.controllers.INavigationController;
import com.appsgeyser.multiTabApp.controllers.ITabContentController;
import com.appsgeyser.multiTabApp.controllers.WebContentController;
import com.appsgeyser.multiTabApp.controllers.WidgetsController;
import com.appsgeyser.multiTabApp.model.WidgetEntity;
import com.appsgeyser.multiTabApp.storage.BookmarksManager;
import com.appsgeyser.multiTabApp.ui.navigationwidget.INavigationWidget;
import com.appsgeyser.multiTabApp.ui.views.TabContent;
import java.util.HashMap;

public class Factory {
    private static Factory _instance;
    private MainNavigationActivity _activity;
    private BookmarksManager _homePageManager;
    private INavigationController _navigationController;
    private INavigationWidget _navigationWidget = null;
    private WidgetsController _widgetsController = new WidgetsController();
    private HashMap<String, BookmarksManager> bookmarkManagers = new HashMap();
    private ITabContentController tccRes = null;

    private Factory() {
    }

    public static Factory getInstance() {
        if (_instance == null) {
            _instance = new Factory();
        }
        return _instance;
    }

    public void Init(MainNavigationActivity mainNavigationActivity) {
        this._activity = mainNavigationActivity;
    }

    public BookmarksManager getBookmarkManager(String string2) {
        if (!this.bookmarkManagers.containsKey((Object)string2)) {
            this.bookmarkManagers.put((Object)string2, (Object)new BookmarksManager(string2, (Context)this._activity));
        }
        return (BookmarksManager)((Object)this.bookmarkManagers.get((Object)string2));
    }

    public BookmarksManager getHomePageManager() {
        if (this._homePageManager == null) {
            this._homePageManager = new BookmarksManager("Homepage", (Context)this._activity);
        }
        return this._homePageManager;
    }

    public MainNavigationActivity getMainNavigationActivity() {
        return this._activity;
    }

    public INavigationWidget getNavigationWidget() {
        return this._navigationWidget;
    }

    public View getTabContent(TabContent.TabType tabType, LayoutInflater layoutInflater, ViewGroup viewGroup) throws Exception {
        int n2 = 1.$SwitchMap$com$appsgeyser$multiTabApp$ui$views$TabContent$TabType[tabType.ordinal()];
        if (n2 != 1) {
            if (n2 == 2) {
                return layoutInflater.inflate(2131492979, viewGroup, false);
            }
            throw new Exception("Unknown Content Type");
        }
        return layoutInflater.inflate(2131493005, viewGroup, false);
    }

    public ITabContentController getTabContentController(WidgetEntity widgetEntity) {
        this.tccRes = new WebContentController(widgetEntity);
        this.tccRes.setMainNavigationActivity(this._activity);
        return this.tccRes;
    }

    public INavigationController getTabsController() {
        return this._navigationController;
    }

    public ITabContentController getWebContentController() {
        return this.tccRes;
    }

    public WidgetsController getWidgetsController() {
        return this._widgetsController;
    }

    public void setNavigationController(INavigationController iNavigationController) {
        this._navigationController = iNavigationController;
    }

    public void setNavigationWidget(INavigationWidget iNavigationWidget) {
        this._navigationWidget = iNavigationWidget;
    }

    public void setWidgetsController(WidgetsController widgetsController) {
        this._widgetsController = widgetsController;
    }

}

