package com;

/**
 * @author kkllor
 * @date 2021/1/22 9:16 PM
 */

import java.util.*;

public class Main111 {
    static class Node1<T> {
        T value;
        Node1<T> pre, next;

        public Node1(T value) {
            this.value = value;
        }
    }

    static class DoubleLink<T> implements Iterable<T> {
        Node1<T> head;

        public DoubleLink() {
            this.head = new Node1(Integer.MAX_VALUE);
        }

        public void add(Node1<T> node) {
            Node1<T> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
            node.pre = tmp;
        }

        public void remove(Node1<T> node) {
            Node1<T> tmp = head;
            while (tmp != null) {
                if (tmp.value == node.value) {
                    if (tmp.next == null) {
                        tmp.pre.next = null;
                        tmp.pre = null;
                    } else {
                        tmp.pre.next = tmp.next;
                        tmp.next.pre = tmp.pre;
                        tmp.pre = null;
                        tmp.next = null;
                    }
                }
                tmp = tmp.next;
            }
        }

        public void printSelf() {
            Node1<T> tmp = head;
            while (tmp != null) {
                tmp = tmp.next;
                if (tmp != null) {
                    System.out.print(tmp.value + " ");
                }
            }
        }

        public Iterator<T> iterator() {
            return new KeyIterator();
        }

        class KeyIterator implements Iterator<T> {
            Node1<T> node;

            public KeyIterator() {
                this.node = head;
            }

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                node = node.next;
                return node.value;
            }
        }
    }

    public static void main(String[] args) {
        DoubleLink<Integer> doubleLink = new DoubleLink<>();
        doubleLink.add(new Node1(1));
        doubleLink.add(new Node1(2));
        doubleLink.add(new Node1(3));
        doubleLink.remove(new Node1(2));
        doubleLink.remove(new Node1(3));
        doubleLink.remove(new Node1(1));
        doubleLink.printSelf();
        Iterator<Integer> it = doubleLink.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "~");
        }
    }
}