/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.ct
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy;

import com.tapjoy.internal.ct;
import java.io.Serializable;

public class TJPlacementData
implements Serializable {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private String h;
    private int i;
    private boolean j;
    private String k;
    private boolean l;
    private String m;
    private String n;
    private boolean o = true;
    private boolean p = false;

    public TJPlacementData(String string, String string2) {
        this.setKey(string);
        this.updateUrl(string2);
        this.setPlacementType("app");
    }

    public TJPlacementData(String string, String string2, String string3) {
        this.setBaseURL(string);
        this.setHttpResponse(string2);
        this.m = string3;
        this.o = false;
        this.setPlacementType("app");
    }

    public String getBaseURL() {
        return this.c;
    }

    public String getCallbackID() {
        return this.m;
    }

    public String getContentViewId() {
        return this.n;
    }

    public String getHttpResponse() {
        return this.e;
    }

    public int getHttpStatusCode() {
        return this.f;
    }

    public String getKey() {
        return this.a;
    }

    public String getMediationURL() {
        return this.d;
    }

    public String getPlacementName() {
        return this.g;
    }

    public String getPlacementType() {
        return this.h;
    }

    public String getRedirectURL() {
        return this.k;
    }

    public String getUrl() {
        return this.b;
    }

    public int getViewType() {
        return this.i;
    }

    public boolean hasProgressSpinner() {
        return this.j;
    }

    public boolean isBaseActivity() {
        return this.o;
    }

    public boolean isPreloadDisabled() {
        return this.p;
    }

    public boolean isPrerenderingRequested() {
        return this.l;
    }

    public void resetPlacementRequestData() {
        this.setHttpResponse(null);
        this.setHttpStatusCode(0);
        this.setRedirectURL(null);
        this.setHasProgressSpinner(false);
        this.setPrerenderingRequested(false);
        this.setPreloadDisabled(false);
        this.setContentViewId(null);
    }

    public void setBaseURL(String string) {
        this.c = string;
    }

    public void setContentViewId(String string) {
        this.n = string;
    }

    public void setHasProgressSpinner(boolean bl) {
        this.j = bl;
    }

    public void setHttpResponse(String string) {
        this.e = string;
    }

    public void setHttpStatusCode(int n2) {
        this.f = n2;
    }

    public void setKey(String string) {
        this.a = string;
    }

    public void setMediationURL(String string) {
        this.d = string;
    }

    public void setPlacementName(String string) {
        this.g = string;
    }

    public void setPlacementType(String string) {
        this.h = string;
    }

    public void setPreloadDisabled(boolean bl) {
        this.p = bl;
    }

    public void setPrerenderingRequested(boolean bl) {
        this.l = bl;
    }

    public void setRedirectURL(String string) {
        this.k = string;
    }

    public void setViewType(int n2) {
        this.i = n2;
    }

    public void updateUrl(String string) {
        this.b = string;
        if (!ct.c((String)string)) {
            this.setBaseURL(string.substring(0, string.indexOf(47, 3 + string.indexOf("//"))));
        }
    }
}

