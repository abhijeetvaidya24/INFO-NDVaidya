/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.lang.Object
 */
package com.appsgeyser.multiTabApp.ui.navigationdrawerwidget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.appsgeyser.multiTabApp.MainNavigationActivity;

class SelectItemController {
    static void selectItem(ListView listView, int n2, MainNavigationActivity mainNavigationActivity) {
        for (int i2 = 1; i2 < listView.getCount(); ++i2) {
            View view = listView.getChildAt(i2);
            if (view != null) {
                SelectItemController.setColorInItem(view, i2, n2, mainNavigationActivity);
                continue;
            }
            ListView listView2 = (ListView)mainNavigationActivity.findViewById(2131296465);
            SelectItemController.setColorInItem(listView.getAdapter().getView(i2, null, (ViewGroup)listView2), i2, n2, mainNavigationActivity);
        }
    }

    private static void setColorInItem(View view, int n2, int n3, MainNavigationActivity mainNavigationActivity) {
        TextView textView = (TextView)view.findViewById(2131296400);
        if (textView != null) {
            if (n2 == n3) {
                view.setBackgroundColor(ContextCompat.getColor((Context)mainNavigationActivity, (int)2131034312));
                textView.setTextColor(ContextCompat.getColor((Context)mainNavigationActivity, (int)2131034180));
                return;
            }
            view.setBackgroundColor(ContextCompat.getColor((Context)mainNavigationActivity, (int)2131034326));
            textView.setTextColor(ContextCompat.getColor((Context)mainNavigationActivity, (int)2131034196));
        }
    }
}

