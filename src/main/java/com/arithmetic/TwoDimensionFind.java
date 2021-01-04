package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/4 3:19 PM
 */
public class TwoDimensionFind {
    private static final int M = 14;
    private static final int N = 15;

    public static void main(String[] args) {
        int[][] array = new int[M][N];
        int v = 119;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = v++;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        find(257, array);
    }

    public static void find(int target, int[][] array) {
        int row = 0;
        int col = N - 1;
        while (row < M && col >= 0) {
            if (array[row][col] == target) {
                System.out.println(row + "," + col);
                return;
            } else if (array[row][col] < target) {
                row++;
            } else if (array[row][col] > target) {
                col--;
            }
        }
        System.out.println("could not found!");
    }


}
