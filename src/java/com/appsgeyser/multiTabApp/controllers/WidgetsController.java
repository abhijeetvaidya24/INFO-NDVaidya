/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Enumeration
 *  java.util.Iterator
 *  java.util.Vector
 */
package com.appsgeyser.multiTabApp.controllers;

import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.model.WidgetEntity;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class WidgetsController
implements Serializable {
    private Vector<WidgetEntity> _widgetCollection = new Vector();

    public void addWidget(WidgetEntity widgetEntity) {
        this._widgetCollection.add((Object)widgetEntity);
        WidgetEntityComparator widgetEntityComparator = new WidgetEntityComparator();
        Collections.sort(this._widgetCollection, (Comparator)widgetEntityComparator);
    }

    public Enumeration<WidgetEntity> getEnumeration() {
        return this._widgetCollection.elements();
    }

    /*
     * Enabled aggressive block sorting
     */
    public WidgetEntity getTabByPosition(int n2) {
        Iterator iterator = this._widgetCollection.iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            WidgetEntity widgetEntity = (WidgetEntity)iterator.next();
            if (Factory.getInstance().getMainNavigationActivity().getConfig().getTabsPosition() == WebWidgetConfiguration.TabsPositions.BOTTOM_MENU) {
                if (n3 == n2) {
                    return widgetEntity;
                }
            } else {
                if (!widgetEntity.isShowAsTab()) continue;
                if (n3 == n2) {
                    return widgetEntity;
                }
            }
            ++n3;
        }
        return null;
    }

    public WidgetEntity getWidgetByTabId(String string2) {
        Enumeration enumeration = this._widgetCollection.elements();
        while (enumeration.hasMoreElements()) {
            WidgetEntity widgetEntity = (WidgetEntity)enumeration.nextElement();
            if (!widgetEntity.getTabId().equalsIgnoreCase(string2)) continue;
            return widgetEntity;
        }
        return null;
    }

    public Vector<WidgetEntity> getWidgetCollection() {
        return this._widgetCollection;
    }

    int getWidgetPositionByTabId(String string2) {
        for (int i2 = 0; i2 < this._widgetCollection.size(); ++i2) {
            if (!((WidgetEntity)this._widgetCollection.get(i2)).getTabId().equals((Object)string2)) continue;
            return i2;
        }
        return -1;
    }

    public void removeAll() {
        this._widgetCollection.removeAllElements();
    }

    public void sortCollectionByShowingTabs() {
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        for (WidgetEntity widgetEntity : this._widgetCollection) {
            if (widgetEntity.isShowAsTab()) {
                vector.add((Object)widgetEntity);
                continue;
            }
            vector2.add((Object)widgetEntity);
        }
        vector.addAll((Collection)vector2);
        this._widgetCollection = vector;
    }

    public int tabsCount() {
        if (Factory.getInstance().getMainNavigationActivity().getConfig().getTabsPosition() == WebWidgetConfiguration.TabsPositions.BOTTOM_MENU) {
            return this._widgetCollection.size();
        }
        int n2 = 0;
        Iterator iterator = this._widgetCollection.iterator();
        while (iterator.hasNext()) {
            if (!((WidgetEntity)iterator.next()).isShowAsTab()) continue;
            ++n2;
        }
        return n2;
    }

    public int widgetsCount() {
        return this._widgetCollection.size();
    }

    class WidgetEntityComparator
    implements Comparator<WidgetEntity> {
        WidgetEntityComparator() {
        }

        public int compare(WidgetEntity widgetEntity, WidgetEntity widgetEntity2) {
            String string2 = widgetEntity.getId();
            String string3 = widgetEntity2.getId();
            if (string2.indexOf("tab") == 0 && string3.indexOf("tab") == 0) {
                return Integer.valueOf((int)Integer.parseInt((String)string2.substring(3))).compareTo(Integer.valueOf((int)Integer.parseInt((String)string3.substring(3))));
            }
            return widgetEntity.getId().compareTo(widgetEntity2.getId());
        }
    }

}

