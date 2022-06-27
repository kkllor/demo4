package com.arithmetic.jzoffer;

import java.util.Arrays;

/**
 * @author kkllor
 * @date 2022/6/27 9:37 PM
 */
public class jz21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new jz21().exchange(new int[]{2})));
    }

    public int[] exchange(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                exchange(nums, i, index);
                index++;
            }
        }
        return nums;
    }

    public void exchange(int[] nums, int from, int to) {
        if (from == to) {
            return;
        }
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
