package ru.otus.gc.hw08;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.MBeanServer;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OomExample {
    public static void main(String[] args) throws Exception {
        final String mxBeanName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("Starting pid: " + mxBeanName);
        switchOnMonitoring();
        long beginTime = System.currentTimeMillis();

        int size = 1 * 1_000;
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ru.otus:type=Benchmark");

        CustomBenchmark mbean = new CustomBenchmark();
        mbs.registerMBean(mbean, name);
        mbean.setSize(size);
        mbean.run();

        System.out.println("time:" + (System.currentTimeMillis() - beginTime) / 1000);
    }

    private static void switchOnMonitoring() {

        List<GarbageCollectorMXBean> gcbeans = ManagementFactory.getGarbageCollectorMXBeans();

        for (GarbageCollectorMXBean gcbean : gcbeans) {

            System.out.println("GC name:" + gcbean.getName());
            AtomicInteger gcCount = new AtomicInteger();

            NotificationEmitter emitter = (NotificationEmitter) gcbean;
            NotificationListener listener = (notification, handback) -> {
                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                    GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());

                    String gcName = info.getGcName();
                    String gcAction = info.getGcAction();

                    long duration = info.getGcInfo().getDuration();

                    if (gcAction != null){
                        gcCount.getAndIncrement();
                    }

                    System.out.println("Name:" + gcName + ", action:" + gcAction + ", Количество сборок: "+ gcCount + ", длительность: " + duration + " ms)");
                }
            };
            emitter.addNotificationListener(listener, null, null);



        }
    }

}
