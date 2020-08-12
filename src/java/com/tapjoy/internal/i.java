/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.NoSuchElementException
 */
package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tapjoy.internal.ay;
import com.tapjoy.internal.bc;
import com.tapjoy.internal.bi;
import com.tapjoy.internal.cs;
import com.tapjoy.internal.dc;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.NoSuchElementException;

public final class i
extends ay
implements bc,
Closeable {
    private SQLiteDatabase a;
    private final bi b;
    private int c;

    public i(File file, bi bi2) {
        this.a = SQLiteDatabase.openOrCreateDatabase((File)file, null);
        this.b = bi2;
        if (this.a.getVersion() != 1) {
            this.a.beginTransaction();
            try {
                this.a.execSQL("CREATE TABLE IF NOT EXISTS List(value BLOB)");
                this.a.setVersion(1);
                this.a.setTransactionSuccessful();
            }
            finally {
                this.a.endTransaction();
            }
        }
        this.c = this.a();
    }

    private int a() {
        Cursor cursor;
        block2 : {
            int n2;
            cursor = null;
            try {
                cursor = this.a.rawQuery("SELECT COUNT(1) FROM List", null);
                if (!cursor.moveToNext()) break block2;
                n2 = cursor.getInt(0);
            }
            catch (Throwable throwable) {
                i.a(cursor);
                throw throwable;
            }
            i.a(cursor);
            return n2;
        }
        i.a(cursor);
        return 0;
    }

    private static Cursor a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public final Object a(int n2) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable throwable32;
        if (n2 < 0) throw new IndexOutOfBoundsException();
        if (n2 >= this.c) throw new IndexOutOfBoundsException();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            StringBuilder stringBuilder = new StringBuilder("SELECT value FROM List ORDER BY rowid LIMIT ");
            stringBuilder.append(n2);
            stringBuilder.append(",1");
            cursor = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
            if (!cursor.moveToNext()) throw new NoSuchElementException();
            byteArrayInputStream = new ByteArrayInputStream(cursor.getBlob(0));
        }
        catch (Throwable throwable2) {
            i.a(cursor);
            throw throwable2;
        }
        Object object = this.b.b((InputStream)byteArrayInputStream);
        dc.a((Closeable)byteArrayInputStream);
        i.a(cursor);
        return object;
        {
            catch (Throwable throwable32) {
            }
            catch (IOException iOException) {}
            {
                throw new IllegalStateException((Throwable)iOException);
            }
        }
        dc.a((Closeable)byteArrayInputStream);
        throw throwable32;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public final void b(int n2) {
        Cursor cursor;
        void var4_14;
        block10 : {
            Cursor cursor2;
            block8 : {
                int n3;
                block9 : {
                    if (n2 <= 0) throw new IndexOutOfBoundsException();
                    int n4 = this.c;
                    if (n2 > n4) throw new IndexOutOfBoundsException();
                    if (n2 == n4) {
                        this.clear();
                        return;
                    }
                    cursor = null;
                    SQLiteDatabase sQLiteDatabase = this.a;
                    StringBuilder stringBuilder = new StringBuilder("SELECT rowid FROM List ORDER BY rowid LIMIT ");
                    stringBuilder.append(n2 - 1);
                    stringBuilder.append(",1");
                    cursor2 = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
                    if (!cursor2.moveToNext()) break block8;
                    long l2 = cursor2.getLong(0);
                    cursor2.close();
                    SQLiteDatabase sQLiteDatabase2 = this.a;
                    StringBuilder stringBuilder2 = new StringBuilder("rowid <= ");
                    stringBuilder2.append(l2);
                    n3 = sQLiteDatabase2.delete("List", stringBuilder2.toString(), null);
                    this.c -= n3;
                    if (n3 != n2) break block9;
                    i.a(null);
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder("Try to delete ");
                stringBuilder.append(n2);
                stringBuilder.append(", but deleted ");
                stringBuilder.append(n3);
                throw new IllegalStateException(stringBuilder.toString());
            }
            try {
                throw new IllegalStateException();
            }
            catch (Throwable throwable) {
                cursor = cursor2;
            }
            break block10;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        i.a(cursor);
        throw var4_14;
    }

    public final void clear() {
        this.a.delete("List", "1", null);
        this.c = 0;
    }

    public final void close() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.a = null;
        }
    }

    protected final void finalize() {
        this.close();
        Object.super.finalize();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final boolean offer(Object object) {
        Throwable throwable2222;
        cs.a(object);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.b.a((OutputStream)byteArrayOutputStream, object);
        byte[] arrby = byteArrayOutputStream.toByteArray();
        dc.a((Closeable)byteArrayOutputStream);
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", arrby);
        if (this.a.insert("List", null, contentValues) == -1L) {
            return false;
        }
        this.c = 1 + this.c;
        return true;
        {
            catch (Throwable throwable2222) {
            }
            catch (IOException iOException) {}
            {
                throw new IllegalArgumentException((Throwable)iOException);
            }
        }
        dc.a((Closeable)byteArrayOutputStream);
        throw throwable2222;
    }

    public final Object peek() {
        if (this.c > 0) {
            return this.a(0);
        }
        return null;
    }

    public final Object poll() {
        if (this.c > 0) {
            Object object = this.peek();
            this.b(1);
            return object;
        }
        return null;
    }

    public final int size() {
        return this.c;
    }
}

