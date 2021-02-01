package com.learn;

import java.util.HashMap;

/**
 * @author kkllor
 * @date 2021/1/26 5:03 PM
 */
public class DoubleLink<T> {
    private Node<T> head = new Node<>(null);
    private Node<T> tail = head;
//    private HashMap<T, Node<T>> map = new HashMap<>();

    public void add(T t) {
        Node<T> node = new Node<>(t);
        tail.next = node;
        node.pre = tail;
    }

    public int delete(T t) {

        return -1;
    }

    static class Node<T> {
        T value;
        Node<T> pre, next;

        public Node(T value) {
            this.value = value;
        }
    }
}
