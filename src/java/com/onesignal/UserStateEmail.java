/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.onesignal;

import com.onesignal.UserState;

class UserStateEmail
extends UserState {
    UserStateEmail(String string, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("email");
        stringBuilder.append(string);
        super(stringBuilder.toString(), bl2);
    }

    @Override
    protected void addDependFields() {
    }

    @Override
    boolean isSubscribed() {
        return true;
    }

    @Override
    UserState newInstance(String string) {
        return new UserStateEmail(string, false);
    }
}

