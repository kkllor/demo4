package com.arithmetic.lc.structure;

/**
 * @author kkllor
 * @date 2021/3/5 3:17 下午
 */
public class ListNode {
   public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            stringBuilder.append(node.val);
            if (node.next != null) {
                stringBuilder.append("->");
            }
            node = node.next;
        }
        return stringBuilder.toString();
    }

    public static ListNode build(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode listNode = new ListNode(array[0]);
        ListNode result = listNode;
        for (int i = 1; i < array.length; i++) {
            listNode.next = new ListNode(array[i]);
            listNode = listNode.next;
        }
        return result;
    }
}
