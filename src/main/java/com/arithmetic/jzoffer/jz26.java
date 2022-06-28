package com.arithmetic.jzoffer;

import com.arithmetic.entity.TreeNode;

/**
 * @author kkllor
 * @date 2022/6/28 9:19 PM
 */
public class jz26 {
    public static void main(String[] args) {
        try {
            System.out.println(new jz26().isSubStructure(TreeNode.from(new Integer[]{3, 4, 5, 1, 2}), TreeNode.from(new Integer[]{4, 1})));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return same(A, B) || (A != null && (isSubStructure(A.left, B) || isSubStructure(A.right, B)));
    }

    public boolean same(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }

        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }
        return (A.val == B.val) && same(A.left, B.left) && same(A.right, B.right);
    }
}
