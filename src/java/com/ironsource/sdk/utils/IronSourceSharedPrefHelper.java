/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  com.ironsource.sdk.data.SSABCParameters
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ironsource.sdk.data.SSABCParameters;
import com.ironsource.sdk.data.SSAEnums;
import com.ironsource.sdk.data.SSAObj;
import com.ironsource.sdk.data.SSASession;
import com.ironsource.sdk.utils.IronSourceAsyncHttpRequestTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceSharedPrefHelper {
    private static IronSourceSharedPrefHelper mInstance;
    private SharedPreferences mSharedPreferences;

    private IronSourceSharedPrefHelper(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    private boolean getShouldRegisterSessions() {
        return this.mSharedPreferences.getBoolean("register_sessions", true);
    }

    public static IronSourceSharedPrefHelper getSupersonicPrefHelper() {
        Class<IronSourceSharedPrefHelper> class_ = IronSourceSharedPrefHelper.class;
        synchronized (IronSourceSharedPrefHelper.class) {
            IronSourceSharedPrefHelper ironSourceSharedPrefHelper = mInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return ironSourceSharedPrefHelper;
        }
    }

    public static IronSourceSharedPrefHelper getSupersonicPrefHelper(Context context) {
        Class<IronSourceSharedPrefHelper> class_ = IronSourceSharedPrefHelper.class;
        synchronized (IronSourceSharedPrefHelper.class) {
            if (mInstance == null) {
                mInstance = new IronSourceSharedPrefHelper(context);
            }
            IronSourceSharedPrefHelper ironSourceSharedPrefHelper = mInstance;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return ironSourceSharedPrefHelper;
        }
    }

    public void addSession(SSASession sSASession) {
        if (this.getShouldRegisterSessions()) {
            JSONObject jSONObject;
            jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionStartTime", sSASession.getSessionStartTime());
                jSONObject.put("sessionEndTime", sSASession.getSessionEndTime());
                jSONObject.put("sessionType", (Object)sSASession.getSessionType());
                jSONObject.put("connectivity", (Object)sSASession.getConnectivity());
            }
            catch (JSONException jSONException) {}
            JSONArray jSONArray = this.getSessions();
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.put((Object)jSONObject);
            SharedPreferences.Editor editor = this.mSharedPreferences.edit();
            editor.putString("sessions", jSONArray.toString());
            editor.commit();
        }
    }

    public void deleteSessions() {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putString("sessions", null);
        editor.commit();
    }

    public String getApplicationKey(SSAEnums.ProductType productType) {
        int n2 = 1.$SwitchMap$com$ironsource$sdk$data$SSAEnums$ProductType[productType.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return "EMPTY_APPLICATION_KEY";
                }
                return this.mSharedPreferences.getString("application_key_is", null);
            }
            return this.mSharedPreferences.getString("application_key_ow", null);
        }
        return this.mSharedPreferences.getString("application_key_rv", null);
    }

    public SSAEnums.BackButtonState getBackButtonState() {
        int n2 = Integer.parseInt((String)this.mSharedPreferences.getString("back_button_state", "2"));
        if (n2 == 0) {
            return SSAEnums.BackButtonState.None;
        }
        if (n2 == 1) {
            return SSAEnums.BackButtonState.Device;
        }
        if (n2 == 2) {
            return SSAEnums.BackButtonState.Controller;
        }
        return SSAEnums.BackButtonState.Controller;
    }

    public String getCampaignLastUpdate(String string) {
        return this.mSharedPreferences.getString(string, null);
    }

    public String getConnectionRetries() {
        return this.mSharedPreferences.getString("ssa_rv_parameter_connection_retries", "3");
    }

    public String getCurrentSDKVersion() {
        return this.mSharedPreferences.getString("version", "UN_VERSIONED");
    }

    public List<String> getSearchKeys() {
        SSAObj sSAObj;
        String string = this.mSharedPreferences.getString("search_keys", null);
        ArrayList arrayList = new ArrayList();
        if (string != null && (sSAObj = new SSAObj(string)).containsKey("searchKeys")) {
            JSONArray jSONArray = (JSONArray)sSAObj.get("searchKeys");
            try {
                arrayList.addAll((Collection)sSAObj.toList(jSONArray));
                return arrayList;
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
        return arrayList;
    }

    public JSONArray getSessions() {
        String string = this.mSharedPreferences.getString("sessions", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            return jSONArray;
        }
        catch (JSONException jSONException) {
            return new JSONArray();
        }
    }

    public String getUniqueId(SSAEnums.ProductType productType) {
        int n2 = 1.$SwitchMap$com$ironsource$sdk$data$SSAEnums$ProductType[productType.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return "EMPTY_UNIQUE_ID";
                }
                return this.mSharedPreferences.getString("unique_id_is", null);
            }
            return this.mSharedPreferences.getString("unique_id_ow", null);
        }
        return this.mSharedPreferences.getString("unique_id_rv", null);
    }

    public String getUniqueId(String string) {
        if (string.equalsIgnoreCase(SSAEnums.ProductType.RewardedVideo.toString())) {
            return this.mSharedPreferences.getString("unique_id_rv", null);
        }
        if (string.equalsIgnoreCase(SSAEnums.ProductType.OfferWall.toString())) {
            return this.mSharedPreferences.getString("unique_id_ow", null);
        }
        if (string.equalsIgnoreCase(SSAEnums.ProductType.Interstitial.toString())) {
            return this.mSharedPreferences.getString("unique_id_is", null);
        }
        return "EMPTY_UNIQUE_ID";
    }

    public String getUserData(String string) {
        String string2 = this.mSharedPreferences.getString(string, null);
        if (string2 != null) {
            return string2;
        }
        return "{}";
    }

    public void setApplicationKey(String string, SSAEnums.ProductType productType) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        int n2 = 1.$SwitchMap$com$ironsource$sdk$data$SSAEnums$ProductType[productType.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 == 3) {
                    editor.putString("application_key_is", string);
                }
            } else {
                editor.putString("application_key_ow", string);
            }
        } else {
            editor.putString("application_key_rv", string);
        }
        editor.commit();
    }

    public void setBackButtonState(String string) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putString("back_button_state", string);
        editor.commit();
    }

    public void setCampaignLastUpdate(String string, String string2) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putString(string, string2);
        editor.commit();
    }

    public void setCurrentSDKVersion(String string) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putString("version", string);
        editor.commit();
    }

    public boolean setLatestCompeltionsTime(String string, String string2, String string3) {
        String string4 = this.mSharedPreferences.getString("ssaUserData", null);
        if (!TextUtils.isEmpty((CharSequence)string4)) {
            try {
                JSONObject jSONObject;
                JSONObject jSONObject2 = new JSONObject(string4);
                if (!jSONObject2.isNull(string2) && !(jSONObject = jSONObject2.getJSONObject(string2)).isNull(string3)) {
                    jSONObject.getJSONObject(string3).put("timestamp", (Object)string);
                    SharedPreferences.Editor editor = this.mSharedPreferences.edit();
                    editor.putString("ssaUserData", jSONObject2.toString());
                    boolean bl2 = editor.commit();
                    return bl2;
                }
            }
            catch (JSONException jSONException) {
                IronSourceAsyncHttpRequestTask ironSourceAsyncHttpRequestTask = new IronSourceAsyncHttpRequestTask();
                Object[] arrobject = new String[1];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                stringBuilder.append(jSONException.getStackTrace()[0].getMethodName());
                arrobject[0] = stringBuilder.toString();
                ironSourceAsyncHttpRequestTask.execute(arrobject);
            }
        }
        return false;
    }

    public void setSSABCParameters(SSABCParameters sSABCParameters) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putString("ssa_rv_parameter_connection_retries", sSABCParameters.getConnectionRetries());
        editor.commit();
    }

    public void setSearchKeys(String string) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putString("search_keys", string);
        editor.commit();
    }

    public void setShouldRegisterSessions(boolean bl2) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putBoolean("register_sessions", bl2);
        editor.commit();
    }

    public boolean setUniqueId(String string, String string2) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        if (string2.equalsIgnoreCase(SSAEnums.ProductType.RewardedVideo.toString())) {
            editor.putString("unique_id_rv", string);
        } else if (string2.equalsIgnoreCase(SSAEnums.ProductType.OfferWall.toString())) {
            editor.putString("unique_id_ow", string);
        } else if (string2.equalsIgnoreCase(SSAEnums.ProductType.Interstitial.toString())) {
            editor.putString("unique_id_is", string);
        }
        return editor.commit();
    }

    public boolean setUserData(String string, String string2) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putString(string, string2);
        return editor.commit();
    }

    public void setUserID(String string, SSAEnums.ProductType productType) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        int n2 = 1.$SwitchMap$com$ironsource$sdk$data$SSAEnums$ProductType[productType.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 == 3) {
                    editor.putString("user_id_is", string);
                }
            } else {
                editor.putString("user_id_ow", string);
            }
        } else {
            editor.putString("user_id_rv", string);
        }
        editor.commit();
    }

}

