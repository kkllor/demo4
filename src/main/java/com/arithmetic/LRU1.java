package com.arithmetic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author kkllor
 * @date 2021/1/21 3:48 PM
 */


public class LRU1 {

    public static void main(String args[]) {

        int[][] operators = new int[6][];
        operators[0] = new int[]{1, 1, 1};
        operators[1] = new int[]{1, 2, 2};
        operators[2] = new int[]{1, 3, 2};
        operators[3] = new int[]{2, 1};
        operators[4] = new int[]{1, 4, 4};
        operators[5] = new int[]{2, 2};

        System.out.println(Arrays.toString(new LRU1().LRU(operators, 3)));

    }

//[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
//[1,-1]

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        Node root = new Node(Integer.MAX_VALUE, -1);
        HashMap<Integer, Node> map = new HashMap<>();
        int nodeCount = 0;
        int count = 0;
        for (int[] arr : operators) {
            if (arr[0] == 2) {
                count++;
            }
        }

        int[] result = new int[count];
// MAX-1-2-3
        int index = 0;
        for (int[] arr : operators) {
            Node node;
            if (arr[0] == 1) {
                //已经包含这个key
                if ((node = map.get(arr[1])) != null) {
                    node.value = arr[2];
                    //先删除
                    delete(node);
                    //插到头节点
                    insertHead(root, node);
                } else {
                    if (nodeCount >= k) {
                        Node deleteNode = deleteLast(root);
                        map.remove(deleteNode.key);
                        nodeCount--;
                    }
                    node = new Node(arr[1], arr[2]);
                    insertHead(root, node);
                    map.put(arr[1], node);
                    nodeCount++;
                }
            } else {
                if ((node = map.get(arr[1])) != null) {
                    //先删除
                    delete(node);
                    //插到头节点
                    insertHead(root, node);
                    result[index++] = node.value;
                } else {
                    result[index++] = -1;
                }

            }
        }


        return result;
    }

    private Node deleteLast(Node root) {
        Node node = root.next;
        while (node.next != null) {
            node = node.next;
        }
        delete(node);
        return node;
    }

    private void delete(Node current) {
        Node next = current.next;
        if (next != null) {
            current.pre.next = next;
            next.pre = current.pre;
            current.pre = null;
            current.next = null;
        } else {
            current.pre.next = null;
            current.pre = null;
        }
    }

    private void insertHead(Node root, Node current) {
        Node tmp = root.next;
        if (tmp != null) {
            root.next = current;
            current.pre = root;
            current.next = tmp;
            tmp.pre = current;
        } else {
            root.next = current;
            current.pre = root;
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
