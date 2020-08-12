/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage;

import io.presage.CapGrisNez;
import io.presage.cl;
import io.presage.common.network.models.RewardItem;

public final class RouedeBrie {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);

    private static String a() {
        return "window.MRAID_ENV =  { version: '3.0', sdk: 'Presage', sdkVersion: '3.0.36-moat'};";
    }

    public static String a(CapGrisNez capGrisNez) {
        if (capGrisNez != null && cl.a((Object)capGrisNez.c(), (Object)"optin_video")) {
            return RouedeBrie.b(capGrisNez);
        }
        return RouedeBrie.a();
    }

    private static String b(CapGrisNez capGrisNez) {
        StringBuilder stringBuilder = new StringBuilder("window.MRAID_ENV =  { version: '3.0', sdk: 'Presage', sdkVersion: '3.0.36-moat', adUnit: { type: '");
        stringBuilder.append(capGrisNez.c());
        stringBuilder.append("', reward : { name: '");
        stringBuilder.append(capGrisNez.e().getName());
        stringBuilder.append("', value: '");
        stringBuilder.append(capGrisNez.e().getValue());
        stringBuilder.append("', launch: '");
        stringBuilder.append(capGrisNez.d());
        stringBuilder.append("'}}};");
        return stringBuilder.toString();
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }
    }

}

