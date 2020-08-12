/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.github.barteksc.pdfviewer.util;

import java.util.ArrayList;

public class ArrayUtils {
    public static int[] calculateIndexesInDuplicateArray(int[] arrn) {
        int[] arrn2 = new int[arrn.length];
        if (arrn.length == 0) {
            return arrn2;
        }
        int n2 = 0;
        arrn2[0] = 0;
        for (int i2 = 1; i2 < arrn.length; ++i2) {
            if (arrn[i2] != arrn[i2 - 1]) {
                // empty if block
            }
            arrn2[i2] = ++n2;
        }
        return arrn2;
    }

    public static int[] deleteDuplicatedPages(int[] arrn) {
        ArrayList arrayList = new ArrayList();
        int n2 = arrn.length;
        int n3 = 0;
        int n4 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            Integer n5 = arrn[i2];
            if (n4 != n5) {
                arrayList.add((Object)n5);
            }
            n4 = n5;
        }
        int[] arrn2 = new int[arrayList.size()];
        while (n3 < arrayList.size()) {
            arrn2[n3] = (Integer)arrayList.get(n3);
            ++n3;
        }
        return arrn2;
    }
}

