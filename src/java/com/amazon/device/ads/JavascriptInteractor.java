/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.JavascriptInterface
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import android.webkit.JavascriptInterface;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class JavascriptInteractor {
    private static final String LOGTAG = "JavascriptInteractor";
    private static String executorMethodName;
    private static final MobileAdsLogger logger;
    private final Executor executor = new Executor(this);
    private final Map<String, JavascriptMethodExecutor> methodMap = new ConcurrentHashMap();

    static {
        logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    }

    private JSONObject execute(String string, String string2) {
        JSONObject jSONObject = null;
        if (string2 != null) {
            int n = string2.length();
            jSONObject = null;
            if (n > 2) {
                JSONObject jSONObject2 = JSONUtils.getJSONObjectFromString(string2);
                if (jSONObject2 == null) {
                    logger.w("The javascript object \"%s\" could not be parsed for method \"%s\".", new Object[]{string2, string});
                    return null;
                }
                jSONObject = jSONObject2;
            }
        }
        return this.execute(string, jSONObject);
    }

    private JSONObject execute(String string, JSONObject jSONObject) {
        if (this.methodMap.containsKey((Object)string)) {
            return ((JavascriptMethodExecutor)this.methodMap.get((Object)string)).execute(jSONObject);
        }
        logger.w("The method %s was not recongized by this javascript interface.", new Object[]{string});
        return null;
    }

    public static String getExecutorMethodName() {
        if (executorMethodName == null) {
            Method[] arrmethod = Executor.class.getDeclaredMethods();
            if (arrmethod != null && arrmethod.length == 1) {
                executorMethodName = arrmethod[0].getName();
            } else {
                logger.e("Could not obtain the method name for javascript interfacing.");
            }
        }
        return executorMethodName;
    }

    public void addMethodExecutor(JavascriptMethodExecutor javascriptMethodExecutor) {
        if (!this.methodMap.containsKey((Object)javascriptMethodExecutor.getMethodName())) {
            this.methodMap.put((Object)javascriptMethodExecutor.getMethodName(), (Object)javascriptMethodExecutor);
            return;
        }
        throw new IllegalArgumentException("There is another executor with that method name already added.");
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public static class Executor {
        private final JavascriptInteractor interactor;
        private boolean proguardKeeper = false;

        public Executor(JavascriptInteractor javascriptInteractor) {
            this.interactor = javascriptInteractor;
            if (this.proguardKeeper) {
                this.execute(null, null);
            }
        }

        @JavascriptInterface
        public String execute(String string, String string2) {
            JSONObject jSONObject = this.interactor.execute(string, string2);
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.toString();
        }
    }

    public static abstract class JavascriptMethodExecutor {
        private final String methodName;

        protected JavascriptMethodExecutor(String string) {
            this.methodName = string;
        }

        protected abstract JSONObject execute(JSONObject var1);

        public String getMethodName() {
            return this.methodName;
        }
    }

}

