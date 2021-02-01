package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/27 8:20 AM
 */
public class MergeListNodes {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        ListNode n7 = new ListNode(7);
        n1.next = n3;
        n3.next = n5;
        n5.next = n7;
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        n2.next = n4;
        printListNode(merge2(n1, n2));

    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode merge1(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode tmp = result;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                result.next = node2;
                node2 = node2.next;
            } else {
                result.next = node1;
                node1 = node1.next;
            }
            result = result.next;
        }
        result.next = node1 == null ? node2 : node1;
        return tmp.next;
    }

    public static ListNode merge2(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.val <= n2.val) {
            n1.next = merge2(n1.next, n2);
            return n1;
        } else {
            n2.next = merge2(n1, n2.next);
            return n2;
        }
    }

}
