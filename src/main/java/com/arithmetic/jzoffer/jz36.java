package com.arithmetic.jzoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kkllor
 * @date 2022/7/3 10:42 AM
 */
public class jz36 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    public Node treeToDoublyList(Node root) {
        dfs(root);
        if (list.isEmpty()) {
            return null;
        }

        Node head = list.get(0), tail = list.get(list.size() - 1);
        for (int i = 0; i < list.size() - 1; i++) {
            Node node = list.get(i);
            Node next = list.get(i + 1);
            node.right = next;
            next.left = node;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }

    private List<Node> list = new ArrayList<>();

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(4);

        Node node1 = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        root.left = node1;
        root.right = node5;
        node1.left = node2;
        node1.right = node3;
        jz36 o = new jz36();
        Node head = o.treeToDoublyList(root);
        System.out.println("finished");
    }
}
