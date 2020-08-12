/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AdUnitsState
implements Parcelable {
    public static final Parcelable.Creator<AdUnitsState> CREATOR = new Parcelable.Creator<AdUnitsState>(){

        public AdUnitsState createFromParcel(Parcel parcel) {
            return new AdUnitsState(parcel);
        }

        public AdUnitsState[] newArray(int n2) {
            return new AdUnitsState[n2];
        }
    };
    private String mDisplayedDemandSourceName;
    private int mDisplayedProduct;
    private String mInterstitialAppKey;
    private Map<String, String> mInterstitialExtraParams;
    private ArrayList<String> mInterstitialInitSuccess;
    private ArrayList<String> mInterstitialLoadSuccess;
    private ArrayList<String> mInterstitialReportInit;
    private ArrayList<String> mInterstitialReportLoad;
    private String mInterstitialUserId;
    private Map<String, String> mOfferWallExtraParams;
    private boolean mOfferwallInitSuccess;
    private boolean mOfferwallReportInit;
    private String mRVAppKey;
    private String mRVUserId;
    private boolean mShouldRestore;

    public AdUnitsState() {
        this.initialize();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private AdUnitsState(Parcel parcel) {
        boolean bl2;
        block3 : {
            block2 : {
                this.initialize();
                try {
                    byte by = parcel.readByte();
                    bl2 = true;
                    boolean bl3 = by != 0;
                    this.mShouldRestore = bl3;
                    this.mDisplayedProduct = parcel.readInt();
                    this.mRVAppKey = parcel.readString();
                    this.mRVUserId = parcel.readString();
                    this.mDisplayedDemandSourceName = parcel.readString();
                    this.mInterstitialAppKey = parcel.readString();
                    this.mInterstitialUserId = parcel.readString();
                    this.mInterstitialExtraParams = this.getMapFromJsonString(parcel.readString());
                    boolean bl4 = parcel.readByte() != 0;
                    this.mOfferwallInitSuccess = bl4;
                    if (parcel.readByte() == 0) break block2;
                    break block3;
                }
                catch (Throwable throwable) {
                    this.initialize();
                    return;
                }
            }
            bl2 = false;
        }
        this.mOfferwallReportInit = bl2;
        this.mOfferWallExtraParams = this.getMapFromJsonString(parcel.readString());
    }

    private Map<String, String> getMapFromJsonString(String string) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(string);
            Iterator iterator = jSONObject.keys();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                hashMap.put((Object)string2, (Object)jSONObject.getString(string2));
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return hashMap;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return hashMap;
    }

    private void initialize() {
        this.mShouldRestore = false;
        this.mDisplayedProduct = -1;
        this.mInterstitialReportInit = new ArrayList();
        this.mInterstitialInitSuccess = new ArrayList();
        this.mInterstitialReportLoad = new ArrayList();
        this.mInterstitialLoadSuccess = new ArrayList();
        this.mOfferwallReportInit = true;
        this.mOfferwallInitSuccess = false;
        this.mInterstitialUserId = "";
        this.mInterstitialAppKey = "";
        this.mInterstitialExtraParams = new HashMap();
        this.mOfferWallExtraParams = new HashMap();
    }

    public void adClosed() {
        this.mDisplayedProduct = -1;
    }

    public void adOpened(int n2) {
        this.mDisplayedProduct = n2;
    }

    public int describeContents() {
        return 0;
    }

    public String getDisplayedDemandSourceName() {
        return this.mDisplayedDemandSourceName;
    }

    public int getDisplayedProduct() {
        return this.mDisplayedProduct;
    }

    public String getInterstitialAppKey() {
        return this.mInterstitialAppKey;
    }

    public String getInterstitialUserId() {
        return this.mInterstitialUserId;
    }

    public String getRVAppKey() {
        return this.mRVAppKey;
    }

    public String getRVUserId() {
        return this.mRVUserId;
    }

    public boolean reportInitOfferwall() {
        return this.mOfferwallReportInit;
    }

    public void setDisplayedDemandSourceName(String string) {
        this.mDisplayedDemandSourceName = string;
    }

    public void setInterstitialAppKey(String string) {
        this.mInterstitialAppKey = string;
    }

    public void setInterstitialUserId(String string) {
        this.mInterstitialUserId = string;
    }

    public void setOfferWallExtraParams(Map<String, String> map) {
        this.mOfferWallExtraParams = map;
    }

    public void setOfferwallInitSuccess(boolean bl2) {
        this.mOfferwallInitSuccess = bl2;
    }

    public void setOfferwallReportInit(boolean bl2) {
        this.mOfferwallReportInit = bl2;
    }

    public void setRVAppKey(String string) {
        this.mRVAppKey = string;
    }

    public void setRVUserId(String string) {
        this.mRVUserId = string;
    }

    public void setReportLoadInterstitial(String string, boolean bl2) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            if (bl2) {
                if (this.mInterstitialReportLoad.indexOf((Object)string) == -1) {
                    this.mInterstitialReportLoad.add((Object)string);
                    return;
                }
            } else {
                this.mInterstitialReportLoad.remove((Object)string);
            }
        }
    }

    public void setShouldRestore(boolean bl2) {
        this.mShouldRestore = bl2;
    }

    public boolean shouldRestore() {
        return this.mShouldRestore;
    }

    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("shouldRestore:");
            stringBuilder.append(this.mShouldRestore);
            stringBuilder.append(", ");
            stringBuilder.append("displayedProduct:");
            stringBuilder.append(this.mDisplayedProduct);
            stringBuilder.append(", ");
            stringBuilder.append("ISReportInit:");
            stringBuilder.append(this.mInterstitialReportInit);
            stringBuilder.append(", ");
            stringBuilder.append("ISInitSuccess:");
            stringBuilder.append(this.mInterstitialInitSuccess);
            stringBuilder.append(", ");
            stringBuilder.append("ISAppKey");
            stringBuilder.append(this.mInterstitialAppKey);
            stringBuilder.append(", ");
            stringBuilder.append("ISUserId");
            stringBuilder.append(this.mInterstitialUserId);
            stringBuilder.append(", ");
            stringBuilder.append("ISExtraParams");
            stringBuilder.append(this.mInterstitialExtraParams);
            stringBuilder.append(", ");
            stringBuilder.append("OWReportInit");
            stringBuilder.append(this.mOfferwallReportInit);
            stringBuilder.append(", ");
            stringBuilder.append("OWInitSuccess");
            stringBuilder.append(this.mOfferwallInitSuccess);
            stringBuilder.append(", ");
            stringBuilder.append("OWExtraParams");
            stringBuilder.append(this.mOfferWallExtraParams);
            stringBuilder.append(", ");
        }
        catch (Throwable throwable) {}
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeToParcel(Parcel parcel, int n2) {
        boolean bl2;
        block3 : {
            block2 : {
                try {
                    boolean bl3 = this.mShouldRestore;
                    bl2 = true;
                    boolean bl4 = bl3;
                    parcel.writeByte((byte)(bl4 ? 1 : 0));
                    parcel.writeInt(this.mDisplayedProduct);
                    parcel.writeString(this.mRVAppKey);
                    parcel.writeString(this.mRVUserId);
                    parcel.writeString(this.mDisplayedDemandSourceName);
                    parcel.writeString(this.mInterstitialAppKey);
                    parcel.writeString(this.mInterstitialUserId);
                    parcel.writeString(new JSONObject(this.mInterstitialExtraParams).toString());
                    boolean bl5 = this.mOfferwallInitSuccess;
                    parcel.writeByte((byte)(bl5 ? 1 : 0));
                    if (!this.mOfferwallReportInit) break block2;
                    break block3;
                }
                catch (Throwable throwable) {}
                return;
            }
            bl2 = false;
        }
        parcel.writeByte((byte)(bl2 ? 1 : 0));
        parcel.writeString(new JSONObject(this.mOfferWallExtraParams).toString());
    }

}

