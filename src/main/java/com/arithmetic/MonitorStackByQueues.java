package com.arithmetic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/1/23 3:01 PM
 */
public class MonitorStackByQueues {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    public static class MyStack {
        private Queue<Integer> queue1, queue2, current;

        public MyStack() {
            queue1 = new LinkedList();
            queue2 = new LinkedList();
            current = queue1;
        }

        public void push(int value) {
            current.add(value);
        }

        public int pop() {
            if (current.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            Queue otherQueue = otherQueue();
            while (current.size() > 1) {
                otherQueue.add(current.poll());
            }
            int result = current.poll();
            switchQueue();
            return result;
        }


        private void switchQueue() {
            if (current == queue1) {
                current = queue2;
            } else {
                current = queue1;
            }
        }

        private Queue otherQueue() {
            if (current == queue1) {
                return queue2;
            } else {
                return queue1;
            }
        }

        public boolean isEmpty() {
            return current.isEmpty();
        }
    }
}
