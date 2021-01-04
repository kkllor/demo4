package com.arithmetic;

/**
 * @author kkllor
 * @date 2020/12/6 8:16 PM
 */
public class ReverseLink {
    public static void main(String[] args) {
        Node<Integer> rootNode = null;
        Node<Integer> node, preNode = null;
        for (int i = 0; i < 10; i++) {
            node = new Node<>();
            node.value = i;
            if (preNode != null) {
                preNode.next = node;
            } else {
                rootNode = node;
            }
            preNode = node;
        }
        node = rootNode;
        printNode(node);
        reverseNode(rootNode);
    }

    private static void printNode(Node<Integer> root) {
        Node<Integer> node = root;
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node);
            node = node.next;
        }
        System.out.println(stringBuilder);
    }


    private static void reverseNode(Node<Integer> rootNode) {

        Node<Integer> reverseRoot = rootNode;
        while (reverseRoot.next != null) {
            reverseRoot = reverseRoot.next;
        }
        travels(rootNode);
        printNode(reverseRoot);

//        reverseNode1(rootNode);
//        printNode(reverseRoot);
    }

    private static void reverseNode1(Node<Integer> rootNode) {
        Node<Integer> node = rootNode, preNode = null;
        while (node != null) {
            Node<Integer> next = node.next;
            node.next = preNode;
            preNode = node;
            node = next;
        }
    }


    private static void travels(Node<Integer> node) {
        if (node.next == null) {
            return;
        }
        travels(node.next);
        node.next.next = node;
        node.next = null;
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

}
