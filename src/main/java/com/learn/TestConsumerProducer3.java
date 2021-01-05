package com.learn;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author kkllor
 * @date 2021/1/5 4:19 PM
 */
public class TestConsumerProducer3 {
    private static final int PLATE_SIZE = 5;
    private static final BlockingDeque<Integer> plate = new LinkedBlockingDeque<>(PLATE_SIZE);

    public static void main(String[] args) {
        new TestConsumerProducer3().start();
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
        while (true) {
            try {
                plate.put(1);
                System.out.println("produce one size = " + plate.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() {
        while (true) {
            try {
                plate.take();
                System.out.println("consume one size = " + plate.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
