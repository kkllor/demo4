package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/6/26 8:54 AM
 */
/*
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/jian-sheng-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

3 = 1 + 2 , 1 x 2 = 2
4 = 2 + 2 , 2*2 = 4
5 = 2 + 3 , 2 * 3 = 6
6 = 3 + 3 , 3 * 3 = 9
7 = 3 + 4 , 3 * 4 = 12
8 =
11 =

 */
public class jz14 {
    public static void main(String[] args) {
        try {
            System.out.println(new jz14().cuttingRope(8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int cuttingRope(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int m = Math.max(Math.max(j * (i - j), j * result[i - j]), Math.max(j * (i - j), result[j] * result[i - j]));
                result[i] = Math.max(m, result[i]);
            }

        }
        return result[n];
    }
}
