package com.learn;

import java.util.Random;

/**
 * @author kkllor
 * @date 2021/3/8 4:07 下午
 */
public class TestRandom {
    public static void main(String[] args) {
        Random random1 = new Random(10);
        Random random2 = new Random(10);
        int count = 0;
        while (count < 20) {
            System.out.println("random1 generate " + random1.nextInt());
            System.out.println("random2 generate " + random2.nextInt());
            count++;
        }
    }
}
