package com.arithmetic;

/**
 * @author kkllor
 * @date 2020/12/6 8:55 PM
 */
public class PalindromicStr {

    private static boolean isPalindromic(Node<Integer> rootNode) {
        Node<Integer> node = rootNode, nextNode = null, returnNode = null, fastNode = rootNode;
        boolean isOdd;
        while (node != null) {
            if ((isOdd = fastNode.next == null) || fastNode.next.next == null) {
                //慢指针到达中点，往回走
                if (returnNode == null) {
                    returnNode = node;
                }
                returnNode = returnNode.next;
                if (!isOdd) {
                    node = node.next;
                }
                if (!returnNode.value.equals(node.value)) {
                    return false;
                }

            } else {
                fastNode = fastNode.next.next;
            }
            Node<Integer> tmp = node;
            node = node.next;
            nextNode = node.next;

            node.next = tmp;
            tmp.next = null;
        }

        return true;
    }

    // 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1

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
