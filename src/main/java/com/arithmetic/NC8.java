package com.arithmetic;

import com.arithmetic.entity.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/2/5 5:16 PM
 */
public class NC8 {

//    给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
//    例如：
//    给出如下的二叉树，\ sum=22 sum=22，
//
//    [
//            [5,4,11,2],
//            [5,8,9]
//            ]


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
//

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return int
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> record = new ArrayList<>();
        pathSum(root, result, record, sum);
        return result;
    }


    public void pathSum(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> record, int sum) {
        // write code here
        ArrayList<Integer> recordCopy = new ArrayList<>(record);
        recordCopy.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(recordCopy);
                return;
            }
        }
        if (root.left != null) {
            pathSum(root.left, result, recordCopy, sum - root.val);
        }
        if (root.right != null) {
            pathSum(root.right, result, recordCopy, sum - root.val);
        }
    }


    public List<Integer> preOrder(BinaryTree<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree<Integer>> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTree<Integer> node = stack.pop();
            result.add(node.getValue());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }

        }
        return result;
    }

    public List<Integer> preOrder1(BinaryTree<Integer> node) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree<Integer>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                result.add(node.getValue());
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.getRight();
            }
        }
        return result;
    }


    public List<Integer> inOrder(BinaryTree<Integer> node) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree<Integer>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.getValue());
                node = node.getRight();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{1/*, 2, 6, 4, 5, null, null, null, null, null, 6*/};
        BinaryTree<Integer> tree = BinaryTree.createByArray(array);
//        List<Integer> result = new NC8().preOrder(tree);
//        List<Integer> result = new NC8().inOrder(tree);
//        for (int i = 0; i < result.size(); i++) {
//            System.out.print(result.get(i) + " ");
//        }

//        ArrayList<ArrayList<Integer>> result = new NC8().pathSum(tree, 7);
//        System.out.println(Arrays.toString(result.toArray()));
    }
}
