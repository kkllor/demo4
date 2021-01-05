package com.arithmetic.jzo;

/**
 * @author kkllor
 * @date 2021/1/4 6:02 PM
 * 翻转数组的最小值
 * {3,4,5,1,2}的最小值为1
 * {7,8,9,1,2,3,4,5,6}
 */

public class jzo08 {

    public static void main(String[] args) {
        int[] array = new int[]/*{9, 1, 2, 3, 4, 5, 6, 7, 8}*/{3, 4, 5, 6, 7, 8, 9, 1, 2};
        /**
         * {3,4,5,6,7,8,9,1,2};
         */
        System.out.println(find(array, 0, array.length - 1));
    }

    public static int find(int[] array, int left, int right) {
        while (right - left > 1) {
            int mid = left + (right - left >> 1);
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                if (mid - 1 >= 0 && array[mid - 1] > array[mid]) {
                    return array[mid];
                }
                right = mid - 1;
            }
        }
        return Math.min(array[left], array[right]);
    }
}
