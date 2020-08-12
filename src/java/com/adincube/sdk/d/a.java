/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package com.adincube.sdk.d;

import com.adincube.sdk.util.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class a
extends Exception {
    private List<String> a = new ArrayList();

    public a(String string) {
        this(string, null, null);
    }

    public a(String string, Throwable throwable) {
        this(string, null, throwable);
    }

    public a(String string, List<String> list) {
        this(string, list, null);
    }

    public a(String string, List<String> list, Throwable throwable) {
        super(string, throwable);
        if (list != null) {
            this.a.addAll(list);
        }
    }

    public void a() {
        this.a(a.a.d);
    }

    public final void a(a.a a2) {
        com.adincube.sdk.util.a.a(a2, this.getMessage(), new Object[0]);
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            com.adincube.sdk.util.a.a(a2, (String)iterator.next(), new Object[0]);
        }
    }
}

