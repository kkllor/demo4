package com.arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kkllor
 * @date 2021/2/17 6:00 下午
 */
public class NC61 {
//    给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
//    你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
//            假设给出的数组中只存在唯一解
//    例如：
//    给出的数组为 {20, 70, 110, 150},目标值为90
//    输出 index1=1, index2=2

    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
            map.put(numbers[index], index);
        }
        for (int i = 0; i < numbers.length; i++) {
            int n = target - numbers[i];
            Integer index = map.get(n);
            if (index != null && index != i) {
                result[0] = (index > i ? i : index) + 1;
                result[1] = (index > i ? index : i) + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 70, 110, 150};
        System.out.println(Arrays.toString(new NC61().twoSum(array, 0)));
    }
}
