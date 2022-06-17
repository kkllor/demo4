package com.arithmetic.lc;

import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/3/16 5:03 下午
 */
public class lc7 {

    //123
    //-123

    public static void main(String[] args) {
        System.out.println(new lc7().reverse(153423699));
    }

    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        Stack<Integer> stack = new Stack<>();
        while (x != 0) {
            int n = x % 10;
            x = x / 10;
            stack.add(n);
        }
        long k = 1;
        long result = 0;
        while (!stack.isEmpty()) {
            int n = stack.pop();
            result += n * k;
            k *= 10;
        }
        if (flag) {
            result = -result;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }
        return (int) result;
    }
}
