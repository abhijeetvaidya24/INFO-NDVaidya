/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.StringUtils;

class Base64 {
    private static final String ENCODE_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    Base64() {
    }

    public static byte[] decode(String string) {
        IllegalArgumentException illegalArgumentException;
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            int n = Base64.getDecodedLength(string);
            if (n > 0) {
                byte[] arrby = new byte[n];
                int n2 = 0;
                for (int i2 = 0; i2 < string.length(); ++i2) {
                    if (n2 >= n) {
                        return arrby;
                    }
                    int n3 = i2 % 4;
                    if (n3 == 0 && string.length() < i2 + 4) {
                        return arrby;
                    }
                    int n4 = ENCODE_CHARSET.indexOf((int)string.charAt(i2));
                    if (n4 == -1) {
                        return arrby;
                    }
                    if (n3 != 0) {
                        int n5;
                        if (n3 != 1) {
                            if (n3 != 2) {
                                if (n3 != 3) continue;
                                n5 = n2 + 1;
                                arrby[n2] = (byte)(arrby[n2] | (byte)(n4 & 63));
                            } else {
                                n5 = n2 + 1;
                                arrby[n2] = (byte)(arrby[n2] | (byte)(15 & n4 >> 2));
                                if (n5 < n) {
                                    arrby[n5] = (byte)(n4 << 6);
                                }
                            }
                        } else {
                            n5 = n2 + 1;
                            arrby[n2] = (byte)(arrby[n2] | (byte)(3 & n4 >> 4));
                            if (n5 < n) {
                                arrby[n5] = (byte)(n4 << 4);
                            }
                        }
                        n2 = n5;
                        continue;
                    }
                    arrby[n2] = (byte)(n4 << 2);
                }
                return arrby;
            }
            throw new IllegalArgumentException("Encoded String decodes to zero bytes");
        }
        illegalArgumentException = new IllegalArgumentException("Encoded String must not be null or white space");
        throw illegalArgumentException;
    }

    private static int getDecodedLength(String string) {
        int n = string.indexOf("=");
        int n2 = n > -1 ? string.length() - n : 0;
        return 3 * ((3 + string.length()) / 4) - n2;
    }
}

