/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.RelativeLayout
 *  com.appsgeyser.multiTabApp.controllers.ITabContentController
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.appsgeyser.multiTabApp.controllers.ITabContentController;

public class TabContent
extends RelativeLayout {
    protected TabContent(Context context) {
        super(context);
    }

    protected TabContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void init(ITabContentController iTabContentController) {
    }

    public static final class TabType
    extends Enum<TabType> {
        private static final /* synthetic */ TabType[] $VALUES;
        public static final /* enum */ TabType PDF;
        public static final /* enum */ TabType WEB;

        static {
            WEB = new TabType();
            PDF = new TabType();
            TabType[] arrtabType = new TabType[]{WEB, PDF};
            $VALUES = arrtabType;
        }

        public static TabType valueOf(String string2) {
            return (TabType)Enum.valueOf(TabType.class, (String)string2);
        }

        public static TabType[] values() {
            return (TabType[])$VALUES.clone();
        }
    }

}

