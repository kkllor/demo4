package com.arithmetic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkllor
 * @date 2021/2/4 3:12 PM
 */
public class NC9 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public class Solution {
        /**
         * @param root TreeNode类
         * @param sum  int整型
         * @return bool布尔型
         */
        public boolean hasPathSum(TreeNode root, int sum) {
            // write code here

            if (root == null) {
                return false;
            }

            if (root.left == null && root.right == null) {
                return root.val == sum;
            } else {
                return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
            }
        }

        public boolean hasPathSumNoRecur(TreeNode root, int sum) {
            // write code here
            if (root == null) {
                return false;
            }
            HashMap<TreeNode, Integer> map = new HashMap<>();
            map.put(root, sum);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    if (map.get(treeNode) == treeNode.val) {
                        return true;
                    }
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    map.put(treeNode, sum - treeNode.val);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    map.put(treeNode, sum - treeNode.val);
                }
            }
            return false;
        }
    }
}
