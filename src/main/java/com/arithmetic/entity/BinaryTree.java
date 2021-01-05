package com.arithmetic.entity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kkllor
 * @date 2021/1/4 4:10 PM
 */
public class BinaryTree<T> {
    private T value;
    private BinaryTree<T> left, right;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    public BinaryTree(T value) {
        this.value = value;
    }

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static <T> BinaryTree<T> createByArray(T[] array) {
        Queue<BinaryTree> queue = new LinkedList<>();
        int index = 0;
        BinaryTree<T> root = new BinaryTree<>(array[index]);
        queue.add(root);
        index++;
        while (index < array.length) {
            BinaryTree<T> node = queue.poll();
            T v;
            if ((v = array[index]) != null) {
                BinaryTree<T> left = new BinaryTree<>(v);
                node.setLeft(left);
                queue.add(left);
            }
            index++;

            if (index < array.length && (v = array[index]) != null) {
                BinaryTree<T> right = new BinaryTree<>(v);
                node.setRight(right);
                queue.add(right);
            }
            index++;
        }
        return root;
    }
}
