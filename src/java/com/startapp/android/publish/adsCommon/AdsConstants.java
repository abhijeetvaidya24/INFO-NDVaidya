/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.adsCommon;

import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.model.AdPreferences;

public class AdsConstants {
    public static final int AD_INFORMATION_EXTENDED_ID = 1475346434;
    public static final int AD_INFORMATION_ID = 1475346433;
    public static final Boolean FORCE_NATIVE_VIDEO_PLAYER;
    public static final int LIST_3D_CLOSE_BUTTON_ID = 1475346435;
    public static final String OVERRIDE_HOST;
    public static final Boolean OVERRIDE_NETWORK;
    public static final int SPLASH_NATIVE_MAIN_LAYOUT_ID = 1475346437;
    public static final int STARTAPP_AD_MAIN_LAYOUT_ID = 1475346432;
    public static final Boolean VIDEO_DEBUG;
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final Boolean g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String[] k;
    public static final String[] l;

    static {
        Boolean bl;
        a = new String(new byte[]{103, 101, 116});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(new String(new byte[]{97, 100, 115}));
        b = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(a);
        stringBuilder2.append(new String(new byte[]{104, 116, 109, 108, 97, 100}));
        c = stringBuilder2.toString();
        d = new String(new byte[]{116, 114, 97, 99, 107, 100, 111, 119, 110, 108, 111, 97, 100});
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(a);
        stringBuilder3.append(new String(new byte[]{97, 100, 115, 109, 101, 116, 97, 100, 97, 116, 97}));
        e = stringBuilder3.toString();
        f = new String(new byte[]{104, 116, 116, 112, 115, 58, 47, 47, 105, 109, 112, 46, 115, 116, 97, 114, 116, 97, 112, 112, 115, 101, 114, 118, 105, 99, 101, 46, 99, 111, 109, 47, 116, 114, 97, 99, 107, 105, 110, 103, 47, 97, 100, 73, 109, 112, 114, 101, 115, 115, 105, 111, 110});
        OVERRIDE_HOST = null;
        OVERRIDE_NETWORK = bl = Boolean.valueOf((boolean)false);
        g = bl;
        VIDEO_DEBUG = bl;
        FORCE_NATIVE_VIDEO_PLAYER = bl;
        h = i.b();
        i = i.c();
        j = i.d();
        k = new String[]{"back_", "back_dark", "browser_icon_dark", "forward_", "forward_dark", "x_dark"};
        l = new String[]{"empty_star", "filled_star", "half_star"};
    }

    public static Boolean a() {
        return VIDEO_DEBUG;
    }

    public static String a(AdApiType adApiType, AdPreferences.Placement placement) {
        String string;
        String string2;
        int n2 = 1.b[adApiType.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                string = null;
                string2 = null;
            } else {
                string = b;
                string2 = MetaData.getInstance().getAdPlatformHost(placement);
            }
        } else {
            string = c;
            string2 = MetaData.getInstance().getAdPlatformHost(placement);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static String a(ServiceApiType serviceApiType) {
        String string;
        String string2;
        int n2 = 1.a[serviceApiType.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                string2 = null;
                string = null;
            } else {
                string2 = d;
                string = MetaData.getInstance().getAdPlatformHost();
            }
        } else {
            string2 = e;
            string = MetaData.getInstance().getMetaDataHost();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static final class AdApiType
    extends Enum<AdApiType> {
        private static final /* synthetic */ AdApiType[] $VALUES;
        public static final /* enum */ AdApiType HTML = new AdApiType();
        public static final /* enum */ AdApiType JSON = new AdApiType();

        static {
            AdApiType[] arradApiType = new AdApiType[]{HTML, JSON};
            $VALUES = arradApiType;
        }

        public static AdApiType valueOf(String string) {
            return (AdApiType)Enum.valueOf(AdApiType.class, (String)string);
        }

        public static AdApiType[] values() {
            return (AdApiType[])$VALUES.clone();
        }
    }

    public static final class ServiceApiType
    extends Enum<ServiceApiType> {
        private static final /* synthetic */ ServiceApiType[] $VALUES;
        public static final /* enum */ ServiceApiType DOWNLOAD;
        public static final /* enum */ ServiceApiType METADATA;

        static {
            METADATA = new ServiceApiType();
            DOWNLOAD = new ServiceApiType();
            ServiceApiType[] arrserviceApiType = new ServiceApiType[]{METADATA, DOWNLOAD};
            $VALUES = arrserviceApiType;
        }

        public static ServiceApiType valueOf(String string) {
            return (ServiceApiType)Enum.valueOf(ServiceApiType.class, (String)string);
        }

        public static ServiceApiType[] values() {
            return (ServiceApiType[])$VALUES.clone();
        }
    }

}

