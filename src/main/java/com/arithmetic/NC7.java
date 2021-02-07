package com.arithmetic;

/**
 * @author kkllor
 * @date 2021/2/5 9:19 PM
 */
public class NC7 {
    public int maxProfit(int[] prices) {
        // write code here
        if (prices.length == 1) {
            return 0;
        }
        int lastMin = 0;
        int max = 0;
        int currentMax;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[lastMin] > 0) {
                currentMax = prices[i] - prices[lastMin];
            } else {
                currentMax = 0;
                lastMin = i;
            }
            max = max > currentMax ? max : currentMax;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new NC7().maxProfit(new int[]{3,67,63,2,178}));
    }
}
