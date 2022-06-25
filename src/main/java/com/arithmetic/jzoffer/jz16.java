package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/6/22 11:36 PM
 */
//https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solutio/
public class jz16 {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }

    public static double myPow(double x, int n) {
        long ln = n;
        boolean isNegative = ln < 0;
        if (isNegative) {
            ln = -ln;
        }
        double result = myPowPositive(x, ln);
        if (isNegative) {
            result = 1 / result;
        }
        return result;
    }

    public static double myPowPositive(double x, long n) {
        if (equals(x, 0)) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double result = myPowPositive(x, n >> 1);
        result *= result;
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }

    public static boolean equals(double num1, double num2) {
        return Math.abs(num1 - num2) < 0.0000001;
    }
}

