package com.learn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kkllor
 * @date 2020/12/26 5:19 PM
 */
public class TestAQS2 {
    ReentrantLock reentrantLock = new ReentrantLock();

    public void syncFun() {
        reentrantLock.lock();

        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
        TestAQS2 testAQS2 = new TestAQS2();
        new MyThread(-1, testAQS2).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            new MyThread(i, testAQS2).start();
        }

    }

    static class MyThread extends Thread {
        private int index;
        private TestAQS2 testAQS2;

        public MyThread(int index, TestAQS2 testAQS2) {
            super("my thread index = " + index);
            this.index = index;
            this.testAQS2 = testAQS2;
        }

        @Override
        public void run() {
            super.run();
            testAQS2.syncFun();
        }
    }
}
