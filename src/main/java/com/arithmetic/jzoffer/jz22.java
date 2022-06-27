package com.arithmetic.jzoffer;

import com.arithmetic.entity.ListNode;

/**
 * @author kkllor
 * @date 2022/6/27 9:47 PM
 */
public class jz22 {
    public static void main(String[] args) {
        System.out.println(new jz22().getKthFromEnd(ListNode.from(new int[]{1, 2, 3, 4, 5}), 3));
    }

    private int k;
    private ListNode node;

    public ListNode getKthFromEnd(ListNode head, int k) {
        this.k = k;
        reverse(head);
        return node;
    }

    public void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        k--;
        if (k == 0) {
            this.node = head;
        }
    }
}
