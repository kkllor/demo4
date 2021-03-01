package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/22 4:01 下午
 */
public class TestHeap {
    //index从1开始
    //[2,5,12,7,18,22,16,4,6,17,3,21]
    //1，2，3，4，5，6，7，8

    private void upToDownHeapized(int[] array, int i, int count) {
        while (true) {
            //左边比parent大
            int maxPos = i;
            if (i * 2 <= count && array[i * 2] > array[i]) {
                maxPos = i * 2;
            }
            if ((i * 2 + 1) <= count && array[i * 2 + 1] > array[maxPos]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(array, i, maxPos);
            i = maxPos;
        }
    }

    private void buildHeap(int[] array, int n) {
        for (int index = n / 2; index > 0; index--) {
            upToDownHeapized(array, index, n);
        }
    }

    private void swap(int[] array, int from, int to) {
        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    public void sort(int[] array, int n) {
        buildHeap(array, n);
        int count = n;
        while (count > 1) {
            swap(array, 1, count);
            count--;
            //堆化index==1的元素
            upToDownHeapized(array, 1, count);
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{-1, 2, 5, 12, 7, 18, 22, 16, 4, 6, 17, 3, 21};
        new TestHeap().sort(array, 12);
        for (int v : array) {
            System.out.print(v + "->");
        }
    }
}
