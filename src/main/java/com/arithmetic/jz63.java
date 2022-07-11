package com.arithmetic;

/**
 * @author kkllor
 * @date 2022/7/10 10:04 AM
 */
public class jz63 {
    public static void main(String[] args) {
        System.out.println(new jz63().maxProfit(new int[]{7,6,4,3,1}));
    }


    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice;
        if (prices.length == 0) {
            return max;
        }
        minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }

            if (prices[i] - minPrice > max) {
                max = prices[i] - minPrice;
            }
        }
        return max;
    }
}
