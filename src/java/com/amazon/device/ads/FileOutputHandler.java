/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedOutputStream
 *  java.io.BufferedWriter
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Writer
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.FileHandler;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

class FileOutputHandler
extends FileHandler {
    private static final String LOGTAG = "FileOutputHandler";
    private BufferedWriter bufferedWriter;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    private OutputStream outputStream;
    private WriteMethod writeMethod;

    FileOutputHandler() {
    }

    private void checkWritable() {
        if (this.bufferedWriter != null) {
            return;
        }
        throw new IllegalStateException("Could not write to the file because no file has been opened yet. Please set the file, then call open() before attempting to write.");
    }

    private boolean writeToFile(String string, WriteMethod writeMethod) {
        if (this.isOpen()) {
            if (!writeMethod.equals((Object)this.writeMethod)) {
                this.close();
                if (!this.open(writeMethod)) {
                    MobileAdsLogger mobileAdsLogger = this.logger;
                    Object[] arrobject = new Object[]{writeMethod.toString()};
                    mobileAdsLogger.e("Could not reopen the file for %s.", arrobject);
                    return false;
                }
            }
        } else if (!this.open(writeMethod)) {
            this.logger.e("Could not open the file for writing.");
            return false;
        }
        try {
            this.write(string);
        }
        catch (IOException iOException) {
            this.logger.e("Failed to write data to the file.");
            return false;
        }
        this.close();
        return true;
    }

    public boolean appendToFile(String string) {
        return this.writeToFile(string, WriteMethod.APPEND);
    }

    @Override
    public void close() {
        this.flush();
        this.closeCloseables();
        this.bufferedWriter = null;
        this.outputStream = null;
    }

    public void flush() {
        BufferedWriter bufferedWriter;
        OutputStream outputStream = this.outputStream;
        if (outputStream != null) {
            try {
                outputStream.flush();
            }
            catch (IOException iOException) {
                MobileAdsLogger mobileAdsLogger = this.logger;
                Object[] arrobject = new Object[]{iOException.getMessage()};
                mobileAdsLogger.e("Could not flush the OutputStream. %s", arrobject);
            }
        }
        if ((bufferedWriter = this.bufferedWriter) != null) {
            try {
                bufferedWriter.flush();
                return;
            }
            catch (IOException iOException) {
                MobileAdsLogger mobileAdsLogger = this.logger;
                Object[] arrobject = new Object[]{iOException.getMessage()};
                mobileAdsLogger.e("Could not flush the BufferedWriter. %s", arrobject);
            }
        }
    }

    @Override
    protected Closeable getCloseableReaderWriter() {
        return this.bufferedWriter;
    }

    @Override
    protected Closeable getCloseableStream() {
        return this.outputStream;
    }

    @Override
    public boolean isOpen() {
        return this.outputStream != null;
    }

    public boolean open(WriteMethod writeMethod) {
        FileOutputStream fileOutputStream;
        if (this.file == null) {
            this.logger.e("A file must be set before it can be opened.");
            return false;
        }
        if (this.outputStream != null) {
            this.logger.e("The file is already open.");
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(this.file, WriteMethod.APPEND.equals((Object)writeMethod));
        }
        catch (Exception exception) {
            return false;
        }
        this.writeMethod = writeMethod;
        this.outputStream = new BufferedOutputStream((OutputStream)fileOutputStream);
        this.bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter(this.outputStream));
        return true;
    }

    public boolean overwriteFile(String string) {
        return this.writeToFile(string, WriteMethod.OVERWRITE);
    }

    public void write(String string) throws IOException {
        this.checkWritable();
        this.bufferedWriter.write(string);
    }

    public void write(byte[] arrby) throws IOException {
        this.checkWritable();
        this.outputStream.write(arrby);
    }

}

