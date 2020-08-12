/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.os.ParcelFileDescriptor
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  java.io.FileDescriptor
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoSuchFieldException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.shockwave.pdfium;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.shockwave.pdfium.PdfDocument;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PdfiumCore {
    private static final Class FD_CLASS;
    private static final String TAG = "com.shockwave.pdfium.PdfiumCore";
    private static final Object lock;
    private static Field mFdField;
    private int mCurrentDpi;

    static {
        System.loadLibrary((String)"modpdfium");
        System.loadLibrary((String)"jniPdfium");
        FD_CLASS = FileDescriptor.class;
        mFdField = null;
        lock = new Object();
    }

    public PdfiumCore(Context context) {
        this.mCurrentDpi = context.getResources().getDisplayMetrics().densityDpi;
    }

    public static int getNumFd(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (mFdField == null) {
                mFdField = FD_CLASS.getDeclaredField("descriptor");
                mFdField.setAccessible(true);
            }
            int n2 = mFdField.getInt((Object)parcelFileDescriptor.getFileDescriptor());
            return n2;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return -1;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
            return -1;
        }
    }

    private native void nativeCloseDocument(long var1);

    private native void nativeClosePage(long var1);

    private native long nativeGetBookmarkDestIndex(long var1, long var3);

    private native String nativeGetBookmarkTitle(long var1);

    private native String nativeGetDocumentMetaText(long var1, String var3);

    private native Long nativeGetFirstChildBookmark(long var1, Long var3);

    private native int nativeGetPageCount(long var1);

    private native int nativeGetPageHeightPixel(long var1, int var3);

    private native int nativeGetPageWidthPixel(long var1, int var3);

    private native Long nativeGetSiblingBookmark(long var1, long var3);

    private native long nativeLoadPage(long var1, int var3);

    private native long nativeOpenDocument(int var1, String var2);

    private native long nativeOpenMemDocument(byte[] var1, String var2);

    private native void nativeRenderPageBitmap(long var1, Bitmap var3, int var4, int var5, int var6, int var7, int var8, boolean var9);

    private void recursiveGetBookmark(List<PdfDocument.Bookmark> list, PdfDocument pdfDocument, long l2) {
        Long l3;
        PdfDocument.Bookmark bookmark = new PdfDocument.Bookmark();
        bookmark.mNativePtr = l2;
        bookmark.title = this.nativeGetBookmarkTitle(l2);
        bookmark.pageIdx = this.nativeGetBookmarkDestIndex(pdfDocument.mNativeDocPtr, l2);
        list.add((Object)bookmark);
        Long l4 = this.nativeGetFirstChildBookmark(pdfDocument.mNativeDocPtr, l2);
        if (l4 != null) {
            this.recursiveGetBookmark(bookmark.getChildren(), pdfDocument, l4);
        }
        if ((l3 = this.nativeGetSiblingBookmark(pdfDocument.mNativeDocPtr, l2)) != null) {
            this.recursiveGetBookmark(list, pdfDocument, l3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void closeDocument(PdfDocument pdfDocument) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            for (Integer n2 : pdfDocument.mNativePagesPtr.keySet()) {
                this.nativeClosePage((Long)pdfDocument.mNativePagesPtr.get((Object)n2));
            }
            pdfDocument.mNativePagesPtr.clear();
            this.nativeCloseDocument(pdfDocument.mNativeDocPtr);
            ParcelFileDescriptor parcelFileDescriptor = pdfDocument.parcelFileDescriptor;
            if (parcelFileDescriptor == null) return;
            try {
                pdfDocument.parcelFileDescriptor.close();
            }
            catch (IOException iOException) {}
            pdfDocument.parcelFileDescriptor = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PdfDocument.Meta getDocumentMeta(PdfDocument pdfDocument) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            PdfDocument.Meta meta = new PdfDocument.Meta();
            meta.title = this.nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Title");
            meta.author = this.nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Author");
            meta.subject = this.nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Subject");
            meta.keywords = this.nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Keywords");
            meta.creator = this.nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Creator");
            meta.producer = this.nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Producer");
            meta.creationDate = this.nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "CreationDate");
            meta.modDate = this.nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "ModDate");
            return meta;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getPageCount(PdfDocument pdfDocument) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            return this.nativeGetPageCount(pdfDocument.mNativeDocPtr);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getPageHeight(PdfDocument pdfDocument, int n2) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            Long l2 = (Long)pdfDocument.mNativePagesPtr.get((Object)n2);
            if (l2 == null) return 0;
            return this.nativeGetPageHeightPixel(l2, this.mCurrentDpi);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getPageWidth(PdfDocument pdfDocument, int n2) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            Long l2 = (Long)pdfDocument.mNativePagesPtr.get((Object)n2);
            if (l2 == null) return 0;
            return this.nativeGetPageWidthPixel(l2, this.mCurrentDpi);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<PdfDocument.Bookmark> getTableOfContents(PdfDocument pdfDocument) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            ArrayList arrayList = new ArrayList();
            Long l2 = this.nativeGetFirstChildBookmark(pdfDocument.mNativeDocPtr, null);
            if (l2 != null) {
                this.recursiveGetBookmark((List<PdfDocument.Bookmark>)arrayList, pdfDocument, l2);
            }
            return arrayList;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PdfDocument newDocument(ParcelFileDescriptor parcelFileDescriptor, String string2) throws IOException {
        Object object;
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.parcelFileDescriptor = parcelFileDescriptor;
        Object object2 = object = lock;
        synchronized (object2) {
            pdfDocument.mNativeDocPtr = this.nativeOpenDocument(PdfiumCore.getNumFd(parcelFileDescriptor), string2);
            return pdfDocument;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PdfDocument newDocument(byte[] arrby, String string2) throws IOException {
        Object object;
        PdfDocument pdfDocument = new PdfDocument();
        Object object2 = object = lock;
        synchronized (object2) {
            pdfDocument.mNativeDocPtr = this.nativeOpenMemDocument(arrby, string2);
            return pdfDocument;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long openPage(PdfDocument pdfDocument, int n2) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            long l2 = this.nativeLoadPage(pdfDocument.mNativeDocPtr, n2);
            pdfDocument.mNativePagesPtr.put((Object)n2, (Object)l2);
            return l2;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void renderPageBitmap(PdfDocument pdfDocument, Bitmap bitmap, int n2, int n3, int n4, int n5, int n6, boolean bl2) {
        void var11_19;
        Object object;
        Object object2 = object = lock;
        // MONITORENTER : object2
        long l2 = (Long)pdfDocument.mNativePagesPtr.get((Object)n2);
        try {
            void var10_16;
            block11 : {
                void var13_14;
                block10 : {
                    try {
                        this.nativeRenderPageBitmap(l2, bitmap, this.mCurrentDpi, n3, n4, n5, n6, bl2);
                        return;
                    }
                    catch (Exception exception) {
                        break block10;
                    }
                    catch (NullPointerException nullPointerException) {
                        break block11;
                    }
                    catch (Throwable throwable) {
                        throw var11_19;
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                Log.e((String)TAG, (String)"Exception throw from native");
                var13_14.printStackTrace();
                return;
                catch (NullPointerException nullPointerException) {}
            }
            Log.e((String)TAG, (String)"mContext may be null");
            var10_16.printStackTrace();
            // MONITOREXIT : object2
            return;
        }
        catch (Throwable throwable) {
            throw var11_19;
        }
    }
}

