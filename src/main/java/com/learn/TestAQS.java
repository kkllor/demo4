package com.learn;

import java.util.concurrent.CountDownLatch;

/**
 * @author kkllor
 * @date 2020/12/26 4:13 PM
 */
public class TestAQS {
    private static final int COUNT = 3;

    static class Thread1 extends Thread {
        private CountDownLatch countDownLatch;
        private int index;

        public Thread1(int index, CountDownLatch countDownLatch) {
            this.index = index;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(index * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }

    static class Thread2 extends Thread {
        private CountDownLatch countDownLatch;
        private int index;

        public Thread2(int index, CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            this.index = index;
        }

        @Override
        public void run() {
            super.run();
            try {
                countDownLatch.await();
                System.out.println(this + " index = " + index + " after await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);

        for (int i = 0; i < COUNT; i++) {
            Thread1 thread1 = new Thread1(i, countDownLatch);
            thread1.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread2 thread2 = new Thread2(i, countDownLatch);
            thread2.setName("my Thread2 index = " + i);
            thread2.start();
        }
    }
}
