package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/6/25 3:31 PM
 */
public class jz13 {
    //    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//             
//
//    示例 1：
//
//    输入：m = 2, n = 3, k = 1
//    输出：3
//    示例 2：
//
//    输入：m = 3, n = 1, k = 0
//    输出：1
//    提示：
//
//            1 <= n,m <= 100
//            0 <= k <= 20
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        try {
            jz13 o = new jz13();
            int m = 3;
            int n = 1;
            int k = 0;
            int count = o.movingCount(m, n, k);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    stringBuilder.append(o.mark[i][j] + "  ");
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder);
            System.out.println("--------------------------");
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*

     *  *  *  *  *  *  *  *  *  *  *  *  *
     *  *  *  *  *  *  *  *  *  *  *  *  *
     *  *  *  *  *  *  *  *  *  *  *  *  *
     *  *  *  *  *  *  *  *  *  *  *  *  *
     */

    /*
    * * *
    * * *

   m = 4
   n = 13
   k = 14
     */

    private int[][] mark;
    private int count;

    public int movingCount(int m, int n, int k) {
        mark = new int[m][n];
        movingCount(m, n, k, 0, 0);
        return count;
    }

    public void movingCount(int m, int n, int k, int x, int y) {
//        try {
//            printMark(x, y);
//            Thread.sleep(500);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("current (" + x + "," + y + ")");
        if (x < 0 || x >= m || y < 0 || y >= n || (sum(x) + sum(y)) > k || mark[x][y] == 1) {
//            System.out.println("current (" + x + "," + y + ") not satisfied!");
            return;
        }
        if (mark[x][y] != 1) {
            mark[x][y] = 1;
            count++;
        }
        movingCount(m, n, k, x, y + 1);
        movingCount(m, n, k, x + 1, y);
    }

    public int sum(int k) {
        int sum = 0;
        sum += k % 10;
        while (k / 10 > 0) {
            k /= 10;
            sum += k % 10;
        }
        return sum;
    }

    public void printMark(int x, int y) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (i == x && j == y) {
                    stringBuilder.append("*  ");
                } else {
                    stringBuilder.append(mark[i][j] + "  ");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

}
