/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  com.tapjoy.TapjoyErrorMessage
 *  com.tapjoy.TapjoyErrorMessage$ErrorType
 *  com.tapjoy.TapjoyHttpURLResponse
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.TapjoyURLConnection
 *  com.tapjoy.TapjoyUtil
 *  com.tapjoy.internal.eu
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.Map
 *  java.util.UUID
 *  org.w3c.dom.Document
 *  org.w3c.dom.NodeList
 */
package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.internal.eu;
import java.util.Map;
import java.util.UUID;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class TJCurrency {
    private static TJGetCurrencyBalanceListener d;
    private static TJSpendCurrencyListener e;
    private static TJAwardCurrencyListener f;
    private static TJEarnedCurrencyListener g;
    String a = null;
    int b = 0;
    Context c;

    public TJCurrency(Context context) {
        this.c = context;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(TapjoyHttpURLResponse var1_1) {
        block9 : {
            block8 : {
                block10 : {
                    block11 : {
                        var16_2 = this;
                        // MONITORENTER : var16_2
                        if (var1_1.response == null) break block8;
                        var3_3 = TapjoyUtil.buildDocument((String)var1_1.response);
                        if (var3_3 == null) break block9;
                        var4_4 = TapjoyUtil.getNodeTrimValue((NodeList)var3_3.getElementsByTagName("Success"));
                        if (var4_4 == null || !var4_4.equals((Object)"true")) break block10;
                        var5_5 = TapjoyUtil.getNodeTrimValue((NodeList)var3_3.getElementsByTagName("TapPoints"));
                        var6_6 = TapjoyUtil.getNodeTrimValue((NodeList)var3_3.getElementsByTagName("CurrencyName"));
                        if (var5_5 == null || var6_6 == null) break block11;
                        var11_7 = Integer.parseInt((String)var5_5);
                        var12_8 = this.getLocalCurrencyBalance();
                        if (TJCurrency.g == null || var12_8 == -9999 || var11_7 <= var12_8) ** GOTO lbl21
                        var13_9 = new StringBuilder("earned: ");
                        var14_10 = var11_7 - var12_8;
                        try {
                            var13_9.append(var14_10);
                            TapjoyLog.i((String)"TJCurrency", (String)var13_9.toString());
                            TJCurrency.g.onEarnedCurrency(var6_6, var14_10);
lbl21: // 2 sources:
                            this.saveCurrencyBalance(var11_7);
                            if (TJCurrency.d != null) {
                                TJCurrency.d.onGetCurrencyBalanceResponse(var6_6, var11_7);
                            }
                            // MONITOREXIT : var16_2
                            return;
                        }
                        catch (Exception var7_11) {
                            var8_12 = TapjoyErrorMessage.ErrorType.SERVER_ERROR;
                            var9_13 = new StringBuilder("Error parsing XML and calling listener: ");
                            var9_13.append(var7_11.toString());
                            TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(var8_12, var9_13.toString()));
                        }
                        break block9;
                    }
                    TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing tags."));
                    break block9;
                }
                TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing <Success> tag."));
                break block9;
            }
            TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is NULL"));
        }
        if (TJCurrency.d != null) {
            TJCurrency.d.onGetCurrencyBalanceResponseFailure("Failed to get currency balance");
        }
        // MONITOREXIT : var16_2
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        TJCurrency tJCurrency = this;
        synchronized (tJCurrency) {
            String string = "Failed to spend currency";
            if (tapjoyHttpURLResponse.response != null) {
                Document document = TapjoyUtil.buildDocument((String)tapjoyHttpURLResponse.response);
                if (document != null) {
                    String string2 = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("Success"));
                    if (string2 != null && string2.equals((Object)"true")) {
                        String string3 = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("TapPoints"));
                        String string4 = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("CurrencyName"));
                        if (string3 != null && string4 != null) {
                            int n2 = Integer.parseInt((String)string3);
                            this.saveCurrencyBalance(n2);
                            if (e != null) {
                                e.onSpendCurrencyResponse(string4, n2);
                            }
                            return;
                        }
                        TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "spendCurrency response is invalid -- missing tags."));
                    } else if (string2 != null && string2.endsWith("false")) {
                        string = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("Message"));
                        TapjoyLog.i((String)"TJCurrency", (String)string);
                        if ("BalanceTooLowError".equals((Object)TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("MessageCode")))) {
                            eu.a();
                        }
                    } else {
                        TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "spendCurrency response is invalid -- missing <Success> tag."));
                    }
                }
            } else {
                TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "spendCurrency response is NULL"));
            }
            if (e != null) {
                e.onSpendCurrencyResponseFailure(string);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        TJCurrency tJCurrency = this;
        synchronized (tJCurrency) {
            String string = "Failed to award currency";
            if (tapjoyHttpURLResponse.response != null) {
                Document document = TapjoyUtil.buildDocument((String)tapjoyHttpURLResponse.response);
                if (document != null) {
                    String string2 = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("Success"));
                    if (string2 != null && string2.equals((Object)"true")) {
                        String string3 = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("TapPoints"));
                        String string4 = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("CurrencyName"));
                        if (string3 != null && string4 != null) {
                            int n2 = Integer.parseInt((String)string3);
                            this.saveCurrencyBalance(n2);
                            if (f != null) {
                                f.onAwardCurrencyResponse(string4, n2);
                            }
                            return;
                        }
                        TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing tags."));
                    } else if (string2 != null && string2.endsWith("false")) {
                        string = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("Message"));
                        TapjoyLog.i((String)"TJCurrency", (String)string);
                    } else {
                        TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing <Success> tag."));
                    }
                }
            } else {
                TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is NULL"));
            }
            if (f != null) {
                f.onAwardCurrencyResponseFailure(string);
            }
            return;
        }
    }

    public void awardCurrency(int n2, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (n2 < 0) {
            TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the awardCurrency API"));
            return;
        }
        this.b = n2;
        f = tJAwardCurrencyListener;
        String string = UUID.randomUUID().toString();
        long l2 = System.currentTimeMillis() / 1000L;
        final Map map = TapjoyConnectCore.getGenericURLParams();
        TapjoyUtil.safePut((Map)map, (String)"tap_points", (String)String.valueOf((int)this.b), (boolean)true);
        TapjoyUtil.safePut((Map)map, (String)"guid", (String)string, (boolean)true);
        TapjoyUtil.safePut((Map)map, (String)"timestamp", (String)String.valueOf((long)l2), (boolean)true);
        TapjoyUtil.safePut((Map)map, (String)"verifier", (String)TapjoyConnectCore.getAwardCurrencyVerifier(l2, this.b, string), (boolean)true);
        new Thread(new Runnable(){

            public final void run() {
                TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(TapjoyConnectCore.getHostURL());
                stringBuilder.append("points/award?");
                TapjoyHttpURLResponse tapjoyHttpURLResponse = tapjoyURLConnection.getResponseFromURL(stringBuilder.toString(), map);
                TJCurrency.this.c(tapjoyHttpURLResponse);
            }
        }).start();
    }

    public void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        d = tJGetCurrencyBalanceListener;
        new Thread(new Runnable(TapjoyConnectCore.getURLParams()){
            final /* synthetic */ Map a;
            {
                this.a = map;
            }

            public final void run() {
                TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(TapjoyConnectCore.getHostURL());
                stringBuilder.append("get_vg_store_items/user_account?");
                TapjoyHttpURLResponse tapjoyHttpURLResponse = tapjoyURLConnection.getResponseFromURL(stringBuilder.toString(), this.a);
                TJCurrency.this.a(tapjoyHttpURLResponse);
            }
        }).start();
    }

    public int getLocalCurrencyBalance() {
        return this.c.getSharedPreferences("tjcPrefrences", 0).getInt("last_currency_balance", -9999);
    }

    public void saveCurrencyBalance(int n2) {
        SharedPreferences.Editor editor = this.c.getSharedPreferences("tjcPrefrences", 0).edit();
        editor.putInt("last_currency_balance", n2);
        editor.commit();
    }

    public void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        g = tJEarnedCurrencyListener;
    }

    public void spendCurrency(int n2, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (n2 < 0) {
            TapjoyLog.e((String)"TJCurrency", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the spendCurrency API"));
            return;
        }
        this.a = String.valueOf((int)n2);
        e = tJSpendCurrencyListener;
        final Map map = TapjoyConnectCore.getURLParams();
        TapjoyUtil.safePut((Map)map, (String)"tap_points", (String)this.a, (boolean)true);
        new Thread(new Runnable(){

            public final void run() {
                TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(TapjoyConnectCore.getHostURL());
                stringBuilder.append("points/spend?");
                TapjoyHttpURLResponse tapjoyHttpURLResponse = tapjoyURLConnection.getResponseFromURL(stringBuilder.toString(), map);
                TJCurrency.this.b(tapjoyHttpURLResponse);
            }
        }).start();
    }

}

