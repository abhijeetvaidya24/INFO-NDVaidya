/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.lang.String
 */
package com.aerserv.sdk.model.vast;

import android.net.Uri;
import com.aerserv.sdk.model.vast.AdResource;

public final class IFrameAdResource
extends AdResource {
    public static final String ELEMENT_NAME = "IFrameResource";
    private static final long serialVersionUID = -2233154358621813080L;
    private String iFrameUri;

    public String getiFrameUri() {
        return this.iFrameUri;
    }

    public void setiFrameUri(String string) {
        Uri uri = string == null ? null : Uri.parse((String)string);
        if (uri != null) {
            this.iFrameUri = uri.toString();
        }
    }
}

