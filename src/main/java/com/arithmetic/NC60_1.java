package com.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkllor
 * @date 2021/1/22 1:45 PM
 */
public class NC60_1 {
    public static void main(String[] args) {
        Integer array[] = new Integer[]{2, 1, 3};
        System.out.println(Arrays.toString(new NC60_1().judgeIt(createByArray(array))));
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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.val > node.val) {
                    return false;
                }
                queue.add(node.left);
            }
            if (node.right != null) {
                if (node.right.val < node.val) {
                    return false;
                }
                queue.add(node.right);
            }
        }
        return true;
    }

    private boolean isFullTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (System.currentTimeMillis() > 1) {
            throw new RuntimeException("12");
        }
        list.add(root);
        boolean flag = false;
        while (!list.isEmpty()) {
            ArrayList<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : list) {
                if (node.left != null) {
                    if (flag) {
                        return false;
                    }
                    tmp.add(node.left);
                } else {
                    flag = true;
                }

                if (node.right != null) {
                    if (flag) {
                        return false;
                    }
                    tmp.add(node.right);
                } else {
                    flag = true;
                }
            }

            if (flag) {
                return isChildAllNull(tmp);
            }
            list.clear();
            list.addAll(tmp);
        }

        return false;
    }

    private boolean isChildAllNull(ArrayList<TreeNode> list) {
        for (TreeNode node : list) {
            if (node.left != null || node.right != null) {
                return false;
            }
        }
        return true;
    }


    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeHeight(root.left) + 1, treeHeight(root.right) + 1);
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
