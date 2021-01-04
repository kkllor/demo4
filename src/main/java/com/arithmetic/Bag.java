package com.arithmetic;

/**
 * @author kkllor
 * @date 2020/12/27 4:50 PM
 */
public class Bag {

    static int[] ITEMS = new int[]{3, 78, 4, 1, 2, 6, 14, 12, 3, 1, 5, 16, 23, 45, 2, 3, 4};
    static final int BAG_CAPICITY = 65;
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
        if (index == ITEMS.length - 1 || currentWeight >= BAG_CAPICITY) {
            result = Math.max(result, currentWeight);
            return;
        }

        //index+1 不放
        solution(currentWeight, index + 1);
        if (currentWeight + ITEMS[index] == BAG_CAPICITY) {
            findPerfect = true;
            result = currentWeight + ITEMS[index];
            return;
        }
        if (currentWeight + ITEMS[index + 1] < BAG_CAPICITY) {
            //index+1 放
            solution(currentWeight + ITEMS[index + 1], index + 1);
        }
    }


}
