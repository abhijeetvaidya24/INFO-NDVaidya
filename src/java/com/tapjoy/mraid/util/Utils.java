/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 */
package com.tapjoy.mraid.util;

import android.os.Bundle;

public class Utils {
    public static String byteToHex(byte by2) {
        char[] arrc = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] arrc2 = new char[]{arrc[15 & by2 >> 4], arrc[by2 & 15]};
        return new String(arrc2);
    }

    public static String convert(String string2) {
        byte[] arrby = string2.getBytes();
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = 0;
        do {
            block7 : {
                try {
                    if (n2 < arrby.length) {
                        if ((128 & arrby[n2]) > 0) {
                            StringBuilder stringBuilder = new StringBuilder("%");
                            stringBuilder.append(Utils.byteToHex(arrby[n2]));
                            stringBuffer.append(stringBuilder.toString());
                        } else {
                            stringBuffer.append((char)arrby[n2]);
                        }
                        break block7;
                    }
                    String string3 = new String(stringBuffer.toString().getBytes(), "ISO-8859-1");
                    return string3;
                }
                catch (Exception exception) {
                    return null;
                }
            }
            ++n2;
        } while (true);
    }

    public static String getData(String string2, Bundle bundle) {
        return bundle.getString(string2);
    }
}

