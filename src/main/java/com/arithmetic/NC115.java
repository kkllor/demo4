package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/25 4:44 PM
 */
public class NC115 {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);


        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(new NC115().hasCycle(node));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next == null) {
                fast = null;
            } else {
                fast = fast.next.next;
            }
        }
        return false;
    }
}
