/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayDeque
 *  java.util.Queue
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONObject
 */
package com.adincube.sdk.i;

import com.adincube.sdk.i.d;
import com.adincube.sdk.i.h;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.e;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a {
    private static String d;
    private h a = null;
    private Queue<a> b = new ArrayDeque();
    private AtomicBoolean c = new AtomicBoolean(false);

    public a(h h2) {
        this.a = h2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String b() {
        if (d != null) return d;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            String string = d;
            if (string != null) return d;
            try {
                d = e.c("KGZ1bmN0aW9uKCl7ZnVuY3Rpb24gZXhlY3V0ZU9uKG9iail7aWYob2JqPT09bnVsbHx8b2JqPT09dW5kZWZpbmVkKXtyZXR1cm4gZmFsc2V9aWYob2JqLl9tcmFpZD09PW51bGx8fG9iai5fbXJhaWQ9PT11bmRlZmluZWQpe3JldHVybiBmYWxzZX1pZihvYmouX21yYWlkLl9fZm5fXz09PW51bGx8fG9iai5fbXJhaWQuX19mbl9fPT09dW5kZWZpbmVkKXtyZXR1cm4gZmFsc2V9b2JqLl9tcmFpZC5fX2ZuX18oX19hcmdzX18pO3JldHVybiB0cnVlfXZhciBleGVjdXRlZD1leGVjdXRlT24od2luZG93KTt2YXIgaT0wO3ZhciBpZnJhbWVzPWRvY3VtZW50LmdldEVsZW1lbnRzQnlUYWdOYW1lKCJpZnJhbWUiKTt3aGlsZSghZXhlY3V0ZWQmJmk8aWZyYW1lcy5sZW5ndGgpe2V4ZWN1dGVkPWV4ZWN1dGVPbihpZnJhbWVzW2ldLmNvbnRlbnRXaW5kb3cpO2krK31pZighZXhlY3V0ZWQpe2NvbnNvbGUubG9nKCJfX2ZuX18gaGFzIG5vdCBiZWVuIGV4ZWN1dGVkLiIpfX0pKCk7");
            }
            catch (Throwable throwable) {
                com.adincube.sdk.util.a.c("MRAIDBridge#MraidFunctionCall.getFunctionCallJs", new Object[]{throwable});
                ErrorReportingHelper.report("MRAIDBridge#MraidFunctionCall.getFunctionCallJs", throwable);
            }
            return d;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void b(a a2) {
        Queue<a> queue;
        Queue<a> queue2 = queue = a2.b;
        synchronized (queue2) {
            while (a2.b.size() > 0) {
                ((a)a2.b.poll()).a();
            }
            return;
        }
    }

    final /* varargs */ void a(d d2, Object ... arrobject) {
        int n2;
        int n3 = arrobject.length;
        Object[] arrobject2 = new Object[n3 + n2];
        arrobject2[0] = d2;
        for (n2 = 1; n2 <= arrobject.length; ++n2) {
            arrobject2[n2] = arrobject[n2 - 1];
        }
        this.a("_fireEvent", arrobject2);
    }

    final void a(String string) {
        h h2 = this.a;
        StringBuilder stringBuilder = new StringBuilder("javascript:");
        stringBuilder.append(string);
        h2.a(stringBuilder.toString(), null, null, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final /* varargs */ void a(String string, Object ... arrobject) {
        Queue<a> queue;
        a a2 = new a(this.a, string, arrobject);
        Queue<a> queue2 = queue = this.b;
        synchronized (queue2) {
            int n2 = this.b.size();
            boolean bl = true;
            if (n2 <= 0 && this.c.get()) {
                bl = false;
            }
            if (bl) {
                this.b.add((Object)a2);
            } else {
                a2.a();
            }
            return;
        }
    }

    private class a {
        private h b = null;
        private String c = null;
        private Object[] d = null;

        public /* varargs */ a(h h2, String string, Object ... arrobject) {
            this.b = h2;
            this.c = string;
            this.d = arrobject;
        }

        /*
         * Enabled aggressive block sorting
         */
        public final void a() {
            String string;
            String string2 = this.c;
            Object[] arrobject = this.d;
            StringBuilder stringBuilder = new StringBuilder("javascript:");
            stringBuilder.append(a.b());
            String string3 = stringBuilder.toString().replace((CharSequence)"__fn__", (CharSequence)string2);
            if (arrobject.length == 0) {
                string = "";
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                for (Object object : arrobject) {
                    if (stringBuilder2.length() != 0) {
                        stringBuilder2.append(',');
                    }
                    stringBuilder2.append(JSONObject.quote((String)object.toString()));
                }
                string = stringBuilder2.toString();
            }
            String string4 = string3.replace((CharSequence)"__args__", (CharSequence)string);
            this.b.a(string4, null, null, null);
        }
    }

}

