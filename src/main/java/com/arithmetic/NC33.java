package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/17 5:41 下午
 */


public class NC33 {
    public static class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        ListNode node6 = new ListNode();
        node6.val = 6;
        ListNode node8 = new ListNode();
        node8.val = 8;

        node1.next = node2;
        node2.next = node6;
        node6.next = node8;

        ListNode node3 = new ListNode();
        node3.val = 3;
        ListNode node4 = new ListNode();
        node4.val = 4;
        node3.next = node4;

        ListNode node = new NC33().mergeTwoLists(node4, node8);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }
}
