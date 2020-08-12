/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.android.publish.cache;

import java.io.Serializable;

public class h
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String filename;
    private long lastUseTimestamp;
    private String videoLocation;

    public h(String string) {
        this.filename = string;
    }

    public String a() {
        return this.filename;
    }

    public void a(long l2) {
        this.lastUseTimestamp = l2;
    }

    public void a(String string) {
        this.videoLocation = string;
    }

    public String b() {
        return this.videoLocation;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        h h2 = (h)object;
        String string = this.filename;
        return !(string == null ? h2.filename != null : !string.equals((Object)h2.filename));
    }

    public int hashCode() {
        String string = this.filename;
        int n2 = string == null ? 0 : string.hashCode();
        return 31 + n2;
    }
}

