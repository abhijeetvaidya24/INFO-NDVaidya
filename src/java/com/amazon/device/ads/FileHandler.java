/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

abstract class FileHandler
implements Closeable {
    private static final String LOGTAG = "FileHandler";
    File file;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    FileHandler() {
    }

    private void closeStream() {
        Closeable closeable = this.getCloseableStream();
        if (closeable != null) {
            try {
                closeable.close();
                return;
            }
            catch (IOException iOException) {
                MobileAdsLogger mobileAdsLogger = this.logger;
                Object[] arrobject = new Object[]{iOException.getMessage()};
                mobileAdsLogger.e("Could not close the stream. %s", arrobject);
            }
        }
    }

    public abstract void close();

    protected void closeCloseables() {
        Closeable closeable = this.getCloseableReaderWriter();
        if (closeable != null) {
            try {
                closeable.close();
                return;
            }
            catch (IOException iOException) {
                MobileAdsLogger mobileAdsLogger = this.logger;
                Object[] arrobject = new Object[]{closeable.getClass().getSimpleName(), iOException.getMessage()};
                mobileAdsLogger.e("Could not close the %s. %s", arrobject);
                this.closeStream();
                return;
            }
        }
        this.closeStream();
    }

    public boolean doesFileExist() {
        if (this.isFileSet()) {
            return this.file.exists();
        }
        throw new IllegalStateException("A file has not been set, yet.");
    }

    protected abstract Closeable getCloseableReaderWriter();

    protected abstract Closeable getCloseableStream();

    public long getFileLength() {
        if (this.isFileSet()) {
            return this.file.length();
        }
        throw new IllegalStateException("A file has not been set, yet.");
    }

    public boolean isFileSet() {
        return this.file != null;
    }

    public abstract boolean isOpen();

    public boolean setFile(File file) {
        if (this.isFileSet()) {
            if (file.getAbsolutePath().equals((Object)this.file.getAbsolutePath())) {
                return true;
            }
            this.logger.e("Another file is already set in this FileOutputHandler. Close the other file before opening a new one.");
            return false;
        }
        this.file = file;
        return true;
    }

    public boolean setFile(File file, String string) {
        return this.setFile(new File(file, string));
    }

    public boolean setFile(String string) {
        return this.setFile(new File(string));
    }
}

