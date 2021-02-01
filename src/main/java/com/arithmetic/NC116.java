package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/25 4:44 PM
 */
public class NC116 {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);


//        node.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode tmp;
        System.out.println(tmp = new NC116().removeNthFromEnd(node, 1));
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        1->2->3->4->5, n= 2.
//        1->2->3->5
        // write code here

        if (n <= 0) {
            return head;
        }

        ListNode preSlow = null;
        ListNode slow = head;
        ListNode fast = head;
        while (n > 1) {
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (preSlow != null) {
            preSlow.next = slow.next;
            slow.next = null;
        } else {
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
        return head;
    }
}
