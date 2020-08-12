/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  java.lang.Object
 */
package org.altbeacon.bluetooth;

import android.annotation.TargetApi;

public class Pdu {
    private byte[] mBytes;
    private int mDeclaredLength;
    private int mEndIndex;
    private int mStartIndex;
    private byte mType;

    @TargetApi(value=9)
    public static Pdu parse(byte[] arrby, int n2) {
        int n3;
        if (arrby.length - n2 >= 2 && (n3 = arrby[n2]) > 0) {
            byte by = arrby[n2 + 1];
            int n4 = n2 + 2;
            if (n4 < arrby.length) {
                Pdu pdu = new Pdu();
                pdu.mEndIndex = n2 + n3;
                if (pdu.mEndIndex >= arrby.length) {
                    pdu.mEndIndex = -1 + arrby.length;
                }
                pdu.mType = by;
                pdu.mDeclaredLength = n3;
                pdu.mStartIndex = n4;
                pdu.mBytes = arrby;
                return pdu;
            }
        }
        return null;
    }

    public int getDeclaredLength() {
        return this.mDeclaredLength;
    }

    public int getEndIndex() {
        return this.mEndIndex;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public byte getType() {
        return this.mType;
    }
}

