package com.arithmetic.jzoffer;

import java.util.Stack;

/**
 * @author kkllor
 * @date 2022/7/2 10:12 AM
 */
public class jz31 {

    /*


    6
    5
    4
    3
    2
    1

    4,5,3,2,1
    3,5,4,2,1
    3,4,5,2,1

//    3,4,6,5,1,2

1,2,3,4,5


2,5,3,4,1

     */


    public static void main(String[] args) {
        System.out.println(new jz31().validateStackSequences(new int[]{0, 1}, new int[]{0, 1}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        if (pushed.length == 0 || popped.length == 0) {
            return false;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        int a = popped[j];
        for (int k : pushed) {
            stack.push(k);
            int top = stack.peek();
            while (top == a) {
                stack.pop();
                j++;
                if (j < popped.length) {
                    a = popped[j];
                    if (!stack.isEmpty()) {
                        top = stack.peek();
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return j == popped.length;
    }
}
