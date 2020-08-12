/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Constructor
 */
package com.appsgeyser.multiTabApp.ui.menu;

import android.content.Context;
import android.view.Menu;
import java.lang.reflect.Constructor;

public class MenuGenerator {
    public static Menu newEmptyMenuInstance(Context context) {
        try {
            Menu menu = (Menu)Class.forName((String)"com.android.internal.view.menu.MenuBuilder").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            return menu;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}

