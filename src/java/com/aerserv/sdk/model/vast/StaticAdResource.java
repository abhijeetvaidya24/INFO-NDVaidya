/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.io.Serializable
 *  java.lang.String
 */
package com.aerserv.sdk.model.vast;

import android.net.Uri;
import com.aerserv.sdk.model.vast.AdResource;
import java.io.Serializable;

public final class StaticAdResource
extends AdResource
implements Serializable {
    public static final String ELEMENT_NAME = "StaticResource";
    private static final long serialVersionUID = 895763327068040441L;
    private String mimeType;
    private String resourceUri;

    public String getMimeType() {
        return this.mimeType;
    }

    public String getResourceUri() {
        return this.resourceUri;
    }

    public void setMimeType(String string) {
        this.mimeType = string;
    }

    public void setResourceUri(String string) {
        Uri uri = string == null ? null : Uri.parse((String)string.trim());
        if (uri != null) {
            this.resourceUri = uri.toString();
        }
    }
}

