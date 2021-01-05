package com.learn;

/**
 * @author kkllor
 * @date 2021/1/5 3:53 PM
 */
public class TestDeadLock {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public static void main(String[] args) {
        new TestDeadLock().mustDeadLock();
    }

    public void mustDeadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                f1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                f2();
            }
        });

        t1.start();
        t2.start();
    }

    public void f1() {
        synchronized (lock1) {
            try {
                Thread.sleep(20);
                f2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void f2() {
        synchronized (lock2) {
            try {
                Thread.sleep(20);
                f1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
