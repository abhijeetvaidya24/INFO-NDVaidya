/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.MenuItem
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.ui.navigationdrawerwidget;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;

public class DrawerWidgetModel {
    private String description;
    private final Drawable imageDrawable;
    private boolean isDivider;
    private final int menuId;

    public DrawerWidgetModel(Drawable drawable2, int n2, String string2) {
        this.imageDrawable = drawable2;
        this.menuId = n2;
        this.description = string2;
    }

    public String getDescription() {
        return this.description;
    }

    Drawable getImageDrawable() {
        return this.imageDrawable;
    }

    int getMenuId() {
        return this.menuId;
    }

    public boolean isDivider() {
        return this.isDivider;
    }

    public void select() {
        final MainNavigationActivity mainNavigationActivity = Factory.getInstance().getMainNavigationActivity();
        if (mainNavigationActivity != null) {
            mainNavigationActivity.runOnUiThread(new Runnable(){

                public void run() {
                    mainNavigationActivity.onOptionsItemSelected(DrawerWidgetModel.this.menuId, null);
                }
            });
        }
    }

    public void setDivider(boolean bl) {
        this.isDivider = bl;
    }

}

