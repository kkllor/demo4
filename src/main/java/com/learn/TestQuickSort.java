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
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int index = start;
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, index, end);
        return index;
    }

    private static void swap(int[] array, int from, int to) {
        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }
}
