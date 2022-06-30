package com.arithmetic.jzoffer;

import com.arithmetic.entity.TreeNode;

/**
 * @author kkllor
 * @date 2022/6/29 7:34 PM
 */
public class jz27 {
    public static void main(String[] args) {
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
