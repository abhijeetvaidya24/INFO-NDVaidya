/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.yandex.metrica.IMetricaService
 *  com.yandex.metrica.impl.ad
 *  com.yandex.metrica.impl.aw
 *  com.yandex.metrica.impl.h
 *  java.lang.Object
 */
package com.yandex.metrica.impl;

import android.content.Context;
import android.os.RemoteException;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ad;
import com.yandex.metrica.impl.aw;
import com.yandex.metrica.impl.h;

interface s {
    public ad a();

    public void a(IMetricaService var1, h var2, aw var3) throws RemoteException;

    public Context b();
}

