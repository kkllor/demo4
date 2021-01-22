package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/22 1:19 PM
 */
public class NC112 {
    public static void main(String[] args) {
        System.out.println(new NC112().solve(-4, 3));
    }
    /**
     * 112
     *
     * 112 / 10 = 12  1
     *
     * 12 /10 = 1 2
     *
     * 2/10 = 0  2
     *
     * 223
     *
     *223 /10 = 22 ..3
     *
     * 22/10 = 2 ..2
     *
     * 2/10
     *
     */

    /**
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */

//    private static final String ONE
    public String solve(int M, int N) {
        // write code here
        StringBuilder stringBuilder = new StringBuilder();
        boolean isNegative = false;
        if (M < 0) {
            isNegative = true;
            M = -M;
        }
        while (M > 0) {
            stringBuilder.insert(0, convert(M % N));
            M = M / N;
        }
        if (isNegative) {
            stringBuilder.insert(0, "-");
        }
        return stringBuilder.toString();
    }

    private String convert(int m) {
        if (m <= 9) {
            return m + "";
        }
        if (m == 10) {
            return "A";
        }
        if (m == 11) {
            return "B";
        }
        if (m == 12) {
            return "C";
        }
        if (m == 13) {
            return "D";
        }
        if (m == 14) {
            return "E";
        }
        if (m == 15) {
            return "F";
        }
        return m + "";
    }

}
