package com.arithmetic;

import com.arithmetic.entity.BinaryTree;

/**
 * @author kkllor
 * @date 2021/1/5 2:44 PM
 * 判断是否包含子树
 */
public class ContainsSubTree {
    public static void main(String[] args) {

        Integer[] buildArray = new Integer[]{1, 2, 3, 4, null, 5, 6, 7, 8};
        /**
         *              1
         *          2       3
         *       4   nil 5    6
         *     7   8
         *
         *
         *
         */
        BinaryTree<Integer> b1 = BinaryTree.createByArray(buildArray);
        buildArray = new Integer[]{2, 4, null};
        BinaryTree<Integer> b2 = BinaryTree.createByArray(buildArray);
        System.out.println(solution(b1, b2));
    }

    public static boolean solution(BinaryTree<Integer> b1, BinaryTree<Integer> b2) {
        return contains(b1, b2) || solution(b1.getLeft(), b2) || solution(b1.getRight(), b2);
    }

    /**
     * @param b1
     * @param b2
     * @return b2 是否包含在b1中
     */
    public static boolean contains(BinaryTree<Integer> b1, BinaryTree<Integer> b2) {
        if (b2 == null) {
            return true;
        }
        if (b1 == null) {
            return false;
        }
        if (!b1.getValue().equals(b2.getValue())) {
            return false;
        }

        return contains(b1.getLeft(), b2.getLeft()) && contains(b1.getRight(), b2.getRight());
    }
}
