package com.arithmetic;

import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/2/10 10:05 AM
 */
public class NC40 {

    public static class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        Stack<ListNode> stack1 = toStack(head1);
        Stack<ListNode> stack2 = toStack(head2);
        int k = 0;
        ListNode node = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = 0;
            if (!stack1.isEmpty()) {
                val1 = stack1.pop().val;
            }

            int val2 = 0;
            if (!stack2.isEmpty()) {
                val2 = stack2.pop().val;
            }

            int total = val1 + val2 + k;
            k = total / 10;
            int value = total % 10;
            ListNode oldNode = node;
            node = new ListNode();
            node.val = value;
            node.next = oldNode;
        }
        if (k > 0) {
            ListNode oldNode = node;
            node = new ListNode();
            node.val = k;
            node.next = oldNode;
        }
        return node;
    }

    private Stack<ListNode> toStack(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        return stack;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.val = 9;
        ListNode listNode2 = new ListNode();
        listNode2.val = 3;
        ListNode listNode3 = new ListNode();
        listNode3.val = 7;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode();
        listNode4.val = 9;
        ListNode listNode5 = new ListNode();
        listNode5.val = 9;
        ListNode listNode6 = new ListNode();
        listNode6.val = 9;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = new NC40().addInList(listNode1, listNode4);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}
