package com.arithmetic;

import com.arithmetic.entity.BinaryTree;

/**
 * @author kkllor
 * @date 2021/1/10 5:53 PM
 */
public class BinaryTreeKRow {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15};
        print(BinaryTree.createByArray(array), 3);
    }

    public static void print(BinaryTree<Integer> tree, int k) {
        if (k == 0) {
            if (tree != null) {
                System.out.println(tree.getValue());
            }
            return;
        }
        print(tree.getLeft(), k - 1);
        print(tree.getRight(), k - 1);
    }
}
