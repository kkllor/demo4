package com.arithmetic.jzoffer;

import com.arithmetic.entity.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kkllor
 * @date 2022/6/18 9:10 PM
 */
//https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
public class jz32 {
    public static void main(String[] args) {
        try {
            TreeNode root = TreeNode.from(new Integer[]{1, 2, 3, 4, null, null, 5});
            List<List<Integer>> list = levelOrder1(root);
            System.out.println(Arrays.toString(list.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeftToRight = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.poll());
            }
            if (!nodeList.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < nodeList.size(); i++) {
                    list.add(nodeList.get(i).val);
                    if (nodeList.get(i).left != null) {
                        queue.add(nodeList.get(i).left);
                    }
                    if (nodeList.get(i).right != null) {
                        queue.add(nodeList.get(i).right);
                    }
                }
                if (isLeftToRight) {
                    result.add(list);
                } else {
                    Collections.reverse(list);
                    result.add(list);
                }
                isLeftToRight = !isLeftToRight;
            }
        }
        return result;
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean isLeftToRight = true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            while (!stack.isEmpty()) {
                nodeList.add(stack.pop());
            }

            if (!nodeList.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < nodeList.size(); i++) {
                    list.add(nodeList.get(i).val);
                    if (isLeftToRight) {
                        if (nodeList.get(i).left != null) {
                            stack.push(nodeList.get(i).left);
                        }
                        if (nodeList.get(i).right != null) {
                            stack.push(nodeList.get(i).right);
                        }
                    } else {
                        if (nodeList.get(i).right != null) {
                            stack.push(nodeList.get(i).right);
                        }
                        if (nodeList.get(i).left != null) {
                            stack.push(nodeList.get(i).left);
                        }
                    }
                }
                isLeftToRight = !isLeftToRight;
                result.add(list);
            }
        }
        return result;
    }
}
