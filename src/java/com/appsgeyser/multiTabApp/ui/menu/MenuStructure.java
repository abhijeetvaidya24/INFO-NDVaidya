/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.appsgeyser.multiTabApp.ui.menu;

import java.util.ArrayList;

public class MenuStructure {
    static ArrayList<Item> menuItems = new ArrayList();

    static {
        menuItems.add((Object)new Item(2131296686, 2131165459));
        menuItems.add((Object)new Item(2131296689, 2131165462));
        menuItems.add((Object)new Item(2131296677, 2131165455));
        menuItems.add((Object)new Item(2131296679, 2131165470));
        menuItems.add((Object)new Item(2131296685, 2131165458));
        menuItems.add((Object)new Item(2131296682, 2131165451));
        menuItems.add((Object)new Item(2131296690, 2131165457));
        menuItems.add((Object)new Item(2131296680, 2131165448));
        menuItems.add((Object)new Item(2131296683, 2131165449));
        menuItems.add((Object)new Item(2131296687, 2131165453));
        menuItems.add((Object)new Item(2131296678, 2131165456));
        menuItems.add((Object)new Item(2131296684, 2131165454));
        menuItems.add((Object)new Item(2131296681, 2131165447));
        menuItems.add((Object)new Item(2131296688, 2131165461));
    }

    public static int getIconResourceIdByItemId(int n2) {
        for (Item item : menuItems) {
            if (item.getItemId() != n2) continue;
            return item.getIconResourceId();
        }
        return -1000500;
    }

    public static class Item {
        private int _iconResourceId;
        private int _itemId;

        public Item(int n2, int n3) {
            this.setItemId(n2);
            this.setIconResourceId(n3);
        }

        public int getIconResourceId() {
            return this._iconResourceId;
        }

        public int getItemId() {
            return this._itemId;
        }

        public void setIconResourceId(int n2) {
            this._iconResourceId = n2;
        }

        public void setItemId(int n2) {
            this._itemId = n2;
        }
    }

}

