package com.arithmetic.jzoffer;

import com.arithmetic.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author kkllor
 * @date 2022/6/18 9:20 AM
 */
public class jz06 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(reversePrint1(ListNode.from(new int[]{1, 2, 3}))));
        System.out.println(reverseNode2(ListNode.from(new int[]{1, 2, 3})));
    }

    public static int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next;
        int count = 0;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
            count++;
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = pre.val;
            pre = pre.next;
        }
        return result;
    }

    public static int[] reversePrint1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        head = reverseNode1(head);
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    public static ListNode reverseNode1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return head;
        }
        head = stack.pop();
        ListNode tmp = head;
        while (!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        tmp.next = null;
        return head;
    }


//1->2->3->4->5
    public static ListNode reverseNode2(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode node = reverseNode2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
