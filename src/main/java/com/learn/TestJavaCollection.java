package com.learn;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kkllor
 * @date 2021/1/13 3:22 PM
 */
public class TestJavaCollection {
    static final int HASH_BITS = 0x7fffffff;

    public static void main(String[] args) throws InterruptedException {
//        ConcurrentHashMap<EqualsKey, String> concurrentHashMap = new ConcurrentHashMap<>();
//
//        for (int i = 0; i < 16; i++) {
//            concurrentHashMap.put(new EqualsKey(i + ""), i + "");
//        }
//
//        int a = 0xffffff31;
//        System.out.println(Integer.toHexString((0x31) ^ (0xff)));
//        System.out.println(Integer.toHexString(spread(a)));
//       new Thread(()->{
//           testWait();
//       }).start();
//
//        new Thread(() -> {
//            lockClass();
//        }).start();


        Map<String, String> map = new LinkedHashMap<String, String>(0,0.75f,true);
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.put("3","5");

        map.get("1");
        map.put("6","6");

        System.out.println(map);
        System.out.println(map.keySet());
    }

    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

    static class EqualsKey {

        private String name;

        public EqualsKey(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EqualsKey equalsKey = (EqualsKey) o;
            return Objects.equals(name, equalsKey.name);
        }

        @Override
        public int hashCode() {
            return 3;
        }
    }

    static synchronized void testWait() {
        try {
            System.out.println("testWait in");
            Thread.sleep(10);
            TestJavaCollection.class.wait(4000);
            System.out.println("testWait out");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static synchronized void lockClass() {

        try {
            System.out.println("lockClass in");
            Thread.sleep(3000);
            System.out.println("lockClass out");
//            TestJavaCollection.class.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
