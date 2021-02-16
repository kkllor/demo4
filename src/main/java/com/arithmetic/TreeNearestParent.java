package com.arithmetic;

import com.arithmetic.entity.BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kkllor
 * @date 2021/2/16 9:13 上午
 */
public class TreeNearestParent {
    private HashMap<Integer, Integer> parentMap = new HashMap<>();
    private Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, null, null, 8, 9, 10, 11, null, null, null, null, 16, null, null, null, 20, null, null, 23, null, null, null, null, null, null, null, null};
        BinaryTree<Integer> binaryTree = BinaryTree.createByArray(array);
        System.out.println(new TreeNearestParent().solution(binaryTree, 9, 16));
    }

    public int solution(BinaryTree<Integer> root, Integer p, Integer q) {

        dfs(root);
        while (p != null) {
            set.add(p);
            p = parentMap.get(p);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return -1;
    }

    private void dfs(BinaryTree<Integer> root) {
        if (root.getLeft() != null) {
            parentMap.put(root.getLeft().getValue(), root.getValue());
            dfs(root.getLeft());
        }
        if (root.getRight() != null) {
            parentMap.put(root.getRight().getValue(), root.getValue());
            dfs(root.getRight());
        }
    }
}
