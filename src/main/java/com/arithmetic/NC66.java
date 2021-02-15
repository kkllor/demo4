package com.arithmetic;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author kkllor
 * @date 2021/2/14 10:24 PM
 */
public class NC66 {
    public static void main(String[] args) {

    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<Integer> set = new HashSet<>();
        while (pHead2 != null) {
            set.add(pHead2.val);
            pHead2 = pHead2.next;
        }
        while (pHead1 != null) {
            if (set.contains(pHead1.val)) {
                return pHead1;
            }
            pHead1 = pHead1.next;
        }
        return null;
    }
}
