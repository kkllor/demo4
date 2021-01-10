package com.arithmetic;

import com.arithmetic.entity.BinaryTree;

import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/1/10 5:30 PM
 */
public class SnakeBinaryTree {

    public static void main(String[] args) {
        Integer[] buildArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15};
        BinaryTree<Integer> root = BinaryTree.createByArray(buildArray);
        snakeTraversal(root);
    }

    
    public static void snakeTraversal(BinaryTree<Integer> tree) {
        if (tree == null) {
            return;
        }
        Stack<BinaryTree> oddStack = new Stack<>();
        Stack<BinaryTree> evenStack = new Stack<>();
        oddStack.push(tree);
        boolean isOdd = true;

        while (!(oddStack.isEmpty() && evenStack.isEmpty())) {
            if (isOdd) {
                while (!oddStack.isEmpty()) {
                    BinaryTree<Integer> root = oddStack.pop();
                    if (root != null) {
                        System.out.println(root.getValue());
                        evenStack.push(root.getLeft());
                        evenStack.push(root.getRight());
                    }
                }
            } else {
                while (!evenStack.isEmpty()) {
                    BinaryTree<Integer> root = evenStack.pop();
                    if (root != null) {
                        System.out.println(root.getValue());
                        oddStack.push(root.getRight());
                        oddStack.push(root.getLeft());
                    }
                }
            }
            isOdd = !isOdd;
        }

    }
}
