package com.arithmetic.entity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkllor
 * @date 2022/6/18 9:10 PM
 */
public class TreeNode {
    public int val;
    public  TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode from(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);
        int index = 1;
        while (index < array.length) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (index < array.length && array[index] != null) {
                    TreeNode leftNode = new TreeNode(array[index]);
                    node.left = leftNode;
                    queue.add(leftNode);
                }
                index++;
                if (index < array.length && array[index] != null) {
                    TreeNode rightNode = new TreeNode(array[index]);
                    node.right = rightNode;
                    queue.add(rightNode);
                }
                index++;
            }
        }
        return root;
    }
}
