package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/7 2:53 PM
 */
public class NC41 {


    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 1, 3, 4};
        System.out.println(new NC41().maxLength(array));
    }

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        if (arr.length == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        int maxLength = 1;
        while (j < arr.length) {
            int start;
            if ((start = contains(arr, i, j - 1, arr[j])) != -1) {
                maxLength = Math.max(j - i, maxLength);
                i = start + 1;
            }
            j++;
        }
        maxLength = Math.max(j - i, maxLength);
        return maxLength;
    }

    private int contains(int[] arr, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
