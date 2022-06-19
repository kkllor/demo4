package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/6/19 2:13 PM
 */
//https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
public class jz10 {
    public static void main(String[] args) {
        System.out.println(frogJump(20));
//        for (int i = 0; i < 100; i++) {
//            System.out.println(fib(i));
//        }

    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int nMinusMinus = 0;
        int nMinus = 1;
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result = (nMinus + nMinusMinus) % 1000000007;
            nMinusMinus = nMinus;
            nMinus = result;
        }

        return result;
    }

    //青蛙跳台阶
    //f(n) = f(n-1)+1 or f(n) = f(n-2)+2

    public static int frogJump(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return frogJump(n - 1)+ frogJump(n - 2);
    }

    // 0 1
    // 1 1
    // 2 2
    // 3 3
    // 4 1+1+1+1 2+1+1 2+2 1+1+2
}
