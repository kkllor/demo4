package com.arithmetic;

/**
 * @author kkllor
 * @date 2020/12/6 8:55 PM
 */
public class PalindromicStr {

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>();
        node1.value = 1;
        Node<Integer> node2 = new Node<>();
        node2.value = 2;
        Node<Integer> node3 = new Node<>();
        node3.value = 3;
        Node<Integer> node4 = new Node<>();
        node4.value = 4;

        Node<Integer> node4_1 = new Node<>();
        node4_1.value = 4;

        Node<Integer> node3_1 = new Node<>();
        node3_1.value = 3;
        Node<Integer> node2_1 = new Node<>();
        node2_1.value = 2;
        Node<Integer> node1_1 = new Node<>();
        node1_1.value = 1;

        node1.next = node1_1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node4_1;
//        node4_1.next = node3_1;
//        node3_1.next = node2_1;
//        node2_1.next = node1_1;

        System.out.println(isPalindromic(node1));

    }

    private static boolean isPalindromic(Node<Integer> rootNode) {

        Node<Integer> fastNode = rootNode;
        Node<Integer> node = rootNode;
        Node<Integer> preNode = null;
        Node<Integer> returnNode = null;
        boolean isOdd = false;
        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            Node<Integer> nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        if (fastNode.next == null) {
            isOdd = true;
        }

        if (isOdd) {
            if (preNode == null) {
                return true;
            }
            node = node.next;
            returnNode = preNode;
        } else {
            Node<Integer> nextNode = node.next;
            returnNode = node;
            returnNode.next = preNode;
            node = nextNode;
        }

        while (node != null) {
            if (returnNode == null) {
                return false;
            }
            if (!node.value.equals(returnNode.value)) {
                return false;
            }

            returnNode = returnNode.next;
            node = node.next;
        }
        return true;
    }

    // 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1

    // 1<-2<-3<-4

    // 1 -> 2 -> 3 -> 4 -> 4 -> 3 -> 2 -> 1


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
