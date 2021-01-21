package com.learn;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2021/1/19 3:12 PM
 */
public class TestWeakReference {
    private List<String> obj2 = new ArrayList<>();
    private List<String> obj = new ArrayList();
    private ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    private WeakReference<Object> weakReference = new WeakReference<Object>(obj, referenceQueue);

    public static void main(String[] args) {
        TestWeakReference testWeakReference = new TestWeakReference();
        for (int i = 0; i < 10000; i++) {
            testWeakReference.obj.add(i + "");
        }

        Object o = testWeakReference.weakReference.get();
        System.out.println("before: " + (o == null));
        System.out.println("before reference queue: " + (testWeakReference.referenceQueue.poll() == null));
        testWeakReference.obj = null;
        o = null;
        testWeakReference.allocLargeData();
        System.out.println("before reference queue: 1" + (testWeakReference.referenceQueue.poll() == null));
//        System.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        o = testWeakReference.weakReference.get();
        System.out.println("after: " + (o == null));
        System.out.println("after reference queue: " + (testWeakReference.referenceQueue.poll() == null));
    }


    private void allocLargeData() {
        for (int i = 0; i < 10_000_000; i++) {
            obj2.add(i + "");
        }
    }
}
