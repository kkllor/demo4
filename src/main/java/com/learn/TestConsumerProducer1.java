package com.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2021/1/5 4:19 PM
 */
public class TestConsumerProducer1 {
    private static final int PLATE_SIZE = 5;
    private static final List<Integer> platesList = new ArrayList<>(PLATE_SIZE);

    public static void main(String[] args) {
        new TestConsumerProducer1().start();
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
        synchronized (platesList) {
            while (true) {
                try {
                    if (platesList.size() == PLATE_SIZE) {
                        platesList.notifyAll();
                        platesList.wait();
                    } else {
                        Thread.sleep(100);
                        platesList.add(1);
                        System.out.println("produce one size = " + platesList.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void consume() {
        synchronized (platesList) {
            while (true) {
                try {
                    if (platesList.isEmpty()) {
                        platesList.notifyAll();
                        platesList.wait();
                    } else {
                        Thread.sleep(10);
                        platesList.remove(0);
                        System.out.println("consume one size = " + platesList.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
