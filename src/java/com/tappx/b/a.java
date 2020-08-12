/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.tappx.b;

import android.content.Intent;
import com.tappx.b.k;
import com.tappx.b.u;

public class a
extends u {
    private Intent b;

    public a() {
    }

    public a(Intent intent) {
        this.b = intent;
    }

    public a(k k2) {
        super(k2);
    }

    public a(String string) {
        super(string);
    }

    public a(String string, Exception exception) {
        super(string, exception);
    }

    public Intent a() {
        return this.b;
    }

    public String getMessage() {
        if (this.b != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}

