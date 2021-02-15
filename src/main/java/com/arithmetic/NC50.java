package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/14 9:50 PM
 */
public class NC50 {

    public static class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (head == null || k == 0 || k == 1) {
            return head;
        }
        //是否有k个元素
        int count = 0;
        ListNode node = head;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        //满足k个元素
        if (count == k) {
            count = 0;
            node = head;
            ListNode pre = null;
            while (count < k) {
                ListNode next = node.next;
                node.next = pre;
                pre = node;
                node = next;
                count++;
            }
            head.next = reverseKGroup(node, k);
            return pre;

        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        ListNode listNode2 = new ListNode();
        listNode2.val = 2;
        ListNode listNode3 = new ListNode();
        listNode3.val = 3;
        ListNode listNode4 = new ListNode();
        listNode4.val = 4;
        ListNode listNode5 = new ListNode();
        listNode5.val = 5;

        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ListNode result = new NC50().reverseKGroup(listNode1, 4);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
