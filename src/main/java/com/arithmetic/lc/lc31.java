package com.arithmetic.lc;

import java.util.Arrays;

/**
 * @author kkllor
 * @date 2022/7/3 5:09 PM
 */
public class lc31 {
    public static void main(String[] args) {
        try {
            int[] nums = new int[]{1};
            new lc31().nextPermutation(nums);

            System.out.println(Arrays.toString(nums));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*

    1,2,3,6,8,7,5,4

    1,2,3,7,8,6,5,4

    1,2,3,7,4,5,6,8

    1,2,3,7,4,5,8,6




     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }
        if (i == 0) {
            reverse(nums, 0);
            return;
        }
        int j = nums.length - 1;
        for (; j > i - 1; j--) {
            if (nums[j] > nums[i - 1]) {
                break;
            }
        }
        swap(nums, i - 1, j);
        reverse(nums, i);
    }

    public void reverse(int[] nums, int from) {
        int i = from;
        int j = nums.length - 1;
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
