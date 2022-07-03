package com.arithmetic.jzoffer;

import com.arithmetic.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2022/7/2 4:07 PM
 */
public class jz34 {
    public static void main(String[] args) {
        System.out.println(new jz34().pathSum(TreeNode.from(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}), 22));
    }

    /*

            3
       5        4
    2    4    3    5
      */

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        dfs(root, target);
        return result;
    }

    public void dfs(TreeNode root, int target) {
        if (root.right == null && root.left == null) {
            if (target == root.val) {
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        }
        list.add(root.val);
        if (root.left != null) {
            pathSum(root.left, target - root.val);
        }
        if (root.right != null) {
            pathSum(root.right, target - root.val);
        }
        list.remove(list.size() - 1);
    }
}
