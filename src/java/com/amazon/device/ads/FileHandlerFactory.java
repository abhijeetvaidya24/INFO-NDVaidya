/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.FileInputHandler
 *  com.amazon.device.ads.FileOutputHandler
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.FileInputHandler;
import com.amazon.device.ads.FileOutputHandler;
import java.io.File;

interface FileHandlerFactory {
    public FileInputHandler createFileInputHandler(File var1);

    public FileInputHandler createFileInputHandler(File var1, String var2);

    public FileInputHandler createFileInputHandler(String var1);

    public FileOutputHandler createFileOutputHandler(File var1);

    public FileOutputHandler createFileOutputHandler(File var1, String var2);

    public FileOutputHandler createFileOutputHandler(String var1);
}

