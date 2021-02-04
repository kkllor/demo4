package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/1 4:16 PM
 */
public class NC32 {
    public static void main(String[] args) {
        int x = 1433313344;
        System.out.println(Math.sqrt(x));
        System.out.println(new NC32().sqrt(x));
        //1---12
        //
    }

    //


    /**
     * @param x int整型
     * @return int整型
     */
    public int sqrt(int x) {
        // write code here
        if (x == 0) {
            return 0;
        }
        return solution1(1, x, x);
    }

    private int solution1(int start, int end, int target) {

        while (start <= end) {
            long mid = start + (end - start >> 1);
            long currentValue = mid * mid;
            if (currentValue == target) {
                return (int) mid;
            } else if (currentValue > target) {
                end = (int) (mid - 1);
            } else {
                currentValue = (mid + 1) * (mid + 1);
                if (currentValue > target) {
                    return (int) mid;
                }
                start = (int) (mid + 1);
            }
        }
        return -1;
    }
}
