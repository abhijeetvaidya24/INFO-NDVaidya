/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.annotations.SerializedName
 *  com.google.gson.stream.JsonReader
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 */
package com.appsgeyser.sdk.configuration.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsgeyser.sdk.ads.fastTrack.FastTrackSdkModel;
import com.appsgeyser.sdk.configuration.models.AdNetworkSdkModel;
import com.appsgeyser.sdk.configuration.models.ConfigPhpSdkModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ConfigPhp
implements Parcelable {
    public static final Parcelable.Creator<ConfigPhp> CREATOR = new Parcelable.Creator<ConfigPhp>(){

        public ConfigPhp createFromParcel(Parcel parcel) {
            return new ConfigPhp(parcel);
        }

        public ConfigPhp[] newArray(int n2) {
            return new ConfigPhp[n2];
        }
    };
    @SerializedName(value="about_screen_description")
    private String aboutScreenDescription;
    @SerializedName(value="about_screen_description_type")
    private String aboutScreenDescriptionType;
    private FastTrackSdkModel activeAdsSDK;
    @SerializedName(value="additional_js_code")
    private String additionalJsCode;
    private Map<String, AdNetworkSdkModel> adsNetworkSdk;
    private ConfigPhpSdkModel appsgeyserSdk;
    private int countOfTry;
    private String country;
    @SerializedName(value="custom_html_about_active")
    private boolean customAboutActive;
    private String eulaBeginning;
    private long fullScreenDelay;
    private int fullscreenBannerCountToShow;
    private boolean inAppPurchasesActive;
    @SerializedName(value="period_days")
    private int inactivityDaysPeriod;
    @SerializedName(value="turn_on_inactivity_reminder")
    private boolean inactivityReminderEnabled;
    @SerializedName(value="text_reminder")
    private String inactivityReminderText;
    @SerializedName(value="enable_about_screen")
    private boolean isAboutScreenEnabled;
    @SerializedName(value="startup_confirmation_dialog")
    private boolean isAdvertisingTermsDialog;
    private boolean isOnResumeFSEnabled;
    private boolean isOnTouchFSEnabled;
    private boolean isTakeOffFSEnabled;
    private String oneSignalAppId;
    private boolean rateMyAppActive;
    private int rateMyAppSessionsCount;
    private int rateMyAppThreshold;
    @SerializedName(value="startup_dialog_allowing_use_if_decline")
    private boolean startupELUAConfirmationDialogAllow;
    private Map<String, String> statUrls;

    public ConfigPhp() {
        this.isAboutScreenEnabled = true;
        this.aboutScreenDescriptionType = "default";
        this.startupELUAConfirmationDialogAllow = true;
        this.isTakeOffFSEnabled = false;
        this.isOnResumeFSEnabled = false;
        this.isOnTouchFSEnabled = true;
        this.fullScreenDelay = -1L;
        this.fullscreenBannerCountToShow = 1;
    }

    private ConfigPhp(Parcel parcel) {
        boolean bl;
        this.isAboutScreenEnabled = bl = true;
        this.aboutScreenDescriptionType = "default";
        this.startupELUAConfirmationDialogAllow = bl;
        this.isTakeOffFSEnabled = false;
        this.isOnResumeFSEnabled = false;
        this.isOnTouchFSEnabled = bl;
        this.fullScreenDelay = -1L;
        this.fullscreenBannerCountToShow = bl ? 1 : 0;
        this.appsgeyserSdk = (ConfigPhpSdkModel)parcel.readParcelable(ConfigPhpSdkModel.class.getClassLoader());
        boolean bl2 = parcel.readByte() != 0;
        this.isAboutScreenEnabled = bl2;
        boolean bl3 = parcel.readByte() != 0;
        this.isAdvertisingTermsDialog = bl3;
        this.country = parcel.readString();
        this.eulaBeginning = parcel.readString();
        this.oneSignalAppId = parcel.readString();
        this.countOfTry = parcel.readInt();
        this.aboutScreenDescriptionType = parcel.readString();
        this.aboutScreenDescription = parcel.readString();
        boolean bl4 = parcel.readByte() != 0;
        this.startupELUAConfirmationDialogAllow = bl4;
        boolean bl5 = parcel.readByte() != 0;
        this.rateMyAppActive = bl5;
        boolean bl6 = parcel.readByte() != 0;
        this.customAboutActive = bl6;
        boolean bl7 = parcel.readByte() != 0;
        this.inAppPurchasesActive = bl7;
        this.additionalJsCode = parcel.readString();
        if (parcel.readByte() == 0) {
            bl = false;
        }
        this.inactivityReminderEnabled = bl;
        this.inactivityDaysPeriod = parcel.readInt();
        this.inactivityReminderText = parcel.readString();
    }

    public static ConfigPhp parseFromJson(String string2) throws JsonSyntaxException {
        Gson gson = new GsonBuilder().setLenient().create();
        JsonReader jsonReader = new JsonReader((Reader)new StringReader(string2));
        jsonReader.setLenient(true);
        return (ConfigPhp)gson.fromJson(jsonReader, ConfigPhp.class);
    }

    public int describeContents() {
        return 0;
    }

    public String getAboutScreenDescription() {
        return this.aboutScreenDescription;
    }

    public String getAboutScreenDescriptionType() {
        return this.aboutScreenDescriptionType;
    }

    public FastTrackSdkModel getActiveAdsSDK() {
        return this.activeAdsSDK;
    }

    public String getAdditionalJsCode() {
        return this.additionalJsCode;
    }

    public ConfigPhpSdkModel getAppsgeyserSdk() {
        return this.appsgeyserSdk;
    }

    public int getCountOfTry() {
        return this.countOfTry;
    }

    public String getEulaBeginning() {
        return this.eulaBeginning;
    }

    public long getFullScreenDelay() {
        return this.fullScreenDelay;
    }

    public int getInactivityDaysPeriod() {
        int n2 = this.inactivityDaysPeriod;
        if (n2 != 0) {
            return n2;
        }
        return 1;
    }

    public String getInactivityReminderText() {
        return this.inactivityReminderText;
    }

    public String getOneSignalAppId() {
        return this.oneSignalAppId;
    }

    public int getRateMyAppSessionsCount() {
        return this.rateMyAppSessionsCount;
    }

    public int getRateMyAppThreshold() {
        return this.rateMyAppThreshold;
    }

    public boolean getStartupELUAConfirmationDialogAllow() {
        return this.startupELUAConfirmationDialogAllow;
    }

    public Map<String, String> getStatUrls() {
        return this.statUrls;
    }

    public boolean isAboutScreenEnabled() {
        return this.isAboutScreenEnabled;
    }

    public boolean isAdvertisingTermsDialog() {
        return this.isAdvertisingTermsDialog;
    }

    public boolean isCustomAboutActive() {
        return this.customAboutActive;
    }

    public boolean isInAppPurchasesActive() {
        return this.inAppPurchasesActive;
    }

    public boolean isInactivityReminderEnabled() {
        return this.inactivityReminderEnabled;
    }

    public boolean isOfferWallEnabled() {
        Map<String, AdNetworkSdkModel> map = this.adsNetworkSdk;
        if (map != null && map.size() > 0) {
            Iterator iterator = this.adsNetworkSdk.values().iterator();
            while (iterator.hasNext()) {
                if (!((AdNetworkSdkModel)iterator.next()).isActive()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isRateMyAppActive() {
        return this.rateMyAppActive;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.appsgeyserSdk, n2);
        parcel.writeByte((byte)(this.isAboutScreenEnabled ? 1 : 0));
        parcel.writeByte((byte)(this.isAdvertisingTermsDialog ? 1 : 0));
        parcel.writeString(this.country);
        parcel.writeString(this.eulaBeginning);
        parcel.writeString(this.oneSignalAppId);
        parcel.writeInt(this.countOfTry);
        parcel.writeString(this.aboutScreenDescriptionType);
        parcel.writeString(this.aboutScreenDescription);
        parcel.writeByte((byte)(this.startupELUAConfirmationDialogAllow ? 1 : 0));
        parcel.writeByte((byte)(this.rateMyAppActive ? 1 : 0));
        parcel.writeByte((byte)(this.customAboutActive ? 1 : 0));
        parcel.writeByte((byte)(this.inAppPurchasesActive ? 1 : 0));
        parcel.writeString(this.additionalJsCode);
        parcel.writeByte((byte)(this.inactivityReminderEnabled ? 1 : 0));
        parcel.writeInt(this.inactivityDaysPeriod);
        parcel.writeString(this.inactivityReminderText);
    }

}

