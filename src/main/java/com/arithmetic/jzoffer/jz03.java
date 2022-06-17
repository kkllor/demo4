package com.arithmetic.jzoffer;

import java.util.HashMap;
/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 0 1 2 2 3 3 5
// 0 1 2 3 4 5 6

/**
 * @author kkllor
 * @date 2022/6/17 11:22 AM
 */
//https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
public class jz03 {
    public static void main(String[] args) {
        try {
            int[] input = new int[]{2, 3, 1, 0, 2, 5, 3};
            int result = new jz03().findRepeatNumber1(input);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                return nums[i];
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        return -1;
    }

    //2, 3, 1, 0, 2, 5, 3
    //1, 3, 2, 0, 2, 5, 3
    //3, 1, 2, 0, 2, 5, 3
    //0, 1, 2, 3, 2, 5, 3

    //9,8,7,6,5,4,4,2,1,0
    //0,8,7,6,5,4,4,2,1,9
    //0,1,2,4,5,4,6,7,8,9

    public int findRepeatNumber1(int[] nums) {
        for (int index = 0; index < nums.length; ) {
            int num = nums[index];
            if (num != index) {
                if (num == nums[num]) {
                    return num;
                } else {
                    nums[index] = nums[num];
                    nums[num] = num;
                }
            } else {
                index++;
            }
        }
        return -1;
    }
}
