package com.learn;

/**
 * @author kkllor
 * @date 2021/1/5 4:03 PM
 */
public class TestThreadPrint {
    private static int count = 0;
    private Object lock = new Object();

    public static void main(String[] args) {
        new TestThreadPrint().print();
    }

    private void print() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (count < 100) {
                        System.out.println(1);
                        count++;
                        try {
                            if (count < 100) {
                                lock.notify();
                                lock.wait();
                            } else {
                                lock.notify();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (count < 100) {
                        System.out.println(2);
                        count++;
                        try {
                            if (count < 100) {
                                lock.notify();
                                lock.wait();
                            } else {
                                lock.notify();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
