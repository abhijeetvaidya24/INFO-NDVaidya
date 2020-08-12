/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 */
package com.aerserv.sdk.notification;

import com.aerserv.sdk.notification.NotificationListener;
import com.aerserv.sdk.notification.NotificationType;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NotificationCenter {
    private static Map<NotificationType, Set<NotificationListener>> listenerMap = new HashMap();
    private static final Object lock = new Object();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void addListener(NotificationType notificationType, NotificationListener notificationListener) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            if (listenerMap.get((Object)notificationType) == null) {
                listenerMap.put((Object)notificationType, (Object)new HashSet());
            }
            ((Set)listenerMap.get((Object)notificationType)).add((Object)notificationListener);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void fireEvent(NotificationType notificationType, Object object) {
        Object object2;
        HashSet hashSet = new HashSet();
        Object object3 = object2 = lock;
        // MONITORENTER : object3
        if (listenerMap.get((Object)notificationType) != null) {
            hashSet.addAll((Collection)listenerMap.get((Object)notificationType));
        }
        // MONITOREXIT : object3
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            new Thread(new Runnable((NotificationListener)iterator.next(), notificationType, object){
                final /* synthetic */ NotificationListener val$listener;
                final /* synthetic */ Object val$obj;
                final /* synthetic */ NotificationType val$type;
                {
                    this.val$listener = notificationListener;
                    this.val$type = notificationType;
                    this.val$obj = object;
                }

                public void run() {
                    this.val$listener.onEvent(this.val$type, this.val$obj);
                }
            }).start();
        }
        return;
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : object3
                throw throwable;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeListener(NotificationType notificationType, NotificationListener notificationListener) {
        Object object;
        Object object2 = object = lock;
        synchronized (object2) {
            if (listenerMap.get((Object)notificationType) == null) {
                return;
            }
            ((Set)listenerMap.get((Object)notificationType)).remove((Object)notificationListener);
            return;
        }
    }

}

