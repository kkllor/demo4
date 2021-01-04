package com.arithmetic.binarytree;

import com.arithmetic.entity.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkllor
 * @date 2021/1/4 4:17 PM
 */
public class LevelTraversal {
    public static void main(String[] args) {

        //12345678

        /**
         *          1
         *
         *
         */
        int[] buildArray = new int[]{1, 2, 3, 4, 0, 5, 6, 7, 8};
        BinaryTree<Integer> root = build(buildArray);
        levelTraversals(root);
    }

    private static BinaryTree<Integer> build(int[] nodes) {
        Queue<BinaryTree> queue = new LinkedList<>();
        int index = 0;
        BinaryTree<Integer> root = new BinaryTree<>(nodes[index++]);
        queue.add(root);
        while (index < nodes.length) {
            BinaryTree<Integer> node = queue.poll();
            int v;
            if ((v = nodes[index++]) != 0) {
                BinaryTree<Integer> left = new BinaryTree<>(v);
                node.setLeft(left);
                queue.add(left);
            }

            if ((v = nodes[index++]) != 0) {
                BinaryTree<Integer> right = new BinaryTree<>(v);
                node.setRight(right);
                queue.add(right);
            }
        }
        return root;
    }


    private static void levelTraversals(BinaryTree<Integer> root) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree<Integer> node = queue.poll();
            System.out.print(node.getValue());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }
}

