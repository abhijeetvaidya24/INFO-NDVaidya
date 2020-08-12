/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Serializable
 *  java.io.Writer
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.chartboost.sdk.impl;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

public class bk
extends Writer
implements Serializable {
    private final StringBuilder a;

    public bk() {
        this.a = new StringBuilder();
    }

    public bk(int n2) {
        this.a = new StringBuilder(n2);
    }

    public Writer append(char c2) {
        this.a.append(c2);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int n2, int n3) {
        this.a.append(charSequence, n2, n3);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.a.toString();
    }

    public void write(String string) {
        if (string != null) {
            this.a.append(string);
        }
    }

    public void write(char[] arrc, int n2, int n3) {
        if (arrc != null) {
            this.a.append(arrc, n2, n3);
        }
    }
}

