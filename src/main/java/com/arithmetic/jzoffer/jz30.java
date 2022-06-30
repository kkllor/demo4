package com.arithmetic.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2022/6/29 9:20 PM
 */
public class jz30 {
    public static void main(String[] args) {

    }

    class MinStack {
        private List<Node> list = new ArrayList<>();
        private int min = Integer.MAX_VALUE;

        class Node {
            int min;
            int value;

            public Node(int min, int value) {
                this.min = min;
                this.value = value;
            }
        }

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            min = Math.min(x, min);
            list.add(new Node(min, x));
        }

        public void pop() {
            if (list.isEmpty()) {
                return;
            }
             list.remove(list.size() - 1);
            if (list.isEmpty()) {
                min = Integer.MAX_VALUE;
            } else {
                min = list.get(list.size() - 1).min;
            }
        }

        public int top() {
            if (list.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return list.get(list.size() - 1).value;
        }

        public int min() {
            if (list.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return list.get(list.size() - 1).min;
        }
    }




    /*


    2147483647



     */

//    [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483646]
//    [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]

}


/*

["MinStack","push","push","min","min","push","min","min","top","min","pop","push","push","min","push","pop","top","min","pop"]
[[],        [-10],  [14],   [],   [],  [-20], [],   [],    []   ,[],   [],  [10],  [-7],   [],  [-7]   ,[],   [],  [],    []]
输出：
[null,null,null,-10,-10,null,-20,-20,-20,-20,null,null,null,-20,null,null,-7,-20,null]
预期结果：
[null,null,null,-10,-10,null,-20,-20,-20,-20,null,null,null,-10,null,null,-7,-10,null]



14
-10
 */