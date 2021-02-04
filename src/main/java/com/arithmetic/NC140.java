package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/4 4:22 PM
 */
public class NC140 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        // write code here
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(arr, start, end);
        sort(arr, start, partition - 1);
        sort(arr, partition + 1, end);
    }

    /***
     *
     * @param arr
     * @param start
     * @param end
     * @return
     *
     *
     *
     */
    private int partition(int[] arr, int start, int end) {
        int target = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < target) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    private void swap(int[] array, int from, int to) {
        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }
}
