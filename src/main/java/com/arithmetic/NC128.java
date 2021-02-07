package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/7 1:24 PM
 */
public class NC128 {
    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater(int[] arr) {
        // write code here
        if (arr.length < 3) {
            return -1;
        }

        int i = 0;
        int j = arr.length - 1;
        int left = arr[0];
        int right = arr[arr.length - 1];
        long res = 0;
        while (i < j) {
            if (left > right) {
                j--;
                if (arr[j] > right) {
                    right = arr[j];
                    continue;
                }
                res += (right - arr[j]);
            } else {
                i++;
                if (arr[i] > left) {
                    left = arr[i];
                    continue;
                }
                res += (left - arr[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2, 5/*, 2, 4*/};
        System.out.println(new NC128().maxWater(array));

    }
}
