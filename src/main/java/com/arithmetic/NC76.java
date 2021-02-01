package com.arithmetic;

import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/1/29 1:14 PM
 */
public class NC76 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        transForm();
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        return Integer.MAX_VALUE;
    }

    private void transForm() {
        if (!stack2.isEmpty()) {
            throw new IllegalStateException("stack2 is not empty ,cannot perform transForm");
        }
        if (stack1.isEmpty()) {
            return;
        }
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }

    }

    public static void main(String[] args) {
        NC76 nc76 = new NC76();
        nc76.push(1);
        nc76.push(2);
        System.out.println(nc76.pop());
        nc76.push(3);
        nc76.push(4);
        nc76.push(5);
        System.out.println(nc76.pop());

        System.out.println(nc76.pop());
        System.out.println(nc76.pop());
        System.out.println(nc76.pop());

    }
}
