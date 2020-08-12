/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.OutputStream
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.configuration;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectSerializer<T> {
    private Context _context;

    public ObjectSerializer(Context context) {
        this._context = context;
    }

    public T loadSerializedObject(String string2) throws IOException, ClassNotFoundException {
        if (this._context.getFileStreamPath(string2).exists()) {
            return (T)new ObjectInputStream((InputStream)this._context.openFileInput(string2)).readObject();
        }
        throw new IOException();
    }

    public void serializeAndSaveObject(T t, String string2) throws IOException {
        FileOutputStream fileOutputStream = this._context.openFileOutput(string2, 0);
        new ObjectOutputStream((OutputStream)fileOutputStream).writeObject(t);
        fileOutputStream.close();
    }
}

