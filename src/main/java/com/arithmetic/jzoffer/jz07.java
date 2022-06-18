package com.arithmetic.jzoffer;

import com.arithmetic.entity.TreeNode;

import java.util.Arrays;
import java.util.List;

import static com.arithmetic.jzoffer.jz32.levelOrder1;

/**
 * @author kkllor
 * @date 2022/6/18 10:22 PM
 */
public class jz07 {
    public static void main(String[] args) {
        try {
            TreeNode treeNode = buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
            List<List<Integer>> list = levelOrder1(treeNode);
            System.out.println(Arrays.toString(list.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//    Output: [3,9,20,null,null,15,7]


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int preStartIndex, int preEndIndex, int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex || inStartIndex > inEndIndex) {
            return null;
        }
        if (preStartIndex == preEndIndex) {
            return new TreeNode(preorder[preEndIndex]);
        }

        TreeNode root = new TreeNode(preorder[preStartIndex]);
        int rootIndex = indexOf(inorder, preorder[preStartIndex]);

        TreeNode left = buildTree(preorder, inorder
                , preStartIndex + 1
                , preStartIndex + rootIndex - inStartIndex
                , inStartIndex
                , rootIndex - 1);

        TreeNode right = buildTree(preorder, inorder
                , preStartIndex + rootIndex - inStartIndex + 1
                , preEndIndex
                , rootIndex + 1
                , inEndIndex);
        root.left = left;
        root.right = right;
        return root;
    }

    public static int indexOf(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
