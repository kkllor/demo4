package com.arithmetic.jzoffer;

import java.util.Stack;

/**
 * @author kkllor
 * @date 2022/6/20 11:18 PM
 */
public class jz09 {
    public static void main(String[] args) {

    }
}

/**
 * 6     1
 * 5     2
 * 4     3
 */

class CQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
}
