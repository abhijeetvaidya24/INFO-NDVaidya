/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk;

import com.appsgeyser.sdk.Logger;

class ExceptionHandler {
    static void handleException(Exception exception) {
        Logger.ErrorLog(exception.getMessage());
    }
}

