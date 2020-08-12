/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.accounts.AccountManager
 *  android.accounts.AccountManagerCallback
 *  android.accounts.AccountManagerFuture
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tappx.b.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import com.tappx.b.a;
import com.tappx.b.a.c;

@SuppressLint(value={"MissingPermission"})
public class b
implements c {
    private final AccountManager a;
    private final Account b;
    private final String c;
    private final boolean d;

    b(AccountManager accountManager, Account account, String string, boolean bl) {
        this.a = accountManager;
        this.b = account;
        this.c = string;
        this.d = bl;
    }

    public b(Context context, Account account, String string) {
        this(context, account, string, false);
    }

    public b(Context context, Account account, String string, boolean bl) {
        this(AccountManager.get((Context)context), account, string, bl);
    }

    public Account a() {
        return this.b;
    }

    @Override
    public void a(String string) {
        this.a.invalidateAuthToken(this.b.type, string);
    }

    public String b() {
        return this.c;
    }

    @Override
    public String c() {
        Bundle bundle;
        AccountManagerFuture accountManagerFuture = this.a.getAuthToken(this.b, this.c, this.d, null, null);
        try {
            bundle = (Bundle)accountManagerFuture.getResult();
        }
        catch (Exception exception) {
            throw new a("Error while retrieving auth token", exception);
        }
        boolean bl = accountManagerFuture.isDone();
        String string = null;
        if (bl) {
            boolean bl2 = accountManagerFuture.isCancelled();
            string = null;
            if (!bl2) {
                if (!bundle.containsKey("intent")) {
                    string = bundle.getString("authtoken");
                } else {
                    throw new a((Intent)bundle.getParcelable("intent"));
                }
            }
        }
        if (string != null) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got null auth token for type: ");
        stringBuilder.append(this.c);
        throw new a(stringBuilder.toString());
    }
}

