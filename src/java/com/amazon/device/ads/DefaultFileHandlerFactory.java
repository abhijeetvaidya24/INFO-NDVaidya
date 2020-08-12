/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.FileHandlerFactory;
import com.amazon.device.ads.FileInputHandler;
import com.amazon.device.ads.FileOutputHandler;
import java.io.File;

class DefaultFileHandlerFactory
implements FileHandlerFactory {
    DefaultFileHandlerFactory() {
    }

    @Override
    public FileInputHandler createFileInputHandler(File file) {
        FileInputHandler fileInputHandler = new FileInputHandler();
        fileInputHandler.setFile(file);
        return fileInputHandler;
    }

    @Override
    public FileInputHandler createFileInputHandler(File file, String string) {
        FileInputHandler fileInputHandler = new FileInputHandler();
        fileInputHandler.setFile(file, string);
        return fileInputHandler;
    }

    @Override
    public FileInputHandler createFileInputHandler(String string) {
        FileInputHandler fileInputHandler = new FileInputHandler();
        fileInputHandler.setFile(string);
        return fileInputHandler;
    }

    @Override
    public FileOutputHandler createFileOutputHandler(File file) {
        FileOutputHandler fileOutputHandler = new FileOutputHandler();
        fileOutputHandler.setFile(file);
        return fileOutputHandler;
    }

    @Override
    public FileOutputHandler createFileOutputHandler(File file, String string) {
        FileOutputHandler fileOutputHandler = new FileOutputHandler();
        fileOutputHandler.setFile(file, string);
        return fileOutputHandler;
    }

    @Override
    public FileOutputHandler createFileOutputHandler(String string) {
        FileOutputHandler fileOutputHandler = new FileOutputHandler();
        fileOutputHandler.setFile(string);
        return fileOutputHandler;
    }
}

