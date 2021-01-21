package com.learn;

/**
 * @author kkllor
 * @date 2021/1/21 9:02 AM
 */
public class TestContinuousMaxValue {

    public static void main(String[] args) {
        int[] array = new int[]{-2, 2, 3, -4, 7, 4, -1, -2, 1, -2, -3, 12, -2, 1};
        System.out.println(findMax(array));
    }

    public static int findMax(int[] array) {
        int[] index = new int[2];
        int start = 0, end = 0;
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum + array[i] > array[i]) {
                sum += array[i];
                end++;
            } else {
                sum = array[i];
                start = i;
                end = i;
            }
            if (sum > max) {
                max = sum;
                index[0] = start;
                index[1] = end;
            }
        }
        System.out.println("start = " + index[0] + ",end = " + index[1]);
        return max;
    }

}
