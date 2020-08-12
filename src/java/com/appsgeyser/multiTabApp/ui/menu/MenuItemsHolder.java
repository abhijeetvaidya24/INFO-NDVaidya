/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.webkit.WebView
 *  androidx.core.content.ContextCompat
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  com.appsgeyser.multiTabApp.configuration.UrlBarMenuLinkButton
 *  com.appsgeyser.multiTabApp.controllers.WebContentController
 *  com.appsgeyser.multiTabApp.ui.menu.MenuItemsHolder$2
 *  com.appsgeyser.multiTabApp.ui.menu.MenuItemsHolder$3
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.appsgeyser.multiTabApp.ui.menu;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.configuration.UrlBarMenuButton;
import com.appsgeyser.multiTabApp.configuration.UrlBarMenuLinkButton;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.controllers.INavigationController;
import com.appsgeyser.multiTabApp.controllers.WebContentController;
import com.appsgeyser.multiTabApp.ui.menu.MenuGenerator;
import com.appsgeyser.multiTabApp.ui.menu.MenuItemsHolder;
import com.appsgeyser.multiTabApp.ui.menu.MenuStructure;
import com.appsgeyser.multiTabApp.ui.navigationdrawerwidget.DrawerWidgetModel;
import com.appsgeyser.sdk.AppsgeyserSDK;
import java.util.ArrayList;

public class MenuItemsHolder {
    private Menu _menu;
    private MainNavigationActivity activity;
    private int itemOrderId = 50;
    public boolean trigger = true;

    public MenuItemsHolder(WebWidgetConfiguration webWidgetConfiguration, MainNavigationActivity.ApplicationMode applicationMode, MainNavigationActivity mainNavigationActivity, Menu menu) {
        if (mainNavigationActivity != null) {
            this._menu = menu;
            this._init(webWidgetConfiguration, applicationMode, (Activity)mainNavigationActivity);
            this.activity = mainNavigationActivity;
        }
    }

    public MenuItemsHolder(WebWidgetConfiguration webWidgetConfiguration, MainNavigationActivity mainNavigationActivity) {
        MainNavigationActivity.ApplicationMode applicationMode = webWidgetConfiguration.getApplicationMode();
        if (mainNavigationActivity != null) {
            this._menu = MenuGenerator.newEmptyMenuInstance((Context)mainNavigationActivity);
            this._init(webWidgetConfiguration, applicationMode, (Activity)mainNavigationActivity);
            this.activity = mainNavigationActivity;
        }
    }

    private void _applyItemsVisibility(Activity activity, WebWidgetConfiguration webWidgetConfiguration, MainNavigationActivity.ApplicationMode applicationMode) {
        if (!webWidgetConfiguration.getUrlOverlayState().equals((Object)WebWidgetConfiguration.UrlBarStates.DISABLED)) {
            for (UrlBarMenuButton urlBarMenuButton : webWidgetConfiguration.getUrlBarMenuButtons()) {
                if (urlBarMenuButton.getType().equals((Object)UrlBarMenuButton.UrlBarMenuButtonTypes.BACK)) {
                    this._menu.findItem(2131296680).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals((Object)UrlBarMenuButton.UrlBarMenuButtonTypes.FORWARD)) {
                    this._menu.findItem(2131296683).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals((Object)UrlBarMenuButton.UrlBarMenuButtonTypes.REQUEST_DESKTOP)) {
                    this._menu.findItem(2131296687).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals((Object)UrlBarMenuButton.UrlBarMenuButtonTypes.ADD_TO_HOME)) {
                    this._menu.findItem(2131296678).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals((Object)UrlBarMenuButton.UrlBarMenuButtonTypes.HOME)) {
                    this._menu.findItem(2131296684).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals((Object)UrlBarMenuButton.UrlBarMenuButtonTypes.DOWNLOADS_LIST)) {
                    this._menu.findItem(2131296681).setVisible(true);
                }
                if (!urlBarMenuButton.getType().equals((Object)UrlBarMenuButton.UrlBarMenuButtonTypes.LINK) || !(urlBarMenuButton instanceof UrlBarMenuLinkButton)) continue;
                final UrlBarMenuLinkButton urlBarMenuLinkButton = (UrlBarMenuLinkButton)urlBarMenuButton;
                MenuItem.OnMenuItemClickListener onMenuItemClickListener = new MenuItem.OnMenuItemClickListener(){

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Factory.getInstance().getTabsController().getSelectedTab().getWebView().loadUrl(urlBarMenuLinkButton.getUrl());
                        return false;
                    }
                };
                this._menu.add(0, urlBarMenuLinkButton.getTitle().hashCode(), this.itemOrderId, (CharSequence)urlBarMenuLinkButton.getTitle()).setOnMenuItemClickListener(onMenuItemClickListener);
            }
        }
        AppsgeyserSDK.isAboutDialogEnabled((Context)activity, (AppsgeyserSDK.OnAboutDialogEnableListener)new 2(this));
        AppsgeyserSDK.areInAppPurchasesEnabled((Context)activity, (AppsgeyserSDK.OnInAppPurchasesEnableListener)new 3(this));
        if (applicationMode == MainNavigationActivity.ApplicationMode.CUSTOM) {
            this._menu.findItem(2131296689).setVisible(false);
        } else {
            this._menu.findItem(2131296689).setVisible(true);
        }
        this._menu.findItem(2131296685).setVisible(webWidgetConfiguration.getRateItemVisibility());
        this._menu.findItem(2131296686).setVisible(webWidgetConfiguration.getShowRefreshMenuItem());
        this._menu.findItem(2131296682).setVisible(webWidgetConfiguration.getShowExitMenuItem());
        this._menu.findItem(2131296689).setVisible(webWidgetConfiguration.getShowShareMenuItem());
        this._menu.findItem(2131296681).setVisible(webWidgetConfiguration.getShowDownloadList());
        this._menu.findItem(2131296688).setVisible(webWidgetConfiguration.getShowSettings());
        this._menu.findItem(2131296690).setVisible(true);
    }

    private void _init(WebWidgetConfiguration webWidgetConfiguration, MainNavigationActivity.ApplicationMode applicationMode, Activity activity) {
        activity.getMenuInflater().inflate(2131558401, this._menu);
        this._applyItemsVisibility(activity, webWidgetConfiguration, applicationMode);
    }

    static /* synthetic */ Menu access$000(MenuItemsHolder menuItemsHolder) {
        return menuItemsHolder._menu;
    }

    public ArrayList<DrawerWidgetModel> getAllItems() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this._menu.size(); ++i2) {
            MenuItem menuItem = this._menu.getItem(i2);
            if (menuItem.getItemId() == 2131296687 || !menuItem.isVisible()) continue;
            int n2 = menuItem.getItemId();
            arrayList.add((Object)new DrawerWidgetModel(ContextCompat.getDrawable((Context)this.activity, (int)MenuStructure.getIconResourceIdByItemId(n2)), n2, menuItem.getTitle().toString()));
        }
        return arrayList;
    }

    public Menu getMenu() {
        return this._menu;
    }

    public void setItemVisible(int n2, boolean bl) {
        MenuItem menuItem = this._menu.findItem(n2);
        if (menuItem != null) {
            menuItem.setVisible(bl);
        }
    }

}

