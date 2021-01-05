package com.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kkllor
 * @date 2021/1/5 4:19 PM
 */
public class TestConsumerProducer2 {
    private static final int PLATE_SIZE = 5;
    private final List<Integer> platesList = new ArrayList<>(PLATE_SIZE);

    private ReentrantLock lock = new ReentrantLock();
    private Condition canProduce = lock.newCondition();
    private Condition canConsume = lock.newCondition();

    public static void main(String[] args) {
        new TestConsumerProducer2().start();
    }

    private void start() {
        Thread c1 = new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
            }
        });
        Thread c2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
            }
        });
        Thread c3 = new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
            }
        });
        Thread p1 = new Thread(new Runnable() {
            @Override
            public void run() {
                produce();
            }
        });
        c1.start();
        c2.start();
        c3.start();
        p1.start();
    }

    private void produce() {
        lock.lock();
        try {
            while (true) {
                try {
                    if (platesList.size() == PLATE_SIZE) {
                        canConsume.signalAll();
                        canProduce.await();
                    } else {
                        Thread.sleep(100);
                        platesList.add(1);
                        System.out.println("produce one size = " + platesList.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    private void consume() {
        lock.lock();
        try {
            while (true) {
                try {
                    if (platesList.isEmpty()) {
                        canProduce.signalAll();
                        canConsume.await();
                    } else {
                        Thread.sleep(10);
                        platesList.remove(0);
                        System.out.println("consume one size = " + platesList.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
