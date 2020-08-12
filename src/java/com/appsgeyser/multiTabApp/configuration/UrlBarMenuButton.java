/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.configuration;

import java.io.Serializable;

public class UrlBarMenuButton
implements Serializable {
    private UrlBarMenuButtonTypes type;

    UrlBarMenuButton(UrlBarMenuButtonTypes urlBarMenuButtonTypes) {
        this.type = urlBarMenuButtonTypes;
    }

    public UrlBarMenuButtonTypes getType() {
        return this.type;
    }

    public void setType(UrlBarMenuButtonTypes urlBarMenuButtonTypes) {
        this.type = urlBarMenuButtonTypes;
    }

    public static final class UrlBarMenuButtonTypes
    extends Enum<UrlBarMenuButtonTypes> {
        private static final /* synthetic */ UrlBarMenuButtonTypes[] $VALUES;
        public static final /* enum */ UrlBarMenuButtonTypes ADD_TO_HOME;
        public static final /* enum */ UrlBarMenuButtonTypes BACK;
        public static final /* enum */ UrlBarMenuButtonTypes DOWNLOADS_LIST;
        public static final /* enum */ UrlBarMenuButtonTypes FORWARD;
        public static final /* enum */ UrlBarMenuButtonTypes HOME;
        public static final /* enum */ UrlBarMenuButtonTypes ICON;
        public static final /* enum */ UrlBarMenuButtonTypes LINK;
        public static final /* enum */ UrlBarMenuButtonTypes REFRESH;
        public static final /* enum */ UrlBarMenuButtonTypes REQUEST_DESKTOP;
        public static final /* enum */ UrlBarMenuButtonTypes URL_BUTTON;

        static {
            BACK = new UrlBarMenuButtonTypes();
            FORWARD = new UrlBarMenuButtonTypes();
            REFRESH = new UrlBarMenuButtonTypes();
            REQUEST_DESKTOP = new UrlBarMenuButtonTypes();
            ADD_TO_HOME = new UrlBarMenuButtonTypes();
            HOME = new UrlBarMenuButtonTypes();
            URL_BUTTON = new UrlBarMenuButtonTypes();
            LINK = new UrlBarMenuButtonTypes();
            ICON = new UrlBarMenuButtonTypes();
            DOWNLOADS_LIST = new UrlBarMenuButtonTypes();
            UrlBarMenuButtonTypes[] arrurlBarMenuButtonTypes = new UrlBarMenuButtonTypes[]{BACK, FORWARD, REFRESH, REQUEST_DESKTOP, ADD_TO_HOME, HOME, URL_BUTTON, LINK, ICON, DOWNLOADS_LIST};
            $VALUES = arrurlBarMenuButtonTypes;
        }

        public static UrlBarMenuButtonTypes valueOf(String string2) {
            return (UrlBarMenuButtonTypes)Enum.valueOf(UrlBarMenuButtonTypes.class, (String)string2);
        }

        public static UrlBarMenuButtonTypes[] values() {
            return (UrlBarMenuButtonTypes[])$VALUES.clone();
        }
    }

}

