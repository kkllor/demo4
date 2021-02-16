package com.arithmetic;

import com.arithmetic.entity.BinaryTree;

/**
 * @author kkllor
 * @date 2021/2/16 9:13 上午
 */
public class TreeDiameter1 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, null, null, 8, 9, 10, 11, null, null, null, null, 16, null, null, null, 20, null, null, 23, null, null, null, null, null, null, null, null};
        BinaryTree<Integer> binaryTree = BinaryTree.createByArray(array);
        System.out.println(new TreeDiameter1().solution(binaryTree));
    }

    public int solution(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 0;
        }
        int leftCount = solution(root.getLeft());
        int rightCount = solution(root.getRight());
        //跨root节点：
        int leftDepth = treeDepth(root.getLeft());
        int rightDepth = treeDepth(root.getRight());
        int crossRoot = leftDepth + rightDepth + 2;
        return max(leftCount, rightCount, crossRoot);
    }

    private int treeDepth(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 0;
        }
        return Math.max(treeDepth(root.getLeft()), treeDepth(root.getRight())) + 1;
    }

    private int max(int... values) {
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
}
