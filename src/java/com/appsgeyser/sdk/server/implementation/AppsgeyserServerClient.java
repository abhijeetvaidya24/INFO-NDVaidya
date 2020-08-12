/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.TextView
 *  com.android.volley.Response
 *  com.android.volley.Response$ErrorListener
 *  com.appsgeyser.sdk.InternalEntryPoint
 *  com.appsgeyser.sdk.rateme.RatingDialog
 *  com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$
 *  com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$$Lambda
 *  com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$$Lambda$1
 *  com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$$Lambda$2
 *  com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$$Lambda$3
 *  com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$1
 *  com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$2
 *  com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$3
 *  com.google.gson.JsonParseException
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.appsgeyser.sdk.server.implementation;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.Response;
import com.appsgeyser.sdk.InternalEntryPoint;
import com.appsgeyser.sdk.R;
import com.appsgeyser.sdk.configuration.Configuration;
import com.appsgeyser.sdk.configuration.PreferencesCoder;
import com.appsgeyser.sdk.configuration.models.ConfigPhp;
import com.appsgeyser.sdk.datasdk.DataSdkController;
import com.appsgeyser.sdk.deviceidparser.DeviceIdParameters;
import com.appsgeyser.sdk.deviceidparser.DeviceIdParser;
import com.appsgeyser.sdk.push.OneSignalCreator;
import com.appsgeyser.sdk.rateme.RatingDialog;
import com.appsgeyser.sdk.server.StatController;
import com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient;
import com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$;
import com.appsgeyser.sdk.server.implementation.AppsgeyserServerClient$$Lambda$4;
import com.appsgeyser.sdk.server.implementation.OnRequestDoneListener;
import com.appsgeyser.sdk.server.network.NetworkManager;
import com.appsgeyser.sdk.utils.DeviceInfoGetter;
import com.appsgeyser.sdk.utils.VersionManager;
import com.google.gson.JsonParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppsgeyserServerClient {
    private ConfigPhp configPhpModel;
    List<ConfigPhpRequestListener> listenerList = new ArrayList();
    private final NetworkManager networkManager = NetworkManager.getInstance();
    private boolean ratingDialogActivated;

    private AppsgeyserServerClient() {
    }

    static /* synthetic */ ConfigPhp access$100(AppsgeyserServerClient appsgeyserServerClient) {
        return appsgeyserServerClient.configPhpModel;
    }

    static /* synthetic */ ConfigPhp access$102(AppsgeyserServerClient appsgeyserServerClient, ConfigPhp configPhp) {
        appsgeyserServerClient.configPhpModel = configPhp;
        return configPhp;
    }

    static /* synthetic */ void access$200(AppsgeyserServerClient appsgeyserServerClient, Context context, ConfigPhp configPhp) {
        appsgeyserServerClient.initPush(context, configPhp);
    }

    static /* synthetic */ boolean access$300(AppsgeyserServerClient appsgeyserServerClient) {
        return appsgeyserServerClient.ratingDialogActivated;
    }

    static /* synthetic */ boolean access$302(AppsgeyserServerClient appsgeyserServerClient, boolean bl) {
        appsgeyserServerClient.ratingDialogActivated = bl;
        return bl;
    }

    static /* synthetic */ void access$400(AppsgeyserServerClient appsgeyserServerClient, Context context, ConfigPhp configPhp) {
        appsgeyserServerClient.initRatingDialog(context, configPhp);
    }

    static /* synthetic */ void access$500(AppsgeyserServerClient appsgeyserServerClient, Context context, ConfigPhpRequestListener configPhpRequestListener, PreferencesCoder preferencesCoder) {
        appsgeyserServerClient.onGetConfigErrorResponse(context, configPhpRequestListener, preferencesCoder);
    }

    private String getInstallerMarket(Context context) {
        String string2;
        try {
            String string3 = context.getPackageName();
            string2 = context.getPackageManager().getInstallerPackageName(string3);
            if (string2 == null) {
                return "";
            }
        }
        catch (Exception exception) {
            if (!TextUtils.isEmpty((CharSequence)exception.getMessage())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ERROR");
                stringBuilder.append(":");
                stringBuilder.append(exception.getMessage());
                return stringBuilder.toString();
            }
            string2 = "ERROR";
        }
        return string2;
    }

    public static AppsgeyserServerClient getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private void initPush(Context context, ConfigPhp configPhp) {
        String string2 = configPhp.getOneSignalAppId();
        if (string2 != null) {
            OneSignalCreator.init(string2, context.getApplicationContext());
        }
    }

    private void initRatingDialog(Context context, ConfigPhp configPhp) {
        if (configPhp.isRateMyAppActive()) {
            RatingDialog.Builder builder = new RatingDialog.Builder(context);
            float f2 = configPhp.getRateMyAppThreshold() > 0 ? (float)configPhp.getRateMyAppThreshold() : 3.0f;
            RatingDialog.Builder builder2 = builder.threshold(f2);
            int n2 = configPhp.getRateMyAppSessionsCount() > 0 ? configPhp.getRateMyAppSessionsCount() : 3;
            builder2.session(n2).onThresholdFailed($Lambda$1.lambdaFactory$()).onThresholdCleared($Lambda$2.lambdaFactory$((Context)context)).onRatingBarFormSumbit($Lambda$3.lambdaFactory$((Context)context)).dialogListener((RatingDialog.Builder.RatingDialogListener)new 3(this, context)).build().show();
        }
    }

    static /* synthetic */ void lambda$initRatingDialog$0(RatingDialog ratingDialog, float f2, boolean bl) {
        ratingDialog.switchToForm();
        ratingDialog.getEtFeedback().setVisibility(0);
    }

    static /* synthetic */ void lambda$initRatingDialog$2(Context context, RatingDialog ratingDialog, float f2, boolean bl) {
        ratingDialog.switchToForm();
        ratingDialog.getFormTitleTextView().setText(R.string.rating_dialog_rate_title);
        ratingDialog.getFormSumbitTextView().setText(R.string.rating_dialog_rate);
        ratingDialog.getFormSumbitTextView().setOnClickListener(AppsgeyserServerClient$$Lambda$4.lambdaFactory$(context, ratingDialog));
    }

    static /* synthetic */ void lambda$initRatingDialog$3(Context context, String string2) {
        StatController.getInstance().sendRequestAsyncByKey("rma_dialog_feedback_clicks", null, context, true);
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"widgetId", (Object)Configuration.getInstance(context).getApplicationId());
        hashMap.put((Object)"rate", (Object)Float.toString((float)InternalEntryPoint.getInstance().getSelectedRating()));
        hashMap.put((Object)"feedback", (Object)string2);
        AppsgeyserServerClient.getInstance().sendRMARequest(context, (Map<String, String>)hashMap);
    }

    static /* synthetic */ void lambda$null$1(Context context, RatingDialog ratingDialog, View view) {
        StatController.getInstance().sendRequestAsyncByKey("rma_dialog_rate_clicks", null, context, true);
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"widgetId", (Object)Configuration.getInstance(context).getApplicationId());
        hashMap.put((Object)"rate", (Object)Float.toString((float)InternalEntryPoint.getInstance().getSelectedRating()));
        AppsgeyserServerClient.getInstance().sendRMARequest(context, (Map<String, String>)hashMap);
        ratingDialog.openPlaystore(ratingDialog.getContext());
        ratingDialog.showNever();
        ratingDialog.dismiss();
    }

    private void onGetConfigErrorResponse(Context context, ConfigPhpRequestListener configPhpRequestListener, PreferencesCoder preferencesCoder) {
        String string2 = preferencesCoder.getPrefString("ServerResponse", "");
        if (!string2.equals((Object)"")) {
            try {
                this.configPhpModel = ConfigPhp.parseFromJson(string2);
                configPhpRequestListener.receivedConfigPhp(this.configPhpModel);
            }
            catch (JsonParseException jsonParseException) {
                Log.d((String)"JsonParseException", (String)jsonParseException.toString());
            }
        }
        DataSdkController.onGetConfigErrorResponse(context);
    }

    private void sendRequestSdkStatisticsWithArgs(String string2, int n2, Context context) {
        Configuration configuration = Configuration.getInstance(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://stat.appsgeyser.com/sdk_statistics.php?action=");
        stringBuilder.append(string2);
        stringBuilder.append("&wdid=");
        stringBuilder.append(configuration.getApplicationId());
        stringBuilder.append("&guid=");
        stringBuilder.append(configuration.getAppGuid());
        stringBuilder.append("&v=");
        stringBuilder.append("2.14.s");
        stringBuilder.append("&p=android");
        stringBuilder.append(DeviceInfoGetter.getDeviceInfo(context));
        stringBuilder.append("&templateversion=");
        stringBuilder.append(configuration.getTemplateVersion());
        String string3 = stringBuilder.toString();
        this.networkManager.sendRequestAsync(string3, (Integer)n2, context, this.networkManager.getEmptyRequestDoneListener(context), this.networkManager.getDefaultErrorListener(n2, context));
    }

    private void sendRequestWithAllArgs(String string2, int n2, Context context) {
        String string3;
        Configuration configuration = Configuration.getInstance(context);
        String string4 = DeviceIdParser.getInstance().getDeviceIdParameters().getAdvId();
        if (!TextUtils.isEmpty((CharSequence)string4)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://stat.appioapp.com/statistics.php?action=");
            stringBuilder.append(string2);
            stringBuilder.append("&name=");
            stringBuilder.append(configuration.getApplicationId());
            stringBuilder.append("&id=");
            stringBuilder.append(configuration.getAppGuid());
            stringBuilder.append("&v=");
            stringBuilder.append("2.14.s");
            stringBuilder.append("&p=android&advid=");
            stringBuilder.append(string4);
            stringBuilder.append("&market=");
            stringBuilder.append(this.getInstallerMarket(context));
            stringBuilder.append(DeviceInfoGetter.getDeviceInfo(context));
            stringBuilder.append("&templateversion=");
            stringBuilder.append(configuration.getTemplateVersion());
            string3 = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://stat.appioapp.com/statistics.php?action=");
            stringBuilder.append(string2);
            stringBuilder.append("&name=");
            stringBuilder.append(configuration.getApplicationId());
            stringBuilder.append("&id=");
            stringBuilder.append(configuration.getAppGuid());
            stringBuilder.append("&v=");
            stringBuilder.append("2.14.s");
            stringBuilder.append("&p=android&market=");
            stringBuilder.append(this.getInstallerMarket(context));
            stringBuilder.append(DeviceInfoGetter.getDeviceInfo(context));
            stringBuilder.append("&templateversion=");
            stringBuilder.append(configuration.getTemplateVersion());
            string3 = stringBuilder.toString();
        }
        String string5 = string3;
        this.networkManager.sendRequestAsync(string5, (Integer)n2, context, this.networkManager.getEmptyRequestDoneListener(context), this.networkManager.getDefaultErrorListener(n2, context));
    }

    public void getConfigPhp(Context context, DeviceIdParameters deviceIdParameters, ConfigPhpRequestListener configPhpRequestListener) {
        ConfigPhp configPhp = this.configPhpModel;
        if (configPhp != null) {
            configPhpRequestListener.receivedConfigPhp(configPhp);
            return;
        }
        if (this.listenerList.size() > 0) {
            this.listenerList.add((Object)configPhpRequestListener);
            return;
        }
        Configuration configuration = Configuration.getInstance(context);
        this.listenerList.add((Object)configPhpRequestListener);
        String string2 = "";
        String string3 = deviceIdParameters != null ? deviceIdParameters.getAdvId() : string2;
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("&advid=");
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
        }
        configuration.loadConfiguration();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://config.appsgeyser.com/?widgetId=");
        stringBuilder.append(configuration.getApplicationId());
        stringBuilder.append("&guid=");
        stringBuilder.append(configuration.getAppGuid());
        stringBuilder.append("&v=");
        stringBuilder.append("2.14.s");
        stringBuilder.append("&market=");
        stringBuilder.append(this.getInstallerMarket(context));
        stringBuilder.append(string2);
        String string4 = stringBuilder.toString();
        PreferencesCoder preferencesCoder = new PreferencesCoder(context);
        preferencesCoder.savePrefString("ConfigPhpURLWithParams", string4);
        this.networkManager.sendRequestAsync(string4, (Integer)NetworkManager.RequestType.CONFIG_PHP.ordinal(), context, (OnRequestDoneListener)new 1(this, preferencesCoder, context), (Response.ErrorListener)new 2(this, context, preferencesCoder));
    }

    public void sendAboutDialogVisitSite(Context context) {
        this.sendRequestSdkStatisticsWithArgs("about_dialog_visit_site", "about_dialog_visit_site".hashCode(), context);
    }

    public void sendAfterInstallInfo(Context context) {
        this.sendRequestWithAllArgs("install", NetworkManager.RequestType.AFTERINSTALL.ordinal(), context);
    }

    public void sendApplicationMode(Context context) {
        Configuration configuration = Configuration.getInstance(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://ads.appsgeyser.com/checkstatus.php?wid=");
        stringBuilder.append(configuration.getApplicationId());
        String string2 = stringBuilder.toString();
        this.networkManager.sendRequestAsync(string2, (Integer)NetworkManager.RequestType.APPMODE.ordinal(), context, this.networkManager.getEmptyRequestDoneListener(context), this.networkManager.getDefaultErrorListener(NetworkManager.RequestType.APPMODE.ordinal(), context));
    }

    public void sendRMARequest(Context context, Map<String, String> map) {
        Configuration.getInstance(context);
        this.networkManager.sendRequestAsyncPost("http://analytics.appsgeyser.com/hypo/rma_dialog_feedback.php?action=add", (Integer)NetworkManager.RequestType.RMA.ordinal(), context, this.networkManager.getEmptyRequestDoneListener(context), this.networkManager.getDefaultErrorListener(NetworkManager.RequestType.RMA.ordinal(), context), map);
    }

    public void sendUpdateInfo(Context context) {
        int n2 = VersionManager.getCurrentVersion(context);
        int n3 = VersionManager.getPreviousVersion(context);
        if (n3 == -1) {
            VersionManager.updateVersion(context, n2);
            return;
        }
        if (n2 > n3) {
            VersionManager.updateVersion(context, n2);
            this.sendRequestWithAllArgs("update", NetworkManager.RequestType.UPDATE.ordinal(), context);
        }
    }

    public void sendUsageInfo(Context context) {
        this.sendRequestWithAllArgs("usage", NetworkManager.RequestType.USAGE.ordinal(), context);
    }

    public void setConfigPhpModel(ConfigPhp configPhp) {
        this.configPhpModel = configPhp;
    }

    public static interface ConfigPhpRequestListener {
        public void receivedConfigPhp(ConfigPhp var1);
    }

    private static class SingletonHolder {
        static final AppsgeyserServerClient HOLDER_INSTANCE = new AppsgeyserServerClient();
    }

}

