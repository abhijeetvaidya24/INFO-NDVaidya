/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.view.Display
 *  android.view.WindowManager
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.device.ads.AndroidBuildInfo;

class DisplayUtils {
    private static int[][] rotationArray = new int[][]{{1, 0, 9, 8}, {0, 9, 8, 1}};

    DisplayUtils() {
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int determineCanonicalScreenOrientation(Context context, AndroidBuildInfo androidBuildInfo) {
        boolean bl;
        int n;
        block6 : {
            block5 : {
                int n2;
                block4 : {
                    n = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
                    n2 = context.getResources().getConfiguration().orientation;
                    if (n2 != 1) break block4;
                    if (n == 0) break block5;
                    bl = false;
                    if (n != 2) break block6;
                    break block5;
                }
                if (n2 != 2 || n == 1) break block5;
                bl = false;
                if (n != 3) break block6;
            }
            bl = true;
        }
        int n3 = bl ^ true;
        return rotationArray[n3][n];
    }
}

