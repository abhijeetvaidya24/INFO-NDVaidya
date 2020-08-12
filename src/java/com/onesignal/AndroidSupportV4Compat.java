/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.onesignal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Process;
import android.util.Log;

class AndroidSupportV4Compat {

    static class ActivityCompat {
        static void requestPermissions(Activity activity, String[] arrstring, int n2) {
            ActivityCompatApi23.requestPermissions(activity, arrstring, n2);
        }
    }

    @TargetApi(value=23)
    static class ActivityCompatApi23 {
        static void requestPermissions(Activity activity, String[] arrstring, int n2) {
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator)activity).validateRequestPermissionsRequestCode(n2);
            }
            activity.requestPermissions(arrstring, n2);
        }
    }

    static class ContextCompat {
        static int checkSelfPermission(Context context, String string2) {
            try {
                int n2 = context.checkPermission(string2, Process.myPid(), Process.myUid());
                return n2;
            }
            catch (Throwable throwable) {
                Log.e((String)"OneSignal", (String)"checkSelfPermission failed, returning PERMISSION_DENIED");
                return -1;
            }
        }

        static int getColor(Context context, int n2) {
            if (Build.VERSION.SDK_INT > 22) {
                return context.getColor(n2);
            }
            return context.getResources().getColor(n2);
        }
    }

    static interface RequestPermissionsRequestCodeValidator {
        public void validateRequestPermissionsRequestCode(int var1);
    }

}

