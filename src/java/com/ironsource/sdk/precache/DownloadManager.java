/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  com.ironsource.sdk.data.SSAFile
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.concurrent.Callable
 */
package com.ironsource.sdk.precache;

import android.os.Handler;
import android.os.Message;
import com.ironsource.sdk.data.SSAFile;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class DownloadManager {
    private static DownloadManager mDownloadManager;
    private String mCacheRootDirectory;
    private DownloadHandler mDownloadHandler;
    private Thread mMobileControllerThread;

    private DownloadManager(String string) {
        this.mCacheRootDirectory = string;
        this.mDownloadHandler = this.getDownloadHandler();
        IronSourceStorageUtils.deleteFolder(this.mCacheRootDirectory, "temp");
        IronSourceStorageUtils.makeDir(this.mCacheRootDirectory, "temp");
    }

    static byte[] getBytes(InputStream inputStream) throws IOException {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[8192];
        while ((n2 = inputStream.read(arrby, 0, arrby.length)) != -1) {
            byteArrayOutputStream.write(arrby, 0, n2);
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static DownloadManager getInstance(String string) {
        Class<DownloadManager> class_ = DownloadManager.class;
        synchronized (DownloadManager.class) {
            if (mDownloadManager == null) {
                mDownloadManager = new DownloadManager(string);
            }
            DownloadManager downloadManager = mDownloadManager;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return downloadManager;
        }
    }

    public void downloadFile(SSAFile sSAFile) {
        new Thread((Runnable)new SingleFileWorkerThread(sSAFile, this.mDownloadHandler, this.mCacheRootDirectory, this.getTempFilesDirectory())).start();
    }

    public void downloadMobileControllerFile(SSAFile sSAFile) {
        this.mMobileControllerThread = new Thread((Runnable)new SingleFileWorkerThread(sSAFile, this.mDownloadHandler, this.mCacheRootDirectory, this.getTempFilesDirectory()));
        this.mMobileControllerThread.start();
    }

    DownloadHandler getDownloadHandler() {
        return new DownloadHandler();
    }

    String getTempFilesDirectory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mCacheRootDirectory);
        stringBuilder.append(File.separator);
        stringBuilder.append("temp");
        return stringBuilder.toString();
    }

    public boolean isMobileControllerThreadLive() {
        Thread thread = this.mMobileControllerThread;
        return thread != null && thread.isAlive();
    }

    public void release() {
        mDownloadManager = null;
        this.mDownloadHandler.release();
        this.mDownloadHandler = null;
    }

    public void setOnPreCacheCompletion(OnPreCacheCompletion onPreCacheCompletion) {
        this.mDownloadHandler.setOnPreCacheCompletion(onPreCacheCompletion);
    }

    static class DownloadHandler
    extends Handler {
        OnPreCacheCompletion mListener;

        DownloadHandler() {
        }

        public void handleMessage(Message message) {
            int n2 = message.what;
            if (n2 != 1016) {
                if (n2 != 1017) {
                    return;
                }
                this.mListener.onFileDownloadFail((SSAFile)message.obj);
                return;
            }
            this.mListener.onFileDownloadSuccess((SSAFile)message.obj);
        }

        public void release() {
            this.mListener = null;
        }

        void setOnPreCacheCompletion(OnPreCacheCompletion onPreCacheCompletion) {
            if (onPreCacheCompletion != null) {
                this.mListener = onPreCacheCompletion;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    static class FileWorkerThread
    implements Callable<Result> {
        private long mConnectionRetries;
        private String mDirectory;
        private String mFileName;
        private String mFileUrl;
        private String mTmpFilesDirectory;

        public FileWorkerThread(String string, String string2, String string3, long l2, String string4) {
            this.mFileUrl = string;
            this.mDirectory = string2;
            this.mFileName = string3;
            this.mConnectionRetries = l2;
            this.mTmpFilesDirectory = string4;
        }

        /*
         * Exception decompiling
         */
        public Result call() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl140 : ALOAD_2 : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
            // java.lang.Thread.run(Thread.java:919)
            throw new IllegalStateException("Decompilation failed");
        }

        /*
         * Exception decompiling
         */
        Result downloadContent(String var1, int var2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl223 : SIPUSH : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
            // java.lang.Thread.run(Thread.java:919)
            throw new IllegalStateException("Decompilation failed");
        }

        byte[] getBytes(InputStream inputStream) throws IOException {
            return DownloadManager.getBytes(inputStream);
        }

        boolean renameFile(String string, String string2) throws Exception {
            return IronSourceStorageUtils.renameFile(string, string2);
        }

        int saveFile(byte[] arrby, String string) throws Exception {
            return IronSourceStorageUtils.saveFile(arrby, string);
        }
    }

    public static interface OnPreCacheCompletion {
        public void onFileDownloadFail(SSAFile var1);

        public void onFileDownloadSuccess(SSAFile var1);
    }

    static class Result {
        byte[] body;
        int responseCode;
        public String url;

        Result() {
        }
    }

    static class SingleFileWorkerThread
    implements Runnable {
        private String mCacheRootDirectory;
        private long mConnectionRetries;
        Handler mDownloadHandler;
        private String mFile;
        private String mFileName;
        private String mPath;
        private final String mTempFilesDirectory;

        SingleFileWorkerThread(SSAFile sSAFile, Handler handler, String string, String string2) {
            this.mFile = sSAFile.getFile();
            this.mPath = sSAFile.getPath();
            this.mFileName = this.guessFileName(this.mFile);
            this.mConnectionRetries = this.getConnectionRetries();
            this.mCacheRootDirectory = string;
            this.mDownloadHandler = handler;
            this.mTempFilesDirectory = string2;
        }

        /*
         * Exception decompiling
         */
        String convertErrorCodeToMessage(int var1_1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
            // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
            // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
            // java.lang.Thread.run(Thread.java:919)
            throw new IllegalStateException("Decompilation failed");
        }

        public long getConnectionRetries() {
            return Long.parseLong((String)IronSourceSharedPrefHelper.getSupersonicPrefHelper().getConnectionRetries());
        }

        FileWorkerThread getFileWorkerThread(String string, String string2, String string3, long l2, String string4) {
            FileWorkerThread fileWorkerThread = new FileWorkerThread(string, string2, string3, l2, string4);
            return fileWorkerThread;
        }

        Message getMessage() {
            return new Message();
        }

        String guessFileName(String string) {
            return SDKUtils.getFileName(this.mFile);
        }

        String makeDir(String string, String string2) {
            return IronSourceStorageUtils.makeDir(string, string2);
        }

        public void run() {
            SSAFile sSAFile = new SSAFile(this.mFileName, this.mPath);
            Message message = this.getMessage();
            message.obj = sSAFile;
            String string = this.makeDir(this.mCacheRootDirectory, this.mPath);
            if (string == null) {
                message.what = 1017;
                sSAFile.setErrMsg("unable_to_create_folder");
                this.mDownloadHandler.sendMessage(message);
                return;
            }
            int n2 = this.getFileWorkerThread((String)this.mFile, (String)string, (String)sSAFile.getFile(), (long)this.mConnectionRetries, (String)this.mTempFilesDirectory).call().responseCode;
            if (n2 != 200) {
                if (n2 != 404 && n2 != 1018 && n2 != 1019) {
                    switch (n2) {
                        default: {
                            switch (n2) {
                                default: {
                                    return;
                                }
                                case 1008: 
                                case 1009: 
                                case 1010: 
                                case 1011: 
                            }
                        }
                        case 1004: 
                        case 1005: 
                        case 1006: 
                    }
                }
                String string2 = this.convertErrorCodeToMessage(n2);
                message.what = 1017;
                sSAFile.setErrMsg(string2);
                this.mDownloadHandler.sendMessage(message);
                return;
            }
            message.what = 1016;
            this.mDownloadHandler.sendMessage(message);
        }
    }

}

