package com.arithmetic;

import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/1/23 3:16 PM
 */
public class MonitorQueueByStack {

    public static class MyQueue {

        public static void main(String[] args) {
            MyQueue myQueue = new MyQueue();
            myQueue.add(1);
            myQueue.add(2);
            myQueue.add(3);
            myQueue.poll();
            myQueue.add(4);
            myQueue.add(5);
            myQueue.poll();
            myQueue.poll();
            myQueue.add(6);
            while (!myQueue.isEmpty()) {
                System.out.println(myQueue.poll());
            }
        }

        private Stack<Integer> in, out;

        public MyQueue() {
            in = new Stack();
            out = new Stack();
        }


        public void add(int value) {
            in.push(value);
        }

        public int poll() {
            if (isEmpty()) {
                throw new RuntimeException("queue is empty!");
            }

            if (out.isEmpty()) {
                transform();
            }
            return out.pop();
        }

        public boolean isEmpty() {
            return in.isEmpty() && out.isEmpty();
        }


        private void transform() {
            if (in.isEmpty()) {
                return;
            }
            if (!out.isEmpty()) {
                throw new RuntimeException("out is not empty! can't perform transform");
            }
            while (!in.isEmpty()) {
                out.push(in.pop());
            }

        }


    }
}
