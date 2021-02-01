package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kkllor
 * @date 2021/1/30 10:10 PM
 */
public class NC19 {

    /**
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        // write code here
        int max = 0;
        int currentMax = 0;
        for (int i = 0; i < arr.length; i++) {
            currentMax = Math.max(currentMax + arr[i], arr[i]);
            if (currentMax > max) {
                max = currentMax;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new NC19().maxsumofSubarray(new int[]{1, -2, 3, 5, -2, 6, -1}));
    }
}
