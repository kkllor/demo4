package com.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/1/21 5:05 PM
 */
public class NC14 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 0;

        TreeNode left = new TreeNode();
        left.val = 1;

        TreeNode right = new TreeNode();
        right.val = 2;

        root.left = left;
        root.right = right;


        left = new TreeNode();
        left.val = 3;

        right = new TreeNode();
        right.val = 4;

        root.left.left = left;
        root.left.right = right;

        left = new TreeNode();
        left.val = 5;

        root.right.left = left;

        System.out.println(new NC14().zigzagLevelOrder(root));



    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> lrqueue = new LinkedList<>();
        Queue<TreeNode> rlqueue = new LinkedList<>();
        lrqueue.add(root);
        boolean isOdd = true;
        Stack<Integer> stack = new Stack<>();
        while (!(lrqueue.isEmpty() && rlqueue.isEmpty())) {
            if (isOdd) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!lrqueue.isEmpty()) {
                    TreeNode treeNode = lrqueue.poll();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        rlqueue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        rlqueue.add(treeNode.right);
                    }
                }
                result.add(list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!rlqueue.isEmpty()) {
                    TreeNode treeNode = rlqueue.poll();
                    stack.add(treeNode.val);
                    if (treeNode.left != null) {
                        lrqueue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        lrqueue.add(treeNode.right);
                    }
                }
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
                result.add(list);
            }
            isOdd = !isOdd;
        }
        return result;
    }
}
