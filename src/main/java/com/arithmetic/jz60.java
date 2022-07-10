package com.arithmetic;

import java.util.Arrays;

/**
 * @author kkllor
 * @date 2022/7/9 10:55 AM
 */
public class jz60 {
    public static void main(String[] args) {
        for(int i=1;i<10;i++){
            System.out.println(Arrays.toString(new jz60().dicesProbability(i)));
        }
    }

    private double[] countArray;
    private double factor;
    private int curCount;

    public double[] dicesProbability(int n) {
        countArray = new double[6 * n + 1];
        factor = Math.pow((1 / 6.0), n);
        dfs(n, 0);
        return Arrays.copyOfRange(countArray, n, countArray.length);
    }

    private void dfs(int n, int index) {
        if (index == n) {
            countArray[curCount] += 1;
            return;
        }
        for (int j = 1; j <= 6; j++) {
            curCount += j;
            dfs(n, index + 1);
            curCount -= j;
        }
    }
}
