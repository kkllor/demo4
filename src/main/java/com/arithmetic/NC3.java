package com.arithmetic;

import java.util.List;

/**
 * @author kkllor
 * @date 2021/2/9 5:38 PM
 */
public class NC3 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        ListNode tmp = null;
        int circleCount = 0;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                hasCycle = true;
                tmp = slow;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if (hasCycle) {
            while (true) {
                slow = slow.next;
                circleCount++;
                if (slow == tmp) {
                    break;
                }
            }
            slow = head;
            fast = head;
            while (circleCount > 0) {
                fast = fast.next;
                circleCount--;
            }

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode1;
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
//        ListNode listNode7 = new ListNode(7);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;
//        listNode7.next = listNode3;
        ListNode listNode = new NC3().detectCycle(listNode1);
        System.out.println(listNode == null ? null : listNode.val);


    }
}
