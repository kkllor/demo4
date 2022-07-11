package com.arithmetic.jzoffer;

import java.util.Arrays;

/**
 * @author kkllor
 * @date 2022/7/10 9:44 AM
 */
public class jz61 {
    public static void main(String[] args) {
        System.out.println(new jz61().isStraight(new int[]{0, 0, 0, 1, 1}));
    }

    /*
    从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

       0,0,0,2,6

       0,0,1,3,7

        0,2,3,4,7
        0,2,3,4,5

        0,0,0,2,5,
     */

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                zeroCount = i;
                break;
            }
        }
        if (zeroCount == 5 || zeroCount == 4) {
            return true;
        }
        int distanceSum = 0;
        for (int i = zeroCount; i < nums.length - 1; i++) {
            int distance = nums[i + 1] - nums[i];
            if (distance == 0) {
                return false;
            }
            if (distance > 1) {
                distanceSum += distance - 1;
            }
        }
        return distanceSum <= zeroCount;
    }
}
