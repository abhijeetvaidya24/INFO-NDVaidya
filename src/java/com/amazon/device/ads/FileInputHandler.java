/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.BufferedReader
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.FileHandler;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

class FileInputHandler
extends FileHandler {
    private static final String LOGTAG = "FileInputHandler";
    private BufferedReader bufferedReader;
    private InputStream inputStream;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    FileInputHandler() {
    }

    private void checkReadable() {
        if (this.bufferedReader != null) {
            return;
        }
        throw new IllegalStateException("Could not read from the file because no file has been opened yet. Please set the file, then call open() before attempting to read.");
    }

    @Override
    public void close() {
        this.closeCloseables();
        this.bufferedReader = null;
        this.inputStream = null;
    }

    @Override
    protected Closeable getCloseableReaderWriter() {
        return this.bufferedReader;
    }

    @Override
    protected Closeable getCloseableStream() {
        return this.inputStream;
    }

    @Override
    public boolean isOpen() {
        return this.inputStream != null;
    }

    public boolean open() {
        FileInputStream fileInputStream;
        if (this.file == null) {
            this.logger.e("A file must be set before it can be opened.");
            return false;
        }
        if (this.inputStream != null) {
            this.logger.e("The file is already open.");
            return false;
        }
        try {
            fileInputStream = new FileInputStream(this.file);
        }
        catch (Exception exception) {
            return false;
        }
        this.inputStream = new BufferedInputStream((InputStream)fileInputStream);
        this.bufferedReader = new BufferedReader((Reader)new InputStreamReader(this.inputStream));
        return true;
    }

    public byte[] readAllBytesFromFileAndClose() {
        if (!this.isOpen() && !this.open()) {
            this.logger.e("Could not open the file for reading");
            return null;
        }
        byte[] arrby = this.readBytes();
        this.close();
        return arrby;
    }

    public byte[] readBytes() {
        byte[] arrby;
        int n2;
        this.checkReadable();
        try {
            arrby = new byte[(int)this.file.length()];
            n2 = 0;
        }
        catch (IOException iOException) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{iOException.getMessage()};
            mobileAdsLogger.e("Error reading bytes from input file: %s", arrobject);
            return null;
        }
        do {
            if (n2 >= arrby.length) break;
            int n3 = arrby.length - n2;
            int n4 = this.inputStream.read(arrby, n2, n3);
            if (n4 <= 0) continue;
            n2 += n4;
        } while (true);
        return arrby;
    }

    public String readLine() {
        this.checkReadable();
        try {
            String string = this.bufferedReader.readLine();
            return string;
        }
        catch (IOException iOException) {
            this.logger.e("Error reading line from file.");
            return null;
        }
    }
}

