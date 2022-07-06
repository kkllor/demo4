package com.arithmetic.jzoffer;

/**
 * @author kkllor
 * @date 2022/7/6 9:22 PM
 */
public class jz47 {
    public static void main(String[] args) {
        jz47 o  = new jz47();
        System.out.println(o.maxValue(new int[][]{{}}));
    }

    public int maxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) {
                        result[i][j] = grid[i][j];
                    } else {
                        result[i][j] = result[i][j - 1] + grid[i][j];
                    }
                } else {
                    if (j == 0) {
                        result[i][j] = result[i - 1][j] + grid[i][j];
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }
        return result[m - 1][n - 1];
//        int [][] result =
    }
}
