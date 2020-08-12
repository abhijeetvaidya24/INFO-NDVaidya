/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.core.app.ActivityCompat
 *  com.appsgeyser.sdk.InternalEntryPoint
 *  com.appsgeyser.sdk.datasdk.DataSdkActivity
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.appsgeyser.sdk.datasdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.appsgeyser.sdk.AppsgeyserSDK;
import com.appsgeyser.sdk.InternalEntryPoint;
import com.appsgeyser.sdk.R;
import com.appsgeyser.sdk.configuration.PreferencesCoder;
import com.appsgeyser.sdk.configuration.models.ConfigPhp;
import com.appsgeyser.sdk.configuration.models.ConfigPhpSdkModel;
import com.appsgeyser.sdk.datasdk.DataSdkActivity;
import com.appsgeyser.sdk.datasdk.PermissionsRequester;
import com.appsgeyser.sdk.server.StatController;
import com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient;

public class DataSdkController {
    static void acceptAllActiveSdk(Context context, ConfigPhp configPhp) {
        DataSdkController.acceptSdk(context, configPhp);
        StatController.getInstance().sendRequestAsyncByKey("click_accept_sdk_dialog");
    }

    private static void acceptSdk(Context context, ConfigPhp configPhp) {
        PreferencesCoder preferencesCoder = new PreferencesCoder(context);
        preferencesCoder.savePrefBoolean("sdkIsAccepted", true);
        if (configPhp.getAppsgeyserSdk().isActive()) {
            preferencesCoder.savePrefBoolean("appsgeyserSdk_eulaAccepted", true);
        }
    }

    private static void checkPermissions(Context context, ConfigPhp configPhp, String string2) {
        if (!PermissionsRequester.isPermissionsRequired(configPhp, context) && (DataSdkController.isSdkAccepted(context) || TextUtils.isEmpty((CharSequence)string2))) {
            DataSdkController.initSdk(configPhp, context);
            return;
        }
        InternalEntryPoint.getInstance().setConsentRequestProcessActive(true);
        DataSdkActivity.startRequestPermissions((Context)context, (ConfigPhp)configPhp, (String)string2);
    }

    private static void declineActiveSdk(Context context, ConfigPhp configPhp, PreferencesCoder preferencesCoder) {
        int n2 = -1 + preferencesCoder.getPrefInt("countOfTry", -1);
        preferencesCoder.savePrefInt("countOfTry", n2);
        StatController.getInstance().sendRequestAsyncByKey("click_decline_sdk_dialog");
        if (n2 == 0 && configPhp.getAppsgeyserSdk().isActive()) {
            preferencesCoder.savePrefBoolean("appsgeyserSdk_eulaAccepted", false);
        }
    }

    static void declineAllActiveSdk(final Context context, final ConfigPhp configPhp, AppCompatActivity appCompatActivity, final String string2) {
        if (!configPhp.getStartupELUAConfirmationDialogAllow()) {
            final DataSdkActivity dataSdkActivity = (DataSdkActivity)appCompatActivity;
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)dataSdkActivity);
            builder.setMessage(R.string.appsgeysersdk_are_you_sure_decline_sdk);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.appsgeysersdk_close_app, new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    PreferencesCoder preferencesCoder = new PreferencesCoder((Context)dataSdkActivity);
                    DataSdkController.declineActiveSdk(context, configPhp, preferencesCoder);
                    AppsgeyserServerClient.getInstance().setConfigPhpModel(null);
                    preferencesCoder.savePrefLong("elapsedTime", 0L);
                    if (Build.VERSION.SDK_INT >= 16) {
                        dataSdkActivity.finishAffinity();
                        return;
                    }
                    ActivityCompat.finishAffinity((Activity)dataSdkActivity);
                }
            });
            builder.setNegativeButton(R.string.appsgeysersdk_back, new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    dataSdkActivity.showEulaDialog(string2, configPhp);
                }
            });
            builder.create().show();
            return;
        }
        DataSdkController.declineActiveSdk(context, configPhp, new PreferencesCoder(context));
        if (Build.VERSION.SDK_INT >= 23 && PermissionsRequester.isPermissionsRequired(configPhp, context)) {
            PermissionsRequester.requestAllActiveByDefaultPermissions((Activity)context, configPhp, 78);
            return;
        }
        DataSdkController.initSdk(configPhp, context);
        appCompatActivity.finish();
    }

    static void initSdk(ConfigPhp configPhp, Context context) {
        if (AppsgeyserSDK.getFastTrackAdsController() != null) {
            AppsgeyserSDK.getFastTrackAdsController().consentRequestProcessFinished();
        }
        InternalEntryPoint.getInstance().setConsentRequestProcessActive(false);
    }

    static boolean isSdkAccepted(Context context) {
        return new PreferencesCoder(context).getPrefBoolean("sdkIsAccepted", false);
    }

    public static void onGetConfigErrorResponse(Context context) {
        new PreferencesCoder(context).getPrefBoolean("appsgeyserSdk_isActive", false);
    }

    public static void startDataSdkController(Context context, ConfigPhp configPhp) {
        ConfigPhpSdkModel configPhpSdkModel;
        boolean bl;
        PreferencesCoder preferencesCoder;
        block10 : {
            block11 : {
                preferencesCoder = new PreferencesCoder(context);
                int n2 = preferencesCoder.getPrefInt("countOfTry", -1);
                int n3 = configPhp.getCountOfTry();
                if (-1 == n2) {
                    preferencesCoder.savePrefInt("countOfTry", n3);
                }
                configPhpSdkModel = configPhp.getAppsgeyserSdk();
                boolean bl2 = configPhpSdkModel.isActive();
                bl = false;
                if (!bl2) break block10;
                if (configPhpSdkModel.isActiveByDefault()) break block11;
                boolean bl3 = preferencesCoder.getPrefBoolean("appsgeyserSdk_eulaAccepted", false);
                bl = false;
                if (!bl3) break block10;
            }
            bl = true;
        }
        preferencesCoder.savePrefBoolean("appsgeyserSdk_isActive", bl);
        int n4 = preferencesCoder.getPrefInt("countOfTry", -1);
        long l2 = preferencesCoder.getPrefLong("elapsedTime", -1L);
        long l3 = System.currentTimeMillis();
        long l4 = l3 - l2;
        if (n4 > 0 && (-1L == l2 || l4 > 7200000L)) {
            if (!DataSdkController.isSdkAccepted(context)) {
                String string2 = configPhpSdkModel.getTextOfPolicy();
                StringBuilder stringBuilder = new StringBuilder();
                if (configPhpSdkModel.isActive() && !configPhpSdkModel.isActiveByDefault() && !TextUtils.isEmpty((CharSequence)string2)) {
                    if (stringBuilder.toString().length() > 0) {
                        stringBuilder.append("\n\n");
                    }
                    stringBuilder.append(string2);
                }
                DataSdkController.checkPermissions(context, configPhp, stringBuilder.toString());
            } else {
                DataSdkController.checkPermissions(context, configPhp, null);
            }
        } else {
            DataSdkController.initSdk(configPhp, context);
        }
        preferencesCoder.savePrefLong("elapsedTime", l3);
    }

}

