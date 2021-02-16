package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2021/2/9 6:16 PM
 */
public class NC16 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


    /**
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetric(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        return isSymmetricLR(root.left, root.right);

    }

    private boolean isSymmetricLR(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        return isSymmetricLR(left.left, right.right) && isSymmetricLR(left.right, right.left);
    }


    public boolean isSymmetric1(TreeNode root) {
        // write code here
        List<List<Integer>> bfsLeft = bfs(root.left, true);
        List<List<Integer>> bfsRight = bfs(root.right, false);
        if (bfsLeft.size() != bfsRight.size()) {
            return false;
        }

        for (int i = 0; i < bfsLeft.size(); i++) {
            if (!compareList(bfsLeft.get(i), bfsRight.get(i))) {
                return false;
            }
        }

        return true;

    }

    private boolean compareList(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            Integer integer1 = list1.get(i);
            Integer integer2 = list2.get(i);
            if (integer1 == null && integer2 == null) {
                continue;
            }
            if (integer1 == null || integer2 == null) {
                return false;
            }

            if (integer1.intValue() != integer2.intValue()) {
                return false;
            }
        }
        return true;
    }

    private List<List<Integer>> bfs(TreeNode root, boolean isLR) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty() && !isAllNull(list)) {
            List<Integer> tmpList = new ArrayList<>();
            List<TreeNode> _list = new ArrayList<>();
            for (TreeNode node : list) {
                tmpList.add(node == null ? null : node.val);
                if (isLR) {
                    _list.add(node == null ? null : node.left);
                    _list.add(node == null ? null : node.right);
                } else {
                    _list.add(node == null ? null : node.right);
                    _list.add(node == null ? null : node.left);
                }
            }
            result.add(tmpList);
            list.clear();
            list.addAll(_list);
        }
        return result;
    }

    private boolean isAllNull(List<TreeNode> list) {
        for (TreeNode node : list) {
            if (node != null) {
                return false;
            }
        }
        return true;

    }
}
