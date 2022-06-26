package com.arithmetic.jzoffer;

import com.arithmetic.entity.ListNode;

/**
 * @author kkllor
 * @date 2022/6/26 7:17 PM
 */
/*
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 

说明：

题目保证链表中节点的值互不相同

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class jz18 {
    public static void main(String[] args) {
        System.out.println(new jz18().deleteNode(ListNode.from(new int[]{1}), 1));
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            if (cur.val == val) {
                if (pre == null) {
                    head = next;
                } else {
                    pre.next = next;
                }
                cur.next = null;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

}
