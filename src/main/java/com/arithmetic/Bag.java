package com.arithmetic;

/**
 * @author kkllor
 * @date 2020/12/27 4:50 PM
 */
public class Bag {

    static int[] ITEMS = new int[]{3, 78, 14, 12, 3, 1, 5};
    static final int BAG_CAPICITY = 89;
    static int result = -1;
    static boolean findPerfect = false;

    public static void main(String[] args) {
        solution(0, 0);
        System.out.println(result);
    }

    public static void solution(int currentWeight, int index) {
        if (findPerfect) {
            return;
        }
        if (currentWeight > BAG_CAPICITY) {
            return;
        }
        result = Math.max(result, currentWeight);
        if (result == BAG_CAPICITY) {
            findPerfect = true;
            return;
        }
        if (index == ITEMS.length - 1) {
            return;
        }
        //index+1 不放
        solution(currentWeight, index + 1);
        //index+1 放
        solution(currentWeight + ITEMS[index + 1], index + 1);
    }
}
