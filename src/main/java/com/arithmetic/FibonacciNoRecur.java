package com.arithmetic;

import java.util.Arrays;

/**
 * @author kkllor
 * @date 2021/1/4 5:49 PM
 */
public class FibonacciNoRecur {
    public static void main(String[] args) {
        System.out.println(fib(8));
        System.out.println(fibRecur(8-1));
    }

    private static int fib(int index) {
        if (index <= 2) {
            return 1;
        }
        int[] record = new int[index];
        record[0] = 1;
        record[1] = 1;
        for (int i = 2; i < index; i++) {
            record[i] = record[i - 1] + record[i - 2];
        }
        System.out.println(Arrays.toString(record));
        return record[index - 1];
    }

    private static int fibRecur(int index) {
        if (index <= 1) {
            return 1;
        }
        return fibRecur(index - 2) + fibRecur(index - 1);
    }

}
