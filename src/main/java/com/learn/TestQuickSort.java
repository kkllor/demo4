package com.learn;

import java.util.Arrays;

/**
 * @author kkllor
 * @date 2021/1/17 8:14 PM
 */
public class TestQuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 7, 1, 8, 9, 2, 6, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int partitionIndex = partition(array, start, end);
        quickSort(array, start, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int target = array[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] < target) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, end);
        return i;
    }

    private static void swap(int[] array, int from, int to) {
        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }
}
