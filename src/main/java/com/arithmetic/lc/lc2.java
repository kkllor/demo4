package com.arithmetic.lc;

import com.arithmetic.lc.structure.ListNode;

/**
 * @author kkllor
 * @date 2021/3/5 3:15 下午
 */
public class lc2 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[]{1});
        ListNode l2 = ListNode.build(new int[]{9, 9, 9, 9, 9});
        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode result = null, listNode = null;
            while (l1 != null || l2 != null) {
                int total = carry;
                if (l1 != null) {
                    total += l1.val;
                }
                if (l2 != null) {
                    total += l2.val;
                }
                carry = total / 10;
                ListNode node = new ListNode(total % 10);
                if (result == null) {
                    result = node;
                    listNode = node;
                } else {
                    listNode.next = node;
                    listNode = listNode.next;
                }
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry != 0) {
                listNode.next = new ListNode(carry);
            }
            return result;
        }
    }
}
