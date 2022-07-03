package com.arithmetic.heap;

import java.util.Arrays;

/**
 * @author kkllor
 * @date 2022/6/30 9:47 AM
 */
public class TestHeap {
    public static void main(String[] args) {
        try {
            int[] array = new int[]{0, 7, 5, 19, 8, 4, 1, 20, 13, 16};
            new TestHeap().heap(array);
            System.out.println(Arrays.toString(array));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 堆化
     *
     * @param array
     */
    public void heap(int[] array) {
        int index = (array.length - 1) / 2;
        for (int i = index; i >= 1; i--) {
            heap(array, i);
        }
    }

    /**
     * 堆化下标 index
     *
     * @param array
     * @param index
     */
    public void heap(int[] array, int index) {
//        while (2 * index < array.length) {
//            int to;
//            if (2 * index + 1 < array.length) {
//                if ((array[index] > array[2 * index]) && (array[index] > array[2 * index + 1])) {
//                    return;
//                }
//                if (array[2 * index] >= array[2 * index + 1]) {
//                    to = 2 * index;
//                } else {
//                    to = 2 * index + 1;
//                }
//            } else {
//                if (array[index] > array[2 * index]) {
//                    return;
//                }
//                to = 2 * index;
//            }
//            swap(array, to, index);
//            index = to;
//        }

        while (true) {
            int maxPos = index;
            if (2 * index < array.length && array[2 * index] > array[index]) {
                maxPos = 2 * index;
            }
            if (2 * index + 1 < array.length && array[2 * index + 1] > array[maxPos]) {
                maxPos = 2 * index + 1;
            }
            if (maxPos == index) {
                return;
            }
            swap(array, maxPos, index);
            index = maxPos;
        }

    }

    public void swap(int[] array, int from, int to) {
        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }
}
