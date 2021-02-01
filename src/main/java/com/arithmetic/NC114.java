package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/25 4:31 PM
 */
public class NC114 {

    public static void main(String[] args) {
        System.out.println(new NC114().JumpFloor(4));
    }

    public int JumpFloor(int target) {
        int[] array = new int[target + 1];
        array[0] = 0;
        if (target >= 1) {
            array[1] = 1;
        }
        if (target >= 2) {
            array[2] = 2;
        }
        for (int i = 3; i < target + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[target];
    }
}
