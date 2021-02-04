package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/1 3:17 PM
 */
public class NC108 {

    /**
     * 最大正方形
     *
     * @param matrix char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] matrix) {
        // write code here
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (matrix[i][k] == 0) {
                        continue;
                    }
                    if (k - j <= max) {
                        continue;
                    }
                    int distance = k - j;
                    //判断是否能够组成一个正方形
                    if (i - distance >= 0 && matrix[i - distance][j] == 1 && matrix[i - distance][k] == 1) {
                        max = distance;
                    }
                }
            }
        }
        return max * max;
    }
//
//            [1,0,1,0,0]
//            [1,0,1,1,1]
//            [1,1,1,1,1]
//            [1,0,0,1,0]

    public static void main(String[] args) {
//        char[][] array = new char[][]{
//                {1, 0, 1, 1, 1, 1, 1, 0, 0, 0},
//                {1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
//                {1, 0, 1, 0, 1, 1, 1, 0, 0, 0},
//                {1, 1, 0, 1, 1, 1, 1, 0, 1, 0},
//                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
//                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
//                {1, 0, 1, 1, 0, 1, 1, 0, 0, 0}};
//        System.out.println(new NC108().solve(array));
        char c = 0;
        System.out.println(c==0);

    }
}
