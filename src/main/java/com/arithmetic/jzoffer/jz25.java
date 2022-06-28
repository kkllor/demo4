package com.arithmetic.jzoffer;

import com.arithmetic.entity.ListNode;

/**
 * @author kkllor
 * @date 2022/6/28 8:59 PM
 */
/*
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class jz25 {
    public static void main(String[] args) {
        System.out.println(new jz25().mergeTwoLists(ListNode.from(new int[]{1}), ListNode.from(new int[]{1})));

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(Integer.MAX_VALUE);
        mergeTwoLists(l1, l2, node);
        return node.next;
    }

    public void mergeTwoLists(ListNode l1, ListNode l2, ListNode preNode) {
        if (l1 == null && l2 == null) {
            return;
        }
        ListNode node = null;
        if (l1 == null) {
            node = l2;
        }
        if (l2 == null) {
            node = l1;
        }
        if (node != null) {
            preNode.next = node;
            return;
        }

        if (l1.val >= l2.val) {
            preNode.next = l2;
            l2 = l2.next;
        } else {
            preNode.next = l1;
            l1 = l1.next;
        }
        mergeTwoLists(l1, l2, preNode.next);
    }
}
