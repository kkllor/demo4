package com.arithmetic;

/**
 * @author kkllor
 * @date 2020/12/6 6:43 PM
 * 通过单链表实现LRU淘汰算法
 */
public class LRU {
    //最大容量
    private static final int MAX_CAPACITY = 15;
    private int capacity = 0;
    private Node<Integer> head;

    public Node<Integer> get(int v) {
        //首先判断是否包含
        Node<Integer> node = head, preNode = null;
        while (node != null) {
            if (node.value == v) {
                if (preNode == null) {
                    return head;
                }
                //否则进行删除
                preNode.next = node.next;
                node.next = null;
                //之后插入到第一个节点
                Node<Integer> oldHead = head;
                head = new Node<>();
                head.value = v;
                head.next = oldHead;
                return head;
            }
            preNode = node;
            node = node.next;
        }

        if (capacity == MAX_CAPACITY) {
            node = head;
            preNode = null;
            while (node.next != null) {
                preNode = node;
                node = node.next;
            }

            if (preNode == null) {
                head = new Node<>();
                head.value = v;
            } else {
                preNode.next = null;
                Node<Integer> oldHead = head;
                head = new Node<>();
                head.value = v;
                head.next = oldHead;
            }
        } else {
            if (capacity == 0) {
                head = new Node<>();
                head.value = v;
            } else {
                Node<Integer> oldHead = head;
                head = new Node<>();
                head.value = v;
                head.next = oldHead;
            }
            capacity++;
        }
        return head;
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        for (int i = 32; i <= 45; i++) {
            lru.get(i);
        }
        lru.get(35);
        lru.get(35);
        lru.get(25);

        System.out.println(lru);
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(value.toString());
            if (next != null) {
                stringBuilder.append("->");
            }
            return stringBuilder.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<Integer> node = head;
        while (node != null) {
            stringBuilder.append(node.toString());
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
