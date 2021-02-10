package com.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kkllor
 * @date 2021/2/10 9:44 AM
 */
public class NC73 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(new NC73().MoreThanHalfNum_Solution(array));
    }


    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int halfCount = array.length / 2;

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            Integer iCount = map.get(value);
            int count = iCount == null ? 0 : iCount;
            count++;
            if (count > halfCount) {
                return value;
            }
            map.put(value, count);
        }
        return 0;
    }
}
