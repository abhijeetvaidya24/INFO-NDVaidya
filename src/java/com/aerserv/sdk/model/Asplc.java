/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.math.BigDecimal
 *  java.math.RoundingMode
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Queue
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.model;

import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.CommonUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;

public class Asplc {
    private static final Map<Integer, Asplc> ASPLC_MAP = new HashMap();
    private static int CELLULAR_LIMIT = 0;
    private static final int DEFAULT_CELLULAR_LIMIT = 1;
    public static final long DEFAULT_LOAD_TIMEOUT = 6000L;
    private static final int DEFAULT_WIFI_LIMIT = 4;
    private static final String LOG_TAG = "Asplc";
    private static int WIFI_LIMIT;
    private String adapterName;
    private int asplcId;
    private BigDecimal dynamicPrice;
    private boolean hasVcEnabled;
    private JSONObject jsonObject;
    private long loadTimeout = 6000L;
    private String rid;
    private String sdkEventUrl;
    private String token;
    private AerServVirtualCurrency vc;

    private Asplc(int n2, String string, String string2, JSONObject jSONObject, boolean bl, AerServVirtualCurrency aerServVirtualCurrency) {
        this.asplcId = n2;
        this.sdkEventUrl = string;
        this.adapterName = string2;
        this.jsonObject = jSONObject;
        this.hasVcEnabled = bl;
        this.vc = aerServVirtualCurrency;
    }

    public static final Asplc getAsplc(int n2) {
        return (Asplc)ASPLC_MAP.get((Object)n2);
    }

    public static int getCellularLimit() {
        return CELLULAR_LIMIT;
    }

    public static final String getStep3CallInputString(Queue<Asplc> queue, List<Integer> list, String string) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("{\"rid\": \"");
        stringBuilder.append(string);
        stringBuilder.append("\", \"adapters\": [");
        if (queue != null && !queue.isEmpty()) {
            for (Asplc asplc : queue) {
                stringBuilder.append("{\"asplcid\": ");
                stringBuilder.append(asplc.getAsplcId());
                BigDecimal bigDecimal = asplc.getDynamicPrice();
                if (bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                    stringBuilder.append(", \"price\": ");
                    stringBuilder.append(bigDecimal.setScale(2, RoundingMode.FLOOR).toString());
                }
                stringBuilder.append("},");
            }
        }
        if (list != null && !list.isEmpty()) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                int n2 = (Integer)iterator.next();
                stringBuilder.append("{\"asplcid\": ");
                stringBuilder.append(n2);
                stringBuilder.append("},");
            }
        }
        if (stringBuilder.charAt(-1 + stringBuilder.length()) == ',') {
            stringBuilder.setLength(-1 + stringBuilder.length());
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

    public static int getWifiLimit() {
        return WIFI_LIMIT;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Asplc newInstance(JSONObject jSONObject) {
        AerServVirtualCurrency aerServVirtualCurrency;
        int n2;
        boolean bl;
        String string;
        String string2;
        block4 : {
            block3 : {
                try {
                    n2 = jSONObject.optInt("asplcid", 0);
                    string = jSONObject.optString("baseEventUrl", null);
                    string2 = jSONObject.optString("adapterName", null);
                    aerServVirtualCurrency = jSONObject.has("vc") ? (AerServVirtualCurrency)jSONObject.get("vc") : null;
                    if ((aerServVirtualCurrency == null || !aerServVirtualCurrency.isEnabled()) && !jSONObject.optBoolean("hasVC", false)) break block3;
                }
                catch (Throwable throwable) {
                    String string3 = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Exception paring asplc ");
                    stringBuilder.append(jSONObject.toString());
                    stringBuilder.append(" ");
                    stringBuilder.append(throwable.getMessage());
                    AerServLog.w(string3, stringBuilder.toString());
                    return null;
                }
                bl = true;
                break block4;
            }
            bl = false;
        }
        if (n2 <= 0 || string == null || string.isEmpty()) return null;
        {
            Asplc asplc = new Asplc(n2, string, string2, new JSONObject(jSONObject.toString()), bl, aerServVirtualCurrency);
            asplc.setLoadTimeout(jSONObject);
            return asplc;
        }
    }

    public static final Asplc putAsplc(JSONObject jSONObject) {
        Asplc asplc = Asplc.newInstance(jSONObject);
        if (asplc != null) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("put Asplc ");
            stringBuilder.append(asplc.toString());
            AerServLog.d(string, stringBuilder.toString());
            ASPLC_MAP.put((Object)asplc.getAsplcId(), (Object)asplc);
        }
        return asplc;
    }

    public static void setLimit(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("limits");
            WIFI_LIMIT = jSONObject2.optInt("wifi", 4);
            CELLULAR_LIMIT = jSONObject2.optInt("cellular", 1);
            return;
        }
        catch (JSONException jSONException) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read limit: ");
            stringBuilder.append(jSONException.getMessage());
            AerServLog.i(string, stringBuilder.toString());
            return;
        }
    }

    public String getAdapterName() {
        return this.adapterName;
    }

    public int getAsplcId() {
        return this.asplcId;
    }

    public BigDecimal getDynamicPrice() {
        return this.dynamicPrice;
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public long getLoadTimeout() {
        return this.loadTimeout;
    }

    public String getRid() {
        return this.rid;
    }

    public String getSdkEventUrl() {
        return this.sdkEventUrl;
    }

    public String getToken() {
        return this.token;
    }

    public AerServVirtualCurrency getVc() {
        return this.vc;
    }

    public boolean hasVcEnabled() {
        return this.hasVcEnabled;
    }

    public void setAdapterName(String string) {
        this.adapterName = string;
    }

    public void setDynamicPrice(BigDecimal bigDecimal) {
        this.dynamicPrice = bigDecimal;
    }

    public void setLoadTimeout(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("Timeout")) {
            this.loadTimeout = CommonUtils.getLong(jSONObject, -10 + AerServSettings.getStep2Timeout(), "Timeout");
            return;
        }
        if (jSONObject != null && jSONObject.has("timeout")) {
            this.loadTimeout = CommonUtils.getLong(jSONObject, -10 + AerServSettings.getStep2Timeout(), "timeout");
        }
    }

    public void setRid(String string) {
        this.rid = string;
    }

    public void setToken(String string) {
        this.token = string;
    }

    public void setVc(AerServVirtualCurrency aerServVirtualCurrency) {
        this.vc = aerServVirtualCurrency;
        boolean bl = this.hasVcEnabled || aerServVirtualCurrency != null && aerServVirtualCurrency.isEnabled();
        this.hasVcEnabled = bl;
        if ("AdColony".equals((Object)this.adapterName)) {
            this.setDynamicPrice(aerServVirtualCurrency.getBuyerPrice());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.asplcId);
        stringBuilder.append(' ');
        stringBuilder.append(this.adapterName);
        stringBuilder.append(" hasVC: ");
        stringBuilder.append(this.hasVcEnabled);
        stringBuilder.append(" timeout: ");
        stringBuilder.append(this.loadTimeout);
        return stringBuilder.toString();
    }
}

