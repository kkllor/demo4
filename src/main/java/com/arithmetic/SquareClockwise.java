package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/1/19 9:00 AM
 */
public class SquareClockwise {
    public static final int N = 4;

    public static void main(String[] args) {
        int[][] array = new int[N][N];
        int value = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = value++;
            }
        }

        System.out.println("before :");
        print(array);

        System.out.println("after :");
        print(clockWise(array));

    }

    public static int[][] clockWise(int[][] array) {
        int[][] resultArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                resultArray[j][N - 1 - i] = array[i][j];
            }
        }
        return resultArray;
    }

    static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }
}


