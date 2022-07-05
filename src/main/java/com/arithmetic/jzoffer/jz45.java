package com.arithmetic.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author kkllor
 * @date 2022/7/5 9:28 PM
 */
public class jz45 {
    public static void main(String[] args) {
        try {
            System.out.println(new jz45().minNumber(new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*

    [3,30,34,5,9]
    3 30
    30 3

    3>30
    9>5>34>3>30
    3 34
    34 3

    3033459
     */

    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        StringBuilder stringBuilder = new StringBuilder();
        for (int n : nums) {
            stringBuilder.append(n);
        }
        return stringBuilder.toString();
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(nums, start, end);
        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);
    }


    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int index = start;
        for (int i = start; i < end; i++) {
            if (compare(nums[i], pivot) == -1) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, end);
        return index;
    }

    private void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    private int compare(int a, int b) {
        if (a == b) {
            return 0;
        }
        int[] arrayA = toArray(a);
        int[] arrayB = toArray(b);

        int count = arrayA.length + arrayB.length;
        for (int i = 0; i < count; i++) {
            int valueA;
            if (i < arrayA.length) {
                valueA = arrayA[i];
            } else {
                valueA = arrayB[i - arrayA.length];
            }
            int valueB;
            if (i < arrayB.length) {
                valueB = arrayB[i];
            } else {
                valueB = arrayA[i - arrayB.length];
            }
            if (valueA == valueB) {
                continue;
            }
            return valueA > valueB ? 1 : -1;
        }
        return 0;
    }


    private int[] toArray(int a) {
        List<Integer> list = new ArrayList<>();
        if (a == 0) {
            list.add(a);
        }
        while (a != 0) {
            list.add(0, a % 10);
            a /= 10;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
