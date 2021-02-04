package com.arithmetic;

import java.util.Stack;

/**
 * @author kkllor
 * @date 2021/2/4 4:39 PM
 */
public class NC2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //删除N节点
    //N节点插入到头节点后面

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        while (node.next != null) {
            if (!stack.isEmpty()) {
                ListNode listNodeN = stack.pop();
                if (listNodeN == node.next) {
                    return;
                }
                if (!stack.isEmpty()) {
                    ListNode listPre = stack.peek();
                    listPre.next = null;
                }
                ListNode nodeTmp = node.next;
                node.next = listNodeN;
                listNodeN.next = nodeTmp;
                node = nodeTmp;
            }
        }
    }

    public static ListNode createByArray(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode node = head;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head;
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = createByArray(new int[]{1, 2, 3, 4, 5, 3, 6, 7});
        new NC2().reorderList(listNode);
        printListNode(listNode);
        // 1 5 2 4 3
        //
        //1 6 2 5 3 4
    }
}
