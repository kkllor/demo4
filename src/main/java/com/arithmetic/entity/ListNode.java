package com.arithmetic.entity;

/**
 * @author kkllor
 * @date 2022/6/18 9:20 AM
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode from(int[] array) {
        if (array.length == 0) {
            return null;
        }

        ListNode head = new ListNode(array[0]);
        ListNode tmp = head;
        for (int i = 1; i < array.length; i++) {
            tmp.next = new ListNode(array[i]);
            tmp = tmp.next;
        }
        return head;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            stringBuilder.append(node.val);
            stringBuilder.append("-");
            node = node.next;
        }
        return stringBuilder.toString();

    }
}


