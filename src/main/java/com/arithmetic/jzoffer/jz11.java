package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/6/20 10:50 PM
 */
public class jz11 {
    //https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
    // 3,4,5,1,2
    //6,7,8,9,1,2,3,4,5
    //2,2,2,1,2,2,2
    public static void main(String[] args) {
        try {
            System.out.println(minArray(new int[]{}));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static int minArray(int[] numbers) {
        return minArray(numbers, 0, numbers.length - 1);
    }

    public static int minArray(int[] numbers, int start, int end) {
        if (start == end) {
            return numbers[start];
        }
        int mid = (start + end) / 2;
        if (numbers[start] >= numbers[end]) {
            if (numbers[start] > numbers[mid]) {
                return minArray(numbers, start, mid);
            } else if (numbers[start] < numbers[mid]) {
                return minArray(numbers, mid + 1, end);
            } else {
                return minArray(numbers, start + 1, end);
            }
        } else {
            return numbers[start];
        }
    }
}
