package com.arithmetic.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kkllor
 * @date 2022/6/29 7:47 PM
 */
public class jz29 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new jz29().clockPrint(new int[][]{{},
        })));
    }


    /*

    array = int[m][n]

    i : 0
    j : 0~n-1

    i : 1~m-1
    j : n-1

    i : m~1
    j : n-2 ~ 0

    i: m-2 ~ 1
    j: 0

    i: 1
    j: 1~n-2

    i : 2 ~ m-2
    j : n-2





     */

    public int[] clockPrint(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        if (matrix[0].length == 0) {
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int index = 0;
        int count = 0;
        while ((count <= m - 1 - count) && (count <= n - 1 - count)) {
            for (int j = count; j <= n - 1 - count; j++) {
                result[index++] = matrix[count][j];
            }

            for (int i = count + 1; i <= m - 1 - count; i++) {
                result[index++] = matrix[i][n - 1 - count];
            }

            for (int j = n - 2 - count; j >= count && m - 1 - count > count; j--) {
                result[index++] = matrix[m - 1 - count][j];
            }

            for (int i = m - 2 - count; i >= 1 + count && n - 1 - count > count; i--) {
                result[index++] = matrix[i][count];
            }
            count++;
        }

        return result;
    }
}
