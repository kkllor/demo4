package com.arithmetic;

import com.arithmetic.entity.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkllor
 * @date 2021/1/22 1:45 PM
 */
public class NC60 {
    public static void main(String[] args) {
        Integer array[] = new Integer[]{47, 30, 21, 14, 11, 45, 4, 26, 3, 40, 35, 34, 2, 23, 24, 16, 37, 8, 39, 13, 15, 31, 25, 22, 46, 10, 28, 12, 9, 32, 43, 36, 7, 1, 27, 48, 33, 19, 44, 29, 6, 42, 5, 41, 38, 17, 18, 20, 49};
        System.out.println(Arrays.toString(new NC60().judgeIt(createByArray(array))));
    }

    //    给定一棵二叉树，已经其中没有重复值的节点，请判断该二叉树是否为搜索二叉树和完全二叉树。
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt(TreeNode root) {
        // write code here
        boolean[] result = new boolean[2];
        result[0] = isSearchTree(root);
        result[1] = isFullTree(root);
        return result;
    }

    private boolean isSearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val > root.val) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val < root.val) {
                return false;
            }
        }
        return isSearchTree(root.left) && isSearchTree(root.right);
    }

    private boolean isFullTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right != null) {
            return false;
        }

        if (root.left != null && root.right == null) {
            return false;
        }

        return isFullTree(root.left) && isFullTree(root.right);
    }

    public static TreeNode createByArray(Integer[] array) {
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(array[index]);
        queue.add(root);
        index++;
        while (index < array.length) {
            TreeNode node = queue.poll();
            Integer v;
            if ((v = array[index]) != null) {
                TreeNode left = new TreeNode(v);
                node.left = left;
                queue.add(left);
            }
            index++;

            if (index < array.length && (v = array[index]) != null) {
                TreeNode right = new TreeNode(v);
                node.right = right;
                queue.add(right);
            }
            index++;
        }
        return root;
    }

}
