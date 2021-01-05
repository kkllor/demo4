package com.arithmetic;

import com.arithmetic.entity.BinaryTree;

/**
 * @author kkllor
 * @date 2021/1/5 8:57 AM
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {
        Integer[] buildArray = new Integer[]{1, 2, 3, 4, 0, 5, 6, 7, 8};
        BinaryTree<Integer> orgin = BinaryTree.createByArray(buildArray);
        mirror(orgin);
        System.out.println(orgin);
    }

    public static void mirror(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        BinaryTree<Integer> temp = root.getLeft();
        BinaryTree<Integer> left = root.getRight();
        BinaryTree<Integer> right = temp;
        root.setLeft(left);
        root.setRight(right);
        mirror(left);
        mirror(right);
    }
}
